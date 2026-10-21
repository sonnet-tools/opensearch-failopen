        assertEquals(
        );
            )
        logger.info("Initialize cluster");
                .get()
            ensureYellowAndNoInitializingShards(TEST_INDEX);
        ShardRouting shardRouting = getShardRouting(!isReplicaAllocation);
            ensureGreen(TEST_INDEX);
                .isAcknowledged()
        );
            "[remote_store migration_direction]: %s shard copy can not be allocated to a non-remote node because a remote store backed index's shard copy can only be allocated to a remote node",
        ensureGreen(TEST_INDEX);
        logger.info("Verify successful allocation of shard");
            (isRemoteCluster ? "remote" : "non-remote")
    // When under strict mode, a shard can be allocated to any node
    public void testNewPrimaryShardAllocationForRemoteStoreMigration() throws Exception {
        createIndex(
        logger.info("Verify non-allocation of shard");
        } else {
    // When the primary is on doc rep node, existing replica copy can get allocated on excluded docrep node.
            .setWaitForNoRelocatingShards(true)
        setDirection(REMOTE_STORE.direction);
            Locale.ROOT,
        List<String> nodes = internalCluster().startNodes(2);
            .add(new MoveAllocationCommand("test", 0, primaryNodeName("test"), remoteNode))
        logger.info("Verify relocation of replica shard to non-remote node");
            internalCluster().client()
        attemptAllocation(null);
                .prepareUpdateSettings("test")
        assertTrue(clusterHealthResponse.isTimedOut());
        internalCluster().validateClusterFormed();
        String expectedReason = String.format(
    }
    public void testAlwaysAllocateNewShardForStrictMode() throws Exception {
            prepareIndexWithAllocatedPrimary(previousNode1, Optional.empty());
    }
        ensureGreen(TEST_INDEX);
            .setWaitForEvents(Priority.LANGUID)
    // When the primary is on remote node, new replica copy shouldn't get allocated on an excluded docrep node.
        String nodeName1 = internalCluster().startDataOnlyNode();
            Settings.builder()
        } else {
        String nonRemoteNodeName2 = internalCluster().startDataOnlyNode();
        boolean isReplicaAllocation = randomBoolean();
        logger.info("Attempt allocation of shard on new node");
            .execute()
        decision = getDecisionForTargetNode(nonRemoteNode2, false, true, false);
        logger.info(
            "[remote_store migration_direction]: replica shard copy can be relocated to a remote node since primary shard copy has been migrated to remote",
import java.util.List;
        Decision decision = getDecisionForTargetNode(nonRemoteNode, true, true, false);
        logger.info("Initialize cluster");
        excludeAllNodes();
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
        assertEquals(Decision.Type.YES, decision.type());
        assertEquals(Decision.Type.NO, decision.type());
            prepareIndexWithoutReplica(Optional.empty());
        assertEquals(Decision.Type.YES, decision.type());
        expectedReason = String.format(
    }
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        attemptAllocation(null);
            "test",
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        String previousNodeName1 = internalCluster().startDataOnlyNode();
    public void testNewReplicaShardAllocationIfPrimaryShardOnRemoteNodeForRemoteStoreMigration() throws Exception {
 */
        logger.info("Allocate primary shard on non-remote node");
            (isRemoteStoreBackedIndex ? "remote" : "non-remote"),
            assertNonRemoteStoreBackedIndex(TEST_INDEX);
                .prepareReroute()
        logger.info("Attempt free allocation of replica shard");
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        createIndex(TEST_INDEX, 1);
            decision.getExplanation().toLowerCase(Locale.ROOT)
            prepareIndexWithAllocatedPrimary(node1, Optional.empty());
import org.opensearch.common.unit.TimeValue;
    public void testRemoteStoreBackedIndexShardAllocationForRemoteStoreMigration() throws Exception {
        logger.info("Initialize cluster and add nodes");
                .admin()
        );
                .admin()
            .cluster()
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0")
        internalCluster().validateClusterFormed();
        DiscoveryNode previousNode1 = assertNodeInCluster(previousNodeName1);
        excludeAllNodes();
            .setTimeout(TimeValue.timeValueSeconds(60))
        logger.info("Initialize cluster");
        attemptAllocation(null);
    public void testFilterAllocationSkipsReplicaOnExcludedNode() throws IOException {
            (isReplicaAllocation ? "replica" : "primary"),
        internalCluster().validateClusterFormed();
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        );
        assertTrue(
        internalCluster().validateClusterFormed();
        internalCluster().startClusterManagerOnlyNode();
                .add(new MoveAllocationCommand(TEST_INDEX, 0, initialReplicaNode.getName(), initialPrimaryNode.getName()))
        DiscoveryNode nonRemoteNode2 = assertNodeInCluster(nonRemoteNodeName2);
        assertAllocation(false, remoteNode2);
        logger.info("Set mixed mode");
                .build()
        DiscoveryNode nonRemoteNode = assertNodeInCluster(nonRemoteNodeName);
            .prepareHealth()
import org.opensearch.common.Priority;
    public void testFilterAllocationSkipsReplica() throws IOException {
        logger.info("Verify non-allocation of shard");
        assertEquals(Decision.Type.NO, decision.type());
        assertEquals(expectedReason, decision.getExplanation().toLowerCase(Locale.ROOT));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
        attemptAllocation(null);
                .prepareUpdateSettings("test")
        );
        Decision decision = getDecisionForTargetNode(newNode, !isReplicaAllocation, false, false);
        DiscoveryNode nonRemoteNode1 = assertNodeInCluster(nonRemoteNodeName1);
 * compatible open source license.
                .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", String.join(",", docRepNodes)))
                .build()
            (isReplicaAllocation ? "replica" : "primary"),
        String nonRemoteNodeName1 = internalCluster().startDataOnlyNode();
import static org.opensearch.node.remotestore.RemoteStoreNodeService.Direction.REMOTE_STORE;
        internalCluster().validateClusterFormed();
        assertTrue(
        internalCluster().validateClusterFormed();
        assertEquals(Decision.Type.YES, decision.type());
        }
        );
        assertAcked(
        String remoteNodeName = internalCluster().startDataOnlyNode();
        logger.info("Verify non-allocation of primary shard on non-remote node");
        decision = getDecisionForTargetNode(remoteNode2, false, true, true);
        );
        List<String> docRepNodes = internalCluster().startNodes(3);
                .admin()
        assertNonAllocation(false);
import java.io.IOException;
        internalCluster().validateClusterFormed();
        internalCluster().validateClusterFormed();
        assertEquals(
        assertAllocation(true, remoteNode);
        createIndex(
        setAddRemote(true);
        ensureGreen(TEST_INDEX);
            .prepareHealth()
        DiscoveryNode previousNode2 = assertNodeInCluster(previousNodeName2);
        DiscoveryNode remoteNode2 = assertNodeInCluster(remoteNodeName2);
        );
            !isReplicaAllocation,
        assertEquals(expectedReason, decision.getExplanation().toLowerCase(Locale.ROOT));
                .add(new MoveAllocationCommand(TEST_INDEX, 0, initialPrimaryNode.getName(), remoteNodeName1))
        DiscoveryNode newNode = assertNodeInCluster(newNodeName);
import org.opensearch.cluster.node.DiscoveryNode;
            "[remote_store migration_direction]: primary shard copy can not be allocated to a non-remote node",
        ClusterHealthResponse clusterHealthResponse = client().admin()
    // When under mixed mode and none direction, allocate shard of a remote store backed index to a remote node and shard of a non remote
            true,
            String.format(
        );
        }
                .admin()
                .isAcknowledged()
        logger.info("Switch to MIXED cluster compatibility mode");
            "[remote_store migration_direction]: replica shard copy can be allocated to a non-remote node",
        logger.info("Add remote and non-remote nodes");
        DiscoveryNode nonRemoteNode = assertNodeInCluster(nonRemoteNodeName);
            logger.info("Create index with primary allocated on remote node");
import java.util.Locale;
    public void testNewReplicaShardAllocationIfPrimaryShardOnNonRemoteNodeForRemoteStoreMigration() throws Exception {
import java.util.Optional;
 * The OpenSearch Contributors require contributions made to
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                .cluster()
        setAddRemote(isRemoteCluster);
        logger.info("Verify allocation of primary shard on remote node");
        setAddRemote(true);
            assertRemoteStoreBackedIndex(TEST_INDEX);
        } else {
        setAddRemote(true);
        setClusterMode(MIXED.mode);
        } else {
        assertAllocation(false, nonRemoteNode2);
        internalCluster().startClusterManagerOnlyNode();
        setAddRemote(!addRemote);
        logger.info("Add non-remote data nodes");
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        logger.info("Relocate primary shard to remote node");
        assertEquals(
        logger.info("Attempt free allocation");
            internalCluster().client()
        assertAllocation(!isReplicaAllocation, !isReplicaAllocation ? null : node2);
        prepareIndexWithAllocatedPrimary(nonRemoteNode1, Optional.empty());
        logger.info("Verify allocation of replica shard on non-remote node");
            .cluster()
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        if (isRemoteStoreBackedIndex) {
public class RemoteMigrationAllocationDeciderIT extends RemoteStoreMigrationShardAllocationBaseTestCase {
        logger.info("Verify expected decision for allocating a new primary shard on a non-remote node");
        logger.info("Add data nodes");
                .add(new MoveAllocationCommand(TEST_INDEX, 0, initialPrimaryNode.getName(), remoteNodeName2))
        internalCluster().stopRandomDataNode();
        internalCluster().startClusterManagerOnlyNode();
        );
            (isRemoteStoreBackedIndex ? "remote" : "non remote")
        );
        logger.info("Attempt allocation on non-remote node");
        String expectedReason = String.format(
            internalCluster().client()
}
            decision.getExplanation().toLowerCase(Locale.ROOT)
        logger.info("Set remote_store direction");
    // store backed index to a non-remote node only
        updateSettingsRequest.persistentSettings(
        boolean isReplicaAllocation = randomBoolean();
                .prepareReroute()
            Settings.builder()
        DiscoveryNode nonRemoteNode1 = assertNodeInCluster(nonRemoteNodeName1);
        logger.info("Verify expected decision for allocating a new primary shard on a remote node");
                .execute()
        if (isReplicaAllocation) {
            prepareIndexWithoutReplica(Optional.empty());
            decision.getExplanation().toLowerCase(Locale.ROOT)
        DiscoveryNode remoteNode1 = assertNodeInCluster(remoteNodeName1);
    public void testAllocationForNoneDirectionAndMixedMode() throws Exception {
        logger.info("Attempt relocation of replica shard to non-remote node");
                .get()
 * this file be licensed under the Apache-2.0 license or a
            .setTimeout(TimeValue.timeValueSeconds(2))
        logger.info("Add non-remote data node");
        internalCluster().startClusterManagerOnlyNode();
        String remoteNodeName = internalCluster().startDataOnlyNode();
            internalCluster().client()
        logger.info("Verify relocation of replica shard to non-remote node");
            .execute()
        logger.info("Verify allocation on one of the previous nodes");
        logger.info("Initialize cluster");
        );
        boolean isRemoteCluster = randomBoolean();
            (isReplicaAllocation ? "replica" : "primary")
        Decision decision = getDecisionForTargetNode(nonRemoteNode, !isReplicaAllocation, false, false);
        assertAllocation(true, remoteNode1);
        DiscoveryNode initialPrimaryNode = primaryNodeName(TEST_INDEX).equals(nonRemoteNodeName1) ? nonRemoteNode1 : nonRemoteNode2;
        assertEquals(expectedReason, decision.getExplanation().toLowerCase(Locale.ROOT));
import org.opensearch.test.InternalTestCluster;
        DiscoveryNode remoteNode = assertNodeInCluster(remoteNodeName);
        if (!isReplicaAllocation) {
        prepareIndexWithoutReplica(Optional.empty());
/*
        DiscoveryNode remoteNode = assertNodeInCluster(remoteNodeName);
        addRemote = true;
            "[none migration_direction]: %s shard copy can not be allocated to a %s node for %s store backed index",
        logger.info("Verify allocation of shard");
        assertNonAllocation(!isReplicaAllocation);
                .indices()
        );
        logger.info("Attempt free allocation of replica shard");
        logger.info("Initialize cluster");
        String remoteNodeName = internalCluster().startDataOnlyNode();
        );
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
                .indices()
        }
        ensureGreen(TEST_INDEX);
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
            assertRemoteStoreBackedIndex(TEST_INDEX);
        setDirection(REMOTE_STORE.direction);
        logger.info("Add non-remote data node");
        );
        logger.info("Set remote_store direction");
            prepareIndexWithoutReplica(Optional.empty());
        String remoteNodeName2 = internalCluster().startDataOnlyNode();
        logger.info("Attempt free allocation");
            .prepareReroute()
        excludeAllNodes();
        updateSettingsRequest.persistentSettings(
    // to another remote node
            .actionGet();
        attemptAllocation(null);
                Locale.ROOT,
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        logger.info("Add remote data node");
            "[remote_store migration_direction]: primary shard copy can be allocated to a remote node",
            .execute()
        assertEquals(expectedReason, decision.getExplanation().toLowerCase(Locale.ROOT));
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        logger.info("Verify decision for allocation on previous node");
        internalCluster().startClusterManagerOnlyNode();
                (isRemoteStoreBackedIndex ? "remote" : "non remote")
        addRemote = false;
        attemptAllocation(nonRemoteNodeName);
        String previousNodeName2 = internalCluster().startDataOnlyNode();
            Settings.builder()
        logger.info("Set remote_store direction");
        Decision decision = getDecisionForTargetNode(initialPrimaryNode, false, true, true);
        ensureGreen("test");
        } else {
        DiscoveryNode remoteNode = assertNodeInCluster(remoteNodeName);
        logger.info("Prepare test index");
        String expectedReason = String.format(
            "[none migration_direction]: %s shard copy can be allocated to a %s node for strict compatibility mode",
        logger.info("Verify expected decision for allocation of shard on a non-remote node");
        );
        assertTrue(
                .cluster()
            decision.getExplanation().toLowerCase(Locale.ROOT)
        internalCluster().validateClusterFormed();
            .setWaitForGreenStatus()
        setClusterMode(MIXED.mode);
        ensureGreen(TEST_INDEX);
        ensureGreen(TEST_INDEX);
            (isRemoteStoreBackedIndex ? "non-remote" : "remote"),
        assertEquals(Decision.Type.NO, decision.type());
        );
                .execute()
        logger.info("Verify remote store backed index");
        DiscoveryNode initialReplicaNode = initialPrimaryNode.equals(nonRemoteNode1) ? nonRemoteNode2 : nonRemoteNode1;
            .actionGet();
import org.opensearch.cluster.routing.UnassignedInfo;
        setClusterMode(MIXED.mode);
        );
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0")
        setClusterMode(MIXED.mode);
        excludeAllNodes();
        client().admin()
        logger.info("Allocate primary and replica shard on non-remote nodes");
            isReplicaAllocation ? node2 : randomFrom(node1, node2),
        ensureGreen(TEST_INDEX);
        setDirection(REMOTE_STORE.direction);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            internalCluster().client()
        logger.info("Verify expected decision for relocating a replica shard on remote node");
        DiscoveryNode nonRemoteNode2 = assertNodeInCluster(nonRemoteNodeName2);
        setDirection(REMOTE_STORE.direction);
        logger.info("Verify non-allocation of replica shard");
            .cluster()
        );
    }
    }
        DiscoveryNode node1 = assertNodeInCluster(nodeName1);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        String remoteNode = internalCluster().startNode();
        String nonRemoteNodeName2 = internalCluster().startDataOnlyNode();
                .get()
            shardRouting.currentNodeId().equals(previousNode1.getId()) || shardRouting.currentNodeId().equals(previousNode2.getId())
        assertEquals(Decision.Type.YES, decision.type());
    // When under mixed mode and remote_store direction, a replica shard can only be allocated to a remote node if the primary has relocated
        assertNonAllocation(true);
        assertEquals(Decision.Type.YES, decision.type());
        logger.info("Verify expected decision for relocating a replica shard on non-remote node");
            .setWaitForEvents(Priority.LANGUID)
        excludeAllNodes();
        logger.info("Add remote data node");
                .actionGet()
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        logger.info("Add another non-remote data node");
        decision = getDecisionForTargetNode(previousNode2, !isReplicaAllocation, true, false);
        String nonRemoteNodeName1 = internalCluster().startDataOnlyNode();
    }
        DiscoveryNode node2 = assertNodeInCluster(nodeName2);
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.common.settings.Settings;
        logger.info("Verify decision for allocation on the new node");
        assertNonAllocation(!isReplicaAllocation);
        logger.info("Attempt allocation of shard on non-remote node");
import org.opensearch.test.OpenSearchIntegTestCase;
        client().admin()
        logger.info("Set mixed mode and remote_store direction");
                "Test for allocation decisions for %s shard of a %s store backed index under NONE direction",
            prepareIndexWithAllocatedPrimary(remoteNode, Optional.empty());
        ensureGreen("test");
        setClusterMode(MIXED.mode);
        }
            assertNonRemoteStoreBackedIndex(TEST_INDEX);
            "test",
        setAddRemote(isRemoteStoreBackedIndex);
        ensureYellow("test");
        } else {
        assertEquals(
        boolean isRemoteStoreBackedIndex = randomBoolean();
    }
            "[none migration_direction]: %s shard copy can be allocated to a %s node for %s store backed index",
        logger.info("Add remote data nodes");
        );
        if (isRemoteCluster) {
        assertEquals(Decision.Type.NO, decision.type());
        assertAcked(
    // When under mixed mode and remote_store direction, shard of a remote store backed index can not be allocated to a non-remote node
        assertRemoteStoreBackedIndex(TEST_INDEX);
        assertEquals(
        }
            Locale.ROOT,
            decision.getExplanation().toLowerCase(Locale.ROOT)
        assertAcked(
            .actionGet();
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
    // When under mixed mode and remote_store direction, a primary shard can only be allocated to a remote node
                .actionGet()
            Settings.builder()
        String newNodeName = internalCluster().startDataOnlyNode();
        attemptAllocation(null);
        addRemote = false;
        logger.info("Verify expected decision for allocation of a shard");
            logger.info("Create index with unallocated primary");
        setAddRemote(false);
 *
            Locale.ROOT,
        assertAllocation(!isReplicaAllocation, null);
        assertEquals(Decision.Type.YES, decision.type());
import org.opensearch.cluster.routing.allocation.decider.Decision;
    }
        excludeAllNodes();
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        }
        Decision decision = getDecisionForTargetNode(remoteNode, false, true, false);
        if (isReplicaAllocation) {
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName("test")));
            decision.getExplanation().toLowerCase(Locale.ROOT)
            false
        logger.info("Attempt free allocation of shard");
import org.opensearch.cluster.routing.ShardRouting;
                (isReplicaAllocation ? "replica" : "primary"),
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode.MIXED;
        String nodeName2 = internalCluster().startDataOnlyNode();
        String remoteNodeName1 = internalCluster().startDataOnlyNode();
                .admin()
        if (isReplicaAllocation) {
        assertAllocation(false, initialPrimaryNode);
        logger.info("Set mixed mode");
        );
        assertEquals(
            Locale.ROOT,
package org.opensearch.remotemigration;
                .cluster()
                .prepareReroute()
        Decision decision = getDecisionForTargetNode(
            "[remote_store migration_direction]: replica shard copy can not be allocated to a remote node since primary shard copy is not yet migrated to remote",
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();
        logger.info("Verify expected decision for allocating a replica shard on a remote node");
            (isRemoteStoreBackedIndex ? "remote" : "non remote")
        logger.info("Attempt relocation of replica shard to remote node");
            (isReplicaAllocation ? "replica" : "primary"),
                .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", String.join(",", nodes)))
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        attemptAllocation(newNodeName);
        setAddRemote(true);
        decision = getDecisionForTargetNode(remoteNode, true, true, false);
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();
        assertEquals(remoteNode, primaryNodeName("test"));
        boolean isReplicaAllocation = randomBoolean();
        logger.info("Verify expected decision for allocating the replica shard on a non-remote node");
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        internalCluster().validateClusterFormed();
            "[remote_store migration_direction]: replica shard copy can be relocated to a non-remote node",
        ensureGreen("test");
        internalCluster().validateClusterFormed();
