            primaryId
            new ShardId(new Index("test_index", "_na_"), 0),  
            null,
import org.opensearch.Version;
            ShardRoutingState.STARTED
            mock(TransportReplicationAction.ReplicasProxy.class),
            randomBoolean()  
    /**
import static org.mockito.Mockito.verify;  
            new ShardId(new Index("test_index", "_na_"), 0),
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
import static org.mockito.Mockito.anyString;  
     * Node running with {@code remote_store.mode: segments_only}: a segment repository and no translog repository.
            "dummy-node",
     * Same as {@link #segmentsOnlyNode} but with a cluster state repository added. The translog still lives on local  
            // what TransportShardBulkAction#getReplicationMode returns for a shard on a remote-attributed node  
            ShardRoutingState.STARTED  
            DiscoveryNodes.builder()
            ReplicationMode.NO_REPLICATION,
        );  
            mockDiscoveryNodes,  
    public void testDetermineReplicationWithRemoteIndexSettingsEnabled() {
    }
            new ShardId(new Index("test_index", "_na_"), 0),
            ShardRoutingState.STARTED
            mock(TransportReplicationAction.ReplicasProxy.class),
            false
     * operations for an acknowledged write to survive loss of the primary. determineReplicationMode gates its  
        assertEquals(ReplicationMode.FULL_REPLICATION, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
            true,
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
        ShardRouting targetRouting = TestShardRouting.newShardRouting(  
            DiscoveryNodes.builder()  
        );
            ReplicationMode.NO_REPLICATION,
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(targetRouting.currentNodeId()))
        );
        );  
     * Sanity check for the segments-only baseline: with no cluster state repository the escape hatch in  
/*  
        );
 * The OpenSearch Contributors require contributions made to  
            true,
            ReplicationMode.NO_REPLICATION,
        Map<String, String> attributes = new HashMap<>();  
            mock(TransportReplicationAction.ReplicasProxy.class),
    }
    /*
    public void testDetermineReplicationModeTargetRoutingDocrepShard() {  
        );  
            ShardRoutingState.RELOCATING,
                .build(),  
            relocationTargetId  
        ReplicationMode replicationModeOverride = ReplicationMode.PRIMARY_TERM_VALIDATION;
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
            replicationModeOverride,
     Replication action originating from remote enabled primary to remote replica during remote store migration  
        );
            AllocationId.newInitializing("abc")  
        assertEquals(ReplicationMode.NO_REPLICATION, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
     * The index therefore has no remote translog, so a replica can only obtain operations over the wire.  
        );
            "dummy-node-2",
import static org.mockito.Mockito.mock;
            new ShardId(new Index("test_index", "_na_"), 0),  
            DiscoveryNodes.builder().add(primaryNode).add(replicaNode).build(),
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;  
     * disk, so the durability requirements are identical and the replication mode must not differ.
            true  
            new ShardId(new Index("test_index", "_na_"), 0),  
    Action should not run and proxy should return ReplicationMode.NO_REPLICATION  
            primaryNode.getId(),
        );  
            true,
            false  
            mock(TransportReplicationAction.ReplicasProxy.class),
        );  
public class ReplicationModeAwareProxyTests extends OpenSearchTestCase {
            mock(TransportReplicationAction.ReplicasProxy.class),
     */
    public void testDetermineReplicationModeTargetRoutingRemoteShard() {  
     Action should not run and proxy should return ReplicationMode.NO_REPLICATION
        return proxy.determineReplicationMode(targetRouting, primaryRouting);
            false,
        );
            ShardRoutingState.STARTED
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(primaryRouting.currentNodeId()))
                .build(),
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), attributes, DiscoveryNodeRole.BUILT_IN_ROLES, Version.CURRENT);
import java.util.Map;
     */
     */
        );  
            ShardRoutingState.STARTED,
    }  
            "dummy-node-2",  
     */
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
    }
            ShardRoutingState.STARTED
        assertEquals(ReplicationMode.NO_REPLICATION, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
                .build(),  
    /*
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
            mock(TransportReplicationAction.ReplicasProxy.class),
            randomBoolean()  
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-test-repo");
    }
    }
            ReplicationMode.PRIMARY_TERM_VALIDATION,
        assertEquals(replicationModeOverride, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
            "dummy-node",  
    /**
import org.opensearch.cluster.routing.ShardRouting;  
            false  
    public void testDetermineReplicationModeSegmentsOnlyWithClusterStateRepoReplicatesToReplica() {
    }  
import org.opensearch.cluster.routing.TestShardRouting;
            new ShardId(new Index("test_index", "_na_"), 0),  
            ShardRoutingState.STARTED
import org.opensearch.cluster.node.DiscoveryNode;
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(  
    /*
        AllocationId primaryId = AllocationId.newRelocation(AllocationId.newInitializing());
            mock(TransportReplicationAction.ReplicasProxy.class),
            mock(TransportReplicationAction.ReplicasProxy.class),
import org.opensearch.index.shard.IndexShardTestUtils;
            "dummy-node",
            new ShardId(new Index("test_index", "_na_"), 0),
import org.opensearch.cluster.node.DiscoveryNodeRole;  
    private static ReplicationMode determineModeBetween(DiscoveryNode primaryNode, DiscoveryNode replicaNode) {
            "dummy-node-2",
     */
            "dummy-node-2",
    }  
    private static DiscoveryNode segmentsOnlyNode(String id) {
    }  
    public void testDetermineReplicationModeSegmentsOnlyReplicatesToReplica() {  
 */  
        assertEquals(ReplicationMode.FULL_REPLICATION, replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting));
            new ShardId(new Index("test_index", "_na_"), 0),
            new ShardId(new Index("test_index", "_na_"), 0),
        ShardRouting targetRouting = TestShardRouting.newShardRouting(
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(targetRouting.currentNodeId()))
import java.util.HashMap;  
import org.opensearch.core.index.shard.ShardId;
    /*
    /*
     */
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
            DiscoveryNodes.builder().add(IndexShardTestUtils.getFakeRemoteEnabledNode("dummy-node")).build(),  
            true,
 *
            "dummy-node",
            replicaNode.getId(),
