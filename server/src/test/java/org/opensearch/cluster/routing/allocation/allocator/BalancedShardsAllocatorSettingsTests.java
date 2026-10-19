        new BalancedShardsAllocator(initialSettings, clusterSettings);
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.SHARD_BALANCE_FACTOR_SETTING;  
            .put(INDEX_BALANCE_FACTOR_SETTING.getKey(), "1.0")
            .build();
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));  
        assertNotNull(e.getCause());  
        final IllegalArgumentException e = expectThrows(  
    }
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }  
        assertThat(e.getCause().getMessage(), org.hamcrest.Matchers.containsString("must sum to a value greater than zero"));  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(SHARD_BALANCE_FACTOR_SETTING.getKey(), "1.0")
        final Settings newSettings = Settings.builder().put(INDEX_BALANCE_FACTOR_SETTING.getKey(), "0.0").build();
    }
        assertEquals(0.7f, allocator.getShardBalance(), 0.001f);
import org.opensearch.test.OpenSearchTestCase;  
            .put(INDEX_BALANCE_FACTOR_SETTING.getKey(), "0.3")
    }
    }
            .put(INDEX_BALANCE_FACTOR_SETTING.getKey(), "1.0")
        final Settings newSettings = Settings.builder()
            () -> new BalancedShardsAllocator(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
            .build();
    }
        new BalancedShardsAllocator(Settings.EMPTY, clusterSettings);  
        assertEquals(1.0f, allocator.getIndexBalance(), 0.0f);
 * SPDX-License-Identifier: Apache-2.0
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY, clusterSettings);
        assertEquals(1.0f, allocator.getShardBalance(), 0.0f);  
            .build();
        final Settings settings = Settings.builder()
    }  
public class BalancedShardsAllocatorSettingsTests extends OpenSearchTestCase {
            .put(SHARD_BALANCE_FACTOR_SETTING.getKey(), "0.0")
    public void testShardBalanceZeroWithNonZeroIndexBalanceIsAccepted() {  
import org.opensearch.common.settings.ClusterSettings;
        final Settings settings = Settings.builder()
        assertThat(e.getCause().getMessage(), org.hamcrest.Matchers.containsString("must sum to a value greater than zero"));
        assertThat(e.getCause().getMessage(), org.hamcrest.Matchers.containsString("must sum to a value greater than zero"));
            IllegalArgumentException.class,
            .build();
    public void testBothBalanceFactorsZeroIsRejectedOnDynamicUpdate() {
            .put(SHARD_BALANCE_FACTOR_SETTING.getKey(), "1.0")
        clusterSettings.applySettings(newSettings);  
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(settings, clusterSettings);  
    public void testIndexBalanceZeroWithNonZeroShardBalanceIsAccepted() {
        final Settings initialSettings = Settings.builder()
        assertEquals(0.3f, allocator.getIndexBalance(), 0.001f);
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
            .build();
    public void testDynamicUpdateIndexBalanceToZeroWhileShardBalanceAlreadyZeroIsRejected() {
        final ClusterSettings clusterSettings = new ClusterSettings(initialSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final Settings initialSettings = Settings.builder()  
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> clusterSettings.applySettings(newSettings));
    public void testValidDynamicUpdateIsAccepted() {  
/*  
            .put(SHARD_BALANCE_FACTOR_SETTING.getKey(), "0.7")  
            .put(SHARD_BALANCE_FACTOR_SETTING.getKey(), "0.0")  
        final Settings settings = Settings.builder()
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
 *
        new BalancedShardsAllocator(initialSettings, clusterSettings);
        assertEquals(0.0f, allocator.getIndexBalance(), 0.0f);
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("illegal value can't update"));
        assertEquals(0.0f, allocator.getShardBalance(), 0.0f);
            .put(INDEX_BALANCE_FACTOR_SETTING.getKey(), "0.0")  
        assertThat(e.getMessage(), org.hamcrest.Matchers.containsString("must sum to a value greater than zero"));
            .build();  
 * compatible open source license.
        final Settings newSettings = Settings.builder().put(SHARD_BALANCE_FACTOR_SETTING.getKey(), "0.0").build();  
            .build();
    public void testBothBalanceFactorsZeroIsRejectedOnConstruction() {
            .put(SHARD_BALANCE_FACTOR_SETTING.getKey(), "0.0")
        final Settings newSettings = Settings.builder()
import org.opensearch.common.settings.Settings;
            .put(SHARD_BALANCE_FACTOR_SETTING.getKey(), "0.0")
 * The OpenSearch Contributors require contributions made to  
}
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(settings, clusterSettings);
        );  
package org.opensearch.cluster.routing.allocation.allocator;
 */  
 * this file be licensed under the Apache-2.0 license or a
            .put(INDEX_BALANCE_FACTOR_SETTING.getKey(), "0.0")  
import static org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator.INDEX_BALANCE_FACTOR_SETTING;
    public void testDynamicUpdateShardBalanceToZeroWhileIndexBalanceAlreadyZeroIsRejected() {
            .put(INDEX_BALANCE_FACTOR_SETTING.getKey(), "0.0")  
        final ClusterSettings clusterSettings = new ClusterSettings(initialSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            .put(INDEX_BALANCE_FACTOR_SETTING.getKey(), "0.0")  
