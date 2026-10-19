        ensureYellow("test");
 * this file be licensed under the Apache-2.0 license or a
        assertAcked(  
        String remoteNodeName2 = internalCluster().startDataOnlyNode();
        }  
        excludeAllNodes();  
        assertEquals(Decision.Type.YES, decision.type());
        if (isReplicaAllocation) {  
    public void testNewPrimaryShardAllocationForRemoteStoreMigration() throws Exception {
            decision.getExplanation().toLowerCase(Locale.ROOT)
        setAddRemote(false);  
 * compatible open source license.
        );
        DiscoveryNode node2 = assertNodeInCluster(nodeName2);  
import java.util.Optional;  
        internalCluster().validateClusterFormed();
        setDirection(REMOTE_STORE.direction);  
        Decision decision = getDecisionForTargetNode(nonRemoteNode, !isReplicaAllocation, false, false);
        logger.info("Attempt relocation of replica shard to remote node");
        );
        );
                .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", String.join(",", docRepNodes)))
        }  
            ensureGreen(TEST_INDEX);  
        assertEquals(expectedReason, decision.getExplanation().toLowerCase(Locale.ROOT));
        );  
        logger.info("Allocate primary shard on non-remote node");
        boolean isReplicaAllocation = randomBoolean();
        logger.info("Add remote data node");
