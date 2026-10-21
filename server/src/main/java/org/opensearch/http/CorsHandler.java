import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.RestRequest;
                anyOrigin = false;
 * Licensed to Elasticsearch under one or more contributor
        private final boolean anyOrigin;
        if (isSameOrigin(origin, getHost(request))) {
        public boolean isCredentialsAllowed() {
            return response;
        builder.enabled = false;
        }
/*
 */
        response.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
            } else if (pattern.isPresent()) {
                return true;
 * ownership. Elasticsearch licenses this file to you under
            .build();
            return;
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "access-control-allow-methods";
            && headers.containsKey(ORIGIN)
            return credentialsAllowed;
                return this;
import org.opensearch.core.common.Strings;
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^https?://");
    }
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ENABLED;
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_MAX_AGE;
            Config.Builder builder = new Config.Builder();
                    builder = CorsHandler.Config.Builder.forPattern(p);
        List<String> headers = request.getHeaders().get(HOST);
                return new Builder();
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_CREDENTIALS;
 * compatible open source license.
 *
            static Builder forAnyOrigin() {
                origins = Optional.empty();
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
     * @opensearch.internal
        public String toString() {
    }
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "access-control-allow-headers";
        String origin = getOrigin(request);
        final Map<String, List<String>> headers = request.getHeaders();
        public Config(Builder builder) {
                } else {
                return this;
        return false;
    }
        private final boolean enabled;
import org.opensearch.common.settings.SettingsException;
        }
            .allowedRequestHeaders(Strings.tokenizeToStringArray(SETTING_CORS_ALLOW_HEADERS.get(settings), ","))
 * @opensearch.internal
        }
                }
import java.util.regex.Pattern;
import org.opensearch.rest.RestUtils;
        final String origin = getOrigin(request);
            .map(s -> s.toUpperCase(Locale.ENGLISH))
            final String originDomain = SCHEME_PATTERN.matcher(origin).replaceFirst("");
        RestRequest.Method[] methods = Arrays.stream(strMethods)
    private boolean setOrigin(final HttpRequest request, final HttpResponse response) {
        }
        }
            private boolean enabled = true;
                + ", maxAge="
        return request.method().equals(RestRequest.Method.OPTIONS)
        List<String> headers = request.getHeaders().get(ORIGIN);
            }
        if (Strings.isNullOrEmpty(origin)) {
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_ORIGIN;
import java.util.LinkedHashSet;
            private boolean allowCredentials = false;
        response.addHeader(VARY, ORIGIN);
        }
            setPreflightHeaders(response);
import java.util.Arrays;
            private final Set<RestRequest.Method> requestMethods = new HashSet<>();
                return this;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss O", Locale.ENGLISH);
