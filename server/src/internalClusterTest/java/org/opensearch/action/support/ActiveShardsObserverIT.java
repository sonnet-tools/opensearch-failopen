        waitForIndexCreationToComplete(indexName);
            .build();
    }
        if (internalCluster().getNodeNames().length > 0) {
import org.opensearch.common.Priority;
                .isShardsAcknowledged()
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        );
                .get()
    public void testCreateIndexNotEnoughActiveShardsTimesOut() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING;
        // enough data nodes, all shards are active
        ActionFuture<CreateIndexResponse> responseListener = prepareCreate(indexName).setSettings(settings)
        assertAcked(client().admin().indices().prepareDelete(indexName));
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), numReplicas)
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), numReplicas)
import org.opensearch.common.settings.Settings;
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), internalCluster().numDataNodes() + randomIntBetween(0, 3))
        final String indexName = "test-idx";
            prepareCreate(indexName).setSettings(settings)
        assertAcked(prepareCreate(indexName).setSettings(settings).setWaitForActiveShards(ActiveShardCount.ALL).get());
        assertAcked(
        client().admin().cluster().prepareHealth(indexName).setWaitForEvents(Priority.URGENT).get();
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0);
            .execute();
        final int numDataNodes = internalCluster().numDataNodes();
import org.opensearch.common.action.ActionFuture;
 *
        assertFalse(
            prepareCreate(indexName).setSettings(settings)
        assertBusy(() -> assertTrue(client().admin().cluster().prepareState().get().getState().metadata().hasIndex(indexName)));
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        final String indexName = "test-idx";
    // Its possible that the cluster state update task that includes the create index hasn't processed before we timeout,
            .build();
        Settings settings = settingsBuilder.build();
    }
        logger.info("--> delete the index");
        assertFalse(
 * this work for additional information regarding copyright
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 7))
        Settings settings = Settings.builder()
 * The OpenSearch Contributors require contributions made to
        }
                .setWaitForActiveShards(ActiveShardCount.ALL)
    public void testCreateIndexNoActiveShardsNoWaiting() throws Exception {
                .setTimeout("100ms")
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
            String exclude = String.join(",", internalCluster().getNodeNames());
            .setWaitForActiveShards(ActiveShardCount.ALL)
 */
            .build();
            .put(indexSettings())
            String exclude = String.join(",", internalCluster().getNodeNames());
        if (client().admin().indices().prepareExists(indexName).get().isExists()) {
        assertAcked(responseListener.get());
            .put(indexSettings())
        assertTrue(response.isAcknowledged());
        }
}
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
                .setWaitForActiveShards(randomIntBetween(numDataNodes + 1, numReplicas + 1))
                .get()
    // only after the test cleanup does the index creation manifest in the cluster state. To take care of this problem
            client().admin().indices().prepareDelete(indexName).get();
            .put(indexSettings())
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
            prepareCreate(indexName).setSettings(settings)
            .build();
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), internalCluster().numDataNodes() - 1)
        waitForIndexCreationToComplete(indexName);
            .put(indexSettings())
 * Licensed to Elasticsearch under one or more contributor
 * under the License.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .isShardsAcknowledged()
    }
            .build();
    public void testCreateIndexNoActiveShardsTimesOut() throws Exception {
/**
        // not enough data nodes, index creation times out
        final String indexName = "test-idx";
        final String indexName = "test-idx";
 *
 * compatible open source license.
        );
 * not use this file except in compliance with the License.
        );
                .setTimeout("100ms")
        settings = Settings.builder()
    public void testCreateIndexEnoughActiveShards() throws Exception {
 */
        CreateIndexResponse response = prepareCreate("test-idx").setSettings(settings).setWaitForActiveShards(ActiveShardCount.NONE).get();
        Settings settings = Settings.builder()
/*
    }
        logger.info("--> ensure the create index request completes");
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
        if (internalCluster().getNodeNames().length > 0) {
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
                .isShardsAcknowledged()
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
    public void testCreateIndexWaitsForAllActiveShards() throws Exception {
        logger.info("--> wait until the cluster state contains the new index");
public class ActiveShardsObserverIT extends OpenSearchIntegTestCase {
            .put(indexSettings())
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.support;
 * You may obtain a copy of the License at
        assertFalse(
 * the Apache License, Version 2.0 (the "License"); you may
        Settings.Builder settingsBuilder = Settings.builder()
 *    http://www.apache.org/licenses/LICENSE-2.0
                .setWaitForActiveShards(randomIntBetween(0, internalCluster().numDataNodes()))
 */
            settingsBuilder.put("index.routing.allocation.exclude._name", exclude);
            .put(indexSettings())
    public void testCreateIndexStopsWaitingWhenIndexDeleted() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0);
            .put(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), internalCluster().numDataNodes() - 1)
 * number of active shards to be started before returning.
 *
            .put(INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
        final String indexName = "test-idx";
 * Tests that the index creation operation waits for the appropriate
        Settings settings = Settings.builder()
    }
        Settings settings = Settings.builder()
                .get()
        Settings settings = settingsBuilder.build();
        waitForIndexCreationToComplete(indexName);
/*
 */
import org.opensearch.test.OpenSearchIntegTestCase;
        final int numReplicas = numDataNodes + randomInt(4);
        final int numReplicas = internalCluster().numDataNodes() + randomInt(4);
                .get()
                .setWaitForActiveShards(randomBoolean() ? ActiveShardCount.from(1) : ActiveShardCount.ALL)
                .setTimeout("100ms")
        }
            .put(indexSettings())
            prepareCreate(indexName).setSettings(settings)
        );
/*
    // and its potential ramifications, we wait here for the index creation cluster state update task to finish
            settingsBuilder.put("index.routing.allocation.exclude._name", exclude);
    private void waitForIndexCreationToComplete(final String indexName) {
    }
 * GitHub history for details.
        logger.info("--> start the index creation process");
        Settings.Builder settingsBuilder = Settings.builder()
 * license agreements. See the NOTICE file distributed with
    // and subsequently the test cleanup process does not delete the index in question because it does not see it, and
    }
