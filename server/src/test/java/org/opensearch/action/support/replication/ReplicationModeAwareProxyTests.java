     Replication action originating from remote enabled primary to remote replica during remote store migration
            new ShardId(new Index("test_index", "_na_"), 0),
        return proxy.determineReplicationMode(targetRouting, primaryRouting);
        );
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
            new ShardId(new Index("test_index", "_na_"), 0),
     * operations for an acknowledged write to survive loss of the primary. determineReplicationMode gates its
        ReplicationMode replicationModeOverride = ReplicationMode.PRIMARY_TERM_VALIDATION;
            "dummy-node",
    /**
                .add(IndexShardTestUtils.getFakeDiscoNode(targetRouting.currentNodeId()))
        assertEquals(ReplicationMode.NO_REPLICATION, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
     */
}
        );
            false,
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
            mock(TransportReplicationAction.ReplicasProxy.class),
        assertEquals(ReplicationMode.FULL_REPLICATION, determineModeBetween(segmentsOnlyNode("node-1"), segmentsOnlyNode("node-2")));
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(targetRouting.currentNodeId()))
            ShardRoutingState.STARTED
            mock(TransportReplicationAction.ReplicasProxy.class),
import org.opensearch.cluster.routing.TestShardRouting;
     Action should run and proxy should return ReplicationMode.FULL_REPLICATION
        );
            ShardRoutingState.STARTED
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
            true,
        assertEquals(ReplicationMode.FULL_REPLICATION, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
    public void testDetermineReplicationModeSegmentsOnlyReplicatesToReplica() {
            "dummy-node",
     Action should run and proxy should return ReplicationMode.FULL_REPLICATION
            mock(TransportReplicationAction.ReplicasProxy.class),
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
            false,
    }
 * compatible open source license.
     * Same as {@link #segmentsOnlyNode} but with a cluster state repository added. The translog still lives on local
    Action should not run and proxy should return ReplicationMode.NO_REPLICATION
     */
            mockDiscoveryNodes,
import static org.mockito.Mockito.mock;
            true,
    /*
            ShardRoutingState.STARTED,
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), attributes, DiscoveryNodeRole.BUILT_IN_ROLES, Version.CURRENT);
            // what TransportShardBulkAction#getReplicationMode returns for a shard on a remote-attributed node
        );
import org.opensearch.core.index.shard.ShardId;
        ReplicationModeAwareProxy proxy = new ReplicationModeAwareProxy(
    /*
     * Adding a cluster state repository does not change where the translog lives, so the replica still has to receive
            ReplicationMode.FULL_REPLICATION,
     * Node running with {@code remote_store.mode: segments_only}: a segment repository and no translog repository.
import static org.mockito.Mockito.never;
    /**
     Replication action originating from remote enabled primary to docrep replica during remote store migration
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
        );
            false
import static org.mockito.Mockito.verify;
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(primaryRouting.currentNodeId()))
     Action should run and proxy should return the overridden Replication Mode
            ReplicationMode.PRIMARY_TERM_VALIDATION,
            // IndexShard#isRemoteTranslogEnabled: false, because no translog repository is configured
            DiscoveryNodes.builder()
        );
            ReplicationMode.NO_REPLICATION,
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
     */
 * this file be licensed under the Apache-2.0 license or a
            "dummy-node-2",
            replicationModeOverride,
            mock(TransportReplicationAction.ReplicasProxy.class),
            ShardRoutingState.STARTED
     */
            ShardRoutingState.STARTED
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
            null,
        assertEquals(ReplicationMode.FULL_REPLICATION, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
    public void testDetermineReplicationModeSegmentsOnlyWithClusterStateRepoReplicatesToReplica() {
            ShardRoutingState.STARTED,
                .build(),
            mock(TransportReplicationAction.ReplicasProxy.class),
            AllocationId.newInitializing("abc")
        );
            new ShardId(new Index("test_index", "_na_"), 0),
            ReplicationMode.NO_REPLICATION,
     Action should not query the DiscoveryNodes object
            ShardRoutingState.STARTED
    Replication action running on the same primary copy from which it originates.
import org.opensearch.cluster.routing.ShardRouting;
 * The OpenSearch Contributors require contributions made to
            "dummy-node",
    }
            new ShardId(new Index("test_index", "_na_"), 0),
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
            replicaNode.getId(),
                .build(),
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(targetRouting.currentNodeId()))
            "dummy-node",
    }
                .build(),
        );
    public void testDetermineReplicationModeTargetRoutingRelocatingPrimary() {
        assertEquals(replicationModeOverride, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
            "dummy-node",
     Action should not run and proxy should return ReplicationMode.NO_REPLICATION
    private static ReplicationMode determineModeBetween(DiscoveryNode primaryNode, DiscoveryNode replicaNode) {
            ShardRoutingState.STARTED
            AllocationId.newInitializing("abc")
        );
    private static DiscoveryNode segmentsOnlyNodeWithClusterStateRepo(String id) {
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(primaryRouting.currentNodeId()))
        AllocationId relocationTargetId = AllocationId.newTargetRelocation(primaryId);
import org.opensearch.index.shard.IndexShardTestUtils;
    public void testDetermineReplicationWithExplicitOverrideTargetRoutingRemoteShard() {
    /*
            mock(TransportReplicationAction.ReplicasProxy.class),
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
     * FULL_REPLICATION escape hatch on DiscoveryNode#isRemoteTranslogStoreNode rather than on
        );
        );
    /*
            ShardRoutingState.STARTED
            "dummy-node-2",
    /**
            ReplicationMode.NO_REPLICATION,
            false,
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
import org.opensearch.cluster.routing.ShardRoutingState;
            new ShardId(new Index("test_index", "_na_"), 0),
            mock(TransportReplicationAction.ReplicasProxy.class),
import org.opensearch.core.index.Index;
            true,
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(primaryRouting.currentNodeId()))
            new ShardId(new Index("test_index", "_na_"), 0),
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(targetRouting.currentNodeId()))
 * SPDX-License-Identifier: Apache-2.0
    }
        );
 *
    public void testDetermineReplicationModeTargetRoutingCurrentPrimary() {
            new ShardId(new Index("test_index", "_na_"), 0),
    }
    /**
            true
    public void testDetermineReplicationModeTargetRoutingDocrepShard() {
    }
package org.opensearch.action.support.replication;
 */
            "dummy-node-2",
    }
            randomBoolean()
            true,
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-test-repo");
            "dummy-node-2",
     */
    }
            DiscoveryNodes.builder()
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "state-test-repo");
        DiscoveryNodes mockDiscoveryNodes = mock(DiscoveryNodes.class);
