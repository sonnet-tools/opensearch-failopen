                true,
package org.opensearch.gateway;
                    new IndexId(remoteMetadata.getIndex().getName(), remoteMetadata.getIndexUUID())
        for (int shardNumber = 0; shardNumber < remoteMetadata.getNumberOfShards(); shardNumber++) {
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
                .build()
            assertEquals(
        }
        final Settings settings = Settings.builder().put("foo.old", randomAlphaOfLength(8)).build();
 */
    private IndexMetadata createIndexMetadata(final String name, final Settings settings) {
import java.util.stream.Stream;
import static org.opensearch.cluster.metadata.Metadata.CLUSTER_READ_ONLY_BLOCK;
            final ClusterState newState = updateRoutingTable(
            transientSettings.put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true);
                routingTable,
            assertTrue(newState.routingTable().hasIndex(index));
            "node1",
            persistentSettings.put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true);
        final Settings.Builder transientSettings = Settings.builder();
            IndexRoutingTable newRemoteIndexRoutingTable = newState.routingTable().index(remoteMetadata.getIndex());
        assertFalse(newState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
                );
                true,
 *
import org.opensearch.repositories.IndexId;
        );
            }
            final String nodeId = "node " + shardNumber;
    private static void assertMetadataEquals(final ClusterState state1, final ClusterState state2) {
                    assertTrue(shardRouting.assignedToNode());
        assertFalse(hiddenState.blocks().hasGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK));
        assertMetadataEquals(initialState, newState);
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
        assertTrue(newState.blocks().hasIndexBlock("test", IndexMetadata.INDEX_READ_BLOCK));
            .initializeAsRemoteStoreRestore(
            ShardRouting searchReplicaRouting = ShardRouting.newUnassigned(
            buildNewFakeTransportAddress(),
import static org.hamcrest.Matchers.not;
        assertTrue(initialState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
                // first five shards add the SR as assigned
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
            assertEquals(numOfSearchReplicas, indexShardRoutingTable.searchOnlyReplicas().size());
            assertEquals(
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            "test",
        assertThat(hiddenState.metadata().indices().size(), is(0));
                )
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
            for (ShardRouting shardRouting : indexShardRoutingTable.searchOnlyReplicas()) {
        // create an initial routing table where all search replicas exist and are assigned, they should get included as is in the restored
            );
        return oldRoutingTable.searchOnlyReplicas().stream().anyMatch(r -> r.isSameAllocation(shardRouting));
                routingTable,
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")
        }
import org.opensearch.common.settings.Settings;
        }
 * compatible open source license.
        final Settings.Builder persistentSettings = Settings.builder();
            routingTable.put(shardId, builder.build());
                new RecoverySource.RemoteStoreRecoverySource(
            .persistentSettings(Settings.builder().put("test", "test").build())
 * The OpenSearch Contributors require contributions made to
        final ClusterState hiddenState = hideStateIfNotRecovered(updatedState);
        final IndexMetadata metadata = createIndexMetadata(
            Collections.emptyMap(),
            final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
    public void testRecoverClusterBlocks() {
            Version.CURRENT
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metadata).build();
 * the Apache License, Version 2.0 (the "License"); you may
                    UUIDs.randomBase64UUID(),
                            .build()
        final Metadata.Builder metadataBuilder = Metadata.builder().persistentSettings(Settings.builder().put("test", "test").build());
            .clusterUUID(clusterUUID)
            );
        final ClusterSettings clusterSettings = new ClusterSettings(
    }
            assertTrue(newState.routingTable().hasIndex(index));
import org.opensearch.cluster.block.ClusterBlocks;
        final int numOfShards = randomIntBetween(1, 10);
            .build();
        final Index index = remoteMetadata.getIndex();
                .build()
                    shardRouting -> shardRouting.unassignedInfo().getReason().equals(UnassignedInfo.Reason.INDEX_CREATED)
                                    .settings(
    }
    }
        final Metadata metadata = Metadata.builder()
            "test-remote",
                public String getValue(final String value) {
            .persistentSettings(Settings.builder().put("test", "test").build())
            assertThat(newState.routingTable().version(), is(0L));
    }
        assertMetadataEquals(initialState, updatedState);
    }
                false,
            Metadata.isGlobalStateEquals(
        if (randomBoolean()) {
            randomLong(),
                .build();
                // first five shards add the SR as assigned
            );
                                        Settings.builder()
    public void testRemoteRestoreWithSearchOnlyShards() {
            Arrays.stream(generateRandomStringArray(5, 5, false))
                    true
    }
        final int numOfSearchReplicas = 1;
import org.opensearch.cluster.node.DiscoveryNodeRole;
            .build();
import org.opensearch.core.index.Index;
        }
