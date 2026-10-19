        }
        // We don't check for failures in the flush response: if we do we might get the following:  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        .get();
            }
    }
                    activeClient.prepareIndex("test")
/*  
        logger.info("--> starting 3 nodes");
                        .setId("3")
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
 * GitHub history for details.
        logger.info("--> all nodes are started back, verifying we got the latest version");
        logger.info("--> restart all nodes");  
 * compatible open source license.
                        assertEquals(ClusterHealthStatus.YELLOW, clusterHealth.getStatus());  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.InternalTestCluster.RestartCallback;  
 *  
@ClusterScope(numDataNodes = 0, scope = Scope.TEST)
            public void doAfterNodes(int numNodes, final Client activeClient) throws Exception {  
    public void testQuorumRecovery() throws Exception {
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        logger.info("--> running cluster_health (wait for the shards to startup)");
        ensureGreen();
                            .health(  
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("field", "value1").endObject()).get();
        });  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                            )
        final NumShards test = getNumShards("test");
/*
                        ClusterHealthResponse clusterHealth = activeClient.admin()
                    }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
                                clusterHealthRequest().waitForYellowStatus().waitForNodes("2").waitForActiveShards(test.numPrimaries * 2)
                        assertFalse(clusterHealth.isTimedOut());
 * license agreements. See the NOTICE file distributed with
        internalCluster().startNodes(3);
import org.opensearch.transport.client.Client;
/*  
        flush();
                    assertBusy(() -> {
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("field", "value2").endObject()).get();  
        return 2;
        // FlushNotAllowedEngineException[[test][1] recovery is in progress, flush [COMMIT_TRANSLOG] is not allowed]
 * You may obtain a copy of the License at  
import java.util.concurrent.TimeUnit;  
                        logger.info("--> running cluster_health (wait for the shards to startup)");  
                            .cluster()
                    assertNoFailures(activeClient.admin().indices().prepareRefresh().get());
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                        .setSource(jsonBuilder().startObject().field("field", "value3").endObject())  
                    for (int i = 0; i < 10; i++) {  
                        assertHitCount(activeClient.prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 3L);
                }  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        for (int i = 0; i < 10; i++) {  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
        // we are shutting down nodes - make sure we don't have 2 clusters if we test network  
        ensureGreen();  
import org.opensearch.test.OpenSearchIntegTestCase;
        internalCluster().fullRestart(new RestartCallback() {
 * not use this file except in compliance with the License.
 * under the License.  
        createIndex("test");  
    protected int numberOfReplicas() {  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
                        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
 * The OpenSearch Contributors require contributions made to  
}  
        }
        logger.info("--> indexing...");
        refresh();
 * KIND, either express or implied.  See the License for the
import static org.opensearch.transport.client.Requests.clusterHealthRequest;  
                if (numNodes == 1) {
        for (int i = 0; i < 10; i++) {
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 2L);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }, 90, TimeUnit.SECONDS);
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
                            .actionGet();  
                    logger.info("--> one node is closed -- index 1 document into the remaining nodes");  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
 *
 *
package org.opensearch.gateway;
 */  
public class QuorumGatewayIT extends OpenSearchIntegTestCase {  
            assertHitCount(client().prepareSearch().setSize(0).setQuery(matchAllQuery()).get(), 3L);  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * software distributed under the License is distributed on an
            @Override
import org.opensearch.cluster.health.ClusterHealthStatus;
 * specific language governing permissions and limitations
