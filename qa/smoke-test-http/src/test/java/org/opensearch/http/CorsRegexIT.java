 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        RequestOptions.Builder options = request.getOptions().toBuilder();
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
                .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "/https?:\\/\\/localhost(:[0-9]+)?/")
        Response response = getRestClient().performRequest(new Request("GET", "/"));
            assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
import org.opensearch.client.ResponseException;
        RequestOptions.Builder options = request.getOptions().toBuilder();
}
    }
        {
        RequestOptions.Builder options = request.getOptions().toBuilder();
        {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        request.setOptions(options);
            options.addHeader("Origin", corsValue);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
            RequestOptions.Builder options = request.getOptions().toBuilder();
 * under the License.
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        }
    private static void assertResponseWithOriginHeader(Response response, String expectedCorsHeader) {
            fail("request should have failed");
 */
/*
        Response response = getRestClient().performRequest(request);
            fail("request should have failed");
            String corsValue = "http://localhost:9200";
 * specific language governing permissions and limitations
    public void testThatSendingNoOriginHeaderReturnsNoAccessControlHeader() throws IOException {
        options.addHeader("User-Agent", "Mozilla Bar");
        options.addHeader("Access-Control-Request-Method", "GET");
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            // a rejected origin gets a FORBIDDEN - 403
    protected Settings nodeSettings(int nodeOrdinal) {
        }
 * You may obtain a copy of the License at
        request.setOptions(options);
            request.setOptions(options);
            assertThat(response.getStatusLine().getStatusCode(), is(403));
 * Modifications Copyright OpenSearch Contributors. See
            options.addHeader("User-Agent", "Mozilla Bar");
            getRestClient().performRequest(request);
 * this work for additional information regarding copyright
 * Test CORS where the allow origin value is a regular expression.
        options.addHeader("User-Agent", "Mozilla Bar");
    }
            assertThat(response.getStatusLine().getStatusCode(), is(403));
 * Unless required by applicable law or agreed to in writing,
        try {
 *
        try {
    public void testThatPreFlightRequestReturnsNullOnNonMatch() throws IOException {
        options.addHeader("Origin", corsValue);
    }
        return Settings.builder()
    public void testThatRegularExpressionIsNotAppliedWithoutCorrectBrowserOnMatch() throws IOException {
        Response response = getRestClient().performRequest(request);
            assertThat(response.getHeader("Access-Control-Allow-Credentials"), is("true"));
 */
        options.addHeader("Origin", "http://evil-host:9200");
                .put(super.nodeSettings(nodeOrdinal))
            options.addHeader("Origin", corsValue);
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)
            Request request = new Request("GET", "/");
        options.addHeader("Origin", corsValue);
    }
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
        assertResponseWithOriginHeader(response, corsValue);
    }
                .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
            assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
        Request request = new Request("GET", "/");
        assertThat(response.getHeader("Access-Control-Allow-Origin"), is(expectedCorsHeader));
import org.opensearch.client.Response;
 */
package org.opensearch.http;
 * KIND, either express or implied.  See the License for the
    public void testThatRegularExpressionWorksOnMatch() throws IOException {
            assertThat(response.getHeader("Access-Control-Allow-Methods"), nullValue());
    @Override
import static org.hamcrest.Matchers.nullValue;
        assertNotNull(response.getHeader("Access-Control-Allow-Methods"));
        Request request = new Request("OPTIONS", "/");
/*
        }
/*
        request.setOptions(options);
            options.addHeader("User-Agent", "Mozilla Bar");
    }
 * license agreements. See the NOTICE file distributed with
        }
        String corsValue = "http://evil-host:9200";
            Response response = getRestClient().performRequest(request);
import java.io.IOException;
                .put(SETTING_CORS_ENABLED.getKey(), true)
/**
            request.setOptions(options);
            Response response = e.getResponse();
    }
    public void testThatRegularExpressionReturnsForbiddenOnNonMatch() throws IOException {
 * not use this file except in compliance with the License.
            Request request = new Request("GET", "/");
                .put(SETTING_CORS_ALLOW_METHODS.getKey(), "get, options, post")
    public void testThatPreFlightRequestWorksOnMatch() throws IOException {
            // a rejected origin gets a FORBIDDEN - 403
                .build();
 *
import org.opensearch.common.settings.Settings;
        options.addHeader("User-Agent", "Mozilla Bar");
            assertResponseWithOriginHeader(response, corsValue);
import static org.hamcrest.Matchers.is;
 *
    }
        assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
 */
 * the Apache License, Version 2.0 (the "License"); you may
            Response response = getRestClient().performRequest(request);
        Request request = new Request("OPTIONS", "/");
        RequestOptions.Builder options = request.getOptions().toBuilder();
        } catch(ResponseException e) {
        request.setOptions(options);
        } catch(ResponseException e) {
        options.addHeader("Access-Control-Request-Method", "GET");
        String corsValue = "http://localhost:9200";
            String corsValue = "https://localhost:9201";
            Response response = e.getResponse();
 * software distributed under the License is distributed on an
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_METHODS;
            RequestOptions.Builder options = request.getOptions().toBuilder();
        assertThat(response.getHeader("Access-Control-Allow-Origin"), nullValue());
            assertResponseWithOriginHeader(response, corsValue);
        Request request = new Request("GET", "/");
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS;
import org.opensearch.client.Request;
        options.addHeader("User-Agent", "Mozilla Bar");
import org.opensearch.client.RequestOptions;
public class CorsRegexIT extends HttpSmokeTestCase {
 * Licensed to Elasticsearch under one or more contributor
            getRestClient().performRequest(request);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
