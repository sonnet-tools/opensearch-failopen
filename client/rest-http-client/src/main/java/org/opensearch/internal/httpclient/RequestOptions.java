         *
         *
     * @param obj request options instance to compare with  
            && Objects.equals(timeout, other.timeout)
        this.timeout = builder.timeout;
         *
    /**
            Duration timeout
        private final Map<String, String> parameters;  
        if (headers.size() > 0) {
     */  
         * @param name  the query parameter name
    public int hashCode() {
         * this request will default to the behavior dictacted by  
    }  
    public Duration getTimeout() {
        return timeout;
            b.append("timeout=").append(timeout.toMillis()).append("ms");  
 * KIND, either express or implied.  See the License for the
            b.append("warningsHandler=").append(warningsHandler);
        }  
    }
            Objects.requireNonNull(name, "header name cannot be null");
         */  
        this.parameters = Collections.unmodifiableMap(new HashMap<>(builder.parameters));  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
/*  
            return this;
            }
     * How this request should handle warnings. If null (the default) then
            b.append(parameters.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(",")));  
         * Add the provided query parameter to the request. Any parameters added here
         * any warnings which is the same behavior as settings
                header.getValue().forEach(v -> addHeader(header.getKey(), v));  
            this.warningsHandler = warningsHandler;  
        }  
/**
            Map<String, String> parameters,  
        this.warningsHandler = builder.warningsHandler;
         * @param warningsHandler the {@link WarningsHandler} to be used  
            return false;
    }
    /**
     * strictDeprecationMode to true. It can be set to
        public Builder addParameter(String name, String value) {  
         * <p>  
        return Objects.hash(headers, parameters, warningsHandler);
    public Map<String, List<String>> getHeaders() {  
    }
        /**
            this.headers = new HashMap<>(headers);
        RequestOptions other = (RequestOptions) obj;
            if (comma) b.append(", ");  
     * @return request timeout
 * under the License.  
        public void setWarningsHandler(WarningsHandler warningsHandler) {
    /**
}  
     */
        /**  
 * Modifications Copyright OpenSearch Contributors. See
     * should ignore all warnings which is the same behavior as setting  
            Objects.requireNonNull(headers, "headers cannot be null");
         */  
        }
     */
    /**
     * this request will default to the behavior dictacted by
     * Calculate the hash code of the request options
            if (comma) b.append(", ");  
    public Builder toBuilder() {
     */  
    /**
         * This can be set to {@link WarningsHandler#PERMISSIVE} if the client  
    }  
        if (obj == null || (obj.getClass() != getClass())) {
 * The OpenSearch Contributors require contributions made to  
 * manipulated without changing OpenSearch's behavior.  
    }
         * How this request should handle warnings. If null (the default) then
 */  
         * Sets request timeout  
     * any warnings which is the same behavior as settings  
        private Duration timeout = Duration.ofMillis(RestHttpClientBuilder.DEFAULT_RESPONSE_TIMEOUT_MILLIS);
     * Gets the request timeout
         *
            Objects.requireNonNull(value, "header value cannot be null");
         * @param value the query parameter value  
        public RequestOptions build() {
            Objects.requireNonNull(name, "query parameter name cannot be null");
import java.time.Duration;
            return new RequestOptions(this);
            comma = true;
    }
     */
 * software distributed under the License is distributed on an
    /**  
package org.opensearch.internal.httpclient;
 *
     * any other {@linkplain RequestOptions}.
 */
         * fail the request if the warnings returned don't  
        StringBuilder b = new StringBuilder();
            comma = true;
     * {@link RequestOptions#toBuilder} on {@link RequestOptions#DEFAULT} or
        if (timeout != null) {  
import java.util.Objects;
        private Builder(
    }
         * It can also be set to a custom implementation of
         * {@link WarningsHandler#STRICT} if the client should fail if there are  
        public void setTimeout(Duration timeout) {
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Headers to attach to the request.
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    @Override
     * will override matching parameters in the {@link Request}, if they exist.  
     * {@link WarningsHandler#STRICT} if the client should fail if there are
         */
    }
         *
        return warningsHandler;  
     */  
         */
            WarningsHandler warningsHandler,
     * <p>
    /**  
        if (warningsHandler != null) {
        return new Builder(headers, parameters, warningsHandler, timeout);  
            Objects.requireNonNull(timeout, "timeout cannot be null");
         * strictDeprecationMode to false.
    public WarningsHandler getWarningsHandler() {
            Objects.requireNonNull(value, "query parameter value cannot be null");
         * <strong>exactly</strong> match some set.
     * {@linkplain WarningsHandler} to permit only certain warnings or to
         * Add the provided header to the request.  
     * Compare two request options for equality
         * @param name  the header name
import java.util.Collections;  
    private final Duration timeout;
        if (parameters.size() > 0) {
         * should ignore all warnings which is the same behavior as setting
/*  
     * Default request options.
 * this work for additional information regarding copyright
            this.timeout = timeout;
    private final Map<String, List<String>> headers;
        }  
         * @param value the header value  
         * {@link RestHttpClientBuilder#setStrictDeprecationMode}.
     * {@link RestHttpClientBuilder#setStrictDeprecationMode}.  
            this.parameters.put(name, value);  
         * @param headers headers to add  
        /**
 * ownership. Elasticsearch licenses this file to you under  
    }  
        }
    private RequestOptions(Builder builder) {
 *  
         * will override matching parameters in the {@link Request}, if they exist.  
    /**
 * SPDX-License-Identifier: Apache-2.0
    ).build();  
        public Builder addHeaders(Map<String, List<String>> headers) {  
            if (comma) b.append(", ");
        /**
        ) {  
         */
         * <p>
    public static final RequestOptions DEFAULT = new Builder(
            this.timeout = timeout;  
        }
 */  
            Map<String, List<String>> headers,
/*
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
         * strictDeprecationMode to true. It can be set to
        }  
    public static class Builder {
     */
         * @throws NullPointerException if {@code name} or {@code value} is null.
     * strictDeprecationMode to false.
     * <strong>exactly</strong> match some set.  
        return parameters;  
 */
        return headers.equals(other.headers)  
     */
        }
        Collections.emptyMap(),  
    public Map<String, String> getParameters() {
 * specific language governing permissions and limitations
        Duration.ofMillis(RestHttpClientBuilder.DEFAULT_RESPONSE_TIMEOUT_MILLIS)
import java.util.HashMap;
public final class RequestOptions {  
    /**  
 * GitHub history for details.
        boolean comma = false;  
            return this;
 * The portion of an HTTP request to OpenSearch that can be
        }
 * You may obtain a copy of the License at  
    private final Map<String, String> parameters;  
        }
            return true;
import java.util.Map;  
            b.append("parameters=");
        if (obj == this) {
     * It can also be set to a custom implementation of  
        return b.append('}').toString();
            this.headers.computeIfAbsent(name, v -> new ArrayList<>()).add(value);  
         */
         * @throws NullPointerException if {@code name} or {@code value} is null.
            && Objects.equals(warningsHandler, other.warningsHandler);  
        Collections.emptyMap(),
        }
        return headers;
            comma = true;
        private final Map<String, List<String>> headers;
         * {@linkplain WarningsHandler} to permit only certain warnings or to
            b.append(headers.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(",")));
        private WarningsHandler warningsHandler;
     * <p>
            comma = true;
        null,
 *
         * Add the provided headers to the request.
     * Create a builder that contains these options but can be modified.  
 * compatible open source license.
         * Build the {@linkplain RequestOptions}.
        /**
            return this;
     * fail the request if the warnings returned don't
import java.util.ArrayList;
            for (Map.Entry<String, List<String>> header : headers.entrySet()) {
     * Builds {@link RequestOptions}. Get one by calling  
            this.warningsHandler = warningsHandler;  
    private final WarningsHandler warningsHandler;
 * Note: This is an experimental API.
            b.append("headers=");  
     * Convert request options to string representation  
    public String toString() {  
    @Override  
        }  
    /**  
    public boolean equals(Object obj) {  
            this.parameters = new HashMap<>(parameters);
     * This can be set to {@link WarningsHandler#PERMISSIVE} if the client
     */
import java.util.stream.Collectors;
        this.headers = Collections.unmodifiableMap(new HashMap<>(builder.headers));
         * @param timeout timeout
 * license agreements. See the NOTICE file distributed with
        /**
     */
    @Override
        public Builder addHeader(String name, String value) {  
         * @throws NullPointerException if {@code name} or {@code value} is null.
 * Licensed to Elasticsearch under one or more contributor  
     * Query parameters to attach to the request. Any parameters present here
        b.append("RequestOptions{");
            && parameters.equals(other.parameters)
