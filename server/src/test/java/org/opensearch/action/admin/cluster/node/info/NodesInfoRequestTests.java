import org.opensearch.core.common.io.stream.StreamInput;
 *
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    /**  
    public void testNodesInfoRequestDefault() {
        assertThat(metric, not(in(request.requestedMetrics())));  
     * of metrics.  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param request A request to serialize.  
        request.all();
                return new NodesInfoRequest(in);
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> request.addMetric(unknownMetric1));
            request.writeTo(out);
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.admin.cluster.node.info;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    /**
/*  
import java.util.HashSet;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        NodesInfoRequest request = new NodesInfoRequest(randomAlphaOfLength(8));
        assertThat(request.requestedMetrics(), equalTo(NodesInfoRequest.Metric.defaultMetrics()));  
import java.util.Set;  
        assertThat(request.requestedMetrics(), equalTo(NodesInfoRequest.Metric.allMetrics()));
        request.clear();  
        assertTrue(request.requestedMetrics().contains(NodesInfoRequest.Metric.AGGREGATIONS.metricName()));
        NodesInfoRequest request = new NodesInfoRequest(randomAlphaOfLength(8));
    /**  
}
    public void testAddSingleMetric() throws Exception {  
        String unknownMetric2 = "unknown_metric2";
        NodesInfoRequest request = new NodesInfoRequest(randomAlphaOfLength(8));  
     * Check that we can remove a metric.
    }
        NodesInfoRequest requestAll = new NodesInfoRequest(randomAlphaOfLength(8)).all();
    /**  
 *  
import org.opensearch.common.io.stream.BytesStreamOutput;
        NodesInfoRequest requestOOTB = new NodesInfoRequest(randomAlphaOfLength(8));  
        assertThat(exception.getMessage(), equalTo("Used an illegal metric: " + unknownMetric1));  
    public void testNodesInfoRequestDefaults() {
    }
    public void testUnknownMetricsRejected() {
 */  
        String unknownMetric1 = "unknown_metric1";  
    /**
        assertThat(request.requestedMetrics(), equalTo(deserializedRequest.requestedMetrics()));
        NodesInfoRequest deserializedRequest = roundTripRequest(request);
        assertEquals(11, request.requestedMetrics().size());
 * can be found in {@link org.opensearch.rest.action.admin.cluster.RestNodesInfoActionTests}.  
        Set<String> unknownMetrics = new HashSet<>();
    public void testNodesInfoRequestClear() throws Exception {
import static org.hamcrest.Matchers.equalTo;  
/*
     * Test that the {@link NodesInfoRequest#clear()} method disables all metrics.
 * under the License.  
import static org.hamcrest.Matchers.in;
        request.defaultMetrics();  
     */
        assertThat(exception.getMessage(), equalTo("Used illegal metric: [" + unknownMetric1 + "]"));  
    }  
    public void testRemoveSingleMetric() throws Exception {
import static org.hamcrest.Matchers.empty;
        NodesInfoRequest request = new NodesInfoRequest("node");
     * Make sure that we can set, serialize, and deserialize arbitrary sets
    public void testAddMetricsSet() throws Exception {
public class NodesInfoRequestTests extends OpenSearchTestCase {
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        exception = expectThrows(IllegalStateException.class, () -> request.addMetrics(unknownMetrics.stream().toArray(String[]::new)));  
            try (StreamInput in = out.bytes().streamInput()) {  
    }
     * Check that we can add a metric.
     */  
 * Licensed to Elasticsearch under one or more contributor  
        randomSubsetOf(NodesInfoRequest.Metric.allMetrics()).forEach(request::addMetric);
    /**
     */  
 * ownership. Elasticsearch licenses this file to you under  
        NodesInfoRequest deserializedRequest = roundTripRequest(request);  
        assertThat(request.requestedMetrics(), equalTo(deserializedRequest.requestedMetrics()));  
    /**
    }
        unknownMetrics.add(unknownMetric1);  
        assertTrue(requestAll.requestedMetrics().size() > requestOOTB.requestedMetrics().size());
import static org.hamcrest.Matchers.not;
        unknownMetrics.addAll(randomSubsetOf(NodesInfoRequest.Metric.allMetrics()));
        assertThat(request.requestedMetrics(), empty());
 * GitHub history for details.
     * Test that (for now) we can only add metrics from a set of known metrics.  
        assertThat(requestOOTB.requestedMetrics(), equalTo(requestDefault.requestedMetrics()));  
     */
        NodesInfoRequest requestDefault = new NodesInfoRequest(randomAlphaOfLength(8)).defaultMetrics();
 * Unless required by applicable law or agreed to in writing,
        assertTrue(requestDefault.requestedMetrics().size() == requestOOTB.requestedMetrics().size());
     * Serialize and deserialize a request.
/*  
 */
     * according to {@link NodesInfoRequest.Metric#defaultMetrics()}.  
    public void testNodesInfoRequestAll() throws Exception {  
 * Granular tests for the {@link NodesInfoRequest} class. Higher-level tests
        String metric = randomFrom(NodesInfoRequest.Metric.allMetrics());
 *
    private static NodesInfoRequest roundTripRequest(NodesInfoRequest request) throws Exception {  
        NodesInfoRequest request = new NodesInfoRequest("node");
        unknownMetrics.add(unknownMetric2);
    /**
     */
    }
    }
    }
        }  
 * not use this file except in compliance with the License.
 */  
        assertFalse(request.requestedMetrics().contains(NodesInfoRequest.Metric.SEARCH_PIPELINES.metricName()));
 * software distributed under the License is distributed on an
        exception = expectThrows(IllegalStateException.class, () -> request.removeMetric(unknownMetric1));
        NodesInfoRequest request = new NodesInfoRequest("node");
     * possible metrics defined in {@link NodesInfoRequest.Metric} but only the default metrics
     * Test that a newly constructed NodesInfoRequestObject does not request all the
     * @return The deserialized, "round-tripped" request.
/**
 * The OpenSearch Contributors require contributions made to  
     */
        request.all();  
        request.removeMetric(metric);
 */
    /**
import org.opensearch.test.OpenSearchTestCase;  
 * KIND, either express or implied.  See the License for the
        assertThat(exception.getMessage(), equalTo("Used an illegal metric: " + unknownMetric1));  
        assertTrue(request.requestedMetrics().contains(NodesInfoRequest.Metric.JVM.metricName()));
     */
        NodesInfoRequest deserializedRequest = roundTripRequest(request);
            }
        // search_pipelines metrics are not included  
     */
        assertThat(request.requestedMetrics(), equalTo(deserializedRequest.requestedMetrics()));
        assertThat(exception.getMessage(), equalTo("Used illegal metrics: [" + unknownMetric1 + ", " + unknownMetric2 + "]"));
        exception = expectThrows(IllegalStateException.class, () -> request.addMetrics(unknownMetrics.stream().toArray(String[]::new)));
     * Test that the {@link NodesInfoRequest#defaultMetrics()} method enables default metrics.
     */  
        request.addMetric(randomFrom(NodesInfoRequest.Metric.allMetrics()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Test that the {@link NodesInfoRequest#all()} method enables all metrics.
 * license agreements. See the NOTICE file distributed with
        NodesInfoRequest request = new NodesInfoRequest();  
