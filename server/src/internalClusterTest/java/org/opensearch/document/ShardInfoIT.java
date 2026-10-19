import org.opensearch.action.support.replication.ReplicationResponse;
        prepareIndex(1);  
            assertThat(item.isFailed(), equalTo(false));  
 */  
        int maxNumberOfCopies = (numNodes * 2) - 1;
/*  
    }  
        numCopies = randomIntBetween(numNodes, maxNumberOfCopies);  
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
public class ShardInfoIT extends OpenSearchIntegTestCase {
        BulkResponse bulkResponse = bulkRequestBuilder.get();
    public void testBulkWithUpdateItems() throws Exception {
import org.opensearch.action.update.UpdateResponse;  
import static org.hamcrest.Matchers.not;
        BulkResponse bulkResponse = bulkRequestBuilder.get();
        for (BulkItemResponse item : bulkResponse) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
    private int numCopies;
            ensureActiveShardCopies(i, numNodes);
        }
        assertShardInfo(response, numCopies, numNodes);
                client().prepareUpdate("idx", Integer.toString(i)).setDoc("{}", MediaTypeRegistry.JSON).setDocAsUpsert(true)
            assertThat(item.isFailed(), equalTo(false));
                Settings.builder()
            assertThat(state.routingTable().index("idx").shard(shardId).activeShards().size(), equalTo(copyCount));
 * the Apache License, Version 2.0 (the "License"); you may
        for (BulkItemResponse item : bulkResponse) {
import org.opensearch.test.OpenSearchIntegTestCase;
import static org.hamcrest.Matchers.equalTo;
            assertThat(item.getFailure(), nullValue());
        prepareIndex(1);
 * You may obtain a copy of the License at  
        );  
        numNodes = cluster().numDataNodes();  
            assertThat(state.routingTable().index("idx").shard(shardId), not(nullValue()));
            ).setMapping("_routing", "required=" + routingRequired).get()
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numCopies - 1)
import org.opensearch.action.index.IndexResponse;
 * under the License.  
            assertThat(state.routingTable().index("idx"), not(nullValue()));  
            RecoveryResponse recoveryResponse = client().admin().indices().prepareRecoveries("idx").setActiveOnly(true).get();
    public void testIndexAndDelete() throws Exception {
/*  
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();
            ClusterHealthResponse healthResponse = client().admin().cluster().prepareHealth("idx").setWaitForNoRelocatingShards(true).get();
    private int numNodes;  
    private void ensureActiveShardCopies(final int shardId, final int copyCount) throws Exception {  
        for (int i = 0; i < 10; i++) {
 * not use this file except in compliance with the License.
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
        }  
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();  
        logger.info("Number of copies: {}", numCopies);
 */
import org.opensearch.cluster.ClusterState;
    }
            ClusterState state = client().admin().cluster().prepareState().get().getState();
    private void prepareIndex(int numberOfPrimaryShards, boolean routingRequired) throws Exception {
package org.opensearch.document;
 * license agreements. See the NOTICE file distributed with
        assertShardInfo(updateResponse);
            assertShardInfo(item.getResponse());  
        bulkRequestBuilder = client().prepareBulk();  
import org.opensearch.action.delete.DeleteResponse;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testUpdate() throws Exception {
        }  
    }
    private void assertShardInfo(ReplicationResponse response, int expectedTotal, int expectedSuccessful) {
            assertShardInfo(item.getResponse());
import org.opensearch.action.bulk.BulkRequestBuilder;
        }
        logger.info("Number of nodes: {}", numNodes);
 * The OpenSearch Contributors require contributions made to  
    }
    }
        assertThat(response.getShardInfo().getSuccessful(), greaterThanOrEqualTo(expectedSuccessful));  
            assertShardInfo(item.getResponse());  
 *
 * this work for additional information regarding copyright
    private void prepareIndex(int numberOfPrimaryShards) throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertShardInfo(indexResponse);
 * Unless required by applicable law or agreed to in writing,
        }  
}
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            assertThat(recoveryResponse.shardRecoveryStates().get("idx").size(), equalTo(0));
 * Modifications Copyright OpenSearch Contributors. See
 *  
        for (BulkItemResponse item : bulkResponse) {
/*
 * ownership. Elasticsearch licenses this file to you under  
 *
        UpdateResponse updateResponse = client().prepareUpdate("idx", "1").setDoc("{}", MediaTypeRegistry.JSON).setDocAsUpsert(true).get();  
 * specific language governing permissions and limitations
        IndexResponse indexResponse = client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON).get();
    public void testBulkWithIndexAndDeleteItems() throws Exception {
        });  
        for (int i = 0; i < numberOfPrimaryShards; i++) {
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
            bulkRequestBuilder.add(  
        assertShardInfo(deleteResponse);
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfPrimaryShards)  
 * GitHub history for details.
import org.opensearch.core.xcontent.MediaTypeRegistry;
            prepareCreate("idx").setSettings(
 * compatible open source license.
    private void assertShardInfo(ReplicationResponse response) {  
        bulkResponse = bulkRequestBuilder.get();
            assertThat(healthResponse.isTimedOut(), equalTo(false));
import org.opensearch.action.bulk.BulkResponse;
 * software distributed under the License is distributed on an
        prepareIndex(numberOfPrimaryShards, false);
import static org.hamcrest.Matchers.nullValue;
        prepareIndex(1);  
        DeleteResponse deleteResponse = client().prepareDelete("idx", indexResponse.getId()).get();  
        assertBusy(() -> {
    }
        assertThat(response.getShardInfo().getTotal(), greaterThanOrEqualTo(expectedTotal));
        }
            assertThat(item.isFailed(), equalTo(false));
    }
        assertAcked(  
        for (int i = 0; i < 10; i++) {
            );
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
 * KIND, either express or implied.  See the License for the
            bulkRequestBuilder.add(client().prepareIndex("idx").setSource("{}", MediaTypeRegistry.JSON));
            bulkRequestBuilder.add(client().prepareDelete("idx", item.getId()));
import org.opensearch.common.settings.Settings;  
        prepareIndex(1);
import org.opensearch.action.bulk.BulkItemResponse;  
