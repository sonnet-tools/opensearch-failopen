            "host_address",  
        return ClusterState.builder(TEST_CLUSTER_NAME)  
    // Create a modified cluster state from another one, but with some number of indices added and deleted.
            case DELETE_NONE: {
        CustomMetadata1 customMetadata1 = new CustomMetadata1("data");  
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();  
    private static RoutingTable createRoutingTable(final long version, final Metadata metadata) {  
        ClusterState previousState = createSimpleClusterState();
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));  
        }
                break;
public class ClusterChangedEventTests extends OpenSearchTestCase {  
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, previousState);
                // the cluster-manager node
        final ClusterState stateWithCustomMetadata = nextState(originalState, Collections.singletonList(customMetadata1));
        final List<Index> deletedIndices,  
import java.util.Collections;
        assertNotNull("IndexMetadata for " + index + " should exist on the cluster state", originalIndexMeta);
            list.add(currIndices.get(i));  
            .build();
import java.util.ArrayList;
        assertTrue("routing tables should not be the same object", event.routingTableChanged());
        assertTrue("Nodes should have been removed between cluster states", event.nodesRemoved());
            .build();
            builder.addAsNew(cursor);  
            if (changeClusterUUID) {
                metaBuilder.put(createIndexMetadata(index), true);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertTrue("Nodes should have been changed between cluster states", event.nodesChanged());  
            default:  
import org.opensearch.cluster.node.DiscoveryNodeRole;
            .blocks(ClusterBlocks.builder().addGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK).build())
        }
                    roles.add(DiscoveryNodeRole.DATA_ROLE);
            return "2";  
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, originalState);
        newState = createState(numNodesInCluster, randomBoolean(), initialIndices);
        assertFalse("local node should not be cluster-manager", event.localNodeClusterManager());  
        }
            final int discoveryNodesSize = previousState.getNodes().getSize();
    private static class CustomMetadata2 extends TestCustomMetadata {
 */  
        final ClusterState withoutBlock = createState(numNodes, isLocalClusterManager, Collections.emptyList());  
            fail("should not have created a ClusterChangedEvent from a null previousState: " + event.previousState());
        @Override
    // Validate the above test case testLocalNodeIsClusterManager() passes when the deprecated 'master' role is assigned to the local node.  
    }  
        }
    // Create a new DiscoveryNode
import java.util.HashSet;  
            }  
        // next state adds new custom metadata type
        for (final IndexMetadata cursor : metadata.indices().values()) {
                }  
        public EnumSet<Metadata.XContentContext> context() {  
            .build();
        nextState = originalState;
            return randomOrderQuantities;
            stateIndices.add(iter.next().getIndex());
        // here we reuse the newState from the previous run which already added extra nodes
            Set<DiscoveryNodeRole> roles = new HashSet<>();  
        } catch (NullPointerException e) {}
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);  
                break;
    public void testChangedCustomMetadataSet() {
            previousState = newState; // serves as the base cluster state for the next iteration
                metaBuilder.remove(index.getName());  
        final IndexMetadata originalIndexMeta = state.metadata().index(index);  
 * under the License.  
                }  
            for (Index index : deletedIndices) {
        }
            fail("should not have created a ClusterChangedEvent from a null state: " + event.state());  
        public Version getMinimalSupportedVersion() {
        final List<Index> list = new ArrayList<>();
        final int numNodesInCluster = 3;  
        event = new ClusterChangedEvent("_na_", originalState, nextState);  
    }  
        return ClusterState.builder(withoutBlock)
        return createIndexMetadata(index, 1);
 * not use this file except in compliance with the License.
 */
        }  
            }
                                                                                                  // cluster-manager  
            .metadata(metadata)
    public void testRoutingTableChanges() {  
        }  
    }  
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
        assertTrue(changedCustomMetadataTypeSet.isEmpty());
        List<Index> delsFromEvent = event.indicesDeleted();
        try {  
            buildNewFakeTransportAddress(),
            + "so there are a minimum of 2 cluster-manager nodes for testing cluster-manager change events.";  
    private static ClusterState nextState(final ClusterState previousState, List<TestCustomMetadata> customMetadataList) {  
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
        protected CustomMetadata1(String data) {  
        final List<Index> list = new ArrayList<>();
            builder.metadata(metaBuilder);
            .metadata(metadata)
        event = new ClusterChangedEvent("_na_", newState, originalState);  
    }
        for (TestCustomMetadata testCustomMetadata : customMetadataList) {  
        return IndexMetadata.builder(index.getName())
        }
import org.opensearch.cluster.metadata.Metadata;
        // test when nodes have been added between cluster states
            .numberOfShards(1)
        new Index("idx3", UUIDs.randomBase64UUID())  
        }  
            fail("should not have created a ClusterChangedEvent from a null source: " + event.source());
        @Override
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));  
 * this work for additional information regarding copyright
    // the initial indices which every cluster state test starts out with
    // Create a basic cluster state with a given set of indices  
        newState = ClusterState.builder(TEST_CLUSTER_NAME)