import org.opensearch.cluster.node.DiscoveryNodeRole;
        // Verify no interactions with the DiscoveryNodes object
            new ShardId(new Index("test_index", "_na_"), 0),
            new ShardId(new Index("test_index", "_na_"), 0),
            mock(TransportReplicationAction.ReplicasProxy.class),
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(primaryRouting.currentNodeId()))
            primaryId
     Replication action originating from failing primary to replica being promoted to primary
     * DiscoveryNode#isRemoteStoreNode, so the replica keeps receiving operations instead of being downgraded to a
            "dummy-node-2",
     */
        );
     */
        Map<String, String> attributes = new HashMap<>();
            new ShardId(new Index("test_index", "_na_"), 0),
     */
import org.opensearch.Version;
    /*
        assertEquals(
        AllocationId primaryId = AllocationId.newRelocation(AllocationId.newInitializing());
    }
            true,
     * Sanity check for the segments-only baseline: with no cluster state repository the escape hatch in
            primaryNode.getId(),
     Replication action originating from remote enabled primary with remote enabled index settings enabled
     */
import org.opensearch.cluster.routing.AllocationId;
            null,
import org.opensearch.cluster.node.DiscoveryNodes;
            mock(TransportReplicationAction.ReplicasProxy.class),
            ShardRoutingState.STARTED
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
     * disk, so the durability requirements are identical and the replication mode must not differ.
     Replication action originating from remote enabled primary to remote enabled replica during remote store migration
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-test-repo");
import org.opensearch.cluster.node.DiscoveryNode;
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), attributes, DiscoveryNodeRole.BUILT_IN_ROLES, Version.CURRENT);
import org.opensearch.test.OpenSearchTestCase;
    private static DiscoveryNode segmentsOnlyNode(String id) {
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
     * determineReplicationMode fires and the replica correctly receives operations.
            "dummy-node",
            true,
        );
        );
    public void testDetermineReplicationWithRemoteIndexSettingsEnabled() {
            new ShardId(new Index("test_index", "_na_"), 0),
        );
            determineModeBetween(segmentsOnlyNodeWithClusterStateRepo("node-1"), segmentsOnlyNodeWithClusterStateRepo("node-2"))
            ShardRoutingState.STARTED
        );
            ReplicationMode.NO_REPLICATION,
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
            true,
        verify(mockDiscoveryNodes, never()).get(anyString());
            mock(TransportReplicationAction.ReplicasProxy.class),
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
        );
            ShardRoutingState.STARTED
            new ShardId(new Index("test_index", "_na_"), 0),
            DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build(),
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            "dummy-node",
import static org.mockito.Mockito.anyString;
            mock(TransportReplicationAction.ReplicasProxy.class),
            mock(TransportReplicationAction.ReplicasProxy.class),
            false
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
        );
            false,
            false
     * The index therefore has no remote translog, so a replica can only obtain operations over the wire.
            randomBoolean()
     with an explicit replication mode specified
            new ShardId(new Index("test_index", "_na_"), 0),
            ReplicationMode.NO_REPLICATION,
                .build(),
        );
        Map<String, String> attributes = new HashMap<>();
    }
            mock(TransportReplicationAction.ReplicasProxy.class),
import java.util.HashMap;
            "dummy-node-2",
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
    }
            true,
        );
        assertEquals(ReplicationMode.NO_REPLICATION, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
            DiscoveryNodes.builder()
    /*
    public void testDetermineReplicationModeTargetRoutingRemoteShard() {
import java.util.Map;
        replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting);
     */
            ShardRoutingState.INITIALIZING,
            null,
            DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode("dummy-node")).build(),
public class ReplicationModeAwareProxyTests extends OpenSearchTestCase {
     * primary term validation ping.
            mock(TransportReplicationAction.ReplicasProxy.class),
/*
            ShardRoutingState.RELOCATING,
            true,
            new ShardId(new Index("test_index", "_na_"), 0),
        );
            relocationTargetId
            DiscoveryNodes.builder()
            false,
            false
