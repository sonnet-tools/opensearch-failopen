         * @param method route method
    }  
        }
     */
     */
     * Indicates if the RestHandler supports working with pooled buffers. If the request handler will not escape the return
        private final RestHandler delegate;  
            this.deprecatedMethod = deprecatedMethod;  
     * @return true iff the handler supports requests that make use of pooled buffers
            this.deprecatedPath = deprecatedPath;
public interface RestHandler {  
     * {@code method} changed. The pre-existing {@code route} will be registered
            return delegate.toString();
     * @return new list of API routes prefixed with the prefix string  
        }
 * compatible open source license.
        /**  
         * @param prefix new route prefix  
    }
 * Unless required by applicable law or agreed to in writing,
     * Construct replaced routes using routes template and prefixes for new and deprecated paths
 */  
        public ReplacedRoute(Method method, String path, String deprecatedPath) {
        protected final String path;
 * Modifications Copyright OpenSearch Contributors. See
                return true;
                && Objects.equals(getPathWithPathParamsReplaced(), that.getPathWithPathParamsReplaced());  
            return delegate.supportsContentStream();
     * A list of routes handled by this RestHandler that are deprecated and do not have a direct  
        public boolean allowsUnsafeBuffers() {  
            }  
            Route that = (Route) o;
            this(route.getMethod(), prefix + route.getPath(), deprecatedPrefix + route.getPath());
        return false;
    /**
        public boolean supportsContentStream() {
     * @return {@code true} if requests handled by this class should be allowed to access system indices.
            return path.replaceAll("(?<=\\{).*?(?=\\})", "path_param");
    }
    }  
        @Override  
 * specific language governing permissions and limitations
    }
        public boolean allowSystemIndexAccessByDefault() {
     * @param prefix new prefix
        return Collections.emptyList();
 * @opensearch.api
     */
            super(method, path);
 */  
        }  
        private final String deprecationMessage;  
     * Represents an API that has been deprecated and is slated for removal.
        private final String deprecatedPath;  
        @Override
        }
        }  
        @Override
import org.opensearch.common.annotation.PublicApi;
         * Construct replaced routes using route method, new and deprecated paths
    /**
        public boolean isActionPaginated() {
     * Represents an API that has had its {@code path} or {@code method} changed. Holds both the
    /**
            return delegate.supportsStreaming();
        }
        }
            return delegate.replacedRoutes();
    /**
 * Licensed to Elasticsearch under one or more contributor  
    /**
     * Controls whether requests handled by this class are allowed to access system indices by default.  
     *
        }
        @Override
            return routeStr.hashCode();  
        public String getDeprecatedPath() {
import java.util.Collections;  
            return method;  
    }  
     * @param channel The channel to write the request response to
 * software distributed under the License is distributed on an
    static RestHandler wrapper(RestHandler delegate) {
        }
     */
