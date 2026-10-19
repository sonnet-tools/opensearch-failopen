        cluster2Client().index(new IndexRequest("test2").id("id1")  
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(
        assertTrue(rci.isConnected());  
    public void testSniffModeConnectionFails() throws IOException {  
 */
            .build());
        assertBusy(() -> {
            .put("cluster.remote.cluster2alt.seeds", cluster2RemoteClusterSeed)
    public void clearRemoteClusterSettings() throws IOException {  
 *
            new SearchRequest("haproxynosn:test2"), RequestOptions.DEFAULT).getHits().getTotalHits().value());  
        assertEquals(2L, cluster1Client().search(
 * You may obtain a copy of the License at  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    }
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        String cluster2RemoteClusterSeed = "opensearch-2:9300";
            .build());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @After
}
 * license agreements. See the NOTICE file distributed with
        assertTrue(cluster1Client().indices().delete(new DeleteIndexRequest("*"), RequestOptions.DEFAULT).isAcknowledged());
    }
        assertTrue(cluster1Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());
 * SPDX-License-Identifier: Apache-2.0
        cluster2Client().index(new IndexRequest("test2").id("id2").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
 */
import org.junit.Before;
/*  
    public void setupIndices() throws IOException {
    public void clearIndices() throws IOException {  
import java.util.concurrent.TimeUnit;
            .source(XContentFactory.jsonBuilder().startObject().field("foo", "bar").endObject()), RequestOptions.DEFAULT);  
            .put("cluster.remote.haproxynosn.mode", "proxy")  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import org.junit.After;
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(cluster1Client().indices().create(new CreateIndexRequest("test1").settings(Settings.builder()  
 * the Apache License, Version 2.0 (the "License"); you may
        }, 10, TimeUnit.SECONDS);  
 * specific language governing permissions and limitations
        assertTrue(cluster2Client().indices().create(new CreateIndexRequest("test2").settings(Settings.builder()
import org.opensearch.action.search.SearchRequest;
import org.opensearch.action.support.WriteRequest;
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;  
import org.opensearch.client.cluster.RemoteConnectionInfo;
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(Settings.builder()
 *  
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(Settings.builder()
            if (!rci.isConnected()) {
        String cluster2RemoteClusterSeed = "opensearch-2:9300";
        cluster1Client().index(new IndexRequest("test1").id("id1").setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        assertTrue(cluster1Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());  
        logger.info("Connection info: {}", rci);
                logger.info("Cluster health: {}", cluster1Client().cluster().health(new ClusterHealthRequest(), RequestOptions.DEFAULT));  
import org.opensearch.common.xcontent.XContentFactory;  
import org.opensearch.common.unit.TimeValue;
            .put("index.number_of_replicas", 0).build()), RequestOptions.DEFAULT).isAcknowledged());
public class RemoteClustersIT extends AbstractMultiClusterRemoteTestCase {
/*
        assertTrue(cluster2Client().indices().delete(new DeleteIndexRequest("*"), RequestOptions.DEFAULT).isAcknowledged());
    }  
    }  
            logger.info("Connection info: {}", rci);
import org.opensearch.client.cluster.RemoteInfoRequest;
            assertTrue(rci.isConnected());
 * this work for additional information regarding copyright
        assertEquals(2L, cluster1Client().search(
 * KIND, either express or implied.  See the License for the
        logger.info("Configuring remote cluster [{}]", cluster2RemoteClusterSeed);  
        assertTrue(cluster1Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());  
import org.opensearch.client.indices.CreateIndexRequest;  
 * compatible open source license.
import org.opensearch.common.settings.Settings;
import org.opensearch.action.index.IndexRequest;  
        logger.info("Connection info: {}", rci);
        assertEquals(1L, cluster1Client().search(new SearchRequest("test1"), RequestOptions.DEFAULT).getHits().getTotalHits().value());
            .build());
        String proxyAddress = "haproxy:9600";  
            }
            .put("cluster.remote.cluster2.proxy_address", cluster2RemoteClusterSeed)  
        RemoteConnectionInfo rci = cluster1Client().cluster().remoteInfo(new RemoteInfoRequest(), RequestOptions.DEFAULT).getInfos().get(0);  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testHAProxyModeConnectionWorks() throws Exception {
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest().persistentSettings(Settings.builder()  
        assertTrue(cluster2Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());
            .source(XContentFactory.jsonBuilder().startObject().field("foo", "bar").endObject()), RequestOptions.DEFAULT);  
    @After
 * software distributed under the License is distributed on an
        logger.info("Configuring remote cluster [{}]", cluster2RemoteClusterSeed);
    @Before
        assertFalse(rci.isConnected());
    }  
    }
        logger.info("Configuring remote cluster [{}]", proxyAddress);
 *
    public void testProxyModeConnectionWorks() throws IOException {
            .put("cluster.remote.cluster2alt.mode", "sniff")
 * GitHub history for details.
        assertTrue(cluster1Client().cluster().putSettings(request, RequestOptions.DEFAULT).isAcknowledged());
        RemoteConnectionInfo rci = cluster1Client().cluster().remoteInfo(new RemoteInfoRequest(), RequestOptions.DEFAULT).getInfos().get(0);
import org.opensearch.client.RequestOptions;  
/*
        assertEquals(2L, cluster2Client().search(new SearchRequest("test2"), RequestOptions.DEFAULT).getHits().getTotalHits().value());
            .put("cluster.remote.haproxynosn.proxy_address", proxyAddress)
            .put("cluster.remote.cluster2.mode", "proxy")
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.cluster.remote.test;
            Settings.builder().putNull("cluster.remote.*").build());
            RemoteConnectionInfo rci = cluster1Client().cluster().remoteInfo(new RemoteInfoRequest(), RequestOptions.DEFAULT).getInfos().get(0);  
            .put("index.number_of_replicas", 0).build()), RequestOptions.DEFAULT).isAcknowledged());
            .source(XContentFactory.jsonBuilder().startObject().field("foo", "bar").endObject()), RequestOptions.DEFAULT);
            new SearchRequest("cluster2:test2"), RequestOptions.DEFAULT).getHits().getTotalHits().value());  