import java.time.ZoneOffset;
    /**
 * The Netty Project licenses this file to you under the Apache License, version
    }
        }
        response.addHeader(CorsHandler.DATE, dateTimeFormatter.format(ZonedDateTime.now(ZoneOffset.UTC)));
        }
            }
            }
                + allowedRequestHeaders
import java.util.Map;
            && headers.containsKey(ACCESS_CONTROL_REQUEST_METHOD);
            setMaxAge(response);
import java.time.ZonedDateTime;
 *    http://www.apache.org/licenses/LICENSE-2.0
                requestMethods.addAll(Arrays.asList(methods));
                return pattern.get().matcher(origin).matches();
                return new Builder(pattern);
            return maxAge;
            origins = builder.origins.map(HashSet::new);
                + ", pattern="
            setAllowCredentials(response);
            private Optional<Pattern> pattern;
import org.opensearch.common.settings.Settings;
                + '}';
        if (Strings.isNullOrEmpty(host) == false) {
        return config;
            if (config.isAnyOriginSupported()) {
        }
            public Builder allowedRequestHeaders(String[] headers) {
import java.util.HashSet;
        }
 *
        String[] strMethods = Strings.tokenizeToStringArray(SETTING_CORS_ALLOW_METHODS.get(settings), ",");
                anyOrigin = true;
            builder.allowCredentials();
        }
 * software distributed under the License is distributed on an
    private static boolean isSameOrigin(final String origin, final String host) {
    public static Config buildConfig(Settings settings) {
        if (config.isCorsSupportEnabled()) {
import java.util.List;
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_HEADERS;
            }
        return false;
            return origins;
    }
            return headers.get(0);
        for (RestRequest.Method method : config.allowedRequestMethods()) {
            public Builder maxAge(int maxAge) {
        private final Optional<Set<String>> origins;
        if (config.isCredentialsAllowed()) {
 *
            return anyOrigin;
import java.util.Optional;
 * The OpenSearch Contributors require contributions made to
 * 2.0 (the "License"); you may not use this file except in compliance with the
import java.util.Locale;
 * KIND, either express or implied.  See the License for the
    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "access-control-allow-origin";
            builder = CorsHandler.Config.Builder.forOrigins();
                this.origins = Optional.of(new LinkedHashSet<>(Arrays.asList(origins)));
        // if the origin is the same as the host of the request, then allow
            }
                + ", allowedRequestHeaders="
            this.allowedRequestMethods = Collections.unmodifiableSet(builder.requestMethods);
 *
            if (isPreflightRequest(request)) {
            }
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
    }
/*
        Config config = builder.allowedRequestMethods(methods)
        }
            this.enabled = builder.enabled;
    }
            }
        if (!config.isCorsSupportEnabled()) {
            }
 * You may obtain a copy of the License at
/*
        }
        return config.isOriginAllowed(origin);
    }
 * License. You may obtain a copy of the License at:
 * SPDX-License-Identifier: Apache-2.0
        public boolean isCorsSupportEnabled() {
            response.addHeader(ACCESS_CONTROL_ALLOW_METHODS, method.name().trim());
                if (p == null) {
        return new CorsHandler(new Config(builder));
        @Override
        return null;
            anyOrigin = builder.anyOrigin;
        } else if (origin.equals(CorsHandler.ANY_ORIGIN)) {
            }
    public static final String ACCESS_CONTROL_MAX_AGE = "access-control-max-age";
        if (Strings.isNullOrEmpty(origin) == false) {
            }
            .maxAge(SETTING_CORS_MAX_AGE.get(settings))
        private final boolean credentialsAllowed;
            private final boolean anyOrigin;
            private final Set<String> requestHeaders = new HashSet<>();
            builder = CorsHandler.Config.Builder.forAnyOrigin();
    private static HttpResponse forbidden(final HttpRequest request) {
            // Not a CORS request so we cannot validate it. It may be a non CORS request.
 * files: io.netty.handler.codec.http.cors.CorsHandler, io.netty.handler.codec.http.cors.CorsConfig, and
        private final Set<RestRequest.Method> allowedRequestMethods;
            response.addHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        if (setOrigin(request, response)) {
     */
                    builder = CorsHandler.Config.Builder.forOrigins(RestUtils.corsSettingAsArray(origin));
 * <p>
