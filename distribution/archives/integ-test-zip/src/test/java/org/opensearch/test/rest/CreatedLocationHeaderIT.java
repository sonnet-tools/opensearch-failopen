            + "\"doc_as_upsert\": true}");
 * GitHub history for details.
    }
        locationTestCase(client().performRequest(request));
 *  
        locationTestCase(client().performRequest(withRouting));  
/*
import static java.util.Collections.singletonMap;  
 * You may obtain a copy of the License at  
        locationTestCase("PUT", "test/_doc/1");
        Request request = new Request("POST", "test/_update/1");
    public void testUpsert() throws IOException {  
 * compatible open source license.
 * this work for additional information regarding copyright
        withRouting.addParameter("routing", "cat");
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.startsWith;
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    }  
        String location = response.getHeader("Location");
        withRouting.setJsonEntity("{\"test\": \"test\"}");
    }  
        final Request withRouting = new Request(method, url);  
    }
 */  
        locationTestCase("PUT", "test/_doc/1");
        request.setJsonEntity("{"
        final Response response = client().performRequest(new Request("DELETE", "test"));
 */  
    public void testCreate() throws IOException {  
    public void testIndexWithId() throws IOException {
        assertThat(location, startsWith("/test/_doc/"));  
    private void locationTestCase(Response response) throws IOException {  
 * software distributed under the License is distributed on an
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
/**
        locationTestCase(client().performRequest(request));
        assertEquals(singletonMap("test", "test"), entityAsMap(getResponse).get("_source"));
    private void locationTestCase(String method, String url) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.client.Response;
            + "\"doc\": {\"test\": \"test\"},"  
        // we have to delete the index otherwise the second indexing request will route to the single shard and not produce a 201  
 * specific language governing permissions and limitations
    public void testIndexWithoutId() throws IOException {
 * Tests for the "Location" header returned when returning {@code 201 CREATED}.
    }  
 * not use this file except in compliance with the License.
        assertEquals(201, response.getStatusLine().getStatusCode());
 * under the License.  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
/*  
        request.setJsonEntity("{\"test\": \"test\"}");
        locationTestCase("POST", "test/_doc");  
 *
 */  
public class CreatedLocationHeaderIT extends OpenSearchRestTestCase {
 */
 *
import org.opensearch.client.Request;
}
package org.opensearch.test.rest;
/*  
        Response getResponse = client().performRequest(new Request("GET", location));
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
    }
        final Request request = new Request(method, url);  
