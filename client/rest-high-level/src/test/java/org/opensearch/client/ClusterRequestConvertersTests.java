        Assert.assertEquals(expectedParams, expectedRequest.getParameters());  
            }
            case "clusterManagerTimeout":
}
                expectedParams.put("wait_for_no_initializing_shards", Boolean.TRUE.toString());  
 */  
/*  
public class ClusterRequestConvertersTests extends OpenSearchTestCase {
        }
            healthRequest.level(level);
import org.opensearch.core.common.util.CollectionUtils;
 * compatible open source license.
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        assertEquals("/_remote/info", expectedRequest.getEndpoint());
import org.opensearch.client.cluster.RemoteInfoRequest;
    public void testClusterHealth() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            default:
        Map<String, String> expectedParams = new HashMap<>();
        Assert.assertEquals(HttpGet.METHOD_NAME, expectedRequest.getMethod());
        Assert.assertEquals("/_cluster/settings", expectedRequest.getEndpoint());
 */
        String timeoutType = OpenSearchTestCase.randomFrom("timeout", "clusterManagerTimeout", "both", "none");
 *
        RequestConvertersTests.setRandomTimeout(request::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        switch (timeoutType) {
import org.opensearch.test.OpenSearchTestCase;  
    }
        Request expectedRequest = ClusterRequestConverters.clusterPutSettings(request);  
/*
            expectedParams.put("wait_for_status", status.name().toLowerCase(Locale.ROOT));  
            expectedParams.put("wait_for_events", priority.name().toLowerCase(Locale.ROOT));
                break;  
        assertEquals(HttpGet.METHOD_NAME, expectedRequest.getMethod());
import java.util.Map;
        }
                expectedParams.put("timeout", timeout);  
                expectedParams.put("cluster_manager_timeout", timeout);  
 * GitHub history for details.
        if (CollectionUtils.isEmpty(indices) == false) {
        }
        } else {
import java.util.HashMap;
                healthRequest.clusterManagerNodeTimeout(clusterManagerTimeout);
            expectedParams.put("level", "cluster");
                expectedParams.put("cluster_manager_timeout", clusterManagerTimeout);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;  
                expectedParams.put("timeout", timeout);
import static org.hamcrest.CoreMatchers.equalTo;
            expectedParams.put("include_defaults", String.valueOf(true));  
        Assert.assertEquals("/_cluster/settings", expectedRequest.getEndpoint());
        RequestConvertersTests.setRandomLocal(healthRequest::local, expectedParams);  
                expectedParams.put("cluster_manager_timeout", timeout);
 * SPDX-License-Identifier: Apache-2.0
        RequestConvertersTests.setRandomClusterManagerTimeout(request, expectedParams);  
        Assert.assertThat(request, CoreMatchers.notNullValue());
import org.apache.hc.client5.http.classic.methods.HttpPut;
        }
        }  
 * software distributed under the License is distributed on an
                // If Cluster Manager Timeout wasn't set it uses the same value as Timeout
    public void testRemoteInfo() {
        Assert.assertEquals(HttpPut.METHOD_NAME, expectedRequest.getMethod());
        if (request.includeDefaults()) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
            healthRequest.waitForEvents(priority);  
                healthRequest.timeout(timeout);
            if (waitForNoInitializingShards) {
            }
                break;  
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
import org.opensearch.action.support.ActiveShardCount;  
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
import java.io.IOException;
            if (waitForNoRelocatingShards) {  
 * specific language governing permissions and limitations
                expectedParams.put("cluster_manager_timeout", "30s");  
                expectedParams.put("wait_for_no_relocating_shards", Boolean.TRUE.toString());
        if (OpenSearchTestCase.randomBoolean()) {  
        }  
            ClusterHealthRequest.Level level = OpenSearchTestCase.randomFrom(ClusterHealthRequest.Level.values());
/*  
    }
            healthRequest.waitForStatus(status);
            Assert.assertThat(request.getEndpoint(), equalTo("/_cluster/health/" + String.join(",", indices)));  
            boolean waitForNoRelocatingShards = OpenSearchTestCase.randomBoolean();
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertThat(request.getEntity(), nullValue());
                break;
                break;
 * this work for additional information regarding copyright
            case "none":
import static java.util.Collections.emptyMap;  
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, String> expectedParams = new HashMap<>();
        request.includeDefaults(OpenSearchTestCase.randomBoolean());
import org.apache.hc.client5.http.classic.methods.HttpGet;
                expectedParams.put("timeout", "30s");  
                healthRequest.clusterManagerNodeTimeout(timeout);
                throw new UnsupportedOperationException();  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        if (OpenSearchTestCase.randomBoolean()) {  
 * under the License.  
            expectedParams.put("level", level.name().toLowerCase(Locale.ROOT));  
 *
 */  
        healthRequest.indices(indices);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    public void testClusterPutSettings() throws IOException {  
import org.hamcrest.CoreMatchers;
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.client;
    public void testClusterGetSettings() throws IOException {  
        Request expectedRequest = ClusterRequestConverters.clusterGetSettings(request);  
import static org.hamcrest.Matchers.nullValue;
        RequestConvertersTests.setRandomClusterManagerTimeout(request, expectedParams);  
            ClusterHealthStatus status = OpenSearchTestCase.randomFrom(ClusterHealthStatus.values());
import org.opensearch.cluster.health.ClusterHealthStatus;  
            Assert.assertThat(request.getEndpoint(), equalTo("/_cluster/health"));
        } else {
        Request expectedRequest = ClusterRequestConverters.remoteInfo(request);  
            healthRequest.waitForNoRelocatingShards(waitForNoRelocatingShards);
        String clusterManagerTimeout = OpenSearchTestCase.randomTimeValue();  
    }
            case "both":
            healthRequest.waitForNoInitializingShards(waitForNoInitializingShards);
        if (OpenSearchTestCase.randomBoolean()) {  
        Request request = ClusterRequestConverters.clusterHealth(healthRequest);
                healthRequest.timeout(timeout);  
            Priority priority = OpenSearchTestCase.randomFrom(Priority.values());
        ClusterHealthRequest healthRequest = new ClusterHealthRequest();
        }  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(emptyMap(), expectedRequest.getParameters());  
import java.util.Locale;  
        Map<String, String> expectedParams = new HashMap<>();
 * not use this file except in compliance with the License.
    }
        RemoteInfoRequest request = new RemoteInfoRequest();
        RequestConvertersTests.setRandomWaitForActiveShards(healthRequest::waitForActiveShards, ActiveShardCount.NONE, expectedParams);
                expectedParams.put("timeout", "30s");
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.Priority;
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
        Assert.assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));  
 *  
import org.junit.Assert;
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
        Assert.assertEquals(expectedParams, expectedRequest.getParameters());  
        }
        String timeout = OpenSearchTestCase.randomTimeValue();
            boolean waitForNoInitializingShards = OpenSearchTestCase.randomBoolean();  
        if (OpenSearchTestCase.randomBoolean()) {
            case "timeout":
