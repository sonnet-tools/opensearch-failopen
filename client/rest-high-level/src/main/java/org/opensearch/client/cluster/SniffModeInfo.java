 * ownership. Elasticsearch licenses this file to you under  
    public int getMaxConnectionsPerCluster() {  
 * GitHub history for details.
    final List<String> seedNodes;  
        return NAME;
 * Unless required by applicable law or agreed to in writing,
        return maxConnectionsPerCluster;
    }
            && numNodesConnected == sniff.numNodesConnected
    @Override  
 * this file be licensed under the Apache-2.0 license or a
public class SniffModeInfo implements RemoteConnectionInfo.ModeInfo {
        SniffModeInfo sniff = (SniffModeInfo) o;  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    }
            + numNodesConnected
    public String modeName() {
    }
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
/*  
    @Override
}
    public List<String> getSeedNodes() {
/*  
        if (this == o) return true;
        return maxConnectionsPerCluster == sniff.maxConnectionsPerCluster
            + ", maxConnectionsPerCluster="
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int getNumNodesConnected() {
        return numNodesConnected > 0;  
        this.seedNodes = seedNodes;
    public boolean equals(Object o) {  
            + '}';
    final int numNodesConnected;
    @Override
 */
    @Override
        return "SniffModeInfo{"
    }  
/*
            + seedNodes  
    static final String SEEDS = "seeds";  
    SniffModeInfo(List<String> seedNodes, int maxConnectionsPerCluster, int numNodesConnected) {
    public boolean isConnected() {
    public int hashCode() {
 *  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
            + maxConnectionsPerCluster
    }  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 *
 * not use this file except in compliance with the License.
            + "seedNodes="
 * KIND, either express or implied.  See the License for the
        this.maxConnectionsPerCluster = maxConnectionsPerCluster;  
package org.opensearch.client.cluster;
 */  
 * under the License.  
        return numNodesConnected;
 * the Apache License, Version 2.0 (the "License"); you may
    }
    static final String MAX_CONNECTIONS_PER_CLUSTER = "max_connections_per_cluster";
        return Objects.hash(seedNodes, maxConnectionsPerCluster, numNodesConnected);
    }
    final int maxConnectionsPerCluster;
 *
        return seedNodes;  
    }  
        this.numNodesConnected = numNodesConnected;
import java.util.Objects;
            && Objects.equals(seedNodes, sniff.seedNodes);  
    static final String NUM_NODES_CONNECTED = "num_nodes_connected";
            + ", numNodesConnected="  
 * software distributed under the License is distributed on an
 * compatible open source license.
    public String toString() {  
        if (o == null || getClass() != o.getClass()) return false;
    public static final String NAME = "sniff";
 * You may obtain a copy of the License at  
