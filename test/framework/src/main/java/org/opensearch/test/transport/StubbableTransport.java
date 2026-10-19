        return delegate.getRequestHandlers().getHandler(actionName) != null;
            (delegatedListener, connection) -> delegatedListener.onResponse(new WrappedConnection(connection))
        return connectBehaviors.put(transportAddress, connectBehavior) == null;
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
            throws IOException;
        return delegate.getStats();
        delegate.setMessageListener(listener);
            behavior.clearCallback();
    }
        @Override
import org.opensearch.transport.TransportMessageListener;
            return connection.getNode();
        @Override
        delegate.stop();
    }
        );
    @FunctionalInterface
    }
import java.net.UnknownHostException;
     * Returns {@code true} if the underlying delegate transport has a
/*
    <Request extends TransportRequest> void addRequestHandlingBehavior(String actionName, RequestHandlingBehavior<Request> behavior) {
        if (realRegistry == null) {
            ActionListener<Connection> listener
    @Override
 */
    public void stop() {
        void messageReceived(TransportRequestHandler<Request> handler, Request request, TransportChannel channel, Task task)
import java.io.IOException;
        }
package org.opensearch.test.transport;
     * {@link MockTransportService#addRequestHandlingBehavior(String, RequestHandlingBehavior)}
            return connection;
        }
