            @Override
            nodes.add(randomNode("node-" + randomAlphaOfLength(10)));
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            String name = randomName(prefix);
    private Settings randomSettings(Settings settings) {
                builder.addShard(updatedShardRouting);
        for (int iteration = 0; iteration < iterationCount; iteration++) {
            public ClusterState.Builder remove(ClusterState.Builder builder, String name) {
            otherNode,
        int additionalPartCount = randomIntBetween(1, 20);
                        } else {
import org.opensearch.cluster.node.DiscoveryNodes;
                return GatewayService.STATE_NOT_RECOVERED_BLOCK;
                        );
                    return builder.indexGraveyard(IndexGraveyard.builder().build());
                    builder.remove(index);
     * Random cluster state part generator interface. Used by {@link #randomClusterStateParts(ClusterState, String, RandomClusterPart)}
    }
    /**
                if (i > 0) {
            List<String> randomParts = randomSubsetOf(
         */
            randomPart.put(builder, randomPart.randomCreate(name));
        }
            ClusterState.Builder.toBytes(clusterState),
        CoordinationMetadata.Builder metaBuilder = CoordinationMetadata.builder(clusterState.coordinationMetadata());
                switch (randomInt(5)) {
package org.opensearch.cluster;
        T randomCreate(String name);
            switch (randomInt(3)) {
import static java.util.Collections.emptyMap;
                    );
            @Override
                }
                );
                            builder.putAlias(AliasMetadata.builder(randomAlphaOfLength(10)));
            public Metadata.Builder remove(Metadata.Builder builder, String name) {
import org.opensearch.cluster.block.ClusterBlocks;
     * Randomly updates nodes in the cluster state
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(original.getIndex());
         * Returns list of parts from metadata
    private interface RandomPart<T> {
            namedWriteableRegistry
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(new Index(index, "_na_"));
    }
                }
        /**
            for (int j = 0; j < replicaCount; j++) {
 * Licensed to Elasticsearch under one or more contributor
        int settingsCount = randomInt(10);
                assertThat(
        int changesCount = randomIntBetween(1, 10);
                    unassignedInfo = new UnassignedInfo(randomReason(), randomAlphaOfLength(10));
                    .patterns(Collections.singletonList(randomName("temp")))
                new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false)))
                final ShardRouting updatedShardRouting = randomChange(shardRouting, availableNodes);
                byte[] diffBytes = BytesReference.toBytes(os.bytes());
        T randomChange(T part);
    }
    }
                case 2:
                return builder.build();
                builder.removeGlobalBlock(block);
import org.opensearch.cluster.routing.UnassignedInfo;
    }
                    default:
                // Check non-diffable elements
                        if (randomBoolean() && part.getAliases().isEmpty() == false) {
         * Remove the part from metadata
                if (randomBoolean()) {
            @Override
            for (String part : randomParts) {
                nodes.remove(nodeId);
            @Override
    private DiscoveryNode randomNode(String nodeId) {
        return builder.build();
        metaBuilder.term(randomNonNegativeLong());
     * method to update cluster state with randomly generated parts
                        break;
    private Metadata randomTemplates(Metadata metadata) {
                            )
    private <T> Metadata randomParts(Metadata metadata, String prefix, RandomPart<T> randomPart) {
        final Map<String, T> parts = randomPart.parts(metadata);
        ClusterState clusterStateFromDiffs = ClusterState.Builder.fromBytes(
         */
                );
            .build();
            public ClusterState.Builder put(ClusterState.Builder builder, ClusterState.Custom part) {
                assertThat(clusterStateFromDiffs.nodes().getNodes(), equalTo(clusterState.nodes().getNodes()));
            int changesCount = randomIntBetween(1, 4);
 * this work for additional information regarding copyright
            }
                assertThat(clusterStateFromDiffs.routingTable().version(), equalTo(clusterState.routingTable().version()));
         */
                assertThat(clusterStateFromDiffs.metadata().customs(), equalTo(clusterState.metadata().customs()));
                builder.settings(settingsBuilder);
            @Override
            @Override
    /**
                assertThat(clusterStateFromDiffs.version(), equalTo(clusterState.version()));
                        break;
                IndexMetadata.Builder builder = IndexMetadata.builder(name);
import java.util.List;
                randomPart.parts(clusterState).keySet().toArray(new String[0])
    private String randomName(String prefix) {
import static java.util.Collections.emptySet;
            @Override
                            builder.removeAlias(randomFrom(part.getAliases().keySet().toArray(new String[0])));
import org.opensearch.snapshots.SnapshotId;
                return clusterState.customs();
            @Override
                String nodeId = randomFrom(availableNodeIds);
import static org.hamcrest.Matchers.is;
            @Override
    public void testClusterStateDiffSerialization() throws Exception {
    }
                throw error;
     */
                    case 0:
                case 3:
            builder.put(settings);
                if (randomInt(5) == 1) {
    /**
                return builder.putCustom(part.getWriteableName(), part);
import org.opensearch.cluster.metadata.RepositoriesMetadata;
                        j == 0,
                                    Math.abs(randomLong()),
        ClusterState.Builder builder = ClusterState.builder(clusterState);
                if (IndexGraveyard.TYPE.equals(name)) {
import org.opensearch.cluster.routing.TestShardRouting;
            randomPart.put(builder, randomPart.randomCreate(name));
         * Puts the part back into metadata
            .add(clusterManagerNode)
import org.opensearch.cluster.routing.RoutingTable;
        }
 * Modifications Copyright OpenSearch Contributors. See
                new CoordinationMetadata.VotingConfiguration(Sets.newHashSet(generateRandomStringArray(10, 10, false)))
                builder.order(randomInt(1000));
        /**
        Metadata metadata = clusterState.metadata();
    private Metadata randomMetadataCustoms(final Metadata metadata) {
                        break;
        int iterationCount = randomIntBetween(10, 300);
        int additionalIndexCount = randomIntBetween(1, 20);
        });
                        break;
            }
                        builder.settings(
    /**
     * Makes random settings changes
                    case 0:
 * You may obtain a copy of the License at
                        )
import static org.opensearch.test.XContentTestUtils.convertToMap;
        int partCount = parts.size();
            for (ClusterBlock block : blocks) {
import org.opensearch.cluster.metadata.Metadata;
 */
     */
                        break;
    /**
                assertThat(clusterStateFromDiffs.routingTable().indicesRouting(), equalTo(clusterState.routingTable().indicesRouting()));
                switch (randomIntBetween(0, 2)) {
/*
        return ClusterState.builder(randomClusterStateParts(clusterState, "custom", new RandomClusterPart<ClusterState.Custom>() {
        DiscoveryNode otherNode = randomNode("other");
    private AliasMetadata randomAlias() {
                return builder.remove(name);
        Metadata.Builder builder = Metadata.builder(metadata);
    }
            }
import org.opensearch.cluster.routing.ShardRoutingState;
                BytesStreamOutput os = new BytesStreamOutput();
    private <T> ClusterState randomClusterStateParts(ClusterState clusterState, String prefix, RandomClusterPart<T> randomPart) {
        }
            .localNodeId(clusterManagerNode.getId())
            }
                Diff<ClusterState> diff;
     */
            );
                    metadata = randomMetadataSettings(metadata);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                    "Cluster state:\n{}\nCluster state from diffs:\n{}",
    }