/*  
        List<Index> delIndices;
            // there is some change in metadata cluster state
        return builder.build();
            list.add(new Index("newIdx_" + id + "_" + i, UUIDs.randomBase64UUID()));  
 * specific language governing permissions and limitations
            .build();
     * Test custom metadata change checks  
        Set<String> changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
            } else if (i == 1) {
        final List<String> addsFromEvent = event.indicesCreated();
        final TombstoneDeletionQuantity deletionQuantity  
        // test when nodes both added and removed between cluster states  
 * KIND, either express or implied.  See the License for the
        ClusterState newState = createState(numNodesInCluster, randomBoolean(), initialIndices);
        ClusterState nextState = ClusterState.builder(originalState).build();
        builder.stateUUID(UUIDs.randomBase64UUID());
        final List<Index> stateIndices = new ArrayList<>();  
        event = new ClusterChangedEvent("_na_", originalState, nextState);
        public String getWriteableName() {
        // test when nodes have not been added or removed between cluster states  
 * this file be licensed under the Apache-2.0 license or a
    public void testLocalNodeIsClusterManagerWithDeprecatedMasterRole() {
    /**
/*  
    /**  
    private static Metadata createMetadata(final List<Index> indices) {  
            executeIndicesChangesTest(previousState, quantity);
import org.opensearch.gateway.GatewayService;
            builder.nodes(nodesBuilder);
 * license agreements. See the NOTICE file distributed with
        assertThat(event.previousState(), equalTo(previousState));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));
        }
        builder.metadata(metadataBuilder);  
        final int numNodesToRemove
        assertTrue(event.changedCustomMetadataSet().isEmpty());  
        for (int i = 0; i < numNodes; i++) {
        assertFalse("Nodes should not have been added between cluster states", event.nodesAdded());  
    }
            final String nodeId = NODE_ID_PREFIX + i;
                numDel = randomIntBetween(0, Math.max(stateIndices.size() - 1, 0));  
     * Test that the indices created and indices deleted lists between two cluster states
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", originalState, nextState);
        final DiscoveryNodes.Builder builderLocalIsMaster = DiscoveryNodes.builder();
    }  
    private static final String NODE_ID_PREFIX = "node_";  
        );
            }
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
 */  
        // next state adds two custom metadata type
            if (i == 0) {
        final int numAdd = randomIntBetween(0, 5); // add random # of indices to the next cluster state
            }
        // routing tables and index routing tables are same object
