            + ", numSocketsConnected="  
            + '\''  
            + ", serverName='"
    public int getNumSocketsConnected() {
 *
            + ", maxSocketConnections="
    @Override
        return numSocketsConnected;  
/*
        return "ProxyModeInfo{"  
 * not use this file except in compliance with the License.
            + serverName
}
    static final String PROXY_ADDRESS = "proxy_address";
            && numSocketsConnected == otherProxy.numSocketsConnected  
    static final String SERVER_NAME = "server_name";  
    static final String NAME = "proxy";
    }
        return maxSocketConnections;
    }
        return maxSocketConnections == otherProxy.maxSocketConnections
            + "address='"
        if (o == null || getClass() != o.getClass()) return false;  
    public String getAddress() {
        return Objects.hash(address, serverName, maxSocketConnections, numSocketsConnected);
public class ProxyModeInfo implements RemoteConnectionInfo.ModeInfo {  
 * this work for additional information regarding copyright
    public int hashCode() {  
        if (this == o) return true;
 * under the License.  
    public String modeName() {
    @Override
        this.address = address;
 * SPDX-License-Identifier: Apache-2.0
            + '\''  
        return numSocketsConnected > 0;  
 * specific language governing permissions and limitations
 */  
 * license agreements. See the NOTICE file distributed with
    @Override  
 * KIND, either express or implied.  See the License for the
    private final int numSocketsConnected;
import java.util.Objects;
        return NAME;
 * Licensed to Elasticsearch under one or more contributor  
 *
    }
    private final String serverName;
            + numSocketsConnected
    }
    private final int maxSocketConnections;  
            && Objects.equals(address, otherProxy.address)
    ProxyModeInfo(String address, String serverName, int maxSocketConnections, int numSocketsConnected) {  
    public int getMaxSocketConnections() {
    static final String NUM_PROXY_SOCKETS_CONNECTED = "num_proxy_sockets_connected";
 * software distributed under the License is distributed on an
    private final String address;
            && Objects.equals(serverName, otherProxy.serverName);
        this.maxSocketConnections = maxSocketConnections;  
    public String toString() {
    }  
        this.serverName = serverName;
        this.numSocketsConnected = numSocketsConnected;
    static final String MAX_PROXY_SOCKET_CONNECTIONS = "max_proxy_socket_connections";
/*  
            + '}';
 *  
            + address
    public boolean isConnected() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean equals(Object o) {
 * compatible open source license.
 * You may obtain a copy of the License at  
 */  
    public String getServerName() {  
package org.opensearch.client.cluster;
 * GitHub history for details.
    }
 */
    }  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        return address;  
    }  
    }
        ProxyModeInfo otherProxy = (ProxyModeInfo) o;
            + maxSocketConnections
/*  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        return serverName;