/*  
        logger.info("Verify relocation of replica shard to non-remote node");  
        String remoteNode = internalCluster().startNode();  
        excludeAllNodes();
            internalCluster().client()
    // When under mixed mode and remote_store direction, a replica shard can only be allocated to a remote node if the primary has relocated
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            (isRemoteStoreBackedIndex ? "remote" : "non remote")  
        logger.info("Verify expected decision for allocating the replica shard on a non-remote node");
        setAddRemote(true);
        );
                .indices()  
        ensureGreen(TEST_INDEX);
}
        setClusterMode(MIXED.mode);
        internalCluster().validateClusterFormed();
        logger.info("Verify expected decision for relocating a replica shard on remote node");  
        logger.info("Attempt allocation of shard on non-remote node");
        assertEquals(  
        logger.info("Verify decision for allocation on previous node");
        internalCluster().validateClusterFormed();
            String.format(  
        DiscoveryNode remoteNode = assertNodeInCluster(remoteNodeName);  
        assertTrue(  
        ensureGreen(TEST_INDEX);  
        logger.info("Set remote_store direction");
        setClusterMode(MIXED.mode);
            "[none migration_direction]: %s shard copy can not be allocated to a %s node for %s store backed index",  
        addRemote = true;  
        decision = getDecisionForTargetNode(nonRemoteNode2, false, true, false);
            shardRouting.currentNodeId().equals(previousNode1.getId()) || shardRouting.currentNodeId().equals(previousNode2.getId())
    }
        String nonRemoteNodeName2 = internalCluster().startDataOnlyNode();
        String remoteNodeName = internalCluster().startDataOnlyNode();  
            decision.getExplanation().toLowerCase(Locale.ROOT)
        if (isReplicaAllocation) {
        );  
        logger.info("Verify allocation on one of the previous nodes");
    public void testFilterAllocationSkipsReplicaOnExcludedNode() throws IOException {  
            .cluster()  
        logger.info("Verify expected decision for allocating a new primary shard on a remote node");
        String nodeName2 = internalCluster().startDataOnlyNode();  
            decision.getExplanation().toLowerCase(Locale.ROOT)
            Locale.ROOT,  
        if (isReplicaAllocation) {
    // When under mixed mode and none direction, allocate shard of a remote store backed index to a remote node and shard of a non remote
            prepareIndexWithAllocatedPrimary(node1, Optional.empty());  
        );  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        logger.info("Verify allocation of replica shard on non-remote node");  
        logger.info("Set mixed mode and remote_store direction");
                .add(new MoveAllocationCommand(TEST_INDEX, 0, initialPrimaryNode.getName(), remoteNodeName2))
        assertAllocation(false, initialPrimaryNode);
                .admin()
        updateSettingsRequest.persistentSettings(  
        logger.info("Initialize cluster");
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")
        logger.info("Verify expected decision for relocating a replica shard on non-remote node");
            logger.info("Create index with unallocated primary");
        String remoteNodeName = internalCluster().startDataOnlyNode();
import org.opensearch.cluster.routing.ShardRouting;
        );
        createIndex(  
    // to another remote node
import org.opensearch.common.unit.TimeValue;
                .admin()
        internalCluster().validateClusterFormed();
    public void testRemoteStoreBackedIndexShardAllocationForRemoteStoreMigration() throws Exception {
        assertEquals(  
        setAddRemote(true);  
import org.opensearch.test.InternalTestCluster;  
        logger.info("Verify non-allocation of replica shard");
        assertAllocation(!isReplicaAllocation, !isReplicaAllocation ? null : node2);  
                .get()  
        DiscoveryNode previousNode1 = assertNodeInCluster(previousNodeName1);
        logger.info("Add remote data nodes");
        setAddRemote(true);  
        DiscoveryNode nonRemoteNode = assertNodeInCluster(nonRemoteNodeName);
        assertRemoteStoreBackedIndex(TEST_INDEX);  
        assertAllocation(false, nonRemoteNode2);
        createIndex(TEST_INDEX, 1);
            "test",
        internalCluster().stopRandomDataNode();
        assertEquals(Decision.Type.YES, decision.type());
        ensureGreen(TEST_INDEX);  
            prepareIndexWithoutReplica(Optional.empty());
        assertEquals(expectedReason, decision.getExplanation().toLowerCase(Locale.ROOT));
        logger.info("Allocate primary and replica shard on non-remote nodes");  
                .cluster()  
            assertRemoteStoreBackedIndex(TEST_INDEX);  
                .get()  
        logger.info("Attempt free allocation");
                .admin()
        excludeAllNodes();  
            .setWaitForEvents(Priority.LANGUID)
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        setClusterMode(MIXED.mode);
        logger.info("Initialize cluster");
            decision.getExplanation().toLowerCase(Locale.ROOT)
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        decision = getDecisionForTargetNode(remoteNode, true, true, false);
        } else {
            assertNonRemoteStoreBackedIndex(TEST_INDEX);
        logger.info("Verify expected decision for allocation of a shard");
        assertAllocation(!isReplicaAllocation, null);
            .actionGet();  
            .execute()  
import org.opensearch.cluster.routing.UnassignedInfo;  
            .add(new MoveAllocationCommand("test", 0, primaryNodeName("test"), remoteNode))
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
    public void testAlwaysAllocateNewShardForStrictMode() throws Exception {
    // When under mixed mode and remote_store direction, shard of a remote store backed index can not be allocated to a non-remote node  
        logger.info("Add remote and non-remote nodes");  
            Settings.builder()
        logger.info("Set remote_store direction");
            .setWaitForEvents(Priority.LANGUID)  
                "Test for allocation decisions for %s shard of a %s store backed index under NONE direction",
            assertNonRemoteStoreBackedIndex(TEST_INDEX);
        assertEquals(expectedReason, decision.getExplanation().toLowerCase(Locale.ROOT));
                .add(new MoveAllocationCommand(TEST_INDEX, 0, initialPrimaryNode.getName(), remoteNodeName1))
    }
        assertEquals(Decision.Type.YES, decision.type());
                .cluster()
        internalCluster().startClusterManagerOnlyNode();
            (isReplicaAllocation ? "replica" : "primary"),
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            true,
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        logger.info("Verify allocation of shard");
        logger.info("Attempt free allocation");
        if (isRemoteCluster) {
                .setSettings(Settings.builder().put("index.routing.allocation.exclude._name", String.join(",", nodes)))
        );
                .prepareReroute()  
            logger.info("Create index with primary allocated on remote node");
import org.opensearch.cluster.node.DiscoveryNode;
            Locale.ROOT,
    // When under strict mode, a shard can be allocated to any node
import org.opensearch.cluster.metadata.IndexMetadata;  
        logger.info("Set remote_store direction");  
 * SPDX-License-Identifier: Apache-2.0
        String previousNodeName2 = internalCluster().startDataOnlyNode();
        List<String> docRepNodes = internalCluster().startNodes(3);
    public void testNewReplicaShardAllocationIfPrimaryShardOnNonRemoteNodeForRemoteStoreMigration() throws Exception {
import static org.opensearch.node.remotestore.RemoteStoreNodeService.Direction.REMOTE_STORE;  
        logger.info("Initialize cluster");  
        ensureGreen("test");
 */  
        internalCluster().validateClusterFormed();
        internalCluster().startClusterManagerOnlyNode();  
