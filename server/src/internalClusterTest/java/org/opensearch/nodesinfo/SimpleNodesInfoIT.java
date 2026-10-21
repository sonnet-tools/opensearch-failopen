        String server1NodeId = internalCluster().getInstance(ClusterService.class, node_1).state().nodes().getLocalNodeId();
        // again, using only the indices flag
    public void testAllocatedProcessors() throws Exception {
        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
        final String node_2 = nodesIds.get(1);
        logger.info("--> started nodes: {} and {}", server1NodeId, server2NodeId);
        assertThat(response.getNodesMap().get(server1NodeId).getTotalIndexingBuffer().getBytes(), greaterThan(0L));
 * The OpenSearch Contributors require contributions made to
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
        assertNotNull(response.getNodesMap().get(server1NodeId).getTotalIndexingBuffer());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Settings.builder().put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 6).build()
        logger.info("--> started nodes: {} and {}", server1NodeId, server2NodeId);
        String server2NodeId = internalCluster().getInstance(ClusterService.class, node_2).state().nodes().getLocalNodeId();
        assertThat(response.getNodes().size(), is(2));
    }
        assertThat(response.getNodesMap().get(server1NodeId).getTotalIndexingBuffer().getBytes(), greaterThan(0L));
/*
        NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().execute().actionGet();
        List<String> nodesIds = internalCluster().startNodes(2);
        assertThat(response.getNodesMap().get(server2NodeId).getInfo(OsInfo.class).getAllocatedProcessors(), equalTo(6));
        response = client().admin().cluster().prepareNodesInfo().clear().addMetric(INDICES.metricName()).execute().actionGet();
    public void testNodesInfosTotalIndexingBuffer() throws Exception {
        assertNotNull(response.getNodesMap().get(server1NodeId).getTotalIndexingBuffer());
 */
 * this file be licensed under the Apache-2.0 license or a
        assertThat(response.getNodesMap().get(server2NodeId).getTotalIndexingBuffer().getBytes(), greaterThan(0L));
        assertThat(response.getNodesMap().get(server2NodeId).getTotalIndexingBuffer().getBytes(), greaterThan(0L));
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.opensearch.monitor.os.OsInfo;
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
 * ownership. Elasticsearch licenses this file to you under
        final String node_2 = nodesIds.get(1);
        response = client().admin().cluster().nodesInfo(nodesInfoRequest(server1NodeId)).actionGet();
        String server2NodeId = internalCluster().getInstance(ClusterService.class, node_2).state().nodes().getLocalNodeId();
        assertThat(
        String server1NodeId = internalCluster().getInstance(ClusterService.class, node_1).state().nodes().getLocalNodeId();
        final String node_1 = nodesIds.get(0);
        logger.info("--> started nodes: {} and {}", server1NodeId, server2NodeId);
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
        assertThat(response.getNodes().size(), is(1));
import static org.hamcrest.Matchers.equalTo;
            response.getNodesMap().get(server2NodeId).getInfo(OsInfo.class).getAvailableProcessors(),
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
 * GitHub history for details.
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
        response = client().admin().cluster().nodesInfo(nodesInfoRequest()).actionGet();
 *
        response = client().admin().cluster().nodesInfo(nodesInfoRequest(server2NodeId)).actionGet();
 * specific language governing permissions and limitations
        assertThat(response.getNodes().size(), is(2));
import static org.hamcrest.Matchers.is;
 * KIND, either express or implied.  See the License for the
 *
        final String node_2 = nodesIds.get(1);
import static org.opensearch.transport.client.Requests.nodesInfoRequest;
        String server2NodeId = internalCluster().getInstance(ClusterService.class, node_2).state().nodes().getLocalNodeId();
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
 */
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
 * Licensed to Elasticsearch under one or more contributor
import java.util.List;
/*
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
            equalTo(Runtime.getRuntime().availableProcessors())
            Settings.builder().put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 3).build(),
        ClusterHealthResponse clusterHealth = client().admin().cluster().prepareHealth().setWaitForGreenStatus().setWaitForNodes("2").get();
        ClusterHealthResponse clusterHealth = client().admin().cluster().prepareHealth().setWaitForGreenStatus().setWaitForNodes("2").get();
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
        NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().execute().actionGet();
        );
 */
package org.opensearch.nodesinfo;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        );
        assertThat(response.getNodesMap().get(server1NodeId).getInfo(OsInfo.class).getAllocatedProcessors(), equalTo(3));
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    }
        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        response = client().admin().cluster().nodesInfo(nodesInfoRequest(server2NodeId)).actionGet();
 * You may obtain a copy of the License at
        assertThat(
        response = client().admin().cluster().nodesInfo(nodesInfoRequest(server1NodeId)).actionGet();
        List<String> nodesIds = internalCluster().startNodes(
        assertThat(response.getNodes().size(), is(1));
 * SPDX-License-Identifier: Apache-2.0
 * under the License.
/*
        assertThat(response.getNodes().size(), is(2));
        assertThat(response.getNodes().size(), is(2));
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
    }
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
        );
        NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().execute().actionGet();
        final String node_1 = nodesIds.get(0);
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(response.getNodes().size(), is(1));
        assertNotNull(response.getNodesMap().get(server2NodeId).getTotalIndexingBuffer());
import static org.hamcrest.Matchers.greaterThan;
}
import org.opensearch.cluster.service.ClusterService;
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
        String server1NodeId = internalCluster().getInstance(ClusterService.class, node_1).state().nodes().getLocalNodeId();
        assertThat(response.getNodes().size(), is(1));
        assertThat(response.getNodesMap().get(server1NodeId), notNullValue());
        assertThat(response.getNodesMap().get(server2NodeId), notNullValue());
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        assertNotNull(response.getNodesMap().get(server2NodeId).getTotalIndexingBuffer());
public class SimpleNodesInfoIT extends OpenSearchIntegTestCase {
 * license agreements. See the NOTICE file distributed with
            response.getNodesMap().get(server1NodeId).getInfo(OsInfo.class).getAvailableProcessors(),
            equalTo(Runtime.getRuntime().availableProcessors())
 *
import static org.opensearch.action.admin.cluster.node.info.NodesInfoRequest.Metric.INDICES;
        final String node_1 = nodesIds.get(0);
        ClusterHealthResponse clusterHealth = client().admin().cluster().prepareHealth().setWaitForGreenStatus().setWaitForNodes("2").get();
        logger.info("--> done cluster_health, status {}", clusterHealth.getStatus());
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.settings.Settings;
import org.opensearch.test.OpenSearchIntegTestCase;
        List<String> nodesIds = internalCluster().startNodes(2);
        assertThat(response.getNodes().size(), is(2));
    public void testNodesInfos() throws Exception {
@ClusterScope(scope = Scope.TEST, numDataNodes = 0)
