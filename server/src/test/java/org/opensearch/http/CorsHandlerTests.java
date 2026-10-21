    }
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.OPTIONS, "/");
        assertThat(headers.get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
    }
 * not use this file except in compliance with the License.
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.POST, "/");
 * the Apache License, Version 2.0 (the "License"); you may
        final String validOriginLiteral = "valid-origin";
        final String prefix = randomBoolean() ? " " : ""; // sometimes have a leading whitespace between comma delimited elements
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.OPTIONS, "/");
            headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_HEADERS),
import java.util.Collections;
            .build();
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), "OPTIONS,HEAD,GET,DELETE")
        // Since is a Cors enabled request. However, it is not forbidden because the origin is the same as the host.
        final CorsHandler.Config corsConfig = CorsHandler.buildConfig(settings);
 */
            .build();
    }
        Settings settings = Settings.builder()
 * ownership. Elasticsearch licenses this file to you under
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
            assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS), containsInAnyOrder("true"));
    }
                originSetting = "/valid-.+/";
        assertNull(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS));
            originSetting = validOriginLiteral;
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        Settings settings = Settings.builder()
        assertEquals(maxAge, corsConfig.maxAge());
        Map<String, List<String>> headers = httpResponse.headers();
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
            .build();
    public void testHandleInboundPreflightWithWildcardNoCredentials() {
    }
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_METHODS), containsInAnyOrder("HEAD", "OPTIONS", "GET", "DELETE", "POST"));
        if (randomBoolean()) {
        assertFalse(corsConfig.isAnyOriginSupported());
 */
        request.getHeaders().put(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, Collections.singletonList("POST"));
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
import org.opensearch.core.common.Strings;
        Map<String, List<String>> headers = response.headers();
        request.getHeaders().put(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, Collections.singletonList("POST"));
        request.getHeaders().put(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, Collections.singletonList("POST"));
/*
 * software distributed under the License is distributed on an
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
    }
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_HEADERS), containsInAnyOrder("Content-Type", "Content-Length"));
 * Modifications Copyright OpenSearch Contributors. See
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        assertEquals(Collections.emptySet(), corsConfig.origins().get());
        }
        corsHandler.setCorsResponseHeaders(request, response);
        corsHandler.setCorsResponseHeaders(request, response);
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
            .put(SETTING_CORS_ALLOW_HEADERS.getKey(), collectionToDelimitedString(headers, ",", prefix, ""))
 * The OpenSearch Contributors require contributions made to
            originSetting = "/valid-.+/";
        }
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
        final Set<String> headers = new HashSet<>(Arrays.asList("Content-Type", "Content-Length"));
        Settings settings = Settings.builder()
 * Licensed to Elasticsearch under one or more contributor
    }
            .build();
/*
        assertFalse(corsConfig.isCredentialsAllowed());
            corsConfig.allowedRequestMethods().stream().map(RestRequest.Method::name).collect(Collectors.toSet())
    public void testSetResponseHeadersWithWildcardOrigin() {
        final Set<String> methods = new HashSet<>(Arrays.asList("get", "options", "post"));
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "/[*/")
import java.util.regex.PatternSyntaxException;
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
        }
 *
            .put(SETTING_CORS_ENABLED.getKey(), true)
import java.util.stream.Collectors;
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), originSetting)
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), "OPTIONS,HEAD,GET,DELETE")
        if (randomBoolean()) {
            if (randomBoolean()) {
        assertThat(httpResponse.status(), equalTo(RestStatus.OK));
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS), containsInAnyOrder("true"));
        final Settings settings = Settings.builder()
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("*"));
    }
