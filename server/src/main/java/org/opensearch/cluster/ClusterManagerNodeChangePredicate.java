     * @return predicate that returns true when cluster manager changes or version increases
 * You may obtain a copy of the License at  
        final DiscoveryNode clusterManagerNode = currentState.nodes().getClusterManagerNode();
 * this work for additional information regarding copyright
    /**
 *  
 * KIND, either express or implied.  See the License for the
public final class ClusterManagerNodeChangePredicate {
        return build(currentVersion, currentMasterId);
 * the Apache License, Version 2.0 (the "License"); you may
    public static Predicate<ClusterState> build(ClusterState currentState) {  
            final DiscoveryNode newClusterManager = newState.nodes().getClusterManagerNode();  
 *
 * GitHub history for details.
    }
/*  
/*  
        final long currentVersion = currentState.version();
/**
     * and delegates to {@link #build(long, String)}.
            } else if (newClusterManager.getEphemeralId().equals(currentMasterId) == false) {
    private ClusterManagerNodeChangePredicate() {  
        final String currentMasterId = clusterManagerNode == null ? null : clusterManagerNode.getEphemeralId();  
 * software distributed under the License is distributed on an
            if (newClusterManager == null) {
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 */
    /**
     * @param currentVersion  the cluster state version to compare against  
 */  
            return accept;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        };
 *
 */  
     */
            final boolean accept;
     * (re-)joined the cluster manager. Extracts version and cluster-manager ID from the given state  
import org.opensearch.cluster.node.DiscoveryNode;
 */  
     * values to avoid retaining the full {@link ClusterState} in lambda closures.
     * Builds a predicate that accepts a cluster state only if the cluster manager has changed
     * Builds a predicate that accepts a cluster state only if it was generated after the current node
package org.opensearch.cluster;
import java.util.function.Predicate;  
 * Licensed to Elasticsearch under one or more contributor  
                accept = newState.version() > currentVersion;
 *
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
}  
                accept = false;  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
        return newState -> {
     */  
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
    }
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
    public static Predicate<ClusterState> build(long currentVersion, String currentMasterId) {
            }
 * not use this file except in compliance with the License.
            } else {  
/*
     * @param currentMasterId the ephemeral ID of the current cluster manager node, or null if none
 * license agreements. See the NOTICE file distributed with
    }
 * Utility class to build a predicate that accepts cluster state changes  
                accept = true;
     * or the state version has increased beyond the provided version. Accepts pre-extracted  
