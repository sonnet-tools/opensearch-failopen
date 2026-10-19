import java.util.List;  
            List<ShardRouting> CurrentShardRoutings = event.state().routingTable().allShards(index);
    /**  
import java.util.HashMap;
    public static Settings buildDisabledAllocationSettings() {  
            }
import org.opensearch.common.SuppressForbidden;
            if (relocationCompleted) {  
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
    }
    /**  
import static org.opensearch.index.IndexModule.TieringState.WARM;  
 * SPDX-License-Identifier: Apache-2.0
                    relocationCompleted = false;
        }
        Map<String, Object> expectedSettings = new HashMap<>();
            return shard.started() && isShardFoundOnWarmNode;  
import java.util.concurrent.CountDownLatch;
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;  
    /**
     */
    public static Map<String, Object> getExpectedWarmIndexSettings() {
        expectedSettings.put(IS_WARM_INDEX_SETTING.getKey(), true);  
            .build();
            }
        }  
    }
            .put("cluster.routing.allocation.node_concurrent_recoveries", concurrentRecoveries)
    }
                    break;  
                return;  
            for (ShardRouting shard : CurrentShardRoutings) {
            .put("cluster.routing.allocation.node_concurrent_incoming_recoveries", 0)  
        expectedSettings.put(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "default");
        expectedSettings.put(IS_WARM_INDEX_SETTING.getKey(), false);  
import org.opensearch.cluster.ClusterStateListener;  
     * Verifies warm index settings after migration
import org.opensearch.cluster.ClusterChangedEvent;
}
import static org.opensearch.index.IndexModule.TieringState.WARM_TO_HOT;
     */  
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
            .put("cluster.routing.allocation.node_concurrent_recoveries", 0)
public class TieringTestUtils {  
            if (shard.unassigned()) {
        expectedSettings.put(INDEX_TIERING_STATE.getKey(), WARM);
import org.opensearch.cluster.ClusterState;
     * @return Map of setting key-value pairs that should be validated in the test
        Map<String, Object> expectedSettings = new HashMap<>();
    }
        public MockTieringCompletionListener(final CountDownLatch latch, final String index, String migrationType) {
        expectedSettings.put(INDEX_TIERING_STATE.getKey(), HOT);
     * @return Map of setting key-value pairs that should be validated in the test
    }  
    @SuppressForbidden(reason = "Best effort sleep to allow async tiering operations to proceed")
                }
     */  
        protected final String index;
        return Settings.builder()  
    public static class MockTieringCompletionListener implements ClusterStateListener {
import static org.opensearch.index.IndexModule.TieringState.HOT;
                return false;  
        return Settings.builder()
            if (!event.state().routingTable().hasIndex(index)) {
     * Listener that waits for migration to be removed for an index and counts down latch  
 */  
            this.index = index;  
import org.opensearch.common.settings.Settings;  
        expectedSettings.put(INDEX_COMPOSITE_STORE_TYPE_SETTING.getKey(), "tiered-storage");
        return expectedSettings;  
            .build();
                    || migrationType.equals(WARM_TO_HOT.toString()) && isShardInWarmNode(shard, event.state())) {
        protected boolean isShardInWarmNode(final ShardRouting shard, final ClusterState clusterState) {
import java.util.Map;
     * Verifies warm index settings after migration
            .put("cluster.routing.allocation.node_concurrent_incoming_recoveries", concurrentRecoveries)
    }
    public static Settings buildEnabledAllocationSettings(int concurrentRecoveries) {
            }
            }
        return expectedSettings;  
        @Override  
import org.opensearch.cluster.routing.ShardRouting;
            this.countDownLatch = latch;
    public static void safeSleep(long millis) throws InterruptedException {
 *
            .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", concurrentRecoveries)  
 * compatible open source license.
                countDownLatch.countDown();
 * The OpenSearch Contributors require contributions made to  
            this.migrationType = migrationType;
 * this file be licensed under the Apache-2.0 license or a
        }
/*  
import static org.opensearch.index.IndexModule.INDEX_COMPOSITE_STORE_TYPE_SETTING;
        Thread.sleep(millis);  
                if (migrationType.equals(HOT_TO_WARM.toString()) && !isShardInWarmNode(shard, event.state())  
            .put("cluster.routing.allocation.node_concurrent_outgoing_recoveries", 0)
            final boolean isShardFoundOnWarmNode = clusterState.getNodes().get(shard.currentNodeId()).isWarmNode();
package org.opensearch.storage.tiering;
        protected final CountDownLatch countDownLatch;  
        protected final String migrationType;
            boolean relocationCompleted = true;
        public void clusterChanged(ClusterChangedEvent event) {
    public static Map<String, Object> getExpectedHotIndexSettings() {
