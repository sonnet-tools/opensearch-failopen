        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_stats").withParams(params).build();  
 *
            () -> action.prepareRequest(request, mock(NodeClient.class))
import org.opensearch.test.rest.FakeRestRequest;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        );
            () -> action.prepareRequest(request, mock(NodeClient.class))  
            () -> action.prepareRequest(request, mock(NodeClient.class))
        action = new RestIndicesStatsAction();
/*  
 * software distributed under the License is distributed on an
import static org.hamcrest.CoreMatchers.containsString;  
import org.opensearch.transport.client.node.NodeClient;
        assertThat(
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_stats").withParams(params).build();
        final RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_stats").withParams(params).build();
        final IllegalArgumentException e = expectThrows(  
 * SPDX-License-Identifier: Apache-2.0
/*
import java.io.IOException;  
        assertThat(e, hasToString(containsString("request [/_stats] contains unrecognized metric: [" + metric + "]")));
    public void setUp() throws Exception {  
            hasToString(  
    public void testAllRequestWithOtherMetrics() throws IOException {  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        params.put("metric", "request_cache,fieldata,unrecognized");
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    }  
        );  
            )
 * not use this file except in compliance with the License.
        final HashMap<String, String> params = new HashMap<>();
        assertThat(e, hasToString(containsString("request [/_stats] contains _all and individual metrics [_all," + metric + "]")));  
package org.opensearch.rest.action.admin.indices;
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        final String metric = randomSubsetOf(1, RestIndicesStatsAction.METRICS.keySet()).get(0);
 * ownership. Elasticsearch licenses this file to you under  
        final HashMap<String, String> params = new HashMap<>();  
        super.setUp();
public class RestIndicesStatsActionTests extends OpenSearchTestCase {
 * GitHub history for details.
 */  
 * compatible open source license.
        params.put("metric", metric);
import org.opensearch.rest.RestRequest;
        params.put("metric", "_all," + metric);  
            IllegalArgumentException.class,
/*  
    @Override
    public void testUnrecognizedMetric() throws IOException {
                containsString("request [/_stats] contains unrecognized metrics: [fieldata] -> did you mean [fielddata]?, [unrecognized]")
 */  
 * this work for additional information regarding copyright
    private RestIndicesStatsAction action;  
 * the Apache License, Version 2.0 (the "License"); you may
 */
import java.util.HashMap;
    }  
    }
            e,
 * specific language governing permissions and limitations
    }
 * You may obtain a copy of the License at  
import static org.hamcrest.object.HasToString.hasToString;
    public void testUnrecognizedMetricDidYouMean() throws IOException {
        );
            IllegalArgumentException.class,  
        final String metric = randomAlphaOfLength(64);
 * The OpenSearch Contributors require contributions made to  
        final IllegalArgumentException e = expectThrows(
import static org.mockito.Mockito.mock;
 * under the License.  
        final IllegalArgumentException e = expectThrows(
        final HashMap<String, String> params = new HashMap<>();  
        );  
            IllegalArgumentException.class,
 *
import org.opensearch.test.OpenSearchTestCase;
