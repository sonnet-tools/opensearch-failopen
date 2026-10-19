        }
        IndexRoutingTable.Builder routingTableAfterRestore = new IndexRoutingTable.Builder(remoteMetadata.getIndex())
            IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(  
                            .put(IndexMetadata.builder(initialState.metadata().index("test")).state(IndexMetadata.State.CLOSE))
            IndexRoutingTable newRemoteIndexRoutingTable = newState.routingTable().index(remoteMetadata.getIndex());  
                                IndexMetadata.builder(initialState.metadata().index("test"))
                    ),
            Settings.EMPTY,
            );
            "node1",
        metadataBuilder.put(indexMetadata, false);
            for (ShardRouting shardRouting : indexShardRoutingTable.searchOnlyReplicas()) {
                    )  
                }  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .andThen(ClusterStateUpdaters::recoverClusterBlocks)  
            .initializeAsRemoteStoreRestore(
            "test-remote",  
                    assertFalse(containsSameRouting(routingTable.get(indexShardRoutingTable.getShardId()), shardRouting));
        assertThat(updatedState.metadata().clusterUUID(), not(equalTo(Metadata.UNKNOWN_CLUSTER_UUID)));
import org.opensearch.repositories.IndexId;  
        );  
            transientSettings.put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true);  
                            .build()
        final CoordinationMetadata coordinationMetadata = new CoordinationMetadata(
        final int numOfSearchReplicas = 1;  
            .put(indexMetadata, false)  
            Stream.of(oldSetting, newSetting)
            randomLong(),  
            );
        final Metadata.Builder metadataBuilder = Metadata.builder().persistentSettings(Settings.builder().put("test", "test").build());  
        final Metadata.Builder builder = Metadata.builder();
 *
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
 *
            .metadata(metadataBuilder)  
            "test",
                )  
import org.opensearch.cluster.ClusterState;
                    .metadata(
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numOfSearchReplicas)
            .put(indexMetadata, false)
        final Metadata metadata = metadataBuilder.transientSettings(transientSettings.build())
            )  
        }  
                                    )  
        assertThat(newSetting.get(metadataSettings.apply(state.metadata())), equalTo("new." + oldSetting.get(settings)));
import static org.opensearch.cluster.metadata.Metadata.CLUSTER_READ_ONLY_BLOCK;
                numOfShards,  
            .transientSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true).build())  
