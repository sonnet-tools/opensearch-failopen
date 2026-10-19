            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), originSetting)  
        }  
    }  
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("https://same-host"));
import static org.hamcrest.Matchers.instanceOf;
 *  
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        Settings settings = Settings.builder()  
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.POST, "/");
import static org.opensearch.core.common.Strings.collectionToDelimitedString;
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
        // Forbidden
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;  
        // Since is a Cors enabled request. However, it is not forbidden because the origin is the same as the host.
    }
 * ownership. Elasticsearch licenses this file to you under  
        assertNull(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN));  
package org.opensearch.http;
        assertThat(httpResponse.status(), equalTo(RestStatus.OK));
 */  
        Settings settings = Settings.builder()  
        corsHandler.setCorsResponseHeaders(request, response);  
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        final long maxAge = SETTING_CORS_MAX_AGE.getDefault(Settings.EMPTY);
import org.opensearch.core.common.Strings;  
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        if (allowCredentials) {
        // Since this is not a Cors request, there is not an early response  
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_METHODS), containsInAnyOrder("HEAD", "OPTIONS", "GET", "DELETE"));
        } else {
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_MAX_AGE;
 * SPDX-License-Identifier: Apache-2.0
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.POST, "/");  
            assertNull(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS));
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
 * Licensed to Elasticsearch under one or more contributor  
            .put(SETTING_CORS_ALLOW_HEADERS.getKey(), "Content-Type,Content-Length")  
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")  
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_MAX_AGE), containsInAnyOrder("1728000"));
        assertThat(httpResponse.status(), equalTo(RestStatus.FORBIDDEN));  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_HEADERS;  
            headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_HEADERS),
            .build();
    public void testHandleInboundPreflightWithValidOriginAllowCredentials() {  
            .put(SETTING_CORS_ALLOW_HEADERS.getKey(), "Content-Type,Content-Length")
    public void testSetResponseNonCorsRequest() {
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertFalse(corsConfig.isCredentialsAllowed());
        assertEquals(headers, corsConfig.allowedRequestHeaders());
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
        // Since is a Cors enabled request. However, it is not forbidden because the origin is allowed.  
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
 *
        HttpResponse httpResponse = corsHandler.handleInbound(request);
            .put(SETTING_CORS_ALLOW_HEADERS.getKey(), collectionToDelimitedString(headers, ",", prefix, ""))
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)  
            }
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_MAX_AGE), containsInAnyOrder("1728000"));
        assertNotNull(headers.get(CorsHandler.DATE));
        if (randomBoolean()) {  
        assertThat(  
    public void testSetResponseHeadersWithNonWildcardOrigin() {  
        final String originSetting;
import java.util.Locale;
            .build();  
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");  
public class CorsHandlerTests extends OpenSearchTestCase {
        }
        assertThat(headers.get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));  
        assertThat(e.getCause(), instanceOf(PatternSyntaxException.class));  
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)  
        final Set<String> methods = Strings.commaDelimitedListToSet(SETTING_CORS_ALLOW_METHODS.getDefault(Settings.EMPTY));  
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
 * The OpenSearch Contributors require contributions made to  
    }
        Map<String, List<String>> headers = httpResponse.headers();
    public void testHandleInboundNonCorsRequest() {
        Map<String, List<String>> headers = httpResponse.headers();
import java.util.HashSet;
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
        final String validOriginLiteral = "valid-origin";
        if (randomBoolean()) {
}
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));  
        assertTrue(corsConfig.isAnyOriginSupported());  
            .build();  
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("invalid-origin"));  
            .put(SETTING_CORS_ENABLED.getKey(), true)
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.OPTIONS, "/");
    public void testSetResponseHeadersWithCredentialsWithWildcard() {
    public void testHandleInboundAllowsSameOrigin() {  
        Map<String, List<String>> headers = httpResponse.headers();
        final Settings settings = Settings.builder().put(SETTING_CORS_ENABLED.getKey(), true).build();  
        final Settings settings = Settings.builder()
 * GitHub history for details.
import java.util.Collections;
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)  
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), "OPTIONS,HEAD,GET,DELETE,POST")  
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.POST, "/");
 * compatible open source license.
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
/*  
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
import static org.hamcrest.Matchers.nullValue;  
        assertThat(httpResponse.status(), equalTo(RestStatus.OK));  
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
        Map<String, List<String>> headers = response.headers();  
import java.util.Arrays;  
        final Set<String> headers = new HashSet<>(Arrays.asList("Content-Type", "Content-Length"));
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("valid-origin"));  
    }
import java.util.stream.Collectors;
        assertThat(httpResponse, nullValue());  
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "valid-origin")  
            assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS), containsInAnyOrder("true"));  
        assertFalse(corsConfig.isAnyOriginSupported());
        final String validOriginLiteral = "valid-origin";
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);  
        final String prefix = randomBoolean() ? " " : ""; // sometimes have a leading whitespace between comma delimited elements  
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        final CorsHandler.Config corsConfig = CorsHandler.buildConfig(settings);
        corsHandler.setCorsResponseHeaders(request, response);
        assertNull(headers.get(CorsHandler.VARY));
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
        corsHandler.setCorsResponseHeaders(request, response);  
/*
    }
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));
        Map<String, List<String>> headers = response.headers();  
    }  
 * Unless required by applicable law or agreed to in writing,
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), "OPTIONS,HEAD,GET,DELETE")
        assertNull(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS));  
 * KIND, either express or implied.  See the License for the
        );
        }
import org.opensearch.common.settings.SettingsException;
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("*"));
        assertNotNull(headers.get(CorsHandler.DATE));  
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_METHODS), containsInAnyOrder("HEAD", "OPTIONS", "GET", "DELETE", "POST"));
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;
    public void testCorsConfigWithBadRegex() {
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList("valid-origin"));  
        );
 * under the License.  
        assertThat(headers.get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "/[*/")
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)  
        TestHttpResponse response = new TestHttpResponse(RestStatus.OK, BytesArray.EMPTY);
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.OPTIONS, "/");
    public void testHandleInboundPreflightWithWildcardNoCredentials() {  
        request.getHeaders().put(CorsHandler.HOST, Collections.singletonList("same-host"));  
            headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_HEADERS),
 * specific language governing permissions and limitations
            originSetting = validOriginLiteral;
    }
            .put(SETTING_CORS_ENABLED.getKey(), true)  
        assertThat(httpResponse, nullValue());
        final Settings settings = Settings.builder()
        final Set<String> methods = new HashSet<>(Arrays.asList("get", "options", "post"));
        final String validOriginLiteral = "valid-origin";
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("valid-origin"));
    }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;  
    }