/**
}
        public Method getDeprecatedMethod() {
        }
    @PublicApi(since = "1.0.0")
        }
    default boolean allowSystemIndexAccessByDefault() {  
        }
        public String toString() {
    }  
 * GitHub history for details.
        return new Wrapper(delegate);  
     * use {@link #replacedRoutes()}.
     * {@link XContent#streamSeparator()}. If a handler returns true this will affect the types of content that can be sent to
 * under the License.  
        }
        public boolean equals(Object o) {  
            if (this == o) {
     *  
            if (o == null || getClass() != o.getClass()) {
        public boolean canTripCircuitBreaker() {
        return false;
 */  
     * @opensearch.api
 *
        @Override  
     * Indicates if the RestHandler supports content as a stream. A stream would be multiple objects delineated by  
        public String toString() {
            this.delegate = Objects.requireNonNull(delegate, "RestHandler delegate can not be null");  
            this.method = method;  
        public ReplacedRoute(Route route, String prefix, String deprecatedPrefix) {  
 * You may obtain a copy of the License at  
        }
 *
 * not use this file except in compliance with the License.
        @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public String getDeprecationMessage() {
        }  
    /**  
        private final Method deprecatedMethod;
    default List<Route> routes() {
            return delegate.allowsUnsafeBuffers();
     * new and previous {@code path} and {@code method} combination.
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    default boolean canTripCircuitBreaker() {
        }  
        }
    default List<ReplacedRoute> replacedRoutes() {
                return false;
         * @param route route
            return delegate.routes();  
 * Handler for REST requests  
         * @param deprecatedPrefix deprecated prefix
         */
 */
import org.opensearch.core.xcontent.XContent;
        @Override  
         */  
            return deprecatedPath;
        }  
    static List<ReplacedRoute> replaceRoutes(List<Route> routes, final String prefix, final String deprecatedPrefix) {
        @Override
    default boolean isActionPaginated() {
        /**
     */  
         * @param path new route path
     * Handles a rest request.  
     */
     */
     */  
     */  
        }
     * @param client A client to use to make internal requests on behalf of the original request  
        @Override
    default boolean supportsStreaming() {  
     * this endpoint.
    }  
        public Wrapper(RestHandler delegate) {
        @Override  
     * The list of {@link Route}s that this RestHandler is responsible for handling.
/*
        @Override
            this.path = path;
        public List<Route> routes() {
        public String getPathWithPathParamsReplaced() {
            this(method, path, method, deprecatedPath);  
/*  
        public List<DeprecatedRoute> deprecatedRoutes() {
        public DeprecatedRoute(Method method, String path, String deprecationMessage) {
        public String getPath() {  
         * This constructor can be used when both new and deprecated paths use the same method  
    @PublicApi(since = "1.0.0")  
        return Collections.emptyList();
        return false;
        return false;
            }  
     *
     * @opensearch.internal  
     * A list of routes handled by this RestHandler that have had their {@code path} and/or  
     *  
            return "Route [method=" + method + ", path=" + path + "]";
            delegate.handleRequest(request, channel, client);
    class DeprecatedRoute extends Route {
    class Wrapper implements RestHandler {
import org.opensearch.transport.client.node.NodeClient;
    class Route {
            return delegate.allowSystemIndexAccessByDefault();  
     * Denotes whether the RestHandler will output paginated responses or not.
    /**
    class ReplacedRoute extends Route {
 * The OpenSearch Contributors require contributions made to  
            return deprecationMessage;
 * ownership. Elasticsearch licenses this file to you under  
@PublicApi(since = "1.0.0")
    default List<DeprecatedRoute> deprecatedRoutes() {
    }
            String routeStr = "Route [method=" + method + ", path=" + getPathWithPathParamsReplaced() + "]";
     * Indicates if the RestHandler supports request / response streaming. Please note that the transport engine has to support  
         * @param deprecatedPath deprecated path
        @Override  
    /**
        public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception {  
     * @param request The request to handle
     */  
import java.util.List;
    /**
     */  
     */
     * {@link RestRequest#content()} or any buffers extracted from it then there is no need to make a copies of any pooled buffers in the  
@FunctionalInterface
    }  
    /**  
        return false;
 * SPDX-License-Identifier: Apache-2.0
    }
        }  
/*  
 * license agreements. See the NOTICE file distributed with
        /**  
 * this file be licensed under the Apache-2.0 license or a
        }  
        return true;
        public List<ReplacedRoute> replacedRoutes() {  
        @Override
     * Wrapper for a handler.
            return Objects.equals(method, that.method)
    }  
        }
    /**
 * this work for additional information regarding copyright
         * Construct replaced routes using new and deprocated methods and new and deprecated paths
     * @opensearch.api
import java.util.stream.Collectors;  
    }
     * replacement. If changing the {@code path} or {@code method} of a route,
 *  
            return deprecatedMethod;  
    @PublicApi(since = "1.0.0")  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        }
import java.util.Objects;
     * {@link RestRequest#ensureSafeBuffers()} should be called on any request before passing it to {@link #handleRequest}.
        public int hashCode() {
    void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws Exception;
package org.opensearch.rest;
        public Route(Method method, String path) {
        protected final Method method;
        }
         */
     * Route for the request.  
        public boolean supportsStreaming() {  
         * @param path new route path  
    /**
    }
     * @param deprecatedPrefix deprecated prefix
    default boolean supportsContentStream() {
    /**
 *
     */  
    }
            return delegate.deprecatedRoutes();
            super(method, path);  
            return path;
            return delegate.isActionPaginated();
        return Collections.emptyList();
     * streaming as well.
         * Construct replaced routes using route, new and deprecated prefixes
     */
            this.deprecationMessage = deprecationMessage;
        return routes.stream().map(route -> new ReplacedRoute(route, prefix, deprecatedPrefix)).collect(Collectors.toList());  
        @Override
        public ReplacedRoute(Method method, String path, Method deprecatedMethod, String deprecatedPath) {
import org.opensearch.rest.RestRequest.Method;  
     * as deprecated alongside the updated {@code route}.
    default boolean allowsUnsafeBuffers() {  
        }
         * @param method route method
     * @param routes routes  
     * @opensearch.api
         * @param deprecatedPath deprecated path  
            return delegate.canTripCircuitBreaker();  
         * @param deprecatedMethod deprecated method
     *  
     * {@link RestRequest} instance before passing a request to this handler. If this instance does not support pooled/unsafe buffers
    /**
        public Method getMethod() {
