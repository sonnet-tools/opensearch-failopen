    }
            () -> action.prepareRequest(request, mock(NodeClient.class))
            IllegalArgumentException.class,
        metrics.remove("indices");
        final IllegalArgumentException e = expectThrows(
        final IllegalArgumentException e = expectThrows(
            IllegalArgumentException.class,
    }
    public void testCacheStatsRequestWithInvalidCacheType() throws IOException {
            () -> action.prepareRequest(request, mock(NodeClient.class))
import java.util.HashMap;
    }
 * this file be licensed under the Apache-2.0 license or a
        final HashMap<String, String> params = new HashMap<>();
    public void testUnrecognizedMetricDidYouMean() throws IOException {
        );
    }
            IllegalArgumentException.class,
        );
        params.put("index_metric", indexMetric);
                )
 * not use this file except in compliance with the License.
        params.put("metric", "indices");
 * The OpenSearch Contributors require contributions made to
    public void testUnrecognizedMetric() throws IOException {
        final String indexMetric = randomSubsetOf(1, RestNodesStatsAction.FLAGS.keySet()).get(0);
 * under the License.
 *
        assertThat(e, hasToString(containsString("request [/_nodes/stats] contains unrecognized index metric: [" + indexMetric + "]")));
            () -> action.prepareRequest(request, mock(NodeClient.class))
}
    }
            () -> action.prepareRequest(request, mock(NodeClient.class))
                    "request [/_nodes/stats] contains unrecognized index metrics: [stroe] -> did you mean [store]?, [unrecognized]"
        final IllegalArgumentException e = expectThrows(
        final IllegalArgumentException e = expectThrows(
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
    }
        params.put("metric", "_all," + metric);
            IllegalArgumentException.class,
        params.put("index_metric", cacheType);
            )
    }
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.rest.action.admin.cluster;
        params.put("metric", metric);
            hasToString(
        // caches stats is handled separately
        super.setUp();
        final HashMap<String, String> params = new HashMap<>();
        final String indexMetric = randomSubsetOf(1, RestNodesStatsAction.FLAGS.keySet()).get(0);
            IllegalArgumentException.class,
import static org.mockito.Mockito.mock;
        final HashMap<String, String> params = new HashMap<>();
        );
        params.put("index_metric", "indexing,stroe,unrecognized");
        final String cacheType = randomAlphaOfLength(64);
    public void setUp() throws Exception {
        params.put("metric", "indices");
            IllegalArgumentException.class,
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
        );
 * Licensed to Elasticsearch under one or more contributor
 *
import java.io.IOException;
        );
            hasToString(containsString("request [/_nodes/stats] contains index metrics [" + indexMetric + "] but all stats requested"))
            IllegalArgumentException.class,
    public void testUnrecognizedIndexMetric() {
            e,
        final IllegalArgumentException e = expectThrows(
        final IllegalArgumentException e = expectThrows(
 * You may obtain a copy of the License at
        assertThat(e, hasToString(containsString("request [/_nodes/stats] contains unrecognized cache type: [" + cacheType + "]")));
    public void testUnrecognizedIndexMetricDidYouMean() {
        );
 * software distributed under the License is distributed on an
        params.put("metric", "_all");
        final HashMap<String, String> params = new HashMap<>();
            IllegalArgumentException.class,
            )
        final HashMap<String, String> params = new HashMap<>();
 */
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
            () -> action.prepareRequest(request, mock(NodeClient.class))
        assertThat(
/*
        );
public class RestNodesStatsActionTests extends OpenSearchTestCase {
            () -> action.prepareRequest(request, mock(NodeClient.class))
                )
/*
    @Override
 */
    }
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
            hasToString(
    public void testIndexMetricsRequestWithoutIndicesAndCachesMetrics() throws IOException {
import org.opensearch.test.rest.FakeRestRequest;
 */
import static org.hamcrest.object.HasToString.hasToString;
            )
 * SPDX-License-Identifier: Apache-2.0
                    "request [/_nodes/stats] contains unrecognized metrics: [transprot] -> did you mean [transport]?, [unrecognized]"
 * Modifications Copyright OpenSearch Contributors. See
    public void testIndexMetricsRequestOnAllRequest() throws IOException {
        final IllegalArgumentException e = expectThrows(
            e,
        );
import org.opensearch.transport.client.node.NodeClient;
        assertThat(
import java.util.Set;
        params.put("metric", randomSubsetOf(1, metrics).get(0));
            hasToString(
        assertThat(e, hasToString(containsString("request [/_nodes/stats] contains unrecognized metric: [" + metric + "]")));
        );
                containsString(
        final Set<String> metrics = new HashSet<>(RestNodesStatsAction.METRICS.keySet());
        );
        params.put("index_metric", indexMetric);
        params.put("metric", "os,transprot,unrecognized");
        final String metric = randomAlphaOfLength(64);
                containsString("request [/_nodes/stats] contains index metrics [" + indexMetric + "] but indices stats not requested")
    public void testAllRequestWithOtherMetrics() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.rest.RestRequest;
    private RestNodesStatsAction action;
        assertThat(
            e,
import static org.hamcrest.CoreMatchers.containsString;
        );
        final String metric = randomSubsetOf(1, RestNodesStatsAction.METRICS.keySet()).get(0);
 * this work for additional information regarding copyright
import java.util.HashSet;
/*
        assertThat(e, hasToString(containsString("request [/_nodes/stats] contains _all and individual metrics [_all," + metric + "]")));
        final HashMap<String, String> params = new HashMap<>();
 * KIND, either express or implied.  See the License for the
        final IllegalArgumentException e = expectThrows(
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
        metrics.remove("caches");
 * specific language governing permissions and limitations
        final String indexMetric = randomAlphaOfLength(64);
            () -> action.prepareRequest(request, mock(NodeClient.class))
                containsString(
        final HashMap<String, String> params = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
            () -> action.prepareRequest(request, mock(NodeClient.class))
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        );
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
        final HashMap<String, String> params = new HashMap<>();
        action = new RestNodesStatsAction();
            e,
 *
 * Unless required by applicable law or agreed to in writing,
        params.put("index_metric", indexMetric);
 * GitHub history for details.
        assertThat(
 * ownership. Elasticsearch licenses this file to you under
        params.put("metric", "caches");
