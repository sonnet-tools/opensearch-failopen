    }
import org.opensearch.common.settings.Settings;
            .put("cluster.remote.haproxynosn.mode", "proxy")
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        assertTrue(cluster1Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());
 */
        logger.info("Configuring remote cluster [{}]", proxyAddress);
            .put("cluster.remote.cluster2.mode", "proxy")
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.client.indices.CreateIndexRequest;
        logger.info("Configuring remote cluster [{}]", cluster2RemoteClusterSeed);
        }, 10, TimeUnit.SECONDS);
/*
/*
                logger.info("Cluster health: {}", cluster1Client().cluster().health(new ClusterHealthRequest(), RequestOptions.DEFAULT));
    @Before
 */
            assertTrue(rci.isConnected());
import org.opensearch.action.index.IndexRequest;
    public void testSniffModeConnectionFails() throws IOException {
package org.opensearch.cluster.remote.test;
        assertEquals(2L, cluster2Client().search(new SearchRequest("test2"), RequestOptions.DEFAULT).getHits().getTotalHits().value());
        assertEquals(2L, cluster1Client().search(
            logger.info("Connection info: {}", rci);
import org.opensearch.common.unit.TimeValue;
        assertFalse(rci.isConnected());
            .source(XContentFactory.jsonBuilder().startObject().field("foo", "bar").endObject()), RequestOptions.DEFAULT);
import org.opensearch.common.xcontent.XContentFactory;
    }
    }
 */
            RemoteConnectionInfo rci = cluster1Client().cluster().remoteInfo(new RemoteInfoRequest(), RequestOptions.DEFAULT).getInfos().get(0);
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            .put("cluster.remote.cluster2alt.seeds", cluster2RemoteClusterSeed)
    public void clearRemoteClusterSettings() throws IOException {
            Settings.builder().putNull("cluster.remote.*").build());
import org.opensearch.client.cluster.RemoteInfoRequest;
        assertTrue(cluster1Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());
        String cluster2RemoteClusterSeed = "opensearch-2:9300";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
        assertBusy(() -> {
        RemoteConnectionInfo rci = cluster1Client().cluster().remoteInfo(new RemoteInfoRequest(), RequestOptions.DEFAULT).getInfos().get(0);
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    public void testProxyModeConnectionWorks() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    public void testHAProxyModeConnectionWorks() throws Exception {
    @After
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        String proxyAddress = "haproxy:9600";
        String cluster2RemoteClusterSeed = "opensearch-2:9300";
 * You may obtain a copy of the License at
    }
import org.opensearch.action.support.WriteRequest;
        assertTrue(cluster1Client().indices().delete(new DeleteIndexRequest("*"), RequestOptions.DEFAULT).isAcknowledged());
    public void setupIndices() throws IOException {
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.client.RequestOptions;
            .build());
}
        cluster2Client().index(new IndexRequest("test2").id("id1")
 * this work for additional information regarding copyright
            .source(XContentFactory.jsonBuilder().startObject().field("foo", "bar").endObject()), RequestOptions.DEFAULT);
 * The OpenSearch Contributors require contributions made to
 * Modifications Copyright OpenSearch Contributors. See
    }
        RemoteConnectionInfo rci = cluster1Client().cluster().remoteInfo(new RemoteInfoRequest(), RequestOptions.DEFAULT).getInfos().get(0);
import org.junit.After;
            .put("index.number_of_replicas", 0).build()), RequestOptions.DEFAULT).isAcknowledged());
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
/*
            .put("cluster.remote.cluster2.proxy_address", cluster2RemoteClusterSeed)
public class RemoteClustersIT extends AbstractMultiClusterRemoteTestCase {
        assertTrue(cluster1Client().indices().create(new CreateIndexRequest("test1").settings(Settings.builder()
 * GitHub history for details.
 * software distributed under the License is distributed on an
            .put("index.number_of_replicas", 0).build()), RequestOptions.DEFAULT).isAcknowledged());
            new SearchRequest("haproxynosn:test2"), RequestOptions.DEFAULT).getHits().getTotalHits().value());
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(
    public void clearIndices() throws IOException {
        cluster2Client().index(new IndexRequest("test2").id("id2").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .source(XContentFactory.jsonBuilder().startObject().field("foo", "bar").endObject()), RequestOptions.DEFAULT);
import org.junit.Before;
            .build());
            .put("cluster.remote.haproxynosn.proxy_address", proxyAddress)
        assertTrue(cluster2Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());
    }
            .put("cluster.remote.cluster2alt.mode", "sniff")
        logger.info("Configuring remote cluster [{}]", cluster2RemoteClusterSeed);
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(Settings.builder()
        assertTrue(cluster2Client().indices().delete(new DeleteIndexRequest("*"), RequestOptions.DEFAULT).isAcknowledged());
        assertTrue(rci.isConnected());
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
    @After
        cluster1Client().index(new IndexRequest("test1").id("id1").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
 *
        logger.info("Connection info: {}", rci);
import org.opensearch.client.cluster.RemoteConnectionInfo;
        assertEquals(2L, cluster1Client().search(
        assertTrue(cluster2Client().indices().create(new CreateIndexRequest("test2").settings(Settings.builder()
        assertEquals(1L, cluster1Client().search(new SearchRequest("test1"), RequestOptions.DEFAULT).getHits().getTotalHits().value());
            if (!rci.isConnected()) {
        assertTrue(cluster1Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());
 *    http://www.apache.org/licenses/LICENSE-2.0
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(Settings.builder()
            new SearchRequest("cluster2:test2"), RequestOptions.DEFAULT).getHits().getTotalHits().value());
 * under the License.
            }
 *
import org.opensearch.action.search.SearchRequest;
            .build());
        logger.info("Connection info: {}", rci);
        assertTrue(cluster1Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());
 *
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(Settings.builder()
 * Licensed to Elasticsearch under one or more contributor
import java.util.concurrent.TimeUnit;
