        try (RestoreWindowObserver observer = new RestoreWindowObserver()) {
 * {@code NO_VALID_SHARD_COPY}, health stays RED while the restore hydrates (a hydrating primary cannot serve queries;
        private final AtomicBoolean sawRemoteStoreRecoverySource = new AtomicBoolean();
        // the primary is STARTED, and it lives on the survivor - are asserted against the SAME observed cluster
                "index health must stay RED (a hydrating primary cannot serve queries) until the restored primary starts: "
            .cluster()
                    .get()
        }
        // The promoted primary serves every acknowledged operation (promotion replays the remote translog) and
            // Wait for the node-left state to apply, then assert the shard is parked with its EXISTING_STORE source
import org.opensearch.cluster.routing.RecoverySource;
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.ZERO)
            assertEquals(survivorDataNode, state.nodes().get(primary.currentNodeId()).getName());
        networkDisruption.startDisrupting();
                    .index(INDEX_NAME)
                    );
                .stream()
        assertBusy(
        );
     * path today), and fires on the reroute {@code DelayedAllocationService} schedules once the window expires.
                assertTrue("restored primary should be started, was " + primary, primary.started());
    public void testAutoRestoreWaitsOutNodeLeftDelay() throws Exception {
                .index(INDEX_NAME)
    }
            ClusterState state = client(clusterManagerNode).admin().cluster().prepareState().get().getState();
            30,
    }
        String primaryNode = primaryNodeName(INDEX_NAME);
            assertTrue("primary should stay parked unassigned without the auto-restore setting", primary.unassigned());
     * newly joined node.
                return;
                }
                    .routingTable()
        refresh(INDEX_NAME);
        // state: a node-count probe that merely counts responders (e.g. nodes-info) passes while the disruption
        // Heal the partition: the stale copy on the rejoined node is dropped, not re-adopted, and the index keeps
            NetworkDisruption.DISCONNECT
    /**
            ensureYellowAndNoInitializingShards(INDEX_NAME);
        // their defaults: a DISCONNECT disruption fails the isolated node's leader check immediately anyway, and
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
    /**
            assertEquals(UnassignedInfo.AllocationStatus.NO_VALID_SHARD_COPY, primary.unassignedInfo().getLastAllocationStatus());
        createIndex(INDEX_NAME, autoRestoreIndexSettings(0, true));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.index.translog.Translog;
            this.clusterService = internalCluster().getInstance(ClusterService.class, internalCluster().getClusterManagerName());
import java.util.List;
        // The cluster manager expels the isolated primary's node and the trigger restores the shard onto the
        internalCluster().setDisruptionScheme(networkDisruption);
            );
            .map(node -> node.getName())
                sawRemoteStoreRecoverySource.get()
            }, 60, TimeUnit.SECONDS);
        );
import org.opensearch.cluster.ClusterStateListener;
        );
            // The trigger honors the node-left grace window before converting; zero it so these tests exercise
     * Observes every published cluster state on the cluster manager. The restore window is precisely the states in
            }
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(replicaNode));
            .put(remoteStoreIndexSettings(replicaCount, 1))
            assertBusy(() -> {
import java.util.stream.Stream;
     * trigger would otherwise abandon. The primary must never carry a {@code REMOTE_STORE} recovery source.
     * The partitioned-writer variant - the scenario {@code FenceAutoRestore.tla} refutes for an unfenced trigger: the
            // Once the window expires, DelayedAllocationService's reroute clears the marker and the trigger fires.
                        && survivorDataNode.equals(recovery.getTargetNode().getName())
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
            30,
            ensureYellowAndNoInitializingShards(INDEX_NAME);
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
            ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
        refresh(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
     * primary is alive, every operation acknowledged before the partition is served, the healed cluster converges
        );
        ensureGreen(INDEX_NAME);
        try (RestoreWindowObserver observer = new RestoreWindowObserver()) {
    @Override
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST.name())
                .get()
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
        // A new data node joins: the replica peer-recovers from the auto-restored primary and the index goes GREEN.
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.test.transport.MockTransportService;
    private final class RestoreWindowObserver implements ClusterStateListener, AutoCloseable {
        createIndex(INDEX_NAME, autoRestoreIndexSettings(0, true));
    }
        String primaryNode = primaryNodeName(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode(fastFollowerChecks);
            );
        }
import org.opensearch.test.InternalTestCluster;
            .values()
        internalCluster().startDataOnlyNodes(2);
        }
    public void testAutoRestoreWithPartitionedWriter() throws Exception {
                ClusterHealthStatus health = new ClusterIndexHealth(state.metadata().index(INDEX_NAME), indexRoutingTable).getStatus();
     * cannot serve queries, so health deliberately stays RED until the shard starts (see
     * the failover path instead). Losing the replica's node and then the primary's node must therefore auto-restore
import org.opensearch.cluster.routing.UnassignedInfo;
            // restored primary STARTED and serving.
        // Fast follower checks so the cluster manager expels the partitioned node quickly. Leader checks stay at
import org.opensearch.common.unit.TimeValue;
            .put(IndexMetadata.SETTING_REMOTE_STORE_AUTO_RESTORE_ENABLED, autoRestoreEnabled)
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
     */
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNodeName(INDEX_NAME)));
            30,
     * The control: without {@code index.remote_store.auto_restore.enabled} the trigger must not fire - the shard is
            }, 10, TimeUnit.SECONDS);
