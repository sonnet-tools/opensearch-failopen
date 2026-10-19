        // nodes before counting down the latch
        flushAndRefresh(index);
import java.util.Iterator;
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.NO_PREFERENCE, true);
        ensureGreen();
    public void testClusterRelocationPrimaryFirstShardMovementMovePrimarySettingEnabled() throws InterruptedException {
        // Start second node in same zone only after yellow cluster to ensure
    }
                .put("cluster.routing.allocation.exclude.zone", z1)
     * primary or replica shards are moved first, and zone2 nodes have all the shards
        internalCluster().startClusterManagerOnlyNodes(1);
        // Shutdown both nodes in zone 1 and ensure cluster does not become red
        if (shardMovementStrategy == ShardMovementStrategy.NO_PREFERENCE && movePrimaryFirst) {
            Settings.builder()
        for (int i = 0; i < 10; i++) {
public class ShardMovementStrategyTests extends OpenSearchIntegTestCase {
                    .put("max_result_window", 20000)
     * relocating half the number of shards. Shards per node constraint ensures
                if (startedCount == primaryShardCount) {
                            }
                    .put("number_of_replicas", replicaCount)
        );
     */
                Settings.builder()
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(z1n2));
            index(index, "_doc", Integer.toString(startDocCountId), "foo", "bar" + startDocCountId);
    }
        final String z1n2 = startDataOnlyNode(z1);
    private static Settings.Builder getSettings(ShardMovementStrategy shardMovementStrategy, boolean movePrimaryFirst) {
        final ClusterStateListener listener = event -> {
    }
        final String z1n1 = startDataOnlyNode(z1);
import org.opensearch.test.OpenSearchIntegTestCase;
        );
 * SPDX-License-Identifier: Apache-2.0
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.PRIMARY_FIRST, true);
                -1,
        settingsRequest.persistentSettings(
import org.opensearch.cluster.ClusterStateListener;
    public void testClusterRelocationReplicaFirstShardMovementPrimaryFirstDisabled() throws InterruptedException {
        return Settings.builder()
        assertAcked(
        return internalCluster().startDataOnlyNode(settings);
    protected String startDataOnlyNode(final String zone) {
            }
            .put("cluster.routing.allocation.shard_movement_strategy", shardMovementStrategy)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void testClusterRelocationPrimaryFirstShardMovementMovePrimarySettingDisabled() throws InterruptedException {
                            if ((shardEntry.primary() == shouldMovePrimaryShardsFirst(shardMovementStrategy, movePrimaryFirst))
    }
        final String z1 = "zone-1", z2 = "zone-2";
    public void testClusterRelocationReplicaFirstShardMovementPrimaryFirstEnabled() throws InterruptedException {
                                && shardEntry.state() == ShardRoutingState.STARTED) {
 */
                    RoutingNode routingNode = it.next();
        int startDocCountId = 0;
        final String z2n2 = startDataOnlyNode(z2);
            getSettings(shardMovementStrategy, movePrimaryFirst).put("cluster.routing.allocation.exclude.zone", z2)
        return shardMovementStrategy == ShardMovementStrategy.PRIMARY_FIRST;
    private void testClusterGreenAfterPartialRelocation(ShardMovementStrategy shardMovementStrategy, boolean movePrimaryFirst)
     * that exactly 50% of shards relocate to nodes in zone2 giving time to shut down
        try {
        shardMoveLatch.await();
                for (Iterator<RoutingNode> it = routingNodes.iterator(); it.hasNext();) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                        for (ShardRouting shardEntry : routingNode) {
                final RoutingNodes routingNodes = event.state().getRoutingNodes();
        ensureYellow();
                        }
        ensureGreen();
        client().admin().cluster().updateSettings(settingsRequest).actionGet();
        final String z2n1 = startDataOnlyNode(z2);
            if (event.routingTableChanged()) {
        // Since yellow suffices for this test, not removing shards constraint
                        startedCount += count;
                    final String nodeName = routingNode.node().getName();
        }
        }
                    .put("number_of_shards", shardCount)
                    shardMoveLatch.countDown();
                .put("cluster.routing.allocation.total_shards_per_node", primaryShardCount / 2)
                    if (nodeName.equals(z2n1) || nodeName.equals(z2n2)) {
    /**
        final Settings settings = Settings.builder().put("node.attr.zone", zone).build();
package org.opensearch.cluster.routing;
                        int count = 0;
        assertTrue("Primary shard count must be even for equal distribution across two nodes", primaryShardCount % 2 == 0);
    }
        // that one gets all primaries and other all secondaries
    }
                    }
        // zone nodes excluded to prevent any shard relocation
            return true;
        createAndIndex("foo", 1, primaryShardCount);
                index,
            )
 * compatible open source license.
        // Enable cluster level setting for moving primaries first and keep new
/*
     * nodes in zone1. Depending on the shard movement strategy, we check whether the
        internalCluster().clusterService().addListener(listener);
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.PRIMARY_FIRST, false);
            prepareCreate(
                                count++;
                // have relocated to allow time for node shutdown and validate yellow cluster
     * Creates two nodes each in two zones and shuts down nodes in zone1 after
 * The OpenSearch Contributors require contributions made to
 *
        };
 * this file be licensed under the Apache-2.0 license or a
        throws InterruptedException {
    public void testClusterRelocationNoPreferenceShardMovementPrimaryFirstEnabled() throws InterruptedException {
        );
        // Create cluster state listener to compute number of shards on new zone
                            // shards are replicas
                int startedCount = 0;
import java.util.concurrent.CountDownLatch;
                // Count down the latch once all the shards have initialized on nodes in zone-2
        settingsRequest = new ClusterUpdateSettingsRequest();
        // Exclude zone1 nodes for allocation and await latch count down
                            // If shard movement strategy is primary first, asserting that primary shards are moved first; else assert
        // Due to shards per node constraint cluster cannot be green
                // Total shards per node constraint is added to pause the relocation after shards
        } catch (Exception e) {}
import org.opensearch.common.settings.Settings;
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(z1n1));
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.REPLICA_FIRST, false);
                }
                }
    private boolean shouldMovePrimaryShardsFirst(ShardMovementStrategy shardMovementStrategy, boolean movePrimaryFirst) {
    }
import org.opensearch.test.InternalTestCluster;
        settingsRequest.persistentSettings(
        final CountDownLatch shardMoveLatch = new CountDownLatch(1);
    }
            ++startDocCountId;
    }
        final int primaryShardCount = 6;
    }
}
        client().admin().cluster().updateSettings(settingsRequest);
        ClusterUpdateSettingsRequest settingsRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
    protected void createAndIndex(String index, int replicaCount, int shardCount) {
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.REPLICA_FIRST, true);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        ensureYellow();
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            .put("cluster.routing.allocation.move.primary_first", movePrimaryFirst);
