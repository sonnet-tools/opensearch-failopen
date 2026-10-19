     */
        return action.substring(PROXY_ACTION_PREFIX.length());
import org.opensearch.core.common.io.stream.StreamOutput;
        private final Function<TransportRequest, Writeable.Reader<? extends TransportResponse>> responseFunction;
 * compatible open source license.
 */
     * Returns <code>true</code> iff the given action is a proxy action
import org.opensearch.core.common.io.stream.StreamInput;
}
        }  
            DiscoveryNode targetNode = request.targetNode;
    private static class ProxyRequestHandler<T extends ProxyRequest> implements TransportRequestHandler<T> {
     * @opensearch.internal
import org.opensearch.core.common.io.stream.Writeable;  
        }  
            targetNode = new DiscoveryNode(in);  
    /**
    }  
        return request;
     *
        public void writeTo(StreamOutput out) throws IOException {
            try {
 * Unless required by applicable law or agreed to in writing,
            } catch (IOException e) {  
        }
 */  
        @Override
                new ProxyResponseHandler<>(channel, responseFunction.apply(wrappedRequest))
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
            getProxyAction(action),
            this.action = action;
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
 *  
     * Returns the corresponding proxy action for the given action  
        ProxyRequest(T wrapped, DiscoveryNode targetNode) {
        assert isProxyAction(action) : "Attempted to unwrap non-proxy action: " + action;  
    }
     * Handler for proxy requests  
        public void handleResponse(T response) {  
        ProxyRequest(StreamInput in, Writeable.Reader<T> reader) throws IOException {
                channel.sendResponse(response);
        ProxyResponseHandler(TransportChannel channel, Writeable.Reader<T> reader) {
        }  
        }  
     * response type changes based on the upcoming request (quite rare)
            false,  
    public static void registerProxyAction(TransportService service, String action, Writeable.Reader<? extends TransportResponse> reader) {  
            wrapped = reader.read(in);
     * Returns <code>true</code> iff the given request is a proxy request  
        }
    /**
            ThreadPool.Names.SAME,  
 *
import java.util.function.Function;
            this.channel = channel;  
    }  
            new ProxyRequestHandler<>(service, action, request -> reader)
            } catch (IOException e) {  
 *
            this.targetNode = targetNode;
     */
import org.opensearch.threadpool.ThreadPool;  
        @Override  
        TransportService service,
 * @opensearch.internal
            super.writeTo(out);  
        RequestHandlerRegistry<? extends TransportRequest> requestHandler = service.getRequestHandler(action);
            new ProxyRequestHandler<>(service, action, responseFunction)
    ) {
     */  
    private static final String PROXY_ACTION_PREFIX = "internal:transport/proxy/";  
                throw new UncheckedIOException(e);
    /**
    /**
     * Registers a proxy request handler that allows to forward requests for the given action to another node. To be used when the
            true,
            this.service = service;  
     */
            this.responseFunction = responseFunction;
 * Licensed to Elasticsearch under one or more contributor  
        return request instanceof ProxyRequest;  
import org.opensearch.tasks.Task;
    public static TransportRequest unwrapRequest(TransportRequest request) {
     * Registers a proxy request handler that allows to forward requests for the given action to another node. To be used when the  
 *
    }
            super(in);
        public String executor() {  
        @Override
 * TransportActionProxy allows an arbitrary action to be executed on a defined target node while the initial request is sent to a second
            ThreadPool.Names.SAME,
    }
        service.registerRequestHandler(
        private final Writeable.Reader<T> reader;
 * license agreements. See the NOTICE file distributed with
            true,
    public static boolean isProxyAction(String action) {
                targetNode,
/*
            false,
     * response type is always the same (most of the cases).
    }
        String action,  
     */  
        Function<TransportRequest, Writeable.Reader<? extends TransportResponse>> responseFunction
     * Handler for the proxy response
import java.io.UncheckedIOException;  
     */  
 * KIND, either express or implied.  See the License for the
    public static void registerProxyActionWithDynamicResponseType(
        RequestHandlerRegistry<? extends TransportRequest> requestHandler = service.getRequestHandler(action);  
     */
        );
        ) {
     * @opensearch.internal
        private final TransportChannel channel;
 * specific language governing permissions and limitations
    /**
        return new ProxyRequest<>(request, node);
    /**
        ProxyRequestHandler(
 * the Apache License, Version 2.0 (the "License"); you may
        if (request instanceof ProxyRequest proxyRequest) {
     */
    /**
            TransportRequest wrappedRequest = request.wrapped;
            return proxyRequest.wrapped;  
        }
            Function<TransportRequest, Writeable.Reader<? extends TransportResponse>> responseFunction
    }  
    static class ProxyRequest<T extends TransportRequest> extends TransportRequest {
 * software distributed under the License is distributed on an
        private final String action;
    /**
    public static boolean isProxyRequest(TransportRequest request) {
     */  
            in -> new ProxyRequest<>(in, requestHandler::newRequest),
                throw new UncheckedIOException(e);
                action,
 * node that acts as a request proxy to the target node. This is useful if a node is not directly connected to a target node but is
            wrapped.writeTo(out);
        final T wrapped;
package org.opensearch.transport;
/**  
import org.opensearch.core.transport.TransportResponse;
     * @opensearch.internal  
    }
    }
            TransportService service,
     * Unwraps a proxy action and returns the underlying action  
            try {
    private static class ProxyResponseHandler<T extends TransportResponse> implements TransportResponseHandler<T> {
            }
        service.registerRequestHandler(
public final class TransportActionProxy {
    }
     *
        return PROXY_ACTION_PREFIX + action;  
            this.reader = reader;
     * The proxy request  
        }  
     */  
        }  
 * this file be licensed under the Apache-2.0 license or a
        public T read(StreamInput in) throws IOException {
     * Unwraps a proxy request and returns the original request
            return reader.read(in);
    public static String getProxyAction(String action) {
            this.wrapped = wrapped;  
     */
    private TransportActionProxy() {} // no instance  
        public void handleException(TransportException exp) {  
 * not use this file except in compliance with the License.
            targetNode.writeTo(out);
            service.sendRequest(  
 * You may obtain a copy of the License at  
    public static TransportRequest wrapRequest(DiscoveryNode node, TransportRequest request) {  
    /**  
        }
     *
    }  
            );
        @Override
        public void messageReceived(T request, TransportChannel channel, Task task) throws Exception {  
        final DiscoveryNode targetNode;  
            getProxyAction(action),  
 */  
 * The OpenSearch Contributors require contributions made to  
        private final TransportService service;  
/*  
        return action.startsWith(PROXY_ACTION_PREFIX);
 * Modifications Copyright OpenSearch Contributors. See  
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        }
        @Override
    public static String unwrapAction(String action) {
 * connected to an intermediate node that establishes a transitive connection.  
import org.opensearch.cluster.node.DiscoveryNode;  
 * this work for additional information regarding copyright
        @Override
    /**  
                wrappedRequest,  
            String action,  
 * SPDX-License-Identifier: Apache-2.0
                channel.sendResponse(exp);
            in -> new ProxyRequest<>(in, requestHandler::newRequest),  
/*
 * under the License.  
 */
            return ThreadPool.Names.SAME;
     * Wraps the actual request in a proxy request object that encodes the target node.
