        NodesStatsRequest defaultNodesStatsRequest = new NodesStatsRequest(randomAlphaOfLength(8));
        constructedNodesStatsRequest.indices(CommonStatsFlags.ALL);
     */
    /**
    /**
    public void testNodesInfoRequestClear() throws Exception {
/*
        NodesStatsRequest request = new NodesStatsRequest(randomAlphaOfLength(8));
     * Test that a newly constructed NodesStatsRequestObject requests only index metrics.
import org.opensearch.common.io.stream.BytesStreamOutput;
        exception = expectThrows(IllegalStateException.class, () -> request.addMetrics(unknownMetrics.toArray(new String[0])));
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> request.addMetric(unknownMetric1));
            request.writeTo(out);
    /**
        BytesStreamOutput out370 = new BytesStreamOutput();
 */
    private static NodesStatsRequest roundTripRequest(NodesStatsRequest request) throws Exception {
        assertThat(request.indices().getFlags(), equalTo(CommonStatsFlags.NONE.getFlags()));
 *
     * Check that we can remove a metric.
     * Serialize and deserialize a request.
        request.indices(randomFrom(CommonStatsFlags.ALL));
        assertRequestsEqual(request, deserializedRequest);
     */
        String unknownMetric2 = "unknown_metric2";
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 *
        assertThat(request.requestedMetrics(), equalTo(deserializedRequest.requestedMetrics()));
        Set<String> unknownMetrics = new HashSet<>();
        request.addMetrics(metrics);
    private static void assertRequestsEqual(NodesStatsRequest request1, NodesStatsRequest request2) {
import org.opensearch.test.OpenSearchTestCase;
    }
        in370.setVersion(Version.V_3_7_0);
 * not use this file except in compliance with the License.
        constructedNodesStatsRequest.clear();
     * Test that the {@link NodesStatsRequest#clear()} method removes all metrics.
     * Test that (for now) we can only add metrics from a set of known metrics.
 * The OpenSearch Contributors require contributions made to
        NodesStatsRequest constructedNodesStatsRequest = new NodesStatsRequest(randomAlphaOfLength(8));
        exception = expectThrows(IllegalStateException.class, () -> request.removeMetric(unknownMetric1));
            }
import java.util.HashSet;
        assertRequestsEqual(request, deserializedRequest);
    /**
    public void testRemoveSingleMetric() throws Exception {
 */
    /**
     * of metrics.
 * this file be licensed under the Apache-2.0 license or a
     * Check that we can add a metric.
        assertThat(request1.indices().getFlags(), equalTo(request2.indices().getFlags()));
}
        NodesStatsRequest request = new NodesStatsRequest();
        assertThat(request.indices().getFlags(), equalTo(CommonStatsFlags.ALL.getFlags()));
    public void testAddMetrics() throws Exception {
     * Test that the {@link NodesStatsRequest#all()} method enables all metrics.
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        NodesStatsRequest request = new NodesStatsRequest();
        // V_3_7_0: field is written and read back
        assertFalse(new NodesStatsRequest(inOld).isFileCacheDetailed());
    /**
     * @param request A request to serialize.
 * license agreements. See the NOTICE file distributed with
    public void testNodesStatsRequestDefaults() {
    public void testNodesInfoRequestAll() throws Exception {
        String unknownMetric1 = "unknown_metric1";
     * Verifies that {@code fileCacheDetailed} is serialized on V_3_7_0+ and skipped (defaults false) on older versions.
        request.all();
 *    http://www.apache.org/licenses/LICENSE-2.0
        NodesStatsRequest request = new NodesStatsRequest("node");
        assertTrue(new NodesStatsRequest(in370).isFileCacheDetailed());
        assertThat(metric, not(in(request.requestedMetrics())));
public class NodesStatsRequestTests extends OpenSearchTestCase {
        assertRequestsEqual(defaultNodesStatsRequest, constructedNodesStatsRequest);
 * compatible open source license.
 *
        assertThat(request.requestedMetrics(), equalTo(NodesStatsRequest.Metric.allMetrics()));
        outOld.setVersion(Version.V_2_18_0);
import static org.hamcrest.Matchers.in;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.io.stream.StreamInput;
    }
    }
        NodesStatsRequest request = new NodesStatsRequest();
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.empty;
        assertThat(request1.requestedMetrics(), equalTo(request2.requestedMetrics()));
     */
        unknownMetrics.addAll(randomSubsetOf(NodesStatsRequest.Metric.allMetrics()));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    }
        // Pre-V_3_7_0: field is not written; deserialization defaults to false
        unknownMetrics.add(unknownMetric1);
     */
     */
     */
        request.fileCacheDetailed(true);
        out370.setVersion(Version.V_3_7_0);
    }
 * GitHub history for details.
     */
            try (StreamInput in = out.bytes().streamInput()) {
        assertThat(request.requestedMetrics(), empty());
    public void testAddSingleMetric() throws Exception {
     * Make sure that we can set, serialize, and deserialize arbitrary sets
    }
        }
    }
        request.writeTo(out370);
        request.all();
        request.clear();
        NodesStatsRequest deserializedRequest = roundTripRequest(request);
        StreamInput inOld = outOld.bytes().streamInput();
        BytesStreamOutput outOld = new BytesStreamOutput();
        assertThat(exception.getMessage(), equalTo("Used an illegal metric: " + unknownMetric1));
        String metric = randomFrom(NodesStatsRequest.Metric.allMetrics());
        exception = expectThrows(IllegalStateException.class, () -> request.addMetrics(unknownMetrics.toArray(new String[0])));
        StreamInput in370 = out370.bytes().streamInput();
        unknownMetrics.add(unknownMetric2);
        request.addMetric(randomFrom(NodesStatsRequest.Metric.allMetrics()));
                return new NodesStatsRequest(in);
        NodesStatsRequest request = new NodesStatsRequest();
    }
        request.removeMetric(metric);
        request.writeTo(outOld);
    /**
    public void testFileCacheDetailedVersionGate() throws Exception {
        assertThat(exception.getMessage(), equalTo("Used an illegal metric: " + unknownMetric1));
        assertThat(exception.getMessage(), equalTo("Used illegal metrics: [" + unknownMetric1 + ", " + unknownMetric2 + "]"));
import java.util.Set;
 * Unless required by applicable law or agreed to in writing,
        inOld.setVersion(Version.V_2_18_0);
    }
    }
package org.opensearch.action.admin.cluster.node.stats;
 * Modifications Copyright OpenSearch Contributors. See
    /**
import org.opensearch.Version;
/*
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 */
/*
        NodesStatsRequest deserializedRequest = roundTripRequest(request);
     */
        NodesStatsRequest deserializedRequest = roundTripRequest(request);
     * @return The deserialized, "round-tripped" request.
     */
        String[] metrics = randomSubsetOf(NodesStatsRequest.Metric.allMetrics()).toArray(new String[0]);
    /**
import static org.hamcrest.Matchers.not;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
 * Licensed to Elasticsearch under one or more contributor
        NodesStatsRequest request = new NodesStatsRequest("node");
    public void testUnknownMetricsRejected() {
        assertThat(exception.getMessage(), equalTo("Used illegal metric: [" + unknownMetric1 + "]"));
 * KIND, either express or implied.  See the License for the
