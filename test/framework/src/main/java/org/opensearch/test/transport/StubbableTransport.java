            behavior.clearCallback();
    public void close() {
            connection.close();  
        } else {  
import org.opensearch.transport.ConnectionProfile;  
        return delegate.getDefaultSeedAddresses();  
            throws IOException;  
        SendRequestBehavior prior = defaultSendRequest;
    @Override  
        OpenConnectionBehavior behavior = connectBehaviors.getOrDefault(address, defaultConnectBehavior);  
import org.opensearch.common.lifecycle.Lifecycle;  
    }  
        }
    public void stop() {
            throw new IllegalStateException("Cannot find registered action for: " + actionName);  
import org.opensearch.transport.RequestHandlerRegistry;
                connection.sendRequest(requestId, action, request, options);
        return delegate.boundAddress();
    private final Transport delegate;  
    @Override
package org.opensearch.test.transport;
    private volatile SendRequestBehavior defaultSendRequest = null;
import org.opensearch.transport.TransportStats;  
        @Override  
            realRegistry,
    }
            (request, channel, task) -> behavior.messageReceived(realHandler, request, channel, task)  
        delegate.setMessageListener(listener);  
 * Modifications Copyright OpenSearch Contributors. See
    }  
    void clearBehaviors() {  
    }
            ConnectionProfile profile,
 * specific language governing permissions and limitations
        }
    private final ConcurrentHashMap<TransportAddress, SendRequestBehavior> sendBehaviors = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<TransportAddress, OpenConnectionBehavior> connectBehaviors = new ConcurrentHashMap<>();
            this.connection = connection;  
        clearOutboundBehaviors();
        public void close() {
            throws Exception;  
    private volatile OpenConnectionBehavior defaultConnectBehavior = null;
            connection.addCloseListener(listener);
import org.opensearch.tasks.Task;
            ActionListener<Connection> listener  
 * The OpenSearch Contributors require contributions made to  
    public interface RequestHandlingBehavior<Request extends TransportRequest> {  
            return connection.getVersion();
 * GitHub history for details.
        final TransportRequestHandler<Request> realHandler = realRegistry.getHandler();  
    @Override
    @FunctionalInterface
        OpenConnectionBehavior openConnectionBehavior = connectBehaviors.remove(transportAddress);  
    public BoundTransportAddress boundAddress() {
    }  
            }
            listener,  
        if (openConnectionBehavior != null) {
        );
        }  
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Connection> listener) {
        return delegate.getRequestHandlers().getHandler(actionName) != null;  
        final RequestHandlers requestHandlers = delegate.getRequestHandlers();  
    @Override  
 * KIND, either express or implied.  See the License for the
    }
        return prior == null;  
