     */
     * is sent with the request.
     * {@code null} then no body is sent with the request. The
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
        if (options.getParameters().isEmpty()) {
            b.append(", entity=").append(entity);
    /**
     * @throws NullPointerException if {@code options} is null.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void addParameters(Map<String, String> paramSource) {
     */
     * @param paramSource a map of key value pairs where the key is the url parameter.
     *
        setEntity(entity == null ? null : new StringEntity(entity, ContentType.APPLICATION_JSON));
     * map in the request so calls to {@link #addParameter(String, String)}
     * manipulated without changing OpenSearch's behavior.
     * Query string parameters. The returned map is an unmodifiable view of the
 * compatible open source license.
    public void setEntity(HttpEntity entity) {
public final class Request {
     * Set the portion of an HTTP request to OpenSearch that can be
     * Add a query string parameter.
import java.util.Map;
            combinedParameters.putAll(options.getParameters());
 * You may obtain a copy of the License at
        return Objects.hash(method, endpoint, parameters, entity, options);
    }
import org.apache.hc.core5.http.HttpEntity;
     * will change it.
        b.append(", options=").append(options);
 */
    public String getEndpoint() {
        Objects.requireNonNull(options, "options cannot be null");
     * manipulated without changing OpenSearch's behavior.
     * Get the portion of an HTTP request to OpenSearch that can be
    public int hashCode() {
 */
        b.append("Request{");
 *
        return options;
     * @param options the options to be set.
        } else {
    /**
     */
    public Map<String, String> getParameters() {
     * body is sent with the request.
     */
import static java.util.Collections.unmodifiableMap;
 * Modifications Copyright OpenSearch Contributors. See
    /**
            && Objects.equals(entity, other.entity)
        b.append(", endpoint='").append(endpoint).append('\'');
 * Unless required by applicable law or agreed to in writing,
     * @param options the options to be set.
    public void setOptions(RequestOptions options) {
 * The OpenSearch Contributors require contributions made to
            return unmodifiableMap(combinedParameters);
     */
        }
    /**
    }
 *
    }
    public void setJsonEntity(String entity) {
    public Request(String method, String endpoint) {
     */
        return endpoint;
        return method.equals(other.method)
    public HttpEntity getEntity() {
     */
    }
        if (obj == null || (obj.getClass() != getClass())) {
package org.opensearch.client;
        paramSource.forEach(this::addParameter);
            throw new IllegalArgumentException("url parameter [" + name + "] has already been set to [" + parameters.get(name) + "]");
import java.util.Objects;
     * {@link #setEntity(HttpEntity)}.
    }
    }
    /**
 * HTTP Request to OpenSearch.
        Objects.requireNonNull(name, "url parameter name cannot be null");
    @Override
     * The HTTP method.
 *
 * SPDX-License-Identifier: Apache-2.0
            && options.equals(other.options);
     * @param entity JSON string to be set as the entity body of the request.
        Request other = (Request) obj;
import org.apache.hc.core5.http.ContentType;
     *
     *
        this.endpoint = Objects.requireNonNull(endpoint, "endpoint cannot be null");
 */
     */
        b.append("method='").append(method).append('\'');
     */
 * the Apache License, Version 2.0 (the "License"); you may
            && parameters.equals(other.parameters)
        if (entity != null) {
     *      the parameter is sent as {@code name} rather than {@code name=value}
    /**
        this.options = options;
     * @param entity the {@link HttpEntity} to be set as the body of the request.
     * {@code Content-Type} will be sent as {@code application/json}.
    private HttpEntity entity;
    private RequestOptions options = RequestOptions.DEFAULT;
    /**
            return true;
    /**
        StringBuilder b = new StringBuilder();
        }
     * @throws IllegalArgumentException if a parameter with that name has already been set.
        return entity;
    }
        if (obj == this) {
     */
    public void addParameter(String name, String value) {
     * @param name the name of the url parameter. Must not be null.
     *
    public void setOptions(RequestOptions.Builder options) {
 * ownership. Elasticsearch licenses this file to you under
     * The path of the request (without scheme, host, port, or prefix).
     *      already been set
     * Set the portion of an HTTP request to OpenSearch that can be
     * @param obj request instance to compare with
    @Override
import org.apache.hc.core5.http.io.entity.StringEntity;
     * The body of the request. If {@code null} then no body
        return b.append('}').toString();
    private final Map<String, String> parameters = new HashMap<>();
            return unmodifiableMap(parameters);
            b.append(", params=").append(parameters);
 * KIND, either express or implied.  See the License for the
}
    private final String endpoint;
    /**
    }
    /**
        if (false == parameters.isEmpty()) {
     * Calculate the hash code of the request
 * under the License.
        }
     */
     * Set the body of the request to a string. If not set or set to
     */
    }
            Map<String, String> combinedParameters = new HashMap<>(parameters);
/**
     * @param value the value of the url url parameter. If {@code null} then
    /**
     */
 * software distributed under the License is distributed on an
     * manipulated without changing OpenSearch's behavior.
    public String getMethod() {
     * @param endpoint the path of the request (without scheme, host, port, or prefix)
        this.entity = entity;
     * If you need a different content type then use
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    public RequestOptions getOptions() {
 * license agreements. See the NOTICE file distributed with
     * @throws IllegalArgumentException if a parameter with that name has
    }
        Objects.requireNonNull(options, "options cannot be null");
        }
    /**
            && endpoint.equals(other.endpoint)
            parameters.put(name, value);
     */
    }
     * Convert request to string representation
    }
     * @throws NullPointerException if {@code options} is null.
    public boolean equals(Object obj) {
import java.util.HashMap;
        }
     */
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        }
     * @param method the HTTP method
     * Create the {@linkplain Request}.
     * Set the body of the request. If not set or set to {@code null} then no
/*
     * Add query parameters using the provided map of key value pairs.
        this.method = Objects.requireNonNull(method, "method cannot be null");
        } else {
    private final String method;
    }
        return method;
        this.options = options.build();
            return false;
    }
    /**
 */
/*
    @Override
    public String toString() {
    /**
    /**
        if (parameters.containsKey(name)) {
     * Compare two requests for equality
     *