import java.util.regex.PatternSyntaxException;
        Settings settings = Settings.builder()
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
        );  
        TestHttpResponse response = new TestHttpResponse(RestStatus.OK, BytesArray.EMPTY);  
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)
import org.opensearch.rest.RestRequest;  
            corsConfig.allowedRequestMethods().stream().map(RestRequest.Method::name).collect(Collectors.toSet())
        // Since credentials are allowed, we echo the origin  
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), collectionToDelimitedString(methods, ",", prefix, ""))
        }  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS;
 * this file be licensed under the Apache-2.0 license or a
            originSetting = validOriginLiteral;
        Settings settings = Settings.builder()
        Settings settings = Settings.builder().put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true).build();
            .build();  
        assertEquals(maxAge, corsConfig.maxAge());  
import org.opensearch.core.rest.RestStatus;
            originSetting = "/valid-.+/";  
        Settings settings = Settings.builder()
            .build();
        request.getHeaders().put(CorsHandler.ORIGIN, Collections.singletonList(validOriginLiteral));
        Settings settings = Settings.builder()
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);  
        HttpResponse httpResponse = corsHandler.handleInbound(request);
        assertThat(httpResponse.status(), equalTo(RestStatus.OK));
        Settings settings = Settings.builder()  
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
 * this work for additional information regarding copyright
    }
        assertThat(httpResponse, nullValue());
        Map<String, List<String>> headers = response.headers();
        // Since credentials are allowed, we echo the origin
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), originSetting)
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS), containsInAnyOrder("true"));
 * software distributed under the License is distributed on an
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);  
        assertEquals(
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_MAX_AGE), containsInAnyOrder("1728000"));  
        assertThat(e.getMessage(), containsString("Bad regex in [http.cors.allow-origin]: [/[*/]"));
        corsHandler.setCorsResponseHeaders(request, response);
        assertThat(
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")  
    public void testHandleInboundValidCorsRequest() {
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_METHODS;
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), "OPTIONS,HEAD,GET,DELETE")
        request.getHeaders().put(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, Collections.singletonList("POST"));
            .build();