import org.opensearch.cluster.metadata.IndexGraveyardTests;
                IndexTemplateMetadata.Builder builder = IndexTemplateMetadata.builder(name);
                                UUIDs.randomBase64UUID(),
                        nodeId,
/*
            }
                                    null,
                int aliasCount = randomIntBetween(0, 10);
        }
    }
import org.opensearch.core.index.shard.ShardId;
                            clusterState.routingTable().indicesRouting().get(index),
import static java.util.Collections.emptyList;
import org.opensearch.common.io.stream.BytesStreamOutput;
                return builder.putCustom(part.getWriteableName(), part);
    /**
                    randomPart.remove(builder, part);
                                Map.of()
        Map<String, T> parts(Metadata metadata);
                    case 1:
        }
        Metadata.Builder remove(Metadata.Builder builder, String name);
                UnassignedInfo unassignedInfo = null;
        AliasMetadata.Builder builder = newAliasMetadataBuilder(randomName("alias"));
        T randomChange(T part);
                // Check cluster blocks
        int globalBlocksCount = clusterState.blocks().global().size();
        switch (randomInt(2)) {
     * If a new part is added the prefix value is used as a prefix of randomly generated part name.
    /**
                    default:
        return ClusterState.builder(clusterState).metadata(Metadata.builder(metadata).version(metadata.version() + 1).build());
                return builder.removeTemplate(name);
        return builder.build();
                    nodes.add(randomNode(nodeId));
        return prefix + UUIDs.randomBase64UUID(random());
                    equalTo(ClusterState.Builder.toBytes(clusterState).length)
    }
                assertThat(
            public Metadata.Builder remove(Metadata.Builder builder, String name) {
        });
        /**
            }
                randomInt(partCount - 1),
    /**
            for (ShardRouting shardRouting : indexShardRoutingTable.shards()) {
        for (int i = 0; i < shardCount; i++) {
import org.opensearch.core.index.Index;
    /**
    /**
            public IndexMetadata randomChange(IndexMetadata part) {
        if (partCount > 0) {
                }
    }
     * Takes an existing cluster state and randomly adds, removes or updates a cluster state part using randomPart generator.
        return ClusterState.builder(clusterState).routingTable(builder.build());
                if (randomBoolean()) {
import org.opensearch.snapshots.SnapshotsInProgressSerializationTests;
            Set<String> availableNodes = Sets.newHashSet(nodes);
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
                                    randomBoolean(),
                case 0:
                return metadata.indices();
                // Update cluster state via full serialization from time to time
    }
            metaBuilder.lastCommittedConfiguration(
    }
        }
            builder.routing(randomAlphaOfLength(10));
        /**
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
                return builder.removeCustom(name);
    }
                default:
            public ClusterState.Custom randomChange(ClusterState.Custom part) {
            public ClusterState.Custom randomCreate(String name) {
                    return new RepositoriesMetadata(Collections.emptyList());
     * Generates a random name that starts with the given prefix
                                emptyList(),
                for (int i = 0; i < aliasCount; i++) {
import org.opensearch.test.OpenSearchIntegTestCase;
                for (int i = 0; i < aliasCount; i++) {
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesReference;
                    builder.add(
import org.opensearch.cluster.metadata.IndexGraveyard;
        ClusterBlocks.Builder builder = ClusterBlocks.builder().blocks(clusterState.blocks());
        Settings.Builder builder = Settings.builder();
                assertNull(differenceBetweenMapsIgnoringArrayOrder(convertToMap(clusterStateFromDiffs), convertToMap(clusterState)));
            List<String> randomIndices = randomSubsetOf(
                Diff<ClusterState> diffBeforeSerialization = clusterState.diff(previousClusterState);
                return metadata.templates();
 * not use this file except in compliance with the License.
                        break;
    /**
                    TestShardRouting.newShardRouting(
                assertThat(clusterStateFromDiffs.metadata().equalsAliases(clusterState.metadata()), is(true));
        }
                return NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES;
            }
            public Map<String, IndexTemplateMetadata> parts(Metadata metadata) {
            @Override
        for (String nodeId : nodeIds) {
                } else {
                    clusterState = builder.build();
                // Update cluster states using diffs
     * Returns a random global block
    }
                    throw new IllegalArgumentException("Shouldn't be here");
        final Map<String, T> parts = randomPart.parts(clusterState);
 * KIND, either express or implied.  See the License for the
                randomInt(numberOfIndices - 1),
            default:
            @Override
                        builder = randomNodes(clusterState);
            }
                for (final String node : clusterStateFromDiffs.nodes().getNodes().keySet()) {
                    availableNodes.remove(shardRouting.relocatingNodeId());
                // Check nodes
            }
            ClusterState previousClusterState = clusterState;
        if (randomBoolean()) {
        DiscoveryNode clusterManagerNode = randomNode("cluster-manager");
    /**
                    builder.putAlias(randomAlias());
            );
                assertThat(clusterStateFromDiffs.metadata().templates(), equalTo(clusterState.metadata().templates()));
                    previousClusterStateFromDiffs.nodes().getLocalNode(),
                    StreamInput namedInput = new NamedWriteableAwareStreamInput(input, namedWriteableRegistry);
        List<String> nodeIds = randomSubsetOf(
import static org.opensearch.cluster.routing.RandomShardRoutingMutator.randomReason;
                    randomPart.put(builder, randomPart.randomChange(parts.get(part)));
            builder.add(randomIndexRoutingTable("index-" + randomInt(), clusterState.nodes().getNodes().keySet().toArray(new String[0])));
 *
                    )
            IndexShardRoutingTable.Builder indexShard = new IndexShardRoutingTable.Builder(new ShardId(index, "_na_", i));
                        builder = randomClusterStateCustoms(clusterState);
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        }));
            }
                assertThat(clusterStateFromDiffs.blocks().indices(), equalTo(clusterStateFromDiffs.blocks().indices()));
                assertThat(clusterStateFromDiffs.coordinationMetadata(), equalTo(clusterState.coordinationMetadata()));
                    break;
            );
            }
                    default:
            ClusterState previousClusterStateFromDiffs = clusterStateFromDiffs;
            }
            }
                    // there must always be at least an empty graveyard
    private IndexRoutingTable randomChangeToIndexRoutingTable(IndexRoutingTable original, String[] nodes) {
    }
                        break;
                assertThat(clusterStateFromDiffs.metadata().transientSettings(), equalTo(clusterState.metadata().transientSettings()));
         */
                                RestoreInProgress.State.fromValue((byte) randomIntBetween(0, 3)),
                    clusterState.toString(),
            if (nodeId.startsWith("node-")) {
                                    Collections.emptyList(),
        int additionalGlobalBlocksCount = randomIntBetween(1, 3);
                IndexMetadata.Builder builder = IndexMetadata.builder(part);
                assertThat(clusterStateFromDiffs.metadata().indices(), equalTo(clusterState.metadata().indices()));
     */
     */
                    namedWriteableRegistry
        return ClusterState.builder(clusterState).blocks(builder);
                                new Snapshot(randomName("repo"), new SnapshotId(randomName("snap"), UUIDs.randomBase64UUID())),
        int additionalPartCount = randomIntBetween(1, 20);
    private ClusterState.Builder randomMetadataChanges(ClusterState clusterState) {
            public Map<String, Metadata.Custom> parts(Metadata metadata) {
        /**
                        break;
                return builder.put(part);
            } else {
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), emptySet(), randomVersion(random()));
    private Metadata randomIndices(Metadata metadata) {
        }
                if (availableNodeIds.isEmpty()) {
                    DiscoveryNode node1 = clusterState.nodes().get(node);
                        }
                    case 5:
        }
                    case 1:
                                    randomIntBetween(0, 1000),
                    case 1:
                        builder = randomCoordinationMetadata(clusterState);
import org.opensearch.common.settings.Settings;
                            clusterState.nodes().getNodes().keySet().toArray(new String[0])
                try (StreamInput input = StreamInput.wrap(diffBytes)) {
        for (int i = 0; i < additionalNodeCount; i++) {
                }
        /**
                    ClusterState.Builder.toBytes(clusterState),
                return builder.put(part, true);
                }
                if (shardRouting.relocating()) {
            randomInt(clusterState.nodes().getNodes().size() - 1),
                    diff = ClusterState.readDiffFrom(namedInput, previousClusterStateFromDiffs.nodes().getLocalNode());
                } else {
    private interface RandomClusterPart<T> {
                                    SnapshotInfoTests.randomUserMetadata(),
        }
     */
    private ClusterState.Builder randomBlocks(ClusterState clusterState) {
                return part;
    }
                diffBeforeSerialization.writeTo(os);
/*
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            }
                        ShardRoutingState.fromValue((byte) randomIntBetween(2, 3)),
                return builder.build();
                    clusterStateFromDiffs.blocks().disableStatePersistence(),
            @Override
                                new SnapshotsInProgress.Entry(
     */
        for (int i = 0; i < additionalPartCount; i++) {
        int shardCount = randomInt(10);
                if (randomBoolean()) {
            case 0:
        }
            }
     * Generates random alias
                                    randomBoolean(),
                indexShard.addShard(
     */
     * Randomly updates index routing table in the cluster state
                        builder = randomRoutingTable(clusterState);
    /**
            return Metadata.builder(metadata).transientSettings(randomSettings(metadata.transientSettings())).build();
import org.opensearch.cluster.routing.ShardRouting;
                    assertThat(node1.getAttributes(), equalTo(node2.getAttributes()));
                                    new Snapshot(randomName("repo"), new SnapshotId(randomName("snap"), UUIDs.randomBase64UUID())),
        return ClusterState.builder(clusterState).nodes(nodes);
            }
            }
        return builder.build();
                    assertThat(node1.getVersion(), equalTo(node2.getVersion()));
            case 1:
            builder.put(randomAlphaOfLength(10), randomAlphaOfLength(10));
            }
                                )
        if (randomBoolean()) {
                availableNodeIds.remove(nodeId);
                    availableNodes.remove(updatedShardRouting.relocatingNodeId());
                        builder.settings(Settings.builder().put(part.getSettings()).put(randomSettings(Settings.EMPTY)));
                        throw new IllegalArgumentException("Shouldn't be here");
            }
                        builder = randomMetadataChanges(clusterState);
     * Randomly updates index routing table in the cluster state
    /**
        return randomParts(metadata, "index", new RandomPart<IndexMetadata>() {
import org.opensearch.core.common.io.stream.StreamInput;
                clusterStateFromDiffs = ClusterState.Builder.fromBytes(
import org.opensearch.index.query.QueryBuilders;
     */
                                    false
import static org.opensearch.cluster.metadata.AliasMetadata.newAliasMetadataBuilder;
    private IndexRoutingTable randomIndexRoutingTable(String index, String[] nodeIds) {
     */
                } else {
                setRandomIndexSettings(random(), settingsBuilder);
         */
                assertThat(clusterStateFromDiffs.metadata().version(), equalTo(clusterState.metadata().version()));
            Set<String> availableNodeIds = Sets.newHashSet(nodeIds);
            for (String index : randomIndices) {
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
                }
    /**
                            Settings.builder().put(part.getSettings()).put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
                // however, serialized size should remain the same
            public IndexTemplateMetadata randomCreate(String name) {
import org.opensearch.gateway.GatewayService;
                    break;
            public Map<String, ClusterState.Custom> parts(ClusterState clusterState) {
                    return builder.removeCustom(name);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE, numDataNodes = 0, numClientNodes = 0)
                                    Map.of(),
    private ClusterState.Builder randomNodes(ClusterState clusterState) {
        if (globalBlocksCount > 0) {
import org.opensearch.cluster.node.DiscoveryNode;
        return builder.build();
            }
            }
            for (int i = 0; i < changesCount; i++) {
     */
     */
        }
public class ClusterStateDiffIT extends OpenSearchIntegTestCase {
        if (randomBoolean()) {
        }
                        index,
            );
            }
 */
                    case 3:
        Map<String, T> parts(ClusterState clusterState);
import org.opensearch.common.UUIDs;
 * compatible open source license.
    private ClusterState.Builder randomCoordinationMetadata(ClusterState clusterState) {
         * Makes random modifications to the part
    /**
        ClusterState.Builder builder = ClusterState.builder(clusterState);
import static org.opensearch.test.XContentTestUtils.differenceBetweenMapsIgnoringArrayOrder;
     * Takes an existing cluster state and randomly adds, removes or updates a metadata part using randomPart generator.
import org.opensearch.cluster.metadata.IndexMetadata;
    }
 * specific language governing permissions and limitations
        return builder.build();
            public IndexTemplateMetadata randomChange(IndexTemplateMetadata part) {
                availableNodes.remove(updatedShardRouting.currentNodeId());
                    clusterStateFromDiffs = diff.apply(previousClusterStateFromDiffs);
                } else {
                return metadata.customs();
         */
     * Randomly adds, deletes or updates repositories in the metadata
                    return IndexGraveyardTests.createRandom();
import org.opensearch.cluster.routing.IndexRoutingTable;
import java.util.Set;
         * Remove the part from metadata
         * Makes random modifications to the part
        return builder;
     * If a new part is added the prefix value is used as a prefix of randomly generated part name.
                case 1:
 * ownership. Elasticsearch licenses this file to you under
        }
            clusterState = builder.incrementVersion().build();
            @Override
            @Override
        }
         * Returns a random part with the specified name
    private ClusterState.Builder randomClusterStateCustoms(final ClusterState clusterState) {
                assertThat(clusterStateFromDiffs.nodes().getLocalNodeId(), equalTo(previousClusterStateFromDiffs.nodes().getLocalNodeId()));
                        builder = randomBlocks(clusterState);
        return builder.build();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                availableNodes.remove(shardRouting.currentNodeId());
 * SPDX-License-Identifier: Apache-2.0
                    break;
            @Override
        int numberOfIndices = clusterState.routingTable().indicesRouting().size();
        int partCount = parts.size();
    private ClusterBlock randomGlobalBlock() {
                    break;
        int additionalNodeCount = randomIntBetween(1, 20);
                                    Collections.emptyList(),
                // Check metadata
                );
     * Randomly creates or removes cluster blocks
        return randomParts(metadata, "custom", new RandomPart<Metadata.Custom>() {
                return builder.build();
            String name = randomName(prefix);
        }
        }
        }
     */
            }
        } else {
                    case 0:
     * Randomly adds, deletes or updates index templates in the metadata
                clusterState.routingTable().indicesRouting().keySet().toArray(new String[0])
                if (randomBoolean()) {
            }
            }
            @Override
     * Randomly add, deletes or updates indices in the metadata
                );
        }
            ClusterState.Builder builder = null;
            builder.filter(QueryBuilders.termQuery("test", randomRealisticUnicodeOfCodepointLength(10)).toString());
        }
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
            } catch (AssertionError error) {
                        randomChangeToIndexRoutingTable(
        for (int i = 0; i < changesCount; i++) {
                        throw new IllegalArgumentException("Shouldn't be here");
     */
            public Metadata.Builder put(Metadata.Builder builder, Metadata.Custom part) {
                    builder.putAlias(randomAlias());
        if (randomBoolean()) {
        for (var indexShardRoutingTable : original.shards().values()) {
     */
        Metadata.Builder put(Metadata.Builder builder, T part);
 * under the License.
     * Randomly updates persistent or transient settings of the given metadata
                    assertThat(node1.getAddress(), equalTo(node2.getAddress()));
                            Collections.singletonList(
            List<String> randomParts = randomSubsetOf(randomInt(partCount - 1), randomPart.parts(metadata).keySet().toArray(new String[0]));
         * Returns a random part with the specified name
                                    randomVersion(random()),
            }
                builder.numberOfShards(randomIntBetween(1, 10)).numberOfReplicas(randomInt(10));
                }
         */
            @Override
                        break;
                        i,
                    case 2:
                    case 2:
                }
                    DiscoveryNode node2 = clusterStateFromDiffs.nodes().get(node);
            }
}
        ClusterState.Builder remove(ClusterState.Builder builder, String name);
                if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
                logger.error(
            );
                        unassignedInfo
                return NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL;
    }
 * The OpenSearch Contributors require contributions made to
        RoutingTable.Builder builder = RoutingTable.builder(clusterState.routingTable());
                    metadata = randomMetadataCustoms(metadata);
        for (int i = 0; i < additionalIndexCount; i++) {
 * Unless required by applicable law or agreed to in writing,
                }
                switch (randomIntBetween(0, 1)) {
         * Puts the part back into metadata
                        null,
                        );
 */
            public Map<String, IndexMetadata> parts(Metadata metadata) {
                    case 4:
     * Randomly updates routing table in the cluster state
                if (shardRouting.relocating()) {
    /**
            @Override
            @Override
                        throw new IllegalArgumentException("Shouldn't be here");
    private ClusterState.Builder randomRoutingTable(ClusterState clusterState) {
            builder.addGlobalBlock(randomGlobalBlock());
     */
                }
        if (numberOfIndices > 0) {
                Settings.Builder settingsBuilder = Settings.builder();
                builder.order(randomInt(1000))
                // Smoke test - we cannot compare bytes to bytes because some elements might get serialized in different order
import org.opensearch.snapshots.Snapshot;
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(discoveryNodes).build();
                IndexTemplateMetadata.Builder builder = new IndexTemplateMetadata.Builder(part);
        if (randomBoolean()) {
                    randomPart.put(builder, randomPart.randomChange(parts.get(part)));
                }
            for (ShardRouting shardRouting : indexShardRoutingTable.shards()) {
            public Metadata.Builder put(Metadata.Builder builder, IndexMetadata part) {
import org.opensearch.cluster.coordination.CoordinationMetadata;
                assertThat(clusterStateFromDiffs.metadata().clusterUUID(), equalTo(clusterState.metadata().clusterUUID()));
     * Randomly adds, deletes or updates in-progress snapshot and restore records in the cluster state
            if (randomIntBetween(0, 10) < 1) {
 * software distributed under the License is distributed on an
import org.opensearch.common.util.set.Sets;
        );
            builder.addIndexShard(indexShard.build());
                }
        }
            metaBuilder.lastAcceptedConfiguration(
            int replicaCount = randomIntBetween(1, 10);
                    metadata = randomIndices(metadata);
        for (int i = 0; i < settingsCount; i++) {
        );
            metaBuilder.addVotingConfigExclusion(new VotingConfigExclusion(randomNode("node-" + randomAlphaOfLength(10))));
            }
                        return SnapshotsInProgress.of(
                randomInt(globalBlocksCount - 1),
                            )
                return part;
                }
        ClusterState.Builder put(ClusterState.Builder builder, T part);
                            new RestoreInProgress.Entry(
         */
                        return new RestoreInProgress.Builder().add(
        for (int i = 0; i < additionalGlobalBlocksCount; i++) {
         */
                }
            return Metadata.builder(metadata).persistentSettings(randomSettings(metadata.persistentSettings())).build();
                }
     */
    }
            try {
                }
            public Metadata.Builder put(Metadata.Builder builder, IndexTemplateMetadata part) {
import org.opensearch.snapshots.SnapshotInfoTests;
        return randomParts(metadata, "template", new RandomPart<IndexTemplateMetadata>() {
 *
        });
                // Check routing table
            public Metadata.Builder remove(Metadata.Builder builder, String name) {
        if (partCount > 0) {
                    randomPart.remove(builder, part);
         * Returns list of parts from metadata
        logger.info("Final cluster state:[{}]", clusterState.toString());
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
                assertThat(clusterStateFromDiffs.metadata().persistentSettings(), equalTo(clusterState.metadata().persistentSettings()));
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Map;
    /**
                    clusterStateFromDiffs.toString()
     * Random metadata part generator
            }
                        ).build();
                } else {
        }
        /**
                );
import java.util.Collections;
            public IndexMetadata randomCreate(String name) {
            public Metadata.Custom randomCreate(String name) {
    private Metadata randomMetadataSettings(Metadata metadata) {
        }
            }
     * Makes random metadata changes
import org.opensearch.cluster.metadata.AliasMetadata;
                assertThat(clusterStateFromDiffs.blocks().global(), equalTo(clusterStateFromDiffs.blocks().global()));
        /**
        for (int i = 0; i < additionalPartCount; i++) {
import static org.hamcrest.Matchers.equalTo;
            for (String part : randomParts) {
                // JSON Serialization test - make sure that both states produce similar JSON
    /**
                int aliasCount = randomInt(10);
            @Override
         */
import org.opensearch.cluster.block.ClusterBlock;
 * license agreements. See the NOTICE file distributed with
            .add(otherNode)
import static org.opensearch.test.VersionUtils.randomVersion;
        /**
                return builder.build();
    }
        T randomCreate(String name);
                    equalTo(clusterStateFromDiffs.blocks().disableStatePersistence())
import static org.opensearch.cluster.routing.RandomShardRoutingMutator.randomChange;
                    break;
            List<ClusterBlock> blocks = randomSubsetOf(
     */
            }
            clusterState.nodes().getNodes().keySet().toArray(new String[0])
                clusterState.blocks().global().toArray(new ClusterBlock[globalBlocksCount])
 *
                    metadata = randomTemplates(metadata);
                assertThat(clusterStateFromDiffs.nodes().getNodes(), equalTo(clusterState.nodes().getNodes()));
        if (randomBoolean()) {
            public Metadata.Custom randomChange(Metadata.Custom part) {
                settingsBuilder.put(randomSettings(Settings.EMPTY)).put(IndexMetadata.SETTING_VERSION_CREATED, randomVersion(random()));
        /**
                                    SnapshotsInProgressSerializationTests.randomState(Map.of()),
                    ClusterState.Builder.toBytes(clusterStateFromDiffs).length,
                }
                }
                    .settings(randomSettings(Settings.EMPTY));
