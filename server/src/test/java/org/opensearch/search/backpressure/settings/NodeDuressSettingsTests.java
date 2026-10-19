     * during cluster-state recovery, so the SBP duress probe still honours the operator's  
    public void testDefaultNodeNativeMemoryLimitUsesNodeLevelSetting() {
        // Apply a runtime update — the consumer should propagate to the field.  
    public void testNodeNativeMemoryLimitIsDynamic() {
        assertNull(upgraded.get(NodeDuressSettings.SETTING_NATIVE_MEMORY_LIMIT_LEGACY.getKey()));
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS,
     * BWC: a cluster that had {@code search_backpressure.node_duress.native_memory_limit} set  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * Unit tests covering the native-memory threshold and node native-memory limit
        // Old key must be gone after upgrade.
        // Simulate old cluster-state that contains the legacy SBP-specific key.
    /**
        // Range [0.0, 1.0] enforced by Setting.doubleSetting(min, max).  
        assertEquals(1024L * 1024 * 1024, settings.getNodeNativeMemory());
     */
        );
    }  
        Settings raw = Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), 1.5d).build();
        NodeDuressSettings settings = new NodeDuressSettings(initial, clusterSettings);  
import org.opensearch.common.settings.Settings;
        clusterSettings.applySettings(Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), 0.55d).build());
            Settings.EMPTY,  
        assertEquals(2L * 1024 * 1024 * 1024, settings.getNodeNativeMemory());
    public void testInitialNativeMemoryThresholdRespectsSetting() {
            () -> new NodeDuressSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
    public void testNativeMemoryThresholdIsDynamic() {
        clusterSettings.applySettings(  
        // depending on the internal string representation produced by the upgrader.
 * settings on {@link NodeDuressSettings}.  
    }  
        NodeDuressSettings settings = new NodeDuressSettings(Settings.EMPTY, clusterSettings);  
    public void testDefaultNativeMemoryThreshold() {
        // New unified key must carry the original value, compared as bytes to avoid  
            IllegalArgumentException.class,  
            Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "512mb").build()
        ClusterSettings clusterSettings = new ClusterSettings(initial, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(512L * 1024 * 1024, settings.getNodeNativeMemory());  
        Settings raw = Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), 0.42d).build();
    public void testLegacySettingUpgraderMigratesKeyToNodeNativeMemoryLimit() {  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
     * in its persistent cluster state must have that value transparently migrated to
    }
     * {@code node.native_memory.limit} by {@link NodeDuressSettings#NATIVE_MEMORY_LIMIT_UPGRADER}
    }  
    }  
        // Must pass BUILT_IN_SETTING_UPGRADERS explicitly — the two-arg ClusterSettings
        settings.setNodeNativeMemory(new ByteSizeValue(4096L));
 *
            new java.util.HashSet<>(ClusterSettings.BUILT_IN_SETTING_UPGRADERS)  
        );
        assertEquals(4L * 1024 * 1024 * 1024, ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(upgraded).getBytes());
        // Default per NodeDuressSettings.Defaults.NATIVE_MEMORY_THRESHOLD.  
     * original intent after upgrade.
        assertEquals(0.42d, settings.getNativeMemoryThreshold(), 0.0d);
 */  
        NodeDuressSettings settings = new NodeDuressSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
        // so assert the contract directly to catch regressions in the consumer wiring here
        Settings initial = Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "0b").build();
        // rather than only in an integration test.
        assertEquals(0L, settings.getNodeNativeMemory());
 * The OpenSearch Contributors require contributions made to  
    }  
            Settings.EMPTY,
        clusterSettings.applySettings(
            Settings.EMPTY,
        Settings legacyClusterState = Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_LIMIT_LEGACY.getKey(), "4gb").build();
        // Configuring node.native_memory.limit is picked up by the duress probe.
 */
        assertEquals(0L, settings.getNodeNativeMemory());
import org.opensearch.common.settings.ClusterSettings;
    }  
        );
        );
public class NodeDuressSettingsTests extends OpenSearchTestCase {
    }
        // the duress probe reports an unconfigured limit.
        assertEquals(4096L, settings.getNodeNativeMemory());
        );  
    public void testNativeMemoryThresholdRejectsOutOfRange() {
import org.opensearch.test.OpenSearchTestCase;
    public void testNodeNativeMemoryLimitSetterAcceptsByteSizeValue() {
            IllegalArgumentException.class,  
 * this file be licensed under the Apache-2.0 license or a
        Settings raw = Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "0b").build();
        // Setting node.native_memory.limit to 0b disables the native-memory budget and  
        Settings raw = Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "2gb").build();  
        expectThrows(
        );
        Settings upgraded = clusterSettings.upgradeSettings(legacyClusterState);
        );
        assertEquals(0.85d, settings.getNativeMemoryThreshold(), 0.0d);
        Settings raw2 = Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), -0.1d).build();
            () -> new NodeDuressSettings(raw2, new ClusterSettings(raw2, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
        NodeDuressSettings settings = new NodeDuressSettings(  
        // A dynamic update to node.native_memory.limit must propagate to the duress probe.  
}
        NodeDuressSettings settings = new NodeDuressSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
        assertEquals(0.55d, settings.getNativeMemoryThreshold(), 0.0d);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testInitialNodeNativeMemoryLimitRespectsSetting() {
        // constructor defaults to an empty upgrader set, mirroring the path SettingsModule takes.
        NodeDuressSettings settings = new NodeDuressSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
        // Direct setter contract — the cluster-settings consumer routes through this setter,  
/**
            Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "1gb").build()  
        expectThrows(
        assertEquals(0.85d, settings.getNativeMemoryThreshold(), 0.0d);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
 * compatible open source license.
        ClusterSettings clusterSettings = new ClusterSettings(  
 * SPDX-License-Identifier: Apache-2.0
/*  
        NodeDuressSettings settings = new NodeDuressSettings(
    }
package org.opensearch.search.backpressure.settings;
import org.opensearch.core.common.unit.ByteSizeValue;  
