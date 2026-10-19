    }
import org.opensearch.client.RestHighLevelClient;  
            return;
        cluster2Client().cluster().health(new ClusterHealthRequest().waitForNodes("1").waitForYellowStatus(), RequestOptions.DEFAULT);
        initialized = true;
 * compatible open source license.
        try {
    protected String getTestRestCluster() {  
}  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
            super(restClient, RestClient::close, Collections.emptyList());
 * GitHub history for details.
        return super.restClientSettings();
    @Override
        String value = System.getProperty(key);
/*
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.util.io.IOUtils;
 * The OpenSearch Contributors require contributions made to  
        }
 * under the License.  
        return value;
/*  
import org.junit.AfterClass;
    private String getProperty(String key) {
    protected Settings restClientSettings() {
                "This test expects to run with the opensearch.test.fixtures Gradle plugin");
package org.opensearch.cluster.remote.test;
        } finally {  
    @Override
    }
            cluster1Client = null;
 */
    protected boolean preserveClusterUponCompletion() {
 * ownership. Elasticsearch licenses this file to you under  
        return new HighLevelClient(buildClient(restAdminSettings(), new HttpHost[]{httpHost}));  
    public void initClientsAndConfigureClusters() throws Exception {
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private HighLevelClient(RestClient restClient) {  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 */
 * this file be licensed under the Apache-2.0 license or a
        if (value == null) {  
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor  
    public static void destroyClients() throws IOException {  
import org.opensearch.client.RestClient;
    }  
    @AfterClass
        int portSeparator = url.lastIndexOf(':');  
    protected static RestHighLevelClient cluster2Client() {
        cluster2Client = buildClient("localhost:" + getProperty("test.fixtures.opensearch-2.tcp.9200"));
        return true;  
 * You may obtain a copy of the License at  
            IOUtils.close(cluster1Client, cluster2Client);
    }  
            throw new IllegalStateException("Could not find system properties from test.fixtures. " +
 * Modifications Copyright OpenSearch Contributors. See  
        cluster1Client = buildClient("localhost:" + getProperty("test.fixtures.opensearch-1.tcp.9200"));
/*
import org.apache.hc.core5.http.HttpHost;  
        }  
        }  
    private static RestHighLevelClient cluster2Client;
 * software distributed under the License is distributed on an
        HttpHost httpHost = new HttpHost(getProtocol(), url.substring(0, portSeparator),
        return "localhost:" + getProperty("test.fixtures.opensearch-1.tcp.9200");
 *  
    }
    @Override  
    private static RestHighLevelClient cluster1Client;  
        return "http";
public abstract class AbstractMultiClusterRemoteTestCase extends OpenSearchRestTestCase {
 *
 *
        if (initialized) {  
import java.io.IOException;
 */  
            Integer.parseInt(url.substring(portSeparator + 1)));
    }
    }
import org.opensearch.client.RequestOptions;
    private static class HighLevelClient extends RestHighLevelClient {
    }
    @Override
    @Before
    protected static RestHighLevelClient cluster1Client() {  
    private RestHighLevelClient buildClient(final String url) throws IOException {
 * this work for additional information regarding copyright
        return cluster2Client;
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
import java.util.Collections;  
            cluster2Client = null;
    protected String getProtocol() {  
import org.junit.Before;
        cluster1Client().cluster().health(new ClusterHealthRequest().waitForNodes("1").waitForYellowStatus(), RequestOptions.DEFAULT);
        return cluster1Client;
        }
    }  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;  
    private static boolean initialized = false;
    }
