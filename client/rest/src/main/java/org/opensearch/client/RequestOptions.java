         * should ignore all warnings which is the same behavior as setting
         * @param name  the header name
        boolean comma = false;
         * {@linkplain WarningsHandler} to permit only certain warnings or to
         * How this request should handle warnings. If null (the default) then
         * @return Builder
     * will override matching parameters in the {@link Request}, if they exist.
     * {@linkplain WarningsHandler} to permit only certain warnings or to
import java.util.ArrayList;
     */
import org.apache.hc.client5.http.config.RequestConfig;
                httpAsyncResponseConsumerFactory,
            return false;
         * Add the provided query parameter to the request. Any parameters added here
        public Builder setRequestConfig(RequestConfig requestConfig) {
         * <p>
            b.append("parameters=");
            this.warningsHandler = warningsHandler;
     * fail the request if the warnings returned don't
 */
        public Builder addParameter(String name, String value) {
        /**
        this.warningsHandler = builder.warningsHandler;
         * {@link RestClientBuilder#setStrictDeprecationMode}.
     * This can be set to {@link WarningsHandler#PERMISSIVE} if the client
            Objects.requireNonNull(value, "header value cannot be null");
        public RequestOptions build() {
        }
     * strictDeprecationMode to false.
         * strictDeprecationMode to false.
    public static final RequestOptions DEFAULT = new Builder(
     * The {@link HttpAsyncResponseConsumerFactory} used to create one
            && parameters.equals(other.parameters)
    }
            && Objects.equals(warningsHandler, other.warningsHandler);
    /**
         * @param name  the query parameter name
    public List<Header> getHeaders() {
     * strictDeprecationMode to true. It can be set to
         * This can be set to {@link WarningsHandler#PERMISSIVE} if the client
import java.util.Map;
     * client side.
 */
        public void setHttpAsyncResponseConsumerFactory(HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory) {
     * Custom implementation of {@link BasicHeader} that overrides equals and
/**
    /**
     */
         * set RequestConfig, which can set socketTimeout, connectTimeout
            this.requestConfig = requestConfig;
        }
         * <p>
     * Create a builder that contains these options but can be modified.
     * <strong>exactly</strong> match some set.
 * this file be licensed under the Apache-2.0 license or a
            b.append(parameters.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(",")));
            HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory,
         */
                return true;
                b.append(headers.get(h).toString());
        /**
        @Override
public final class RequestOptions {
 * The OpenSearch Contributors require contributions made to
        }
            this.headers.add(new ReqHeader(name, value));
            List<Header> headers,
            return new RequestOptions(this);
 * software distributed under the License is distributed on an
                return Objects.equals(getName(), otherHeader.getName()) && Objects.equals(getValue(), otherHeader.getValue());
         */
         *
        if (obj == this) {
            return this;
            this.requestConfig = requestConfig;
 * GitHub history for details.
    public WarningsHandler getWarningsHandler() {
            this.parameters.put(name, value);
 */
        StringBuilder b = new StringBuilder();
    private final List<Header> headers;
    /**
         * @param httpAsyncResponseConsumerFactory factory for creating {@link AsyncResponseConsumer}.
         * strictDeprecationMode to true. It can be set to
 * not use this file except in compliance with the License.
            Objects.requireNonNull(value, "query parameter value cannot be null");
 * The portion of an HTTP request to OpenSearch that can be
        }
     */
    }
 *
 * SPDX-License-Identifier: Apache-2.0
            this.httpAsyncResponseConsumerFactory = Objects.requireNonNull(
            }
     * response body gets streamed from a non-blocking HTTP connection on the
        public Builder addHeader(String name, String value) {
            Objects.requireNonNull(name, "header name cannot be null");
    /**
         */
    }
         * @throws NullPointerException if {@code name} or {@code value} is null.
                    b.append(',');
            return this;
     * Query parameters to attach to the request. Any parameters present here
    private final WarningsHandler warningsHandler;
     */
        null
 */
            this.httpAsyncResponseConsumerFactory = httpAsyncResponseConsumerFactory;
        this.requestConfig = builder.requestConfig;
        HeapBufferedResponseConsumerFactory.DEFAULT,
            super(name, value);
import java.util.Objects;
        if (httpAsyncResponseConsumerFactory != HttpAsyncResponseConsumerFactory.DEFAULT) {
    /**
        return headers.equals(other.headers)
     * Convert request options to string representation
import java.util.stream.Collectors;
 *
    /**
            comma = true;
        if (obj == null || (obj.getClass() != getClass())) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private final HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory;
        b.append("RequestOptions{");
        Collections.emptyMap(),
import org.apache.hc.core5.http.Header;
    @Override
         * will override matching parameters in the {@link Request}, if they exist.
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
package org.opensearch.client;
 * compatible open source license.
        return headers;
     * Default request options.
            this.headers = new ArrayList<>(headers);
    }
}
         * It can also be set to a custom implementation of
            && httpAsyncResponseConsumerFactory.equals(other.httpAsyncResponseConsumerFactory)
        Collections.emptyList(),
        }
     * get RequestConfig, which can set socketTimeout, connectTimeout
     * this request will default to the behavior dictacted by
         * client side.
        this.parameters = Collections.unmodifiableMap(new HashMap<>(builder.parameters));
         * @param requestConfig http client RequestConfig
        }
    public Builder toBuilder() {
        }
    }
            Map<String, String> parameters,
    public String toString() {
     */
    /**
import org.apache.hc.core5.http.message.BasicHeader;
    }
 * under the License.
    }
            comma = true;
         *
    public Map<String, String> getParameters() {
            }
     * any warnings which is the same behavior as settings
import java.util.Collections;
     * should ignore all warnings which is the same behavior as setting
 * Unless required by applicable law or agreed to in writing,
            Objects.requireNonNull(name, "query parameter name cannot be null");
         *
import java.util.HashMap;
         *
        @Override
        return parameters;
    private final RequestConfig requestConfig;
         * Add the provided header to the request.
        }
 *
         * {@link WarningsHandler#STRICT} if the client should fail if there are
         * fail the request if the warnings returned don't
import org.opensearch.client.HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory;
                if (h != 0) {
        return httpAsyncResponseConsumerFactory;
         * @throws NullPointerException if {@code name} or {@code value} is null.
        null,
        return warningsHandler;
            b.append("headers=");
        }
        private final Map<String, String> parameters;
        return b.append('}').toString();
            for (int h = 0; h < headers.size(); h++) {
         * @param warningsHandler the {@link WarningsHandler} to be used
    /**
        ReqHeader(String name, String value) {
     * {@link RequestOptions#toBuilder} on {@link RequestOptions#DEFAULT} or
    /**
         * response body gets streamed from a non-blocking HTTP connection on the
         * {@link AsyncResponseConsumer} callback per retry. Controls how the
     */
    @Override
        /**
            );
    public boolean equals(Object obj) {
        }
            RequestConfig requestConfig
    @Override
     */
            this.parameters = new HashMap<>(parameters);
        if (warningsHandler != null) {
    public HttpAsyncResponseConsumerFactory getHttpAsyncResponseConsumerFactory() {
        private RequestConfig requestConfig;
 * this work for additional information regarding copyright
     * hashCode so it is easier to test equality of {@link RequestOptions}.
        }
        }
        private final List<Header> headers;
    public static class Builder {
    private RequestOptions(Builder builder) {
         * Set the {@link HttpAsyncResponseConsumerFactory} used to create one
 * Licensed to Elasticsearch under one or more contributor
        this.headers = Collections.unmodifiableList(new ArrayList<>(builder.headers));
     * It can also be set to a custom implementation of
            return this;
         * <strong>exactly</strong> match some set.
/*
         * and so on by request
        }
            comma = true;
     * @param obj request options instance to compare with
         * @param value the query parameter value
        private HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory;
     */
    }
 * Modifications Copyright OpenSearch Contributors. See
            if (comma) b.append(", ");
     * {@link RestClientBuilder#setStrictDeprecationMode}.
         * Build the {@linkplain RequestOptions}.
     * {@link WarningsHandler#STRICT} if the client should fail if there are
            return false;
     * <p>
     */
            comma = true;
     * {@link AsyncResponseConsumer} callback per retry. Controls how the
        return new Builder(headers, parameters, httpAsyncResponseConsumerFactory, warningsHandler, requestConfig);
        private Builder(
    private final Map<String, String> parameters;
 * license agreements. See the NOTICE file distributed with
        }
        return requestConfig;
        /**
    /**
     * Builds {@link RequestOptions}. Get one by calling
 * ownership. Elasticsearch licenses this file to you under
     * Headers to attach to the request.
     * @return RequestConfig
         */
     * Calculate the hash code of the request options
            WarningsHandler warningsHandler,
        ) {
/*
 * KIND, either express or implied.  See the License for the
            if (comma) b.append(", ");
 * manipulated without changing OpenSearch's behavior.
                Header otherHeader = (Header) other;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        this.httpAsyncResponseConsumerFactory = builder.httpAsyncResponseConsumerFactory;
         * @throws NullPointerException if {@code httpAsyncResponseConsumerFactory} is null.
            return Objects.hash(getName(), getValue());
         * this request will default to the behavior dictacted by
                "httpAsyncResponseConsumerFactory cannot be null"
     * any other {@linkplain RequestOptions}.
    }
            if (other instanceof ReqHeader) {
 * the Apache License, Version 2.0 (the "License"); you may
     * How this request should handle warnings. If null (the default) then
    }
     */
        /**
        }
    /**
         */
        return Objects.hash(headers, parameters, httpAsyncResponseConsumerFactory, warningsHandler);
    ).build();
         */
            this.warningsHandler = warningsHandler;
        RequestOptions other = (RequestOptions) obj;
import java.util.List;
        if (headers.size() > 0) {
    }
        /**
        public int hashCode() {
     */
    public int hashCode() {
    /**
         * @param value the header value
            }
        public boolean equals(Object other) {
     * and so on by request
    static final class ReqHeader extends BasicHeader {
            return true;
 * You may obtain a copy of the License at
                }
    public RequestConfig getRequestConfig() {
        }
            if (this == other) {
         * any warnings which is the same behavior as settings
            b.append("warningsHandler=").append(warningsHandler);
     */
        if (parameters.size() > 0) {
     * <p>
            if (comma) b.append(", ");
        public void setWarningsHandler(WarningsHandler warningsHandler) {
     * Compare two request options for equality
            b.append("consumerFactory=").append(httpAsyncResponseConsumerFactory);
    }
        private WarningsHandler warningsHandler;
 * specific language governing permissions and limitations