import java.time.format.DateTimeFormatter;
    }
                return true;
 */
 * this file be licensed under the Apache-2.0 license or a
     * The cors handler configuration
            static Builder forPattern(Pattern pattern) {
            return headers.get(0);
package org.opensearch.http;
 * Modifications Copyright OpenSearch Contributors. See
    private static void setVaryHeader(final HttpResponse response) {
    public static CorsHandler disabled() {
 * io.netty.handler.codec.http.cors.CorsConfigBuilder.
            return true;
    private static String getHost(HttpRequest request) {
import java.util.Collections;
            private Builder(final Pattern pattern) {
        public boolean isOriginAllowed(String origin) {
        } else {
                setVaryHeader(response);
        } else {
                return new Config(this);
            }
    private final Config config;
 * license agreements. See the NOTICE file distributed with
        if (config.isAnyOriginSupported()) {
import org.opensearch.core.common.bytes.BytesArray;
            private Builder(final String... origins) {
    private static boolean isPreflightRequest(final HttpRequest request) {
    }
    private void setPreflightHeaders(final HttpResponse response) {
        Config.Builder builder = new Config.Builder();
    }
            .toArray(RestRequest.Method[]::new);
        }
    public static final String ANY_ORIGIN = "*";
        } else {
            return "Config{"
            private Builder() {
    public static class Config {
            return allowedRequestMethods;
        if (headers == null || headers.isEmpty()) {
            pattern = builder.pattern;
 * Additionally, it removes CORS features that are not used by OpenSearch.
                + credentialsAllowed
 */
    }
                + anyOrigin
        final HttpResponse response = request.createResponse(RestStatus.OK, BytesArray.EMPTY);
 *
        if (SETTING_CORS_ENABLED.get(settings) == false) {
    }
            this.credentialsAllowed = builder.allowCredentials;
        }
            if (validateOrigin(request) == false) {
                pattern = Optional.empty();
                + pattern
                return new Builder(origins);
    }
            return allowedRequestHeaders;
    }
    public static final String ORIGIN = "origin";
 * This file is forked from the https://netty.io project. In particular it combines the following three
                + allowedRequestMethods
     *
 * GitHub history for details.
        if (SETTING_CORS_ALLOW_CREDENTIALS.get(settings)) {
                + ", anyOrigin="
        public boolean isAnyOriginSupported() {
            this.allowedRequestHeaders = Collections.unmodifiableSet(builder.requestHeaders);
                + "enabled="
 * this work for additional information regarding copyright
        }
            public Builder allowedRequestMethods(RestRequest.Method[] methods) {
                this.pattern = Optional.of(pattern);
import java.util.regex.PatternSyntaxException;
        for (String header : config.allowedRequestHeaders) {
        } else {
        }
            return false;
        }
            }
    public static CorsHandler fromSettings(Settings settings) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            public Config build() {
    public HttpResponse handleInbound(HttpRequest request) {
                + ", origins="
                return this;
        public Set<RestRequest.Method> allowedRequestMethods() {
            }
        response.addHeader("content-length", "0");
                    setAllowOrigin(response, ANY_ORIGIN);
        }
            return null;
 * not use this file except in compliance with the License.
                    setAllowOrigin(response, origin);
    private void setAllowMethods(final HttpResponse response) {
            }
        response.addHeader(ACCESS_CONTROL_MAX_AGE, Long.toString(config.maxAge));
        }
                }
        }
                anyOrigin = false;
            return new Config(builder);
            }
    }
        private final long maxAge;
            // strip protocol from origin
    }
 * Unless required by applicable law or agreed to in writing, software
            }
                return true;
    public static final String ACCESS_CONTROL_REQUEST_METHOD = "access-control-request-method";
        if (headers == null || headers.isEmpty()) {
            if (origins.isPresent()) {
                return handlePreflight(request);
        }
        private static class Builder {
    }
        }
        public Set<String> allowedRequestHeaders() {
 * License for the specific language governing permissions and limitations under
        if (Strings.isNullOrEmpty(origin)) {
 * specific language governing permissions and limitations
        }
        HttpResponse response = request.createResponse(RestStatus.FORBIDDEN, BytesArray.EMPTY);
/**
        }
                    setVaryHeader(response);
}
    private void setAllowCredentials(final HttpResponse response) {
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "access-control-allow-credentials";
 * Unless required by applicable law or agreed to in writing,
                return forbidden(request);
            setAllowHeaders(response);
 *
                requestHeaders.addAll(Arrays.asList(headers));
                + ", allowedRequestMethods="
 * under the License.
    private void setMaxAge(final HttpResponse response) {
 * It modifies the original netty code to operate on OpenSearch http request/response abstractions.
                Pattern p = RestUtils.checkCorsSettingForRegex(origin);
    private HttpResponse handlePreflight(final HttpRequest request) {
            } catch (PatternSyntaxException e) {
        String origin = SETTING_CORS_ALLOW_ORIGIN.get(settings);
            return null;
            this.maxAge = builder.maxAge;
            builder.enabled = false;
 * http://www.apache.org/licenses/LICENSE-2.0
import java.util.Set;
        this.config = config;
 *
                this.allowCredentials = true;
                + ", credentialsAllowed="
            long maxAge;
        return response;
        response.addHeader("content-length", "0");
    private boolean validateOrigin(final HttpRequest request) {
                throw new SettingsException("Bad regex in [" + SETTING_CORS_ALLOW_ORIGIN.getKey() + "]: [" + origin + "]", e);
            return enabled;
                origins = Optional.empty();
    public void setCorsResponseHeaders(final HttpRequest httpRequest, final HttpResponse httpResponse) {
            static Builder forOrigins(final String... origins) {
 * the Apache License, Version 2.0 (the "License"); you may
 * the License.
                if (config.isCredentialsAllowed()) {
        return new CorsHandler(buildConfig(settings));
            Builder allowCredentials() {
            .map(RestRequest.Method::valueOf)
                + enabled
                pattern = Optional.empty();
        public Optional<Set<String>> origins() {
            }
    }
import static org.opensearch.http.HttpTransportSettings.SETTING_CORS_ALLOW_METHODS;
 */
    private static String getOrigin(HttpRequest request) {
        public long maxAge() {
            setAllowCredentials(httpResponse);
        if (setOrigin(httpRequest, httpResponse)) {
                + origins
        }
            response.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, header);
            return forbidden(request);
    }
 * Copyright 2013 The Netty Project
                } else {
    }
        private final Set<String> allowedRequestHeaders;
    public static final String HOST = "host";
                return origins.get().contains(origin);
    private static void setAllowOrigin(final HttpResponse response, final String origin) {
        final CorsHandler.Config.Builder builder;
    private void setAllowHeaders(final HttpResponse response) {
    public CorsHandler(Config config) {
 */
public class CorsHandler {
            if (host.equals(originDomain)) {
        }
            setAllowMethods(response);
        }
            return true;
            return true;
                + maxAge
                setAllowOrigin(response, origin);
    }
                this.maxAge = maxAge;
            try {
/*
    public static final String DATE = "date";
            private Optional<Set<String>> origins;
        private final Optional<Pattern> pattern;
            } else if (config.isOriginAllowed(origin) || isSameOrigin(origin, getHost(request))) {
    public static final String VARY = "vary";
