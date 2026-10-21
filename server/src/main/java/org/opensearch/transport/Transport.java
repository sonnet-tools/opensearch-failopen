        }
            return this.connection;
        public TransportResponseHandler<T> handler() {
                    if (remove != null) {
        if (publishPort < 0) {
            requestHandlers = MapBuilder.newMapBuilder(requestHandlers).put(reg.getAction(), reg).immutableMap();
import org.opensearch.core.transport.TransportResponse;
        void addCloseListener(ActionListener<Void> listener);
import java.util.List;
 * under the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        // TODO: Only visible for testing. Perhaps move StubbableTransport from
         * the original connection.
 */
        return false;
 * this file be licensed under the Apache-2.0 license or a
     * A unidirectional connection to a {@link DiscoveryNode}
         * @param action the action to execute
            final TransportMessageListener listener
import java.util.Map;
            if (context == null) {
 * license agreements. See the NOTICE file distributed with
    default <Request extends TransportRequest> void registerRequestHandler(RequestHandlerRegistry<Request> reg) {
        ResponseContext(TransportResponseHandler<T> handler, Connection connection, String action) {
    @PublicApi(since = "1.0.0")
     */
            ResponseContext<? extends TransportResponse> existing = handlers.put(requestId, holder);
            return requestIdGenerator.incrementAndGet();
     * @opensearch.api
    }
         * sent request (before any processing or deserialization was done). Returns the appropriate response handler or null if not
     * Returns an address from its string representation.
     * Resolve the publishPort for a server provided a list of boundAddresses and a publishInetAddress.
         * Removes and returns all {@link ResponseContext} instances that match the predicate
        /**
            return handlers.containsKey(requestId);
        @Override
            final long requestId,
     * Opens a new connection to the given node. When the connection is fully connected, the listener is called.
            .newConcurrentMapLongWithAggressiveConcurrency();
         */
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        }
import org.opensearch.Version;
        /**
                    break;
/**
        public String action() {
            for (Map.Entry<Long, ResponseContext<? extends TransportResponse>> entry : handlers.entrySet()) {
     * @opensearch.api
        private final ConcurrentMapLong<ResponseContext<? extends TransportResponse>> handlers = ConcurrentCollections
     * @param publishInetAddress address published for the server
            return handlers.remove(requestId);
 *
 * Modifications Copyright OpenSearch Contributors. See
         *
        private final AtomicLong requestIdGenerator = new AtomicLong();
     * The ActionListener will be called on the calling thread or the generic thread pool.
    }
                if (boundInetAddress.isAnyLocalAddress() || boundInetAddress.equals(publishInetAddress)) {
            }
        }
            boundAddresses.stream().map(TransportAddress::address).collect(Collectors.toList()),
 * ownership. Elasticsearch licenses this file to you under
    /**
package org.opensearch.transport;
import java.util.Set;
    /**
    /**
import org.opensearch.common.annotation.PublicApi;
         */
    /**
     * Further profile bound addresses
import java.net.InetAddress;
        /**
 * this work for additional information regarding copyright
        public List<ResponseContext<? extends TransportResponse>> prune(Predicate<ResponseContext<? extends TransportResponse>> predicate) {
        }
     * @return Resolved port. If publishPort is negative and no port can be resolved return publishPort.
                }
    }
        }
 * OpenSearch Transport Interface
 * The OpenSearch Contributors require contributions made to
        }
            return requestId;
        public ResponseContext<? extends TransportResponse> remove(long requestId) {
import org.opensearch.cluster.node.DiscoveryNode;
    }
         * Sends the request to the node this connection is associated with
 * GitHub history for details.
                ports.add(boundAddress.getPort());
import org.opensearch.common.unit.TimeValue;
 */
 * You may obtain a copy of the License at
                return null;
     *
         * {@link ActionListener#onFailure(Exception)} will not be called.
        /**
    @PublicApi(since = "1.0.0")
                throw new IllegalArgumentException("transport handlers for action " + reg.getAction() + " is already registered");
     */
     */
import org.opensearch.common.lifecycle.LifecycleComponent;
        );
        }
         */
    /**
     * Registers a new request handler
/*
 */
        /**
     *
        public Connection connection() {
    static int resolveTransportPublishPort(int publishPort, List<TransportAddress> boundAddresses, InetAddress publishInetAddress) {
            return handler;
                InetAddress boundInetAddress = boundAddress.getAddress();
     * Returns a list of all local addresses for this transport
    TransportStats getStats();
    ResponseHandlers getResponseHandlers();
            if (ports.size() == 1) {
    final class ResponseContext<T extends TransportResponse> {
        public <T extends TransportRequest> RequestHandlerRegistry<T> getHandler(String action) {
import java.util.function.Predicate;
     */
         * @return the new request ID
            }
        public long add(ResponseContext<? extends TransportResponse> holder) {
         */
 *
            }
         */
         * @param options request options to apply
     * The address the transport is bound on.
import org.opensearch.core.common.transport.BoundTransportAddress;
 * SPDX-License-Identifier: Apache-2.0
 *
            assert existing == null : "request ID already in use: " + requestId;
     */
         * Returns a new request ID to use when sending a message via {@link Connection#sendRequest(long, String,
import java.util.HashSet;
     * If a bound address is a wildcard address resolve to that port.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        /**
    Map<String, BoundTransportAddress> profileBoundAddresses();
        boolean isClosed();
            return this.action;
        default Object getCacheKey() {
import java.net.InetSocketAddress;
import java.util.stream.Collectors;
         * The node this connection is associated with
         */
import java.util.ArrayList;
        void close();
import java.io.Closeable;
            if (requestHandlers.containsKey(reg.getAction())) {
    }
        /**
    interface Connection extends Closeable {
 * compatible open source license.
                if (predicate.test(holder)) {
        long newRequestId() {
     */
            long requestId = newRequestId();
            final List<ResponseContext<? extends TransportResponse>> holders = new ArrayList<>();
        /**
         * <code>null</code> if no context is associated with this request ID.
            listener.onResponseReceived(requestId, context);
     */
     * Request handler implementations
            return holders;
    final class ResponseHandlers {
     * If a bound address matches the publishInetAddress resolve to that port.
     * @param boundAddresses addresses bound by the server
        getRequestHandlers().registerHandler(reg);
import org.opensearch.common.util.concurrent.ConcurrentMapLong;
            this.action = action;
        private final String action;
        }
import java.io.IOException;
    @PublicApi(since = "1.0.0")
    void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Transport.Connection> listener);
/*
        }
     * Resolution strategy is as follows:
    /**
         * @param request the request to send
    static int resolvePublishPort(int publishPort, List<InetSocketAddress> boundAddresses, InetAddress publishInetAddress) {
        /**
 * KIND, either express or implied.  See the License for the
         * Returns a key that this connection can be cached on. Delegating subclasses must delegate method call to
        default Version getVersion() {
    RequestHandlers getRequestHandlers();
            }
    }
        // org.opensearch.test.transport to org.opensearch.transport
    @PublicApi(since = "1.0.0")
        }
 * the Apache License, Version 2.0 (the "License"); you may
        @SuppressWarnings("unchecked")
                    }
            publishPort,
            requestHandlers = MapBuilder.newMapBuilder(requestHandlers).put(reg.getAction(), reg).immutableMap();
    }
     */
        public TransportResponseHandler<? extends TransportResponse> onResponseReceived(
         * The listener's {@link ActionListener#onResponse(Object)} method will be called when this
     * This class represents a response context that encapsulates the actual response handler, the action and the connection it was
     * @return <code>null</code> iff profiles are unsupported, otherwise a map with name of profile and its bound transport address
                        holders.add(holder);
     * If all bound addresses share the same port resolve to that port.
 * @opensearch.api
    default void setSlowLogThreshold(TimeValue slowLogThreshold) {}
 * software distributed under the License is distributed on an
                }
        }
     * This class is a registry that allows
    /**
        return publishPort;
            for (InetSocketAddress boundAddress : boundAddresses) {
    /**
    /**
                    publishPort = boundAddress.getPort();
            for (InetSocketAddress boundAddress : boundAddresses) {
            } else {
    void setMessageListener(TransportMessageListener listener);
     * If a configured port exists resolve to that port.
        private volatile Map<String, RequestHandlerRegistry<? extends TransportRequest>> requestHandlers = Collections.emptyMap();
                    ResponseContext<? extends TransportResponse> remove = handlers.remove(entry.getKey());
    /**
            }
         */
         * Removes and return the {@link ResponseContext} for the given request ID or returns
     * @opensearch.api
                ResponseContext<? extends TransportResponse> holder = entry.getValue();
        }
         */
            ResponseContext<? extends TransportResponse> context = handlers.remove(requestId);
    TransportAddress[] addressesFromString(String address) throws UnknownHostException;
         */
