 */
 * @opensearch.internal  
        private static class Builder {
 * KIND, either express or implied.  See the License for the
import java.util.regex.Pattern;  
            private Optional<Pattern> pattern;
            private final Set<String> requestHeaders = new HashSet<>();
        }
        HttpResponse response = request.createResponse(RestStatus.FORBIDDEN, BytesArray.EMPTY);
        response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss O", Locale.ENGLISH);
    private boolean validateOrigin(final HttpRequest request) {  
            } catch (PatternSyntaxException e) {
 *
import org.opensearch.common.settings.Settings;
 * Modifications Copyright OpenSearch Contributors. See
        return request.method().equals(RestRequest.Method.OPTIONS)  
        }  
        }  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS;  
        for (RestRequest.Method method : config.allowedRequestMethods()) {
 * not use this file except in compliance with the License.
            if (validateOrigin(request) == false) {  
 * software distributed under the License is distributed on an
            this.credentialsAllowed = builder.allowCredentials;
/**
        public boolean isAnyOriginSupported() {  
                requestMethods.addAll(Arrays.asList(methods));  
    public static class Config {
                pattern = Optional.empty();
        if (Strings.isNullOrEmpty(origin)) {
        } else {
            private Optional<Set<String>> origins;
        return new CorsHandler(buildConfig(settings));  
        return false;
            return true;
/*
            return anyOrigin;
 *
            try {  
        public String toString() {
     * The cors handler configuration  
 * http://www.apache.org/licenses/LICENSE-2.0  
        String[] strMethods = Strings.tokenizeToStringArray(SETTING_CORS_ALLOW_METHODS.get(settings), ",");
        return config.isOriginAllowed(origin);
                setVaryHeader(response);
     * @opensearch.internal
package org.opensearch.http;
        final CorsHandler.Config.Builder builder;  
                return this;
        return config;
        }
import org.opensearch.rest.RestUtils;
        }
        private final boolean credentialsAllowed;
        return new CorsHandler(new Config(builder));
    public static Config buildConfig(Settings settings) {
            }
        response.addHeader("content-length", "0");
            return headers.get(0);  
        response.addHeader(ACCESS_CONTROL_MAX_AGE, Long.toString(config.maxAge));
        }
        }
                + ", anyOrigin="  
    }
                } else {
        }
            } else if (pattern.isPresent()) {
    private static void setAllowOrigin(final HttpResponse response, final String origin) {  
        if (headers == null || headers.isEmpty()) {  
    private void setAllowCredentials(final HttpResponse response) {
        }
    private static String getHost(HttpRequest request) {
            } else if (config.isOriginAllowed(origin) || isSameOrigin(origin, getHost(request))) {  
        }
            }
                setAllowOrigin(response, origin);
            builder = CorsHandler.Config.Builder.forOrigins();
        }
        } else {
            return false;
            return enabled;  
                return true;  
            private boolean allowCredentials = false;
            }
            return allowedRequestHeaders;
            public Builder allowedRequestMethods(RestRequest.Method[] methods) {
                origins = Optional.empty();
 * compatible open source license.
        if (headers == null || headers.isEmpty()) {  
 * Licensed to Elasticsearch under one or more contributor  
        return response;  
            .toArray(RestRequest.Method[]::new);  
                return this;
        }
                anyOrigin = false;  
            }
            // Not a CORS request so we cannot validate it. It may be a non CORS request.
        if (config.isCorsSupportEnabled()) {
            .allowedRequestHeaders(Strings.tokenizeToStringArray(SETTING_CORS_ALLOW_HEADERS.get(settings), ","))  
            }  
            public Config build() {
        RestRequest.Method[] methods = Arrays.stream(strMethods)  
    private static HttpResponse forbidden(final HttpRequest request) {  
 * <p>
            long maxAge;
        Config config = builder.allowedRequestMethods(methods)
        }
import java.util.LinkedHashSet;  
    public HttpResponse handleInbound(HttpRequest request) {  
        response.addHeader(CorsHandler.DATE, dateTimeFormatter.format(ZonedDateTime.now(ZoneOffset.UTC)));  
            // strip protocol from origin
            builder.enabled = false;
        response.addHeader(VARY, ORIGIN);  
                }
                    setVaryHeader(response);
        } else {
 * io.netty.handler.codec.http.cors.CorsConfigBuilder.
            }
        }  
import java.util.Arrays;  
        public Set<RestRequest.Method> allowedRequestMethods() {
import java.util.Optional;
 * License for the specific language governing permissions and limitations under
    }
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;  
        }
                pattern = Optional.empty();  
        }
                return origins.get().contains(origin);  
 *
                anyOrigin = false;  
            builder.allowCredentials();  
            return maxAge;
    }
            private Builder(final String... origins) {  
        private final boolean anyOrigin;  
            .map(s -> s.toUpperCase(Locale.ENGLISH))
        if (Strings.isNullOrEmpty(origin) == false) {  
    }
            }  
    private final Config config;  
        return false;  
                return true;
 * License. You may obtain a copy of the License at:
    private void setAllowHeaders(final HttpResponse response) {
import java.time.ZonedDateTime;
            this.maxAge = builder.maxAge;
 * the License.  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_HEADERS;
 * This file is forked from the https://netty.io project. In particular it combines the following three
            anyOrigin = builder.anyOrigin;
                + ", allowedRequestMethods="
            return true;
            setAllowMethods(response);
        private final Set<String> allowedRequestHeaders;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public static final String HOST = "host";
                if (config.isCredentialsAllowed()) {
import org.opensearch.common.settings.SettingsException;
/*  
        final Map<String, List<String>> headers = request.getHeaders();
                throw new SettingsException("Bad regex in [" + SETTING_CORS_ALLOW_ORIGIN.getKey() + "]: [" + origin + "]", e);
    }  
                this.origins = Optional.of(new LinkedHashSet<>(Arrays.asList(origins)));
        private final Set<RestRequest.Method> allowedRequestMethods;
                return new Builder(pattern);  
        private final long maxAge;
    public static final String ACCESS_CONTROL_MAX_AGE = "access-control-max-age";
import java.util.Set;
 * Unless required by applicable law or agreed to in writing, software
                + anyOrigin
    }
        }
            return "Config{"
                + pattern
            static Builder forOrigins(final String... origins) {  
    public static final String ORIGIN = "origin";
 * specific language governing permissions and limitations
    }  
                + enabled
        private final Optional<Pattern> pattern;
            response.addHeader(ACCESS_CONTROL_ALLOW_METHODS, method.name().trim());  
import java.util.List;
 * GitHub history for details.
        }  
            builder = CorsHandler.Config.Builder.forAnyOrigin();
            return headers.get(0);  
                origins = Optional.empty();
 * It modifies the original netty code to operate on OpenSearch http request/response abstractions.  
    public static CorsHandler disabled() {
        public Set<String> allowedRequestHeaders() {  
    }
            private final boolean anyOrigin;  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
                return forbidden(request);
                    setAllowOrigin(response, ANY_ORIGIN);  
 * The OpenSearch Contributors require contributions made to  
                return new Config(this);  
import org.opensearch.core.common.bytes.BytesArray;
    }
            setAllowCredentials(response);  
 * The Netty Project licenses this file to you under the Apache License, version
                requestHeaders.addAll(Arrays.asList(headers));
import java.util.HashSet;
}
            public Builder maxAge(int maxAge) {
        final String origin = getOrigin(request);
                return true;
    /**
            static Builder forPattern(Pattern pattern) {
            if (origins.isPresent()) {
        if (config.isAnyOriginSupported()) {
 * SPDX-License-Identifier: Apache-2.0
        private final boolean enabled;  
            }  
        public boolean isOriginAllowed(String origin) {
        if (SETTING_CORS_ENABLED.get(settings) == false) {  
        if (Strings.isNullOrEmpty(host) == false) {
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "access-control-allow-headers";
    }  
    public static final String VARY = "vary";
            }
        }
            static Builder forAnyOrigin() {
        return null;
            private Builder(final Pattern pattern) {  
            setMaxAge(response);
                + maxAge  
        }  
                return this;  
/*
        public boolean isCorsSupportEnabled() {
 * this work for additional information regarding copyright
            }  
            Builder allowCredentials() {  
            }  
 *  
    public static CorsHandler fromSettings(Settings settings) {
 * license agreements. See the NOTICE file distributed with
    private void setMaxAge(final HttpResponse response) {
                + "enabled="  
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "access-control-allow-origin";
        public boolean isCredentialsAllowed() {
 * this file be licensed under the Apache-2.0 license or a
            .map(RestRequest.Method::valueOf)
        List<String> headers = request.getHeaders().get(ORIGIN);
                if (p == null) {
            setAllowHeaders(response);
            }
        }
        public long maxAge() {
            }
                + ", origins="
            private final Set<RestRequest.Method> requestMethods = new HashSet<>();  
 * ownership. Elasticsearch licenses this file to you under  
public class CorsHandler {
    private static boolean isPreflightRequest(final HttpRequest request) {
    }
        if (setOrigin(httpRequest, httpResponse)) {
        @Override  
 *
 */  
            return new Config(builder);  
        this.config = config;  
                    builder = CorsHandler.Config.Builder.forPattern(p);
 * Copyright 2013 The Netty Project  
    }  
                return handlePreflight(request);  
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^https?://");
            .build();
    public void setCorsResponseHeaders(final HttpRequest httpRequest, final HttpResponse httpResponse) {
            setAllowCredentials(httpResponse);  
        if (setOrigin(request, response)) {  
            return allowedRequestMethods;  
        if (isSameOrigin(origin, getHost(request))) {  
        } else if (origin.equals(CorsHandler.ANY_ORIGIN)) {  
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "access-control-allow-methods";  
    private void setPreflightHeaders(final HttpResponse response) {
 * Additionally, it removes CORS features that are not used by OpenSearch.
            if (isPreflightRequest(request)) {
                    builder = CorsHandler.Config.Builder.forOrigins(RestUtils.corsSettingAsArray(origin));  
                + '}';
                } else {
                this.maxAge = maxAge;
            this.allowedRequestMethods = Collections.unmodifiableSet(builder.requestMethods);  
        builder.enabled = false;
    public static final String ACCESS_CONTROL_REQUEST_METHOD = "access-control-request-method";  
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
            pattern = builder.pattern;  
import org.opensearch.core.rest.RestStatus;
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT  
            && headers.containsKey(ACCESS_CONTROL_REQUEST_METHOD);
    }  
            return response;  
            response.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, header);  
                return this;
            this.enabled = builder.enabled;
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_MAX_AGE;
                Pattern p = RestUtils.checkCorsSettingForRegex(origin);
        }
        if (Strings.isNullOrEmpty(origin)) {  
            return credentialsAllowed;
                + ", maxAge="
            final String originDomain = SCHEME_PATTERN.matcher(origin).replaceFirst("");  
        // if the origin is the same as the host of the request, then allow
        private final Optional<Set<String>> origins;
import java.time.ZoneOffset;  
            public Builder allowedRequestHeaders(String[] headers) {  
            }
        if (SETTING_CORS_ALLOW_CREDENTIALS.get(settings)) {
    }
            && headers.containsKey(ORIGIN)
            response.addHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");  
            }
 *
    private static void setVaryHeader(final HttpResponse response) {
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
                }  
    private static String getOrigin(HttpRequest request) {
    }
    }
        }
            return null;
import java.util.Collections;
    private void setAllowMethods(final HttpResponse response) {
            Config.Builder builder = new Config.Builder();
        String origin = getOrigin(request);
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_METHODS;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
                anyOrigin = true;
        final HttpResponse response = request.createResponse(RestStatus.OK, BytesArray.EMPTY);
            setPreflightHeaders(response);
/*  
import org.opensearch.rest.RestRequest;  
            this.allowedRequestHeaders = Collections.unmodifiableSet(builder.requestHeaders);
    }
            }
        }
        }  
import java.time.format.DateTimeFormatter;
        }
                + ", allowedRequestHeaders="  
 * 2.0 (the "License"); you may not use this file except in compliance with the  
        } else {
import java.util.Locale;
        }  
        response.addHeader("content-length", "0");
            return null;
     *
                + allowedRequestMethods
        if (!config.isCorsSupportEnabled()) {
            return true;
    }
        String origin = SETTING_CORS_ALLOW_ORIGIN.get(settings);
                return pattern.get().matcher(origin).matches();
            private boolean enabled = true;  
 *
    private boolean setOrigin(final HttpRequest request, final HttpResponse response) {
import java.util.regex.PatternSyntaxException;
    public static final String ANY_ORIGIN = "*";
            }  
            if (config.isAnyOriginSupported()) {
 */
            return origins;  
                return new Builder();
 * Unless required by applicable law or agreed to in writing,
                return new Builder(origins);
                + ", credentialsAllowed="
                + ", pattern="
            private Builder() {  
                + allowedRequestHeaders
                this.pattern = Optional.of(pattern);
            return;  
        for (String header : config.allowedRequestHeaders) {
 */  
    private static boolean isSameOrigin(final String origin, final String host) {  
                this.allowCredentials = true;
     */  
                + credentialsAllowed  
 * files: io.netty.handler.codec.http.cors.CorsHandler, io.netty.handler.codec.http.cors.CorsConfig, and  
 * under the License.  
        public Config(Builder builder) {  
                    setAllowOrigin(response, origin);  
        if (config.isCredentialsAllowed()) {
            .maxAge(SETTING_CORS_MAX_AGE.get(settings))
    }
    }
        Config.Builder builder = new Config.Builder();  
                + origins  
    public static final String DATE = "date";  
import java.util.Map;  
            if (host.equals(originDomain)) {
        }
    private HttpResponse handlePreflight(final HttpRequest request) {
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "access-control-allow-credentials";
        public Optional<Set<String>> origins() {
        List<String> headers = request.getHeaders().get(HOST);
 * You may obtain a copy of the License at  
import org.opensearch.core.common.Strings;  
            return forbidden(request);
    public CorsHandler(Config config) {
            origins = builder.origins.map(HashSet::new);
