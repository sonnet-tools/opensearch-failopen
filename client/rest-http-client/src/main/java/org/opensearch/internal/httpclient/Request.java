        return new Request.Builder(method, endpoint);  
 * SPDX-License-Identifier: Apache-2.0
     * will change it.
         * @throws NullPointerException if {@code options} is null.
import java.util.Map;
         * @param value the value of the url url parameter. If {@code null} then  
         * @throws IllegalArgumentException if a parameter with that name has
        }
         */  
        private BodyPublisher entity;
         */  
         */
         * @throws IllegalArgumentException if a parameter with that name has already been set.
        private final String endpoint;
            return this;  
    }
         * Set the portion of an HTTP request to OpenSearch that can be  
     */
         * manipulated without changing OpenSearch's behavior.
                parameters.put(name, value);
        }
        }  
        options = options == null ? RequestOptions.DEFAULT : options;
        }
         * {@code null} then no body is sent with the request. The
        /**
            this.options = options.build();
         */
         *  
            Objects.requireNonNull(options, "options cannot be null");
        /**
         * @param options the options to be set.
         *
        public Builder withEntity(String entity) {  
         * @param entity JSON string to be set as the entity body of the request.
            return this;
        /**  
        public Builder withParameters(Map<String, String> paramSource) {  
         * If you need a different content type then use
         */
        public Builder withParameter(String name, String value) {
        } else {
     * Query string parameters. The returned map is an unmodifiable view of the
        public Builder withOptions(RequestOptions.Builder options) {  
        /**  
            return unmodifiableMap(combinedParameters);
        if (options.getParameters().isEmpty()) {
            return this;  
            this.method = Objects.requireNonNull(method, "method cannot be null");
            combinedParameters.putAll(options.getParameters());  
    }  
            withEntity(entity == null ? BodyPublishers.noBody() : BodyPublishers.ofString(entity));
            return new Request(method, endpoint, parameters, entity, options);  
            return this;  
import java.util.Objects;
         * @param options the options to be set.  
            Objects.requireNonNull(options, "options cannot be null");
import java.net.http.HttpRequest.BodyPublishers;
        public Builder withOptions(RequestOptions options) {
    public Map<String, String> parameters() {
import static java.util.Collections.unmodifiableMap;
    public static Request.Builder newRequest(String method, String endpoint) {
        }
         */  
         * @param paramSource a map of key value pairs where the key is the url parameter.  
            this.options = options;  
        }
         * Add query parameters using the provided map of key value pairs.
import java.util.HashMap;  
        }  
        parameters = parameters == null ? new HashMap<>() : parameters;  
            return unmodifiableMap(parameters);  
    }
         * body is sent with the request.  
         * Set the body of the request. If not set or set to {@code null} then no
/*  
         * {@link #withEntity(BodyPublisher)}.
         * @param options the options to be set.
         *  
         *      the parameter is sent as {@code name} rather than {@code name=value}
         * Set the portion of an HTTP request to OpenSearch that can be
         *      already been set  
         * manipulated without changing OpenSearch's behavior.
         * Add a query string parameter.
            return this;
    }
         * @throws NullPointerException if {@code options} is null.
 *
 * HTTP Request to OpenSearch.
            Objects.requireNonNull(name, "url parameter name cannot be null");  
        private final String method;
    @Override  
            if (parameters.containsKey(name)) {
        }
import java.net.http.HttpRequest.BodyPublisher;
        }
         */
        private Builder(String method, String endpoint) {
/**  
         * {@code Content-Type} will be sent as {@code application/json}.  
 * The OpenSearch Contributors require contributions made to  
        public Request build() {
 */  
        private RequestOptions options = RequestOptions.DEFAULT;
 * compatible open source license.
        /**  
         * @param entity the {@link BodyPublisher} to be set as the body of the request.
            Map<String, String> combinedParameters = new HashMap<>(parameters);
         * Set the portion of an HTTP request to OpenSearch that can be
            this.endpoint = Objects.requireNonNull(endpoint, "endpoint cannot be null");  
package org.opensearch.internal.httpclient;
         *
         *
}  
        method = Objects.requireNonNull(method, "method cannot be null");
     * map in the request so calls to {@link Map#put(Object, Object)}  
            paramSource.forEach(this::withParameter);
            }
            Objects.requireNonNull(options, "options cannot be null");
            this.options = options;  
        private final Map<String, String> parameters = new HashMap<>();  
 * this file be licensed under the Apache-2.0 license or a
         * Set the body of the request to a string. If not set or set to
                throw new IllegalArgumentException("url parameter [" + name + "] has already been set to [" + parameters.get(name) + "]");
         *  
 * Note: This is an experimental API.
         * manipulated without changing OpenSearch's behavior.
            return this;
         * @param name the name of the url parameter. Must not be null.
    /**
        endpoint = Objects.requireNonNull(endpoint, "endpoint cannot be null");
    public static final class Builder {  
        }
         * @throws NullPointerException if {@code options} is null.
        /**  
        /**  
            } else {  
        public Builder withEntity(BodyPublisher entity) {
 */  
    public Request {  
            this.entity = entity;
        public void setOptions(RequestOptions options) {
public record Request(String method, String endpoint, Map<String, String> parameters, BodyPublisher entity, RequestOptions options) {
