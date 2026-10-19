        // Don't set setting
import static org.opensearch.common.breaker.ResponseLimitSettings.CAT_INDICES_RESPONSE_LIMIT_SETTING;
    }
    }
        // Don't enable limit  
import org.opensearch.common.settings.ClusterSettings;
}
import org.opensearch.cluster.routing.ShardRouting;
        // Don't enable limit
        assertTrue(breached);
        return TestShardRouting.newShardRouting(shardId, randomAlphaOfLength(4), isPrimary, ShardRoutingState.STARTED);  
    public void testIsResponseLimitBreachedForNullRoutingTableExpectNotBreached() {
        final Map<String, IndexRoutingTable> indexRoutingTableMap = new HashMap<>();  
            (Metadata) null,
    }  
 * this file be licensed under the Apache-2.0 license or a
            indexShardRoutingTableBuilder.addShard(primaryShardRouting);
        // Don't set setting  
            final ShardId replicaShardId = new ShardId(index, 1);
        final boolean breached = isBreachedForIndices(settings);
        final boolean breached = isBreachedForIndices(settings);  
    }  
    private static boolean isBreachedForSegments(Settings settings) {
        return breached;
    private static boolean isBreachedForShards(Settings settings) {  
import org.opensearch.test.OpenSearchTestCase;  
    }
    public void testIsResponseLimitBreachedForCatIndicesWithSettingEnabledExpectNotBreached() {  
        assertTrue(breached);  
        final Settings settings = Settings.builder().put(CAT_INDICES_RESPONSE_LIMIT_SETTING.getKey(), 1).build();
        );  
package org.opensearch.common.breaker;
        final Settings settings = Settings.builder().put(CAT_SHARDS_RESPONSE_LIMIT_SETTING.getKey(), -1).build();  
        return ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            IllegalArgumentException.class,
        final Settings settings = Settings.builder().put(CAT_INDICES_RESPONSE_LIMIT_SETTING.getKey(), -1).build();  
        final Settings settings = Settings.builder().build();
            responseLimitSettings.getCatIndicesResponseLimit()  
        assertFalse(breached);
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
        final Metadata.Builder metadata = Metadata.builder();
 */  
        return ResponseLimitSettings.isResponseLimitBreached(
            .metadata(metadata)  
    public void testIsResponseLimitBreachedForNullLimitEntityWithMetadataExpectException() {
            indexRoutingTableMap.put(index.getName(), indexRoutingTable.build());
            0  
    }  
    }
        final Settings settings = Settings.builder().build();
    private static ShardRouting createShardRouting(ShardId shardId, boolean isPrimary) {
            (RoutingTable) null,
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        // Set limit of 1 index  
        // Set limit of 5 indices
        );  
import org.opensearch.cluster.routing.TestShardRouting;
        final Settings settings = Settings.builder().build();
            .routingTable(routingTable)
        assertFalse(breached);  
        );
            final IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index)
        final Settings settings = Settings.builder().put(CAT_INDICES_RESPONSE_LIMIT_SETTING.getKey(), 5).build();
        // Pass cluster state with 3 indices
        }
    }
        for (String index : indices) {  
        final boolean breached = isBreachedForIndices(settings);
    }  
            clusterState.getRoutingTable(),
            () -> ResponseLimitSettings.isResponseLimitBreached(clusterState.getRoutingTable(), null, 4)  
        final boolean breached = isBreachedForShards(settings);
            final ShardId primaryShardId = new ShardId(index, 0);  
    }
        // Set limit of 9 shards
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }  
            0  
    public void testIsResponseLimitBreachedForCatSegmentsWithSettingDisabledExpectNotBreached() {
            indexShardRoutingTableBuilder.addShard(replicaShardRouting);  
import java.util.HashMap;
            () -> ResponseLimitSettings.isResponseLimitBreached(clusterState.getMetadata(), null, 4)
            .build();
            metadata.put(IndexMetadata.builder(index).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0));
        // Set limit of 2 shards
        );
            final IndexShardRoutingTable.Builder indexShardRoutingTableBuilder = new IndexShardRoutingTable.Builder(primaryShardId);
import org.opensearch.core.index.shard.ShardId;
        // Don't enable limit
            ResponseLimitSettings.LimitEntity.SHARDS,
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
        assertFalse(breached);
        assertFalse(breached);  
        // Build cluster state with 3 shards  
    }
    }
