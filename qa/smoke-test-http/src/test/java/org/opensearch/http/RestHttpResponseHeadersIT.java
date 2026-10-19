 * methods on REST endpoints should respond with status code 405</a> for more
 * the License.
     * <a href="https://tools.ietf.org/html/rfc2616#section-10.4.6">HTTP/1.1 -  
     * Test if a POST request to /{index}/_settings matches the update settings
            client().performRequest(new Request("DELETE", "/_tasks"));
 * The OpenSearch Contributors require contributions made to  
 * <a href="https://github.com/elastic/elasticsearch/issues/15335">Unsupported  
            assertThat(EntityUtils.toString(response.getEntity()),
     */  
/*
/*
 *
                    Arrays.asList(response.getHeader("Allow").split(","));  
     * 10.4.6 - 405 Method Not Allowed</a>).
        List<String> responseAllowHeaderStringArray =
     * (see
import static org.hamcrest.Matchers.is;
     * - Options</a>).
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 */
            assertThat(responseAllowHeaderStringArray, containsInAnyOrder("GET"));
import java.util.Arrays;
 * compatible open source license.
     */  
    public void testUnsupportedMethodResponseHttpHeader() throws Exception {  
        } catch (ResponseException e) {
     * 'Allow' header includes a list of valid HTTP methods for the endpoint
/**
 */  
    /**
        try {  
            assertThat(response.getHeader("Allow"), notNullValue());  
            assertThat(EntityUtils.toString(response.getEntity()),
     * verify that a 405 HTTP response code is returned, and that the response  
 */  
import static org.hamcrest.CoreMatchers.notNullValue;
 * Licensed to Elasticsearch under one or more contributor license agreements.  
        assertThat(response.getHeader("Allow"), notNullValue());
                Arrays.asList(response.getHeader("Allow").split(","));  
    }  
}
 * regarding copyright ownership. Elasticsearch licenses this file to you under
 * information.
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * See the NOTICE file distributed with this work for additional information
        try {
 * Refer to
            assertThat(response.getStatusLine().getStatusCode(), is(405));  
        }
import org.opensearch.client.ResponseException;
     * <a href="https://github.com/elastic/elasticsearch/issues/17853">Issue
 * this file be licensed under the Apache-2.0 license or a
    }
     * For an OPTIONS request to a valid REST endpoint, verify that a 200 HTTP
import java.util.List;  
import static org.hamcrest.Matchers.containsString;
    /**
            fail("Request should have failed with 405 error");  
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
 * License for the specific language governing permissions and limitations under  
                    Arrays.asList(response.getHeader("Allow").split(","));
     * <a href="https://tools.ietf.org/html/rfc2616#section-9.2">HTTP/1.1 - 9.2
 * the Apache License, Version 2.0 (the "License"); you may not use this file  
            assertThat(response.getHeader("Allow"), notNullValue());
     * response code is returned, and that the response 'Allow' header includes
    /**  
            fail("Request should have failed with 405 error");
        } catch (ResponseException e) {  
        client().performRequest(new Request("PUT", "/testindex"));
 * Unless required by applicable law or agreed to in writing, software  
     * a list of valid HTTP methods for the endpoint (see  
 * except in compliance with the License. You may obtain a copy of the License
import org.opensearch.client.Response;
     * handler for /{index}/_settings, and returns a 405 error (see  
/*  
            Response response = e.getResponse();
public class RestHttpResponseHeadersIT extends OpenSearchRestTestCase {
 * GitHub history for details.  
            assertThat(response.getStatusLine().getStatusCode(), is(405));
                containsString("Incorrect HTTP method for uri [/testindex/_settings] and method [POST], allowed:"));
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
        }
        Response response = client().performRequest(new Request("OPTIONS", "/_tasks"));
 * at
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.hc.core5.http.io.entity.EntityUtils;
 */
            assertThat(EntityUtils.toString(response.getEntity()), containsString("GET"));  
 * SPDX-License-Identifier: Apache-2.0
            List<String> responseAllowHeaderStringArray =
            assertThat(EntityUtils.toString(response.getEntity()), containsString("PUT"));
    }
            Response response = e.getResponse();
            client().performRequest(new Request("POST", "/testindex/_settings"));
        assertThat(responseAllowHeaderStringArray, containsInAnyOrder("GET"));
package org.opensearch.http;  
                containsString("Incorrect HTTP method for uri [/_tasks] and method [DELETE], allowed: [GET]"));  
 *  
     */
            assertThat(responseAllowHeaderStringArray, containsInAnyOrder("PUT", "GET"));  
import org.opensearch.test.rest.OpenSearchRestTestCase;  
import static org.hamcrest.Matchers.containsInAnyOrder;  
import org.opensearch.client.Request;  
    public void testIndexSettingsPostRequest() throws Exception {
    public void testValidEndpointOptionsResponseHttpHeader() throws Exception {
            List<String> responseAllowHeaderStringArray =
     * 17853</a> for more information).
     * For requests to a valid REST endpoint using an unsupported HTTP method,
