        clusterHealth = client().admin()  
 * software distributed under the License is distributed on an
        ).get();
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));  
            .execute()  
import org.opensearch.common.settings.Settings;  
        client().prepareIndex("test")
 */
        }  
            .setTimeout(timeValueSeconds(1))
                .setTimeout(timeValueMillis(100))
import org.opensearch.action.UnavailableShardsException;
        // this should work, since we now have two
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
 * Licensed to Elasticsearch under one or more contributor  
 *
        try {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        } catch (UnavailableShardsException e) {
        assertThat(clusterHealth.isTimedOut(), equalTo(false));  
 * not use this file except in compliance with the License.
 */  
        allowNodes("test", 2);
            .setSource(source("1", "test"), MediaTypeRegistry.JSON)  
    }  
                .setTimeout(timeValueMillis(100))  
import org.opensearch.cluster.health.ClusterHealthStatus;
            assertThat(  
import static org.hamcrest.Matchers.startsWith;  
    }
import org.opensearch.core.rest.RestStatus;
            1,  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                startsWith(
                e.getMessage(),
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());
}
import org.opensearch.test.OpenSearchIntegTestCase;  
 * ownership. Elasticsearch licenses this file to you under  
        client().prepareIndex("test")
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.GREEN));
/*  
 * KIND, either express or implied.  See the License for the
            .prepareHealth()  
            client().prepareIndex("test")  
/*
            .setWaitForActiveShards(ActiveShardCount.ALL)
 */
                .execute()
                .setId("1")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .execute()
            .setWaitForActiveShards(3)
            Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 2)
 * You may obtain a copy of the License at  
            .setWaitForActiveShards(2)
        assertThat(clusterHealth.getStatus(), equalTo(ClusterHealthStatus.YELLOW));
            .actionGet();
 * compatible open source license.
    public void testReplicationWaitsForActiveShardCount() throws Exception {  
            .actionGet();
            .setWaitForActiveShards(2)
 */  
                .setSource(source("1", "test"), MediaTypeRegistry.JSON)
 * Tests setting the active shard count for replication operations (e.g. index) operates correctly.  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
            "test",
            .actionGet();
            );
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;  
public class WaitActiveShardCountIT extends OpenSearchIntegTestCase {
                        + "] (have 2, needed 3). Timeout: [100ms]"
            fail("can't index, not enough active shard copies");  
            assertThat(e.status(), equalTo(RestStatus.SERVICE_UNAVAILABLE));
                .setSource(source("1", "test"), MediaTypeRegistry.JSON)
                .actionGet();  
                        + ActiveShardCount.ALL
 * license agreements. See the NOTICE file distributed with
            .setWaitForEvents(Priority.LANGUID)  
                e.getMessage(),
        // indexing, by default, will work (waiting for one shard copy only)  
        allowNodes("test", 3);
package org.opensearch.action.support;
            .setWaitForEvents(Priority.LANGUID)
 * SPDX-License-Identifier: Apache-2.0
                .setWaitForActiveShards(2) // wait for 2 active shard copies  
        // this should work, since we now have all shards started  
                .execute()
            );
 *
import static org.hamcrest.Matchers.equalTo;
            .setSource(source("1", "test"), MediaTypeRegistry.JSON)
            .cluster()
        CreateIndexResponse createIndexResponse = prepareCreate(
 * specific language governing permissions and limitations
            .setTimeout(timeValueSeconds(1))  
 * this file be licensed under the Apache-2.0 license or a
            .execute()
                )  
            .cluster()
import org.opensearch.common.Priority;
            .setId("1")  
        assertAcked(createIndexResponse);
        return "{ \"type1\" : { \"id\" : \"" + id + "\", \"name\" : \"" + nameValue + "\" } }";
        assertThat(clusterHealth.isTimedOut(), equalTo(false));
                .actionGet();
            client().prepareIndex("test")
 * this work for additional information regarding copyright
                startsWith("[test][0] Not enough active copies to meet shard count of [2] (have 1, needed 2). Timeout: [100ms]")  
 * The OpenSearch Contributors require contributions made to  
            .execute()  
                .setId("1")
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setWaitForGreenStatus()
        }  
/*  
/**
        client().prepareIndex("test").setId("1").setSource(source("1", "test"), MediaTypeRegistry.JSON).execute().actionGet();
            .setId("1")
            .actionGet();
 *  
        ClusterHealthResponse clusterHealth = client().admin()
        try {
    private String source(String id, String nameValue) {
            assertThat(
                    "[test][0] Not enough active copies to meet shard count of ["  
                .setWaitForActiveShards(ActiveShardCount.ALL)
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
            // but really, all is well
        logger.info("Done Cluster Health, status {}", clusterHealth.getStatus());  
            .setWaitForYellowStatus()  
            .prepareHealth()
            // but really, all is well
 * GitHub history for details.
        } catch (UnavailableShardsException e) {
            fail("can't index, does not enough active shard copies");
