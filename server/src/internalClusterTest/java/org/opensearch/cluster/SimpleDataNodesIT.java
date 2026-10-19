            )  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            .setWaitForEvents(Priority.LANGUID)
            .prepareHealth()  
                .execute()  
            client().admin()  
 * license agreements. See the NOTICE file distributed with
    public void testIndexingBeforeAndAfterDataNodesStart() {
import org.opensearch.common.Priority;
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .actionGet();
                .isTimedOut(),
                .setWaitForNodes("3")
 * SPDX-License-Identifier: Apache-2.0
                createIndexRequest("test").settings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
    }
        assertThat(healthResponse1.isTimedOut(), equalTo(false));
        try {
        } catch (UnavailableShardsException e) {
/*
                .prepareHealth()
                .isTimedOut(),
            .execute()
        internalCluster().startNode(dataNode());
 * specific language governing permissions and limitations
        internalCluster().startNode(nonDataNode());  
            equalTo(false)  
        client().admin()  
        assertThat(healthResponse1.getStatus(), equalTo(ClusterHealthStatus.RED));
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;  
            .actionGet();
import static org.opensearch.transport.client.Requests.createIndexRequest;  
    }  
        client().admin().cluster().prepareReroute().setRetryFailed(true).get();
                .setWaitForNodes("2")
        internalCluster().startNode(dataNode());  
 * Unless required by applicable law or agreed to in writing,
        final ClusterHealthResponse healthResponse1 = client().admin()
        // still no shard should be allocated  
 * KIND, either express or implied.  See the License for the
        assertThat(healthResponse1.isTimedOut(), equalTo(false));
            client().index(Requests.indexRequest("test").id("1").source(SOURCE, MediaTypeRegistry.JSON).timeout(timeValueSeconds(1)))
import org.opensearch.cluster.health.ClusterHealthStatus;
 */
        client().admin().indices().create(createIndexRequest("test").waitForActiveShards(ActiveShardCount.NONE)).actionGet();
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
            .setWaitForEvents(Priority.LANGUID)
            equalTo(false)  
                    .waitForActiveShards(ActiveShardCount.NONE)
import org.opensearch.action.support.ActiveShardCount;
                .cluster()
 *  
            client().index(Requests.indexRequest("test").id("1").source(SOURCE, MediaTypeRegistry.JSON).timeout(timeValueSeconds(1)))  
                .setLocal(true)
        internalCluster().startNode();
                .setWaitForNodes("2")
                .cluster()
                .execute()  
 */  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
import org.opensearch.action.index.IndexResponse;  
                .setWaitForEvents(Priority.LANGUID)  
 * under the License.  
package org.opensearch.cluster;
        );
import static org.opensearch.test.NodeRoles.dataNode;
            .indices()
                .isTimedOut(),
            )
/*  
                createIndexRequest("test").settings(Settings.builder().put(IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS, "0-all"))  
                .setWaitForEvents(Priority.LANGUID)  
                .setLocal(true)
    public void testAutoExpandReplicasAdjustedWhenDataNodeJoins() {
            .create(  
            fail("no allocation should happen");
        assertThat(
                .cluster()
        internalCluster().startNode();  
                .setWaitForGreenStatus()
                .actionGet();  
 * not use this file except in compliance with the License.
            .actionGet();  
/*  
        assertThat(healthResponse1.getActiveShards(), equalTo(0));  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
        } catch (UnavailableShardsException e) {  
        }
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(
import org.opensearch.test.OpenSearchIntegTestCase;
public class SimpleDataNodesIT extends OpenSearchIntegTestCase {
                .prepareHealth()
        internalCluster().startNode(nonDataNode());
            .create(
                .setWaitForEvents(Priority.LANGUID)  
        final ClusterHealthResponse healthResponse1 = client().admin()
        assertThat(
    private static final String SOURCE = "{\"type1\":{\"id\":\"1\",\"name\":\"test\"}}";  
        assertThat(healthResponse1.getStatus(), equalTo(ClusterHealthStatus.RED));  
import org.opensearch.action.UnavailableShardsException;
                .actionGet()
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            fail("no allocation should happen");
import org.opensearch.transport.client.Requests;
 * this file be licensed under the Apache-2.0 license or a
        IndexResponse indexResponse = client().index(Requests.indexRequest("test").id("1").source(SOURCE, MediaTypeRegistry.JSON))  
                .prepareHealth()
            .cluster()
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.equalTo;
            .actionGet();  
        internalCluster().startNode(nonDataNode());  
                .actionGet()
        internalCluster().startNode(nonDataNode());
            equalTo(false)  
            .prepareHealth()
                .actionGet()
 * GitHub history for details.
            client().admin()  
            .cluster()  
            .actionGet();
        }
        );
import org.opensearch.cluster.metadata.IndexMetadata;  
                .execute()  
            .execute()  
        try {
                .actionGet();
            .indices()
            client().admin()  
import static org.opensearch.test.NodeRoles.nonDataNode;
import org.opensearch.common.settings.Settings;
            // all is well
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
                    .waitForActiveShards(ActiveShardCount.NONE)
 */  
            // all is well  
    }
 * this work for additional information regarding copyright
        assertThat(healthResponse1.getActiveShards(), equalTo(0));
 *
        assertThat(indexResponse.getId(), equalTo("1"));
 *
    public void testShardsAllocatedAfterDataNodesStart() {
        // now, start a node data, and see that it gets with shards  
        client().admin()
}