import org.opensearch.cluster.routing.AllocationId;
     * Adding a cluster state repository does not change where the translog lives, so the replica still has to receive
        );  
            false  
import org.opensearch.cluster.node.DiscoveryNodes;
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(targetRouting.currentNodeId()))  
        DiscoveryNodes mockDiscoveryNodes = mock(DiscoveryNodes.class);  
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), attributes, DiscoveryNodeRole.BUILT_IN_ROLES, Version.CURRENT);
        ReplicationModeAwareProxy proxy = new ReplicationModeAwareProxy(
            true,
     Replication action originating from remote enabled primary to remote enabled replica during remote store migration  
    /**
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-test-repo");
            "dummy-node-2",  
 * compatible open source license.
    public void testDetermineReplicationModeTargetRoutingCurrentPrimary() {
            false,
        );
            null,  
            ReplicationMode.NO_REPLICATION,
                .add(IndexShardTestUtils.getFakeDiscoNode(targetRouting.currentNodeId()))
            mock(TransportReplicationAction.ReplicasProxy.class),
            new ShardId(new Index("test_index", "_na_"), 0),
        );
            new ShardId(new Index("test_index", "_na_"), 0),
     Action should not query the DiscoveryNodes object  
            mock(TransportReplicationAction.ReplicasProxy.class),
package org.opensearch.action.support.replication;
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(primaryRouting.currentNodeId()))
     Replication action originating from remote enabled primary with remote enabled index settings enabled
     * FULL_REPLICATION escape hatch on DiscoveryNode#isRemoteTranslogStoreNode rather than on
     */
            ShardRoutingState.STARTED,
    /**
     Action should run and proxy should return ReplicationMode.FULL_REPLICATION
    public void testDetermineReplicationWithExplicitOverrideTargetRoutingRemoteShard() {
            AllocationId.newInitializing("abc")
        replicationModeAwareProxy.determineReplicationMode(targetRouting, primaryRouting);
        );
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(primaryRouting.currentNodeId()))
    }  
        ShardRouting targetRouting = TestShardRouting.newShardRouting(  
     * DiscoveryNode#isRemoteStoreNode, so the replica keeps receiving operations instead of being downgraded to a
        );  
     */
            true,  
    }  
            ShardRoutingState.STARTED  
     * determineReplicationMode fires and the replica correctly receives operations.
        verify(mockDiscoveryNodes, never()).get(anyString());
     Replication action originating from remote enabled primary to docrep replica during remote store migration  
        assertEquals(ReplicationMode.FULL_REPLICATION, determineModeBetween(segmentsOnlyNode("node-1"), segmentsOnlyNode("node-2")));
     * primary term validation ping.  
            false,  
import org.opensearch.cluster.routing.ShardRoutingState;
            new ShardId(new Index("test_index", "_na_"), 0),
 * this file be licensed under the Apache-2.0 license or a
    /*
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
            true,  
            false,
                .add(IndexShardTestUtils.getFakeRemoteEnabledNode(primaryRouting.currentNodeId()))
        );  
            ShardRoutingState.STARTED
            "dummy-node",  
            ShardRoutingState.STARTED
     Action should run and proxy should return ReplicationMode.FULL_REPLICATION
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "state-test-repo");  
        );
            mock(TransportReplicationAction.ReplicasProxy.class),
import org.opensearch.test.OpenSearchTestCase;
        );
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
            true,
     Replication action originating from failing primary to replica being promoted to primary  
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(  
                .build(),  
            ShardRoutingState.STARTED
            null,  
import org.opensearch.core.index.Index;  
        );
        AllocationId relocationTargetId = AllocationId.newTargetRelocation(primaryId);
     with an explicit replication mode specified
            "dummy-node-2",  
     */
            new ShardId(new Index("test_index", "_na_"), 0),
import static org.mockito.Mockito.never;
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
            "dummy-node",
     Action should run and proxy should return the overridden Replication Mode
    public void testDetermineReplicationModeTargetRoutingRelocatingPrimary() {  
            ShardRoutingState.INITIALIZING,
            DiscoveryNodes.builder()  
            ReplicationMode.NO_REPLICATION,
        ShardRouting targetRouting = TestShardRouting.newShardRouting(  
        assertEquals(  
        ShardRouting primaryRouting = TestShardRouting.newShardRouting(
            mock(TransportReplicationAction.ReplicasProxy.class),
    Replication action running on the same primary copy from which it originates.
 * SPDX-License-Identifier: Apache-2.0
            determineModeBetween(segmentsOnlyNodeWithClusterStateRepo("node-1"), segmentsOnlyNodeWithClusterStateRepo("node-2"))
        Map<String, String> attributes = new HashMap<>();
            false,
    private static DiscoveryNode segmentsOnlyNodeWithClusterStateRepo(String id) {  
}
            "dummy-node",  
            // IndexShard#isRemoteTranslogEnabled: false, because no translog repository is configured
        final ReplicationModeAwareProxy replicationModeAwareProxy = new ReplicationModeAwareProxy(
            true,  
            mock(TransportReplicationAction.ReplicasProxy.class),  
            mock(TransportReplicationAction.ReplicasProxy.class),  
        );  
            new ShardId(new Index("test_index", "_na_"), 0),
        // Verify no interactions with the DiscoveryNodes object  
            DiscoveryNodes.builder()  
            ReplicationMode.FULL_REPLICATION,
     */  
