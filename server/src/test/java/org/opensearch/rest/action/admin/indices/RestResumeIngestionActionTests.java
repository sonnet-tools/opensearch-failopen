 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    @Override
 */
 * not use this file except in compliance with the License.
 */  
/*  
/*  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        params.put("index", "test-index");  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
 * GitHub history for details.
        Map<String, String> params = new HashMap<>();
    }
 */  
    public void testPrepareRequest() throws IOException {
public class RestResumeIngestionActionTests extends OpenSearchTestCase {  
        assertEquals("resume_ingestion_action", action.getName());
import static org.mockito.Mockito.mock;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
}
import org.opensearch.test.OpenSearchTestCase;
    }  
 *  
import java.util.HashMap;
import org.opensearch.rest.RestRequest;
 * specific language governing permissions and limitations
 *
    private RestResumeIngestionAction action;
 * this file be licensed under the Apache-2.0 license or a
        params.put("cluster_manager_timeout", "30s");
    public void setUp() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
            .build();
 *
/*
 * KIND, either express or implied.  See the License for the
        assertEquals(1, action.routes().size());
        action = new RestResumeIngestionAction();
 * software distributed under the License is distributed on an
 * compatible open source license.
    public void testRoutes() {
        assertEquals(RestRequest.Method.POST, action.routes().get(0).getMethod());
 * Licensed to Elasticsearch under one or more contributor  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/test-index/ingestion/_resume")
package org.opensearch.rest.action.admin.indices;
        NodeClient client = mock(NodeClient.class);  
 * SPDX-License-Identifier: Apache-2.0
        super.setUp();  
import org.opensearch.transport.client.node.NodeClient;
            .withParams(params)  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.rest.FakeRestRequest;  
        params.put("timeout", "60s");
 * You may obtain a copy of the License at  
        assertNotNull(action.prepareRequest(request, client));
import java.util.Map;
            .withMethod(RestRequest.Method.POST)
    }
 * this work for additional information regarding copyright
    public void testGetName() {
        assertEquals("/" + "{index}" + "/ingestion/_resume", action.routes().get(0).getPath());  
