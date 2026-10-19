            ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        String primaryNode = primaryNodeName(INDEX_NAME);  
import org.opensearch.index.translog.Translog;
            TimeUnit.SECONDS
            }, 60, TimeUnit.SECONDS);
        );
        ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
            clusterService.removeListener(this);
     * primary is alive, every operation acknowledged before the partition is served, the healed cluster converges
            .put(autoRestoreIndexSettings(0, true))
 * multi-writer safety of the sequence (a departed primary that is still alive behind a partition) rides on the fence
        String survivorDataNode = internalCluster().client(clusterManagerNode)
            assertTrue("primary should be restored and started, was " + primary, primary.started());  
        internalCluster().startDataOnlyNode();
     * The trigger honors the node-left grace window: with a non-zero
        RestoreWindowObserver() {
            observer.assertRestoredRedUntilStarted();  
        }
                    .prepareState()
        ensureGreen(INDEX_NAME);
        // Heal the partition: the stale copy on the rejoined node is dropped, not re-adopted, and the index keeps  
     * the remote store - RED (deliberately, a hydrating primary cannot serve queries) for every published cluster
    public void testReplicaPromotionPreemptsAutoRestore() throws Exception {  
import org.opensearch.cluster.coordination.FollowersChecker;
        );
            IndexRoutingTable indexRoutingTable = state.routingTable().index(INDEX_NAME);  
import org.opensearch.cluster.routing.ShardRouting;
                assertTrue("primary should be parked during the node-left grace window, was " + primary, primary.unassigned());
        assertTrue(  
        void assertTriggerNeverFired() {
    /**  
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.cluster.routing.RecoverySource;
            ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
        ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));  
import java.util.concurrent.CopyOnWriteArrayList;
 * The OpenSearch Contributors require contributions made to  
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
        return false;
        // Fast follower checks so the cluster manager expels the partitioned node quickly. Leader checks stay at  
     * higher term is what stops the departed writer acknowledging operations the restored copy will never see. The  
                    .cluster()
            .values()
    /**  
 */  
            30,  
     */
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
import org.opensearch.common.unit.TimeValue;  
            );
import org.opensearch.cluster.service.ClusterService;
    }
                assertTrue("promoted primary should be started, was " + primary, primary.started());  
     * parameter: the trigger itself is replica-count independent (it fires on the allocator's no-valid-copy proof,  
        // The manual operator path is unaffected by the (disabled) trigger.  
        String primaryNode = primaryNodeName(INDEX_NAME);  
                    .get()  
                ClusterState state = client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();
            observer.assertTriggerNeverFired();
            // restored primary STARTED and serving.  
        indexSingleDoc(INDEX_NAME);  
 *
            observer.assertRestoredRedUntilStarted();
                sawRemoteStoreRecoverySource.set(true);  
            }
        String primaryNode = primaryNodeName(INDEX_NAME);
     * The partitioned-writer variant - the scenario {@code FenceAutoRestore.tla} refutes for an unfenced trigger: the  
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),  
     */
        createIndex(INDEX_NAME, autoRestoreIndexSettings(1, true));
            assertBusy(() -> {
                assertEquals(replicaNode, state.nodes().get(primary.currentNodeId()).getName());
            ShardRouting primary = indexRoutingTable.shard(0).primaryShard();
        ensureRed(INDEX_NAME);
                if (health != ClusterHealthStatus.RED) {
        createIndex(INDEX_NAME, indexSettings);
                .get()
     * the operator's manual {@code _remotestore/_restore} path still recovers it.  
                ClusterState state = client().admin().cluster().prepareState().get().getState();
            assertTrue(  
        assertBusy(() -> {  
            30,
    public void testAutoRestoreWithReplicaWhenAllCopiesLost() throws Exception {
        try (RestoreWindowObserver observer = new RestoreWindowObserver()) {
            }
            if (primary == null || primary.recoverySource() == null) {
 * node, or N replicas losing every copy-holding node - the shard is re-pointed at a
     * {@code NO_VALID_SHARD_COPY} when EVERY copy-holding node is gone (a surviving in-sync replica is promoted on  
        }  
        );  
            NetworkDisruption.DISCONNECT  
        }
        Set<String> isolatedSide = Stream.of(primaryNode).collect(Collectors.toCollection(HashSet::new));  
        ensureGreen(INDEX_NAME);  
     * {@code ClusterShardHealth#getInactivePrimaryHealth}); YELLOW would overstate availability.  
        internalCluster().startClusterManagerOnlyNode();
        // slowing them (as PrimaryTermValidationIT does to keep its stale primary deluded) would also delay the
            }, 60, TimeUnit.SECONDS);
        internalCluster().setDisruptionScheme(networkDisruption);
            .findFirst()
        );
            30,  
        createIndex(INDEX_NAME, autoRestoreIndexSettings(1, true));  
        refresh(INDEX_NAME);  
    @Override
        internalCluster().startDataOnlyNodes(2);
        Settings fastFollowerChecks = Settings.builder()
        );
            ensureYellowAndNoInitializingShards(INDEX_NAME);
     * translog, so the restored primary must serve all of them. The replica count is the test's failure-domain
            .build();
        );
        @Override  
            // The in-sync replica is promoted; with only one data node left the replica slot stays unassigned.
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),
        Set<String> liveSide = Stream.of(clusterManagerNode, survivorDataNode).collect(Collectors.toCollection(HashSet::new));
            if (primary.recoverySource().getType() == RecoverySource.Type.REMOTE_STORE) {
        refresh(INDEX_NAME);  
                .index(INDEX_NAME)
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST.name())
        indexSingleDoc(INDEX_NAME);
import java.util.stream.Stream;  
import org.opensearch.cluster.health.ClusterHealthStatus;  
     * The headline flow: kill the node holding a fenced zero-replica primary and assert the shard auto-restores from  
                "index health must stay RED (a hydrating primary cannot serve queries) until the restored primary starts: "
 * End-to-end coverage for the auto-restore trigger ({@code BaseGatewayShardAllocator#maybeAutoRestoreFromRemoteStore}):
        String replicaNode = replicaNodeName(INDEX_NAME);
        // read the stale pre-removal GREEN.
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));  
                ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();  
        assertBusy(
        );
     */
     * which with replicas configured requires every copy-holding node to be gone).
            .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)  
                sawRemoteStoreRecoverySource.get()
        // their defaults: a DISCONNECT disruption fails the isolated node's leader check immediately anyway, and
                "the trigger must not fire while an in-sync replica is available for promotion",  
            ShardRouting primary = client().admin()
