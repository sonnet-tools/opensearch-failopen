    }
        }
        if (Metadata.SETTING_READ_ONLY_SETTING.get(state.metadata().settings())) {
        metadataBuilder.generateClusterUuidIfNeeded();
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
}
            .blocks(ClusterBlocks.builder().blocks(state.blocks()).removeGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK).build())
        }
                .coordinationMetadata(state.metadata().coordinationMetadata())
package org.opensearch.gateway;
        return ClusterState.builder(state).routingTable(routingTableBuilder.build()).build();
        return ClusterState.builder(currentState).blocks(blocks).metadata(metadataBuilder).build();
 *
import org.opensearch.cluster.metadata.Metadata;
    private static final Logger logger = LogManager.getLogger(ClusterStateUpdaters.class);
 */
        metadataBuilder.transientSettings(
    }
            return ClusterState.builder(state).metadata(metadata).blocks(blocks.build()).build();
            .blocks(ClusterBlocks.builder().blocks(state.blocks()).addGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK).build())
                e.getValue()
    static ClusterState upgradeAndArchiveUnknownOrInvalidSettings(final ClusterState clusterState, final ClusterSettings clusterSettings) {
            ),
 * KIND, either express or implied.  See the License for the
        return ClusterState.builder(state)
            metadataBuilder.put(indexMetadata, false);
 * Unless required by applicable law or agreed to in writing,
 * Updates cluster state
        }
            blocks.addBlocks(indexMetadata);
 * @opensearch.internal
    }
            blocks.removeGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK);
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks()).blocks(recoveredState.blocks());
 * compatible open source license.
        assert currentState.metadata().indices().isEmpty();
 */
                "ignoring invalid {} setting: [{}] with value [{}]; archiving",
 * license agreements. See the NOTICE file distributed with
public class ClusterStateUpdaters {
            clusterSettings.archiveUnknownOrInvalidSettings(
 *    http://www.apache.org/licenses/LICENSE-2.0
            () -> new ParameterizedMessage(
            )
            blocks.addGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK);
 * The OpenSearch Contributors require contributions made to
/*
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.cluster.ClusterState;
    }
    private static void logInvalidSetting(final String settingType, final Map.Entry<String, String> e, final IllegalArgumentException ex) {
 */
    static ClusterState recoverClusterBlocks(final ClusterState state) {
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
    private static void logUnknownSetting(final String settingType, final Map.Entry<String, String> e) {
        return ClusterState.builder(clusterState).metadata(metadataBuilder).build();
                e -> logUnknownSetting("persistent", e),
            clusterSettings.archiveUnknownOrInvalidSettings(
import org.opensearch.cluster.routing.RoutingTable;
        return ClusterState.builder(state).blocks(blocks).build();
        return ClusterState.builder(state)
        for (final IndexMetadata indexMetadata : state.metadata()) {
        }
        return state;
        // initialize all index routing tables as empty
import org.apache.logging.log4j.Logger;
        final Metadata.Builder metadataBuilder = Metadata.builder(clusterState.metadata());
import org.opensearch.cluster.node.DiscoveryNode;
    }
    }
import org.opensearch.common.settings.ClusterSettings;
        // automatically generate a UID for the metadata if we need to
        }
/*
        }
            blocks.removeGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
        );
 *
    public static ClusterState addStateNotRecoveredBlock(ClusterState state) {
                blocks.removeIndexBlocks(indexMetadata.getIndex().getName());
        // start with 0 based versions for routing table
            for (IndexMetadata indexMetadata : state.metadata()) {
    static ClusterState setLocalNode(final ClusterState clusterState, DiscoveryNode localNode) {
 * the Apache License, Version 2.0 (the "License"); you may
    static ClusterState updateRoutingTable(final ClusterState state) {
            }
    }
                (e, ex) -> logInvalidSetting("persistent", e, ex)
/*
            .build();
            .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).build())
        logger.warn(
            .build();
 * GitHub history for details.
        if (state.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK)) {
 * Licensed to Elasticsearch under one or more contributor
        if (Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.get(state.metadata().settings())) {
            ex
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
import org.opensearch.cluster.metadata.IndexMetadata;
                clusterSettings.upgradeSettings(metadataBuilder.transientSettings()),
            final Metadata metadata = Metadata.builder()
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(state.blocks());
            blocks.addGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
            final ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(state.blocks());
                e -> logUnknownSetting("transient", e),
            )
                e.getKey(),
 * this file be licensed under the Apache-2.0 license or a
 *
        for (final IndexMetadata indexMetadata : recoveredState.metadata()) {
 * specific language governing permissions and limitations
                settingType,
        logger.warn("ignoring unknown {} setting: [{}] with value [{}]; archiving", settingType, e.getKey(), e.getValue());
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder(state.routingTable());
import java.util.Map;
/**
import org.opensearch.cluster.block.ClusterBlocks;
                .build();
        );
                .clusterUUID(state.metadata().clusterUUID())
 */
 * ownership. Elasticsearch licenses this file to you under
    }
        final Metadata.Builder metadataBuilder = Metadata.builder(recoveredState.metadata());
        metadataBuilder.persistentSettings(
            routingTableBuilder.addAsRecovery(cursor);
                (e, ex) -> logInvalidSetting("transient", e, ex)
 *
    }
            .build();
import org.opensearch.cluster.node.DiscoveryNodes;
                clusterSettings.upgradeSettings(metadataBuilder.persistentSettings()),
    static ClusterState mixCurrentStateAndRecoveredState(final ClusterState currentState, final ClusterState recoveredState) {
        routingTableBuilder.version(0);
 * SPDX-License-Identifier: Apache-2.0
    static ClusterState removeStateNotRecoveredBlock(final ClusterState state) {
        for (final IndexMetadata cursor : state.metadata().indices().values()) {
    }
    public static ClusterState hideStateIfNotRecovered(ClusterState state) {
        return ClusterState.builder(clusterState)
        );
import org.apache.logging.log4j.LogManager;
