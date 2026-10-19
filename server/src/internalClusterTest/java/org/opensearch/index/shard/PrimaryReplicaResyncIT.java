 * The OpenSearch Contributors require contributions made to  
}  
            this.target = target;  
    }
                .cluster()
    private void moveToTarget(Nodes nodes) {
        refresh(INDEX);
     */
import org.opensearch.cluster.routing.ShardRouting;
        final String primary = primaryNodeName();  
        assertThat(node.getName(), equalTo(nodeName));
                    .put("index.unassigned.node_left.delayed_timeout", "0")  
        ensureGreen(INDEX);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
     * replicas keep the copy lost with the stopped node from claiming the target node before the primary moves there.  
        assertNotNull("primary on unknown node: " + primary, node);  
        final CountDownLatch resyncFailed = new CountDownLatch(1);
        assertBusy(() -> assertPrimaryStartedOn(nodes.target), 60, TimeUnit.SECONDS);
        final IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
        final long initialPrimaryTerm = client().admin().cluster().prepareState().get().getState().metadata().index(INDEX).primaryTerm(0);  
    }
                Settings.builder()
        }  
            client().admin()
            // neither handle the request nor reply on the channel  
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        futurePrimaryTransport.addRequestHandlingBehavior(RESYNC_PRIMARY_ACTION, (handler, request, channel, task) -> {
            assertPrimaryStartedOn(nodes.replica);  
    }
     */
        futurePrimaryTransport.addRequestHandlingBehavior(RESYNC_PRIMARY_ACTION, (handler, request, channel, task) -> {
        final String target;
    /**  
        Nodes(String primary, String replica, String target) {  
 * normally. See <a href="https://github.com/opensearch-project/OpenSearch/issues/21692">#21692</a>.
                .setPersistentSettings(Settings.builder().put(RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.getKey(), "20s"))  
            this.replica = replica;
        ensureGreen(INDEX);  
                        .put("index.routing.allocation.include._name", nodes.replica + "," + nodes.target)  
            final IndexShard shard = getIndexShard(nodes.replica);
import org.opensearch.test.OpenSearchIntegTestCase;
        moveToTarget(nodes);  
import java.util.concurrent.TimeUnit;
    private String primaryNodeName() {
    private static final String INDEX = "test";  
        assertAcked(
    }
        );
                .add(new MoveAllocationCommand(INDEX, 0, nodes.replica, nodes.target))
import org.opensearch.transport.TransportService;  
        }
import org.opensearch.common.settings.Settings;
        }, 60, TimeUnit.SECONDS);
        });
    private Nodes startNodesAndCreateIndex() {
            return; // already moved there by a reroute of the allocator
        moveToTarget(nodes);
        return new Nodes(primary, primary.equals(nodeA) ? nodeB : nodeA, target);
import org.opensearch.test.InternalTestCluster;  
     * data nodes. The third data node is the relocation target.  
        assertBusy(() -> assertFalse(promotedShard.isPrimaryReplicaResyncInProgress()), 60, TimeUnit.SECONDS);  
        );  
        final String nodeB = internalCluster().startDataOnlyNode();
                    Settings.builder()
        assertNotNull("shard not allocated on " + nodeName, shard);  
 */  
import org.opensearch.indices.IndicesService;  
        assertBusy(() -> {
import org.opensearch.plugins.Plugin;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        return shard;
                .get()
            TransportService.class,
import org.opensearch.cluster.node.DiscoveryNode;
        assertTrue(promotedShard.isPrimaryReplicaResyncInProgress());  
        final DiscoveryNode node = state.nodes().get(primary.currentNodeId());
        promoteReplica(nodes);
    }
                .prepareUpdateSettings()
        final IndexShard shard = indexService.getShardOrNull(0);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
    private IndexShard getIndexShard(String nodeName) {
        final ShardRouting primary = state.routingTable().index(INDEX).shard(0).primaryShard();  
    }
     * The resync request on the promoted primary is swallowed without a reply, which is equivalent to a lost transport
    /**  
            assertFalse(shard.isPrimaryReplicaResyncInProgress());  
        assertTrue("resync request was not intercepted", resyncFailed.await(30, TimeUnit.SECONDS));
            prepareCreate(INDEX).setSettings(  
        final CountDownLatch resyncDropped = new CountDownLatch(1);  
        );
        final IndexService indexService = indicesService.indexService(resolveIndex(INDEX));  
        // relocation is refused while the resync is pending: the relocation target fails and the primary stays put  
import java.util.Collections;  
    /**
     */
            client().prepareIndex(INDEX).setSource("field", "value" + i).get();
 *
        assertBusy(() -> assertPrimaryStartedOn(nodes.replica), 30, TimeUnit.SECONDS);
                    // reassign the copy lost with the stopped node immediately instead of after the default 1m delay
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            nodes.replica  
    public void testPrimaryRelocationSucceedsAfterResyncTimeout() throws Exception {
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
                .prepareReroute()  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        // set dynamically so that the test also covers updates of the setting through the cluster settings API
        }
            channel.sendResponse(new OpenSearchException("simulated primary-replica resync failure"));
        // the resync timeout clears the flag
import java.util.Collection;
        for (int i = 0; i < NUM_DOCS; i++) {
import java.util.concurrent.CountDownLatch;
        final IndexShard promotedShard = getIndexShard(nodes.replica);  
        // allocation id, so tell the new shard apart from the promoted one by its primary term: one bump for the promotion  
        // and another for the re-allocation of the failed primary.
            nodes.replica
        );
            assertThat(shard.getOperationPrimaryTerm(), greaterThanOrEqualTo(initialPrimaryTerm + 2));
        assertTrue("primary not started: " + primary, primary.started());
                .cluster()
import org.opensearch.OpenSearchException;
     * The resync request on the promoted primary fails. The flag must be cleared by onFailure, the shard is failed and
        final Nodes nodes = startNodesAndCreateIndex();  
/*  
        });
                )
            client().admin()  
        assertRelocatedToTarget(nodes);
import static org.hamcrest.Matchers.equalTo;
        final String replica;  
        internalCluster().stopRandomNode(InternalTestCluster.nameFilter(nodes.primary));  
package org.opensearch.index.shard;
                .indices()
    }
                .isAcknowledged()  
        assertNotNull("index not allocated on " + nodeName, indexService);
            )
        if (nodes.target.equals(primaryNodeName())) {  
        assertAcked(
 * compatible open source license.
    /**
import org.opensearch.test.transport.MockTransportService;
            TransportService.class,
        );
import org.opensearch.cluster.ClusterState;  
        futurePrimaryTransport.clearAllRules();
            this.primary = primary;
    }
        // The failed shard is re-allocated from its local store on the same node, with the flag cleared. It keeps its
    }
    /**
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
        internalCluster().startClusterManagerOnlyNode();  
    private void assertPrimaryStartedOn(String nodeName) {
                    .put(SETTING_NUMBER_OF_REPLICAS, 1)  
        assertTrue(promotedShard.isPrimaryReplicaResyncInProgress());
                .setSettings(  
     * Stops the primary's node so that the replica is promoted, then allows the shard on the target node only. Zero
        final MockTransportService futurePrimaryTransport = (MockTransportService) internalCluster().getInstance(  
            resyncDropped.countDown();
 * this file be licensed under the Apache-2.0 license or a
     */  
        assertHitCount(client().prepareSearch(INDEX).setSize(0).get(), NUM_DOCS);
        );
     * response: neither onResponse nor onFailure ever fires. Relocation must be refused while the resync is pending and
     * Asserts that the primary is started on the given node. Routing and nodes are read from the same cluster
 */
                .prepareUpdateSettings(INDEX)
        final String target = internalCluster().startDataOnlyNode();  
 * Verifies that a replica promoted to primary can still be relocated when its primary-replica resync does not complete  
        assertBusy(() -> assertPrimaryStartedOn(nodes.replica), 30, TimeUnit.SECONDS);
     * Starts a cluster-manager node and three data nodes, and creates a one-shard index with one replica on the first two
        promoteReplica(nodes);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            client().admin()  
    public void testPrimaryRelocationSucceedsAfterResyncFailure() throws Exception {
        futurePrimaryTransport.clearAllRules();  
        final ClusterState state = client().admin().cluster().prepareState().get().getState();
import org.opensearch.index.IndexService;
                        .put(SETTING_NUMBER_OF_REPLICAS, 0)
        final String primary;
    private void assertRelocatedToTarget(Nodes nodes) throws Exception {
 * SPDX-License-Identifier: Apache-2.0
                    .put("index.routing.allocation.include._name", nodeA + "," + nodeB)
        final MockTransportService futurePrimaryTransport = (MockTransportService) internalCluster().getInstance(
            resyncFailed.countDown();  
    private static final String RESYNC_PRIMARY_ACTION = "internal:index/seq_no/resync" + TransportReplicationAction.PRIMARY_ACTION_SUFFIX;
public class PrimaryReplicaResyncIT extends OpenSearchIntegTestCase {
        final Nodes nodes = startNodesAndCreateIndex();  
    @Override
        assertTrue("resync request was not intercepted", resyncDropped.await(30, TimeUnit.SECONDS));
        return state.nodes().get(state.routingTable().index(INDEX).shard(0).primaryShard().currentNodeId()).getName();  
import org.opensearch.action.support.replication.TransportReplicationAction;
        assertAcked(
    private static final int NUM_DOCS = 100;
    }
/**
     */
        assertTrue(  
     * must succeed once the resync timeout clears the flag.  
        return Collections.singletonList(MockTransportService.TestPlugin.class);  
        moveToTarget(nodes);  
        assertRelocatedToTarget(nodes);
    private static final class Nodes {
    private void promoteReplica(Nodes nodes) throws Exception {
     * re-allocated, and the primary can then be relocated.  
import org.opensearch.indices.recovery.RecoverySettings;
        final String nodeA = internalCluster().startDataOnlyNode();
                    .put(SETTING_NUMBER_OF_SHARDS, 1)
     * state and failures are reported as assertion errors, so this can be used inside {@link #assertBusy}.
