import org.opensearch.common.annotation.PublicApi;  
 * ownership. Elasticsearch licenses this file to you under  
 * Enables listening to cluster-manager changes events of the local node (when the local node becomes the cluster-manager, and when the local  
 * SPDX-License-Identifier: Apache-2.0
    void offClusterManager();
 * GitHub history for details.
        final boolean isClusterManager = event.localNodeClusterManager();  
 * KIND, either express or implied.  See the License for the
    default void clusterChanged(ClusterChangedEvent event) {
 *  
 * Modifications Copyright OpenSearch Contributors. See  
 *
 * this work for additional information regarding copyright
    @Override  
 * @opensearch.api  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Called when the local node used to be the cluster-manager, a new cluster-manager was elected and it's no longer the local node.
public interface LocalNodeClusterManagerListener extends ClusterStateListener {  
            onClusterManager();
        final boolean wasClusterManager = event.previousState().nodes().isLocalNodeElectedClusterManager();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/*  
 */
 * not use this file except in compliance with the License.
     * Called when local node is elected to be the cluster-manager  
 * Licensed to Elasticsearch under one or more contributor  
 */
/*
@PublicApi(since = "1.0.0")
 * You may obtain a copy of the License at  
        } else if (wasClusterManager && isClusterManager == false) {  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        if (wasClusterManager == false && isClusterManager) {
/*
    /**
 * compatible open source license.
    void onClusterManager();
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    /**
        }
 *
 */
/**
package org.opensearch.cluster;
 * license agreements. See the NOTICE file distributed with
    }  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 * node cease being a cluster-manager).
     */  
     */
}
 * under the License.  
            offClusterManager();
 * this file be licensed under the Apache-2.0 license or a