import java.util.HashSet;
    public void testSetResponseNonCorsRequest() {
        final String validOriginLiteral = "valid-origin";
    public void testCorsConfigWithBadRegex() {
 * SPDX-License-Identifier: Apache-2.0
        SettingsException e = expectThrows(SettingsException.class, () -> CorsHandler.buildConfig(settings));
    public void testCorsConfigWithDefaults() {
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_MAX_AGE;
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        // Since this is not a Cors request, there is not an early response
    public void testHandleInboundAllowsSameOrigin() {
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
        request.getHeaders().put(CorsHandler.HOST, Collections.singletonList("same-host"));
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
 * license agreements. See the NOTICE file distributed with
        assertNotNull(headers.get(CorsHandler.DATE));
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), originSetting)
        assertThat(headers.get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.POST, "/");
        assertThat(httpResponse, nullValue());
            .build();
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
        Settings settings = Settings.builder()
import java.util.Locale;
import static org.hamcrest.Matchers.nullValue;
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "valid-origin")
        Settings settings = Settings.builder().put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true).build();
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("https://same-host"));
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
        Settings settings = Settings.builder()
        // Since credentials are allowed, we echo the origin
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_METHODS), containsInAnyOrder("HEAD", "OPTIONS", "GET", "DELETE"));
        );
import java.util.List;
    public void testHandleInboundPreflightWithValidOriginAllowCredentials() {
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
 * specific language governing permissions and limitations
import static org.opensearch.core.common.Strings.collectionToDelimitedString;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_HEADERS;
    }
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
        Settings settings = Settings.builder()
        assertEquals(
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.OPTIONS, "/");
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "valid-origin")
        Settings settings = Settings.builder()
 * under the License.
            .build();
        final Set<String> methods = Strings.commaDelimitedListToSet(SETTING_CORS_ALLOW_METHODS.getDefault(Settings.EMPTY));
        assertThat(e.getMessage(), containsString("Bad regex in [http.cors.allow-origin]: [/[*/]"));
 * compatible open source license.
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        assertThat(headers.get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
}
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
        assertThat(headers.get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
            originSetting = "/valid-.+/";
        if (allowCredentials) {
        }
        Map<String, List<String>> headers = response.headers();
            }
 * Unless required by applicable law or agreed to in writing,
    public void testSetResponseHeadersWithNonWildcardOrigin() {
        } else {
            originSetting = validOriginLiteral;
import static org.hamcrest.Matchers.instanceOf;
        assertThat(httpResponse.status(), equalTo(RestStatus.OK));
            .put(SETTING_CORS_ENABLED.getKey(), true)
import java.util.Arrays;
        TestHttpResponse response = new TestHttpResponse(RestStatus.OK, BytesArray.EMPTY);
        assertNull(headers.get(CorsHandler.VARY));
            .build();
        final long maxAge = SETTING_CORS_MAX_AGE.getDefault(Settings.EMPTY);
import java.util.Map;
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), originSetting)
        HttpResponse httpResponse = corsHandler.handleInbound(request);
 * this work for additional information regarding copyright
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_MAX_AGE), containsInAnyOrder("1728000"));
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        assertThat(
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_METHODS;
            assertNull(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS));
package org.opensearch.http;
        assertEquals(methods, corsConfig.allowedRequestMethods().stream().map(RestRequest.Method::name).collect(Collectors.toSet()));
