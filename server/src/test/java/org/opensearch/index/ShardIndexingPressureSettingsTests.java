        clusterSettings.applySettings(updated.build());
                .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), false)  
        long shardPrimaryAndCoordinatingBaseLimits = (long) (nodePrimaryAndCoordinatingLimits * 0.001d);
        assertFalse(shardIndexingPressureSettings.isShardIndexingPressureEnforced());
        long tenMB = 10 * 1024 * 1024;  
        long nodePrimaryAndCoordinatingLimits = shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits();
                .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
        assertEquals(tenMB, nodePrimaryAndCoordinatingLimits);
 * compatible open source license.
            IndexingPressure.MAX_INDEXING_BYTES.get(settings).getBytes()
        .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 2000)
        assertEquals(tenMB, nodePrimaryAndCoordinatingLimits);
        assertEquals(4000, shardIndexingPressureSettings.getRequestSizeWindow());  
    final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * The OpenSearch Contributors require contributions made to  
        long shardPrimaryAndCoordinatingBaseLimits = (long) (nodePrimaryAndCoordinatingLimits * 0.003d);  
import org.opensearch.common.settings.ClusterSettings;
            clusterService,  
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        // Shard Level Limits
        .put(IndexingPressure.MAX_INDEXING_BYTES.getKey(), "10MB")
            IndexingPressure.MAX_INDEXING_BYTES.get(settings).getBytes()  
    final ClusterService clusterService = ClusterServiceUtils.createClusterService(settings, clusterSettings, null);  
        );
        assertTrue(shardIndexingPressureSettings.isShardIndexingPressureEnforced());
        assertTrue(shardIndexingPressureSettings.isShardIndexingPressureEnabled());  
            settings,
        // Node level limits
import org.opensearch.test.ClusterServiceUtils;
        long nodePrimaryAndCoordinatingLimits = shardIndexingPressureSettings.getNodePrimaryAndCoordinatingLimits();  
                .put(ShardIndexingPressureSettings.REQUEST_SIZE_WINDOW.getKey(), 4000)
 *
        .build();  
        );  
            updated,
import org.opensearch.test.OpenSearchTestCase;
        assertEquals((long) (tenMB * 1.5), shardIndexingPressureSettings.getNodeReplicaLimits());
 * this file be licensed under the Apache-2.0 license or a
        .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENFORCED.getKey(), true)  
        long tenMB = 10 * 1024 * 1024;
        assertEquals((long) (shardPrimaryAndCoordinatingBaseLimits * 1.5), shardIndexingPressureSettings.getShardReplicaBaseLimits());
        assertEquals((long) (shardPrimaryAndCoordinatingBaseLimits * 1.5), shardIndexingPressureSettings.getShardReplicaBaseLimits());
            getTestClass().getName()  
                .put(ShardIndexingPressureSettings.SHARD_MIN_LIMIT.getKey(), 0.003d)
import org.opensearch.cluster.service.ClusterService;
        assertEquals(2000, shardIndexingPressureSettings.getRequestSizeWindow());
package org.opensearch.index;
public class ShardIndexingPressureSettingsTests extends OpenSearchTestCase {
        ShardIndexingPressureSettings shardIndexingPressureSettings = new ShardIndexingPressureSettings(
        assertFalse(shardIndexingPressureSettings.isShardIndexingPressureEnabled());
        Settings.Builder updated = Settings.builder();
            Settings.builder()
        // Node level limits
        clusterSettings.updateDynamicSettings(  
                .build(),  
    }  
        );
        assertEquals(shardPrimaryAndCoordinatingBaseLimits, shardIndexingPressureSettings.getShardPrimaryAndCoordinatingBaseLimits());  
        // Shard Level Limits
            settings,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;  
/*  
    public void testFromSettings() {
        assertEquals(shardPrimaryAndCoordinatingBaseLimits, shardIndexingPressureSettings.getShardPrimaryAndCoordinatingBaseLimits());
    public void testUpdateSettings() {
}
        .put(ShardIndexingPressureSettings.SHARD_MIN_LIMIT.getKey(), 0.001d)
        assertEquals((long) (tenMB * 1.5), shardIndexingPressureSettings.getNodeReplicaLimits());  
    private final Settings settings = Settings.builder()  
            clusterService,
    }
 */  
            Settings.builder().put(settings),
        ShardIndexingPressureSettings shardIndexingPressureSettings = new ShardIndexingPressureSettings(  
