    default void onConnectionClosed(Transport.Connection connection) {}
     * @param connection the closed connection
     */  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    default void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {}
 * Modifications Copyright OpenSearch Contributors. See
     * Called once a node connection is opened and registered.
/*  
    /**  
 *
 *
 *
    /**  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 */  
 * not use this file except in compliance with the License.
 */  
 * A listener interface that allows to react on transport events. All methods may be
     * Called once a node connection is closed and unregistered.  
     */
import org.opensearch.cluster.node.DiscoveryNode;
 * this work for additional information regarding copyright
 *  
    default void onConnectionOpened(Transport.Connection connection) {}
     */  
     */
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
     * Called once a connection was opened
 * compatible open source license.
     * Called once a connection ws closed.
 * this file be licensed under the Apache-2.0 license or a
}  
 * You may obtain a copy of the License at  
package org.opensearch.transport;
 * executed on network threads. Consumers must fork in the case of long running or blocking
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 */
     * @param connection the connection
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * software distributed under the License is distributed on an
/**  
 */  
 * KIND, either express or implied.  See the License for the
public interface TransportConnectionListener {
 * SPDX-License-Identifier: Apache-2.0
 * operations.  
 * under the License.  
 * GitHub history for details.
    /**  
    default void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {}  
/*
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
