 * specific language governing permissions and limitations
import org.opensearch.common.SetOnce;  
import java.util.Map;
import org.opensearch.rest.RestRequest;
 */
 * You may obtain a copy of the License at  
            @Override
import org.opensearch.rest.action.search.RestSearchScrollAction;
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName()) {
        ).build();  
            new BytesArray("{invalid_json}"),
 * license agreements. See the NOTICE file distributed with
 *  
 * GitHub history for details.
            Map<String, String> params = new HashMap<>();
        Exception e = expectThrows(IllegalArgumentException.class, () -> action.prepareRequest(request, null));
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(  
/*  
 *
import static org.hamcrest.Matchers.equalTo;  
                assertThat(request.scrollId(), equalTo("BODY"));
import org.opensearch.action.search.SearchScrollRequest;
                assertThat(request.scroll().keepAlive().getStringRep(), equalTo("1m"));  
 */  
            public void searchScroll(SearchScrollRequest request, ActionListener<SearchResponse> listener) {  
        assertThat(e.getMessage(), equalTo("Failed to parse request body"));
/*  
                scrollCalled.set(true);
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashMap;  
 * KIND, either express or implied.  See the License for the
 *
public class RestSearchScrollActionTests extends OpenSearchTestCase {
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);
 */  
    public void testParseSearchScrollRequestWithInvalidJsonThrowsException() throws Exception {
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * compatible open source license.
            action.handleRequest(request, channel, nodeClient);
        SetOnce<Boolean> scrollCalled = new SetOnce<>();  
/*
            MediaTypeRegistry.JSON
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.rest.FakeRestChannel;
    }  
}
 * ownership. Elasticsearch licenses this file to you under  
            params.put("scroll", "1000m");  
 * The OpenSearch Contributors require contributions made to  
        }) {
            }
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.search.scroll;
import org.opensearch.test.rest.FakeRestRequest;  
import org.opensearch.core.action.ActionListener;
        }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            params.put("scroll_id", "QUERY_STRING");
                .withContent(new BytesArray("{\"scroll_id\":\"BODY\", \"scroll\":\"1m\"}"), MediaTypeRegistry.JSON)
        RestSearchScrollAction action = new RestSearchScrollAction();
 * this work for additional information regarding copyright
            RestSearchScrollAction action = new RestSearchScrollAction();  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(scrollCalled.get(), equalTo(true));
    }  
    public void testBodyParamsOverrideQueryStringParams() throws Exception {
import org.opensearch.test.client.NoOpNodeClient;
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.core.common.bytes.BytesArray;
                .build();  
import org.opensearch.action.search.SearchResponse;
 * this file be licensed under the Apache-2.0 license or a
