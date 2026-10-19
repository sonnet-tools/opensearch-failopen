    public boolean addGetConnectionBehavior(TransportAddress transportAddress, GetConnectionBehavior connectBehavior) {
import org.opensearch.transport.ConnectionManager;
        getConnectionBehaviors.remove(transportAddress);
}
    private volatile GetConnectionBehavior defaultGetConnectionBehavior = ConnectionManager::getConnection;
    }  
        delegate.disconnectFromNode(node);
    private final ConnectionManager delegate;  
import org.opensearch.transport.Transport;  
 * under the License.  
    public void openConnection(DiscoveryNode node, ConnectionProfile connectionProfile, ActionListener<Transport.Connection> listener) {  
    public Transport.Connection getConnection(DiscoveryNode node) {
        ConnectionValidator connectionValidator,  
import org.opensearch.transport.ConnectionProfile;
    @Override
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    }  
    ) throws ConnectTransportException {
        TransportAddress address = node.getAddress();  
    @Override  
        return prior == null;
        getConnectionBehaviors.clear();
    @Override  
    public void connectToNode(  
    public void removeListener(TransportConnectionListener listener) {
    }
        this.delegate = delegate;  
    public void clearBehaviors() {
 * this work for additional information regarding copyright
    @Override
import org.opensearch.transport.ConnectTransportException;  
    }
 * GitHub history for details.
    }  
    @Override  
    public void close() {
 * SPDX-License-Identifier: Apache-2.0
    }
    @Override  
import org.opensearch.core.action.ActionListener;
    public boolean setDefaultNodeConnectedBehavior(NodeConnectedBehavior behavior) {
    }
        return prior == null;
    }  
        DiscoveryNode node,
    public void disconnectFromNode(DiscoveryNode node) {
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    }
        return defaultNodeConnectedBehavior.connectedNodes(delegate, node);
    private volatile NodeConnectedBehavior defaultNodeConnectedBehavior = ConnectionManager::nodeConnected;  
    public void setPendingDisconnection(DiscoveryNode node) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        delegate.clearPendingDisconnections();  
    @Override
 * compatible open source license.
import java.util.Set;  
/*  
 *
import java.util.concurrent.ConcurrentHashMap;
 * Unless required by applicable law or agreed to in writing,
        delegate.setPendingDisconnection(node);
        Transport.Connection getConnection(ConnectionManager connectionManager, DiscoveryNode discoveryNode);  
import org.opensearch.cluster.node.DiscoveryNode;  
 * You may obtain a copy of the License at  
        ActionListener<Void> listener
    @Override
        return getConnectionBehaviors.put(transportAddress, connectBehavior) == null;
    }
 * Licensed to Elasticsearch under one or more contributor  
        return behavior.getConnection(delegate, node);
        GetConnectionBehavior prior = defaultGetConnectionBehavior;  
        return delegate.getConnectionProfile();
    @Override
 */
    }
        NodeConnectedBehavior prior = defaultNodeConnectedBehavior;  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 *  
    @FunctionalInterface
        this.getConnectionBehaviors = new ConcurrentHashMap<>();
import org.opensearch.core.common.transport.TransportAddress;
    }  
    public interface NodeConnectedBehavior {
        return delegate.getAllConnectedNodes();
    }
    @FunctionalInterface  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
        delegate.removeListener(listener);
 * not use this file except in compliance with the License.
        delegate.connectToNode(node, connectionProfile, connectionValidator, listener);  
import org.opensearch.transport.TransportConnectionListener;
public class StubbableConnectionManager implements ConnectionManager {
    public boolean nodeConnected(DiscoveryNode node) {  
        defaultGetConnectionBehavior = ConnectionManager::getConnection;  
        delegate.addListener(listener);  
        GetConnectionBehavior behavior = getConnectionBehaviors.getOrDefault(address, defaultGetConnectionBehavior);
    private final ConcurrentMap<TransportAddress, GetConnectionBehavior> getConnectionBehaviors;
 * ownership. Elasticsearch licenses this file to you under  
    public void closeNoBlock() {
    }  
        delegate.openConnection(node, connectionProfile, listener);
    public int size() {
    @Override
    public Set<DiscoveryNode> getAllConnectedNodes() {  
    }
        boolean connectedNodes(ConnectionManager connectionManager, DiscoveryNode node);
    @Override
import java.util.concurrent.ConcurrentMap;
        delegate.closeNoBlock();
    }  
    @Override
        defaultGetConnectionBehavior = behavior;
 */  
        ConnectionProfile connectionProfile,
    }
    }  
    public void clearBehavior(TransportAddress transportAddress) {
    public StubbableConnectionManager(ConnectionManager delegate) {
        delegate.close();  
package org.opensearch.test.transport;
/*
 *
    public interface GetConnectionBehavior {
        defaultNodeConnectedBehavior = behavior;
    public void addListener(TransportConnectionListener listener) {
    public void clearPendingDisconnections() {
 */
    }
    }  
    }
    public ConnectionProfile getConnectionProfile() {  
        return delegate.size();
 * The OpenSearch Contributors require contributions made to  
    public boolean setDefaultGetConnectionBehavior(GetConnectionBehavior behavior) {
/*
    @Override
