        return ClusterState.builder(TEST_CLUSTER_NAME).build();
    // Create the routing table for a cluster state.
 * Unless required by applicable law or agreed to in writing,
    }
    }
    // Create the discovery nodes for a cluster state. For our testing purposes, we want
 * You may obtain a copy of the License at
        CustomMetadata1 customMetadata1 = new CustomMetadata1("data");
        }
            .build();
        final ClusterState newState = nextState(previousState, changeClusterUUID, addedIndices, delIndices, 0);
        final int localNodeIndex = isLocalClusterManager ? 0 : randomIntBetween(1, numNodes - 1); // randomly assign the local node if not
        assertTrue("Nodes should have been removed between cluster states", event.nodesRemoved());
        assertTrue(
    private static RoutingTable createRoutingTable(final long version, final Metadata metadata) {
        ClusterState newState = createState(numNodesInCluster, true, initialIndices);
            } else if (i == 2) {
        return builder.build();
        // test when it doesn't exist
        assertTrue(changedCustomMetadataTypeSet.size() == 1);
    // the first to be cluster-manager, the second to be cluster-manager eligible, the third to be a data node,
            final ClusterState previousState = createNonInitializedState(randomIntBetween(3, 5), randomBoolean());
            .nodes(builderLocalIsMaster.build())
        }
            "host",
        ClusterState newState = createState(numNodesInCluster, randomBoolean(), initialIndices);
        public EnumSet<Metadata.XContentContext> context() {
        return new DiscoveryNode(
            }
        return list;
            case DELETE_RANDOM: {
            executeIndicesChangesTest(previousState, quantity);
        // next state updates custom metadata
     * Test custom metadata change checks
        assertFalse("routing tables should be the same object", event.routingTableChanged());
            .build();
        for (Map.Entry<String, Metadata.Custom> customMetadata : previousState.metadata().customs().entrySet()) {
        return newState;
    /**
 */
        event = new ClusterChangedEvent("_na_", originalState, newState);
            }
        // test when nodes have not been added or removed between cluster states
        for (int i = 0; i < numIndices; i++) {
import org.opensearch.cluster.node.DiscoveryNode;
        final DiscoveryNode node1 = newNode("node_1", Set.of(DiscoveryNodeRole.DATA_ROLE));
            Collections.emptyMap(),
        assertTrue("index routing table should not be the same object", event.indexRoutingTableChanged(initialIndices.get(0).getName()));
    }
            delIndices = delIndices(numDel, stateIndices);
        new Index("idx1", UUIDs.randomBase64UUID()),
            } else if (i == 1) {
        newState = ClusterState.builder(TEST_CLUSTER_NAME)
        assertTrue("Nodes should have been removed between cluster states", event.nodesRemoved());
/*
        builder.metadata(metadataBuilder);
    }
        // next state adds two custom metadata type
            }
            builder.put(createIndexMetadata(index), true);
    }
            .creationDate(System.currentTimeMillis())
            }
        for (Iterator<IndexMetadata> iter = previousState.metadata().indices().values().iterator(); iter.hasNext();) {
        assertFalse("Nodes should not have been removed between cluster states", event.nodesRemoved());
                numDel = randomIntBetween(0, Math.max(stateIndices.size() - 1, 0));
    private static IndexMetadata createIndexMetadata(final Index index, final long version) {
    }
     */
        newState = createState(numNodesInCluster, false, initialIndices);
        }
        final IndexGraveyard oldGraveyard = event.previousState().metadata().indexGraveyard();
        }
            .routingTable(createRoutingTable(1, metadata))
                metaBuilder.clusterUUID(UUIDs.randomBase64UUID());
 * The OpenSearch Contributors require contributions made to
        assertFalse("local node should not be cluster-manager", event.localNodeClusterManager());
    private static IndexMetadata createIndexMetadata(final Index index) {
        Metadata.Builder metadataBuilder = new Metadata.Builder(previousState.metadata());
    }
        try {
            case DELETE_NONE: {
    private static DiscoveryNode newNode(final String nodeId, Set<DiscoveryNodeRole> roles) {
    private static final List<Index> initialIndices = Arrays.asList(
        nextState = nextState(originalState, Collections.singletonList(new CustomMetadata1("data")));
        Set<String> changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
        builder.stateUUID(UUIDs.randomBase64UUID());
        final List<Index> deletedIndices,
        event = new ClusterChangedEvent("_na_", originalState, nextState);
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
    // and the remainder can be any kinds of nodes (cluster-manager eligible, data, or both).
            Collections.shuffle(randomOrderQuantities, random());
import java.util.stream.Collectors;
import org.opensearch.test.TestCustomMetadata;
 */
 * not use this file except in compliance with the License.
            builder.add(node);
    /**
        assertTrue("Nodes should have been changed between cluster states", event.nodesChanged());
 *     http://www.apache.org/licenses/LICENSE-2.0
        nextState = nextState(originalState, Collections.singletonList(customMetadata1));
                throw new AssertionError("Unhandled mode [" + deletionQuantity + "]");
        new Index("idx3", UUIDs.randomBase64UUID())
                                                                                                  // cluster-manager
    private static final String INITIAL_CLUSTER_ID = UUIDs.randomBase64UUID();
        ClusterState previousState = createSimpleClusterState();
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", originalState, newState);
            delIndices = new ArrayList<>();
        final DiscoveryNodes.Builder builderLocalNotMaster = DiscoveryNodes.builder();
import org.opensearch.cluster.metadata.Metadata;
            "host_address",
        }
        newState = nextState(newState, randomBoolean(), Collections.emptyList(), Collections.emptyList(), 1);
        event = new ClusterChangedEvent("_na_", newState, previousState);
        ClusterState previousState = createSimpleClusterState();
                    roles.add(DiscoveryNodeRole.DATA_ROLE);
            .build();
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
 * Licensed to Elasticsearch under one or more contributor
        // next state has same custom metadata
                builder.clusterManagerNodeId(nodeId);
    // Create a non-initialized cluster state
        assertThat(((IndexGraveyard.IndexGraveyardDiff) newGraveyard.diff(oldGraveyard)).getAdded().size(), equalTo(delIndices.size()));
        nextState = nextState(stateWithCustomMetadata, Arrays.asList(customMetadata1, customMetadata2));
    // Validate the above test case testLocalNodeIsClusterManager() passes when the deprecated 'master' role is assigned to the local node.
        newIndexMeta = createIndexMetadata(new Index("doesntexist", UUIDs.randomBase64UUID()));
    public void testLocalNodeIsClusterManager() {
                builder.localNodeId(nodeId);
import java.util.HashSet;
 *
        final Metadata.Builder metaBuilder = Metadata.builder(previousState.metadata());
            nodeId,
        }
                roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
    }
    public void testIndicesMetadataChanges() {
/*
    );
        try {
            return Version.CURRENT;
        );
        final ClusterState withoutBlock = createState(numNodes, isLocalClusterManager, Collections.emptyList());
            final DiscoveryNode node = newNode(nodeId, roles);
        // next state removes two custom metadata type
    private static DiscoveryNodes createDiscoveryNodes(final int numNodes, final boolean isLocalClusterManager) {
        assertFalse("Nodes should not have been changed between cluster states", event.nodesChanged());
        assertTrue("routing tables should not be the same object", event.routingTableChanged());
import org.opensearch.gateway.GatewayService;
            final ClusterState newState = executeIndicesChangesTest(previousState, quantity);
            for (Index index : deletedIndices) {
        final int numAdd = randomIntBetween(0, 5); // add random # of indices to the next cluster state
            builder.metadata(metaBuilder);
import org.opensearch.core.index.Index;
        ClusterState nextState = ClusterState.builder(originalState).build();
            return "2";
     */
            event = new ClusterChangedEvent("_na_", null, previousState);
                // the cluster-manager node
import java.util.Arrays;
    private static List<Index> addIndices(final int numIndices, final String id) {
        );
        event = new ClusterChangedEvent("_na_", originalState, nextState);
 *
            }
    public void testBasicProperties() {
    }
            .nodes(builderLocalNotMaster.build())
            // there is some change in metadata cluster state
import org.opensearch.common.settings.Settings;
        return createIndexMetadata(index, 1);
     * based on what was set on the cluster state.
        return ClusterState.builder(TEST_CLUSTER_NAME)
            .blocks(ClusterBlocks.builder().addGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK).build())
            }
        newState = createState(numNodesInCluster + 1, randomBoolean(), initialIndices);
        assertTrue("Nodes should have been added between cluster states", event.nodesAdded());
            return randomOrderQuantities;
            nodeId,
            final int discoveryNodesSize = previousState.getNodes().getSize();
        assertTrue("local node should be master", event.localNodeClusterManager());
        ClusterState previousState = createSimpleClusterState();
                metaBuilder.indexGraveyard(graveyardBuilder.build());
        );
        assertTrue(
        }
        @Override
                roles.add(DiscoveryNodeRole.DATA_ROLE);
import org.opensearch.cluster.block.ClusterBlocks;
        final int numNodesToRemove
     * Test the routing table changes checks.
     */
        final List<Index> addedIndices = addIndices(numAdd, randomAlphaOfLengthBetween(5, 10));
 * under the License.
            .metadata(metadata)
        for (TestCustomMetadata testCustomMetadata : customMetadataList) {
        event = new ClusterChangedEvent("_na_", newState, originalState);
            if (changeClusterUUID) {
        return builder.build();
            "IndexMetadata that didn't previously exist should be considered changed",
                if (randomBoolean()) {
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));
    private static Metadata createMetadata(final List<Index> indices) {
        } catch (NullPointerException e) {}
            fail("should not have created a ClusterChangedEvent from a null previousState: " + event.previousState());
                }
            } else {
            .metadata(metadata)
     *   (1) make sure there are no null values for any of its properties
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata2.getWriteableName()));
            .build();
        final DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
 * ownership. Elasticsearch licenses this file to you under
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
        assertTrue(changedCustomMetadataTypeSet.isEmpty());
            if (i == localNodeIndex) {
            return "1";
        event = new ClusterChangedEvent("_na_", newState, originalState);
        @Override
        final ClusterState.Builder builder = ClusterState.builder(previousState);
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));
        DELETE_ALL; // delete all tombstones from cluster state
        @Override
    private static final ClusterName TEST_CLUSTER_NAME = new ClusterName("test");
        assertTrue(changedCustomMetadataTypeSet.size() == 2);
            .routingTable(createRoutingTable(1, metadata))
        final ClusterState originalState = createState(numNodesInCluster, randomBoolean(), initialIndices);
    // Create a new DiscoveryNode
        List<Index> delsFromEvent = event.indicesDeleted();
     * equality between cluster states.
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, previousState);
 *
        final int numNodesInCluster = 3;
        ClusterState newState = ClusterState.builder(originalState).build();
            super(data);
 * Tests for the {@link ClusterChangedEvent} class.
        }
        } catch (NullPointerException e) {}
        final List<Index> stateIndices = new ArrayList<>();
                graveyardBuilder.addTombstone(index);
    /**
        public String getWriteableName() {
        final DiscoveryNode node0 = newNode("node_0", Set.of(DiscoveryNodeRole.MASTER_ROLE));
        for (TombstoneDeletionQuantity quantity : TombstoneDeletionQuantity.valuesInRandomizedOrder()) {
import java.util.Collections;
        final ClusterState originalState = createState(numNodesInCluster, randomBoolean(), initialIndices);
    // the initial indices which every cluster state test starts out with
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
        }
        if (changeClusterUUID) {
        }
    /**
     */
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.cluster.metadata.IndexGraveyard;
        }
