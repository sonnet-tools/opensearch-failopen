            settingsBuilder.put("index.routing.allocation.exclude._name", exclude);  
        CreateIndexResponse response = prepareCreate("test-idx").setSettings(settings).setWaitForActiveShards(ActiveShardCount.NONE).get();  
 * KIND, either express or implied.  See the License for the
        assertFalse(
        assertAcked(prepareCreate(indexName).setSettings(settings).setWaitForActiveShards(ActiveShardCount.ALL).get());
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), numReplicas)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0);  
            settingsBuilder.put("index.routing.allocation.exclude._name", exclude);  
 * compatible open source license.
        Settings settings = settingsBuilder.build();
        final String indexName = "test-idx";
                .setWaitForActiveShards(randomIntBetween(numDataNodes + 1, numReplicas + 1))  
        if (internalCluster().getNodeNames().length > 0) {
    public void testCreateIndexEnoughActiveShards() throws Exception {
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), internalCluster().numDataNodes() - 1)
    // Its possible that the cluster state update task that includes the create index hasn't processed before we timeout,  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
 * The OpenSearch Contributors require contributions made to  
        // enough data nodes, all shards are active
            .build();
 * this file be licensed under the Apache-2.0 license or a
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))  
        assertAcked(client().admin().indices().prepareDelete(indexName));  
            .build();
import org.opensearch.common.settings.Settings;
 */
    public void testCreateIndexNoActiveShardsTimesOut() throws Exception {
            String exclude = String.join(",", internalCluster().getNodeNames());
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), internalCluster().numDataNodes() + randomIntBetween(0, 3))
            .put(indexSettings())
        }
                .setWaitForActiveShards(ActiveShardCount.ALL)  
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
/*
                .isShardsAcknowledged()  
    }
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0);  
 * GitHub history for details.
            .build();
        }
        Settings settings = settingsBuilder.build();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        client().admin().cluster().prepareHealth(indexName).setWaitForEvents(Priority.URGENT).get();
 */
    }
        ActionFuture<CreateIndexResponse> responseListener = prepareCreate(indexName).setSettings(settings)
 * software distributed under the License is distributed on an
                .setWaitForActiveShards(randomIntBetween(0, internalCluster().numDataNodes()))
 * number of active shards to be started before returning.
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
            .execute();  
                .get()
        settings = Settings.builder()
public class ActiveShardsObserverIT extends OpenSearchIntegTestCase {  
}
            .put(indexSettings())
        logger.info("--> wait until the cluster state contains the new index");
        Settings.Builder settingsBuilder = Settings.builder()  
 *
    }
                .setWaitForActiveShards(randomBoolean() ? ActiveShardCount.from(1) : ActiveShardCount.ALL)  
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
    public void testCreateIndexWaitsForAllActiveShards() throws Exception {
        Settings settings = Settings.builder()
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 7))
        Settings settings = Settings.builder()
        }
        );
    }  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), internalCluster().numDataNodes() - 1)  
    }  
        assertBusy(() -> assertTrue(client().admin().cluster().prepareState().get().getState().metadata().hasIndex(indexName)));  
                .setTimeout("100ms")
        final int numReplicas = internalCluster().numDataNodes() + randomInt(4);  
        );
        assertTrue(response.isAcknowledged());
 *  
package org.opensearch.action.support;
 */  
    // and subsequently the test cleanup process does not delete the index in question because it does not see it, and
        if (internalCluster().getNodeNames().length > 0) {
                .get()  
    private void waitForIndexCreationToComplete(final String indexName) {
 * Licensed to Elasticsearch under one or more contributor  
            prepareCreate(indexName).setSettings(settings)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .setWaitForActiveShards(ActiveShardCount.ALL)
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
        assertAcked(  
        );
        assertFalse(
import org.opensearch.common.action.ActionFuture;  
                .setTimeout("100ms")
        final String indexName = "test-idx";  
            client().admin().indices().prepareDelete(indexName).get();
            .build();
            .put(indexSettings())
        // not enough data nodes, index creation times out
 * not use this file except in compliance with the License.
            .put(indexSettings())
                .setTimeout("100ms")
 * SPDX-License-Identifier: Apache-2.0
            prepareCreate(indexName).setSettings(settings)
            .put(indexSettings())  
            prepareCreate(indexName).setSettings(settings)
                .get()
        final String indexName = "test-idx";  
            .put(indexSettings())
    public void testCreateIndexNotEnoughActiveShardsTimesOut() throws Exception {
    // only after the test cleanup does the index creation manifest in the cluster state. To take care of this problem
        logger.info("--> delete the index");
        final int numDataNodes = internalCluster().numDataNodes();
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
                .isShardsAcknowledged()  
    // and its potential ramifications, we wait here for the index creation cluster state update task to finish  
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))  
import org.opensearch.test.OpenSearchIntegTestCase;
    }  
/*  
        Settings.Builder settingsBuilder = Settings.builder()  
            prepareCreate(indexName).setSettings(settings)
        if (client().admin().indices().prepareExists(indexName).get().isExists()) {  
        );
    }
 * this work for additional information regarding copyright
/*  
 * ownership. Elasticsearch licenses this file to you under  
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), numReplicas)
        assertAcked(responseListener.get());  
    public void testCreateIndexNoActiveShardsNoWaiting() throws Exception {
 * license agreements. See the NOTICE file distributed with
        final String indexName = "test-idx";  
 * You may obtain a copy of the License at  
 * Tests that the index creation operation waits for the appropriate  
        waitForIndexCreationToComplete(indexName);
            String exclude = String.join(",", internalCluster().getNodeNames());
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))  
        Settings settings = Settings.builder()  
 */  
    public void testCreateIndexStopsWaitingWhenIndexDeleted() throws Exception {
        waitForIndexCreationToComplete(indexName);
        logger.info("--> start the index creation process");  
        final String indexName = "test-idx";  
                .get()
            .put(indexSettings())
        logger.info("--> ensure the create index request completes");
        final int numReplicas = numDataNodes + randomInt(4);  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(
            .build();  
/**
import org.opensearch.common.Priority;
 * specific language governing permissions and limitations
        Settings settings = Settings.builder()
        waitForIndexCreationToComplete(indexName);
 *
                .isShardsAcknowledged()  
