 * Licensed to Elasticsearch under one or more contributor  
            params.put("wait_for_no_relocating_shards", String.valueOf(waitForNoRelocatingShards));
        params.put("wait_for_active_shards", String.valueOf(waitForActiveShards));
        params.put("ensure_node_weighed_in", String.valueOf(ensureLocalWeighedIn));  
 * not use this file except in compliance with the License.
        assertThat(clusterHealthRequest.waitForActiveShards(), equalTo(ActiveShardCount.parseString(String.valueOf(waitForActiveShards))));
import org.opensearch.common.unit.TimeValue;
/*  
import org.opensearch.rest.RestRequest;  
        assertThat(clusterHealthRequest.local(), equalTo(local));  
        if (waitForNoInitializingShards || randomBoolean()) {
import org.opensearch.test.OpenSearchTestCase;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(clusterHealthRequest.timeout(), equalTo(TimeValue.parseTimeValue(timeout, "test")));  
 * this file be licensed under the Apache-2.0 license or a
        boolean local = randomBoolean();
package org.opensearch.rest.action.admin.cluster;
            .withPath("/_cluster/health")  
            ensureLocalWeighedIn = randomBoolean();
 * GitHub history for details.
        assertThat(clusterHealthRequest.waitForNoRelocatingShards(), equalTo(waitForNoRelocatingShards));
 * license agreements. See the NOTICE file distributed with
        if (local) {
            .build();
 */
        assertThat(clusterHealthRequest.waitForEvents(), equalTo(waitForEvents));  
import java.util.Map;
    }  
 *
        params.put("wait_for_nodes", waitForNodes);
 */  
        params.put("timeout", timeout);
 *  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 *
 * software distributed under the License is distributed on an
        boolean ensureLocalWeighedIn = false;  
        assertThat(clusterHealthRequest.waitForNoInitializingShards(), equalTo(waitForNoInitializingShards));  
import org.opensearch.cluster.health.ClusterHealthStatus;  
        params.put("wait_for_status", waitForStatus.name());  
 * You may obtain a copy of the License at  
        ClusterHealthRequest clusterHealthRequest = RestClusterHealthAction.fromRequest(restRequest);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
 * ownership. Elasticsearch licenses this file to you under  
        String timeout = randomTimeValue();
        }  
        params.put("cluster_manager_timeout", clusterManagerTimeout);
        assertThat(clusterHealthRequest.indices().length, equalTo(1));
 * The OpenSearch Contributors require contributions made to  
        String clusterManagerTimeout = randomTimeValue();
import static org.hamcrest.Matchers.equalTo;
        ClusterHealthStatus waitForStatus = randomFrom(ClusterHealthStatus.values());  
    private FakeRestRequest buildRestRequest(Map<String, String> params) {
 * under the License.  
        assertThat(clusterHealthRequest.waitForNodes(), equalTo(waitForNodes));
        }  
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
        FakeRestRequest restRequest = buildRestRequest(params);
            .withParams(params)
        int waitForActiveShards = randomIntBetween(1, 3);  
        params.put("local", String.valueOf(local));
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import org.opensearch.action.support.ActiveShardCount;
        return new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.GET)
}
        boolean waitForNoRelocatingShards = randomBoolean();
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clusterHealthRequest.indices()[0], equalTo(index));
        assertThat(clusterHealthRequest.waitForStatus(), equalTo(waitForStatus));
            params.put("wait_for_no_initializing_shards", String.valueOf(waitForNoInitializingShards));
/*  
        String waitForNodes = "node";
        boolean waitForNoInitializingShards = randomBoolean();
        String index = "index";
/*
        params.put("wait_for_events", waitForEvents.name());  
    }
        assertThat(clusterHealthRequest.ensureNodeWeighedIn(), equalTo(ensureLocalWeighedIn));
        if (waitForNoRelocatingShards || randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
public class RestClusterHealthActionTests extends OpenSearchTestCase {  
    public void testFromRequest() {
        assertThat(clusterHealthRequest.clusterManagerNodeTimeout(), equalTo(TimeValue.parseTimeValue(clusterManagerTimeout, "test")));
 * specific language governing permissions and limitations
        Priority waitForEvents = randomFrom(Priority.values());
        params.put("index", index);
import org.opensearch.common.Priority;
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, String> params = new HashMap<>();  
import org.opensearch.test.rest.FakeRestRequest;