public class RemoteStoreAutoRestoreIT extends RemoteStoreBaseIntegTestCase {
        String clusterManagerNode = internalCluster().getClusterManagerName();
            );
        ensureGreen(INDEX_NAME);
import java.util.concurrent.atomic.AtomicBoolean;
                    .primaryShard();
        try (RestoreWindowObserver observer = new RestoreWindowObserver()) {  
            .build();  
                    .getState()
            .getState()
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
     * Observes every published cluster state on the cluster manager. The restore window is precisely the states in
     * action, all acknowledged operations present, and the index writable again.  
import org.opensearch.cluster.metadata.IndexMetadata;
                return;
                ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
import org.opensearch.test.transport.MockTransportService;
        }, 60, TimeUnit.SECONDS);
            30,
    }
     * {@code REQUEST} durability pins the contract being asserted - every acknowledged operation is in the remote
    private static final String INDEX_NAME = "remote-store-auto-restore-idx";
                    + nonRedStatesDuringRestore,
     * newly joined node.  
    public void testAutoRestoreWithPartitionedWriter() throws Exception {
                )  
    public void testAutoRestoreWaitsOutNodeLeftDelay() throws Exception {  
        internalCluster().startClusterManagerOnlyNode();  
        // Every acknowledged operation survived the node loss ...
        // A new data node joins: the replica peer-recovers from the auto-restored primary and the index goes GREEN.
        assertBusy(  
        refresh(INDEX_NAME);  
        // surviving data node while the old primary is still alive. All three facts - membership shrank to two,  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * state in which the shard carries a {@code REMOTE_STORE} recovery source, GREEN once hydrated with no operator
                ClusterHealthStatus health = new ClusterIndexHealth(state.metadata().index(INDEX_NAME), indexRoutingTable).getStatus();
        refresh(INDEX_NAME);
        ensureGreen(INDEX_NAME);  
        void assertRestoredRedUntilStarted() {
        internalCluster().clearDisruptionScheme();  
        internalCluster().startClusterManagerOnlyNode(fastFollowerChecks);  
        internalCluster().startClusterManagerOnlyNode();
            // expires, and this assertBusy caps at 10s.  
                .shard(0)
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
    /**
        assertBusy(
     */
import org.opensearch.cluster.routing.UnassignedInfo;  
            ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
     * old primary is not dead, only expelled from the cluster manager's view, and (on a shared filesystem repository)
     */
    private final class RestoreWindowObserver implements ClusterStateListener, AutoCloseable {
            .put(remoteStoreIndexSettings(replicaCount, 1))
            30,
package org.opensearch.remotestore;
            TimeUnit.SECONDS  
            .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
                    );
    private Settings autoRestoreIndexSettings(int replicaCount, boolean autoRestoreEnabled) {  
                assertEquals(RecoverySource.Type.EXISTING_STORE, primary.recoverySource().getType());
     * cannot serve queries, so health deliberately stays RED until the shard starts (see
import org.opensearch.test.InternalTestCluster;
        refresh(INDEX_NAME);
                .primaryShard();  
    }
        networkDisruption.stopDisrupting();
            assertEquals("isolated node should be expelled from the cluster manager's view", 2, state.nodes().getSize());
                    nonRedStatesDuringRestore.add(  
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);  
    }  
     * (so a bouncing node can rejoin and recover its local copy - a converted primary has no rejoin-cancellation  
            .build();  
                        && survivorDataNode.equals(recovery.getTargetNode().getName())
    }
        refresh(INDEX_NAME);
 * {@link RecoverySource.RemoteStoreRecoverySource} inside the allocation round instead of being parked RED at
        }
        internalCluster().startDataOnlyNodes(3);
import java.util.concurrent.TimeUnit;  
        internalCluster().startDataOnlyNodes(2);
            assertEquals(survivorDataNode, state.nodes().get(primary.currentNodeId()).getName());
        assertBusy(
            recoveries.shardRecoveryStates()
        indexSingleDoc(INDEX_NAME);  
            TimeUnit.SECONDS  
            // and a live delay marker. Deterministic: the conversion cannot legally happen before the 15s window
     * The boundary from the other side: while an in-sync replica survives, losing the primary's node is handled by
        );
            .stream()
            // Wait for the node-left state to apply, then assert the shard is parked with its EXISTING_STORE source
                        && recovery.getRecoverySource().getType() == RecoverySource.Type.REMOTE_STORE
        try (RestoreWindowObserver observer = new RestoreWindowObserver()) {
        refresh(INDEX_NAME);
    protected boolean remoteStoreFencingForAllIndices() {  
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.ZERO)
                ShardRouting primary = client().admin()  
     * The control: without {@code index.remote_store.auto_restore.enabled} the trigger must not fire - the shard is
        private final List<String> nonRedStatesDuringRestore = new CopyOnWriteArrayList<>();
            if (indexRoutingTable == null) {
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueSeconds(15))
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
            assertBusy(() -> {  
        // blocks the isolated node but before the node-left state is applied, and a health-only probe can then  
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());  
/**
            assertTrue(
 * acknowledged operation. While an in-sync replica survives, promotion wins and the trigger stays out of the way. The  
        String replicaNode = replicaNodeName(INDEX_NAME);
    public void testNoAutoRestoreWithoutSetting() throws Exception {
    /** This suite manages fencing and auto-restore explicitly per index; ignore the suite-wide randomization. */
        // node's post-heal rejoin, which this test does wait for.  
        try (RestoreWindowObserver observer = new RestoreWindowObserver()) {
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
            TimeUnit.SECONDS  
            "the surviving node's primary should have recovered from the remote store",
    }
     * allocation path - and any state in that window whose computed index health was NOT RED. A hydrating primary
                .get(INDEX_NAME)  
    private static final String TOTAL_OPERATIONS = "total-operations";
     * exactly as in the zero-replica case, after which the replica peer-recovers from the restored primary on a
            .filter(name -> name.equals(primaryNode) == false)
        assertBusy(  
     * parked at {@code NO_VALID_SHARD_COPY} with its {@code EXISTING_STORE} source intact (today's RED behavior), and
            () -> assertHitCount(client(clusterManagerNode).prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
                .cluster()
        }
            TimeUnit.SECONDS
        Settings indexSettings = Settings.builder()  
    /**
            // Replica's node first, so no promotion happens in between; then the primary's node - all copies gone.
                }  
        assertBusy(  
    public void testAutoRestoreOnNodeLoss() throws Exception {
/*  
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        );
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
                return;  
        // the primary is STARTED, and it lives on the survivor - are asserted against the SAME observed cluster
        NetworkDisruption networkDisruption = new NetworkDisruption(
        @Override
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
        createIndex(INDEX_NAME, autoRestoreIndexSettings(0, true));
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),  
                .routingTable()  
 * converges to GREEN without operator action, and the restored primary serves every
     * with the restored primary (the rejoined stale copy is dropped, not re-adopted), and the index stays writable.  
                sawRemoteStoreRecoverySource.get()
        }
        assertBusy(  
        internalCluster().startClusterManagerOnlyNode();  
import org.opensearch.cluster.ClusterChangedEvent;
import org.opensearch.cluster.ClusterStateListener;
            clusterService.addListener(this);  
    }  
            assertEquals(RecoverySource.Type.EXISTING_STORE, primary.recoverySource().getType());
                "the allocator should have re-pointed the lost primary at a REMOTE_STORE recovery source",  
        internalCluster().startDataOnlyNodes(2);
        assertBusy(() -> {
                nonRedStatesDuringRestore.isEmpty()  
        RecoveryResponse recoveries = client(clusterManagerNode).admin().indices().prepareRecoveries(INDEX_NAME).get();
                assertTrue("the node-left delay marker should be live", primary.unassignedInfo().isDelayed());  
        refresh(INDEX_NAME);  
        private final ClusterService clusterService;
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
    }
 * {@code NO_VALID_SHARD_COPY}, health stays RED while the restore hydrates (a hydrating primary cannot serve queries;  
        assertBusy(
            .prepareState()
        );
        assertBusy(
        networkDisruption.startDisrupting();  
import org.opensearch.test.disruption.NetworkDisruption;  
            // Only one data node remains, so the replica cannot allocate: the settled state is YELLOW with the
     * the observer records that the window was entered at all - proof the trigger fired rather than some other  
            .getDataNodes()  
            30,
                    recovery -> recovery.getPrimary()  
            .admin()  
import java.util.Set;
        public void close() {  
                        "state version [" + state.version() + "] health [" + health + "] primary [" + primary + "]"
            .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
        internalCluster().startClusterManagerOnlyNode();  
        return Settings.builder()
        createIndex(INDEX_NAME, autoRestoreIndexSettings(0, true));
            // Once the window expires, DelayedAllocationService's reroute clears the marker and the trigger fires.
     * trigger would otherwise abandon. The primary must never carry a {@code REMOTE_STORE} recovery source.
            ClusterState state = client(clusterManagerNode).admin().cluster().prepareState().get().getState();  
            .put(IndexMetadata.SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED, autoRestoreEnabled)
            assertTrue("primary should stay parked unassigned without the auto-restore setting", primary.unassigned());
        assertBusy(
            30,
            30,  
        ensureGreen(INDEX_NAME);  
            );
 * compatible open source license.
        }
import java.util.Map;  
            observer.assertRestoredRedUntilStarted();  
            .get()  
        // the seal; anything it completed before the seal is in the restore point by the metadata-then-CAS ordering).
                    .shard(0)
            new NetworkDisruption.TwoPartitions(liveSide, isolatedSide),
    /**
import org.opensearch.cluster.health.ClusterIndexHealth;
     * {@code index.unassigned.node_left.delayed_timeout}, the conversion is declined while the delay marker is live
     */
import org.opensearch.plugins.Plugin;  
        // accepts new writes.
                .stream()
        // ... and the restored primary accepts new writes.
            .cluster()
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));  
            assertBusy(() -> {
import org.opensearch.index.IndexSettings;
}
 * takeover verified in {@code FenceAutoRestore.tla} and shipped with the fence PR.
import org.opensearch.cluster.ClusterState;  
        );
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
        }
     * test asserts the observable consequences end to end: the restore lands on the surviving node while the old
                .getState()
            .orElseThrow();  
import java.util.List;
     * path today), and fires on the reroute {@code DelayedAllocationService} schedules once the window expires.
            30,
        restore(randomBoolean(), INDEX_NAME);
            TimeUnit.SECONDS  
     * replica promotion and the trigger must never fire - {@code DECIDERS_NO}/promotion territory is real data the  
        refresh(INDEX_NAME);
     * the failover path instead). Losing the replica's node and then the primary's node must therefore auto-restore
 */  
 * when no valid copy of a fenced, remote-backed primary survives on any live node - zero replicas losing its one  
        // The recovery that produced the new primary was a remote-store restore, not any other allocation path.
        String primaryNode = primaryNodeName(INDEX_NAME);  
import org.opensearch.cluster.routing.IndexRoutingTable;  
                .prepareState()  
     * can still reach the object store. The trigger fires on the membership view; the fence takeover at a strictly
 * SPDX-License-Identifier: Apache-2.0
                .anyMatch(
        // The cluster manager expels the isolated primary's node and the trigger restores the shard onto the
                    .index(INDEX_NAME)  
        String primaryNode = primaryNodeName(INDEX_NAME);
            }  
        // serving and accepting writes.
import java.util.stream.Collectors;
        createIndex(INDEX_NAME, autoRestoreIndexSettings(0, false));
            TimeUnit.SECONDS
        // The promoted primary serves every acknowledged operation (promotion replays the remote translog) and
        );  
    }
            assertEquals(UnassignedInfo.AllocationStatus.NO_VALID_SHARD_COPY, primary.unassignedInfo().getLastAllocationStatus());  
        }, 30, TimeUnit.SECONDS);
                    .routingTable()
            ClusterState state = event.state();
        // No acknowledged write was lost to the takeover (the fence refused anything the departed writer tried after  
    }  
            .put(FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), "1s")  
     */