package org.opensearch.cluster;
     * are correct when there is a change in indices added and deleted.  Also tests metadata
/**
        final ClusterState state = createState(numNodesInCluster, randomBoolean(), initialIndices);
    }
        final IndexMetadata originalIndexMeta = state.metadata().index(index);
import java.util.Iterator;
            }
        // here we reuse the newState from the previous run which already added extra nodes
                break;
    private static ClusterState nextState(final ClusterState previousState, List<TestCustomMetadata> customMetadataList) {
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, originalState);
        final RoutingTable.Builder builder = RoutingTable.builder().version(version);
                }
            Set<DiscoveryNodeRole> roles = new HashSet<>();
        }
        // next state has new custom metadata
        public String getWriteableName() {
        return builder.build();
        assertTrue(changedCustomMetadataTypeSet.size() == 1);
                numDel = 0;
        assertFalse("IndexMetadata should be the same", ClusterChangedEvent.indexMetadataChanged(originalIndexMeta, originalIndexMeta));
        assertTrue(changedCustomMetadataTypeSet.isEmpty());
                // the alternate cluster-manager node
        final ClusterState.Builder builder = ClusterState.builder(previousState);
        newState = createState(numNodesInCluster, randomBoolean(), initialIndices.subList(1, initialIndices.size()));
    private static ClusterState createState(final int numNodes, final boolean isLocalClusterManager, final List<Index> indices) {
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, previousState);
        assertTrue("Nodes should have been changed between cluster states", event.nodesChanged());
        assertFalse("Nodes should not have been added between cluster states", event.nodesAdded());
            list.add(new Index("newIdx_" + id + "_" + i, UUIDs.randomBase64UUID()));
        final List<Index> list = new ArrayList<>();
            Version.CURRENT
    /**
    private static final String NODE_ID_PREFIX = "node_";
            }
        @Override
    public void testLocalNodeIsClusterManagerWithDeprecatedMasterRole() {
public class ClusterChangedEventTests extends OpenSearchTestCase {
    private static ClusterState executeIndicesChangesTest(
        final Index index = initialIndices.get(0);
    }
        final ClusterState previousState,
                metaBuilder.put(createIndexMetadata(index), true);
        assertTrue("Nodes should have been added between cluster states", event.nodesAdded());
        final int numNodesInCluster = 4;
        nextState = originalState;
    }
    }
            return EnumSet.of(Metadata.XContentContext.GATEWAY);
        } else {
        assertTrue(changedCustomMetadataTypeSet.size() == 1);
        public Version getMinimalSupportedVersion() {
            ClusterChangedEvent.indexMetadataChanged(originalIndexMeta, newIndexMeta)
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, previousState);
            .build();
            .nodes(createDiscoveryNodes(numNodes, isLocalClusterManager))
            for (int i = 0; i < numNodesToRemove && i < discoveryNodesSize; i++) {
        assertFalse("Nodes should not have been added between cluster states", event.nodesAdded());
    public void testIndexMetadataChange() {
                IndexGraveyard.Builder graveyardBuilder = IndexGraveyard.builder(metaBuilder.indexGraveyard());
    private static ClusterState createSimpleClusterState() {
        // test when nodes both added and removed between cluster states
     * Test that the indices deleted list is correct when the previous cluster state is
        return IndexMetadata.builder(index.getName())
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));
        final boolean changeClusterUUID,
        final int numDel;
    public void testChangedCustomMetadataSet() {
     * Test basic properties of the ClusterChangedEvent class:
    }
        builderLocalIsMaster.add(node0).add(node1).clusterManagerNodeId(node0.getId()).localNodeId(node0.getId());
 * the Apache License, Version 2.0 (the "License"); you may
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
        if (numNodesToRemove > 0) {
        builderLocalNotMaster.add(node0).add(node1).clusterManagerNodeId(node0.getId()).localNodeId(node1.getId());
        return ClusterState.builder(withoutBlock)
        assertTrue("index routing table should not be the same object", event.indexRoutingTableChanged(initialIndices.get(0).getName()));
import org.opensearch.cluster.node.DiscoveryNodeRole;
            case DELETE_ALL: {
    // Create the index metadata for a given index, with the specified version.
    }
            event = new ClusterChangedEvent(null, newState, previousState);
    // Create the metadata for a cluster state.
            super(data);
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
        } catch (NullPointerException e) {}
                nodesBuilder.remove(NODE_ID_PREFIX + i);
                metaBuilder.remove(index.getName());
        if (changeClusterUUID || addedIndices.size() > 0 || deletedIndices.size() > 0) {
        }
    }
    // execute the indices changes test by generating random index additions and deletions and
            list.add(currIndices.get(i));
        // make sure the metadata is actually on the cluster state
        nextState = nextState(originalState, Arrays.asList(customMetadata1, customMetadata2));
        // index routing tables are different because they don't exist
            ClusterChangedEvent.indexMetadataChanged(originalIndexMeta, newIndexMeta)
    public void testRoutingTableChanges() {
                numDel = stateIndices.size();
        assertNotNull("nodesDelta should not be null", event.nodesDelta());
        final int numNodesInCluster = 3;
            default:
    ) {
import org.opensearch.Version;
     */
        protected CustomMetadata2(String data) {
import java.util.List;
        CustomMetadata2 customMetadata2 = new CustomMetadata2("data2");
        builder.stateUUID(UUIDs.randomBase64UUID());
     * determine the deleted indices.
 * compatible open source license.
    private static class CustomMetadata2 extends TestCustomMetadata {
            .settings(settings)
            previousState = newState; // serves as the base cluster state for the next iteration
        DELETE_RANDOM, // delete a random number of tombstones from cluster state (not zero and not all)
            final String nodeId = NODE_ID_PREFIX + i;
 */
     * not initialized/recovered.  This should trigger the use of the index tombstones to
        final List<String> addsFromEvent = event.indicesCreated();
        public Version getMinimalSupportedVersion() {
        assertTrue(event.changedCustomMetadataSet().isEmpty());
    // Create a list of indices to delete from a list that already belongs to a particular cluster state.
        ClusterState newState = createSimpleClusterState();
        assertNotNull("IndexMetadata for " + index + " should exist on the cluster state", originalIndexMeta);
        // no custom metadata present in any state
        // next state removes custom metadata
        // should not be able to create a ClusterChangedEvent with null values for any of the constructor args
            return Version.CURRENT;
            nodeId,
        final int numNodesInCluster = 3;
            fail("should not have created a ClusterChangedEvent from a null state: " + event.state());
            for (Index index : addedIndices) {
        assertTrue("local node should be cluster-manager", event.localNodeClusterManager());
import java.util.Map;
    // Create a basic cluster state with a given set of indices
        assertFalse("local node should not be master", event.localNodeClusterManager());
        final TombstoneDeletionQuantity deletionQuantity
        final List<Index> list = new ArrayList<>();
    public void testNodesAddedAndRemovedAndChanged() {
        return list;
        assertTrue(changedCustomMetadataTypeSet.size() == 2);
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
        newState = createState(numNodesInCluster, randomBoolean(), initialIndices);
        ClusterState previousState = createState(numNodesInCluster, randomBoolean(), initialIndices);
            metadataBuilder.putCustom(testCustomMetadata.getWriteableName(), testCustomMetadata);
        nextState = originalState;
        final DiscoveryNodes.Builder builderLocalIsMaster = DiscoveryNodes.builder();
            .metadata(metadata)
        ClusterState newState = ClusterState.builder(TEST_CLUSTER_NAME)
        public EnumSet<Metadata.XContentContext> context() {
import org.opensearch.cluster.node.DiscoveryNodes;
        }
            }
    // Create a list of indices to add
            .numberOfShards(1)
        assertThat(new HashSet<>(delsFromEvent), equalTo(new HashSet<>(delIndices)));
        }
        final ClusterState previousState,
import org.opensearch.cluster.metadata.IndexMetadata;
 * this work for additional information regarding copyright
        }
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));
        @Override
        for (int i = 0; i < numIndices; i++) {
import org.opensearch.test.OpenSearchTestCase;
 * specific language governing permissions and limitations
    private static ClusterState nextState(
                // we need at least one data node
        assertTrue("routing tables should not be the same object", event.routingTableChanged());
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", originalState, nextState);
        new Index("idx2", UUIDs.randomBase64UUID()),
        final Metadata.Builder builder = Metadata.builder();
        }
        // test when its not the same IndexMetadata
        event = new ClusterChangedEvent("_na_", newState, previousState);
        return builder.build();
/*
        nextState = nextState(originalState, Collections.singletonList(customMetadata1));
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
        for (int i = 0; i < numNodes; i++) {
    }
            fail("should not have created a ClusterChangedEvent from a null source: " + event.source());
        }
        final boolean changeClusterUUID = randomBoolean();
        final ClusterState originalState = createState(numNodesInCluster, randomBoolean(), initialIndices);
 * Modifications Copyright OpenSearch Contributors. See
        event = new ClusterChangedEvent("_na_", originalState, newState);
        // next state has equivalent custom metadata
            event = new ClusterChangedEvent("_na_", newState, null);
        try {
                metadataBuilder.removeCustom(customMetadata.getKey());
        event = new ClusterChangedEvent("_na_", newState, originalState);
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));
        final ClusterState stateWithCustomMetadata = nextState(originalState, Collections.singletonList(customMetadata1));
import static org.hamcrest.Matchers.equalTo;
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata2.getWriteableName()));
import java.util.ArrayList;
            }
                    roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
        // test when its the same IndexMetadata
            if (i == 0) {
        }
     */
            if (customMetadata.getValue() instanceof TestCustomMetadata) {
    private static List<Index> delIndices(final int numIndices, final List<Index> currIndices) {
    }
        final IndexGraveyard newGraveyard = event.state().metadata().indexGraveyard();
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
    /**
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
        final int numNodesInCluster = 3;
        assertThat(event.source(), equalTo("_na_"));
}
        assertThat(event.metadataChanged(), equalTo(changeClusterUUID || addedIndices.size() > 0 || delIndices.size() > 0));
        final Metadata metadata = createMetadata(indices);
    private static class CustomMetadata1 extends TestCustomMetadata {
        for (final IndexMetadata cursor : metadata.indices().values()) {
                break;
            stateIndices.add(iter.next().getIndex());
     * Test nodes added/removed/changed checks.
    }
            final List<TombstoneDeletionQuantity> randomOrderQuantities = new ArrayList<>(EnumSet.allOf(TombstoneDeletionQuantity.class));
            .build();
        protected CustomMetadata1(String data) {
        newState = createState(numNodesInCluster - 1, randomBoolean(), initialIndices);
        DELETE_NONE, // delete none of the tombstones from cluster state
import java.util.Set;
        assertFalse("index routing table should be the same object", event.indexRoutingTableChanged(initialIndices.get(0).getName()));
        builder.blocks(ClusterBlocks.builder().build());
                if (randomBoolean()) {
        for (TombstoneDeletionQuantity quantity : TombstoneDeletionQuantity.valuesInRandomizedOrder()) {
    }
        assertThat(new HashSet<>(addsFromEvent), equalTo(addedIndices.stream().map(Index::getName).collect(Collectors.toSet())));
 */
    }
    }
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
            buildNewFakeTransportAddress(),