/*
 * under the License.  
        @Override
        for (Map.Entry<String, RequestHandlerRegistry<?>> entry : replacedRequestRegistries.entrySet()) {  
import java.util.Map;
    }  
 *
     * to decide which transport (regular vs streaming) owns the action.  
        delegate.stop();  
    @Override
    }
    boolean setDefaultSendBehavior(SendRequestBehavior sendBehavior) {  
        delegate.removeLifecycleListener(listener);
        public Object getCacheKey() {  
        private WrappedConnection(Transport.Connection connection) {
                behavior.sendRequest(connection, requestId, action, request, options);
    }
            } else {  
    }
    @Override  
    public void setMessageListener(TransportMessageListener listener) {
    @Override
        }
        return connectBehaviors.put(transportAddress, connectBehavior) == null;
        void openConnection(
            return connection;
        void sendRequest(Connection connection, long requestId, String action, TransportRequest request, TransportRequestOptions options)
            behavior.openConnection(delegate, node, profile, wrappedListener);
    private final ConcurrentHashMap<String, RequestHandlerRegistry<?>> replacedRequestRegistries = new ConcurrentHashMap<>();  
import org.opensearch.transport.TransportRequest;  
import org.opensearch.transport.TransportChannel;  
    public void removeLifecycleListener(LifecycleListener listener) {
        ActionListener<Connection> wrappedListener = ActionListener.delegateFailure(
    public Transport.ResponseHandlers getResponseHandlers() {
        );
        }  
 * Unless required by applicable law or agreed to in writing,
        }
        connectBehaviors.clear();
import org.opensearch.cluster.node.DiscoveryNode;
        public Transport.Connection getConnection() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public TransportAddress[] addressesFromString(String address) throws UnknownHostException {  
        this.defaultConnectBehavior = openConnectionBehavior;
 * license agreements. See the NOTICE file distributed with
    @FunctionalInterface
            SendRequestBehavior behavior = sendBehaviors.getOrDefault(address, defaultSendRequest);  
import org.opensearch.common.lifecycle.LifecycleListener;
            Transport transport,  
    @Override
 */
    @Override  
    public interface OpenConnectionBehavior {  
        }
        }
        }  
    /**
        requestHandlers.forceRegister(newRegistry);
            TransportAddress address = connection.getNode().getAddress();
    boolean addConnectBehavior(TransportAddress transportAddress, OpenConnectionBehavior connectBehavior) {
    @Override
        final RequestHandlerRegistry<Request> realRegistry = requestHandlers.getHandler(actionName);
    Transport getDelegate() {  
        this.defaultSendRequest = null;
import java.io.IOException;
    @Override
    }  
        return delegate.profileBoundAddresses();
        }  
    boolean addSendBehavior(TransportAddress transportAddress, SendRequestBehavior sendBehavior) {  
        public void addCloseListener(ActionListener<Void> listener) {  
     */
    public TransportStats getStats() {  
import org.opensearch.core.common.transport.BoundTransportAddress;  
     * Returns {@code true} if the underlying delegate transport has a  
    }  
    public class WrappedConnection implements Transport.Connection {
/*  
        default void clearCallback() {}
        }
import java.net.UnknownHostException;  
    public Lifecycle.State lifecycleState() {  
        replacedRequestRegistries.put(actionName, realRegistry);
}
        }
            delegate.openConnection(node, profile, wrappedListener);
import org.opensearch.transport.TransportMessageListener;
    boolean hasHandler(String actionName) {
import org.opensearch.transport.TransportException;
        return delegate.getResponseHandlers();  
    }  
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)  
    @Override  
        SendRequestBehavior behavior = sendBehaviors.remove(transportAddress);
        );
    }
            return connection.getCacheKey();
    <Request extends TransportRequest> void addRequestHandlingBehavior(String actionName, RequestHandlingBehavior<Request> behavior) {
        void messageReceived(TransportRequestHandler<Request> handler, Request request, TransportChannel channel, Task task)
        delegate.start();
        defaultSendRequest = sendBehavior;
    }  
        delegate.addLifecycleListener(listener);  
    }  
    public StubbableTransport(Transport transport) {
    }
            openConnectionBehavior.clearCallback();
    }
    }
        sendBehaviors.clear();
        public DiscoveryNode getNode() {
            (delegatedListener, connection) -> delegatedListener.onResponse(new WrappedConnection(connection))
    public void addLifecycleListener(LifecycleListener listener) {
import org.opensearch.transport.TransportRequestHandler;
            getRequestHandlers().forceRegister(entry.getValue());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.TransportRequestOptions;
    @FunctionalInterface  
        return delegate.getRequestHandlers();
        default void clearCallback() {}  
        if (behavior == null) {
import org.opensearch.core.common.transport.TransportAddress;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
        final RequestHandlerRegistry<Request> newRegistry = RequestHandlerRegistry.replaceHandler(
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
            DiscoveryNode discoveryNode,
        if (realRegistry == null) {
/*  
        delegate.close();
        default void clearCallback() {}
import java.util.concurrent.ConcurrentHashMap;  
    }
 * You may obtain a copy of the License at  
import org.opensearch.transport.Transport;
    }
    public boolean setDefaultConnectBehavior(OpenConnectionBehavior openConnectionBehavior) {  
        clearInboundBehaviors();
    }
    void clearInboundBehaviors() {
    public void start() {  
 * compatible open source license.
        OpenConnectionBehavior prior = this.defaultConnectBehavior;
    @Override
        return sendBehaviors.put(transportAddress, sendBehavior) == null;
        }
    void clearOutboundBehaviors() {  
        return delegate.addressesFromString(address);
 *
 * ownership. Elasticsearch licenses this file to you under  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        this.defaultConnectBehavior = null;  
        @Override
    }
        this.delegate = transport;  
     * registered request handler for the given action name. Used by
        return delegate;
 */  
    @Override
            return connection.getNode();
        replacedRequestRegistries.clear();  
        @Override
    public RequestHandlers getRequestHandlers() {
 * this work for additional information regarding copyright
        return delegate.getStats();
        private final Transport.Connection connection;  
        @Override
public class StubbableTransport implements Transport {
    }  
        }
    void clearOutboundBehaviors(TransportAddress transportAddress) {
 * software distributed under the License is distributed on an
    }  
        return delegate.lifecycleState();
        if (behavior != null) {  
        @Override  
    }
    public interface SendRequestBehavior {
            return connection.isClosed();  
    }
import java.util.List;
     * {@link MockTransportService#addRequestHandlingBehavior(String, RequestHandlingBehavior)}
    public Map<String, BoundTransportAddress> profileBoundAddresses() {  
    @Override
    public List<String> getDefaultSeedAddresses() {
    }
 *  
    }
            if (behavior == null) {
            throws IOException, TransportException {
import org.opensearch.core.action.ActionListener;
        TransportAddress address = node.getAddress();
        return prior == null;  
        public Version getVersion() {
        public boolean isClosed() {
 */  
import org.opensearch.Version;
        @Override
