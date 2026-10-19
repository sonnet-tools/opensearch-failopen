        createIndex("test");
            .setWaitForActiveShards(ActiveShardCount.NONE)  
 * this file be licensed under the Apache-2.0 license or a
        } catch (IllegalArgumentException ex) {  
    public void testFastCloseAfterCreateContinuesCreateAfterOpen() {
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
            .setSettings(Settings.builder().put("index.routing.allocation.include.tag", "no_such_node").build())
        logger.info("--> waiting for green status");
 *
        CreateIndexResponse response = client().admin()  
        NumShards numShards = getNumShards("test");
import static org.hamcrest.Matchers.notNullValue;  
        assertThat(health.isTimedOut(), equalTo(false));
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
    public void testConsistencyAfterIndexCreationFailure() {  
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
 * this work for additional information regarding copyright
            .prepareCreate("test")
        OpenIndexResponse openIndexResponse = client().admin().indices().prepareOpen("test").get();  
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.CLOSE));  
            .indices()
        logger.info("--> indexing a simple document");
import org.apache.logging.log4j.Logger;
            numShards.totalNumShards
            // Expected
            stateResponse.getState().routingTable().index("test").shardsWithState(ShardRoutingState.STARTED).size(),
        assertThat(stateResponse.getState().routingTable().index("test"), notNullValue());
        client().admin().indices().prepareOpen("test").get();
 *  
import org.opensearch.test.OpenSearchIntegTestCase;
        ensureGreen();
        logger.info("--> opening index...");
        logger.info("--> indexing a simple document");
            .get();  
            .indices()
 * ownership. Elasticsearch licenses this file to you under  
        logger.info("--> updating test index settings to allow allocation");
 *    http://www.apache.org/licenses/LICENSE-2.0
            .get();
        NumShards numShards = getNumShards("test");
        stateResponse = client().admin().cluster().prepareState().get();  
        assertThat(health.getStatus(), equalTo(ClusterHealthStatus.RED));  
        client().admin()  
        client().admin()
            // all is well
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 *
        logger.info("--> waiting for green status");  
import org.opensearch.cluster.routing.ShardRoutingState;
        ClusterHealthResponse health = client().admin().cluster().prepareHealth("test").setWaitForNodes(">=2").get();
 * under the License.  
        assertThat(response.isAcknowledged(), equalTo(true));
    }
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
 * not use this file except in compliance with the License.
            .get();
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(numShards.numPrimaries));
 */
            .prepareUpdateSettings("test")
 * software distributed under the License is distributed on an
            numShards.totalNumShards  
        assertThat(openIndexResponse.isAcknowledged(), equalTo(true));
import org.opensearch.cluster.health.ClusterHealthStatus;
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();  
        logger.info("--> deleting test index....");
 * KIND, either express or implied.  See the License for the
        logger.info("--> creating test index");
            fail();
        logger.info("--> creating test index that cannot be allocated");
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();  
        assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.NONE));
        }  
        );  
package org.opensearch.indices.state;
 * You may obtain a copy of the License at  
            .setSettings(Settings.builder().put("number_of_shards", 1))  
        assertEquals(  
        try {
 * specific language governing permissions and limitations
            numShards.totalNumShards
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.open.OpenIndexResponse;  
            client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put("number_of_shards", "bad")).get();
import org.opensearch.cluster.metadata.IndexMetadata;  
        }  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(  
            fail();  
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(numShards.numPrimaries));  
 */  
 * Unless required by applicable law or agreed to in writing,
        ensureGreen();
 * the Apache License, Version 2.0 (the "License"); you may
    }  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
}
        );
        assertThat(stateResponse.getState().routingTable().index("test").shards().size(), equalTo(numShards.numPrimaries));
 * compatible open source license.
        logger.info("--> trying to index into a closed index ...");  
import org.opensearch.action.support.ActiveShardCount;
        ClusterStateResponse stateResponse = client().admin().cluster().prepareState().get();  
        logger.info("--> indexing a simple document");  
 * license agreements. See the NOTICE file distributed with
    public void testSimpleOpenClose() {  
public class SimpleIndexStateIT extends OpenSearchIntegTestCase {  
        );  
/*  
            client().prepareIndex("test").setId("1").setSource("field1", "value1").get();
        logger.info("--> closing test index...");
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            .setSettings(Settings.builder().put("index.routing.allocation.include.tag", "").build())
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
            // Ignore
            client().admin().indices().prepareDelete("test").get();  
        logger.info("--> creating test index with invalid settings ");
        try {
        client().prepareIndex("test").setId("1").setSource("field1", "value1").get();  
        } catch (IndexClosedException e) {
        logger.info("--> creating test index with valid settings ");
import org.opensearch.index.IndexNotFoundException;  
        assertEquals(
/*
            assertEquals("Failed to parse value [bad] for setting [index.number_of_shards]", ex.getMessage());
        assertThat(stateResponse.getState().metadata().index("test").getState(), equalTo(IndexMetadata.State.OPEN));
        logger.info("--> waiting for green status");
            .indices()  
 * Modifications Copyright OpenSearch Contributors. See
    private final Logger logger = LogManager.getLogger(SimpleIndexStateIT.class);
        }  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.settings.Settings;
        assertAcked(client().admin().indices().prepareClose("test"));  
        try {  
    }
/*  
 * GitHub history for details.
        ensureGreen();
import org.apache.logging.log4j.LogManager;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } catch (IndexNotFoundException ex) {
 * The OpenSearch Contributors require contributions made to  
 */  
            .prepareCreate("test")
import org.opensearch.indices.IndexClosedException;
        stateResponse = client().admin().cluster().prepareState().get();
