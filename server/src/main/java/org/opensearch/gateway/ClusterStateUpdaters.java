                e.getKey(),  
 * specific language governing permissions and limitations
 * compatible open source license.
                settingType,
            clusterSettings.archiveUnknownOrInvalidSettings(  
 * ownership. Elasticsearch licenses this file to you under  
        return ClusterState.builder(state).blocks(blocks).build();
/*
    static ClusterState recoverClusterBlocks(final ClusterState state) {
            .build();  
            metadataBuilder.put(indexMetadata, false);
        return ClusterState.builder(currentState).blocks(blocks).metadata(metadataBuilder).build();
 *
    static ClusterState updateRoutingTable(final ClusterState state) {
        assert currentState.metadata().indices().isEmpty();
 */  
/**
import org.apache.logging.log4j.message.ParameterizedMessage;  
        return state;
        );
            .blocks(ClusterBlocks.builder().blocks(state.blocks()).addGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK).build())
import org.opensearch.cluster.ClusterState;
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).build())  
            )
        for (final IndexMetadata indexMetadata : recoveredState.metadata()) {  
            ),
    }
import java.util.Map;
                (e, ex) -> logInvalidSetting("transient", e, ex)  
 */  
/*  
                .clusterUUID(state.metadata().clusterUUID())
        for (final IndexMetadata indexMetadata : state.metadata()) {  
                .coordinationMetadata(state.metadata().coordinationMetadata())
            .blocks(ClusterBlocks.builder().blocks(state.blocks()).removeGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK).build())
    }
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    static ClusterState mixCurrentStateAndRecoveredState(final ClusterState currentState, final ClusterState recoveredState) {  
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder(state.routingTable());  
        final Metadata.Builder metadataBuilder = Metadata.builder(recoveredState.metadata());
            final Metadata metadata = Metadata.builder()  
 *
    public static ClusterState hideStateIfNotRecovered(ClusterState state) {
        metadataBuilder.transientSettings(
        }
 */  
        return ClusterState.builder(state).routingTable(routingTableBuilder.build()).build();  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 *
        }  
            blocks.removeGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
 * Unless required by applicable law or agreed to in writing,
            for (IndexMetadata indexMetadata : state.metadata()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(state.blocks());  
package org.opensearch.gateway;
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.metadata.Metadata;
        logger.warn("ignoring unknown {} setting: [{}] with value [{}]; archiving", settingType, e.getKey(), e.getValue());
 * under the License.  
                clusterSettings.upgradeSettings(metadataBuilder.transientSettings()),
        if (state.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK)) {
        return ClusterState.builder(state)
            .build();  
 * this file be licensed under the Apache-2.0 license or a
            blocks.addBlocks(indexMetadata);
        );
            }
 * this work for additional information regarding copyright
                e -> logUnknownSetting("transient", e),
            blocks.addGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK);
            blocks.removeGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK);
        // start with 0 based versions for routing table
        // automatically generate a UID for the metadata if we need to  
            ex  
            )  
        }  
import org.opensearch.cluster.node.DiscoveryNode;
    private static void logUnknownSetting(final String settingType, final Map.Entry<String, String> e) {  
                blocks.removeIndexBlocks(indexMetadata.getIndex().getName());
        return ClusterState.builder(state)
        }
 * The OpenSearch Contributors require contributions made to  
    static ClusterState setLocalNode(final ClusterState clusterState, DiscoveryNode localNode) {
        return ClusterState.builder(clusterState).metadata(metadataBuilder).build();  
        }  
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks()).blocks(recoveredState.blocks());  
    static ClusterState upgradeAndArchiveUnknownOrInvalidSettings(final ClusterState clusterState, final ClusterSettings clusterSettings) {
/*  
    private static void logInvalidSetting(final String settingType, final Map.Entry<String, String> e, final IllegalArgumentException ex) {
 * Licensed to Elasticsearch under one or more contributor  
    }
        metadataBuilder.persistentSettings(
                e.getValue()
        return ClusterState.builder(clusterState)
        // initialize all index routing tables as empty
            .build();
                clusterSettings.upgradeSettings(metadataBuilder.persistentSettings()),  
public class ClusterStateUpdaters {
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        }
        routingTableBuilder.version(0);
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
    }
    static ClusterState removeStateNotRecoveredBlock(final ClusterState state) {  
        if (Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.get(state.metadata().settings())) {
}
import org.opensearch.cluster.metadata.IndexMetadata;  
        final Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
                e -> logUnknownSetting("persistent", e),
    }
import org.opensearch.common.settings.ClusterSettings;
            clusterSettings.archiveUnknownOrInvalidSettings(
        logger.warn(
import org.opensearch.cluster.routing.RoutingTable;
        metadataBuilder.generateClusterUuidIfNeeded();
    private static final Logger logger = LogManager.getLogger(ClusterStateUpdaters.class);
        );
    }
            () -> new ParameterizedMessage(  
                "ignoring invalid {} setting: [{}] with value [{}]; archiving",
 * Modifications Copyright OpenSearch Contributors. See
                .build();  
 * @opensearch.internal
            return ClusterState.builder(state).metadata(metadata).blocks(blocks.build()).build();
            routingTableBuilder.addAsRecovery(cursor);
        for (final IndexMetadata cursor : state.metadata().indices().values()) {
            blocks.addGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);  
import org.apache.logging.log4j.LogManager;
 * Updates cluster state  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
                (e, ex) -> logInvalidSetting("persistent", e, ex)
import org.opensearch.cluster.node.DiscoveryNodes;  
    }
        if (Metadata.SETTING_READ_ONLY_SETTING.get(state.metadata().settings())) {
 *  
    }
import org.opensearch.cluster.block.ClusterBlocks;
    public static ClusterState addStateNotRecoveredBlock(ClusterState state) {  
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(state.blocks());
 * You may obtain a copy of the License at  
