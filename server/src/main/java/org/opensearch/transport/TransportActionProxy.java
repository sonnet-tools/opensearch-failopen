            String action,
    }
        }
        ProxyResponseHandler(TransportChannel channel, Writeable.Reader<T> reader) {
        ) {
     * Handler for proxy requests
    private static class ProxyResponseHandler<T extends TransportResponse> implements TransportResponseHandler<T> {
}
     * @opensearch.internal
 */
                throw new UncheckedIOException(e);
     * @opensearch.internal
     */
        }
 */
     *
        @Override
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        String action,
        }
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        TransportService service,
    /**
 * not use this file except in compliance with the License.
    private static class ProxyRequestHandler<T extends ProxyRequest> implements TransportRequestHandler<T> {
/**
        public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {
     *
    /**
     * Wraps the actual request in a proxy request object that encodes the target node.
     * @opensearch.internal
    public static void registerProxyAction(TransportService service, String action, Writeable.Reader<? extends TransportResponse> reader) {
     */
        ProxyRequest(StreamInput in, Writeable.Reader<T> reader) throws IOException {
            targetNode.writeTo(out);
     * Returns <code>true</code> iff the given action is a proxy action
            wrapped.writeTo(out);
        @Override
    }
        return PROXY_ACTION_PREFIX + action;
                throw new UncheckedIOException(e);
            false,
        private final Writeable.Reader<T> reader;
        public void handleException(TransportException exp) {
            getProxyAction(action),
    /**
            }
    /**
            TransportRequest wrappedRequest = request.wrapped;
        public void handleResponse(T response) {
 * Licensed to Elasticsearch under one or more contributor
        service.registerRequestHandler(
     * response type is always the same (most of the cases).
     */
            TransportService service,
        @Override
    /**
     */
 * Unless required by applicable law or agreed to in writing,
            in -> new ProxyRequest<>(in, requestHandler::newRequest),
                new ProxyResponseHandler<>(channel, responseFunction.apply(wrappedRequest))
    /**
     * Unwraps a proxy action and returns the underlying action
                targetNode,
    private static final String PROXY_ACTION_PREFIX = "internal:transport/proxy/";
     */
 * The OpenSearch Contributors require contributions made to
     * Returns <code>true</code> iff the given request is a proxy request
            super(in);
            this.action = action;
            this.targetNode = targetNode;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * Handler for the proxy response
/*
 * You may obtain a copy of the License at
                channel.sendResponse(response);
 *
        private final TransportService service;
     *
            } catch (IOException e) {
     */
    /**
        ProxyRequest(T wrapped, DiscoveryNode targetNode) {
        @Override
        }
        service.registerRequestHandler(
        final T wrapped;
import org.opensearch.core.transport.TransportResponse;
            ThreadPool.Names.SAME,
            true,
            } catch (IOException e) {
        @Override
            DiscoveryNode targetNode = request.targetNode;
    ) {
    public static boolean isProxyAction(String action) {
            getProxyAction(action),
public final class TransportActionProxy {
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
            new ProxyRequestHandler<>(service, action, request -> reader)
    public static boolean isProxyRequest(TransportRequest request) {
        assert isProxyAction(action) : "Attempted to unwrap non-proxy action: " + action;
        public void writeTo(StreamOutput out) throws IOException {
import java.util.function.Function;
            false,
    /**
 *
        }
            return ThreadPool.Names.SAME;
 * software distributed under the License is distributed on an
            this.wrapped = wrapped;
            }
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.opensearch.cluster.node.DiscoveryNode;
 *
            ThreadPool.Names.SAME,
            this.responseFunction = responseFunction;
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
        }
 * connected to an intermediate node that establishes a transitive connection.
 */
                action,
    private TransportActionProxy() {} // no instance
    }
        public T read(StreamInput in) throws IOException {
 * @opensearch.internal
     */
    }
        }
     */
            this.service = service;
            return proxyRequest.wrapped;
            service.sendRequest(
    public static TransportRequest unwrapRequest(TransportRequest request) {
        RequestHandlerRegistry<? extends TransportRequest> requestHandler = service.getRequestHandler(action);
            in -> new ProxyRequest<>(in, requestHandler::newRequest),
        final DiscoveryNode targetNode;
    public static void registerProxyActionWithDynamicResponseType(
        return action.substring(PROXY_ACTION_PREFIX.length());
            );
            Function<TransportRequest, Writeable.Reader<? extends TransportResponse>> responseFunction
     * Registers a proxy request handler that allows to forward requests for the given action to another node. To be used when the
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    public static TransportRequest wrapRequest(DiscoveryNode node, TransportRequest request) {
    public static String unwrapAction(String action) {
            wrapped = reader.read(in);
    /**
        if (request instanceof ProxyRequest proxyRequest) {
    }
        return new ProxyRequest<>(request, node);
        private final Function<TransportRequest, Writeable.Reader<? extends TransportResponse>> responseFunction;
        return request;
        RequestHandlerRegistry<? extends TransportRequest> requestHandler = service.getRequestHandler(action);
    public static String getProxyAction(String action) {
import java.io.UncheckedIOException;
/*
     * Unwraps a proxy request and returns the original request
            targetNode = new DiscoveryNode(in);
        );
            try {
            true,
    /**
 * TransportActionProxy allows an arbitrary action to be executed on a defined target node while the initial request is sent to a second
package org.opensearch.transport;
 * this work for additional information regarding copyright
        return action.startsWith(PROXY_ACTION_PREFIX);
 * compatible open source license.
            try {
        Function<TransportRequest, Writeable.Reader<? extends TransportResponse>> responseFunction
 * specific language governing permissions and limitations
import org.opensearch.tasks.Task;
     */
import org.opensearch.threadpool.ThreadPool;
 * node that acts as a request proxy to the target node. This is useful if a node is not directly connected to a target node but is
        public String executor() {
        }
            this.channel = channel;
    }
     * Registers a proxy request handler that allows to forward requests for the given action to another node. To be used when the
            this.reader = reader;
    /**
 * KIND, either express or implied.  See the License for the
    static class ProxyRequest<T extends TransportRequest> extends TransportRequest {
    }
            new ProxyRequestHandler<>(service, action, responseFunction)
 *
        }
 * this file be licensed under the Apache-2.0 license or a
     */
     * The proxy request
        private final String action;
import java.io.IOException;
            return reader.read(in);
                wrappedRequest,
        private final TransportChannel channel;
        ProxyRequestHandler(
     */
/*
 * under the License.
                channel.sendResponse(exp);
import org.opensearch.core.common.io.stream.StreamOutput;
            super.writeTo(out);
import org.opensearch.core.common.io.stream.Writeable;
    }
     * response type changes based on the upcoming request (quite rare)
        }
        return request instanceof ProxyRequest;
 */
        );
     * Returns the corresponding proxy action for the given action