import org.opensearch.cluster.routing.IndexRoutingTable;
        return ResponseLimitSettings.isResponseLimitBreached(  
        final RoutingTable routingTable = new RoutingTable(1, indexRoutingTableMap);
/*  
 * compatible open source license.
        assertFalse(breached);
        expectThrows(  
        assertFalse(breached);
        );
import org.opensearch.cluster.ClusterState;
            final ShardRouting primaryShardRouting = createShardRouting(primaryShardId, true);
        assertTrue(breached);  
        final boolean breached = isBreachedForShards(settings);
            ResponseLimitSettings.LimitEntity.INDICES,
            IllegalArgumentException.class,
            ResponseLimitSettings.LimitEntity.INDICES,
        final boolean breached = isBreachedForSegments(settings);
        final boolean breached = ResponseLimitSettings.isResponseLimitBreached(  
    public void testIsResponseLimitBreachedForCatIndicesWithSettingEnabledExpectBreached() {
import org.opensearch.cluster.routing.RoutingTable;
        assertFalse(breached);
import org.opensearch.cluster.metadata.IndexMetadata;  
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);  
                .addShard(replicaShardRouting)  
        final boolean breached = isBreachedForSegments(settings);  
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);  
    public void testIsResponseLimitBreachedForCatIndicesWithSettingDisabledExpectNotBreached() {
        final boolean breached = isBreachedForShards(settings);  
        // Don't set setting
    }
import org.opensearch.core.index.Index;
 * SPDX-License-Identifier: Apache-2.0
    public void testIsResponseLimitBreachedForCatShardsWithSettingEnabledExpectNotBreached() {
            ResponseLimitSettings.LimitEntity.INDICES,
import org.opensearch.Version;
import java.util.Map;  
        final Settings settings = Settings.builder().put(CAT_SHARDS_RESPONSE_LIMIT_SETTING.getKey(), 9).build();  
    }
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testIsResponseLimitBreachedForCatShardsWithSettingEnabledExpectBreached() {  
            responseLimitSettings.getCatShardsResponseLimit()
        // Build cluster state with 3 indices
    private static boolean isBreachedForIndices(final Settings settings) {
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
        final boolean breached = ResponseLimitSettings.isResponseLimitBreached(  
    public void testIsResponseLimitBreachedForCatShardsWithNoSettingPassedExpectNotBreached() {
    }
    private static ClusterState buildClusterState(String... indices) {
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
    }  
    }
import org.opensearch.cluster.metadata.Metadata;
        final Settings settings = Settings.builder().put(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING.getKey(), 1).build();
        final boolean breached = isBreachedForSegments(settings);
        final Settings settings = Settings.builder().put(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING.getKey(), -1).build();
    public void testIsResponseLimitBreachedForNullLimitEntityWithRoutingTableExpectException() {
    public void testIsResponseLimitBreachedForNullMetadataExpectNotBreached() {
 *
            final ShardRouting replicaShardRouting = createShardRouting(replicaShardId, false);  
        final Settings settings = Settings.builder().put(CAT_SHARDS_RESPONSE_LIMIT_SETTING.getKey(), 2).build();
            responseLimitSettings.getCatSegmentsResponseLimit()  
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");  
import static org.opensearch.common.breaker.ResponseLimitSettings.CAT_SHARDS_RESPONSE_LIMIT_SETTING;
        assertFalse(breached);
        final Settings settings = Settings.builder().build();  
        // Set limit of 1 index  
        final boolean breached = ResponseLimitSettings.isResponseLimitBreached(  
        final boolean breached = isBreachedForSegments(settings);  
            clusterState.getMetadata(),
import static org.opensearch.common.breaker.ResponseLimitSettings.CAT_SEGMENTS_RESPONSE_LIMIT_SETTING;  
    public void testIsResponseLimitBreachedForCatSegmentsWithNoSettingPassedExpectNotBreached() {  
    public void testIsResponseLimitBreachedForCatShardsWithSettingDisabledExpectNotBreached() {
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
            final Index index = new Index(s, "uuid");
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * The OpenSearch Contributors require contributions made to  
                .addIndexShard(indexShardRoutingTableBuilder.build());
        }  
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
        );
        // Set limit of 5 indices
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final Settings settings = Settings.builder().build();  
        );
                .addShard(primaryShardRouting)
import org.opensearch.cluster.routing.ShardRoutingState;  
        assertFalse(breached);
import org.opensearch.common.settings.Settings;  
    }
    }  
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
            clusterState.getRoutingTable(),  
        assertFalse(breached);
        assertFalse(breached);
    public void testIsResponseLimitBreachedForCatSegmentsWithSettingEnabledExpectBreached() {
        final boolean breached = isBreachedForShards(settings);
    }
        for (String s : indices) {
        final boolean breached = isBreachedForIndices(settings);  
public class ResponseLimitSettingsTests extends OpenSearchTestCase {  
    public void testIsResponseLimitBreachedForCatIndicesWithNoSettingPassedExpectNotBreached() {  
        expectThrows(
            ResponseLimitSettings.LimitEntity.INDICES,
    public void testIsResponseLimitBreachedForCatSegmentsWithSettingEnabledExpectNotBreached() {  
        final Settings settings = Settings.builder().put(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING.getKey(), 5).build();
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