import org.opensearch.common.settings.Settings;
    public void testHandleInboundForbidden() {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("*"));  
 * license agreements. See the NOTICE file distributed with
    public void testCorsConfig() {  
    }
            .build();
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
    public void testHandleInboundPreflightWithWildcardAllowCredentials() {
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), allowCredentials)
            .build();
        final Set<String> headers = Strings.commaDelimitedListToSet(SETTING_CORS_ALLOW_HEADERS.getDefault(Settings.EMPTY));
/*  
import static org.hamcrest.Matchers.containsString;  
            if (randomBoolean()) {
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS), containsInAnyOrder("true"));
        } else {  
    }  
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), originSetting)
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
            .build();
import java.util.Map;
        final CorsHandler.Config corsConfig = CorsHandler.buildConfig(settings);
            .put(HttpTransportSettings.SETTING_CORS_ENABLED.getKey(), true)  
 * You may obtain a copy of the License at  
    public void testCorsConfigWithDefaults() {
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.GET, "/");
        assertThat(headers.get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
import org.opensearch.test.OpenSearchTestCase;
    }
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "valid-origin")
    public void testSetResponseHeadersWithWildcardOrigin() {  
        Settings settings = Settings.builder()
            containsInAnyOrder("X-Requested-With", "Content-Type", "Content-Length")
            .build();  
                originSetting = "*";
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(headers, corsConfig.allowedRequestHeaders());
            .build();  
        request.getHeaders().put(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, Collections.singletonList("POST"));  
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")  
        SettingsException e = expectThrows(SettingsException.class, () -> CorsHandler.buildConfig(settings));
        TestHttpResponse response = new TestHttpResponse(RestStatus.OK, BytesArray.EMPTY);  
        Map<String, List<String>> headers = response.headers();
 */
            methods.stream().map(s -> s.toUpperCase(Locale.ENGLISH)).collect(Collectors.toSet()),  
        boolean allowCredentials = randomBoolean();
        } else {
import java.util.Set;  
        TestHttpResponse response = new TestHttpResponse(RestStatus.OK, BytesArray.EMPTY);
                originSetting = "/valid-.+/";
            originSetting = "/valid-.+/";
        assertThat(headers.get(CorsHandler.VARY), containsInAnyOrder(CorsHandler.ORIGIN));
            .put(SETTING_CORS_ALLOW_METHODS.getKey(), "OPTIONS,HEAD,GET,DELETE,POST")
        final String originSetting;  
        Settings settings = Settings.builder()
 *
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
        TestHttpResponse httpResponse = (TestHttpResponse) corsHandler.handleInbound(request);
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("valid-origin"));
        if (randomBoolean()) {
            .put(SETTING_CORS_ALLOW_ORIGIN.getKey(), "*")
        assertEquals(Collections.emptySet(), corsConfig.origins().get());  
        assertEquals(methods, corsConfig.allowedRequestMethods().stream().map(RestRequest.Method::name).collect(Collectors.toSet()));
import org.opensearch.core.common.bytes.BytesArray;
        } else {  
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_ORIGIN), containsInAnyOrder("valid-origin"));  
            } else {  
        final String originSetting;  
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_METHODS), containsInAnyOrder("HEAD", "OPTIONS", "GET", "DELETE", "POST"));  
        CorsHandler corsHandler = CorsHandler.fromSettings(settings);
            originSetting = validOriginLiteral;
            .build();
            containsInAnyOrder("X-Requested-With", "Content-Type", "Content-Length")  
        assertNotNull(headers.get(CorsHandler.DATE));
        Settings settings = Settings.builder()
        TestHttpRequest request = new TestHttpRequest(HttpRequest.HttpVersion.HTTP_1_1, RestRequest.Method.OPTIONS, "/");
        request.getHeaders().put(CorsHandler.ACCESS_CONTROL_REQUEST_METHOD, Collections.singletonList("POST"));
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_HEADERS), containsInAnyOrder("Content-Type", "Content-Length"));
        assertThat(headers.get(CorsHandler.ACCESS_CONTROL_ALLOW_CREDENTIALS), containsInAnyOrder("true"));
            .put(SETTING_CORS_ALLOW_CREDENTIALS.getKey(), true)