import org.opensearch.test.TestCustomMetadata;  
        builder.stateUUID(UUIDs.randomBase64UUID());
        final ClusterState state = createState(numNodesInCluster, randomBoolean(), initialIndices);
        event = new ClusterChangedEvent("_na_", newState, originalState);  
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata2.getWriteableName()));
        assertTrue("Nodes should have been changed between cluster states", event.nodesChanged());  
    public void testNodesAddedAndRemovedAndChanged() {
        return builder.build();
        assertFalse("routing tables should be the same object", event.routingTableChanged());
        // test when nodes have been removed between cluster states
            roles,  
        assertTrue("Nodes should have been added between cluster states", event.nodesAdded());  
    private enum TombstoneDeletionQuantity {  
        builderLocalNotMaster.add(node0).add(node1).clusterManagerNodeId(node0.getId()).localNodeId(node1.getId());
                graveyardBuilder.addTombstone(index);
        assertTrue(changedCustomMetadataTypeSet.isEmpty());
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", originalState, newState);  
        ClusterState newState = ClusterState.builder(TEST_CLUSTER_NAME)  
        final int localNodeIndex = isLocalClusterManager ? 0 : randomIntBetween(1, numNodes - 1); // randomly assign the local node if not
            metadataBuilder.putCustom(testCustomMetadata.getWriteableName(), testCustomMetadata);
                // we need at least one data node  
        // no custom metadata present in any state  
        for (Index index : indices) {  
            }
        ClusterState newState = createSimpleClusterState();  
import java.util.stream.Collectors;
            .build();  
        public Version getMinimalSupportedVersion() {
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();  
    // Create a non-initialized cluster state
            return Version.CURRENT;
/*
    // and the remainder can be any kinds of nodes (cluster-manager eligible, data, or both).  
    private static List<Index> delIndices(final int numIndices, final List<Index> currIndices) {  
        assertTrue("local node should be cluster-manager", event.localNodeClusterManager());
     * equality between cluster states.  
            final ClusterState newState = executeIndicesChangesTest(previousState, quantity);  
 *
     *   (2) make sure you can't create a ClusterChangedEvent with any null values  
    }
        static List<TombstoneDeletionQuantity> valuesInRandomizedOrder() {
        } catch (NullPointerException e) {}
        nextState = nextState(originalState, Collections.singletonList(customMetadata1));  
        for (Iterator<IndexMetadata> iter = previousState.metadata().indices().values().iterator(); iter.hasNext();) {
            .routingTable(createRoutingTable(1, metadata))  
        if (numNodesToRemove > 0) {
     * Test the routing table changes checks.
            }
    }
    private static ClusterState nextState(
    private static class CustomMetadata1 extends TestCustomMetadata {
        nextState = nextState(originalState, Arrays.asList(customMetadata1, customMetadata2));
     *   (1) make sure there are no null values for any of its properties
    }
            .version(version)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.test.OpenSearchTestCase;
        assertThat(new HashSet<>(addsFromEvent), equalTo(addedIndices.stream().map(Index::getName).collect(Collectors.toSet())));  
        // make sure the metadata is actually on the cluster state
        assertFalse("Nodes should not have been added between cluster states", event.nodesAdded());
import java.util.Iterator;
        return builder.build();
            "IndexMetadata with different version numbers must be considered changed",
    }  
            .settings(settings)  
        }  
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, previousState);
 * The OpenSearch Contributors require contributions made to  
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();  
 */
        final ClusterState previousState,
     */
    private static ClusterState executeIndicesChangesTest(
        assertThat(event.metadataChanged(), equalTo(changeClusterUUID || addedIndices.size() > 0 || delIndices.size() > 0));
 * Tests for the {@link ClusterChangedEvent} class.
        builderLocalIsMaster.add(node0).add(node1).clusterManagerNodeId(node0.getId()).localNodeId(node0.getId());
    );
            nodeId,  
        final DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        newState = createState(numNodesInCluster - 1, randomBoolean(), initialIndices);
                IndexGraveyard.Builder graveyardBuilder = IndexGraveyard.builder(metaBuilder.indexGraveyard());
        final int numDel;
    /**
        assertTrue("Nodes should have been removed between cluster states", event.nodesRemoved());
        DELETE_NONE, // delete none of the tombstones from cluster state
        newState = createState(numNodesInCluster + 1, randomBoolean(), initialIndices);  
 *  
    }
            .metadata(metadata)
    public void testIndicesMetadataChanges() {
    // the first to be cluster-manager, the second to be cluster-manager eligible, the third to be a data node,
        @Override
     */
        event = new ClusterChangedEvent("_na_", nextState(originalState, Arrays.asList(customMetadata1, customMetadata2)), nextState);
        @Override  
        for (TombstoneDeletionQuantity quantity : TombstoneDeletionQuantity.valuesInRandomizedOrder()) {  
            return "1";  
import org.opensearch.core.index.Index;  
            super(data);
        }  
        final RoutingTable.Builder builder = RoutingTable.builder().version(version);
        @Override  
        assertTrue("index routing table should not be the same object", event.indexRoutingTableChanged(initialIndices.get(0).getName()));
                // the alternate cluster-manager node  
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata2.getWriteableName()));  
        newState = createState(numNodesInCluster, false, initialIndices);
        assertTrue("routing tables should not be the same object", event.routingTableChanged());
        final int numNodesInCluster = 3;
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();  
    }
    private static final List<Index> initialIndices = Arrays.asList(  
 *     http://www.apache.org/licenses/LICENSE-2.0
        // index routing tables are different because they don't exist
                numDel = stateIndices.size();
        nextState = nextState(originalState, Collections.singletonList(customMetadata1));
        // next state has same custom metadata  
        event = new ClusterChangedEvent("_na_", originalState, newState);  
 * Unless required by applicable law or agreed to in writing,
            .nodes(builderLocalIsMaster.build())
        nextState = nextState(originalState, Collections.singletonList(new CustomMetadata1("data")));
            if (customMetadata.getValue() instanceof TestCustomMetadata) {
        }
        // next state has equivalent custom metadata  
                roles.add(DiscoveryNodeRole.DATA_ROLE);
        try {
        assertThat(event.source(), equalTo("_na_"));  
        final Index index = initialIndices.get(0);
        event = new ClusterChangedEvent("_na_", newState, previousState);
        }
            ClusterChangedEvent.indexMetadataChanged(originalIndexMeta, newIndexMeta)
    /**
    }  
        final ClusterState originalState = createState(numNodesInCluster, randomBoolean(), initialIndices);
        final boolean changeClusterUUID = randomBoolean();  
        final Metadata metadata = createMetadata(indices);
    }  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
        ClusterState newState = createState(numNodesInCluster, true, initialIndices);  
        final int numNodesInCluster = 3;  
        final boolean changeClusterUUID,
import org.opensearch.common.UUIDs;
        }
    private static DiscoveryNodes createDiscoveryNodes(final int numNodes, final boolean isLocalClusterManager) {
    }
        newState = nextState(newState, randomBoolean(), Collections.emptyList(), Collections.emptyList(), 1);
            for (Index index : addedIndices) {
        assertTrue("local node should be master", event.localNodeClusterManager());  
     * Test nodes added/removed/changed checks.  
        newState = createState(numNodesInCluster, randomBoolean(), initialIndices.subList(1, initialIndices.size()));
     * Test the index metadata change check.
 * Modifications Copyright OpenSearch Contributors. See
        new Index("idx1", UUIDs.randomBase64UUID()),
            builder.add(node);  
            event = new ClusterChangedEvent(null, newState, previousState);
            return EnumSet.of(Metadata.XContentContext.GATEWAY);
        final ClusterState originalState = createState(numNodesInCluster, randomBoolean(), initialIndices);
        final ClusterState newState = nextState(previousState, changeClusterUUID, addedIndices, delIndices, 0);
        }  
        ClusterState previousState = createSimpleClusterState();
        return new DiscoveryNode(
            .numberOfReplicas(0)
 *
    }
        assertFalse("IndexMetadata should be the same", ClusterChangedEvent.indexMetadataChanged(originalIndexMeta, originalIndexMeta));
        final ClusterState.Builder builder = ClusterState.builder(previousState);  
     * Test that the indices deleted list is correct when the previous cluster state is  
    private static ClusterState createSimpleClusterState() {
 * Licensed to Elasticsearch under one or more contributor  
        final IndexGraveyard oldGraveyard = event.previousState().metadata().indexGraveyard();
                throw new AssertionError("Unhandled mode [" + deletionQuantity + "]");
            event = new ClusterChangedEvent("_na_", null, previousState);
    // Create a list of indices to delete from a list that already belongs to a particular cluster state.
        IndexMetadata newIndexMeta = createIndexMetadata(index, originalIndexMeta.getVersion() + 1);  
import org.opensearch.Version;
        assertThat(new HashSet<>(delsFromEvent), equalTo(new HashSet<>(delIndices)));
            "host",
    public void testIndicesDeletionWithNotRecoveredState() {
     * Test whether the ClusterChangedEvent returns the correct value for whether the local node is cluster-manager,  
    }
        assertTrue(
    /**
        final Settings settings = Settings.builder()
        return list;
package org.opensearch.cluster;
        assertTrue(changedCustomMetadataTypeSet.size() == 1);
        final Metadata metadata = createMetadata(initialIndices);
        final Metadata.Builder builder = Metadata.builder();
        final Metadata.Builder metaBuilder = Metadata.builder(previousState.metadata());
        final ClusterState.Builder builder = ClusterState.builder(previousState);
        }
            return Version.CURRENT;
    private static List<Index> addIndices(final int numIndices, final String id) {  
    // checking the values on the cluster changed event.  
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));
        assertFalse("Nodes should not have been changed between cluster states", event.nodesChanged());
        final ClusterState previousState,  
}  
        }
        );
        return builder.build();
        public String getWriteableName() {
            .build();  
        try {
            builder.put(createIndexMetadata(index), true);
        assertTrue(changedCustomMetadataTypeSet.size() == 1);
        DELETE_RANDOM, // delete a random number of tombstones from cluster state (not zero and not all)
        final int numNodesInCluster = 3;
        // next state updates custom metadata
            delIndices = delIndices(numDel, stateIndices);  
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, previousState);
        assertTrue(
        assertFalse("Nodes should not have been removed between cluster states", event.nodesRemoved());
     */
        ClusterState previousState = createSimpleClusterState();
        // routing tables and index routing tables aren't same object
import java.util.Arrays;  
            if (i == localNodeIndex) {
            Collections.shuffle(randomOrderQuantities, random());
    // Create the metadata for a cluster state.
        assertFalse("local node should not be master", event.localNodeClusterManager());
        assertTrue(changedCustomMetadataTypeSet.size() == 2);
        assertTrue("Nodes should have been added between cluster states", event.nodesAdded());
        public EnumSet<Metadata.XContentContext> context() {  
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata1.getWriteableName()));
            Collections.emptyMap(),
        ClusterChangedEvent event = new ClusterChangedEvent("_na_", newState, previousState);  
     */
        assert (numNodes >= 3) : "the initial cluster state for event change tests should have a minimum of 3 nodes "
    }  
                metaBuilder.clusterUUID(UUIDs.randomBase64UUID());  
            nodeId,
        return ClusterState.builder(TEST_CLUSTER_NAME).build();  
     * based on what was set on the cluster state.
        assertFalse("index routing table should be the same object", event.indexRoutingTableChanged(initialIndices.get(0).getName()));
        }
            .nodes(createDiscoveryNodes(numNodes, isLocalClusterManager))
        assertNotNull("nodesDelta should not be null", event.nodesDelta());  
     */
        switch (deletionQuantity) {
    // Create the index metadata for a given index.  
        for (int i = 0; i < numIndices; i++) {
import org.opensearch.common.settings.Settings;
    // execute the indices changes test by generating random index additions and deletions and
        final IndexGraveyard newGraveyard = event.state().metadata().indexGraveyard();  
        builder.blocks(ClusterBlocks.builder().build());  
        DELETE_ALL; // delete all tombstones from cluster state  
        event = new ClusterChangedEvent("_na_", newState, originalState);
    private static ClusterState createNonInitializedState(final int numNodes, final boolean isLocalClusterManager) {
            case DELETE_RANDOM: {
                    roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
    }  
        nextState = nextState(stateWithCustomMetadata, Arrays.asList(customMetadata1, customMetadata2));
    ) {
    }  
        protected CustomMetadata2(String data) {  
        final DiscoveryNode node0 = newNode("node_0", Set.of(DiscoveryNodeRole.MASTER_ROLE));  
import java.util.Map;  
        // should not be able to create a ClusterChangedEvent with null values for any of the constructor args
            ClusterChangedEvent.indexMetadataChanged(originalIndexMeta, newIndexMeta)  
            .nodes(builderLocalNotMaster.build())  
        assertFalse("Nodes should not have been removed between cluster states", event.nodesRemoved());
        assertThat(event.state(), equalTo(newState));
        // test when it doesn't exist  
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
            delIndices = new ArrayList<>();
                metaBuilder.indexGraveyard(graveyardBuilder.build());  
        } catch (NullPointerException e) {}  
        new Index("idx2", UUIDs.randomBase64UUID()),
import java.util.Set;
     * Test basic properties of the ClusterChangedEvent class:
        // next state removes custom metadata  
    // Create a list of indices to add
            final List<TombstoneDeletionQuantity> randomOrderQuantities = new ArrayList<>(EnumSet.allOf(TombstoneDeletionQuantity.class));  
 * GitHub history for details.
    public void testLocalNodeIsClusterManager() {  
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();  
    }
    }  
        final ClusterState originalState = createState(numNodesInCluster, randomBoolean(), initialIndices);
        assertTrue(changedCustomMetadataTypeSet.size() == 1);
    // Create the index metadata for a given index, with the specified version.
        assertThat(((IndexGraveyard.IndexGraveyardDiff) newGraveyard.diff(oldGraveyard)).getAdded().size(), equalTo(delIndices.size()));
                // remaining nodes can be anything (except for cluster-manager)  
 * software distributed under the License is distributed on an
    /**  
        event = new ClusterChangedEvent("_na_", stateWithCustomMetadata, nextState);
    private static IndexMetadata createIndexMetadata(final Index index, final long version) {  
            .routingTable(createRoutingTable(1, metadata))
import java.util.EnumSet;
        nextState = originalState;
 * compatible open source license.
                if (randomBoolean()) {
import org.opensearch.cluster.node.DiscoveryNode;  
                nodesBuilder.remove(NODE_ID_PREFIX + i);
        assertTrue("Nodes should have been changed between cluster states", event.nodesChanged());
    }  
    }
        newIndexMeta = createIndexMetadata(new Index("doesntexist", UUIDs.randomBase64UUID()));
        ClusterState newState = ClusterState.builder(originalState).build();
    }  
            Version.CURRENT
    /**  
    public void testBasicProperties() {
     * not initialized/recovered.  This should trigger the use of the index tombstones to
        if (changeClusterUUID) {  
        return list;
        // next state has new custom metadata
        return builder.build();  
        for (int i = 0; i < numIndices; i++) {
    public void testIndexMetadataChange() {  
        ClusterState previousState = createState(numNodesInCluster, randomBoolean(), initialIndices);
            super(data);
        nextState = nextState(stateWithCustomMetadata, Collections.singletonList(new CustomMetadata1("data1")));
        CustomMetadata2 customMetadata2 = new CustomMetadata2("data2");  
        for (Map.Entry<String, Metadata.Custom> customMetadata : previousState.metadata().customs().entrySet()) {
        }
        final List<Index> addedIndices,
            "IndexMetadata that didn't previously exist should be considered changed",  
        }
                builder.clusterManagerNodeId(nodeId);  
        assertTrue(changedCustomMetadataTypeSet.size() == 2);
 * ownership. Elasticsearch licenses this file to you under  
     */
            final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(previousState.getNodes());  
            }  
 * SPDX-License-Identifier: Apache-2.0
    // Create the routing table for a cluster state.
        // test when its not the same IndexMetadata
            nodeId,