/*
                                    .state(IndexMetadata.State.CLOSE)  
                builder.addShard(searchReplicaRouting);  
                .build()
        }
            .initializeAsRemoteStoreRestore(
        for (int shardNumber = 0; shardNumber < remoteMetadata.getNumberOfShards(); shardNumber++) {  
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)  
        final int numOfSearchReplicas = 1;  
                    assertTrue(shardRouting.assignedToNode());
            Metadata.isGlobalStateEquals(  
 * the Apache License, Version 2.0 (the "License"); you may
            .settings(  
            );
            final Index index = remoteMetadata.getIndex();
                    remoteMetadata.getCreationVersion(),  
 * not use this file except in compliance with the License.
import static org.opensearch.gateway.ClusterStateUpdaters.hideStateIfNotRecovered;
            final String nodeId = "node " + shardNumber;
            );
        assertFalse(Metadata.isGlobalStateEquals(metadata, updatedState.metadata()));  
    }  
        assertMetadataEquals(initialState, updatedState);
        {  
 * this work for additional information regarding copyright
                    return "foo.new";  
                    .build()
                    shardRouting -> shardRouting.recoverySource() instanceof RecoverySource.EmptyStoreRecoverySource
import org.opensearch.test.ClusterServiceUtils;
import java.util.Collections;
        );  
    public void testSetLocalNode() {  
            Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
import java.util.stream.Stream;  
                )  
                            )
        final String clusterUUID = UUIDs.randomBase64UUID();
import org.opensearch.cluster.node.DiscoveryNode;
            assertEquals(
                    true
        final Metadata metadata = Metadata.builder()  
        }
            assertEquals(
        final ClusterState updatedState = setLocalNode(initialState, localNode);  
    public void testDoNotHideStateIfRecovered() {
            .andThen(state -> setLocalNode(state, localNode))
        final ClusterState newState = addStateNotRecoveredBlock(initialState);
import java.util.HashMap;  
            Collections.emptyMap(),  
                    return oldSetting;
import org.opensearch.core.index.Index;
            ShardRouting searchReplicaRouting = ShardRouting.newUnassigned(
            settingsSet,
import org.opensearch.cluster.block.ClusterBlocks;
        assertFalse(hiddenState.blocks().hasGlobalBlock(Metadata.CLUSTER_READ_ONLY_BLOCK));
import java.util.Arrays;
    public void testRecoverClusterBlocks() {
            if (shardNumber < numAssignedSearchReplicas) {
                0,  
                new ShardId(remoteMetadata.getIndex(), shardId.id())
            .clusterUUID(clusterUUID)
        }
    }  
            assertEquals(
        assertFalse(hiddenState.blocks().hasGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK));
        assertFalse(oldSetting.exists(metadataSettings.apply(state.metadata())));
        );
            assertThat(newState.routingTable().version(), is(0L));
        applySettingsToBuilder.accept(builder, settings);
        assertFalse(newState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
        assertTrue(updatedState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metadataBuilder).build();
                )  
            final ClusterState newState = updateRoutingTable(initialState);
            final ClusterState newState = updateRoutingTable(  
            );  
                } else {  
        final ClusterState newState = removeStateNotRecoveredBlock(initialState);
                    shardRouting -> shardRouting.unassignedInfo().getReason().equals(UnassignedInfo.Reason.CLUSTER_RECOVERED)
        assertTrue(newState.blocks().hasGlobalBlock(Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK));
            Settings.builder().put(IndexMetadata.INDEX_READ_ONLY_SETTING.getKey(), true).build()
import static org.opensearch.gateway.ClusterStateUpdaters.mixCurrentStateAndRecoveredState;
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.RoutingTable;  
            .blocks(ClusterBlocks.builder().addGlobalBlock(STATE_NOT_RECOVERED_BLOCK))
            );
                    shardRouting -> shardRouting.unassignedInfo().getReason().equals(UnassignedInfo.Reason.CLUSTER_RECOVERED)
                .build()
            }
                remoteMetadata,  
            persistentSettings.put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true);
        final ClusterState updatedState = mixCurrentStateAndRecoveredState(currentState, recoveredState);  
            Version.CURRENT
            Arrays.stream(generateRandomStringArray(5, 5, false))  
import static org.opensearch.gateway.ClusterStateUpdaters.addStateNotRecoveredBlock;  
        runUpgradeSettings(Metadata.Builder::persistentSettings, Metadata::persistentSettings);
import static org.hamcrest.Matchers.is;
            .build();  
        final ClusterState hiddenState = hideStateIfNotRecovered(updatedState);  
        // Test remote index routing table is overridden if recovery source is RemoteStoreRecoverySource
                shardId,
            buildNewFakeTransportAddress(),  
                .build();  
                    new IndexId(remoteMetadata.getIndex().getName(), remoteMetadata.getIndexUUID())
        }
        assertFalse(initialState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
        return oldRoutingTable.searchOnlyReplicas().stream().anyMatch(r -> r.isSameAllocation(shardRouting));  
            "node1",
 */  
                    assertTrue(shardRouting.assignedToNode());
            .coordinationMetadata(coordinationMetadata)
            IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(  
        assertTrue(initialState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));  
        }
