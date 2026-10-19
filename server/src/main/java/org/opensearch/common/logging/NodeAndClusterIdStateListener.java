     */  
        ClusterStateObserver observer = new ClusterStateObserver(clusterState, clusterService, null, logger, threadContext);  
 * GitHub history for details.
package org.opensearch.common.logging;
import org.opensearch.common.unit.TimeValue;  
    }
 * Licensed to Elasticsearch under one or more contributor  
/**  
public class NodeAndClusterIdStateListener implements ClusterStateObserver.Listener {
    @Override
    private static String getNodeId(ClusterState state) {
import org.opensearch.cluster.ClusterState;  
     * Subscribes for the first cluster state update where nodeId and clusterId is present
 * license agreements. See the NOTICE file distributed with
 */  
    public void onClusterServiceClose() {}  
        return state.getNodes().getLocalNodeId();
 * @opensearch.internal
        ClusterState clusterState = clusterService.state();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 * KIND, either express or implied.  See the License for the
    }  
    public void onTimeout(TimeValue timeout) {}  
        return state.getMetadata().clusterUUID();
 */  
    }  
 *
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    private static String getClusterUUID(ClusterState state) {  
 * ownership. Elasticsearch licenses this file to you under  
        observer.waitForNextChange(new NodeAndClusterIdStateListener(), NodeAndClusterIdStateListener::isNodeAndClusterIdPresent);
 * Once the first update is received, it will automatically be de-registered from subsequent updates.  
    private static final Logger logger = LogManager.getLogger(NodeAndClusterIdStateListener.class);
import org.apache.logging.log4j.LogManager;
 *
    public static void getAndSetNodeIdAndClusterId(ClusterService clusterService, ThreadContext threadContext) {
/*
 * compatible open source license.
        String nodeId = getNodeId(state);
    private static boolean isNodeAndClusterIdPresent(ClusterState clusterState) {
        String clusterUUID = getClusterUUID(state);
    /**  
    @Override
/*  
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.apache.logging.log4j.Logger;
        return getNodeId(clusterState) != null && getClusterUUID(clusterState) != null;  
 * software distributed under the License is distributed on an
    }  
     * and sets these values in {@link NodeAndClusterIdConverter}.
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
    private NodeAndClusterIdStateListener() {}
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
/*  
    }
        NodeAndClusterIdConverter.setNodeIdAndClusterId(nodeId, clusterUUID);
    public void onNewClusterState(ClusterState state) {  
 *
import org.opensearch.cluster.service.ClusterService;
 * it sets the clusterUUID and nodeID in log4j pattern converter {@link NodeAndClusterIdConverter}.
 */  
        logger.debug("Received cluster state update. Setting nodeId=[{}] and clusterUuid=[{}]", nodeId, clusterUUID);
 * The {@link NodeAndClusterIdStateListener} listens to cluster state changes and ONLY when receives the first update
 *  
 * this work for additional information regarding copyright
import org.opensearch.cluster.ClusterStateObserver;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.util.concurrent.ThreadContext;
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * under the License.  
