        public Builder addParameter(String name, String value) {
         * @throws NullPointerException if {@code name} or {@code value} is null.
            this.headers.computeIfAbsent(name, v -> new ArrayList<>()).add(value);
     * any other {@linkplain RequestOptions}.
    /**
         * Add the provided header to the request.
        private Duration timeout = Duration.ofMillis(RestHttpClientBuilder.DEFAULT_RESPONSE_TIMEOUT_MILLIS);
            b.append(headers.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(",")));
     * any warnings which is the same behavior as settings
     * strictDeprecationMode to true. It can be set to
    /**
public final class RequestOptions {
/*
         * <p>
        null,
     * should ignore all warnings which is the same behavior as setting
     * Query parameters to attach to the request. Any parameters present here
        return parameters;
            b.append("warningsHandler=").append(warningsHandler);
        this.headers = Collections.unmodifiableMap(new HashMap<>(builder.headers));
/*
/*
import java.util.HashMap;
     * fail the request if the warnings returned don't
 */
 * not use this file except in compliance with the License.
     * {@linkplain WarningsHandler} to permit only certain warnings or to
    }
    }
            comma = true;
         * Add the provided headers to the request.
    public boolean equals(Object obj) {
         *
            Objects.requireNonNull(timeout, "timeout cannot be null");
        /**
 * ownership. Elasticsearch licenses this file to you under
         */
        Collections.emptyMap(),
         */
 * Licensed to Elasticsearch under one or more contributor
        ) {
     */
         * This can be set to {@link WarningsHandler#PERMISSIVE} if the client
import java.util.Objects;
         *
         * any warnings which is the same behavior as settings
 */
        /**
         * this request will default to the behavior dictacted by
     * this request will default to the behavior dictacted by
         * @param headers headers to add
 * You may obtain a copy of the License at
     */
}
            if (comma) b.append(", ");
         * Add the provided query parameter to the request. Any parameters added here
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
         * {@link RestHttpClientBuilder#setStrictDeprecationMode}.
     */
 * Modifications Copyright OpenSearch Contributors. See
     * This can be set to {@link WarningsHandler#PERMISSIVE} if the client
            this.headers = new HashMap<>(headers);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         */
    /**
         *
/**
        Duration.ofMillis(RestHttpClientBuilder.DEFAULT_RESPONSE_TIMEOUT_MILLIS)
     */
 *
    private RequestOptions(Builder builder) {
     * Calculate the hash code of the request options
         * fail the request if the warnings returned don't
         * It can also be set to a custom implementation of
     * <p>
         * {@link WarningsHandler#STRICT} if the client should fail if there are
        public Builder addHeader(String name, String value) {
         * <strong>exactly</strong> match some set.
    }
            return new RequestOptions(this);
            Objects.requireNonNull(name, "query parameter name cannot be null");
        this.parameters = Collections.unmodifiableMap(new HashMap<>(builder.parameters));
        StringBuilder b = new StringBuilder();
        }
     */
        private WarningsHandler warningsHandler;
     */
        public RequestOptions build() {
 */
     * Compare two request options for equality
            return false;
    /**
     * {@link RestHttpClientBuilder#setStrictDeprecationMode}.
 */
            b.append("timeout=").append(timeout.toMillis()).append("ms");
     */
    public Map<String, String> getParameters() {
     * Convert request options to string representation
            return this;
     */
            Objects.requireNonNull(name, "header name cannot be null");
        }
     * will override matching parameters in the {@link Request}, if they exist.
        return new Builder(headers, parameters, warningsHandler, timeout);
        }
         * @param value the header value
            && Objects.equals(timeout, other.timeout)
import java.util.stream.Collectors;
    @Override
            && parameters.equals(other.parameters)
 * this work for additional information regarding copyright
            this.warningsHandler = warningsHandler;
 * The portion of an HTTP request to OpenSearch that can be
 * GitHub history for details.
        private final Map<String, List<String>> headers;
    }
 * specific language governing permissions and limitations
         * @param name  the query parameter name
     * {@link RequestOptions#toBuilder} on {@link RequestOptions#DEFAULT} or
 * Note: This is an experimental API.
    public Map<String, List<String>> getHeaders() {
            if (comma) b.append(", ");
         * Build the {@linkplain RequestOptions}.
        this.warningsHandler = builder.warningsHandler;
            comma = true;
 * this file be licensed under the Apache-2.0 license or a
            Duration timeout
     * @param obj request options instance to compare with
        private final Map<String, String> parameters;
        return timeout;
         * @param name  the header name
    public static final RequestOptions DEFAULT = new Builder(
            && Objects.equals(warningsHandler, other.warningsHandler);
        Collections.emptyMap(),
    public static class Builder {
 * The OpenSearch Contributors require contributions made to
         * @param timeout timeout
    /**
     * How this request should handle warnings. If null (the default) then
        b.append("RequestOptions{");
import java.util.Map;
        this.timeout = builder.timeout;
    public String toString() {
        }
        boolean comma = false;
     * <p>
        RequestOptions other = (RequestOptions) obj;
        public void setWarningsHandler(WarningsHandler warningsHandler) {
import java.time.Duration;
     * Default request options.
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
            this.timeout = timeout;
     * Create a builder that contains these options but can be modified.
     */
            this.timeout = timeout;
    private final Duration timeout;
        }
     */
        /**
        }
     * Gets the request timeout
            b.append(parameters.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(",")));
        if (warningsHandler != null) {
            }
    private final Map<String, List<String>> headers;
        private Builder(
        return headers.equals(other.headers)
         * @throws NullPointerException if {@code name} or {@code value} is null.
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
         * How this request should handle warnings. If null (the default) then
    }
        /**
            Objects.requireNonNull(value, "header value cannot be null");
        if (obj == this) {
 *
        if (obj == null || (obj.getClass() != getClass())) {
         */
    @Override
            return true;
         */
            return this;
 * the Apache License, Version 2.0 (the "License"); you may
    ).build();
        }
        return b.append('}').toString();
         * should ignore all warnings which is the same behavior as setting
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
     * Builds {@link RequestOptions}. Get one by calling
import java.util.ArrayList;
        public void setTimeout(Duration timeout) {
            WarningsHandler warningsHandler,
            Map<String, List<String>> headers,
        }
            this.parameters.put(name, value);
        public Builder addHeaders(Map<String, List<String>> headers) {
            if (comma) b.append(", ");
            b.append("headers=");
        return Objects.hash(headers, parameters, warningsHandler);
        if (headers.size() > 0) {
            this.warningsHandler = warningsHandler;
    }
        }
    }
         * strictDeprecationMode to true. It can be set to
    public Builder toBuilder() {
            b.append("parameters=");
    private final WarningsHandler warningsHandler;
         * @throws NullPointerException if {@code name} or {@code value} is null.
            comma = true;
 *
        return warningsHandler;
    /**
         * {@linkplain WarningsHandler} to permit only certain warnings or to
        /**
         * @param value the query parameter value
        /**
     * <strong>exactly</strong> match some set.
        if (parameters.size() > 0) {
    public int hashCode() {
            Map<String, String> parameters,
    public Duration getTimeout() {
    @Override
        }
    public WarningsHandler getWarningsHandler() {
 * compatible open source license.
        }
     * strictDeprecationMode to false.
         * <p>
    }
    /**
    private final Map<String, String> parameters;
         *
         * @param warningsHandler the {@link WarningsHandler} to be used
        }
         * Sets request timeout
            comma = true;
 * manipulated without changing OpenSearch's behavior.
                header.getValue().forEach(v -> addHeader(header.getKey(), v));
            Objects.requireNonNull(value, "query parameter value cannot be null");
import java.util.Collections;
     * Headers to attach to the request.
 * under the License.
     * {@link WarningsHandler#STRICT} if the client should fail if there are
            Objects.requireNonNull(headers, "headers cannot be null");
    /**
         */
    }
     * It can also be set to a custom implementation of
     * @return request timeout
        return headers;
         *
    }
    /**
package org.opensearch.internal.httpclient;
         * will override matching parameters in the {@link Request}, if they exist.
            for (Map.Entry<String, List<String>> header : headers.entrySet()) {
         * strictDeprecationMode to false.
            this.parameters = new HashMap<>(parameters);
            return this;
        if (timeout != null) {