import org.opensearch.cluster.routing.IndexRoutingTable;
                assertTrue("the node-left delay marker should be live", primary.unassignedInfo().isDelayed());
            TimeUnit.SECONDS
            TimeUnit.SECONDS
        @Override
     * The trigger is replica-count independent: with a replica configured, the allocator only ever reaches
    private static final String INDEX_NAME = "remote-store-auto-restore-idx";
                if (health != ClusterHealthStatus.RED) {
            // Only one data node remains, so the replica cannot allocate: the settled state is YELLOW with the
        internalCluster().startDataOnlyNode();
        );
     * {@code NO_VALID_SHARD_COPY} when EVERY copy-holding node is gone (a surviving in-sync replica is promoted on
            }
        return Settings.builder()
import org.opensearch.cluster.ClusterChangedEvent;
        );
     * which the primary carries a {@code REMOTE_STORE} recovery source (set on conversion, cleared on shard start);
        createIndex(INDEX_NAME, autoRestoreIndexSettings(0, false));
        internalCluster().startDataOnlyNodes(2, fastFollowerChecks);
        RecoveryResponse recoveries = client(clusterManagerNode).admin().indices().prepareRecoveries(INDEX_NAME).get();
            .getState()
            30,
import org.opensearch.test.OpenSearchIntegTestCase;
            TimeUnit.SECONDS
            TimeUnit.SECONDS
        );
        assertBusy(() -> {
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),
        ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
            .get()
            ClusterState state = event.state();
        internalCluster().startDataOnlyNodes(2);
                .cluster()
        internalCluster().startDataOnlyNodes(2);
        ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),
        // The recovery that produced the new primary was a remote-store restore, not any other allocation path.
 */
                "the trigger must not fire while an in-sync replica is available for promotion",
        internalCluster().startClusterManagerOnlyNode();
            assertFalse(observer.sawRemoteStoreRecoverySource.get());
    public void testReplicaPromotionPreemptsAutoRestore() throws Exception {
        ensureGreen(INDEX_NAME);
    public void testAutoRestoreOnNodeLoss() throws Exception {
            // The in-sync replica is promoted; with only one data node left the replica slot stays unassigned.
            .filter(name -> name.equals(primaryNode) == false)
import java.util.Map;
            .nodes()
                assertEquals(replicaNode, state.nodes().get(primary.currentNodeId()).getName());
            .findFirst()
            TimeUnit.SECONDS
import org.opensearch.cluster.ClusterState;
    /** This suite manages fencing and auto-restore explicitly per index; ignore the suite-wide randomization. */
                .getState()
                    .prepareState()
        assertBusy(
        try (RestoreWindowObserver observer = new RestoreWindowObserver()) {
            clusterService.addListener(this);
            ShardRouting primary = client().admin()
     * (so a bouncing node can rejoin and recover its local copy - a converted primary has no rejoin-cancellation
                .prepareState()
     * parameter: the trigger itself is replica-count independent (it fires on the allocator's no-valid-copy proof,
        String replicaNode = replicaNodeName(INDEX_NAME);
     */
            TimeUnit.SECONDS
        );
        createIndex(INDEX_NAME, indexSettings);
     * {@code REQUEST} durability pins the contract being asserted - every acknowledged operation is in the remote
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.common.settings.Settings;
     * allocation path - and any state in that window whose computed index health was NOT RED. A hydrating primary
        // surviving data node while the old primary is still alive. All three facts - membership shrank to two,
                sawRemoteStoreRecoverySource.set(true);
            if (indexRoutingTable == null) {
        indexSingleDoc(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode();
 * multi-writer safety of the sequence (a departed primary that is still alive behind a partition) rides on the fence
            .stream()
        String primaryNode = primaryNodeName(INDEX_NAME);
        try (RestoreWindowObserver observer = new RestoreWindowObserver()) {
            assertTrue("primary should be restored and started, was " + primary, primary.started());
        // read the stale pre-removal GREEN.
        refresh(INDEX_NAME);
 * converges to GREEN without operator action, and the restored primary serves every
        }
import org.opensearch.index.IndexSettings;
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
        return Stream.concat(super.nodePlugins().stream(), Stream.of(MockTransportService.TestPlugin.class)).collect(Collectors.toList());
            observer.assertRestoredRedUntilStarted();
     * can still reach the object store. The trigger fires on the membership view; the fence takeover at a strictly
        internalCluster().startClusterManagerOnlyNode();
    /**
        internalCluster().startClusterManagerOnlyNode();
            assertTrue(
                nonRedStatesDuringRestore.isEmpty()
        // serving and accepting writes.
     * replica promotion and the trigger must never fire - {@code DECIDERS_NO}/promotion territory is real data the
        ensureStableCluster(3, TimeValue.timeValueSeconds(60));
                .anyMatch(
            // immediate conversion. testAutoRestoreWaitsOutNodeLeftDelay covers the non-zero window explicitly.
                assertEquals(RecoverySource.Type.EXISTING_STORE, primary.recoverySource().getType());
 * node, or N replicas losing every copy-holding node - the shard is re-pointed at a
        private final ClusterService clusterService;
        );
        ensureGreen(INDEX_NAME);
        ensureGreen(INDEX_NAME);
     */
            TimeUnit.SECONDS
        RestoreWindowObserver() {
            recoveries.shardRecoveryStates()
     * higher term is what stops the departed writer acknowledging operations the restored copy will never see. The
            observer.assertRestoredRedUntilStarted();
        refresh(INDEX_NAME);
     * The headline flow: kill the node holding a fenced zero-replica primary and assert the shard auto-restores from
                "the allocator should have re-pointed the lost primary at a REMOTE_STORE recovery source",
            // and a live delay marker. Deterministic: the conversion cannot legally happen before the 15s window
public class RemoteStoreAutoRestoreIT extends RemoteStoreBaseIntegTestCase {
import org.opensearch.cluster.health.ClusterIndexHealth;
        String survivorDataNode = internalCluster().client(clusterManagerNode)
 * takeover verified in {@code FenceAutoRestore.tla} and shipped with the fence PR.
        client(clusterManagerNode).admin().indices().prepareRefresh(INDEX_NAME).get();
        networkDisruption.stopDisrupting();
    @Override
import java.util.HashSet;
                ShardRouting primary = client().admin()
import org.opensearch.cluster.health.ClusterHealthStatus;
 * SPDX-License-Identifier: Apache-2.0
        indexSingleDoc(INDEX_NAME);
        // ... and the restored primary accepts new writes.
            .admin()
     */
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
     * the remote store - RED (deliberately, a hydrating primary cannot serve queries) for every published cluster
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
        // accepts new writes.
            }, 60, TimeUnit.SECONDS);
 *
        return false;
/**
                    recovery -> recovery.getPrimary()
                        && recovery.getRecoverySource().getType() == RecoverySource.Type.REMOTE_STORE
        assertBusy(() -> {
                    nonRedStatesDuringRestore.add(
        internalCluster().startDataOnlyNodes(2);
import org.opensearch.cluster.coordination.FollowersChecker;
            .put(FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING.getKey(), "1s")
        createIndex(INDEX_NAME, autoRestoreIndexSettings(1, true));
        // the seal; anything it completed before the seal is in the restore point by the metadata-then-CAS ordering).
        );
import org.opensearch.plugins.Plugin;
            30,
        private final List<String> nonRedStatesDuringRestore = new CopyOnWriteArrayList<>();
    protected boolean remoteStoreFencingForAllIndices() {
            // Replica's node first, so no promotion happens in between; then the primary's node - all copies gone.
    }
                    .getState()
        assertTrue(
        }
            }
     */
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
                    .cluster()
        // The manual operator path is unaffected by the (disabled) trigger.
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),
import org.opensearch.cluster.routing.ShardRouting;
        }
     * old primary is not dead, only expelled from the cluster manager's view, and (on a shared filesystem repository)
            if (primary == null || primary.recoverySource() == null) {
 * this file be licensed under the Apache-2.0 license or a
                    + nonRedStatesDuringRestore,
                ClusterState state = client(internalCluster().getClusterManagerName()).admin().cluster().prepareState().get().getState();
        public void clusterChanged(ClusterChangedEvent event) {
            TimeUnit.SECONDS
            ShardRouting primary = indexRoutingTable.shard(0).primaryShard();
import org.opensearch.test.disruption.NetworkDisruption;
 * End-to-end coverage for the auto-restore trigger ({@code BaseGatewayShardAllocator#maybeAutoRestoreFromRemoteStore}):
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
     * parked at {@code NO_VALID_SHARD_COPY} with its {@code EXISTING_STORE} source intact (today's RED behavior), and
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        assertBusy(
        }, 30, TimeUnit.SECONDS);
                .get(INDEX_NAME)
            30,
import java.util.Collection;
            .build();
    }
            .build();
        void assertTriggerNeverFired() {
        String primaryNode = primaryNodeName(INDEX_NAME);
        Set<String> liveSide = Stream.of(clusterManagerNode, survivorDataNode).collect(Collectors.toCollection(HashSet::new));
     * The trigger honors the node-left grace window: with a non-zero
        NetworkDisruption networkDisruption = new NetworkDisruption(
        String clusterManagerNode = internalCluster().getClusterManagerName();
            // expires, and this assertBusy caps at 10s.
        }
                    .shard(0)
    }
        internalCluster().clearDisruptionScheme();
}
    /**
        public void close() {
        }, 60, TimeUnit.SECONDS);
        );
        refresh(INDEX_NAME);
        // blocks the isolated node but before the node-left state is applied, and a health-only probe can then
                .primaryShard();
     * exactly as in the zero-replica case, after which the replica peer-recovers from the restored primary on a
            "the surviving node's primary should have recovered from the remote store",
        assertBusy(
                ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
            .put(autoRestoreIndexSettings(0, true))
            .put(UnassignedInfo.INDEX_DELAYED_NODE_LEFT_TIMEOUT_SETTING.getKey(), TimeValue.timeValueSeconds(15))
import org.opensearch.cluster.service.ClusterService;
import java.util.concurrent.atomic.AtomicBoolean;
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
            ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
        indexSingleDoc(INDEX_NAME);
            TimeUnit.SECONDS
    /**
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS) + 1),
            () -> assertHitCount(client(clusterManagerNode).prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
            assertEquals(RecoverySource.Type.EXISTING_STORE, primary.recoverySource().getType());
            .orElseThrow();
            observer.assertTriggerNeverFired();
 * The OpenSearch Contributors require contributions made to
            .put(FollowersChecker.FOLLOWER_CHECK_RETRY_COUNT_SETTING.getKey(), 1)
            .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
        assertBusy(
            30,
            TimeUnit.SECONDS
        refresh(INDEX_NAME);
        Map<String, Long> indexStats = indexData(randomIntBetween(2, 4), true, INDEX_NAME);
import java.util.Set;
        // Every acknowledged operation survived the node loss ...
        assertBusy(
                        "state version [" + state.version() + "] health [" + health + "] primary [" + primary + "]"
    }
        ensureRed(INDEX_NAME);
    }
            .prepareState()
     * translog, so the restored primary must serve all of them. The replica count is the test's failure-domain
 * {@link RecoverySource.RemoteStoreRecoverySource} inside the allocation round instead of being parked RED at
                )
                .shard(0)
        void assertRestoredRedUntilStarted() {
        ensureGreen(INDEX_NAME);
        Settings indexSettings = Settings.builder()
            observer.assertRestoredRedUntilStarted();
 * when no valid copy of a fenced, remote-backed primary survives on any live node - zero replicas losing its one
            assertTrue(
        indexSingleDoc(INDEX_NAME);
            30,
        }
                assertTrue("primary should be parked during the node-left grace window, was " + primary, primary.unassigned());
                sawRemoteStoreRecoverySource.get()
                assertTrue("promoted primary should be started, was " + primary, primary.started());
        // node's post-heal rejoin, which this test does wait for.
     * the observer records that the window was entered at all - proof the trigger fired rather than some other
            IndexRoutingTable indexRoutingTable = state.routingTable().index(INDEX_NAME);
                .routingTable()
        String replicaNode = replicaNodeName(INDEX_NAME);
            assertEquals("isolated node should be expelled from the cluster manager's view", 2, state.nodes().getSize());
    /**
                    .primaryShard();
import java.util.concurrent.TimeUnit;
     * The boundary from the other side: while an in-sync replica survives, losing the primary's node is handled by
        assertBusy(
     */
     * action, all acknowledged operations present, and the index writable again.
import java.util.concurrent.CopyOnWriteArrayList;
        refresh(INDEX_NAME);
        assertBusy(
     * test asserts the observable consequences end to end: the restore lands on the surviving node while the old
        refresh(INDEX_NAME);
        refresh(INDEX_NAME);
     * the operator's manual {@code _remotestore/_restore} path still recovers it.
     * which with replicas configured requires every copy-holding node to be gone).
        );
    public void testNoAutoRestoreWithoutSetting() throws Exception {
 */
        internalCluster().startDataOnlyNodes(3);
                ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        @Override
        ensureGreen(TimeValue.timeValueSeconds(60), INDEX_NAME);
     */
        // slowing them (as PrimaryTermValidationIT does to keep its stale primary deluded) would also delay the
    /**
    public void testAutoRestoreWithReplicaWhenAllCopiesLost() throws Exception {
            () -> assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), indexStats.get(TOTAL_OPERATIONS)),
import java.util.stream.Collectors;
     */
            if (primary.recoverySource().getType() == RecoverySource.Type.REMOTE_STORE) {
    }
            new NetworkDisruption.TwoPartitions(liveSide, isolatedSide),
package org.opensearch.remotestore;
        ensureGreen(INDEX_NAME);
            clusterService.removeListener(this);
            30,
 * acknowledged operation. While an in-sync replica survives, promotion wins and the trigger stays out of the way. The
            );
        Set<String> isolatedSide = Stream.of(primaryNode).collect(Collectors.toCollection(HashSet::new));
            .build();
    private static final String TOTAL_OPERATIONS = "total-operations";
        // No acknowledged write was lost to the takeover (the fence refused anything the departed writer tried after
        restore(randomBoolean(), INDEX_NAME);
     * {@code ClusterShardHealth#getInactivePrimaryHealth}); YELLOW would overstate availability.
                ClusterState state = client().admin().cluster().prepareState().get().getState();
            assertFalse(
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(primaryNode));
        createIndex(INDEX_NAME, autoRestoreIndexSettings(1, true));
        assertBusy(
    private Settings autoRestoreIndexSettings(int replicaCount, boolean autoRestoreEnabled) {
     * {@code index.unassigned.node_left.delayed_timeout}, the conversion is declined while the delay marker is live
        Settings fastFollowerChecks = Settings.builder()
            ShardRouting primary = state.routingTable().index(INDEX_NAME).shard(0).primaryShard();
        internalCluster().startClusterManagerOnlyNode();
 * YELLOW is deferred until warm/searchable-remote shards can serve queries directly off the remote store) and
        assertBusy(
            assertBusy(() -> {
     * state in which the shard carries a {@code REMOTE_STORE} recovery source, GREEN once hydrated with no operator
            .getDataNodes()
     * with the restored primary (the rejoined stale copy is dropped, not re-adopted), and the index stays writable.
            30,
    }
        }
        String primaryNode = primaryNodeName(INDEX_NAME);
    /**
/*
            .put(FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING.getKey(), "1s")
                return;
 * compatible open source license.
            assertBusy(() -> {