import java.net.UnknownHostException;
 *
        }
     */
            final Set<Integer> ports = new HashSet<>();
         * called by the {@link Transport} implementation when a response or an exception has been received for a previously
        private final Connection connection;
            }
         * Returns <code>true</code> if the give request ID has a context associated with it.
}
        if (publishPort < 0) {
/*
     *
         * connection is closed. No implementations currently throw an exception during close, so
            return this;
     */
 * Licensed to Elasticsearch under one or more contributor
public interface Transport extends LifecycleComponent {
import org.opensearch.core.action.ActionListener;
     *
         * found.
         * @param listener to be called
        /**
                return context.handler();
@PublicApi(since = "1.0.0")
        public boolean contains(long requestId) {
         */
     */
        private final TransportResponseHandler<T> handler;
 */
         * @param requestId see {@link ResponseHandlers#add(ResponseContext)} for details
        public synchronized <Request extends TransportRequest> void forceRegister(RequestHandlerRegistry<Request> reg) {
        ) {
import org.opensearch.common.collect.MapBuilder;
 * not use this file except in compliance with the License.
    BoundTransportAddress boundAddress();
import java.util.concurrent.atomic.AtomicLong;
    List<String> getDefaultSeedAddresses();
    final class RequestHandlers {
         * Adds a new response context and associates it with a new request ID.
            this.handler = handler;
            publishInetAddress
         */
         * Returns the version of the node this connection was established with.
     * @opensearch.api
            return (RequestHandlerRegistry<T>) requestHandlers.get(action);
    }
import java.util.Collections;
         * @see Connection#sendRequest(long, String, TransportRequest, TransportRequestOptions)
        }
         * TransportRequest, TransportRequestOptions)}
                publishPort = ports.iterator().next();
    /**
        }
 * specific language governing permissions and limitations
     * executed on.
    default boolean isSecure() {
            this.connection = connection;
        /**
        synchronized <Request extends TransportRequest> void registerHandler(RequestHandlerRegistry<Request> reg) {
         * @throws NodeNotConnectedException if the given node is not connected
        DiscoveryNode getNode();
     *
        }
        return Transport.resolvePublishPort(
import org.opensearch.core.common.transport.TransportAddress;
        }
     * @param publishPort -1 if no configured publish port exists
            return getNode().getVersion();
 * Unless required by applicable law or agreed to in writing,
        void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options) throws IOException,
            TransportException;
