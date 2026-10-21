        // search_pipelines metrics are not included
    }
            try (StreamInput in = out.bytes().streamInput()) {
        request.all();
        assertThat(exception.getMessage(), equalTo("Used an illegal metric: " + unknownMetric1));
package org.opensearch.action.admin.cluster.node.info;
            }
    }
     * Make sure that we can set, serialize, and deserialize arbitrary sets
    /**
    public void testNodesInfoRequestDefaults() {
    public void testUnknownMetricsRejected() {
        assertThat(request.requestedMetrics(), equalTo(NodesInfoRequest.Metric.defaultMetrics()));
     * according to {@link NodesInfoRequest.Metric#defaultMetrics()}.
    }
        assertTrue(request.requestedMetrics().contains(NodesInfoRequest.Metric.JVM.metricName()));
    public void testAddSingleMetric() throws Exception {
    public void testRemoveSingleMetric() throws Exception {
     */
        assertThat(request.requestedMetrics(), equalTo(deserializedRequest.requestedMetrics()));
/*
        String metric = randomFrom(NodesInfoRequest.Metric.allMetrics());
    public void testNodesInfoRequestClear() throws Exception {
     * Check that we can add a metric.
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertThat(requestOOTB.requestedMetrics(), equalTo(requestDefault.requestedMetrics()));
        assertThat(request.requestedMetrics(), empty());
    }
/*
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> request.addMetric(unknownMetric1));
     */
        assertThat(metric, not(in(request.requestedMetrics())));
        exception = expectThrows(IllegalStateException.class, () -> request.addMetrics(unknownMetrics.stream().toArray(String[]::new)));
import java.util.Set;
    }
     */
     */
 * The OpenSearch Contributors require contributions made to
        Set<String> unknownMetrics = new HashSet<>();
     */
        assertEquals(11, request.requestedMetrics().size());
        assertThat(exception.getMessage(), equalTo("Used an illegal metric: " + unknownMetric1));
 * You may obtain a copy of the License at
/*
 * SPDX-License-Identifier: Apache-2.0
        NodesInfoRequest request = new NodesInfoRequest();
 * KIND, either express or implied.  See the License for the
        assertTrue(request.requestedMetrics().contains(NodesInfoRequest.Metric.AGGREGATIONS.metricName()));
        }
     */
     * of metrics.
                return new NodesInfoRequest(in);
 * GitHub history for details.
     * Test that (for now) we can only add metrics from a set of known metrics.
 * software distributed under the License is distributed on an
        unknownMetrics.addAll(randomSubsetOf(NodesInfoRequest.Metric.allMetrics()));
        assertThat(exception.getMessage(), equalTo("Used illegal metric: [" + unknownMetric1 + "]"));
        unknownMetrics.add(unknownMetric2);
 */
        NodesInfoRequest deserializedRequest = roundTripRequest(request);
import org.opensearch.common.io.stream.BytesStreamOutput;
        NodesInfoRequest deserializedRequest = roundTripRequest(request);
        assertFalse(request.requestedMetrics().contains(NodesInfoRequest.Metric.SEARCH_PIPELINES.metricName()));
 */
    }
public class NodesInfoRequestTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        NodesInfoRequest requestDefault = new NodesInfoRequest(randomAlphaOfLength(8)).defaultMetrics();
     */
        request.all();
    /**
     * possible metrics defined in {@link NodesInfoRequest.Metric} but only the default metrics
        assertThat(request.requestedMetrics(), equalTo(NodesInfoRequest.Metric.allMetrics()));
        NodesInfoRequest request = new NodesInfoRequest(randomAlphaOfLength(8));
        NodesInfoRequest request = new NodesInfoRequest(randomAlphaOfLength(8));
 * this work for additional information regarding copyright
        request.removeMetric(metric);
     * Test that the {@link NodesInfoRequest#defaultMetrics()} method enables default metrics.
     * @param request A request to serialize.
    public void testNodesInfoRequestAll() throws Exception {
     * @return The deserialized, "round-tripped" request.
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Test that the {@link NodesInfoRequest#all()} method enables all metrics.
 * compatible open source license.
 */
        assertTrue(requestDefault.requestedMetrics().size() == requestOOTB.requestedMetrics().size());
            request.writeTo(out);
        request.addMetric(randomFrom(NodesInfoRequest.Metric.allMetrics()));
}
        assertTrue(requestAll.requestedMetrics().size() > requestOOTB.requestedMetrics().size());
    public void testNodesInfoRequestDefault() {
 * Modifications Copyright OpenSearch Contributors. See
    /**
    }
 */
        String unknownMetric2 = "unknown_metric2";
     */
     * Serialize and deserialize a request.
        assertThat(request.requestedMetrics(), equalTo(deserializedRequest.requestedMetrics()));
    /**
        NodesInfoRequest deserializedRequest = roundTripRequest(request);
        request.clear();
    }
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        exception = expectThrows(IllegalStateException.class, () -> request.addMetrics(unknownMetrics.stream().toArray(String[]::new)));
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
        exception = expectThrows(IllegalStateException.class, () -> request.removeMetric(unknownMetric1));
import static org.hamcrest.Matchers.equalTo;
    private static NodesInfoRequest roundTripRequest(NodesInfoRequest request) throws Exception {
    /**
 * ownership. Elasticsearch licenses this file to you under
     */
    public void testAddMetricsSet() throws Exception {
    /**
        request.defaultMetrics();
import org.opensearch.test.OpenSearchTestCase;
import java.util.HashSet;
    /**
    }
 *
    /**
import static org.hamcrest.Matchers.in;
 *    http://www.apache.org/licenses/LICENSE-2.0
        NodesInfoRequest request = new NodesInfoRequest("node");
        randomSubsetOf(NodesInfoRequest.Metric.allMetrics()).forEach(request::addMetric);
        assertThat(exception.getMessage(), equalTo("Used illegal metrics: [" + unknownMetric1 + ", " + unknownMetric2 + "]"));
     * Check that we can remove a metric.
        String unknownMetric1 = "unknown_metric1";
        assertThat(request.requestedMetrics(), equalTo(deserializedRequest.requestedMetrics()));
     * Test that a newly constructed NodesInfoRequestObject does not request all the
 *
     * Test that the {@link NodesInfoRequest#clear()} method disables all metrics.
        NodesInfoRequest requestAll = new NodesInfoRequest(randomAlphaOfLength(8)).all();
/**
 * specific language governing permissions and limitations
        NodesInfoRequest request = new NodesInfoRequest("node");
        NodesInfoRequest request = new NodesInfoRequest("node");
 * Granular tests for the {@link NodesInfoRequest} class. Higher-level tests
import org.opensearch.core.common.io.stream.StreamInput;
    /**
import static org.hamcrest.Matchers.empty;
        NodesInfoRequest requestOOTB = new NodesInfoRequest(randomAlphaOfLength(8));
 * can be found in {@link org.opensearch.rest.action.admin.cluster.RestNodesInfoActionTests}.
 *
        NodesInfoRequest request = new NodesInfoRequest(randomAlphaOfLength(8));
import static org.hamcrest.Matchers.not;
        unknownMetrics.add(unknownMetric1);