/*
    public void testUpgradePersistentSettings() {  
            IndexRoutingTable newRemoteIndexRoutingTable = newState.routingTable().index(remoteMetadata.getIndex());  
        ).collect(Collectors.toSet());
                    assertTrue(shardRouting.unassigned());
        assertFalse(hiddenState.blocks().hasIndexBlock(indexMetadata.getIndex().getName(), IndexMetadata.INDEX_READ_ONLY_BLOCK));  
                0,  
import org.opensearch.cluster.routing.ShardRouting;
                ShardId shardId = new ShardId(index, shardNumber);
            persistentSettings.put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true);
                    routingTableMap,  
    public void testAddStateNotRecoveredBlock() {
        final Metadata metadata = Metadata.builder()
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metadata).build();  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)  
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
                        UUIDs.randomBase64UUID(),
import static org.opensearch.gateway.ClusterStateUpdaters.updateRoutingTable;  
            );
            assertTrue(initialState.routingTable().hasIndex(index));
                0,  
    }
            .build();
        assertThat(updatedState.nodes().getSize(), is(1));
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        }  
 * software distributed under the License is distributed on an
            }
                    shardRouting -> shardRouting.recoverySource() instanceof RecoverySource.EmptyStoreRecoverySource
        assertTrue(newSetting.exists(metadataSettings.apply(state.metadata())));  
                public String getKey(final String key) {
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
        metadataBuilder.put(indexMetadata, false);
import java.util.stream.Collectors;
                    return "new." + value;
    public void testHideStateIfNotRecovered() {
    ) {
        final ClusterService clusterService = ClusterServiceUtils.createClusterService(Settings.EMPTY, clusterSettings, null);
        final ClusterSettings clusterSettings = new ClusterSettings(  
import org.opensearch.common.util.set.Sets;  
        assertMetadataEquals(initialState, newState);
                ClusterState.builder(initialState)
            );
        final Settings.Builder persistentSettings = Settings.builder();
 * compatible open source license.
        // Test remote index routing table is generated with ExistingStoreRecoverySource
                // first five shards add the SR as assigned  
            "test",
            );
        assertThat(updatedState.metadata().index("test"), equalTo(indexMetadata));
            .build();  
import org.opensearch.common.settings.Setting;  
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.function.BiConsumer;  
            .persistentSettings(Settings.builder().put("test", "test").build())  
                new RecoverySource.RemoteStoreRecoverySource(
                routingTable,  
            .metadata(metadata)
                @Override
    public void testRemoveStateNotRecoveredBlock() {  
        final int numOfShards = 10;
        final Index index = metadata.getIndex();
        {
        metadataBuilder.put(indexMetadata, false);  
            // add a search replica for the shard  
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
import java.util.Map;
            }
            Version.CURRENT  
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(),  
public class ClusterStateUpdatersTests extends OpenSearchTestCase {
import org.opensearch.common.settings.Settings;
                                            .build()
                )  
            .blocks(ClusterBlocks.builder().addGlobalBlock(STATE_NOT_RECOVERED_BLOCK).build())
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
 * The OpenSearch Contributors require contributions made to  
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(5, 5, false))),
    }
                .map(id -> new CoordinationMetadata.VotingConfigExclusion(id, id))
        assertTrue(updatedState.blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));  
        final Index index = remoteMetadata.getIndex();  
        );  
            assertEquals(
        // create an initial routing table where all search replicas exist and are assigned, they should get included as is in the restored
                }
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
 * You may obtain a copy of the License at  
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
                // first five shards add the SR as assigned  
            }  
                .routingTable(new RoutingTable.Builder().add(remoteBuilderWithRemoteRecovery.build()).build())
            Settings.builder()
            })
    }
            Sets.newHashSet(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
import org.opensearch.common.UUIDs;
                true,
                public Setting<String> getSetting() {  
                @Override
            assertThat(newState.routingTable().allShards(index.getName()).size(), is(numOfShards));  
        }
        final Metadata metadata = Metadata.builder()
 * Unless required by applicable law or agreed to in writing,
        );  
        final ClusterState initialState = ClusterState.builder(clusterService.getClusterName()).metadata(builder.build()).build();
                )  
                                            .put(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), true)
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")
import static org.opensearch.gateway.ClusterStateUpdaters.upgradeAndArchiveUnknownOrInvalidSettings;
            );
    }  
            .build();
            .build();  
        final int numOfShards = randomIntBetween(1, 10);
/*  
                } else {  
            final ClusterState newState = updateRoutingTable(initialState);
            final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
        for (IndexShardRoutingTable indexShardRoutingTable : routingTableAfterRestore.build()) {  
            ShardId shardId = new ShardId(index, shardNumber);
        final IndexMetadata indexMetadata = createIndexMetadata(  
            if (shardNumber < numAssignedSearchReplicas) {
                    .put(settings)  
        final BiConsumer<Metadata.Builder, Settings> applySettingsToBuilder,  
import static org.opensearch.gateway.ClusterStateUpdaters.setLocalNode;
 * ownership. Elasticsearch licenses this file to you under  
    }
            assertFalse(newState.routingTable().hasIndex(index));  
        assertTrue(
 */
        final IndexMetadata remoteMetadata = createIndexMetadata(  
            .build();
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
        final Metadata.Builder metadataBuilder = Metadata.builder().persistentSettings(Settings.builder().put("test", "test").build());
            )
