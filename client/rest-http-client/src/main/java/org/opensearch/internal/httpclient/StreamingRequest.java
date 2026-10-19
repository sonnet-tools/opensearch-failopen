    public RequestOptions options() {
         *
public final class StreamingRequest {
     * @param method method
        if (options.getParameters().isEmpty()) {
            if (parameters.containsKey(name)) {  
         * @throws IllegalArgumentException if a parameter with that name has already been set.  
        private Builder(String method, String endpoint, Publisher<ByteBuffer> publisher) {
    public String method() {  
     */
    /**  
        }  
 * Note: This is an experimental API.  
         * @throws NullPointerException if {@code options} is null.  
        /**
        private final Publisher<ByteBuffer> publisher;
        } else {
            this.options = options.build();
         * @param value the value of the url url parameter. If {@code null} then
            } else {
            combinedParameters.putAll(options.getParameters());  
    /**  
     * Get options
    }  
    }
    }
         */  
            return this;  
            Objects.requireNonNull(options, "options cannot be null");
        public Builder withOptions(RequestOptions options) {  
         * Add a query string parameter.  
         * Add query parameters using the provided map of key value pairs.  
import java.nio.ByteBuffer;
            Objects.requireNonNull(name, "url parameter name cannot be null");
        private final String endpoint;  
}
         *
     * @param options request options
         * @param options the options to be set.
         */
        }  
        Map<String, String> parameters,
         *      already been set
         * Set the portion of an HTTP request to OpenSearch that can be
    }
        String method,
     * Body publisher  
            this.endpoint = Objects.requireNonNull(endpoint, "endpoint cannot be null");
    /**
    ) {
         * manipulated without changing OpenSearch's behavior.  
         */
import static java.util.Collections.unmodifiableMap;
         * Set the portion of an HTTP request to OpenSearch that can be  
         *
         * manipulated without changing OpenSearch's behavior.
 * SPDX-License-Identifier: Apache-2.0
     * @param publisher publisher
         * @throws NullPointerException if {@code options} is null.
     * @return method
     * @param endpoint endpoint  
        public Builder withParameters(Map<String, String> paramSource) {
     */  
     * @return options  
        this.endpoint = endpoint;  
    public String endpoint() {
import java.util.Map;  
        private final Map<String, String> parameters = new HashMap<>();
package org.opensearch.internal.httpclient;
import org.reactivestreams.Publisher;  
    private final String method;  
     */  
        public Builder withParameter(String name, String value) {
     * Constructor
        private RequestOptions options = RequestOptions.DEFAULT;  
         *      the parameter is sent as {@code name} rather than {@code name=value}  
    private StreamingRequest(
            return this;
            return this;
    /**
    /**
    public static final class Builder {
            return this;
     */
        return options;  
    }
        Publisher<ByteBuffer> publisher,
     * Constructor
     * Constructor
         * @param options the options to be set.  
        public Builder withOptions(RequestOptions.Builder options) {
        }  
        String method,  
        String endpoint,
     * @param builder request options builder
     */
    }  
    }  
        public void setOptions(RequestOptions options) {  
 *
         * @param options the options to be set.  
        this.publisher = publisher;
     * @param publisher publisher
        Publisher<ByteBuffer> publisher,  
        return new StreamingRequest.Builder(method, endpoint, publisher);  
    /**  
            this.options = options;
        this(method, endpoint, parameters, publisher, builder.build());  
     * @param endpoint endpoint
     * @return parameters
/*  
        /**
            this.publisher = Objects.requireNonNull(publisher, "publisher cannot be null");
    private final RequestOptions options;  
        return publisher;
            Objects.requireNonNull(options, "options cannot be null");  
     * @param method method
     * Get endpoint
                parameters.put(name, value);  
        String endpoint,  
         * Set the portion of an HTTP request to OpenSearch that can be  
    /**
        RequestOptions.Builder builder
            return unmodifiableMap(combinedParameters);
         * @throws NullPointerException if {@code options} is null.
    }
import java.util.HashMap;
        }  
    public static StreamingRequest.Builder newRequest(String method, String endpoint, Publisher<ByteBuffer> publisher) {
 */  
    private final Map<String, String> parameters = new HashMap<>();
     * @param endpoint endpoint  
     * @return endpoint
     * @param publisher publisher  
    private StreamingRequest(String method, String endpoint, Publisher<ByteBuffer> publisher) {  
    public Map<String, String> parameters() {
         * @param name the name of the url parameter. Must not be null.
    /**  
        }
     */
    }
        this.method = method;
         */
    private final Publisher<ByteBuffer> publisher;
        }
            this.options = options;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
         * @throws IllegalArgumentException if a parameter with that name has
        private final String method;
     * @return body publisher
        return method;
        /**
/**
        }
    private StreamingRequest(
            paramSource.forEach(this::withParameter);  
                throw new IllegalArgumentException("url parameter [" + name + "] has already been set to [" + parameters.get(name) + "]");
         */
     * Get method  
     */
        this.options = options;
        }
    ) {
    public Publisher<ByteBuffer> body() {  
        Map<String, String> parameters,
            Objects.requireNonNull(options, "options cannot be null");
 * compatible open source license.
        RequestOptions options  
            this.method = Objects.requireNonNull(method, "method cannot be null");  
        /**
            return unmodifiableMap(parameters);  
        /**
     * @param method method  
 */
            Map<String, String> combinedParameters = new HashMap<>(parameters);
    }  
         * manipulated without changing OpenSearch's behavior.
     * Get parameters
            return new StreamingRequest(method, endpoint, parameters, publisher, options);
    private final String endpoint;
     */  
            }
        this(method, endpoint, Map.of(), publisher, RequestOptions.DEFAULT);
 * HTTP Streaming Request to OpenSearch.
         *
import java.util.Objects;
         * @param paramSource a map of key value pairs where the key is the url parameter.
        public StreamingRequest build() {  
        return endpoint;