import java.util.function.Function;
        }
        final ClusterState updatedState = Function.<ClusterState>identity()
                } else {
                .metadata(Metadata.builder().put(remoteMetadata, false).build())
            .put(indexMetadata, false)
 * software distributed under the License is distributed on an
                    shardRouting -> shardRouting.unassignedInfo().getReason().equals(UnassignedInfo.Reason.INDEX_CREATED)
                new ShardId(remoteMetadata.getIndex(), shardId.id())
                .routingTable(new RoutingTable.Builder().add(remoteBuilderWithRemoteRecovery.build()).build())
                }
        assertTrue(Metadata.isGlobalStateEquals(state1.metadata(), state2.metadata()));
    }
            ShardId shardId = new ShardId(index, shardNumber);
    }
        );
            .build();
import java.util.Collections;
                false,
        }
        final Metadata.Builder metadataBuilder = Metadata.builder().persistentSettings(Settings.builder().put("test", "test").build());
        } else {
 * Modifications Copyright OpenSearch Contributors. See
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
            final ClusterState newState = updateRoutingTable(
    public void testRoutingTableUpdateWhenRemoteStateRecovery() {
                    UUIDs.randomBase64UUID(),
                public Setting<String> getSetting() {
    private boolean containsSameRouting(IndexShardRoutingTable oldRoutingTable, ShardRouting shardRouting) {
            Settings.builder().put(IndexMetadata.INDEX_READ_ONLY_SETTING.getKey(), true).build()
                    assertTrue(containsSameRouting(routingTable.get(indexShardRoutingTable.getShardId()), shardRouting));
        ).collect(Collectors.toSet());
            .metadata(Metadata.builder().put(metadata, false).build())
        assertFalse(oldSetting.exists(metadataSettings.apply(state.metadata())));
import java.util.function.BiConsumer;
            );
        assertMetadataEquals(initialState, newState);
            if (shardNumber < numAssignedSearchReplicas) {
                .collect(Collectors.toSet())
        assertTrue(newState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
            buildNewFakeTransportAddress(),
            // add the primary as assigned
import org.opensearch.common.settings.Setting;
                    return "new." + value;
        final IndexMetadata indexMetadata = createIndexMetadata(
            .apply(initialState);
            .blocks(ClusterBlocks.builder().addGlobalBlock(STATE_NOT_RECOVERED_BLOCK).build())
            .andThen(state -> setLocalNode(state, localNode))
 * ownership. Elasticsearch licenses this file to you under
            Collections.singleton(new SettingUpgrader<String>() {
            assertEquals(
import java.util.Arrays;
    }
        // create an initial routing table where all search replicas exist and are assigned, they should get included as is in the restored
            routingTable.put(shardId, builder.build());
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metadata).build();
        }
            assertFalse(newState.routingTable().hasIndex(index));
    ) {
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
        IndexRoutingTable.Builder routingTableAfterRestore = new IndexRoutingTable.Builder(remoteMetadata.getIndex())
        final ClusterState initialState = ClusterState.builder(clusterService.getClusterName()).metadata(builder.build()).build();
 * You may obtain a copy of the License at
        final DiscoveryNode localNode = new DiscoveryNode(
        );
            IndexRoutingTable.Builder remoteBuilderWithRemoteRecovery = new IndexRoutingTable.Builder(remoteMetadata.getIndex())
    public void testUpgradeTransientSettings() {
    public void testSetLocalNode() {
        metadataBuilder.put(indexMetadata, false);
import org.opensearch.cluster.coordination.CoordinationMetadata;
            .persistentSettings(persistentSettings.build())
                    shardRouting -> shardRouting.unassignedInfo().getReason().equals(UnassignedInfo.Reason.CLUSTER_RECOVERED)
            .transientSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true).build())
            }
            )
 */
            .andThen(ClusterStateUpdaters::recoverClusterBlocks)
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")
            .build();
            );
                0,
            IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(
            ShardId shardId = new ShardId(index, shardNumber);
            .put(indexMetadata, false)
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
    }
            IndexRoutingTable newRemoteIndexRoutingTable = newState.routingTable().index(remoteMetadata.getIndex());
        assertThat(state1.metadata().indices().size(), equalTo(state2.metadata().indices().size()));
        // routing.
            assertEquals(
                            .put(IndexMetadata.builder(initialState.metadata().index("test")).state(IndexMetadata.State.CLOSE))
import org.opensearch.cluster.routing.IndexRoutingTable;
                    assertTrue(containsSameRouting(routingTable.get(indexShardRoutingTable.getShardId()), shardRouting));
                .initializeAsRemoteStoreRestore(
import static org.opensearch.gateway.ClusterStateUpdaters.upgradeAndArchiveUnknownOrInvalidSettings;
        Map<ShardId, IndexShardRoutingTable> routingTable = new HashMap<>();
    public void testAddStateNotRecoveredBlock() {
            assertEquals(
            .blocks(ClusterBlocks.builder().addGlobalBlock(STATE_NOT_RECOVERED_BLOCK))
        assertThat(updatedState.metadata().index("test"), equalTo(indexMetadata));
        final Function<Metadata, Settings> metadataSettings
import org.opensearch.cluster.metadata.IndexMetadata;
 * Unless required by applicable law or agreed to in writing,
        );
 * specific language governing permissions and limitations
    }
        // Test remote index routing table is generated with ExistingStoreRecoverySource
                new RecoverySource.RemoteStoreRecoverySource(
                    assertTrue(shardRouting.unassigned());
        assertFalse(hiddenState.blocks().hasGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK));
        assertFalse(initialState.routingTable().hasIndex(index));
                                            .build()
                0,
                    return "foo.new";
        assertThat(updatedState.nodes().getLocalNode(), equalTo(localNode));
            Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                shardId,
        assertTrue(hiddenState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
            Version.CURRENT
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
        assertThat(updatedState.metadata().clusterUUID(), not(equalTo(Metadata.UNKNOWN_CLUSTER_UUID)));
        );
                )
            IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(
            .build();
                    shardRouting -> shardRouting.recoverySource() instanceof RecoverySource.RemoteStoreRecoverySource
        final DiscoveryNode localNode = new DiscoveryNode(
        }
            builder.addShard(primary.initialize(nodeId + " Primary", null, 0L));
        for (final IndexMetadata indexMetadata : state1.metadata()) {
                builder.addShard(searchReplicaRouting.initialize(nodeId, null, 0L));
        assertThat(newSetting.get(metadataSettings.apply(state.metadata())), equalTo("new." + oldSetting.get(settings)));
                builder.addShard(searchReplicaRouting.initialize(nodeId, null, 0L));
}
                        UUIDs.randomBase64UUID(),
            .initializeAsRemoteStoreRestore(
                ClusterState.builder(initialState)
        final int numOfSearchReplicas = 1;
 * license agreements. See the NOTICE file distributed with
            );
                                    .state(IndexMetadata.State.CLOSE)
                ),
        );
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(5, 5, false))),
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
            );
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
            Settings.builder().put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true).build()
        if (randomBoolean()) {
 */
                new ShardId(remoteMetadata.getIndex(), shardId.id())
            .build();
                    new RecoverySource.RemoteStoreRecoverySource(
                    .put(settings)
                    return oldSetting;
            .build();
        {
    }
        final int numOfShards = 10;
        runUpgradeSettings(Metadata.Builder::transientSettings, Metadata::transientSettings);
        final Metadata.Builder metadataBuilder = Metadata.builder();
 *
                        new IndexId(remoteMetadata.getIndex().getName(), remoteMetadata.getIndexUUID())
            .metadata(metadata)
            assertTrue(newState.routingTable().hasIndex(index));
        final ClusterState currentState = ClusterState.builder(ClusterState.EMPTY_STATE)
            assertTrue(newState.routingTable().hasIndex(index));
        final BiConsumer<Metadata.Builder, Settings> applySettingsToBuilder,
        }
    }
            );
            );
