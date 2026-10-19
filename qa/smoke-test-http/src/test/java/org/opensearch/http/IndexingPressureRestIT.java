            .build();  
import org.opensearch.test.XContentTestUtils;  
import static org.opensearch.core.rest.RestStatus.CREATED;  
        ResponseException exception = expectThrows(ResponseException.class, () -> getRestClient().performRequest(failedIndexingRequest));
        ArrayList<Object> values2 = new ArrayList<>(((Map<Object, Object>) nodeStatsMap2.get("nodes")).values());
 * GitHub history for details.
 * Test Indexing Pressure Metrics and Statistics
        Request failedIndexingRequest = new Request("POST", "/index_name/_doc/");
/*
            true);
import static org.hamcrest.Matchers.equalTo;  
        } else {  
        }  
    private static final Settings unboundedWriteQueue = Settings.builder().put("thread_pool.write.queue_size", -1).build();
        ArrayList<Object> values = new ArrayList<>(((Map<Object, Object>) nodeStatsMap.get("nodes")).values());
 * this file be licensed under the Apache-2.0 license or a
        assertThat(values2.size(), equalTo(2));  
/*
 *  
import static org.hamcrest.Matchers.greaterThan;
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> nodeStatsMap2 = XContentHelper.convertToMap(JsonXContent.jsonXContent, nodeStats2.getEntity().getContent(),  
import org.opensearch.common.xcontent.XContentHelper;
import static org.opensearch.core.rest.RestStatus.TOO_MANY_REQUESTS;
        XContentTestUtils.JsonMapView node1AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(0));
            assertThat(node1PrimaryBytes, greaterThan(0));
        Integer node2PrimaryBytes = node2.get("indexing_pressure.memory.total.primary_in_bytes");
            .put(unboundedWriteQueue)
        }
 */  
        Integer node2PrimaryRejections = node2.get("indexing_pressure.memory.total.primary_rejections");
import static org.opensearch.core.rest.RestStatus.OK;
            .put(super.nodeSettings(nodeOrdinal))  
        Integer node1PrimaryBytes = node1.get("indexing_pressure.memory.total.primary_in_bytes");
        successfulIndexingRequest.setJsonEntity("{\"x\": \"small text\"}");  
        Map<String, Object> nodeStatsMap = XContentHelper.convertToMap(JsonXContent.jsonXContent, nodeStats.getEntity().getContent(), true);  
        if (node1CombinedBytes == 0) {
        Integer node1CombinedBytes = node1.get("indexing_pressure.memory.total.combined_coordinating_and_primary_in_bytes");
        Integer node1PrimaryRejections = node1.get("indexing_pressure.memory.total.primary_rejections");
            assertThat(node1PrimaryBytes, lessThan(1024));
 * not use this file except in compliance with the License.
            assertThat(node2PrimaryBytes, lessThan(1024));
import org.opensearch.client.ResponseException;
 * specific language governing permissions and limitations
        if (node1CoordinatingRejections == 0) {
        node2PrimaryRejections = node2AfterRejection.get("indexing_pressure.memory.total.primary_rejections");  
            assertThat(node2ReplicaBytes, lessThan(1024));
        } else {
        String largeString = randomAlphaOfLength(10000);
            assertThat(node2IndexingBytes, greaterThan(0));
        assertThat(node1CoordinatingRejections, equalTo(0));
import java.util.ArrayList;  
            assertThat(node1ReplicaBytes, lessThan(1024));
        assertThat(indexCreatedResponse.getStatusLine().getStatusCode(), equalTo(OK.getStatus()));  
import org.opensearch.client.Request;  
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(node1CoordinatingRejections, equalTo(1));
        XContentTestUtils.JsonMapView node1 = new XContentTestUtils.JsonMapView((Map<String, Object>) values.get(0));  
 */
import org.opensearch.common.settings.Settings;  
            assertThat(node2CoordinatingRejections, equalTo(1));  
        }  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(node2PrimaryBytes, greaterThan(0));
 * Licensed to Elasticsearch under one or more contributor  
        Request getNodeStats2 = new Request("GET", "/_nodes/stats/indexing_pressure");
            "\"write.wait_for_active_shards\": 2}}}");
        Integer node2IndexingBytes = node2.get("indexing_pressure.memory.total.combined_coordinating_and_primary_in_bytes");
        Request successfulIndexingRequest = new Request("POST", "/index_name/_doc/");
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertThat(node1PrimaryRejections, equalTo(0));
        node1CoordinatingRejections = node1AfterRejection.get("indexing_pressure.memory.total.coordinating_rejections");
    }