import org.opensearch.common.UUIDs;
        }
        for (Index index : indices) {
            return EnumSet.of(Metadata.XContentContext.GATEWAY);
        event = new ClusterChangedEvent("_na_", nextState(originalState, Arrays.asList(customMetadata1, customMetadata2)), nextState);
     * Test whether the ClusterChangedEvent returns the correct value for whether the local node is cluster-manager,
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, previousState);
            .routingTable(createRoutingTable(1, metadata))
    }
 * license agreements. See the NOTICE file distributed with
        // test when nodes have been added between cluster states
            .numberOfReplicas(0)
        assertThat(event.previousState(), equalTo(previousState));
        // test when nodes have been removed between cluster states
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata2.getWriteableName()));
        assert (numNodes >= 3) : "the initial cluster state for event change tests should have a minimum of 3 nodes "
        assertTrue("Nodes should have been changed between cluster states", event.nodesChanged());
                break;
        IndexMetadata newIndexMeta = createIndexMetadata(index, originalIndexMeta.getVersion() + 1);
     * Test that the indices created and indices deleted lists between two cluster states
    }
        assertTrue(changedCustomMetadataTypeSet.size() == 1);
        assertFalse("Nodes should not have been removed between cluster states", event.nodesRemoved());
    // Create a modified cluster state from another one, but with some number of indices added and deleted.
        }
            "IndexMetadata with different version numbers must be considered changed",
        // routing tables and index routing tables are same object
 * KIND, either express or implied.  See the License for the
        final int numNodesInCluster = 3;
        static List<TombstoneDeletionQuantity> valuesInRandomizedOrder() {
            final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(previousState.getNodes());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        List<Index> delIndices;
        switch (deletionQuantity) {
    ) {
            .version(version)
     *   (2) make sure you can't create a ClusterChangedEvent with any null values
    }
     * Test the index metadata change check.
 * SPDX-License-Identifier: Apache-2.0
        final List<Index> addedIndices,
        // routing tables and index routing tables aren't same object
        nextState = nextState(stateWithCustomMetadata, Collections.singletonList(new CustomMetadata1("data1")));
    public void testIndicesDeletionWithNotRecoveredState() {
        // test with all the various tombstone deletion quantities
                // remaining nodes can be anything (except for cluster-manager)
    // Create the index metadata for a given index.
    private static ClusterState createNonInitializedState(final int numNodes, final boolean isLocalClusterManager) {
            roles,
        assertThat(event.state(), equalTo(newState));
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
    /**
     */
            builder.nodes(nodesBuilder);
            + "so there are a minimum of 2 cluster-manager nodes for testing cluster-manager change events.";
        final Metadata metadata = createMetadata(initialIndices);
 * GitHub history for details.
        final Settings settings = Settings.builder()
    private enum TombstoneDeletionQuantity {
    // checking the values on the cluster changed event.
        }
            builder.addAsNew(cursor);
        // next state adds new custom metadata type
        @Override
        builder.clusterUUID(INITIAL_CLUSTER_ID);
    }
    /**
import java.util.EnumSet;
        return builder.build();
                roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