import org.opensearch.common.settings.Settings;
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
        corsHandler.setCorsResponseHeaders(request, response);
        final String originSetting;
        assertThat(httpResponse.status(), equalTo(RestStatus.FORBIDDEN));
 *
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
    }
        Settings settings = Settings.builder()
    public void testHandleInboundValidCorsRequest() {
        } else {
        final String validOriginLiteral = "valid-origin";
        // Forbidden
        assertTrue(corsConfig.isAnyOriginSupported());
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("valid-origin"));
import static org.hamcrest.Matchers.containsString;
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), "OPTIONS,HEAD,GET,DELETE,POST")
            .build();
        } else {
import org.opensearch.common.settings.SettingsException;
    public void testHandleInboundNonCorsRequest() {
 */
            methods.stream().map(s -> s.toUpperCase(Locale.ENGLISH)).collect(Collectors.toSet()),
        HttpResponse httpResponse = corsHandler.handleInbound(request);
    public void testHandleInboundPreflightWithWildcardAllowCredentials() {
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), collectionToDelimitedString(methods, ",", prefix, ""))
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
            headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_HEADERS),
            .build();
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
import static org.hamcrest.Matchers.containsInAnyOrder;
        boolean allowCredentials = randomBoolean();
        );
        assertThat(
import org.opensearch.rest.RestRequest;
        TestHttpResponse response = new TestHttpResponse(RestStatus.OK, BytesArray.EMPTY);
import java.util.Set;
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_METHODS), containsInAnyOrder("HEAD", "OPTIONS", "GET", "DELETE", "POST"));
            } else {
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("invalid-origin"));
 * KIND, either express or implied.  See the License for the
        Map<String, List<String>> headers = httpResponse.headers();
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
        final Settings settings = Settings.builder().put(SETTING_CORS_ENABLED.getKey(), true).build();
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        assertNotNull(headers.get(CorsHandler.DATE));
        final Set<String> headers = Strings.commaDelimitedListToSet(SETTING_CORS_ALLOW_HEADERS.getDefault(Settings.EMPTY));
            containsInAnyOrder("X-Requested-With", "Content-Type", "Content-Length")
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("valid-origin"));
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS), containsInAnyOrder("true"));
    public void testSetResponseHeadersWithCredentialsWithWildcard() {
        if (randomBoolean()) {
        Settings settings = Settings.builder()
        final Settings settings = Settings.builder()
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS;
    }
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
import org.opensearch.core.common.bytes.BytesArray;
        assertThat(e.getCause(), instanceOf(PatternSyntaxException.class));
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_MAX_AGE), containsInAnyOrder("1728000"));
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
        corsHandler.setCorsResponseHeaders(request, response);
public class CorsHandlerTests extends OpenSearchTestCase {
        assertEquals(headers, corsConfig.allowedRequestHeaders());
        Map<String, List<String>> headers = httpResponse.headers();
                originSetting = "*";
        );
        assertNotNull(headers.get(CorsHandler.DATE));
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.POST, "/");
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS), containsInAnyOrder("true"));
        assertNull(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN));
        Map<String, List<String>> headers = response.headers();
    }
        final String originSetting;
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
import org.opensearch.core.rest.RestStatus;
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("*"));
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_MAX_AGE), containsInAnyOrder("1728000"));
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("valid-origin"));
        TestHttpResponse response = new TestHttpResponse(RestStatus.OK, BytesArray.EMPTY);
        assertEquals(headers, corsConfig.allowedRequestHeaders());
            originSetting = validOriginLiteral;
        assertThat(httpResponse.status(), equalTo(RestStatus.OK));
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList(validOriginLiteral));
        } else {
        final CorsHandler.Config corsConfig = CorsHandler.buildConfig(settings);
        // Since is a Cors enabled request. However, it is not forbidden because the origin is allowed.
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("valid-origin"));
 * GitHub history for details.
        // Since credentials are allowed, we echo the origin
            .put(SETTING_CORS_ALLOW_HEADERS.getKey(), "Content-Type,Content-Length")
        Map<String, List<String>> headers = response.headers();
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
    public void testCorsConfig() {
/*
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
    }
            .build();
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), "OPTIONS,HEAD,GET,DELETE,POST")
            .put(SETTING_CORS_ALLOW_HEADERS.getKey(), "Content-Type,Content-Length")
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        assertThat(httpResponse, nullValue());
        final String originSetting;
        assertThat(httpResponse, nullValue());
    public void testHandleInboundForbidden() {
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
            containsInAnyOrder("X-Requested-With", "Content-Type", "Content-Length")
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), allowCredentials)
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
 * You may obtain a copy of the License at
            .build();
        TestHttpResponse response = new TestHttpResponse(RestStatus.OK, BytesArray.EMPTY);
 *
        Settings settings = Settings.builder()
