        private final List<Header> headers;
        }  
        }
         * and so on by request
            return this;  
import org.apache.hc.core5.http.message.BasicHeader;  
        return requestConfig;
    public int hashCode() {  
        if (obj == this) {  
    /**
 * You may obtain a copy of the License at  
     */
        StringBuilder b = new StringBuilder();
            Objects.requireNonNull(value, "header value cannot be null");
         * @param name  the header name
 *  
            this.httpAsyncResponseConsumerFactory = httpAsyncResponseConsumerFactory;
 * Licensed to Elasticsearch under one or more contributor  
    /**
        public void setWarningsHandler(WarningsHandler warningsHandler) {
        null,  
        public RequestOptions build() {  
         * Build the {@linkplain RequestOptions}.
         * @param name  the query parameter name
            this.requestConfig = requestConfig;  
     */
        @Override
    }
     * <strong>exactly</strong> match some set.
         * @param warningsHandler the {@link WarningsHandler} to be used  
            return false;
         * It can also be set to a custom implementation of
         * strictDeprecationMode to false.
     */
         * should ignore all warnings which is the same behavior as setting
            comma = true;  
 * software distributed under the License is distributed on an
            this.warningsHandler = warningsHandler;  
    public WarningsHandler getWarningsHandler() {
     * The {@link HttpAsyncResponseConsumerFactory} used to create one
    private final HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory;  
            );
            if (this == other) {  
     * fail the request if the warnings returned don't
    public Map<String, String> getParameters() {  
        /**  
        /**  
        if (parameters.size() > 0) {
    private final WarningsHandler warningsHandler;
         * @throws NullPointerException if {@code httpAsyncResponseConsumerFactory} is null.
     * any other {@linkplain RequestOptions}.
         * {@link AsyncResponseConsumer} callback per retry. Controls how the
         * @param httpAsyncResponseConsumerFactory factory for creating {@link AsyncResponseConsumer}.  
        b.append("RequestOptions{");
     * Default request options.  
     * Query parameters to attach to the request. Any parameters present here  
 * SPDX-License-Identifier: Apache-2.0
                }
    @Override
        ReqHeader(String name, String value) {  
            this.parameters.put(name, value);
        return new Builder(headers, parameters, httpAsyncResponseConsumerFactory, warningsHandler, requestConfig);
            b.append("headers=");
     */
     * hashCode so it is easier to test equality of {@link RequestOptions}.
         * How this request should handle warnings. If null (the default) then
        }  
     * @param obj request options instance to compare with
         *
            RequestConfig requestConfig  
    /**  
        }
            this.warningsHandler = warningsHandler;
 * the Apache License, Version 2.0 (the "License"); you may
         * {@linkplain WarningsHandler} to permit only certain warnings or to
        if (warningsHandler != null) {
                return true;
import org.apache.hc.core5.http.nio.AsyncResponseConsumer;
                httpAsyncResponseConsumerFactory,
            return true;
         */
     * {@link RestClientBuilder#setStrictDeprecationMode}.
        private HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory;  
            for (int h = 0; h < headers.size(); h++) {
            b.append("warningsHandler=").append(warningsHandler);
 * compatible open source license.
         */
 * this file be licensed under the Apache-2.0 license or a
    }  
                    b.append(',');  
 */
     * client side.
}  
 * specific language governing permissions and limitations
        return httpAsyncResponseConsumerFactory;
            if (comma) b.append(", ");
         * set RequestConfig, which can set socketTimeout, connectTimeout
            Objects.requireNonNull(name, "query parameter name cannot be null");  
     * Headers to attach to the request.
         */
 * KIND, either express or implied.  See the License for the
        this.httpAsyncResponseConsumerFactory = builder.httpAsyncResponseConsumerFactory;
     * Convert request options to string representation  
    /**  
         * @throws NullPointerException if {@code name} or {@code value} is null.  
     * Builds {@link RequestOptions}. Get one by calling
            HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory,
                if (h != 0) {
            comma = true;
        return parameters;
        }
        }
            return this;  
        if (httpAsyncResponseConsumerFactory != HttpAsyncResponseConsumerFactory.DEFAULT) {
    }
     * strictDeprecationMode to false.  
import java.util.stream.Collectors;
 *
/**  
         * Add the provided query parameter to the request. Any parameters added here
            Objects.requireNonNull(name, "header name cannot be null");  
        }
        RequestOptions other = (RequestOptions) obj;
            this.headers.add(new ReqHeader(name, value));
            }
 */  
        /**
        /**  
     * this request will default to the behavior dictacted by
     * and so on by request
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            b.append(parameters.entrySet().stream().map(e -> e.getKey() + "=" + e.getValue()).collect(Collectors.joining(",")));  
        public int hashCode() {
            this.requestConfig = requestConfig;
     * Create a builder that contains these options but can be modified.
        public Builder addParameter(String name, String value) {
        boolean comma = false;  
 * The OpenSearch Contributors require contributions made to  
        }
        this.parameters = Collections.unmodifiableMap(new HashMap<>(builder.parameters));  
import org.apache.hc.client5.http.config.RequestConfig;
    /**
 */  
    /**
    public static final RequestOptions DEFAULT = new Builder(
                return Objects.equals(getName(), otherHeader.getName()) && Objects.equals(getValue(), otherHeader.getValue());
     * This can be set to {@link WarningsHandler#PERMISSIVE} if the client
         * strictDeprecationMode to true. It can be set to
         * <p>
         * @param value the query parameter value
     */
        return Objects.hash(headers, parameters, httpAsyncResponseConsumerFactory, warningsHandler);
        /**
            return Objects.hash(getName(), getValue());  
        return headers.equals(other.headers)
     */  
        @Override
            super(name, value);
     * {@link WarningsHandler#STRICT} if the client should fail if there are
    }
            this.httpAsyncResponseConsumerFactory = Objects.requireNonNull(
    }
     */  
         * {@link WarningsHandler#STRICT} if the client should fail if there are  
     * get RequestConfig, which can set socketTimeout, connectTimeout  
    }  
            }  
        }
        private Builder(
    @Override
     * will override matching parameters in the {@link Request}, if they exist.
        return headers;
import java.util.List;
         *  
    private final List<Header> headers;
    /**
     */  
            comma = true;
            List<Header> headers,
import org.apache.hc.core5.http.Header;
 * not use this file except in compliance with the License.
         * @return Builder
        }
        public Builder addHeader(String name, String value) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