import org.opensearch.transport.TransportRequestOptions;
    }
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
        OpenConnectionBehavior prior = this.defaultConnectBehavior;
    public Map<String, BoundTransportAddress> profileBoundAddresses() {
        OpenConnectionBehavior openConnectionBehavior = connectBehaviors.remove(transportAddress);
        public Transport.Connection getConnection() {
    @Override
    boolean hasHandler(String actionName) {
            (request, channel, task) -> behavior.messageReceived(realHandler, request, channel, task)
        return delegate.addressesFromString(address);
    }
 * this file be licensed under the Apache-2.0 license or a
        final RequestHandlerRegistry<Request> realRegistry = requestHandlers.getHandler(actionName);
     */
import org.opensearch.core.common.transport.BoundTransportAddress;
    public Lifecycle.State lifecycleState() {
            ConnectionProfile profile,
        final RequestHandlerRegistry<Request> newRegistry = RequestHandlerRegistry.replaceHandler(
            DiscoveryNode discoveryNode,
 *
    }
    @Override
            Transport transport,
    }
    }
        return delegate.getRequestHandlers();
        requestHandlers.forceRegister(newRegistry);
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Connection> listener) {
        sendBehaviors.clear();
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
        clearInboundBehaviors();
    @Override
        return delegate;
    void clearOutboundBehaviors() {
        this.defaultSendRequest = null;
 * ownership. Elasticsearch licenses this file to you under
    }
        final RequestHandlers requestHandlers = delegate.getRequestHandlers();
            if (behavior == null) {
        @Override
    }
        return delegate.getResponseHandlers();
                behavior.sendRequest(connection, requestId, action, request, options);
import org.opensearch.transport.TransportStats;
        if (behavior != null) {
    public void addLifecycleListener(LifecycleListener listener) {
import org.opensearch.transport.TransportRequest;
        private final Transport.Connection connection;
        this.defaultConnectBehavior = null;
        this.defaultConnectBehavior = openConnectionBehavior;
    public boolean setDefaultConnectBehavior(OpenConnectionBehavior openConnectionBehavior) {
        OpenConnectionBehavior behavior = connectBehaviors.getOrDefault(address, defaultConnectBehavior);
        public void close() {
    }
            realRegistry,
        return delegate.lifecycleState();
        default void clearCallback() {}
        return prior == null;
        }
    public void close() {
 * Unless required by applicable law or agreed to in writing,
        replacedRequestRegistries.clear();
        ActionListener<Connection> wrappedListener = ActionListener.delegateFailure(
import org.opensearch.common.lifecycle.Lifecycle;
 */
            openConnectionBehavior.clearCallback();
    private final ConcurrentHashMap<String, RequestHandlerRegistry<?>> replacedRequestRegistries = new ConcurrentHashMap<>();
    @Override
    @Override
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (behavior == null) {
    }
        return sendBehaviors.put(transportAddress, sendBehavior) == null;
    }
    }
        void sendRequest(Connection connection, long requestId, String action, TransportRequest request, TransportRequestOptions options)
        }
    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
import org.opensearch.transport.TransportException;
/*
        SendRequestBehavior behavior = sendBehaviors.remove(transportAddress);
        }
 * KIND, either express or implied.  See the License for the
    public class WrappedConnection implements Transport.Connection {
 * software distributed under the License is distributed on an
import org.opensearch.Version;
    public interface SendRequestBehavior {
            TransportAddress address = connection.getNode().getAddress();
        if (openConnectionBehavior != null) {
        final TransportRequestHandler<Request> realHandler = realRegistry.getHandler();
    @FunctionalInterface
        delegate.close();
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.transport.TransportChannel;
    @Override
                connection.sendRequest(requestId, action, request, options);
    @Override
        }
        } else {
        }
    private final ConcurrentHashMap<TransportAddress, OpenConnectionBehavior> connectBehaviors = new ConcurrentHashMap<>();
        public boolean isClosed() {
    Transport getDelegate() {
    void clearInboundBehaviors() {
        delegate.removeLifecycleListener(listener);
    void clearBehaviors() {
    @Override
    /**
    private volatile OpenConnectionBehavior defaultConnectBehavior = null;
    }
            listener,
        default void clearCallback() {}
    }
        );
    }
    }
    private final Transport delegate;
        public DiscoveryNode getNode() {
            throws Exception;
        public Version getVersion() {
    public TransportStats getStats() {
        defaultSendRequest = sendBehavior;
        }
 * under the License.
 * license agreements. See the NOTICE file distributed with
 *
        this.delegate = transport;
            throws IOException, TransportException {
        }
        delegate.addLifecycleListener(listener);
    public TransportAddress[] addressesFromString(String address) throws UnknownHostException {
    public StubbableTransport(Transport transport) {
            connection.addCloseListener(listener);
    }
        delegate.start();
    public BoundTransportAddress boundAddress() {
    @Override
    }
public class StubbableTransport implements Transport {
        @Override
        TransportAddress address = node.getAddress();
    }
    }
        connectBehaviors.clear();
        }
    }
    boolean addConnectBehavior(TransportAddress transportAddress, OpenConnectionBehavior connectBehavior) {
}
            getRequestHandlers().forceRegister(entry.getValue());
import org.opensearch.transport.ConnectionProfile;
            return connection.getVersion();
    }
        return delegate.profileBoundAddresses();
    }
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    }
        }
        for (Map.Entry<String, RequestHandlerRegistry<?>> entry : replacedRequestRegistries.entrySet()) {
    private final ConcurrentHashMap<TransportAddress, SendRequestBehavior> sendBehaviors = new ConcurrentHashMap<>();
    @FunctionalInterface
        return delegate.getDefaultSeedAddresses();
    public RequestHandlers getRequestHandlers() {
            }
    @Override
    public void start() {
        public void addCloseListener(ActionListener<Void> listener) {
    }
    @Override
            throw new IllegalStateException("Cannot find registered action for: " + actionName);
import org.opensearch.cluster.node.DiscoveryNode;
    public void setMessageListener(TransportMessageListener listener) {
import java.util.concurrent.ConcurrentHashMap;
            this.connection = connection;
     * registered request handler for the given action name. Used by
        return delegate.boundAddress();
        public Object getCacheKey() {
 * compatible open source license.
     * to decide which transport (regular vs streaming) owns the action.
import org.opensearch.tasks.Task;
import java.util.Map;
        default void clearCallback() {}
        @Override
        return prior == null;
        }
import org.opensearch.transport.TransportRequestHandler;
            delegate.openConnection(node, profile, wrappedListener);
 */
import java.util.List;
        @Override
        SendRequestBehavior prior = defaultSendRequest;
            return connection.getCacheKey();
import org.opensearch.core.action.ActionListener;
    boolean setDefaultSendBehavior(SendRequestBehavior sendBehavior) {
        }
    public List<String> getDefaultSeedAddresses() {
    public interface OpenConnectionBehavior {
import org.opensearch.transport.RequestHandlerRegistry;
    }
        }
    boolean addSendBehavior(TransportAddress transportAddress, SendRequestBehavior sendBehavior) {
        replacedRequestRegistries.put(actionName, realRegistry);
    public interface RequestHandlingBehavior<Request extends TransportRequest> {
            connection.close();
    private volatile SendRequestBehavior defaultSendRequest = null;
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    }
 * this work for additional information regarding copyright
    @Override
        void openConnection(
        );
    void clearOutboundBehaviors(TransportAddress transportAddress) {
import org.opensearch.transport.Transport;
        clearOutboundBehaviors();
    }
/*
            behavior.openConnection(delegate, node, profile, wrappedListener);
            SendRequestBehavior behavior = sendBehaviors.getOrDefault(address, defaultSendRequest);
        private WrappedConnection(Transport.Connection connection) {
 *
import org.opensearch.common.lifecycle.LifecycleListener;
    public Transport.ResponseHandlers getResponseHandlers() {
            return connection.isClosed();
            } else {
 * The OpenSearch Contributors require contributions made to
        @Override
