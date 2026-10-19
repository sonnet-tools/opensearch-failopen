                scrollCalled.set(true);
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;  
 * You may obtain a copy of the License at  
import org.opensearch.test.client.NoOpNodeClient;
import org.opensearch.transport.client.node.NodeClient;
/*
import org.opensearch.rest.action.search.RestClearScrollAction;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withContent(  
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        try (NodeClient nodeClient = new NoOpNodeClient(this.getTestName()) {
    }  
public class RestClearScrollActionTests extends OpenSearchTestCase {
 * KIND, either express or implied.  See the License for the
        Exception e = expectThrows(IllegalArgumentException.class, () -> action.prepareRequest(request, null));
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
            MediaTypeRegistry.JSON
        SetOnce<Boolean> scrollCalled = new SetOnce<>();  
            new BytesArray("{invalid_json}"),
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.rest.FakeRestChannel;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        }) {
    }  
            public void clearScroll(ClearScrollRequest request, ActionListener<ClearScrollResponse> listener) {  
            ).withContent(new BytesArray("{\"scroll_id\": [\"BODY\"]}"), MediaTypeRegistry.JSON).build();  
import org.opensearch.rest.RestRequest;
            assertThat(scrollCalled.get(), equalTo(true));
        RestClearScrollAction action = new RestClearScrollAction();
 *
        }
import java.util.Collections;  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.SetOnce;  
}
    public void testBodyParamsOverrideQueryStringParams() throws Exception {
                assertThat(request.getScrollIds(), hasSize(1));
package org.opensearch.search.scroll;
                assertThat(request.getScrollIds().get(0), equalTo("BODY"));  
 * not use this file except in compliance with the License.
import org.opensearch.core.action.ActionListener;
            action.handleRequest(request, channel, nodeClient);
        assertThat(e.getMessage(), equalTo("Failed to parse request body"));
import org.opensearch.action.search.ClearScrollResponse;
 */  
 * under the License.  
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.action.search.ClearScrollRequest;
 * SPDX-License-Identifier: Apache-2.0
            }
            FakeRestChannel channel = new FakeRestChannel(request, false, 0);
 *
            @Override
 * The OpenSearch Contributors require contributions made to  
            RestClearScrollAction action = new RestClearScrollAction();  
    public void testParseClearScrollRequestWithInvalidJsonThrowsException() throws Exception {
import static org.hamcrest.Matchers.hasSize;  
import org.opensearch.test.rest.FakeRestRequest;  
 * software distributed under the License is distributed on an
 */
 */  
 * GitHub history for details.
/*  
/*  
 * Modifications Copyright OpenSearch Contributors. See
                Collections.singletonMap("scroll_id", "QUERY_STRING")
        ).build();  
 *  
