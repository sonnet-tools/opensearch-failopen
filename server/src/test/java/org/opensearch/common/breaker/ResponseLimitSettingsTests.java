        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
import org.opensearch.cluster.routing.ShardRouting;
}
        final Settings settings = Settings.builder().build();
        final Settings settings = Settings.builder().put(CAT_INDICES_RESPONSE_LIMIT_SETTING.getKey(), 5).build();
            final Index index = new Index(s, "uuid");
        final boolean breached = ResponseLimitSettings.isResponseLimitBreached(
            IllegalArgumentException.class,
        final Settings settings = Settings.builder().put(CAT_SHARDS_RESPONSE_LIMIT_SETTING.getKey(), 2).build();
 */
            indexShardRoutingTableBuilder.addShard(replicaShardRouting);
        for (String s : indices) {
            .build();
        final Settings settings = Settings.builder().put(CAT_SHARDS_RESPONSE_LIMIT_SETTING.getKey(), 9).build();
        final boolean breached = isBreachedForShards(settings);
    }
        // Set limit of 1 index
        // Don't set setting
        // Pass cluster state with 3 indices
            clusterState.getRoutingTable(),
        final boolean breached = isBreachedForShards(settings);
        final boolean breached = isBreachedForSegments(settings);
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
import org.opensearch.common.settings.Settings;
        final Settings settings = Settings.builder().put(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING.getKey(), -1).build();
        return TestShardRouting.newShardRouting(shardId, randomAlphaOfLength(4), isPrimary, ShardRoutingState.STARTED);
    }
import org.opensearch.core.index.Index;
            final ShardId replicaShardId = new ShardId(index, 1);
            .metadata(metadata)
            (Metadata) null,
    private static boolean isBreachedForIndices(final Settings settings) {
        assertFalse(breached);
        final boolean breached = isBreachedForShards(settings);
            indexShardRoutingTableBuilder.addShard(primaryShardRouting);
    }
        );
        final Settings settings = Settings.builder().build();
        final boolean breached = isBreachedForIndices(settings);
        // Set limit of 5 indices
import org.opensearch.core.index.shard.ShardId;
        final boolean breached = isBreachedForIndices(settings);