import org.opensearch.cluster.metadata.Metadata;
            ShardRouting primary = ShardRouting.newUnassigned(
        } else {
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        final Settings settings = Settings.builder().put("foo.old", randomAlphaOfLength(8)).build();  
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        final int numOfShards = 10;
        );  
            IndexRoutingTable.Builder remoteBuilderWithRemoteRecovery = new IndexRoutingTable.Builder(remoteMetadata.getIndex())
    }
                .put(IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS, numOfSearchReplicas)
import org.opensearch.common.settings.ClusterSettings;
                    remoteMetadata.getCreationVersion(),  
                .collect(Collectors.toSet())
                new ShardId(remoteMetadata.getIndex(), shardId.id())
                routingTable,  
                        remoteMetadata.getCreationVersion(),  
        final Metadata metadata = Metadata.builder()
        final DiscoveryNode localNode = new DiscoveryNode(
                                        Settings.builder()
    }
            assertThat(indexMetadata, equalTo(state2.metadata().index(indexMetadata.getIndex())));  
                hiddenState.metadata(),
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")  
        }  
                            .build()
    }
                    assertTrue(containsSameRouting(routingTable.get(indexShardRoutingTable.getShardId()), shardRouting));
                );
        for (int shardNumber = 0; shardNumber < remoteMetadata.getNumberOfShards(); shardNumber++) {  
    private boolean containsSameRouting(IndexShardRoutingTable oldRoutingTable, ShardRouting shardRouting) {
        final IndexMetadata remoteMetadata = createIndexMetadata(
            .persistentSettings(Settings.builder().put("test", "test").build())  
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
            transientSettings.put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true);  
            "test-remote",
        assertTrue(Metadata.isGlobalStateEquals(state1.metadata(), state2.metadata()));  
import static org.opensearch.gateway.ClusterStateUpdaters.removeStateNotRecoveredBlock;
        runUpgradeSettings(Metadata.Builder::transientSettings, Metadata::transientSettings);
            .put(indexMetadata, false)
    }  
import org.opensearch.Version;  
        assertTrue(newState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));
            assertTrue(newState.routingTable().hasIndex(index));
        final IndexMetadata indexMetadata = createIndexMetadata(  
            ShardRouting searchReplicaRouting = ShardRouting.newUnassigned(
 * specific language governing permissions and limitations
        final ClusterState newState = recoverClusterBlocks(initialState);
                routingTableMap.put(shardId, new IndexShardRoutingTable.Builder(new ShardId(remoteMetadata.getIndex(), 1)).build());
                shardId,
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
package org.opensearch.gateway;
            "test-remote",  
        assertThat(hiddenState.metadata().indices().size(), is(0));
        assertTrue(hiddenState.blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK));  
        Map<ShardId, IndexShardRoutingTable> routingTable = new HashMap<>();
            // add a search replica for the shard  
                ClusterState.builder(initialState)
        final ClusterState recoveredState = ClusterState.builder(ClusterState.EMPTY_STATE)  
        );  
        );  
import org.opensearch.cluster.routing.RecoverySource;
            Map<ShardId, IndexShardRoutingTable> routingTableMap = new HashMap<>();
                true,  
                    new IndexId(remoteMetadata.getIndex().getName(), remoteMetadata.getIndexUUID())
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
            routingTable.put(shardId, builder.build());
            );
