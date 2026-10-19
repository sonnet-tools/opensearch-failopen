        StringBuilder b = new StringBuilder();  
     * manipulated without changing OpenSearch's behavior.
 * software distributed under the License is distributed on an
        this.method = Objects.requireNonNull(method, "method cannot be null");
 * compatible open source license.
        setEntity(entity == null ? null : new StringEntity(entity, ContentType.APPLICATION_JSON));  
    private RequestOptions options = RequestOptions.DEFAULT;
    public boolean equals(Object obj) {
 * GitHub history for details.
    public void addParameter(String name, String value) {  
     * @param paramSource a map of key value pairs where the key is the url parameter.  
     *
    /**
import java.util.Objects;
     * Set the body of the request to a string. If not set or set to  
     * Calculate the hash code of the request  
        }
     */
     *
    public String toString() {
    @Override
     */
    }  
    /**
        b.append("method='").append(method).append('\'');
     * Set the body of the request. If not set or set to {@code null} then no
            throw new IllegalArgumentException("url parameter [" + name + "] has already been set to [" + parameters.get(name) + "]");  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
     *      the parameter is sent as {@code name} rather than {@code name=value}
     * is sent with the request.
    /**
        return Objects.hash(method, endpoint, parameters, entity, options);
     *
        return options;
    public String getMethod() {
     */  
     */
    public void addParameters(Map<String, String> paramSource) {  
    }
     * The body of the request. If {@code null} then no body
     * @param entity JSON string to be set as the entity body of the request.  
    private HttpEntity entity;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * will change it.
/**
            Map<String, String> combinedParameters = new HashMap<>(parameters);
        }
 */  
    }
     */
            return false;  
     * @param method the HTTP method  
        this.entity = entity;
    /**  
 * KIND, either express or implied.  See the License for the
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        paramSource.forEach(this::addParameter);
    public String getEndpoint() {  
     * The HTTP method.  
        }  
     * @param name the name of the url parameter. Must not be null.  
        }  
     *
            return unmodifiableMap(parameters);
package org.opensearch.client;
}  
            combinedParameters.putAll(options.getParameters());
        return entity;
        this.options = options.build();
     * @param value the value of the url url parameter. If {@code null} then
        if (parameters.containsKey(name)) {
 *  
     * @throws NullPointerException if {@code options} is null.
     */  
     * If you need a different content type then use  
        if (options.getParameters().isEmpty()) {
    }  
 * Unless required by applicable law or agreed to in writing,
            && endpoint.equals(other.endpoint)
    public Map<String, String> getParameters() {  
    public void setEntity(HttpEntity entity) {
    /**
        Objects.requireNonNull(name, "url parameter name cannot be null");
     * Get the portion of an HTTP request to OpenSearch that can be  
    public void setJsonEntity(String entity) {
            && options.equals(other.options);
            b.append(", entity=").append(entity);
     */
        } else {  
     * map in the request so calls to {@link #addParameter(String, String)}  
 * under the License.  
    }
    private final Map<String, String> parameters = new HashMap<>();
import java.util.Map;  
import org.apache.hc.core5.http.ContentType;
 */
    }  
    /**
    public HttpEntity getEntity() {
    /**
     */
 * Modifications Copyright OpenSearch Contributors. See
     *
    /**
     * Compare two requests for equality  
 * this file be licensed under the Apache-2.0 license or a
        } else {
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
    }
        }  
    }
 * HTTP Request to OpenSearch.  
     * {@code null} then no body is sent with the request. The
    }  
    public void setOptions(RequestOptions options) {  
 *
        b.append(", options=").append(options);
            && parameters.equals(other.parameters)  
     * manipulated without changing OpenSearch's behavior.
     * {@link #setEntity(HttpEntity)}.
            parameters.put(name, value);
        this.endpoint = Objects.requireNonNull(endpoint, "endpoint cannot be null");
        return endpoint;
     * The path of the request (without scheme, host, port, or prefix).
            return unmodifiableMap(combinedParameters);  
    /**
        Request other = (Request) obj;  
        if (obj == null || (obj.getClass() != getClass())) {
    private final String endpoint;
    public Request(String method, String endpoint) {  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        if (false == parameters.isEmpty()) {
     * Add a query string parameter.
    /**
import static java.util.Collections.unmodifiableMap;  
        this.options = options;
 */
    }  
/*  
        Objects.requireNonNull(options, "options cannot be null");
     */
     */
    public int hashCode() {  
    }
        return method;  
     * Set the portion of an HTTP request to OpenSearch that can be  
 * ownership. Elasticsearch licenses this file to you under  
 *
     * @param options the options to be set.  
     * @throws NullPointerException if {@code options} is null.
     * Add query parameters using the provided map of key value pairs.
 * not use this file except in compliance with the License.
    public RequestOptions getOptions() {  
     * @param obj request instance to compare with
     */
        return b.append('}').toString();
/*  
     * Query string parameters. The returned map is an unmodifiable view of the
    private final String method;  
        b.append(", endpoint='").append(endpoint).append('\'');  
            b.append(", params=").append(parameters);
     */
import org.apache.hc.core5.http.io.entity.StringEntity;  
    }  
    }
        }
        Objects.requireNonNull(options, "options cannot be null");
     * @param options the options to be set.  
     * Convert request to string representation
 */  
    /**  
            && Objects.equals(entity, other.entity)
     * @param endpoint the path of the request (without scheme, host, port, or prefix)
    }  
     */  
    /**  
/*
     */
        return method.equals(other.method)
     */
    }
    public void setOptions(RequestOptions.Builder options) {  
    @Override  
    /**
     * @throws IllegalArgumentException if a parameter with that name has already been set.
import org.apache.hc.core5.http.HttpEntity;
     * {@code Content-Type} will be sent as {@code application/json}.
        if (obj == this) {
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
public final class Request {
     * manipulated without changing OpenSearch's behavior.
        b.append("Request{");
     * Create the {@linkplain Request}.
import java.util.HashMap;
     * Set the portion of an HTTP request to OpenSearch that can be  
     * body is sent with the request.  
     *      already been set
    /**
        if (entity != null) {
 * SPDX-License-Identifier: Apache-2.0
     * @throws IllegalArgumentException if a parameter with that name has  
     * @param entity the {@link HttpEntity} to be set as the body of the request.
            return true;  
