     * @return options
    }
 * HTTP Streaming Request to OpenSearch. <strong>This is an experimental API.</strong>
     */  
            throw new IllegalArgumentException("url parameter [" + name + "] has already been set to [" + parameters.get(name) + "]");  
     */
     *      already been set
        if (options.getParameters().isEmpty()) {
     */
     * @throws NullPointerException if {@code options} is null.  
     * manipulated without changing OpenSearch's behavior.  
     * @param name the name of the url parameter. Must not be null.  
     *
    }  
    public void addParameters(Map<String, String> paramSource) {  
    /**
     * @param paramSource a map of key value pairs where the key is the url parameter.  
        } else {  
     * Set the portion of an HTTP request to OpenSearch that can be
import static java.util.Collections.unmodifiableMap;
    }
        Objects.requireNonNull(options, "options cannot be null");  
     * @param options the options to be set.
     * @param publisher publisher  
     *
    /**
    }
    /**
 * SPDX-License-Identifier: Apache-2.0
     * @throws IllegalArgumentException if a parameter with that name has already been set.
    /**
    }  
     *
     */
     * Constructor  
    /**
     * Add a query string parameter.
 *
     * @throws NullPointerException if {@code options} is null.  
     * @throws IllegalArgumentException if a parameter with that name has  
     * @param options the options to be set.
/**  
    public String getMethod() {
     * @param method method
    public Map<String, String> getParameters() {  
     */
    }
    }
        return endpoint;
     * Body publisher
     * Get method
        Objects.requireNonNull(name, "url parameter name cannot be null");
            parameters.put(name, value);
package org.opensearch.client;
    }
    private final Map<String, String> parameters = new HashMap<>();  
    /**
     * Get options
    public Publisher<T> getBody() {
 * The OpenSearch Contributors require contributions made to  
        } else {
        this.options = options;
        return publisher;  
    public StreamingRequest(String method, String endpoint, Publisher<T> publisher) {
     * @return method  
    public void setOptions(RequestOptions.Builder options) {
        return method;  
    /**
        paramSource.forEach(this::addParameter);
 */
    }
     * @return endpoint
    /**
     * manipulated without changing OpenSearch's behavior.  
            Map<String, String> combinedParameters = new HashMap<>(parameters);
import java.util.Map;
    /**  
     */
 * compatible open source license.
    private final String method;
    /**  
}
        }
     */
 * this file be licensed under the Apache-2.0 license or a
     * @param endpoint endpoint
     * Add query parameters using the provided map of key value pairs.
import org.reactivestreams.Publisher;
    }
            return unmodifiableMap(combinedParameters);  
     */
    public String getEndpoint() {  
        }  
     */
public class StreamingRequest<T> {  
     * Set the portion of an HTTP request to OpenSearch that can be
import java.util.Objects;  
     * @return parameters
     * Get endpoint  
import java.util.HashMap;
    private final String endpoint;
        this.endpoint = endpoint;
        Objects.requireNonNull(options, "options cannot be null");  
    private RequestOptions options = RequestOptions.DEFAULT;
     * @param value the value of the url url parameter. If {@code null} then
    public RequestOptions getOptions() {
    public void setOptions(RequestOptions options) {
        return options;
            combinedParameters.putAll(options.getParameters());
 */  
    public void addParameter(String name, String value) {  
        this.options = options.build();
    private final Publisher<T> publisher;  
        this.method = method;  
            return unmodifiableMap(parameters);
     */
     * Get parameters  
     * @return body publisher  
        this.publisher = publisher;
     *      the parameter is sent as {@code name} rather than {@code name=value}
/*  
        if (parameters.containsKey(name)) {