import org.opensearch.cluster.node.DiscoveryNodes;
 * You may obtain a copy of the License at  
import org.opensearch.cluster.block.ClusterBlocks;
     * determine the deleted indices.
        @Override
        final DiscoveryNode node1 = newNode("node_1", Set.of(DiscoveryNodeRole.DATA_ROLE));
            }
                builder.localNodeId(nodeId);
        changedCustomMetadataTypeSet = event.changedCustomMetadataSet();
        event = new ClusterChangedEvent("_na_", originalState, newState);  
            }
            event = new ClusterChangedEvent("_na_", newState, null);  
            .creationDate(System.currentTimeMillis())  
            for (int i = 0; i < numNodesToRemove && i < discoveryNodesSize; i++) {
        );
        builder.clusterUUID(INITIAL_CLUSTER_ID);
        assertTrue(changedCustomMetadataTypeSet.contains(customMetadata2.getWriteableName()));
            } else {
                numDel = 0;
            .routingTable(createRoutingTable(1, metadata))  
import org.opensearch.cluster.routing.RoutingTable;  
        // next state removes two custom metadata type  
        }
    }  
import org.opensearch.cluster.metadata.IndexGraveyard;  
     * are correct when there is a change in indices added and deleted.  Also tests metadata
    private static ClusterState createState(final int numNodes, final boolean isLocalClusterManager, final List<Index> indices) {
            }  
                if (randomBoolean()) {
        final DiscoveryNodes.Builder builderLocalNotMaster = DiscoveryNodes.builder();
        assertTrue("index routing table should not be the same object", event.indexRoutingTableChanged(initialIndices.get(0).getName()));
     */  
        for (TombstoneDeletionQuantity quantity : TombstoneDeletionQuantity.valuesInRandomizedOrder()) {
    /**  
    // Create the discovery nodes for a cluster state. For our testing purposes, we want
        final int numNodesInCluster = 4;  
    private static final String INITIAL_CLUSTER_ID = UUIDs.randomBase64UUID();
        if (changeClusterUUID || addedIndices.size() > 0 || deletedIndices.size() > 0) {  
        }
            final ClusterState previousState = createNonInitializedState(randomIntBetween(3, 5), randomBoolean());
     */
/**  
        } else {
                metadataBuilder.removeCustom(customMetadata.getKey());  
    private static IndexMetadata createIndexMetadata(final Index index) {
import static org.hamcrest.Matchers.equalTo;
        event = new ClusterChangedEvent("_na_", newState, previousState);
    private static final ClusterName TEST_CLUSTER_NAME = new ClusterName("test");
            case DELETE_ALL: {  
        return newState;  
            } else if (i == 2) {
                roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
    ) {
            return EnumSet.of(Metadata.XContentContext.GATEWAY);
        Metadata.Builder metadataBuilder = new Metadata.Builder(previousState.metadata());  
        assertTrue(changedCustomMetadataTypeSet.size() == 1);  
        final List<Index> addedIndices = addIndices(numAdd, randomAlphaOfLengthBetween(5, 10));
        final int numNodesInCluster = 3;
        // test when its the same IndexMetadata
    private static DiscoveryNode newNode(final String nodeId, Set<DiscoveryNodeRole> roles) {  
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())  
            final DiscoveryNode node = newNode(nodeId, roles);
                break;  
        // test with all the various tombstone deletion quantities
                roles.add(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE);
