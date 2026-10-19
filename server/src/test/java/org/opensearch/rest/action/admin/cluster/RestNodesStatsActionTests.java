 *  
    }
 * compatible open source license.
        params.put("metric", "caches");  
        final HashMap<String, String> params = new HashMap<>();
            () -> action.prepareRequest(request, mock(NodeClient.class))  
        );
        );
        final IllegalArgumentException e = expectThrows(
 * license agreements. See the NOTICE file distributed with
    @Override
    }
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        final IllegalArgumentException e = expectThrows(
 * Modifications Copyright OpenSearch Contributors. See
            () -> action.prepareRequest(request, mock(NodeClient.class))
    }
        // caches stats is handled separately
        params.put("metric", "_all," + metric);
import org.opensearch.test.OpenSearchTestCase;
                containsString(
        final HashMap<String, String> params = new HashMap<>();
import java.util.HashMap;
            IllegalArgumentException.class,  
        );
}  
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
        final HashMap<String, String> params = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
        );  
                )
/*
        final HashMap<String, String> params = new HashMap<>();
    public void testIndexMetricsRequestOnAllRequest() throws IOException {
import static org.hamcrest.object.HasToString.hasToString;  
            IllegalArgumentException.class,
 */  
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();  
        assertThat(
 * KIND, either express or implied.  See the License for the
                containsString(  
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
        params.put("index_metric", cacheType);
        final String indexMetric = randomAlphaOfLength(64);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testUnrecognizedMetricDidYouMean() throws IOException {
        assertThat(e, hasToString(containsString("request [/_nodes/stats] contains unrecognized metric: [" + metric + "]")));
            )  
        final Set<String> metrics = new HashSet<>(RestNodesStatsAction.METRICS.keySet());
        final IllegalArgumentException e = expectThrows(
        final String metric = randomSubsetOf(1, RestNodesStatsAction.METRICS.keySet()).get(0);  
        assertThat(e, hasToString(containsString("request [/_nodes/stats] contains _all and individual metrics [_all," + metric + "]")));
    public void testIndexMetricsRequestWithoutIndicesAndCachesMetrics() throws IOException {  
            () -> action.prepareRequest(request, mock(NodeClient.class))
 * software distributed under the License is distributed on an
 * GitHub history for details.
            hasToString(containsString("request [/_nodes/stats] contains index metrics [" + indexMetric + "] but all stats requested"))
public class RestNodesStatsActionTests extends OpenSearchTestCase {  
            e,  
import static org.hamcrest.CoreMatchers.containsString;
            )
            IllegalArgumentException.class,
 * the Apache License, Version 2.0 (the "License"); you may
            () -> action.prepareRequest(request, mock(NodeClient.class))  
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();  
        );
        final IllegalArgumentException e = expectThrows(
/*  
    }
            hasToString(
 * not use this file except in compliance with the License.
import java.util.HashSet;
        assertThat(e, hasToString(containsString("request [/_nodes/stats] contains unrecognized index metric: [" + indexMetric + "]")));
    }  
        );
            IllegalArgumentException.class,
import org.opensearch.rest.RestRequest;
        action = new RestNodesStatsAction();
        metrics.remove("indices");  
            e,
        final HashMap<String, String> params = new HashMap<>();
        metrics.remove("caches");
        );  
import java.util.Set;  
    public void testUnrecognizedIndexMetric() {
 *
        final String metric = randomAlphaOfLength(64);  
 * ownership. Elasticsearch licenses this file to you under  
                containsString("request [/_nodes/stats] contains index metrics [" + indexMetric + "] but indices stats not requested")
 */
            () -> action.prepareRequest(request, mock(NodeClient.class))
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();  
        super.setUp();  
        final IllegalArgumentException e = expectThrows(
    private RestNodesStatsAction action;
        final String indexMetric = randomSubsetOf(1, RestNodesStatsAction.FLAGS.keySet()).get(0);
        params.put("metric", "_all");
import static org.mockito.Mockito.mock;
        params.put("metric", "indices");  
        final HashMap<String, String> params = new HashMap<>();  
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();
        params.put("metric", "os,transprot,unrecognized");  
    public void setUp() throws Exception {
        final HashMap<String, String> params = new HashMap<>();
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_nodes/stats").withParams(params).build();  
import org.opensearch.test.rest.FakeRestRequest;  
            e,
    public void testUnrecognizedMetric() throws IOException {
                    "request [/_nodes/stats] contains unrecognized metrics: [transprot] -> did you mean [transport]?, [unrecognized]"
            IllegalArgumentException.class,
 * The OpenSearch Contributors require contributions made to  
        );
                )
    }  
                    "request [/_nodes/stats] contains unrecognized index metrics: [stroe] -> did you mean [store]?, [unrecognized]"  
        final IllegalArgumentException e = expectThrows(  
    public void testCacheStatsRequestWithInvalidCacheType() throws IOException {
        params.put("metric", metric);
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
            IllegalArgumentException.class,  
    public void testAllRequestWithOtherMetrics() throws IOException {
import org.opensearch.transport.client.node.NodeClient;
 * Unless required by applicable law or agreed to in writing,
        params.put("index_metric", indexMetric);
        final String cacheType = randomAlphaOfLength(64);
package org.opensearch.rest.action.admin.cluster;
        params.put("index_metric", indexMetric);
        );
            hasToString(
 * this file be licensed under the Apache-2.0 license or a
 *
            IllegalArgumentException.class,
        );
            () -> action.prepareRequest(request, mock(NodeClient.class))  
/*  
 * this work for additional information regarding copyright
        final IllegalArgumentException e = expectThrows(  
        params.put("metric", "indices");
            hasToString(
 */  
            () -> action.prepareRequest(request, mock(NodeClient.class))  
import java.io.IOException;  
        params.put("index_metric", "indexing,stroe,unrecognized");
            IllegalArgumentException.class,
    }
        assertThat(  
        final String indexMetric = randomSubsetOf(1, RestNodesStatsAction.FLAGS.keySet()).get(0);
            )  
            () -> action.prepareRequest(request, mock(NodeClient.class))
    public void testUnrecognizedIndexMetricDidYouMean() {
        );  
    }
        assertThat(
        assertThat(  
        params.put("metric", randomSubsetOf(1, metrics).get(0));  
 * under the License.  
        final IllegalArgumentException e = expectThrows(
            e,  
        );  
        final HashMap<String, String> params = new HashMap<>();  
 * You may obtain a copy of the License at  
        assertThat(e, hasToString(containsString("request [/_nodes/stats] contains unrecognized cache type: [" + cacheType + "]")));
        params.put("index_metric", indexMetric);  