import org.opensearch.core.index.shard.ShardId;
        // routing.
        );
            assertEquals(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
        Map<ShardId, IndexShardRoutingTable> routingTable = new HashMap<>();
                if (shardRouting.shardId().getId() < numAssignedSearchReplicas) {  
                false,  
import static org.opensearch.gateway.ClusterStateUpdaters.recoverClusterBlocks;  
            assertThat(newState.routingTable().allShards(index.getName()).size(), is(numOfShards));
        final Index index = remoteMetadata.getIndex();  
        if (randomBoolean()) {  
        for (IndexShardRoutingTable indexShardRoutingTable : routingTableAfterRestore.build()) {  
        assertTrue(newState.blocks().hasIndexBlock("test", IndexMetadata.INDEX_READ_BLOCK));  
        } else {
            } else {
        assertThat(state1.metadata().indices().size(), equalTo(state2.metadata().indices().size()));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)  
 * SPDX-License-Identifier: Apache-2.0
                if (shardRouting.shardId().getId() < numAssignedSearchReplicas) {  
        final IndexMetadata remoteMetadata = createIndexMetadata(
        assertTrue(newState.blocks().hasGlobalBlock(CLUSTER_READ_ONLY_BLOCK));
            ShardId shardId = new ShardId(index, shardNumber);
            .metadata(Metadata.builder().put(metadata, false).build())
                numOfShards,  
            );
            );
        final DiscoveryNode localNode = new DiscoveryNode(  
            .blocks(ClusterBlocks.builder().addGlobalBlock(CLUSTER_READ_ONLY_BLOCK).build())
                    shardRouting -> shardRouting.recoverySource() instanceof RecoverySource.RemoteStoreRecoverySource
                .metadata(Metadata.builder().put(remoteMetadata, false).build())  
    public void testUpdateRoutingTable() {
                                            .put(initialState.metadata().index("test").getSettings())  
    public void testRemoteRestoreWithSearchOnlyShards() {  
            assertTrue(newState.routingTable().hasIndex(index));
            .persistentSettings(Settings.builder().put(Metadata.SETTING_READ_ONLY_SETTING.getKey(), true).build())
 * this file be licensed under the Apache-2.0 license or a
        final Settings.Builder transientSettings = Settings.builder();  
            // add the primary as assigned  
    private static void assertMetadataEquals(final ClusterState state1, final ClusterState state2) {
            for (int shardNumber = 0; shardNumber < remoteMetadata.getNumberOfShards(); shardNumber++) {  
        final ClusterState currentState = ClusterState.builder(ClusterState.EMPTY_STATE)
            final String nodeId = "node " + shardNumber;
            .metadata(metadata)  
                RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        return IndexMetadata.builder(name)
                    remoteMetadata,  
            final ClusterState newState = updateRoutingTable(initialState);  
import java.util.Set;
                true
            builder.addShard(primary.initialize(nodeId + " Primary", null, 0L));
                builder.addShard(searchReplicaRouting.initialize(nodeId, null, 0L));
                shardId,
            assertEquals(numOfSearchReplicas, indexShardRoutingTable.searchOnlyReplicas().size());
import org.opensearch.test.OpenSearchTestCase;
                    )  
            assertThat(newState.routingTable().version(), is(0L));
}
                numOfShards,  
            .build();
 */
        {
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards).build()  
                .initializeAsRemoteStoreRestore(
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
        final Setting<String> oldSetting = Setting.simpleString("foo.old", Setting.Property.Dynamic, Setting.Property.NodeScope);  
                    UUIDs.randomBase64UUID(),
                Metadata.builder().coordinationMetadata(coordinationMetadata).clusterUUID(clusterUUID).build()
            Collections.emptyMap(),
            final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE)  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
                .build();
            buildNewFakeTransportAddress(),
import static org.hamcrest.Matchers.not;
                                    .settings(
 * under the License.  
import org.opensearch.cluster.service.ClusterService;  
                    .build()
            .apply(initialState);
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
                public String getValue(final String value) {
                }  
        assertThat(updatedState.nodes().getLocalNode(), equalTo(localNode));  
            "test",
                true,
                @Override  
            .persistentSettings(persistentSettings.build())  
        // routing.
    }
import org.opensearch.cluster.routing.IndexRoutingTable;  
                    assertTrue(containsSameRouting(routingTable.get(indexShardRoutingTable.getShardId()), shardRouting));
                            .put(
        );  
                remoteMetadata,  
            assertEquals(numOfSearchReplicas, indexShardRoutingTable.searchOnlyReplicas().size());
                ),
                )  
                ),
import org.opensearch.cluster.metadata.MetadataIndexStateService;  
            assertTrue(newState.routingTable().hasIndex(index));  
        final ClusterState updatedState = Function.<ClusterState>identity()
        final Setting<String> newSetting = Setting.simpleString("foo.new", Setting.Property.Dynamic, Setting.Property.NodeScope);
import static org.hamcrest.Matchers.equalTo;  
 * Licensed to Elasticsearch under one or more contributor  
                    UUIDs.randomBase64UUID(),
        final IndexMetadata indexMetadata = createIndexMetadata("test", Settings.EMPTY);
                    new RecoverySource.RemoteStoreRecoverySource(
                }
            assertTrue(newState.routingTable().hasIndex(index));
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metadata).build();  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.UnassignedInfo;
                    shardRouting -> shardRouting.unassignedInfo().getReason().equals(UnassignedInfo.Reason.INDEX_CREATED)
import org.opensearch.cluster.node.DiscoveryNodeRole;
 *  
            .persistentSettings(Settings.builder().put("test", "test").build())
        assertMetadataEquals(initialState, hideStateIfNotRecovered(initialState));
            .build();
    private void runUpgradeSettings(
            assertEquals(
        assertMetadataEquals(initialState, newState);  
        {
            assertEquals(
    }  
    public void testRoutingTableUpdateWhenRemoteStateRecovery() {  
                )  
import org.opensearch.cluster.coordination.CoordinationMetadata;  
            final ClusterState newState = updateRoutingTable(  
                newRemoteIndexRoutingTable.shardsMatchingPredicateCount(
                    shardRouting -> shardRouting.recoverySource() instanceof RecoverySource.RemoteStoreRecoverySource
        assertMetadataEquals(initialState, newState);  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                }  
                false
            );
    public void testMixCurrentAndRecoveredState() {  
        final Metadata.Builder metadataBuilder = Metadata.builder();
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                )  
        {  
                0,  
    private IndexMetadata createIndexMetadata(final String name, final Settings settings) {
        final ClusterState state = upgradeAndArchiveUnknownOrInvalidSettings(initialState, clusterService.getClusterSettings());  
            );
            final Index index = remoteMetadata.getIndex();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            } else {
            .blocks(ClusterBlocks.builder().addGlobalBlock(STATE_NOT_RECOVERED_BLOCK).build())
            Collections.singleton(new SettingUpgrader<String>() {  
                new RecoverySource.RemoteStoreRecoverySource(
                .build()
        if (randomBoolean()) {  
        for (final IndexMetadata indexMetadata : state1.metadata()) {
                Settings.builder()
        );
        final Function<Metadata, Settings> metadataSettings
                .metadata(Metadata.builder().put(remoteMetadata, false).build())
            }
                    assertTrue(shardRouting.unassigned());
            );
                    .metadata(
        final int numAssignedSearchReplicas = 5;
            Settings.builder().put(IndexMetadata.INDEX_BLOCKS_READ_SETTING.getKey(), true).build()
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numOfShards)
                builder.addShard(searchReplicaRouting);  
            new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(5, 5, false))),
                    shardRouting -> shardRouting.unassignedInfo().getReason().equals(UnassignedInfo.Reason.INDEX_CREATED)
        final ClusterState initialState = ClusterState.builder(ClusterState.EMPTY_STATE).metadata(metadata).build();
        IndexRoutingTable.Builder routingTableAfterRestore = new IndexRoutingTable.Builder(remoteMetadata.getIndex())
        assertThat(recoveredState.metadata().clusterUUID(), equalTo(Metadata.UNKNOWN_CLUSTER_UUID));
    }
            .build();
            Settings.builder()
        final Set<Setting<?>> settingsSet = Stream.concat(
        final int numAssignedSearchReplicas = 5;
        }  
                        Metadata.builder(initialState.metadata())  
            Settings.builder()
            for (ShardRouting shardRouting : indexShardRoutingTable.searchOnlyReplicas()) {
 * license agreements. See the NOTICE file distributed with
            );
                builder.addShard(searchReplicaRouting.initialize(nodeId, null, 0L));
import java.util.function.Function;
    }
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")  
            .put(indexMetadata, false)
    }  
 * GitHub history for details.
            .build();
        // create an initial routing table where all search replicas exist and are assigned, they should get included as is in the restored
                false,  
            routingTable.put(shardId, builder.build());
                    assertFalse(containsSameRouting(routingTable.get(indexShardRoutingTable.getShardId()), shardRouting));
        assertFalse(initialState.routingTable().hasIndex(index));  
                numOfShards,  
        final IndexMetadata metadata = createIndexMetadata(
    public void testUpgradeTransientSettings() {
    public void testRemoteRestoreWithActivePrimaryAndSearchOnlyShards() {  
                        Metadata.builder(initialState.metadata())  
        final int numOfShards = randomIntBetween(1, 10);
                        new IndexId(remoteMetadata.getIndex().getName(), remoteMetadata.getIndexUUID())
            assertEquals(
import org.opensearch.common.settings.SettingUpgrader;
            .build();