import org.opensearch.cluster.metadata.IndexMetadata;
            ResponseLimitSettings.LimitEntity.INDICES,
    }
    public void testIsResponseLimitBreachedForNullRoutingTableExpectNotBreached() {
        final Settings settings = Settings.builder().build();
        final boolean breached = ResponseLimitSettings.isResponseLimitBreached(
    }
        // Don't enable limit
        assertFalse(breached);
        return breached;
        // Set limit of 5 indices
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
    }
        final Settings settings = Settings.builder().build();
    private static ShardRouting createShardRouting(ShardId shardId, boolean isPrimary) {
        assertFalse(breached);
    }
        // Don't enable limit
        for (String index : indices) {
    public void testIsResponseLimitBreachedForNullLimitEntityWithRoutingTableExpectException() {
import org.opensearch.cluster.routing.IndexRoutingTable;
        // Build cluster state with 3 indices
            ResponseLimitSettings.LimitEntity.INDICES,
    public void testIsResponseLimitBreachedForCatSegmentsWithNoSettingPassedExpectNotBreached() {
                .addShard(replicaShardRouting)
    }
        expectThrows(
        assertTrue(breached);
            IllegalArgumentException.class,
    }
        return ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final Settings settings = Settings.builder().put(CAT_SHARDS_RESPONSE_LIMIT_SETTING.getKey(), -1).build();
 * The OpenSearch Contributors require contributions made to
            clusterState.getMetadata(),
        );
        assertFalse(breached);
            ResponseLimitSettings.LimitEntity.SHARDS,
            ResponseLimitSettings.LimitEntity.INDICES,
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
        final Metadata.Builder metadata = Metadata.builder();
                .addShard(primaryShardRouting)
import static org.opensearch.common.breaker.ResponseLimitSettings.CAT_SEGMENTS_RESPONSE_LIMIT_SETTING;
        assertFalse(breached);
        // Set limit of 9 shards
        assertFalse(breached);
        return ResponseLimitSettings.isResponseLimitBreached(
        final boolean breached = ResponseLimitSettings.isResponseLimitBreached(
import static org.opensearch.common.breaker.ResponseLimitSettings.CAT_SHARDS_RESPONSE_LIMIT_SETTING;
 *
    }
        );
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
    public void testIsResponseLimitBreachedForCatIndicesWithNoSettingPassedExpectNotBreached() {
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
            final IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(index)
    private static boolean isBreachedForShards(Settings settings) {
            final ShardRouting primaryShardRouting = createShardRouting(primaryShardId, true);
        // Build cluster state with 3 shards
        final boolean breached = isBreachedForSegments(settings);
            final ShardId primaryShardId = new ShardId(index, 0);
        assertFalse(breached);
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
 * this file be licensed under the Apache-2.0 license or a
            (RoutingTable) null,
import org.opensearch.cluster.routing.ShardRoutingState;
        );
import org.opensearch.common.settings.ClusterSettings;
    public void testIsResponseLimitBreachedForCatShardsWithSettingDisabledExpectNotBreached() {
            () -> ResponseLimitSettings.isResponseLimitBreached(clusterState.getRoutingTable(), null, 4)
import org.opensearch.cluster.routing.RoutingTable;
 * compatible open source license.
        final boolean breached = isBreachedForShards(settings);
import org.opensearch.cluster.routing.TestShardRouting;
    public void testIsResponseLimitBreachedForCatSegmentsWithSettingDisabledExpectNotBreached() {
            responseLimitSettings.getCatIndicesResponseLimit()
        final boolean breached = isBreachedForIndices(settings);
        final Settings settings = Settings.builder().put(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING.getKey(), 1).build();
package org.opensearch.common.breaker;
    public void testIsResponseLimitBreachedForCatSegmentsWithSettingEnabledExpectBreached() {
    public void testIsResponseLimitBreachedForCatShardsWithNoSettingPassedExpectNotBreached() {
    public void testIsResponseLimitBreachedForNullLimitEntityWithMetadataExpectException() {
        );
            responseLimitSettings.getCatSegmentsResponseLimit()
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
 * SPDX-License-Identifier: Apache-2.0
    }
            0
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final boolean breached = isBreachedForSegments(settings);
    }
                .addIndexShard(indexShardRoutingTableBuilder.build());
    }
public class ResponseLimitSettingsTests extends OpenSearchTestCase {
    }
            responseLimitSettings.getCatShardsResponseLimit()
        assertTrue(breached);
import org.opensearch.Version;
        assertFalse(breached);
        final Settings settings = Settings.builder().build();
            final IndexShardRoutingTable.Builder indexShardRoutingTableBuilder = new IndexShardRoutingTable.Builder(primaryShardId);
    }
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testIsResponseLimitBreachedForCatIndicesWithSettingEnabledExpectBreached() {
import org.opensearch.test.OpenSearchTestCase;
        // Set limit of 2 shards
import org.opensearch.cluster.metadata.Metadata;
    }
    }
    public void testIsResponseLimitBreachedForCatSegmentsWithSettingEnabledExpectNotBreached() {
        final RoutingTable routingTable = new RoutingTable(1, indexRoutingTableMap);
            indexRoutingTableMap.put(index.getName(), indexRoutingTable.build());
        // Don't enable limit
    public void testIsResponseLimitBreachedForCatIndicesWithSettingEnabledExpectNotBreached() {
    private static boolean isBreachedForSegments(Settings settings) {
    private static ClusterState buildClusterState(String... indices) {
    }
        final Settings settings = Settings.builder().put(CAT_INDICES_RESPONSE_LIMIT_SETTING.getKey(), 1).build();
        final Settings settings = Settings.builder().put(CAT_INDICES_RESPONSE_LIMIT_SETTING.getKey(), -1).build();
import java.util.HashMap;
        }
        );
            final ShardRouting replicaShardRouting = createShardRouting(replicaShardId, false);
        assertFalse(breached);
        final Settings settings = Settings.builder().put(CAT_SEGMENTS_RESPONSE_LIMIT_SETTING.getKey(), 5).build();
    public void testIsResponseLimitBreachedForCatIndicesWithSettingDisabledExpectNotBreached() {
import static org.opensearch.common.breaker.ResponseLimitSettings.CAT_INDICES_RESPONSE_LIMIT_SETTING;
    }
        );
import org.opensearch.cluster.routing.IndexShardRoutingTable;
/*
        // Don't set setting
            .routingTable(routingTable)
    }
        assertFalse(breached);
        final boolean breached = isBreachedForSegments(settings);
        // Don't set setting
        final ResponseLimitSettings responseLimitSettings = new ResponseLimitSettings(clusterSettings, settings);
            metadata.put(IndexMetadata.builder(index).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0));
        return ResponseLimitSettings.isResponseLimitBreached(
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
        final Map<String, IndexRoutingTable> indexRoutingTableMap = new HashMap<>();
        final boolean breached = isBreachedForIndices(settings);
        // Set limit of 1 index
import org.opensearch.cluster.ClusterState;
import java.util.Map;
        assertTrue(breached);
            () -> ResponseLimitSettings.isResponseLimitBreached(clusterState.getMetadata(), null, 4)
            clusterState.getRoutingTable(),
    public void testIsResponseLimitBreachedForCatShardsWithSettingEnabledExpectNotBreached() {
        assertFalse(breached);
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testIsResponseLimitBreachedForNullMetadataExpectNotBreached() {
            0
    public void testIsResponseLimitBreachedForCatShardsWithSettingEnabledExpectBreached() {
        }
            ResponseLimitSettings.LimitEntity.INDICES,
        final ClusterState clusterState = buildClusterState("test-index-1", "test-index-2", "test-index-3");
        expectThrows(
