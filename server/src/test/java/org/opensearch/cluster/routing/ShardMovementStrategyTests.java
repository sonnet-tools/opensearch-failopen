        );
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.NO_PREFERENCE, true);
        final String z1n1 = startDataOnlyNode(z1);
            if (event.routingTableChanged()) {
        internalCluster().clusterService().addListener(listener);  
    }
                    shardMoveLatch.countDown();
                }
     * relocating half the number of shards. Shards per node constraint ensures
        assertAcked(  
                }  
        flushAndRefresh(index);  
        // Shutdown both nodes in zone 1 and ensure cluster does not become red
        final String z2n2 = startDataOnlyNode(z2);
            )
        final int primaryShardCount = 6;
        final String z2n1 = startDataOnlyNode(z2);  
            }
            return true;
import org.opensearch.test.InternalTestCluster;  
        };
        return shardMovementStrategy == ShardMovementStrategy.PRIMARY_FIRST;  
    }
        // Exclude zone1 nodes for allocation and await latch count down
        ensureYellow();  
        // nodes before counting down the latch
}
                for (Iterator<RoutingNode> it = routingNodes.iterator(); it.hasNext();) {
        settingsRequest.persistentSettings(
        try {  
        final String z1n2 = startDataOnlyNode(z1);
        createAndIndex("foo", 1, primaryShardCount);  
                            // If shard movement strategy is primary first, asserting that primary shards are moved first; else assert
                    .put("number_of_replicas", replicaCount)  
                                && shardEntry.state() == ShardRoutingState.STARTED) {
    private static Settings.Builder getSettings(ShardMovementStrategy shardMovementStrategy, boolean movePrimaryFirst) {  
        }
        final Settings settings = Settings.builder().put("node.attr.zone", zone).build();
        client().admin().cluster().updateSettings(settingsRequest).actionGet();
        );  
            .put("cluster.routing.allocation.move.primary_first", movePrimaryFirst);  
        }
                // have relocated to allow time for node shutdown and validate yellow cluster
        ensureYellow();
                int startedCount = 0;  
    }
                    .put("max_result_window", 20000)
        settingsRequest = new ClusterUpdateSettingsRequest();  
    }  
    }
        if (shardMovementStrategy == ShardMovementStrategy.NO_PREFERENCE && movePrimaryFirst) {  
 * The OpenSearch Contributors require contributions made to  
        final ClusterStateListener listener = event -> {  
import java.util.Iterator;  
    private boolean shouldMovePrimaryShardsFirst(ShardMovementStrategy shardMovementStrategy, boolean movePrimaryFirst) {
                    .put("number_of_shards", shardCount)
                        int count = 0;
        // Start second node in same zone only after yellow cluster to ensure
                .put("cluster.routing.allocation.exclude.zone", z1)  
                    }  
        client().admin().cluster().updateSettings(settingsRequest);
package org.opensearch.cluster.routing;
    protected void createAndIndex(String index, int replicaCount, int shardCount) {
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(z1n2));
/*  
            index(index, "_doc", Integer.toString(startDocCountId), "foo", "bar" + startDocCountId);  
                            }  
     */  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
public class ShardMovementStrategyTests extends OpenSearchIntegTestCase {
import org.opensearch.common.settings.Settings;
    }  
        int startDocCountId = 0;
     * Creates two nodes each in two zones and shuts down nodes in zone1 after
            prepareCreate(
import java.util.concurrent.CountDownLatch;
        throws InterruptedException {
                        }
                .put("cluster.routing.allocation.total_shards_per_node", primaryShardCount / 2)  
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.REPLICA_FIRST, false);
                final RoutingNodes routingNodes = event.state().getRoutingNodes();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
    public void testClusterRelocationPrimaryFirstShardMovementMovePrimarySettingDisabled() throws InterruptedException {
        return Settings.builder()
        shardMoveLatch.await();  
                // Count down the latch once all the shards have initialized on nodes in zone-2  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
 *
                Settings.builder()
        final CountDownLatch shardMoveLatch = new CountDownLatch(1);
        ensureGreen();
    public void testClusterRelocationNoPreferenceShardMovementPrimaryFirstEnabled() throws InterruptedException {
        assertTrue("Primary shard count must be even for equal distribution across two nodes", primaryShardCount % 2 == 0);  
                    RoutingNode routingNode = it.next();
    }
 */  
                        for (ShardRouting shardEntry : routingNode) {  
        } catch (Exception e) {}  
        return internalCluster().startDataOnlyNode(settings);
            internalCluster().stopRandomNode(InternalTestCluster.nameFilter(z1n1));
import org.opensearch.test.OpenSearchIntegTestCase;
        );  
        // Enable cluster level setting for moving primaries first and keep new
        settingsRequest.persistentSettings(
    public void testClusterRelocationReplicaFirstShardMovementPrimaryFirstEnabled() throws InterruptedException {
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
    protected String startDataOnlyNode(final String zone) {  
                index,
        ClusterUpdateSettingsRequest settingsRequest = new ClusterUpdateSettingsRequest();  
    public void testClusterRelocationReplicaFirstShardMovementPrimaryFirstDisabled() throws InterruptedException {  
        for (int i = 0; i < 10; i++) {
     * nodes in zone1. Depending on the shard movement strategy, we check whether the
        internalCluster().startClusterManagerOnlyNodes(1);  
                            // shards are replicas
                            if ((shardEntry.primary() == shouldMovePrimaryShardsFirst(shardMovementStrategy, movePrimaryFirst))  
            Settings.builder()
                                count++;
    }  
    }
                // Total shards per node constraint is added to pause the relocation after shards
    public void testClusterRelocationPrimaryFirstShardMovementMovePrimarySettingEnabled() throws InterruptedException {  
        // that one gets all primaries and other all secondaries  
                        startedCount += count;
        final String z1 = "zone-1", z2 = "zone-2";
                    if (nodeName.equals(z2n1) || nodeName.equals(z2n2)) {
        ensureGreen();
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.PRIMARY_FIRST, false);
     * that exactly 50% of shards relocate to nodes in zone2 giving time to shut down  
            .put("cluster.routing.allocation.shard_movement_strategy", shardMovementStrategy)
            ++startDocCountId;
 * SPDX-License-Identifier: Apache-2.0
                    final String nodeName = routingNode.node().getName();  
                -1,  
    /**  
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.REPLICA_FIRST, true);  
import org.opensearch.cluster.ClusterStateListener;
        // Since yellow suffices for this test, not removing shards constraint
 * compatible open source license.
        testClusterGreenAfterPartialRelocation(ShardMovementStrategy.PRIMARY_FIRST, true);
    }
            getSettings(shardMovementStrategy, movePrimaryFirst).put("cluster.routing.allocation.exclude.zone", z2)
        // zone nodes excluded to prevent any shard relocation
        // Create cluster state listener to compute number of shards on new zone  
        // Due to shards per node constraint cluster cannot be green
    private void testClusterGreenAfterPartialRelocation(ShardMovementStrategy shardMovementStrategy, boolean movePrimaryFirst)
     * primary or replica shards are moved first, and zone2 nodes have all the shards
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 * this file be licensed under the Apache-2.0 license or a
                if (startedCount == primaryShardCount) {