package org.opensearch.client;
    /**
        this.requestConfig = builder.requestConfig;  
import java.util.HashMap;  
        null
     * <p>  
            && Objects.equals(warningsHandler, other.warningsHandler);
    private final RequestConfig requestConfig;
            this.headers = new ArrayList<>(headers);
     * It can also be set to a custom implementation of
 * ownership. Elasticsearch licenses this file to you under  
         * This can be set to {@link WarningsHandler#PERMISSIVE} if the client  
 */  
         * fail the request if the warnings returned don't  
                b.append(headers.get(h).toString());
        private RequestConfig requestConfig;
            comma = true;  
 * this work for additional information regarding copyright
        this.warningsHandler = builder.warningsHandler;
     * Custom implementation of {@link BasicHeader} that overrides equals and
    }  
/*
 *
    }
     */
    public List<Header> getHeaders() {
    @Override
 * manipulated without changing OpenSearch's behavior.
         * <strong>exactly</strong> match some set.
         * Add the provided header to the request.
    public Builder toBuilder() {  
    public static class Builder {  
            WarningsHandler warningsHandler,
        HeapBufferedResponseConsumerFactory.DEFAULT,
        }
 * The portion of an HTTP request to OpenSearch that can be
        }
        private final Map<String, String> parameters;
            return new RequestOptions(this);
    }  
     */  
            b.append("parameters=");
        Collections.emptyList(),  
    /**  
            return false;
        public boolean equals(Object other) {
        }
/*  
            return this;
         * response body gets streamed from a non-blocking HTTP connection on the  
    public HttpAsyncResponseConsumerFactory getHttpAsyncResponseConsumerFactory() {
            && httpAsyncResponseConsumerFactory.equals(other.httpAsyncResponseConsumerFactory)
            if (comma) b.append(", ");  
        ) {
         * @param value the header value
 * under the License.  
     */  
     * How this request should handle warnings. If null (the default) then  
     * {@linkplain WarningsHandler} to permit only certain warnings or to  
     * @return RequestConfig
        return warningsHandler;
         *  
     * any warnings which is the same behavior as settings
     * Compare two request options for equality
        private WarningsHandler warningsHandler;
 * Modifications Copyright OpenSearch Contributors. See
    public RequestConfig getRequestConfig() {
public final class RequestOptions {
            }  
         */
        public void setHttpAsyncResponseConsumerFactory(HttpAsyncResponseConsumerFactory httpAsyncResponseConsumerFactory) {  
import org.opensearch.client.HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory;
     * Calculate the hash code of the request options  
         * @throws NullPointerException if {@code name} or {@code value} is null.  
         * Set the {@link HttpAsyncResponseConsumerFactory} used to create one
         * <p>  
        this.headers = Collections.unmodifiableList(new ArrayList<>(builder.headers));
            b.append("consumerFactory=").append(httpAsyncResponseConsumerFactory);
    private RequestOptions(Builder builder) {
    /**
 * license agreements. See the NOTICE file distributed with
            this.parameters = new HashMap<>(parameters);  
            if (other instanceof ReqHeader) {  
     * {@link RequestOptions#toBuilder} on {@link RequestOptions#DEFAULT} or  
    static final class ReqHeader extends BasicHeader {
 * Unless required by applicable law or agreed to in writing,
         * any warnings which is the same behavior as settings
                Header otherHeader = (Header) other;
        return b.append('}').toString();  
         */
        }
    private final Map<String, String> parameters;
import java.util.ArrayList;
         * client side.
            if (comma) b.append(", ");  
     * response body gets streamed from a non-blocking HTTP connection on the
    public String toString() {  
     * {@link AsyncResponseConsumer} callback per retry. Controls how the  
        public Builder setRequestConfig(RequestConfig requestConfig) {  
     * should ignore all warnings which is the same behavior as setting
        if (headers.size() > 0) {
    }
         */
         * will override matching parameters in the {@link Request}, if they exist.
        /**  
         * @param requestConfig http client RequestConfig  
        if (obj == null || (obj.getClass() != getClass())) {  
    ).build();
     * strictDeprecationMode to true. It can be set to  
    }
    /**
 * GitHub history for details.
            Objects.requireNonNull(value, "query parameter value cannot be null");
    public boolean equals(Object obj) {
         * {@link RestClientBuilder#setStrictDeprecationMode}.
            Map<String, String> parameters,  
import java.util.Map;
import java.util.Collections;
            && parameters.equals(other.parameters)  
     */  
         * this request will default to the behavior dictacted by  
        Collections.emptyMap(),
        }
         *
import java.util.Objects;  
/*  
     * <p>
                "httpAsyncResponseConsumerFactory cannot be null"  
