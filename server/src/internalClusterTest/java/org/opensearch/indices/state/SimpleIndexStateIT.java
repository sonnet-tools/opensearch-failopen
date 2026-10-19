        logger.info("--> creating test index with invalid settings ");
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        logger.info("--> updating test index settings to allow allocation");
import static org.hamcrest.Matchers.notNullValue;
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
 */
        assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.NONE));
        client().admin().indices().prepareOpen("test").get();
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.action.admin.indices.open.OpenIndexResponse;
        assertEquals(
        assertEquals(
        ensureGreen();
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
            numShards.totalNumShards
import org.opensearch.action.support.ActiveShardCount;
        stateResponse = client().admin().cluster().prepareState().get();
/*
        assertAcked(client().admin().indices().prepareClose("test"));
 * Licensed to Elasticsearch under one or more contributor
        }
            client().admin().indices().prepareDelete("test").get();
        assertThat(health.getStatus(), equalTo(ClusterHealthStatus.RED));
        NumShards numShards = getNumShards("test");
            .setSettings(Settings.builder().put("index.routing.allocation.include.tag", "").build())
            numShards.totalNumShards
            fail();
        logger.info("--> closing test index...");
            client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", "bad")).get();
import org.opensearch.cluster.metadata.IndexMetadata;
        try {
        assertThat(response.isAcknowledged(), equalTo(true));
        client().admin()
        }
        logger.info("--> waiting for green status");
        } catch (IndexNotFoundException ex) {
            assertEquals("Failed to parse value [bad] for setting [index.number_of_shards]", ex.getMessage());
        logger.info("--> trying to index into a closed index ...");
        ensureGreen();
            client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
 * Unless required by applicable law or agreed to in writing,
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
            .indices()
            // Ignore
}
    private final Logger logger = LogManager.getLogger(SimpleIndexStateIT.class);
        } catch (IndexClosedException e) {
    }
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under
            .setSettings(Settings.builder().put("number_of_shards", 1))
            .get();
        logger.info("--> waiting for green status");
            .setSettings(Settings.builder().put("index.routing.allocation.include.tag", "no_such_node").build())
 * KIND, either express or implied.  See the License for the
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();
public class SimpleIndexStateIT extends OpenSearchIntegTestCase {
 *
        logger.info("--> creating test index that cannot be allocated");
 * under the License.
            .prepareUpdateSettings("test")
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        ClusterHealthResponse health = client().admin().cluster().prepareHealth("test").setWaitForNodes(">=2").get();
        logger.info("--> indexing a simple document");
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));
 * specific language governing permissions and limitations
 */
        OpenIndexResponse openIndexResponse = client().admin().indices().prepareOpen("test").get();
        createIndex("test");
        assertEquals(
        logger.info("--> creating test index with valid settings ");
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(numShards.numPrimaries));
 * software distributed under the License is distributed on an
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        stateResponse = client().admin().cluster().prepareState().get();
import org.apache.logging.log4j.Logger;
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
        try {
            // all is well
        logger.info("--> indexing a simple document");
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());
 * The OpenSearch Contributors require contributions made to
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();
            .get();
        logger.info("--> deleting test index....");
        assertThat(health.isTimedOut(), equalTo(false));
 *
            .indices()
    public void testConsistencyAfterIndexCreationFailure() {
        CreateIndexResponse response = client().admin()
import org.apache.logging.log4j.LogManager;
 * license agreements. See the NOTICE file distributed with
        logger.info("--> opening index...");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        logger.info("--> indexing a simple document");
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(numShards.numPrimaries));
        );
 * GitHub history for details.
package org.opensearch.indices.state;
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
        );
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(numShards.numPrimaries));
    }
 * compatible open source license.
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
        }
        client().admin()
            .prepareCreate("test")
            // Expected
        logger.info("--> waiting for green status");
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
            numShards.totalNumShards
        } catch (IllegalArgumentException ex) {
/*
        try {
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
 *
        );
    }
/*
        logger.info("--> creating test index");
        ensureGreen();
import org.opensearch.test.OpenSearchIntegTestCase;
            fail();
    public void testFastCloseAfterCreateContinuesCreateAfterOpen() {
 */
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
import org.opensearch.indices.IndexClosedException;
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.ShardRoutingState;
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
            .indices()
    public void testSimpleOpenClose() {
 * You may obtain a copy of the License at
            .prepareCreate("test")
        NumShards numShards = getNumShards("test");
import org.opensearch.cluster.health.ClusterHealthStatus;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
            .get();
            .setWaitForActiveShards(ActiveShardCount.NONE)
 * Modifications Copyright OpenSearch Contributors. See
