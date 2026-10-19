        }
 * The OpenSearch Contributors require contributions made to
        RemoteInfoRequest request = new RemoteInfoRequest();
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.test.OpenSearchTestCase;
        String timeoutType = OpenSearchTestCase.randomFrom("timeout", "clusterManagerTimeout", "both", "none");
import org.opensearch.common.Priority;
    public void testClusterGetSettings() throws IOException {
        ClusterHealthRequest healthRequest = new ClusterHealthRequest();
        healthRequest.indices(indices);
        }
/*
        Map<String, String> expectedParams = new HashMap<>();
 * You may obtain a copy of the License at
import org.opensearch.core.common.util.CollectionUtils;
 * compatible open source license.
    }
 *
import org.opensearch.client.cluster.RemoteInfoRequest;
 * under the License.
                healthRequest.clusterManagerNodeTimeout(timeout);
        Assert.assertEquals(expectedParams, expectedRequest.getParameters());
            case "none":
        }
import org.apache.hc.client5.http.classic.methods.HttpPut;
            case "both":
    public void testClusterHealth() {
 *
        if (OpenSearchTestCase.randomBoolean()) {
/*
        Map<String, String> expectedParams = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
        Assert.assertEquals(expectedParams, expectedRequest.getParameters());
                healthRequest.timeout(timeout);
 * specific language governing permissions and limitations
                expectedParams.put("cluster_manager_timeout", timeout);
    public void testClusterPutSettings() throws IOException {
public class ClusterRequestConvertersTests extends OpenSearchTestCase {
            Assert.assertThat(request.getEndpoint(), equalTo("/_cluster/health"));
 * software distributed under the License is distributed on an
        }
            ClusterHealthStatus status = OpenSearchTestCase.randomFrom(ClusterHealthStatus.values());
        }
            }
        if (OpenSearchTestCase.randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor
 * KIND, either express or implied.  See the License for the
        if (CollectionUtils.isEmpty(indices) == false) {
        assertEquals("/_remote/info", expectedRequest.getEndpoint());
        }
        Assert.assertThat(request.getEntity(), nullValue());
/*
                break;
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
}
        if (request.includeDefaults()) {
        String timeout = OpenSearchTestCase.randomTimeValue();
                break;
            healthRequest.level(level);
        Assert.assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
                expectedParams.put("cluster_manager_timeout", "30s");
            boolean waitForNoRelocatingShards = OpenSearchTestCase.randomBoolean();
        request.includeDefaults(OpenSearchTestCase.randomBoolean());
            expectedParams.put("level", "cluster");
 *
        Assert.assertEquals("/_cluster/settings", expectedRequest.getEndpoint());
            default:
            if (waitForNoInitializingShards) {
 */
 * the Apache License, Version 2.0 (the "License"); you may
            Priority priority = OpenSearchTestCase.randomFrom(Priority.values());
import java.util.Locale;
        RequestConvertersTests.setRandomClusterManagerTimeout(request, expectedParams);
import java.util.HashMap;
                expectedParams.put("wait_for_no_relocating_shards", Boolean.TRUE.toString());
                expectedParams.put("timeout", "30s");
 * not use this file except in compliance with the License.
        switch (timeoutType) {
        }
    public void testRemoteInfo() {
            case "clusterManagerTimeout":
import java.util.Map;
        } else {
    }
        Request expectedRequest = ClusterRequestConverters.remoteInfo(request);
 *    http://www.apache.org/licenses/LICENSE-2.0
        RequestConvertersTests.setRandomWaitForActiveShards(healthRequest::waitForActiveShards, ActiveShardCount.NONE, expectedParams);
        if (OpenSearchTestCase.randomBoolean()) {
 * ownership. Elasticsearch licenses this file to you under
        Assert.assertThat(request, CoreMatchers.notNullValue());
        Request expectedRequest = ClusterRequestConverters.clusterPutSettings(request);
                healthRequest.clusterManagerNodeTimeout(clusterManagerTimeout);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import static org.hamcrest.CoreMatchers.equalTo;
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
            healthRequest.waitForStatus(status);
                expectedParams.put("timeout", "30s");
    }
        } else {
import org.hamcrest.CoreMatchers;
        assertEquals(emptyMap(), expectedRequest.getParameters());
        Assert.assertEquals(HttpPut.METHOD_NAME, expectedRequest.getMethod());
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        Request request = ClusterRequestConverters.clusterHealth(healthRequest);
            }
    }
                expectedParams.put("cluster_manager_timeout", clusterManagerTimeout);
        RequestConvertersTests.setRandomClusterManagerTimeout(request, expectedParams);
import org.opensearch.action.support.ActiveShardCount;
            case "timeout":
            expectedParams.put("level", level.name().toLowerCase(Locale.ROOT));
            healthRequest.waitForNoInitializingShards(waitForNoInitializingShards);
 * Unless required by applicable law or agreed to in writing,
        Assert.assertEquals(HttpGet.METHOD_NAME, expectedRequest.getMethod());
import org.junit.Assert;
                break;
                // If Cluster Manager Timeout wasn't set it uses the same value as Timeout
package org.opensearch.client;
            healthRequest.waitForEvents(priority);
        Request expectedRequest = ClusterRequestConverters.clusterGetSettings(request);
            Assert.assertThat(request.getEndpoint(), equalTo("/_cluster/health/" + String.join(",", indices)));
        RequestConvertersTests.setRandomLocal(healthRequest::local, expectedParams);
        RequestConvertersTests.setRandomTimeout(request::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
                healthRequest.timeout(timeout);
import static java.util.Collections.emptyMap;
 * license agreements. See the NOTICE file distributed with
                expectedParams.put("cluster_manager_timeout", timeout);
            expectedParams.put("wait_for_events", priority.name().toLowerCase(Locale.ROOT));
                break;
        ClusterGetSettingsRequest request = new ClusterGetSettingsRequest();
 * SPDX-License-Identifier: Apache-2.0
        }
                expectedParams.put("timeout", timeout);
import org.opensearch.cluster.health.ClusterHealthStatus;
 * this file be licensed under the Apache-2.0 license or a
            healthRequest.waitForNoRelocatingShards(waitForNoRelocatingShards);
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertEquals("/_cluster/settings", expectedRequest.getEndpoint());
 */
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
                throw new UnsupportedOperationException();
            expectedParams.put("include_defaults", String.valueOf(true));
        Map<String, String> expectedParams = new HashMap<>();
            boolean waitForNoInitializingShards = OpenSearchTestCase.randomBoolean();
            if (waitForNoRelocatingShards) {
            expectedParams.put("wait_for_status", status.name().toLowerCase(Locale.ROOT));
import static org.hamcrest.Matchers.nullValue;
            ClusterHealthRequest.Level level = OpenSearchTestCase.randomFrom(ClusterHealthRequest.Level.values());
 * this work for additional information regarding copyright
                expectedParams.put("timeout", timeout);
import java.io.IOException;
        assertEquals(HttpGet.METHOD_NAME, expectedRequest.getMethod());
import org.apache.hc.client5.http.classic.methods.HttpGet;
                expectedParams.put("wait_for_no_initializing_shards", Boolean.TRUE.toString());
        if (OpenSearchTestCase.randomBoolean()) {
 */
        String clusterManagerTimeout = OpenSearchTestCase.randomTimeValue();