import static org.hamcrest.Matchers.is;
                    remoteMetadata.getCreationVersion(),
import java.util.Map;
            assertThat(newState.routingTable().allShards(index.getName()).size(), is(numOfShards));
import static org.opensearch.gateway.ClusterStateUpdaters.hideStateIfNotRecovered;
                .metadata(Metadata.builder().put(remoteMetadata, false).build())
import static org.opensearch.gateway.ClusterStateUpdaters.recoverClusterBlocks;
                .build()
                numOfShards,
import org.opensearch.common.util.set.Sets;
        runUpgradeSettings(Metadata.Builder::persistentSettings, Metadata::persistentSettings);
                    shardRouting -> shardRouting.recoverySource() instanceof RecoverySource.RemoteStoreRecoverySource
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
        // Test remote index routing table is overridden if recovery source is RemoteStoreRecoverySource
            .settings(
        );
        final ClusterState recoveredState = ClusterState.builder(ClusterState.EMPTY_STATE)
            } else {
                Settings.builder()
            Settings.builder()
        }
                                    )
            final ClusterState newState = updateRoutingTable(initialState);
        assertTrue(updatedState.blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));
 * SPDX-License-Identifier: Apache-2.0
                numOfShards,
                public String getKey(final String key) {
        assertFalse(initialState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
                remoteMetadata,
                                            .put(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true)
                builder.addShard(searchReplicaRouting);
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
        final Metadata metadata = Metadata.builder()
import org.opensearch.cluster.service.ClusterService;
                            .put(
                @Override
                    shardRouting -> shardRouting.recoverySource() instanceof RecoverySource.EmptyStoreRecoverySource
            }
    public void testUpgradePersistentSettings() {
            assertTrue(initialState.routingTable().hasIndex(index));
                )
        metadataBuilder.put(indexMetadata, false);
                    assertTrue(shardRouting.assignedToNode());
                ),
                ClusterState.builder(initialState)
            ShardRouting primary = ShardRouting.newUnassigned(
                true,
        final IndexMetadata indexMetadata = createIndexMetadata(
                    shardRouting -> shardRouting.recoverySource() instanceof RecoverySource.EmptyStoreRecoverySource
import org.opensearch.test.ClusterServiceUtils;
        {
    public void testDoNotHideStateIfRecovered() {
    public void testUpdateRoutingTable() {
            "test",
                remoteMetadata,
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
            "node1",
                            )
                }
import org.opensearch.cluster.routing.ShardRouting;
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
        assertThat(recoveredState.metadata().clusterUUID(), equalTo(Metadata.UNKNOWN_CLUSTER_UUID));
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metadata).build();
            final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
 * GitHub history for details.
        final ClusterState newState = addStateNotRecoveredBlock(initialState);
            );
            final ClusterState newState = updateRoutingTable(initialState);
                )
            // add a search replica for the shard
                    .metadata(
            final Index index = remoteMetadata.getIndex();
import org.opensearch.cluster.metadata.Metadata;
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.gateway.ClusterStateUpdaters.updateRoutingTable;
        );
            assertThat(indexMetadata, equalTo(state2.metadata().index(indexMetadata.getIndex())));
            .blocks(ClusterBlocks.builder().addGlobalBlock(CLUSTER_READ_ONLY_BLOCK).build())
                .build();
                hiddenState.metadata(),
                0,
    public void testMixCurrentAndRecoveredState() {
                ShardId shardId = new ShardId(index, shardNumber);
                    ),
/*
        final Index index = remoteMetadata.getIndex();
        final Metadata metadata = Metadata.builder()
import org.opensearch.common.settings.SettingUpgrader;
        assertThat(updatedState.nodes().getSize(), is(1));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards).build()
        assertMetadataEquals(initialState, newState);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
            final Index index = remoteMetadata.getIndex();
            .build();
            "test-remote",
import static org.opensearch.gateway.ClusterStateUpdaters.removeStateNotRecoveredBlock;
            }
                routingTableMap.put(shardId, new IndexShardRoutingTable.Builder(new ShardId(remoteMetadata.getIndex(), 1)).build());
        return IndexMetadata.builder(name)
            persistentSettings.put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true);
import static org.opensearch.gateway.ClusterStateUpdaters.mixCurrentStateAndRecoveredState;
            Settings.builder()
        {
                }
            .build();
        {
        metadataBuilder.put(indexMetadata, false);
                    new IndexId(remoteMetadata.getIndex().getName(), remoteMetadata.getIndexUUID())
        final ClusterService clusterService = ClusterServiceUtils.createClusterService(Settings.EMPTY, clusterSettings, null);
                )
import org.opensearch.core.index.shard.ShardId;
        for (IndexShardRoutingTable indexShardRoutingTable : routingTableAfterRestore.build()) {
        final ClusterState state = upgradeAndArchiveUnknownOrInvalidSettings(initialState, clusterService.getClusterSettings());
        final CoordinationMetadata coordinationMetadata = new CoordinationMetadata(
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
            Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            ShardRouting searchReplicaRouting = ShardRouting.newUnassigned(
import org.opensearch.cluster.routing.RecoverySource;
        );
        // routing.
        final Setting<String> newSetting = Setting.simpleString("foo.new", Setting.Property.Dynamic, Setting.Property.NodeScope);
            Stream.of(oldSetting, newSetting)
            Settings.EMPTY,
                .map(id -> new CoordinationMetadata.VotingConfigExclusion(id, id))
import static org.opensearch.gateway.ClusterStateUpdaters.addStateNotRecoveredBlock;
import org.opensearch.cluster.ClusterState;
            assertThat(newState.routingTable().allShards(index.getName()).size(), is(numOfShards));
public class ClusterStateUpdatersTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        final Metadata metadata = Metadata.builder()
        final Setting<String> oldSetting = Setting.simpleString("foo.old", Setting.Property.Dynamic, Setting.Property.NodeScope);
            assertEquals(
        final ClusterState updatedState = setLocalNode(initialState, localNode);
        assertMetadataEquals(initialState, hideStateIfNotRecovered(initialState));
            )
        assertTrue(updatedState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
        final IndexMetadata remoteMetadata = createIndexMetadata(
            assertEquals(
            assertEquals(numOfSearchReplicas, indexShardRoutingTable.searchOnlyReplicas().size());
            );
            Settings.builder()
                builder.addShard(searchReplicaRouting);
        }
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            // add a search replica for the shard
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
import java.util.Set;
                true
            } else {
                        Metadata.builder(initialState.metadata())
                    .metadata(
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
            );
        final Set<Setting<?>> settingsSet = Stream.concat(
import static org.opensearch.gateway.ClusterStateUpdaters.setLocalNode;
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        );
        final Metadata.Builder builder = Metadata.builder();
                shardId,
    private void runUpgradeSettings(
                                IndexMetadata.builder(initialState.metadata().index("test"))
            .put(indexMetadata, false)
                )
                )
        {
            })
                    assertFalse(containsSameRouting(routingTable.get(indexShardRoutingTable.getShardId()), shardRouting));
        assertFalse(hiddenState.blocks().hasIndexBlock(indexMetadata.getIndex().getName(), IndexMetadata.INDEX_READ_ONLY_BLOCK));
            }
        assertTrue(newState.blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));
                numOfShards,
                0,
        for (int shardNumber = 0; shardNumber < remoteMetadata.getNumberOfShards(); shardNumber++) {
import org.opensearch.cluster.routing.RoutingTable;
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(5, 5, false))),
    }
            );
            .blocks(ClusterBlocks.builder().addGlobalBlock(STATE_NOT_RECOVERED_BLOCK).build())
        final ClusterState newState = recoverClusterBlocks(initialState);
            assertEquals(
                                            .put(initialState.metadata().index("test").getSettings())
        final IndexMetadata remoteMetadata = createIndexMetadata(
            if (shardNumber < numAssignedSearchReplicas) {
                shardId,
import org.opensearch.Version;
            );
        IndexRoutingTable.Builder routingTableAfterRestore = new IndexRoutingTable.Builder(remoteMetadata.getIndex())
                Metadata.builder().coordinationMetadata(coordinationMetadata).clusterUUID(clusterUUID).build()
                    )
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(),
    public void testRemoveStateNotRecoveredBlock() {
                            .build()
        final int numOfShards = 10;
                if (shardRouting.shardId().getId() < numAssignedSearchReplicas) {
import org.opensearch.common.settings.ClusterSettings;
        );
            transientSettings.put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true);
    }
                @Override
import java.util.HashMap;
                        remoteMetadata.getCreationVersion(),
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Map<ShardId, IndexShardRoutingTable> routingTable = new HashMap<>();
                    assertFalse(containsSameRouting(routingTable.get(indexShardRoutingTable.getShardId()), shardRouting));
                    shardRouting -> shardRouting.unassignedInfo().getReason().equals(UnassignedInfo.Reason.CLUSTER_RECOVERED)
import org.opensearch.test.OpenSearchTestCase;
 *
            );
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        final Index index = metadata.getIndex();
                if (shardRouting.shardId().getId() < numAssignedSearchReplicas) {
            .metadata(metadataBuilder)
/*
            Map<ShardId, IndexShardRoutingTable> routingTableMap = new HashMap<>();
                    remoteMetadata.getCreationVersion(),
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
            assertThat(newState.routingTable().version(), is(0L));
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
                false
 * Licensed to Elasticsearch under one or more contributor
        assertFalse(Metadata.isGlobalStateEquals(metadata, updatedState.metadata()));
import org.opensearch.cluster.metadata.MetadataIndexStateService;
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metadataBuilder).build();
 * not use this file except in compliance with the License.
            for (int shardNumber = 0; shardNumber < remoteMetadata.getNumberOfShards(); shardNumber++) {
                    remoteMetadata,
        final int numAssignedSearchReplicas = 5;
            .metadata(metadata)
        for (IndexShardRoutingTable indexShardRoutingTable : routingTableAfterRestore.build()) {
            Collections.emptyMap(),
            .persistentSettings(Settings.builder().put("test", "test").build())
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numOfSearchReplicas)
import org.opensearch.common.UUIDs;
                    .build()
                    assertTrue(shardRouting.unassigned());
        final int numAssignedSearchReplicas = 5;
        final ClusterState newState = removeStateNotRecoveredBlock(initialState);
                        Metadata.builder(initialState.metadata())
                numOfShards,
                }
import org.opensearch.cluster.routing.UnassignedInfo;
            final String nodeId = "node " + shardNumber;
        final ClusterState updatedState = mixCurrentStateAndRecoveredState(currentState, recoveredState);
import org.opensearch.cluster.node.DiscoveryNode;
    }
                    routingTableMap,
        final int numOfShards = randomIntBetween(1, 10);
                @Override
        final Metadata metadata = metadataBuilder.transientSettings(transientSettings.build())
            .coordinationMetadata(coordinationMetadata)
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
    public void testRemoteRestoreWithActivePrimaryAndSearchOnlyShards() {
                )
 * under the License.
        applySettingsToBuilder.accept(builder, settings);
            .build();
                    .build()
        assertTrue(newState.blocks().hasGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK));
    }
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            "test",
        assertTrue(
    public void testHideStateIfNotRecovered() {
            final ClusterState newState = updateRoutingTable(initialState);
            );
        }
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
            .build();
        assertTrue(newSetting.exists(metadataSettings.apply(state.metadata())));
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        } else {
/*
                } else {
            "test-remote",
            .put(indexMetadata, false)
            for (ShardRouting shardRouting : indexShardRoutingTable.searchOnlyReplicas()) {
 * KIND, either express or implied.  See the License for the
import java.util.stream.Collectors;
        final String clusterUUID = UUIDs.randomBase64UUID();
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")
        final IndexMetadata remoteMetadata = createIndexMetadata(
 * this work for additional information regarding copyright
            settingsSet,
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numOfSearchReplicas)
                    )
