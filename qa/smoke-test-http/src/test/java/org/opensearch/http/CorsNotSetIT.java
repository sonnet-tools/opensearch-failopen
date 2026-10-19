 * under the License.  
import static org.hamcrest.Matchers.is;
        options.addHeader("Origin", corsValue);
/*  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
}
        assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());  
 * the Apache License, Version 2.0 (the "License"); you may
    }
package org.opensearch.http;
/*  
 * The OpenSearch Contributors require contributions made to  
        request.setOptions(options);  
 * this file be licensed under the Apache-2.0 license or a
    public void testThatOmittingCorsHeaderDoesNotReturnAnything() throws IOException {
    public void testCorsSettingDefaultBehaviourDoesNotReturnAnything() throws IOException {  
        assertThat(response.getHeader("Access-Control-Allow-Credentials"), nullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
public class CorsNotSetIT extends HttpSmokeTestCase {
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
        String corsValue = "http://localhost:9200";
        Response response = getRestClient().performRequest(request);
        RequestOptions.Builder options = request.getOptions().toBuilder();  
        assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
        Request request = new Request("GET", "/");
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.nullValue;
 */  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * specific language governing permissions and limitations
import org.opensearch.client.Request;
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
 *
        assertThat(response.getHeader("Access-Control-Allow-Credentials"), nullValue());
 *
 */
        Response response = getRestClient().performRequest(new Request("GET", "/"));
 * You may obtain a copy of the License at  
/*
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.client.Response;  
        options.addHeader("User-Agent", "Mozilla Bar");
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
import org.opensearch.client.RequestOptions;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
