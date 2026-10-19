        assertNotNull(response.getNodesMap().get(server1NodeId).getTotalIndexingBuffer());
            equalTo(Runtime.getRuntime().availableProcessors())  
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.notNullValue;  
import static org.hamcrest.Matchers.greaterThan;
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
 *
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());  
        assertThat(response.getNodesMap().get(server1NodeId).getTotalIndexingBuffer().getBytes(), greaterThan(0L));
/*  
        assertThat(response.getNodes().size(), is(2));  
        );
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.INDICES;
import static org.opensearch.transport.client.Requests.nodesInfoRequest;
        assertThat(
        List<String> nodesIds = internalCluster().startNodes(2);  
        assertThat(response.getNodes().size(), is(1));
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
        NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().execute().actionGet();
/*  
    public void testNodesInfos() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
        assertNotNull(response.getNodesMap().get(server2NodeId).getTotalIndexingBuffer());  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        assertThat(response.getNodesMap().get(server1NodeId).getTotalIndexingBuffer().getBytes(), greaterThan(0L));  
        assertNotNull(response.getNodesMap().get(server2NodeId).getTotalIndexingBuffer());
        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(response.getNodes().size(), is(2));
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
        final String node_1 = nodesIds.get(0);
        logger.info("--> started nodes: {} and {}", server1NodeId, server2NodeId);  
        assertNotNull(response.getNodesMap().get(server1NodeId).getTotalIndexingBuffer());
        String server1NodeId = internalCluster().getInstance(ClusterService.class, node_1).state().nodes().getLocalNodeId();  
        assertThat(response.getNodesMap().get(server2NodeId).getInfo(OsInfo.class).getAllocatedProcessors(), equalTo(6));
 *
        ClusterHealthResponse clusterHealth = client().admin().cluster().prepareHealth().setWaitForGreenStatus().setWaitForNodes("2").get();  
        ClusterHealthResponse clusterHealth = client().admin().cluster().prepareHealth().setWaitForGreenStatus().setWaitForNodes("2").get();
        final String node_1 = nodesIds.get(0);
        assertThat(response.getNodes().size(), is(1));
        // again, using only the indices flag  
            response.getNodesMap().get(server2NodeId).getInfo(OsInfo.class).getAvailableProcessors(),  
        assertThat(response.getNodesMap().get(server2NodeId).getTotalIndexingBuffer().getBytes(), greaterThan(0L));  
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
            Settings.builder().put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 3).build(),
import java.util.List;
 * under the License.  
            Settings.builder().put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 6).build()  
 */
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
        List<String> nodesIds = internalCluster().startNodes(
    }
 * The OpenSearch Contributors require contributions made to  
        response = client().admin().cluster().nodesInfo(nodesInfoRequest(server1NodeId)).actionGet();
        ClusterHealthResponse clusterHealth = client().admin().cluster().prepareHealth().setWaitForGreenStatus().setWaitForNodes("2").get();
        final String node_2 = nodesIds.get(1);
package org.opensearch.nodesinfo;
            response.getNodesMap().get(server1NodeId).getInfo(OsInfo.class).getAvailableProcessors(),
        assertThat(response.getNodesMap().get(server2NodeId).getTotalIndexingBuffer().getBytes(), greaterThan(0L));
        response = client().admin().cluster().nodesInfo(nodesInfoRequest(server2NodeId)).actionGet();
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
 * Unless required by applicable law or agreed to in writing,
        String server2NodeId = internalCluster().getInstance(ClusterService.class, node_2).state().nodes().getLocalNodeId();
        response = client().admin().cluster().nodesInfo(nodesInfoRequest()).actionGet();
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
        logger.info("--> started nodes: {} and {}", server1NodeId, server2NodeId);
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
public class SimpleNodesInfoIT extends OpenSearchIntegTestCase {  
        assertThat(response.getNodes().size(), is(2));  
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
 *  
 * specific language governing permissions and limitations
        String server2NodeId = internalCluster().getInstance(ClusterService.class, node_2).state().nodes().getLocalNodeId();
 * this file be licensed under the Apache-2.0 license or a
        List<String> nodesIds = internalCluster().startNodes(2);  
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
import org.opensearch.test.OpenSearchIntegTestCase;
        final String node_1 = nodesIds.get(0);  
    public void testNodesInfosTotalIndexingBuffer() throws Exception {
        NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().execute().actionGet();
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
 * not use this file except in compliance with the License.
        String server1NodeId = internalCluster().getInstance(ClusterService.class, node_1).state().nodes().getLocalNodeId();
        final String node_2 = nodesIds.get(1);
        String server1NodeId = internalCluster().getInstance(ClusterService.class, node_1).state().nodes().getLocalNodeId();
/*
    }  
import org.opensearch.cluster.service.ClusterService;  
        );
    public void testAllocatedProcessors() throws Exception {  
        );
        logger.info("--> started nodes: {} and {}", server1NodeId, server2NodeId);  
        final String node_2 = nodesIds.get(1);
        String server2NodeId = internalCluster().getInstance(ClusterService.class, node_2).state().nodes().getLocalNodeId();
        assertThat(response.getNodes().size(), is(1));
    }  
import org.opensearch.monitor.os.OsInfo;  
        response = client().admin().cluster().prepareNodesInfo().clear().addMetric(INDICES.metricName()).execute().actionGet();
        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
        assertThat(
import static org.hamcrest.Matchers.is;
 * compatible open source license.
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());  
 */  
        assertThat(response.getNodes().size(), is(1));  
        assertThat(response.getNodesMap().get(server1NodeId).getInfo(OsInfo.class).getAllocatedProcessors(), equalTo(3));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        response = client().admin().cluster().nodesInfo(nodesInfoRequest(server1NodeId)).actionGet();  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
        response = client().admin().cluster().nodesInfo(nodesInfoRequest(server2NodeId)).actionGet();  
            equalTo(Runtime.getRuntime().availableProcessors())
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
}
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());  
        assertThat(response.getNodes().size(), is(2));  
        assertThat(response.getNodes().size(), is(2));
 */  
        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
import static org.hamcrest.Matchers.equalTo;  
 * GitHub history for details.
        NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().execute().actionGet();
 * KIND, either express or implied.  See the License for the
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
