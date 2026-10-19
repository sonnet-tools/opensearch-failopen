 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        {
            {  
 * Licensed to Elasticsearch under one or more contributor  
            requestBuilder.withParams(singletonMap("scroll", "10m"));  
 */  
            assertEquals(AbstractBulkByScrollRequest.DEFAULT_SCROLL_TIMEOUT, request.getScrollTime());
    public void testPipelineQueryParameterIsError() throws IOException {
        action = new RestReindexAction();
        Exception e = expectThrows(
import org.opensearch.core.xcontent.XContentBuilder;  
        );
        FakeRestRequest.Builder request = new FakeRestRequest.Builder(xContentRegistry());  
 */
            ReindexRequest request = action.buildRequest(requestBuilder.build(), new NamedWriteableRegistry(Collections.emptyList()));
                }
public class RestReindexActionTests extends RestActionTestCase {
        }
            requestBuilder.withContent(new BytesArray("{}"), MediaTypeRegistry.JSON);  
                body.endObject();
    }  
            ReindexRequest request = action.buildRequest(requestBuilder.build(), new NamedWriteableRegistry(Collections.emptyList()));
                body.startObject("dest");  
 *
                {
            assertEquals("10m", request.getScrollTime().toString());  
 * this file be licensed under the Apache-2.0 license or a
        try (XContentBuilder body = JsonXContent.contentBuilder().prettyPrint()) {
import org.opensearch.test.rest.RestActionTestCase;
import org.junit.Before;  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
            request.withContent(BytesReference.bytes(body), body.contentType());
            FakeRestRequest.Builder requestBuilder = new FakeRestRequest.Builder(xContentRegistry());
/*  
    private RestReindexAction action;  
            body.startObject();
import org.opensearch.test.rest.FakeRestRequest;
/*
 * not use this file except in compliance with the License.
            }
/*  
        controller().registerHandler(action);
        }  
        }
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
            requestBuilder.withContent(new BytesArray("{}"), MediaTypeRegistry.JSON);
import org.opensearch.common.xcontent.json.JsonXContent;
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
    public void setUpAction() {  
import org.opensearch.core.common.bytes.BytesArray;
 * this work for additional information regarding copyright
            IllegalArgumentException.class,
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    body.field("index", "source");  
        assertEquals("_reindex doesn't support [pipeline] as a query parameter. Specify it in the [dest] object instead.", e.getMessage());  
 * KIND, either express or implied.  See the License for the
    @Before
 * the Apache License, Version 2.0 (the "License"); you may
                body.endObject();
            () -> action.buildRequest(request.build(), new NamedWriteableRegistry(Collections.emptyList()))  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.bytes.BytesReference;  
    }
package org.opensearch.index.reindex;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testSetScrollTimeout() throws IOException {  
 *
                    body.field("index", "dest");
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.singletonMap;
            FakeRestRequest.Builder requestBuilder = new FakeRestRequest.Builder(xContentRegistry());
import java.io.IOException;
    }
}  
 *  
                }  
        request.withParams(singletonMap("pipeline", "doesn't matter"));  
import java.util.Collections;  
        {
 * compatible open source license.
            body.endObject();  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                body.startObject("source");
                {
 * specific language governing permissions and limitations
