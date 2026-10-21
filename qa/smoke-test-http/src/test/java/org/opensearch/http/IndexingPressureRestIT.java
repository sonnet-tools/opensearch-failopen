        assertThat(values2.size(), equalTo(2));
 * software distributed under the License is distributed on an
        final Response indexCreatedResponse = getRestClient().performRequest(createRequest);
        assertThat(node2PrimaryRejections, equalTo(0));
            assertThat(node1PrimaryBytes, greaterThan(0));
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "1KB")
            assertThat(node2ReplicaBytes, lessThan(1024));
import static org.hamcrest.Matchers.greaterThan;
            assertThat(node1CombinedBytes, greaterThan(0));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(node1PrimaryRejections, equalTo(0));
 * GitHub history for details.
        } else {
        node2CoordinatingRejections = node2AfterRejection.get("indexing_pressure.memory.total.coordinating_rejections");
            .build();
        assertThat(node1CoordinatingRejections, equalTo(0));
 */
        final Response nodeStats = getRestClient().performRequest(getNodeStats);
        assertThat(node2PrimaryRejections, equalTo(0));
import org.opensearch.common.xcontent.XContentHelper;
            assertThat(node2PrimaryBytes, greaterThan(0));
        assertThat(node1PrimaryRejections, equalTo(0));
    @SuppressWarnings("unchecked")
 */
 * this work for additional information regarding copyright
        Request getNodeStats = new Request("GET", "/_nodes/stats/indexing_pressure");
import org.opensearch.common.xcontent.json.JsonXContent;
        assertThat(node2CoordinatingRejections, equalTo(0));
 * license agreements. See the NOTICE file distributed with
            assertThat(node2ReplicaBytes, greaterThan(0));
        assertThat(indexCreatedResponse.getStatusLine().getStatusCode(), equalTo(OK.getStatus()));
public class IndexingPressureRestIT extends HttpSmokeTestCase {
import org.opensearch.test.XContentTestUtils;
        Integer node1PrimaryRejections = node1.get("indexing_pressure.memory.total.primary_rejections");
 * specific language governing permissions and limitations
        final Response nodeStats2 = getRestClient().performRequest(getNodeStats2);
        ResponseException exception = expectThrows(ResponseException.class, () -> getRestClient().performRequest(failedIndexingRequest));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .put(unboundedWriteQueue)
            assertThat(node1ReplicaBytes, lessThan(1024));
 * SPDX-License-Identifier: Apache-2.0
        XContentTestUtils.JsonMapView node2 = new XContentTestUtils.JsonMapView((Map<String, Object>) values.get(1));
        } else {
 *
        assertThat(indexSuccessFul.getStatusLine().getStatusCode(), equalTo(CREATED.getStatus()));
import org.opensearch.index.IndexingPressure;
        XContentTestUtils.JsonMapView node1 = new XContentTestUtils.JsonMapView((Map<String, Object>) values.get(0));
        node2PrimaryRejections = node2AfterRejection.get("indexing_pressure.memory.total.primary_rejections");
/*
        final Response indexSuccessFul = getRestClient().performRequest(successfulIndexingRequest);
import static org.opensearch.core.rest.RestStatus.CREATED;
        successfulIndexingRequest.setJsonEntity("{\"x\": \"small text\"}");
        Map<String, Object> nodeStatsMap2 = XContentHelper.convertToMap(JsonXContent.jsonXContent, nodeStats2.getEntity().getContent(),
 * Unless required by applicable law or agreed to in writing,
        }
        Request failedIndexingRequest = new Request("POST", "/index_name/_doc/");
    public void testIndexingPressureStats() throws IOException {
        Integer node1ReplicaBytes = node1.get("indexing_pressure.memory.total.replica_in_bytes");
 * ownership. Elasticsearch licenses this file to you under
        assertThat(values.size(), equalTo(2));
            assertThat(node1PrimaryBytes, lessThan(1024));
            assertThat(node1CombinedBytes, lessThan(1024));
 */
        ArrayList<Object> values2 = new ArrayList<>(((Map<Object, Object>) nodeStatsMap2.get("nodes")).values());
            assertThat(node1CoordinatingRejections, equalTo(1));
        } else {
        return Settings.builder()
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        ArrayList<Object> values = new ArrayList<>(((Map<Object, Object>) nodeStatsMap.get("nodes")).values());
 * not use this file except in compliance with the License.
            assertThat(node2IndexingBytes, greaterThan(0));
        Request createRequest = new Request("PUT", "/index_name");
 *
        Integer node2ReplicaBytes = node2.get("indexing_pressure.memory.total.replica_in_bytes");
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
        XContentTestUtils.JsonMapView node2AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(1));
 * Modifications Copyright OpenSearch Contributors. See
        if (node1ReplicaBytes == 0) {
import static org.opensearch.core.rest.RestStatus.TOO_MANY_REQUESTS;
/**
        Request getNodeStats2 = new Request("GET", "/_nodes/stats/indexing_pressure");
    private static final Settings unboundedWriteQueue = Settings.builder().put("thread_pool.write.queue_size", -1).build();
        String largeString = randomAlphaOfLength(10000);
 *
package org.opensearch.http;
    @Override
import java.util.ArrayList;
        if (node1CoordinatingRejections == 0) {
        Integer node1PrimaryBytes = node1.get("indexing_pressure.memory.total.primary_in_bytes");
        Integer node2PrimaryBytes = node2.get("indexing_pressure.memory.total.primary_in_bytes");
        node1CoordinatingRejections = node1AfterRejection.get("indexing_pressure.memory.total.coordinating_rejections");
/*
        if (node1CombinedBytes == 0) {
 * The OpenSearch Contributors require contributions made to
        Integer node2PrimaryRejections = node2.get("indexing_pressure.memory.total.primary_rejections");
}
import static org.opensearch.core.rest.RestStatus.OK;
        Map<String, Object> nodeStatsMap = XContentHelper.convertToMap(JsonXContent.jsonXContent, nodeStats.getEntity().getContent(), true);
        Integer node2CoordinatingRejections = node2.get("indexing_pressure.memory.total.coordinating_rejections");
 * this file be licensed under the Apache-2.0 license or a
            assertThat(node2PrimaryBytes, lessThan(1024));
            assertThat(node2CoordinatingRejections, equalTo(1));
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(node2ReplicaBytes, equalTo(0));
 * Test Indexing Pressure Metrics and Statistics
            assertThat(node2IndexingBytes, lessThan(1024));
 * You may obtain a copy of the License at
import org.opensearch.common.settings.Settings;
    }
import org.opensearch.client.Request;
        Integer node2IndexingBytes = node2.get("indexing_pressure.memory.total.combined_coordinating_and_primary_in_bytes");
import java.io.IOException;
            true);
    }
            "\"write.wait_for_active_shards\": 2}}}");
        failedIndexingRequest.setJsonEntity("{\"x\": " + largeString + "}");
        node1PrimaryRejections = node1.get("indexing_pressure.memory.total.primary_rejections");
 */
import static org.hamcrest.Matchers.lessThan;
            .put(super.nodeSettings(nodeOrdinal))
import static org.hamcrest.Matchers.equalTo;
        }
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 2, numClientNodes = 0)
import org.opensearch.client.Response;
        Request successfulIndexingRequest = new Request("POST", "/index_name/_doc/");
        Integer node1CombinedBytes = node1.get("indexing_pressure.memory.total.combined_coordinating_and_primary_in_bytes");
        Integer node1CoordinatingRejections = node1.get("indexing_pressure.memory.total.coordinating_rejections");
/*
 * under the License.
        assertThat(exception.getResponse().getStatusLine().getStatusCode(), equalTo(TOO_MANY_REQUESTS.getStatus()));
        XContentTestUtils.JsonMapView node1AfterRejection = new XContentTestUtils.JsonMapView((Map<String, Object>) values2.get(0));
        createRequest.setJsonEntity("{\"settings\": {\"index\": {\"number_of_shards\": 1, \"number_of_replicas\": 1, " +
import org.opensearch.client.ResponseException;
    protected Settings nodeSettings(int nodeOrdinal) {
import java.util.Map;
