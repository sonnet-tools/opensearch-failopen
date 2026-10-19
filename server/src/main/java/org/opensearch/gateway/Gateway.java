                        electedIndexMetadata = indexMetadata;  
/**
    public interface GatewayStateRecoveredListener {
 * ownership. Elasticsearch licenses this file to you under  
import java.util.function.Function;
        final ClusterService clusterService,
 *  
            }  
            listener.onFailure("found [" + found + "] metadata states, required [" + requiredAllocation + "]");  
                logger.warn("failed to fetch state from node", failedNodeException);
import org.apache.logging.log4j.LogManager;
import java.util.HashMap;  
        final String[] nodesIds = clusterService.state().nodes().getClusterManagerNodes().keySet().toArray(new String[0]);  
        final Object[] keys = indices.keySet().toArray();
            }  
        final TransportNodesListGatewayMetaState listGatewayMetaState
 * not use this file except in compliance with the License.
    private final TransportNodesListGatewayMetaState listGatewayMetaState;  
 * KIND, either express or implied.  See the License for the
        logger.trace("performing state recovery from {}", Arrays.toString(nodesIds));
 */
            }
import java.util.Map;
 *  
 * You may obtain a copy of the License at  
import org.opensearch.cluster.metadata.Metadata;  
            } else if (nodeState.metadata().version() > electedGlobalState.version()) {
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
                        continue;
        if (nodesState.hasFailures()) {  
                for (final TransportNodesListGatewayMetaState.NodeGatewayMetaState nodeState : nodesState.getNodes()) {
                    metadataBuilder.put(electedIndexMetadata, false);  
            return;
        final Settings settings,  
        ClusterState recoveredState = Function.<ClusterState>identity()
 * SPDX-License-Identifier: Apache-2.0
    public Gateway(
import org.opensearch.cluster.metadata.IndexMetadata;
 */  
    /**
            if (electedGlobalState == null) {
        for (final TransportNodesListGatewayMetaState.NodeGatewayMetaState nodeState : nodesState.getNodes()) {  
 * software distributed under the License is distributed on an
                        logger.debug("[{}] found [{}], required [{}], not adding", index, indexMetadataCount, requiredAllocation);  
                    } // TODO if this logging statement is correct then we are missing an else here
                    final IndexMetadata indexMetadata = nodeState.metadata().index(index);
                int indexMetadataCount = 0;  
            for (final IndexMetadata cursor : nodeState.metadata().indices().values()) {
        // update the global state, and clean the indices, we elect them in the next phase  
                    } else if (indexMetadata.getVersion() > electedIndexMetadata.getVersion()) {
            if (nodeState.metadata() == null) {
/*  
        void onFailure(String s);
import org.apache.logging.log4j.Logger;
            if (keys[i] != null) {  
 *
     *
     */  
public class Gateway {  
                    if (indexMetadata == null) {  
            }  
                    indexMetadataCount++;
                }  
 * Unless required by applicable law or agreed to in writing,
        final int requiredAllocation = 1;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 *
                    }
        final TransportNodesListGatewayMetaState.NodesGatewayMetaState nodesState = listGatewayMetaState.list(nodesIds, null).actionGet();
        final Metadata.Builder metadataBuilder = Metadata.builder(electedGlobalState).removeAllIndices();
import org.opensearch.common.settings.Settings;
            }  
 * The Gateway
        listener.onSuccess(recoveredState);
        this.clusterService = clusterService;
     * The lister for state recovered.  
        }
    }  
    ) {  
            .andThen(state -> ClusterStateUpdaters.upgradeAndArchiveUnknownOrInvalidSettings(state, clusterService.getClusterSettings()))
/*  
}  
        }  
                electedGlobalState = nodeState.metadata();  
import org.opensearch.action.FailedNodeException;  
                    if (electedIndexMetadata == null) {  
    private static final Logger logger = LogManager.getLogger(Gateway.class);
                indices.merge(cursor.getIndex(), 1f, Float::sum);
        assert !indices.containsKey(null);  
    public void performStateRecovery(final GatewayStateRecoveredListener listener) throws GatewayException {
        if (found < requiredAllocation) {
    private final ClusterService clusterService;
            for (final FailedNodeException failedNodeException : nodesState.failures()) {
import org.opensearch.core.index.Index;  
 * specific language governing permissions and limitations
import java.util.Arrays;
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (electedIndexMetadata != null) {
                    }
                    if (nodeState.metadata() == null) {
                electedGlobalState = nodeState.metadata();
        for (int i = 0; i < keys.length; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        void onSuccess(ClusterState build);
     * @opensearch.internal
    }  
            .apply(ClusterState.builder(clusterService.getClusterName()).metadata(metadataBuilder).build());  
                    }
        int found = 0;
import org.opensearch.cluster.ClusterState;
                IndexMetadata electedIndexMetadata = null;
                        electedIndexMetadata = indexMetadata;
        this.listGatewayMetaState = listGatewayMetaState;
            found++;
import org.opensearch.cluster.service.ClusterService;
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.gateway;
 * @opensearch.internal
 */
        final Map<Index, Float> indices = new HashMap<>();  
 * license agreements. See the NOTICE file distributed with
                final Index index = (Index) keys[i];
                }
 * under the License.  
                        continue;  
        Metadata electedGlobalState = null;
        }
 * compatible open source license.
                continue;
/*
 * Modifications Copyright OpenSearch Contributors. See
        }
                    if (indexMetadataCount < requiredAllocation) {