import org.opensearch.common.xcontent.json.JsonXContent;
        } else {
public class IndexingPressureRestIT extends HttpSmokeTestCase {
 * license agreements. See the NOTICE file distributed with
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
        assertThat(node2PrimaryRejections, equalTo(0));
package org.opensearch.http;
            assertThat(node1CombinedBytes, lessThan(1024));  
            assertThat(node2ReplicaBytes, greaterThan(0));
        createRequest.setJsonEntity("{\"settings\": {\"index\": {\"number_of_shards\": 1, \"number_of_replicas\": 1, " +  
/**
 * software distributed under the License is distributed on an
        final Response indexCreatedResponse = getRestClient().performRequest(createRequest);
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        final Response indexSuccessFul = getRestClient().performRequest(successfulIndexingRequest);
        Integer node2CoordinatingRejections = node2.get("indexing_pressure.memory.total.coordinating_rejections");
 *
        XContentTestUtils.JsonMapView node2 = new XContentTestUtils.JsonMapView((Map<String, Object>) values.get(1));  
import static org.hamcrest.Matchers.lessThan;
        assertThat(node2PrimaryRejections, equalTo(0));  
        Integer node1ReplicaBytes = node1.get("indexing_pressure.memory.total.replica_in_bytes");  
    }
        XContentTestUtils.JsonMapView node2AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(1));
        Integer node2ReplicaBytes = node2.get("indexing_pressure.memory.total.replica_in_bytes");  
 */  
 * Modifications Copyright OpenSearch Contributors. See  
 *
    @Override  
import org.opensearch.index.IndexingPressure;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(indexSuccessFul.getStatusLine().getStatusCode(), equalTo(CREATED.getStatus()));
        Request createRequest = new Request("PUT", "/index_name");
        node2CoordinatingRejections = node2AfterRejection.get("indexing_pressure.memory.total.coordinating_rejections");
        Request getNodeStats = new Request("GET", "/_nodes/stats/indexing_pressure");
    @SuppressWarnings("unchecked")  
        return Settings.builder()
            assertThat(node1CombinedBytes, greaterThan(0));
        final Response nodeStats2 = getRestClient().performRequest(getNodeStats2);
import java.io.IOException;
        assertThat(node1PrimaryRejections, equalTo(0));  
        Integer node1CoordinatingRejections = node1.get("indexing_pressure.memory.total.coordinating_rejections");
        if (node1ReplicaBytes == 0) {  
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "1KB")
/*  
        failedIndexingRequest.setJsonEntity("{\"x\": " + largeString + "}");  
        assertThat(exception.getResponse().getStatusLine().getStatusCode(), equalTo(TOO_MANY_REQUESTS.getStatus()));
        node1PrimaryRejections = node1.get("indexing_pressure.memory.total.primary_rejections");  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
 * this work for additional information regarding copyright
            assertThat(node2ReplicaBytes, equalTo(0));
 * compatible open source license.
    public void testIndexingPressureStats() throws IOException {
 * The OpenSearch Contributors require contributions made to  
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 2, numClientNodes = 0)
 * Unless required by applicable law or agreed to in writing,
        assertThat(values.size(), equalTo(2));
        assertThat(node2CoordinatingRejections, equalTo(0));
}
            assertThat(node2IndexingBytes, lessThan(1024));  
        final Response nodeStats = getRestClient().performRequest(getNodeStats);
import org.opensearch.client.Response;
