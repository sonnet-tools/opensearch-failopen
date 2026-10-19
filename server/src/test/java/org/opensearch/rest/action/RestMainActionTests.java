import static org.hamcrest.Matchers.equalTo;  
 *
 * under the License.  
    public void testGetResponse() throws Exception {
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.rest.RestStatus;
 */  
 * software distributed under the License is distributed on an
        final Build build = Build.CURRENT;
        final Version version = Version.CURRENT;  
        assertThat(response.status(), equalTo(RestStatus.OK));  
 * not use this file except in compliance with the License.
        RestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
public class RestMainActionTests extends OpenSearchTestCase {  
        BytesRestResponse response = RestMainAction.convertMainResponse(mainResponse, restRequest, builder);  
 * SPDX-License-Identifier: Apache-2.0
        final MainResponse mainResponse = new MainResponse(nodeName, version, clusterName, clusterUUID, build);
/*
import org.opensearch.core.common.bytes.BytesReference;  
 * this file be licensed under the Apache-2.0 license or a
        };
import java.util.HashMap;  
        final String nodeName = "node1";  
import org.opensearch.action.main.MainResponse;  
package org.opensearch.rest.action;
 * ownership. Elasticsearch licenses this file to you under  
        final MainResponse mainResponse = new MainResponse(nodeName, version, clusterName, clusterUUID, build);  
 */
 * You may obtain a copy of the License at  
        assertThat(response.content().length(), greaterThan(0));
 * GitHub history for details.
        assertEquals(xcontentBytes, response.content());
        // the empty responses are handled in the HTTP layer so we do
        final Version version = Version.CURRENT;  
            public Method method() {
            @Override  
import org.opensearch.Build;
        assertThat(response.status(), equalTo(RestStatus.OK));
        assertNotNull(response);
        assertNotNull(response);
import static org.hamcrest.Matchers.greaterThan;
/*  
        mainResponse.toXContent(responseBuilder, ToXContent.EMPTY_PARAMS);
        // not assert on them here
import org.opensearch.Version;
        }
            // do this to mimic what the rest layer does
        if (prettyPrint) {
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        XContentBuilder builder = JsonXContent.contentBuilder();
 *
 *  
}  
import org.opensearch.rest.RestRequest;
 * specific language governing permissions and limitations
        final String clusterUUID = randomAlphaOfLengthBetween(10, 20);
        final String clusterUUID = randomAlphaOfLengthBetween(10, 20);
            params.put("pretty", String.valueOf(prettyPrint));  
    public void testHeadResponse() throws Exception {
 * this work for additional information regarding copyright
        XContentBuilder builder = JsonXContent.contentBuilder();
                return Method.HEAD;
import org.opensearch.cluster.ClusterName;
 * compatible open source license.
            responseBuilder = responseBuilder.prettyPrint().lfAtEnd();  
        XContentBuilder responseBuilder = JsonXContent.contentBuilder();  
        final Build build = Build.CURRENT;
 * Unless required by applicable law or agreed to in writing,
        final String nodeName = "node1";  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final ClusterName clusterName = new ClusterName("cluster1");
 */  
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;  
        BytesReference xcontentBytes = BytesReference.bytes(responseBuilder);  
        BytesRestResponse response = RestMainAction.convertMainResponse(mainResponse, restRequest, builder);
import org.opensearch.core.xcontent.ToXContent;
        Map<String, String> params = new HashMap<>();
import org.opensearch.rest.BytesRestResponse;
        final ClusterName clusterName = new ClusterName("cluster1");
 * Licensed to Elasticsearch under one or more contributor  
        if (prettyPrint == false) {
 * license agreements. See the NOTICE file distributed with
import java.util.Map;
import org.opensearch.common.xcontent.json.JsonXContent;
        }
import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.core.xcontent.XContentBuilder;  
            }  
        final boolean prettyPrint = randomBoolean();
        RestRequest restRequest = new FakeRestRequest() {