import org.opensearch.common.settings.Settings;
                .execute()  
            Settings.builder()
        } else {
        ensureGreen(TEST_INDEX);
            .prepareHealth()
 *
        internalCluster().validateClusterFormed();  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                .indices()  
                .actionGet()
        );  
package org.opensearch.remotemigration;
        client().admin()
        logger.info("Prepare test index");
        }  
            prepareIndexWithAllocatedPrimary(remoteNode, Optional.empty());
        assertEquals(Decision.Type.NO, decision.type());
        String expectedReason = String.format(  
        DiscoveryNode remoteNode = assertNodeInCluster(remoteNodeName);  
            .setTimeout(TimeValue.timeValueSeconds(2))
        String newNodeName = internalCluster().startDataOnlyNode();
        DiscoveryNode node1 = assertNodeInCluster(nodeName1);
        }  
        String remoteNodeName = internalCluster().startDataOnlyNode();
        assertTrue(clusterHealthResponse.isTimedOut());
        assertTrue(  
        String previousNodeName1 = internalCluster().startDataOnlyNode();
        logger.info("Switch to MIXED cluster compatibility mode");
        ensureGreen("test");
        DiscoveryNode previousNode2 = assertNodeInCluster(previousNodeName2);
        internalCluster().validateClusterFormed();
        attemptAllocation(null);
        excludeAllNodes();  
        attemptAllocation(null);  
    }  
        Decision decision = getDecisionForTargetNode(initialPrimaryNode, false, true, true);  
        );  
        logger.info("Attempt free allocation of replica shard");
            false
            (isRemoteStoreBackedIndex ? "remote" : "non remote")  
        assertAllocation(true, remoteNode);
    public void testNewReplicaShardAllocationIfPrimaryShardOnRemoteNodeForRemoteStoreMigration() throws Exception {
            (isRemoteCluster ? "remote" : "non-remote")  
            "[remote_store migration_direction]: primary shard copy can not be allocated to a non-remote node",
    }
            .cluster()  
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0")
                (isRemoteStoreBackedIndex ? "remote" : "non remote")
        logger.info("Add remote data node");
        setDirection(REMOTE_STORE.direction);  
        logger.info("Verify expected decision for allocating a new primary shard on a non-remote node");
        boolean isRemoteCluster = randomBoolean();
                .admin()
        ensureGreen("test");
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
    }  
        assertAllocation(false, remoteNode2);
                .cluster()  
            internalCluster().client()
        logger.info("Set mixed mode");
                .get()
            "[remote_store migration_direction]: replica shard copy can be allocated to a non-remote node",
        }  
    // When the primary is on doc rep node, existing replica copy can get allocated on excluded docrep node.
            "[none migration_direction]: %s shard copy can be allocated to a %s node for %s store backed index",  
            (isReplicaAllocation ? "replica" : "primary"),
                (isReplicaAllocation ? "replica" : "primary"),  
        DiscoveryNode newNode = assertNodeInCluster(newNodeName);
        String nonRemoteNodeName2 = internalCluster().startDataOnlyNode();
        attemptAllocation(null);
        attemptAllocation(null);  
                .prepareReroute()
        logger.info("Verify successful allocation of shard");
        ensureGreen(TEST_INDEX);
        logger.info("Add data nodes");  
        );  
            (isRemoteStoreBackedIndex ? "remote" : "non-remote"),
    // store backed index to a non-remote node only  
        updateSettingsRequest.persistentSettings(
        setAddRemote(isRemoteStoreBackedIndex);  
                .prepareUpdateSettings("test")
            internalCluster().client()
            decision.getExplanation().toLowerCase(Locale.ROOT)
            .setTimeout(TimeValue.timeValueSeconds(60))
        prepareIndexWithAllocatedPrimary(nonRemoteNode1, Optional.empty());
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
                .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), "0")
        );
        setAddRemote(!addRemote);
                .build()  
            "[remote_store migration_direction]: replica shard copy can be relocated to a remote node since primary shard copy has been migrated to remote",
        assertEquals(  
        assertAcked(  
            "[none migration_direction]: %s shard copy can be allocated to a %s node for strict compatibility mode",
        decision = getDecisionForTargetNode(previousNode2, !isReplicaAllocation, true, false);
        logger.info("Add non-remote data node");
        logger.info("Relocate primary shard to remote node");  
        DiscoveryNode nonRemoteNode1 = assertNodeInCluster(nonRemoteNodeName1);  
        DiscoveryNode initialReplicaNode = initialPrimaryNode.equals(nonRemoteNode1) ? nonRemoteNode2 : nonRemoteNode1;
        excludeAllNodes();  
        DiscoveryNode remoteNode2 = assertNodeInCluster(remoteNodeName2);
            .setWaitForNoRelocatingShards(true)
        logger.info("Set mixed mode");  
        }  
                .prepareReroute()
            "[remote_store migration_direction]: %s shard copy can not be allocated to a non-remote node because a remote store backed index's shard copy can only be allocated to a remote node",
            decision.getExplanation().toLowerCase(Locale.ROOT)
        attemptAllocation(null);  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertNonAllocation(true);  
        String nonRemoteNodeName1 = internalCluster().startDataOnlyNode();  
            .prepareReroute()
            .execute()
        boolean isReplicaAllocation = randomBoolean();  
        );
        Decision decision = getDecisionForTargetNode(
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();  
        logger.info("Verify remote store backed index");
        } else {
        attemptAllocation(newNodeName);
        logger.info("Initialize cluster and add nodes");
        assertAllocation(true, remoteNode1);  
        logger.info("Verify relocation of replica shard to non-remote node");
        if (isRemoteStoreBackedIndex) {
import java.util.Locale;
        Decision decision = getDecisionForTargetNode(newNode, !isReplicaAllocation, false, false);
        } else {
        setClusterMode(MIXED.mode);
        logger.info("Verify non-allocation of shard");
                .prepareUpdateSettings("test")
        Decision decision = getDecisionForTargetNode(remoteNode, false, true, false);
        String nodeName1 = internalCluster().startDataOnlyNode();
        boolean isReplicaAllocation = randomBoolean();
        internalCluster().startClusterManagerOnlyNode();  
        ensureGreen(TEST_INDEX);
    }  
        internalCluster().validateClusterFormed();  
        boolean isRemoteStoreBackedIndex = randomBoolean();  
            assertRemoteStoreBackedIndex(TEST_INDEX);  
    public void testFilterAllocationSkipsReplica() throws IOException {  
            .execute()
        setDirection(REMOTE_STORE.direction);  
            (isReplicaAllocation ? "replica" : "primary"),
        addRemote = false;
public class RemoteMigrationAllocationDeciderIT extends RemoteStoreMigrationShardAllocationBaseTestCase {  
        String expectedReason = String.format(
        assertEquals(Decision.Type.NO, decision.type());  
                Locale.ROOT,
        logger.info("Attempt free allocation of replica shard");
        createIndex(  
import java.io.IOException;  
    }  
        assertNonAllocation(false);  
            prepareIndexWithoutReplica(Optional.empty());
        DiscoveryNode nonRemoteNode1 = assertNodeInCluster(nonRemoteNodeName1);
        } else {
        logger.info("Attempt free allocation of shard");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                .admin()
        assertNonAllocation(!isReplicaAllocation);
        internalCluster().validateClusterFormed();
            (isRemoteStoreBackedIndex ? "non-remote" : "remote"),
        logger.info("Attempt allocation on non-remote node");
        } else {  
            Settings.builder()  
            !isReplicaAllocation,  
        if (!isReplicaAllocation) {
        String expectedReason = String.format(
            internalCluster().client()
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNodeName("test")));
            Settings.builder()
        DiscoveryNode nonRemoteNode = assertNodeInCluster(nonRemoteNodeName);  
            (isReplicaAllocation ? "replica" : "primary")  
        assertEquals(expectedReason, decision.getExplanation().toLowerCase(Locale.ROOT));
        assertEquals(remoteNode, primaryNodeName("test"));
    }
        assertAcked(
        excludeAllNodes();  
                .add(new MoveAllocationCommand(TEST_INDEX, 0, initialReplicaNode.getName(), initialPrimaryNode.getName()))
            Locale.ROOT,
        );  
            "[remote_store migration_direction]: replica shard copy can not be allocated to a remote node since primary shard copy is not yet migrated to remote",
        );  
        internalCluster().startClusterManagerOnlyNode();
            .setWaitForGreenStatus()  
        );  
            isReplicaAllocation ? node2 : randomFrom(node1, node2),
        internalCluster().startClusterManagerOnlyNode();
        assertEquals(Decision.Type.NO, decision.type());
        setAddRemote(true);
        DiscoveryNode nonRemoteNode2 = assertNodeInCluster(nonRemoteNodeName2);  
        logger.info("Initialize cluster");
 * The OpenSearch Contributors require contributions made to  
                .actionGet()
            .actionGet();  
        assertNonAllocation(!isReplicaAllocation);
        assertEquals(Decision.Type.YES, decision.type());
            "test",
        logger.info("Verify allocation of primary shard on remote node");  
        logger.info("Add non-remote data nodes");
        DiscoveryNode remoteNode1 = assertNodeInCluster(remoteNodeName1);  
        );  
            .cluster()  
        client().admin()
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), "mixed")  
        attemptAllocation(null);  
            internalCluster().client()  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode.MIXED;
    // When under mixed mode and remote_store direction, a primary shard can only be allocated to a remote node
        expectedReason = String.format(
                .put(MIGRATION_DIRECTION_SETTING.getKey(), "remote_store")
        logger.info("Add another non-remote data node");
        );
        setDirection(REMOTE_STORE.direction);
                .isAcknowledged()
