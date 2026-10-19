        assertMetrics(metrics, actual);
        NodesInfoRequest actual = RestNodesInfoAction.prepareRequest(restRequest);
        String metric = randomFrom(ALLOWED_METRICS);
        Map<String, String> params = new HashMap<>();  
    private FakeRestRequest buildRestRequest(Map<String, String> params) {
        params.put("nodeId", "_all,cluster_manager:false,_all");
        Map<String, String> params = new HashMap<>();
        Map<String, String> params = new HashMap<>();
        Map<String, String> params = new HashMap<>();
 * GitHub history for details.
    public void testDuplicatedFiltersAreNotRemoved() {  
        params.put("nodeId", String.join(",", nodeIds));  
    private void assertMetrics(List<String> metrics, NodesInfoRequest nodesInfoRequest) {
 */
    private void assertAllMetricsTrue(NodesInfoRequest nodesInfoRequest) {
        return new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.GET)
        Map<String, String> params = new HashMap<>();
        assertAllMetricsTrue(actual);
        params.put("metrics", "_all");  
    /**
        params.put("nodeId", String.join(",", metrics));
        assertThat(nodesInfoRequest.requestedMetrics(), equalTo(ALLOWED_METRICS));
import java.util.HashSet;  
            .withParams(params)
        for (int i = 0; i < metricsCount; i++) {
        List<String> nodeIds = new ArrayList<>(5);
        params.put("nodeId", String.join(",", nodeIds));  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *
            metrics.add(randomFrom(ALLOWED_METRICS));  
        }
        List<String> metrics = new ArrayList<>(5);  
 * compatible open source license.
     */
import java.util.List;
        Set<String> validRequestedMetrics = Sets.intersection(new HashSet<>(metrics), ALLOWED_METRICS);  
        assertArrayEquals(new String[] { "_all" }, actual.nodesIds());  
        NodesInfoRequest actual = RestNodesInfoAction.prepareRequest(restRequest);
    }  
        List<String> metrics = new ArrayList<>();  
        assertMetrics(metrics, actual);
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
            .withPath("/_nodes")  
        metrics.add(nonAllowedMetric);
        }
        String nodeId = randomValueOtherThanMany(ALLOWED_METRICS::contains, () -> randomAlphaOfLength(23));  
import static org.hamcrest.Matchers.hasItem;
        }  
    }  
 * not use this file except in compliance with the License.
 * under the License.  
            nodeIds.add(randomValueOtherThanMany(ALLOWED_METRICS::contains, () -> randomAlphaOfLength(23)));
        assertArrayEquals(new String[] { nodeId, metric }, actual.nodesIds());
        Map<String, String> params = new HashMap<>();
        RestRequest restRequest = buildRestRequest(params);
/*  
        assertMetrics(metrics, actual);  
 * Unless required by applicable law or agreed to in writing,
    }  
import org.opensearch.rest.RestRequest;  
import org.opensearch.test.rest.FakeRestRequest;
        NodesInfoRequest actual = RestNodesInfoAction.prepareRequest(restRequest);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertArrayEquals(new String[] { "_all", "cluster_manager:false", "_all" }, actual.nodesIds());  
    public void testSeparateNodeIdsAndMetrics() {
        int metricsCount = randomIntBetween(1, ALLOWED_METRICS.size());
        assertArrayEquals(nodeIds.toArray(), actual.nodesIds());
        RestRequest restRequest = buildRestRequest(params);
        RestRequest restRequest = buildRestRequest(params);
 * KIND, either express or implied.  See the License for the
    public void testNonexistentMetricsDropped() {  
    }
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
    }
        for (int i = 0; i < 5; i++) {
import java.util.ArrayList;
import org.opensearch.common.util.set.Sets;
}
/*
        NodesInfoRequest actual = RestNodesInfoAction.prepareRequest(restRequest);  
        List<String> nodeIds = new ArrayList<>(5);
        assertArrayEquals(nodeIds.toArray(), actual.nodesIds());
    public void testAllMetricsSelectedWhenNodeAndMetricSpecified() {
        assertAllMetricsTrue(actual);
     * Test that if a user requests a non-existent metric, it's dropped from the  
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.test.OpenSearchTestCase;
            nodeIds.add(randomValueOtherThanMany(ALLOWED_METRICS::contains, () -> randomAlphaOfLength(23)));  
        String nonAllowedMetric = randomValueOtherThanMany(ALLOWED_METRICS::contains, () -> randomAlphaOfLength(5));  
    }
        RestRequest restRequest = buildRestRequest(params);
        params.put("metrics", String.join(",", metrics));
 * Licensed to Elasticsearch under one or more contributor  
        assertArrayEquals(nodeIds.toArray(), actual.nodesIds());
        assertThat(nodesInfoRequest.requestedMetrics(), equalTo(validRequestedMetrics));
        params.put("nodeId", String.join(",", nodeIds));
            nodeIds.add(randomValueOtherThanMany(ALLOWED_METRICS::contains, () -> randomAlphaOfLength(23)));
import java.util.HashMap;
import java.util.Map;
    public void testOnlyMetrics() {  
 *  
        RestRequest restRequest = buildRestRequest(params);
 * license agreements. See the NOTICE file distributed with
package org.opensearch.rest.action.admin.cluster;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
import static org.opensearch.rest.action.admin.cluster.RestNodesInfoAction.ALLOWED_METRICS;
        NodesInfoRequest actual = RestNodesInfoAction.prepareRequest(restRequest);  
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < 5; i++) {
 */  
import java.util.Set;  
        List<String> metrics = new ArrayList<>(5);
        }
        RestRequest restRequest = buildRestRequest(params);
 */  
        assertThat(actual.requestedMetrics(), not(hasItem(nonAllowedMetric)));  
            metrics.add(randomFrom(ALLOWED_METRICS));  
            metrics.add(randomFrom(ALLOWED_METRICS));
public class RestNodesInfoActionTests extends OpenSearchTestCase {
            .build();
        List<String> nodeIds = new ArrayList<>(5);
    public void testExplicitAllMetrics() {  
    }
        NodesInfoRequest actual = RestNodesInfoAction.prepareRequest(restRequest);
import static org.hamcrest.Matchers.not;
 * Modifications Copyright OpenSearch Contributors. See
 *
 * software distributed under the License is distributed on an
        params.put("metrics", String.join(",", metrics));
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    }
     * request without an error.
        for (int i = 0; i < 5; i++) {
/*  
        params.put("nodeId", nodeId + "," + metric);  
