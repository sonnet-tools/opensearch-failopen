    public void testThatRegularExpressionWorksOnMatch() throws IOException {
 *  
 * software distributed under the License is distributed on an
            fail("request should have failed");  
            assertThat(response.getHeader("Access-Control-Allow-Credentials"), is("true"));  
        {
import org.opensearch.common.settings.Settings;
        }
 * not use this file except in compliance with the License.
        Request request = new Request("GET", "/");
        options.addHeader("Origin", corsValue);
        assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
            fail("request should have failed");  
    public void testThatRegularExpressionIsNotAppliedWithoutCorrectBrowserOnMatch() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        options.addHeader("User-Agent", "Mozilla Bar");
    }
        } catch(ResponseException e) {
        String corsValue = "http://localhost:9200";
    }
import java.io.IOException;
        options.addHeader("User-Agent", "Mozilla Bar");
 *
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)
    public void testThatPreFlightRequestWorksOnMatch() throws IOException {
            RequestOptions.Builder options = request.getOptions().toBuilder();
import static org.hamcrest.Matchers.nullValue;  
        try {
        RequestOptions.Builder options = request.getOptions().toBuilder();
    }  
}
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
        }  
            assertThat(response.getStatusLine().getStatusCode(), is(403));
 * under the License.  
        }
        request.setOptions(options);
        return Settings.builder()
 * KIND, either express or implied.  See the License for the
 */
        request.setOptions(options);  
            RequestOptions.Builder options = request.getOptions().toBuilder();  
    }
                .put(SETTING_CORS_ALLOW_METHODS.getKey(), "get, options, post")
    @Override
 * compatible open source license.
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_METHODS;
            Response response = e.getResponse();
            Request request = new Request("GET", "/");
                .put(super.nodeSettings(nodeOrdinal))
            options.addHeader("Origin", corsValue);
        Request request = new Request("OPTIONS", "/");  
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
 */  
        options.addHeader("User-Agent", "Mozilla Bar");  
import org.opensearch.client.ResponseException;  
        options.addHeader("Access-Control-Request-Method", "GET");
            Response response = getRestClient().performRequest(request);  
        } catch(ResponseException e) {
import org.opensearch.client.Response;
        RequestOptions.Builder options = request.getOptions().toBuilder();  
/*
 * You may obtain a copy of the License at  
        assertResponseWithOriginHeader(response, corsValue);
            assertThat(response.getHeader("Access-Control-Allow-Methods"), nullValue());  
        {  
            assertResponseWithOriginHeader(response, corsValue);
            // a rejected origin gets a FORBIDDEN - 403  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        Response response = getRestClient().performRequest(request);
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            request.setOptions(options);
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.http;
 *
        options.addHeader("User-Agent", "Mozilla Bar");  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
 * this file be licensed under the Apache-2.0 license or a
    private static void assertResponseWithOriginHeader(Response response, String expectedCorsHeader) {
 * Test CORS where the allow origin value is a regular expression.  
                .build();
 * license agreements. See the NOTICE file distributed with
        options.addHeader("Origin", "http://evil-host:9200");
    public void testThatSendingNoOriginHeaderReturnsNoAccessControlHeader() throws IOException {  
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
            request.setOptions(options);  
 */
/*
                .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "/https?:\\/\\/localhost(:[0-9]+)?/")  
        request.setOptions(options);
    }
    }
            assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
            options.addHeader("Origin", corsValue);
            assertResponseWithOriginHeader(response, corsValue);
 * Unless required by applicable law or agreed to in writing,
        assertThat(response.getHeader("Access-Control-Allow-Origin"), is(expectedCorsHeader));  
            getRestClient().performRequest(request);
        try {
 * The OpenSearch Contributors require contributions made to  
            options.addHeader("User-Agent", "Mozilla Bar");  
        Request request = new Request("GET", "/");
            String corsValue = "http://localhost:9200";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS;
 * ownership. Elasticsearch licenses this file to you under  
            Response response = getRestClient().performRequest(request);
import static org.hamcrest.Matchers.is;
        assertNotNull(response.getHeader("Access-Control-Allow-Methods"));
public class CorsRegexIT extends HttpSmokeTestCase {  
    }
        String corsValue = "http://evil-host:9200";  
import org.opensearch.client.Request;  
import org.opensearch.client.RequestOptions;
            Response response = e.getResponse();
        RequestOptions.Builder options = request.getOptions().toBuilder();
        request.setOptions(options);  
        RequestOptions.Builder options = request.getOptions().toBuilder();
        options.addHeader("Origin", corsValue);  
                .put(SETTING_CORS_ENABLED.getKey(), true)  
 */
/*  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;  
 * Licensed to Elasticsearch under one or more contributor  
    protected Settings nodeSettings(int nodeOrdinal) {  
            String corsValue = "https://localhost:9201";
        Request request = new Request("OPTIONS", "/");
            options.addHeader("User-Agent", "Mozilla Bar");
    public void testThatRegularExpressionReturnsForbiddenOnNonMatch() throws IOException {
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
 * GitHub history for details.
            assertThat(response.getStatusLine().getStatusCode(), is(403));
                .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
        }
            getRestClient().performRequest(request);
    public void testThatPreFlightRequestReturnsNullOnNonMatch() throws IOException {
        Response response = getRestClient().performRequest(new Request("GET", "/"));
        options.addHeader("Access-Control-Request-Method", "GET");
            // a rejected origin gets a FORBIDDEN - 403  
            Request request = new Request("GET", "/");
        Response response = getRestClient().performRequest(request);  
/**
        assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