import org.opensearch.cluster.routing.allocation.decider.Decision;
        DiscoveryNode remoteNode = assertNodeInCluster(remoteNodeName);
        logger.info("Verify expected decision for allocation of shard on a non-remote node");
            prepareIndexWithAllocatedPrimary(previousNode1, Optional.empty());  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Decision decision = getDecisionForTargetNode(nonRemoteNode, true, true, false);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        assertEquals(
        logger.info("Verify decision for allocation on the new node");  
                .execute()  
        logger.info("Initialize cluster");
        logger.info("Verify expected decision for allocating a replica shard on a remote node");
        DiscoveryNode nonRemoteNode2 = assertNodeInCluster(nonRemoteNodeName2);
import org.opensearch.common.Priority;  
        assertEquals(Decision.Type.NO, decision.type());
        internalCluster().validateClusterFormed();
        assertEquals(  
        assertEquals(  
            "[remote_store migration_direction]: replica shard copy can be relocated to a non-remote node",  
        logger.info("Add non-remote data node");
            )
        DiscoveryNode initialPrimaryNode = primaryNodeName(TEST_INDEX).equals(nonRemoteNodeName1) ? nonRemoteNode1 : nonRemoteNode2;
        attemptAllocation(nonRemoteNodeName);
        setClusterMode(MIXED.mode);  
            Locale.ROOT,
        assertEquals(Decision.Type.YES, decision.type());
        assertTrue(
                .build()  
        String nonRemoteNodeName1 = internalCluster().startDataOnlyNode();  
            "[remote_store migration_direction]: primary shard copy can be allocated to a remote node",
                .isAcknowledged()
        logger.info("Verify non-allocation of shard");
        String remoteNodeName1 = internalCluster().startDataOnlyNode();  
import java.util.List;
        List<String> nodes = internalCluster().startNodes(2);
        logger.info("Verify non-allocation of primary shard on non-remote node");
        logger.info("Attempt allocation of shard on new node");
import org.opensearch.test.OpenSearchIntegTestCase;
        ClusterHealthResponse clusterHealthResponse = client().admin()
        ensureGreen(TEST_INDEX);
        String nonRemoteNodeName = internalCluster().startDataOnlyNode();
        ShardRouting shardRouting = getShardRouting(!isReplicaAllocation);  
        );  
        );  
        internalCluster().validateClusterFormed();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            .actionGet();
        setAddRemote(isRemoteCluster);  
    public void testAllocationForNoneDirectionAndMixedMode() throws Exception {
    // When the primary is on remote node, new replica copy shouldn't get allocated on an excluded docrep node.
        addRemote = false;
        logger.info(
        );
            prepareIndexWithoutReplica(Optional.empty());
        prepareIndexWithoutReplica(Optional.empty());  
        assertEquals(Decision.Type.YES, decision.type());  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
            .prepareHealth()
        decision = getDecisionForTargetNode(remoteNode2, false, true, true);
            ensureYellowAndNoInitializingShards(TEST_INDEX);
        internalCluster().startClusterManagerOnlyNode();  
        logger.info("Attempt relocation of replica shard to non-remote node");
