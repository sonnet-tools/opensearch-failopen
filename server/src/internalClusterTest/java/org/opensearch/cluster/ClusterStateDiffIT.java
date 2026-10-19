        );  
        ClusterState.Builder builder = ClusterState.builder(clusterState);
            public Metadata.Builder put(Metadata.Builder builder, Metadata.Custom part) {  
                                RestoreInProgress.State.fromValue((byte) randomIntBetween(0, 3)),
            public IndexMetadata randomCreate(String name) {
                    default:
     */  
            public IndexMetadata randomChange(IndexMetadata part) {
    private interface RandomPart<T> {
    }
                    unassignedInfo = new UnassignedInfo(randomReason(), randomAlphaOfLength(10));
     * Randomly creates or removes cluster blocks
            }
            public ClusterState.Custom randomCreate(String name) {
                        )
            int replicaCount = randomIntBetween(1, 10);
    /**
            @Override
        DiscoveryNode otherNode = randomNode("other");
        /**
        }  
                                    randomBoolean(),  
                    case 0:  
        return ClusterState.builder(randomClusterStateParts(clusterState, "custom", new RandomClusterPart<ClusterState.Custom>() {
                }
        return builder.build();
                if (randomInt(5) == 1) {  
                }
                    clusterState = builder.build();
                            clusterState.routingTable().indicesRouting().get(index),  
                    return builder.removeCustom(name);
                    )
                                )
            public Map<String, ClusterState.Custom> parts(ClusterState clusterState) {
            }
import org.opensearch.cluster.block.ClusterBlock;
    }  
        Map<String, T> parts(Metadata metadata);
         * Returns list of parts from metadata  
            @Override
         */
     */  
                    // there must always be at least an empty graveyard
                        throw new IllegalArgumentException("Shouldn't be here");  
    private ClusterState.Builder randomCoordinationMetadata(ClusterState clusterState) {
            public ClusterState.Custom randomChange(ClusterState.Custom part) {  
    private Settings randomSettings(Settings settings) {
                assertThat(
import java.util.Collections;
            public Map<String, Metadata.Custom> parts(Metadata metadata) {
        }  
        final Map<String, T> parts = randomPart.parts(clusterState);
        if (randomBoolean()) {
        ClusterState.Builder builder = ClusterState.builder(clusterState);
                throw error;
        return ClusterState.builder(clusterState).routingTable(builder.build());
                assertThat(
                final ShardRouting updatedShardRouting = randomChange(shardRouting, availableNodes);
     * Randomly adds, deletes or updates index templates in the metadata
     * Generates random alias
                        nodeId,  
                    randomPart.remove(builder, part);
        Metadata metadata = clusterState.metadata();
            }
                assertThat(clusterStateFromDiffs.metadata().version(), equalTo(clusterState.metadata().version()));
     * Generates a random name that starts with the given prefix
            @Override
                // JSON Serialization test - make sure that both states produce similar JSON
        for (int iteration = 0; iteration < iterationCount; iteration++) {
                        builder.settings(Settings.builder().put(part.getSettings()).put(randomSettings(Settings.EMPTY)));  
                            builder.putAlias(AliasMetadata.builder(randomAlphaOfLength(10)));  
 * specific language governing permissions and limitations
import org.opensearch.cluster.metadata.IndexMetadata;  
                UnassignedInfo unassignedInfo = null;
    }
                switch (randomIntBetween(0, 1)) {
                );
            default:
            }  
import org.opensearch.core.common.bytes.BytesReference;
                    case 0:
     */  
        return builder.build();  
    }
                        );
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.cluster.metadata.Metadata;
        }
            return Metadata.builder(metadata).persistentSettings(randomSettings(metadata.persistentSettings())).build();
                } else {  
        /**
    /**
            }
    /**
                        i,
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < shardCount; i++) {  
                }
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
        return ClusterState.builder(clusterState).blocks(builder);
                    randomPart.put(builder, randomPart.randomChange(parts.get(part)));
/*
            String name = randomName(prefix);
                        break;
        }
    private ClusterState.Builder randomBlocks(ClusterState clusterState) {  
                IndexMetadata.Builder builder = IndexMetadata.builder(name);  
                if (randomBoolean()) {
                // Update cluster state via full serialization from time to time  
                }
        if (partCount > 0) {
                    case 1:
     */  
                randomInt(numberOfIndices - 1),  
                        ShardRoutingState.fromValue((byte) randomIntBetween(2, 3)),  
                case 3:  
     * If a new part is added the prefix value is used as a prefix of randomly generated part name.
                return builder.build();
import static java.util.Collections.emptyList;  
         */  
                                new SnapshotsInProgress.Entry(  
    private Metadata randomMetadataCustoms(final Metadata metadata) {  
            }
        return ClusterState.builder(clusterState).metadata(Metadata.builder(metadata).version(metadata.version() + 1).build());
    /**  
     */  
        int changesCount = randomIntBetween(1, 10);  
        return randomParts(metadata, "index", new RandomPart<IndexMetadata>() {
import java.util.Set;
        for (int i = 0; i < settingsCount; i++) {
        Metadata.Builder builder = Metadata.builder(metadata);
                                    randomIntBetween(0, 1000),
            }  
 * SPDX-License-Identifier: Apache-2.0
        int partCount = parts.size();  
            }  
                if (shardRouting.relocating()) {  
        DiscoveryNode clusterManagerNode = randomNode("cluster-manager");
import static org.opensearch.test.VersionUtils.randomVersion;  
    }
            public Metadata.Builder remove(Metadata.Builder builder, String name) {
                        break;
            List<String> randomParts = randomSubsetOf(
        ClusterBlocks.Builder builder = ClusterBlocks.builder().blocks(clusterState.blocks());
     * Randomly adds, deletes or updates repositories in the metadata
        }
 * GitHub history for details.
import org.opensearch.cluster.routing.ShardRouting;  
            public Map<String, IndexTemplateMetadata> parts(Metadata metadata) {
                // Check cluster blocks
 */
         */
        CoordinationMetadata.Builder metaBuilder = CoordinationMetadata.builder(clusterState.coordinationMetadata());  
        for (int i = 0; i < additionalPartCount; i++) {  
                        break;
                        randomChangeToIndexRoutingTable(
                    builder.putAlias(randomAlias());
                String nodeId = randomFrom(availableNodeIds);  
        }
                    break;
                        return new RestoreInProgress.Builder().add(  
        int additionalNodeCount = randomIntBetween(1, 20);  
            @Override
            @Override  
                return metadata.customs();
        if (randomBoolean()) {  
import org.opensearch.core.index.Index;  
            IndexShardRoutingTable.Builder indexShard = new IndexShardRoutingTable.Builder(new ShardId(index, "_na_", i));
    /**
                    case 2:
            @Override  
                );  
    private Metadata randomTemplates(Metadata metadata) {
        /**
                    TestShardRouting.newShardRouting(  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }  
            } catch (AssertionError error) {
                                    null,
            } else {  
                        break;
                switch (randomInt(5)) {
                    clusterStateFromDiffs.toString()  
            }
            for (String part : randomParts) {  
        Map<String, T> parts(ClusterState clusterState);
import org.opensearch.cluster.routing.RoutingTable;
         */
            public IndexTemplateMetadata randomCreate(String name) {
                    return builder.indexGraveyard(IndexGraveyard.builder().build());
            clusterState = builder.incrementVersion().build();  
        return builder.build();
                    assertThat(node1.getVersion(), equalTo(node2.getVersion()));
                assertThat(clusterStateFromDiffs.blocks().indices(), equalTo(clusterStateFromDiffs.blocks().indices()));
            }
        logger.info("Final cluster state:[{}]", clusterState.toString());  
 * compatible open source license.
                // Check metadata
                    clusterStateFromDiffs.blocks().disableStatePersistence(),  
            }
                    clusterStateFromDiffs = diff.apply(previousClusterStateFromDiffs);
            .build();
     */
            }  
                return metadata.templates();
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
import static org.hamcrest.Matchers.is;
                                    Collections.emptyList(),
 * Licensed to Elasticsearch under one or more contributor  
                }
     * Randomly adds, deletes or updates in-progress snapshot and restore records in the cluster state
                );
                try (StreamInput input = StreamInput.wrap(diffBytes)) {
                byte[] diffBytes = BytesReference.toBytes(os.bytes());
import org.opensearch.cluster.routing.IndexRoutingTable;  
        }
     * Randomly add, deletes or updates indices in the metadata
                    default:  
 * Unless required by applicable law or agreed to in writing,
        final Map<String, T> parts = randomPart.parts(metadata);
            builder.add(randomIndexRoutingTable("index-" + randomInt(), clusterState.nodes().getNodes().keySet().toArray(new String[0])));  
                        builder = randomNodes(clusterState);  
                        );  
                return builder.putCustom(part.getWriteableName(), part);
 *
    /**
                clusterStateFromDiffs = ClusterState.Builder.fromBytes(
            namedWriteableRegistry  
                BytesStreamOutput os = new BytesStreamOutput();  
        }  
            );
    private IndexRoutingTable randomIndexRoutingTable(String index, String[] nodeIds) {
                        throw new IllegalArgumentException("Shouldn't be here");
        if (randomBoolean()) {  
                return builder.remove(name);
        Metadata.Builder put(Metadata.Builder builder, T part);
                IndexTemplateMetadata.Builder builder = new IndexTemplateMetadata.Builder(part);  
        }
                    randomPart.put(builder, randomPart.randomChange(parts.get(part)));
import static org.hamcrest.Matchers.equalTo;  
                // Check routing table
 * this file be licensed under the Apache-2.0 license or a
                new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false)))  
            builder.addIndexShard(indexShard.build());
         * Returns a random part with the specified name  
                    break;
                        builder = randomMetadataChanges(clusterState);  
     */  
                            )  
            if (nodeId.startsWith("node-")) {
import static org.opensearch.test.XContentTestUtils.differenceBetweenMapsIgnoringArrayOrder;
     * Returns a random global block
     */  
        for (var indexShardRoutingTable : original.shards().values()) {  
                return NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES;  
         */  
            }  
            }
                clusterState.blocks().global().toArray(new ClusterBlock[globalBlocksCount])  
        int partCount = parts.size();  
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
            }  
                availableNodes.remove(updatedShardRouting.currentNodeId());
                }
            public Metadata.Builder remove(Metadata.Builder builder, String name) {  
                    );  
                builder.addShard(updatedShardRouting);  
    /**  
                assertThat(clusterStateFromDiffs.routingTable().version(), equalTo(clusterState.routingTable().version()));
    private ClusterState.Builder randomMetadataChanges(ClusterState clusterState) {
        if (numberOfIndices > 0) {
import org.opensearch.snapshots.SnapshotId;
            Set<String> availableNodes = Sets.newHashSet(nodes);
    private String randomName(String prefix) {  
            List<String> randomParts = randomSubsetOf(randomInt(partCount - 1), randomPart.parts(metadata).keySet().toArray(new String[0]));
                }
                    ClusterState.Builder.toBytes(clusterState),
            randomPart.put(builder, randomPart.randomCreate(name));
                }  
     * Takes an existing cluster state and randomly adds, removes or updates a metadata part using randomPart generator.  
                            clusterState.nodes().getNodes().keySet().toArray(new String[0])
        }));  
    /**
        /**
            }
    /**  
            String name = randomName(prefix);
                        builder = randomRoutingTable(clusterState);  
            randomInt(clusterState.nodes().getNodes().size() - 1),
                    assertThat(node1.getAttributes(), equalTo(node2.getAttributes()));
    }  
    private ClusterState.Builder randomRoutingTable(ClusterState clusterState) {
        T randomChange(T part);
                            new RestoreInProgress.Entry(
        /**
            List<ClusterBlock> blocks = randomSubsetOf(
            randomPart.put(builder, randomPart.randomCreate(name));
        }  
            @Override  
            @Override
                // however, serialized size should remain the same  
        return builder;  
 * The OpenSearch Contributors require contributions made to  
                int aliasCount = randomInt(10);  
     * Randomly updates routing table in the cluster state
        Settings.Builder builder = Settings.builder();
            .localNodeId(clusterManagerNode.getId())  
        for (int i = 0; i < additionalGlobalBlocksCount; i++) {
                        break;
            }  
        for (int i = 0; i < additionalNodeCount; i++) {
     */  
        if (randomBoolean()) {  
    private Metadata randomIndices(Metadata metadata) {
                assertThat(clusterStateFromDiffs.nodes().getLocalNodeId(), equalTo(previousClusterStateFromDiffs.nodes().getLocalNodeId()));  
                assertThat(clusterStateFromDiffs.metadata().equalsAliases(clusterState.metadata()), is(true));  
                case 0:  
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.snapshots.SnapshotInfoTests;  
                return builder.put(part, true);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                        return SnapshotsInProgress.of(
    /**
                availableNodes.remove(shardRouting.currentNodeId());  
                                    randomVersion(random()),  
            .add(clusterManagerNode)
     */
    private <T> Metadata randomParts(Metadata metadata, String prefix, RandomPart<T> randomPart) {  
        return builder.build();  
    /**
                assertThat(clusterStateFromDiffs.nodes().getNodes(), equalTo(clusterState.nodes().getNodes()));
            public ClusterState.Builder remove(ClusterState.Builder builder, String name) {
        }
    }
import org.opensearch.core.index.shard.ShardId;
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
     */
import static org.opensearch.cluster.metadata.AliasMetadata.newAliasMetadataBuilder;  
            @Override
        return builder.build();
        return prefix + UUIDs.randomBase64UUID(random());
                    case 1:
 * You may obtain a copy of the License at  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                    .settings(randomSettings(Settings.EMPTY));
         */  
    /**
    /**  
     */
                    return new RepositoriesMetadata(Collections.emptyList());
import org.opensearch.common.io.stream.BytesStreamOutput;
            metaBuilder.lastCommittedConfiguration(  
                switch (randomIntBetween(0, 2)) {
            );
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;  
            @Override
                if (randomBoolean()) {
    /**
        }
                                    Map.of(),  
                settingsBuilder.put(randomSettings(Settings.EMPTY)).put(IndexMetadata.SETTING_VERSION_CREATED, randomVersion(random()));  
        ClusterState.Builder put(ClusterState.Builder builder, T part);
                assertThat(clusterStateFromDiffs.metadata().clusterUUID(), equalTo(clusterState.metadata().clusterUUID()));  
            ClusterState.Builder builder = null;
                }
        }  
         * Makes random modifications to the part
                    return IndexGraveyardTests.createRandom();
                        if (randomBoolean() && part.getAliases().isEmpty() == false) {  
            builder.addGlobalBlock(randomGlobalBlock());
        T randomChange(T part);
                assertThat(clusterStateFromDiffs.routingTable().indicesRouting(), equalTo(clusterState.routingTable().indicesRouting()));  
        }  
                    randomPart.remove(builder, part);
    /**
            }  
            List<String> randomIndices = randomSubsetOf(
        );
            }
                                UUIDs.randomBase64UUID(),
        return builder.build();
package org.opensearch.cluster;
                return builder.removeCustom(name);  
import org.opensearch.gateway.GatewayService;
            @Override
            }
                case 1:  
        int settingsCount = randomInt(10);  
                builder.settings(settingsBuilder);
        /**  
                    builder.putAlias(randomAlias());
        for (int i = 0; i < additionalIndexCount; i++) {
                }
            metaBuilder.lastAcceptedConfiguration(
        }
    /**
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 0, numClientNodes = 0)  
                                    randomBoolean(),
            ClusterState.Builder.toBytes(clusterState),
                }
                return GatewayService.STATE_NOT_RECOVERED_BLOCK;
                return builder.build();
    }
            nodes.add(randomNode("node-" + randomAlphaOfLength(10)));
                randomPart.parts(clusterState).keySet().toArray(new String[0])
                return builder.put(part);
                    nodes.add(randomNode(nodeId));
        }
                } else {  
                Settings.Builder settingsBuilder = Settings.builder();
import static java.util.Collections.emptyMap;
            @Override
        }  
import org.opensearch.core.common.io.stream.StreamInput;
                }  
            public Map<String, IndexMetadata> parts(Metadata metadata) {
        ClusterState.Builder remove(ClusterState.Builder builder, String name);  
                        break;
            for (String index : randomIndices) {  
    }  
            int changesCount = randomIntBetween(1, 4);
                int aliasCount = randomIntBetween(0, 10);  
        int numberOfIndices = clusterState.routingTable().indicesRouting().size();  
     */
    private ClusterBlock randomGlobalBlock() {
    private AliasMetadata randomAlias() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            ClusterState previousClusterStateFromDiffs = clusterStateFromDiffs;  
        });
                    assertThat(node1.getAddress(), equalTo(node2.getAddress()));  
                    .patterns(Collections.singletonList(randomName("temp")))
import org.opensearch.snapshots.Snapshot;
 * the Apache License, Version 2.0 (the "License"); you may
                // Check nodes
                assertNull(differenceBetweenMapsIgnoringArrayOrder(convertToMap(clusterStateFromDiffs), convertToMap(clusterState)));  
                        builder.settings(
                                    Math.abs(randomLong()),
            @Override
            if (randomIntBetween(0, 10) < 1) {
     * Random metadata part generator
     */  
/*  
        /**
                randomInt(globalBlocksCount - 1),
        });
                setRandomIndexSettings(random(), settingsBuilder);
            }  
                assertThat(clusterStateFromDiffs.blocks().global(), equalTo(clusterStateFromDiffs.blocks().global()));  
            }
            for (int i = 0; i < changesCount; i++) {  
        AliasMetadata.Builder builder = newAliasMetadataBuilder(randomName("alias"));
    }
                assertThat(clusterStateFromDiffs.metadata().indices(), equalTo(clusterState.metadata().indices()));  
            @Override
import org.opensearch.common.UUIDs;
    }
                assertThat(clusterStateFromDiffs.metadata().customs(), equalTo(clusterState.metadata().customs()));
     * Randomly updates index routing table in the cluster state  
                return part;
                    clusterState.toString(),
import org.opensearch.cluster.routing.UnassignedInfo;  
                    case 4:
                assertThat(clusterStateFromDiffs.metadata().persistentSettings(), equalTo(clusterState.metadata().persistentSettings()));
                return metadata.indices();  
    private ClusterState.Builder randomClusterStateCustoms(final ClusterState clusterState) {  
        List<String> nodeIds = randomSubsetOf(  
        }
    }
                }  
            ClusterState previousClusterState = clusterState;
         */
/*  
         * Puts the part back into metadata
                if (IndexGraveyard.TYPE.equals(name)) {  
        int iterationCount = randomIntBetween(10, 300);  
                    case 0:
                return part;
import org.opensearch.cluster.routing.TestShardRouting;
    /**
     * Randomly updates nodes in the cluster state
            }  
                    default:
                    DiscoveryNode node1 = clusterState.nodes().get(node);  
        return ClusterState.builder(clusterState).nodes(nodes);
                        unassignedInfo
                                    new Snapshot(randomName("repo"), new SnapshotId(randomName("snap"), UUIDs.randomBase64UUID())),
        /**  
    }
            clusterState.nodes().getNodes().keySet().toArray(new String[0])
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
import org.opensearch.index.query.QueryBuilders;  
        int additionalIndexCount = randomIntBetween(1, 20);
                    break;
                }  
    private <T> ClusterState randomClusterStateParts(ClusterState clusterState, String prefix, RandomClusterPart<T> randomPart) {  
import java.util.List;
            }
import static org.opensearch.cluster.routing.RandomShardRoutingMutator.randomChange;
            }
            public Metadata.Builder put(Metadata.Builder builder, IndexTemplateMetadata part) {  
                                Map.of()  
                return NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL;
                assertThat(clusterStateFromDiffs.metadata().transientSettings(), equalTo(clusterState.metadata().transientSettings()));
        RoutingTable.Builder builder = RoutingTable.builder(clusterState.routingTable());
                return builder.build();
                );
                randomInt(partCount - 1),  
                    metadata = randomTemplates(metadata);
import java.util.Map;  
            }
import org.opensearch.cluster.metadata.IndexGraveyardTests;
            );
        int additionalPartCount = randomIntBetween(1, 20);
        for (int i = 0; i < changesCount; i++) {
                Diff<ClusterState> diff;  
        int additionalGlobalBlocksCount = randomIntBetween(1, 3);  
            @Override  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
    }
            }
import org.opensearch.cluster.node.DiscoveryNode;
            }  
     */  
        metaBuilder.term(randomNonNegativeLong());
 * KIND, either express or implied.  See the License for the
         * Returns list of parts from metadata  
            @Override
        if (globalBlocksCount > 0) {  
        return randomParts(metadata, "template", new RandomPart<IndexTemplateMetadata>() {
                case 2:  
         * Puts the part back into metadata
                                    SnapshotsInProgressSerializationTests.randomState(Map.of()),
                if (randomBoolean()) {
        } else {
            public IndexTemplateMetadata randomChange(IndexTemplateMetadata part) {
import org.opensearch.cluster.metadata.AliasMetadata;  
            public ClusterState.Builder put(ClusterState.Builder builder, ClusterState.Custom part) {  
                    diff = ClusterState.readDiffFrom(namedInput, previousClusterStateFromDiffs.nodes().getLocalNode());  
                return builder.build();
            @Override  
                            builder.removeAlias(randomFrom(part.getAliases().keySet().toArray(new String[0])));
                } else {  
                );
                if (randomBoolean()) {
            switch (randomInt(3)) {
import org.opensearch.snapshots.SnapshotsInProgressSerializationTests;
                if (availableNodeIds.isEmpty()) {  
    }
        return randomParts(metadata, "custom", new RandomPart<Metadata.Custom>() {
        for (int i = 0; i < additionalPartCount; i++) {  
                    throw new IllegalArgumentException("Shouldn't be here");
                }
                }
 * this work for additional information regarding copyright
                                    Collections.emptyList(),  
                            )
                    case 1:
                                emptyList(),
            );
    /**  
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(new Index(index, "_na_"));  
        switch (randomInt(2)) {
                // Check non-diffable elements  
                builder.removeGlobalBlock(block);  
            case 0:  
         */  
        });  
    }
    }
            for (int j = 0; j < replicaCount; j++) {
                    StreamInput namedInput = new NamedWriteableAwareStreamInput(input, namedWriteableRegistry);
                    DiscoveryNode node2 = clusterStateFromDiffs.nodes().get(node);
            @Override
        T randomCreate(String name);
        if (randomBoolean()) {
                Diff<ClusterState> diffBeforeSerialization = clusterState.diff(previousClusterState);
                builder.order(randomInt(1000))  
            @Override
                        break;
        ClusterState clusterStateFromDiffs = ClusterState.Builder.fromBytes(  
                indexShard.addShard(
     */
            public Metadata.Builder put(Metadata.Builder builder, IndexMetadata part) {
    }
     * Randomly updates index routing table in the cluster state
        if (randomBoolean()) {  
                        }
    }
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), emptySet(), randomVersion(random()));
                    builder.add(
                        throw new IllegalArgumentException("Shouldn't be here");  
     * If a new part is added the prefix value is used as a prefix of randomly generated part name.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return Metadata.builder(metadata).transientSettings(randomSettings(metadata.transientSettings())).build();  
 *
            for (ShardRouting shardRouting : indexShardRoutingTable.shards()) {  
    private interface RandomClusterPart<T> {
                // Smoke test - we cannot compare bytes to bytes because some elements might get serialized in different order
     */
                return clusterState.customs();
 */  
                    case 2:  
 */  
                IndexTemplateMetadata.Builder builder = IndexTemplateMetadata.builder(name);
                // Update cluster states using diffs
                        break;
                        builder = randomClusterStateCustoms(clusterState);  
                    metadata = randomIndices(metadata);
 * under the License.  
                assertThat(clusterStateFromDiffs.version(), equalTo(clusterState.version()));
                default:  
 *  
 * software distributed under the License is distributed on an
        int shardCount = randomInt(10);
                builder.order(randomInt(1000));
            }  
                logger.error(  
                for (int i = 0; i < aliasCount; i++) {
            }
            Set<String> availableNodeIds = Sets.newHashSet(nodeIds);  
                }  
                        ).build();
            case 1:
                    metadata = randomMetadataCustoms(metadata);
                builder.numberOfShards(randomIntBetween(1, 10)).numberOfReplicas(randomInt(10));
        }
            .add(otherNode)
            public Metadata.Custom randomCreate(String name) {  
    private Metadata randomMetadataSettings(Metadata metadata) {
                        index,
     * Makes random settings changes
                assertThat(clusterStateFromDiffs.coordinationMetadata(), equalTo(clusterState.coordinationMetadata()));
                            Collections.singletonList(
     */  
                                    false
                    case 3:
                    case 5:
                        null,
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(original.getIndex());
            public Metadata.Builder remove(Metadata.Builder builder, String name) {
        }  
    public void testClusterStateDiffSerialization() throws Exception {
                clusterState.routingTable().indicesRouting().keySet().toArray(new String[0])
        /**
import org.opensearch.cluster.coordination.CoordinationMetadata;  
        if (partCount > 0) {
import org.opensearch.common.util.set.Sets;
            for (String part : randomParts) {  
         */
                    availableNodes.remove(shardRouting.relocatingNodeId());
            metaBuilder.addVotingConfigExclusion(new VotingConfigExclusion(randomNode("node-" + randomAlphaOfLength(10))));
                            Settings.builder().put(part.getSettings()).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                assertThat(clusterStateFromDiffs.metadata().templates(), equalTo(clusterState.metadata().templates()));
    private ClusterState.Builder randomNodes(ClusterState clusterState) {
         * Remove the part from metadata
                if (i > 0) {
        if (randomBoolean()) {  
                        builder = randomBlocks(clusterState);  
                new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false)))
                diffBeforeSerialization.writeTo(os);
            }
        int globalBlocksCount = clusterState.blocks().global().size();
    }
        }
            builder.put(randomAlphaOfLength(10), randomAlphaOfLength(10));
         * Remove the part from metadata
         */
                    availableNodes.remove(updatedShardRouting.relocatingNodeId());
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());  
     * Random cluster state part generator interface. Used by {@link #randomClusterStateParts(ClusterState, String, RandomClusterPart)}
            for (ShardRouting shardRouting : indexShardRoutingTable.shards()) {
                        builder = randomCoordinationMetadata(clusterState);  
                    previousClusterStateFromDiffs.nodes().getLocalNode(),  
                if (randomBoolean()) {
        int additionalPartCount = randomIntBetween(1, 20);
                    equalTo(ClusterState.Builder.toBytes(clusterState).length)  
         * Returns a random part with the specified name  
                        break;
import org.opensearch.cluster.metadata.IndexGraveyard;
        for (String nodeId : nodeIds) {
    /**
                    break;
                return builder.putCustom(part.getWriteableName(), part);
     * method to update cluster state with randomly generated parts
                                    SnapshotInfoTests.randomUserMetadata(),
                for (int i = 0; i < aliasCount; i++) {
import static java.util.Collections.emptySet;
                return builder.removeTemplate(name);  
import static org.opensearch.test.XContentTestUtils.convertToMap;
                    builder.remove(index);
        T randomCreate(String name);
                } else {  
            }  
        /**
    }
import static org.opensearch.cluster.routing.RandomShardRoutingMutator.randomReason;
            builder.put(settings);
            for (ClusterBlock block : blocks) {
     * Takes an existing cluster state and randomly adds, removes or updates a cluster state part using randomPart generator.  
                        } else {
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()  
                if (shardRouting.relocating()) {
     * Makes random metadata changes
            try {
            otherNode,
        Metadata.Builder remove(Metadata.Builder builder, String name);  
}  
            builder.filter(QueryBuilders.termQuery("test", randomRealisticUnicodeOfCodepointLength(10)).toString());
                }
         * Makes random modifications to the part
    }  
            builder.routing(randomAlphaOfLength(10));
    private DiscoveryNode randomNode(String nodeId) {  
                                new Snapshot(randomName("repo"), new SnapshotId(randomName("snap"), UUIDs.randomBase64UUID())),  
            public Metadata.Custom randomChange(Metadata.Custom part) {  
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(discoveryNodes).build();
                    break;
                availableNodeIds.remove(nodeId);
                    "Cluster state:\n{}\nCluster state from diffs:\n{}",
            @Override  
                nodes.remove(nodeId);  
                } else {  
                    metadata = randomMetadataSettings(metadata);
                    namedWriteableRegistry
    private IndexRoutingTable randomChangeToIndexRoutingTable(IndexRoutingTable original, String[] nodes) {
                IndexMetadata.Builder builder = IndexMetadata.builder(part);  
public class ClusterStateDiffIT extends OpenSearchIntegTestCase {
        }  
            );
     * Randomly updates persistent or transient settings of the given metadata  
                for (final String node : clusterStateFromDiffs.nodes().getNodes().keySet()) {
                    ClusterState.Builder.toBytes(clusterStateFromDiffs).length,
     */
                    equalTo(clusterStateFromDiffs.blocks().disableStatePersistence())
import org.opensearch.cluster.routing.ShardRoutingState;
                        j == 0,
                assertThat(clusterStateFromDiffs.nodes().getNodes(), equalTo(clusterState.nodes().getNodes()));
