        assertTrue(promotedShard.isPrimaryReplicaResyncInProgress());
            client().admin()
        final String replica;
    }
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)
import java.util.Collection;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertTrue(promotedShard.isPrimaryReplicaResyncInProgress());
}
package org.opensearch.index.shard;
        final String primary = primaryNodeName();
     */
        }, 60, TimeUnit.SECONDS);
        final String target;
        final CountDownLatch resyncDropped = new CountDownLatch(1);
                    Settings.builder()
import org.opensearch.action.support.replication.TransportReplicationAction;
        final IndexService indexService = indicesService.indexService(resolveIndex(INDEX));
            resyncDropped.countDown();
    private static final String INDEX = "test";
        assertBusy(() -> assertFalse(promotedShard.isPrimaryReplicaResyncInProgress()), 60, TimeUnit.SECONDS);
    @Override
        futurePrimaryTransport.addRequestHandlingBehavior(RESYNC_PRIMARY_ACTION, (handler, request, channel, task) -> {
 */
        assertNotNull("index not allocated on " + nodeName, indexService);
        final Nodes nodes = startNodesAndCreateIndex();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            TransportService.class,
        // relocation is refused while the resync is pending: the relocation target fails and the primary stays put
     */
            nodes.replica
 * compatible open source license.
        assertBusy(() -> assertPrimaryStartedOn(nodes.replica), 30, TimeUnit.SECONDS);
        final long initialPrimaryTerm = client().admin().cluster().prepareState().get().getState().metadata().index(INDEX).primaryTerm(0);
        final MockTransportService futurePrimaryTransport = (MockTransportService) internalCluster().getInstance(
        ensureGreen(INDEX);
     * Asserts that the primary is started on the given node. Routing and nodes are read from the same cluster
                .prepareUpdateSettings(INDEX)
    /**
        promoteReplica(nodes);
        // the resync timeout clears the flag
        moveToTarget(nodes);
    }
        );
                .cluster()
                        .put("index.routing.allocation.include._name", nodes.replica + "," + nodes.target)
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.plugins.Plugin;
            )
        futurePrimaryTransport.addRequestHandlingBehavior(RESYNC_PRIMARY_ACTION, (handler, request, channel, task) -> {
import org.opensearch.cluster.ClusterState;
 * this file be licensed under the Apache-2.0 license or a
                .setPersistentSettings(Settings.builder().put(RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.getKey(), "20s"))
        futurePrimaryTransport.clearAllRules();
        );
import static org.hamcrest.Matchers.equalTo;
/*
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
     */
     */
 * normally. See <a href="https://github.com/opensearch-project/OpenSearch/issues/21692">#21692</a>.
 * SPDX-License-Identifier: Apache-2.0
            client().admin()
        assertTrue(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        Nodes(String primary, String replica, String target) {
     * re-allocated, and the primary can then be relocated.
        assertRelocatedToTarget(nodes);
        final MockTransportService futurePrimaryTransport = (MockTransportService) internalCluster().getInstance(
        final CountDownLatch resyncFailed = new CountDownLatch(1);
     * data nodes. The third data node is the relocation target.
import java.util.Collections;
    private static final int NUM_DOCS = 100;
        final String nodeB = internalCluster().startDataOnlyNode();
    /**
    }
        // set dynamically so that the test also covers updates of the setting through the cluster settings API
                .prepareReroute()
        // The failed shard is re-allocated from its local store on the same node, with the flag cleared. It keeps its
    private void promoteReplica(Nodes nodes) throws Exception {
        });
            client().admin()
        assertTrue("primary not started: " + primary, primary.started());
 * Verifies that a replica promoted to primary can still be relocated when its primary-replica resync does not complete
     * The resync request on the promoted primary is swallowed without a reply, which is equivalent to a lost transport
     * Stops the primary's node so that the replica is promoted, then allows the shard on the target node only. Zero
        refresh(INDEX);
import org.opensearch.OpenSearchException;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                    .put("index.routing.allocation.include._name", nodeA + "," + nodeB)
        final Nodes nodes = startNodesAndCreateIndex();
            this.primary = primary;
            nodes.replica
    }
        assertAcked(
        final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
    private void assertRelocatedToTarget(Nodes nodes) throws Exception {
        assertHitCount(client().prepareSearch(INDEX).setSize(0).get(), NUM_DOCS);
import org.opensearch.cluster.node.DiscoveryNode;
        }
     * response: neither onResponse nor onFailure ever fires. Relocation must be refused while the resync is pending and
                .cluster()
 *
        // and another for the re-allocation of the failed primary.
                    // reassign the copy lost with the stopped node immediately instead of after the default 1m delay
        futurePrimaryTransport.clearAllRules();
public class PrimaryReplicaResyncIT extends OpenSearchIntegTestCase {
    private String primaryNodeName() {
        }
            prepareCreate(INDEX).setSettings(
     * Starts a cluster-manager node and three data nodes, and creates a one-shard index with one replica on the first two
            // neither handle the request nor reply on the channel
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    }
        );
import org.opensearch.index.IndexService;
     * must succeed once the resync timeout clears the flag.
            TransportService.class,
    private void assertPrimaryStartedOn(String nodeName) {
import org.opensearch.test.OpenSearchIntegTestCase;
        // allocation id, so tell the new shard apart from the promoted one by its primary term: one bump for the promotion
    public void testPrimaryRelocationSucceedsAfterResyncTimeout() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.cluster.routing.ShardRouting;
        assertTrue("resync request was not intercepted", resyncDropped.await(30, TimeUnit.SECONDS));
        for (int i = 0; i < NUM_DOCS; i++) {
        final String target = internalCluster().startDataOnlyNode();
    private Nodes startNodesAndCreateIndex() {
        assertBusy(() -> assertPrimaryStartedOn(nodes.target), 60, TimeUnit.SECONDS);
    }
        final IndexShard promotedShard = getIndexShard(nodes.replica);
                )
        final String primary;
        final IndexShard shard = indexService.getShardOrNull(0);
        return shard;
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
import java.util.concurrent.CountDownLatch;
            final IndexShard shard = getIndexShard(nodes.replica);
        ensureGreen(INDEX);
            this.replica = replica;
        return new Nodes(primary, primary.equals(nodeA) ? nodeB : nodeA, target);
                .add(new MoveAllocationCommand(INDEX, 0, nodes.replica, nodes.target))
            resyncFailed.countDown();
import org.opensearch.indices.recovery.RecoverySettings;
     * state and failures are reported as assertion errors, so this can be used inside {@link #assertBusy}.
        );
        assertRelocatedToTarget(nodes);
    }
    private static final String RESYNC_PRIMARY_ACTION = "internal:index/seq_no/resync" + TransportReplicationAction.PRIMARY_ACTION_SUFFIX;
/**
        assertNotNull("primary on unknown node: " + primary, node);
     * The resync request on the promoted primary fails. The flag must be cleared by onFailure, the shard is failed and
import org.opensearch.indices.IndicesService;
            channel.sendResponse(new OpenSearchException("simulated primary-replica resync failure"));
    private static final class Nodes {
    private IndexShard getIndexShard(String nodeName) {
                .setSettings(
        return state.nodes().get(state.routingTable().index(INDEX).shard(0).primaryShard().currentNodeId()).getName();
        final DiscoveryNode node = state.nodes().get(primary.currentNodeId());
        assertBusy(() -> assertPrimaryStartedOn(nodes.replica), 30, TimeUnit.SECONDS);
            assertPrimaryStartedOn(nodes.replica);
        return Collections.singletonList(MockTransportService.TestPlugin.class);
    }
import org.opensearch.transport.TransportService;
                Settings.builder()
import org.opensearch.test.transport.MockTransportService;
        assertBusy(() -> {
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                    .put("index.unassigned.node_left.delayed_timeout", "0")
    /**
        });
    }
 * The OpenSearch Contributors require contributions made to
        promoteReplica(nodes);
     */
        );
        assertThat(node.getName(), equalTo(nodeName));
            assertFalse(shard.isPrimaryReplicaResyncInProgress());
        assertAcked(
        assertAcked(
                .prepareUpdateSettings()
    }
                .isAcknowledged()
    public void testPrimaryRelocationSucceedsAfterResyncFailure() throws Exception {
            this.target = target;
        assertTrue("resync request was not intercepted", resyncFailed.await(30, TimeUnit.SECONDS));
    /**
            assertThat(shard.getOperationPrimaryTerm(), greaterThanOrEqualTo(initialPrimaryTerm + 2));
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.primary));
                .indices()
    /**
        final String nodeA = internalCluster().startDataOnlyNode();
     * replicas keep the copy lost with the stopped node from claiming the target node before the primary moves there.
        if (nodes.target.equals(primaryNodeName())) {
import java.util.concurrent.TimeUnit;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .get()
            client().prepareIndex(INDEX).setSource("field", "value" + i).get();
        moveToTarget(nodes);
        final ShardRouting primary = state.routingTable().index(INDEX).shard(0).primaryShard();
    private void moveToTarget(Nodes nodes) {
        moveToTarget(nodes);
 */
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
    }
import org.opensearch.test.InternalTestCluster;
import org.opensearch.common.settings.Settings;
        assertNotNull("shard not allocated on " + nodeName, shard);
        }
        internalCluster().startClusterManagerOnlyNode();
            return; // already moved there by a reroute of the allocator
        );
