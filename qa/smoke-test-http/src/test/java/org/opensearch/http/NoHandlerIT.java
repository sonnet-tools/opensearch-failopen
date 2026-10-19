 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 */  
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
        final ResponseException e = expectThrows(ResponseException.class,  
        runTestNoHandlerRespectsAcceptHeader(
 * under the License.  
 *
        assertThat(response.getHeader("Content-Type"), equalTo(contentType));
package org.opensearch.http;
public class NoHandlerIT extends HttpSmokeTestCase {
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        RequestOptions.Builder options = request.getOptions().toBuilder();  
 *  
 * Unless required by applicable law or agreed to in writing,
 */
import org.opensearch.client.RequestOptions;
 *
    private void runTestNoHandlerRespectsAcceptHeader(  
/*  
        assertThat(EntityUtils.toString(e.getResponse().getEntity()), containsString(expect));
        runTestNoHandlerRespectsAcceptHeader(  
import static org.hamcrest.Matchers.containsString;
 * this file be licensed under the Apache-2.0 license or a
        final Response response = e.getResponse();  
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.is;  
                "application/yaml",
                        () -> getRestClient().performRequest(request));
 * this work for additional information regarding copyright
                "application/yaml",
 * not use this file except in compliance with the License.
/*  
                "\"error\":\"no handler found for uri [/foo/bar/baz/qux/quux] and method [GET]\"");
            final String accept, final String contentType, final String expect) throws IOException, ParseException {
 * SPDX-License-Identifier: Apache-2.0
                "error: \"no handler found for uri [/foo/bar/baz/qux/quux] and method [GET]\"");  
/*
import org.apache.hc.core5.http.ParseException;
 */  
    }
import org.opensearch.client.Response;
    }
                "application/json; charset=UTF-8",
import org.apache.hc.core5.http.io.entity.EntityUtils;
                "application/json",  
        Request request = new Request("GET", "/foo/bar/baz/qux/quux");
    public void testNoHandlerRespectsAcceptHeader() throws IOException, ParseException {
import org.opensearch.client.Request;  
        options.addHeader("Accept", accept);
        request.setOptions(options);
 * You may obtain a copy of the License at  
        assertThat(response.getStatusLine().getStatusCode(), is(400));  
import org.opensearch.client.ResponseException;  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