import org.opensearch.common.settings.Settings;
            ensureYellowAndNoInitializingShards(INDEX_NAME);
     * The trigger is replica-count independent: with a replica configured, the allocator only ever reaches
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        // state: a node-count probe that merely counts responders (e.g. nodes-info) passes while the disruption
        public void clusterChanged(ClusterChangedEvent event) {
        private final AtomicBoolean sawRemoteStoreRecoverySource = new AtomicBoolean();  
        }
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),
    @Override
     * which the primary carries a {@code REMOTE_STORE} recovery source (set on conversion, cleared on shard start);
import org.opensearch.test.OpenSearchIntegTestCase;
        indexSingleDoc(INDEX_NAME);
import java.util.HashSet;
            }, 10, TimeUnit.SECONDS);
            TimeUnit.SECONDS
            TimeUnit.SECONDS
 * this file be licensed under the Apache-2.0 license or a
    /**  
            assertFalse(
        client(clusterManagerNode).admin().indices().prepareRefresh(INDEX_NAME).get();
            .nodes()
                assertTrue("restored primary should be started, was " + primary, primary.started());  
            30,  
            TimeUnit.SECONDS
            assertFalse(observer.sawRemoteStoreRecoverySource.get());
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
        ensureGreen(INDEX_NAME);  
        ensureStableCluster(3, TimeValue.timeValueSeconds(60));
        ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);  
 * YELLOW is deferred until warm/searchable-remote shards can serve queries directly off the remote store) and
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
    /**  
    /**
            // The trigger honors the node-left grace window before converting; zero it so these tests exercise  
        internalCluster().startDataOnlyNodes(2, fastFollowerChecks);
import java.util.Collection;  
            .map(node -> node.getName())  
     */
            // immediate conversion. testAutoRestoreWaitsOutNodeLeftDelay covers the non-zero window explicitly.
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
            this.clusterService = internalCluster().getInstance(ClusterService.class, internalCluster().getClusterManagerName());
