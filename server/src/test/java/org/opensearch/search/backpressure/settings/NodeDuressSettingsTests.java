    /**
        // Range [0.0, 1.0] enforced by Setting.doubleSetting(min, max).
     */
        NodeDuressSettings settings = new NodeDuressSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
 *
    public void testNativeMemoryThresholdIsDynamic() {
    }
        assertEquals(0.55d, settings.getNativeMemoryThreshold(), 0.0d);
        Settings raw = Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), 1.5d).build();
     * BWC: a cluster that had {@code search_backpressure.node_duress.native_memory_limit} set
public class NodeDuressSettingsTests extends OpenSearchTestCase {
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        assertEquals(2L * 1024 * 1024 * 1024, settings.getNodeNativeMemory());
        );
        // Simulate old cluster-state that contains the legacy SBP-specific key.
package org.opensearch.search.backpressure.settings;
        settings.setNodeNativeMemory(new ByteSizeValue(4096L));
        // constructor defaults to an empty upgrader set, mirroring the path SettingsModule takes.
        clusterSettings.applySettings(
        NodeDuressSettings settings = new NodeDuressSettings(initial, clusterSettings);
        ClusterSettings clusterSettings = new ClusterSettings(initial, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 * settings on {@link NodeDuressSettings}.
        assertEquals(0.42d, settings.getNativeMemoryThreshold(), 0.0d);
            Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "1gb").build()
     * in its persistent cluster state must have that value transparently migrated to
        // the duress probe reports an unconfigured limit.
            IllegalArgumentException.class,
    public void testNativeMemoryThresholdRejectsOutOfRange() {
    }
        );
        // depending on the internal string representation produced by the upgrader.
 */
    public void testDefaultNodeNativeMemoryLimitUsesNodeLevelSetting() {
        );
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS,
    public void testNodeNativeMemoryLimitSetterAcceptsByteSizeValue() {
        assertEquals(0.85d, settings.getNativeMemoryThreshold(), 0.0d);
            new java.util.HashSet<>(ClusterSettings.BUILT_IN_SETTING_UPGRADERS)
}
        assertEquals(1024L * 1024 * 1024, settings.getNodeNativeMemory());
        assertEquals(4L * 1024 * 1024 * 1024, ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(upgraded).getBytes());
        Settings raw = Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "0b").build();
 */
        Settings raw = Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "2gb").build();
        // rather than only in an integration test.
        ClusterSettings clusterSettings = new ClusterSettings(
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
     * original intent after upgrade.
        assertEquals(512L * 1024 * 1024, settings.getNodeNativeMemory());
            Settings.EMPTY,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        clusterSettings.applySettings(
        // Default per NodeDuressSettings.Defaults.NATIVE_MEMORY_THRESHOLD.
    }
        NodeDuressSettings settings = new NodeDuressSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
            () -> new NodeDuressSettings(raw2, new ClusterSettings(raw2, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(4096L, settings.getNodeNativeMemory());
        Settings raw = Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), 0.42d).build();
     * {@code node.native_memory.limit} by {@link NodeDuressSettings#NATIVE_MEMORY_LIMIT_UPGRADER}
        Settings legacyClusterState = Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_LIMIT_LEGACY.getKey(), "4gb").build();
            Settings.EMPTY,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        // A dynamic update to node.native_memory.limit must propagate to the duress probe.
            Settings.EMPTY,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.common.settings.Settings;
    }
        assertEquals(0L, settings.getNodeNativeMemory());
        Settings raw2 = Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), -0.1d).build();
        );
    public void testInitialNodeNativeMemoryLimitRespectsSetting() {
        // Must pass BUILT_IN_SETTING_UPGRADERS explicitly — the two-arg ClusterSettings
 * SPDX-License-Identifier: Apache-2.0
     * during cluster-state recovery, so the SBP duress probe still honours the operator's
        );
    }
 * compatible open source license.
        // Setting node.native_memory.limit to 0b disables the native-memory budget and
    public void testInitialNativeMemoryThresholdRespectsSetting() {
        // Apply a runtime update — the consumer should propagate to the field.
        NodeDuressSettings settings = new NodeDuressSettings(Settings.EMPTY, clusterSettings);
            IllegalArgumentException.class,
        Settings upgraded = clusterSettings.upgradeSettings(legacyClusterState);
        );
        // Configuring node.native_memory.limit is picked up by the duress probe.
        NodeDuressSettings settings = new NodeDuressSettings(
 * The OpenSearch Contributors require contributions made to
        NodeDuressSettings settings = new NodeDuressSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
            Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "512mb").build()
    public void testDefaultNativeMemoryThreshold() {
import org.opensearch.test.OpenSearchTestCase;
        );
    public void testLegacySettingUpgraderMigratesKeyToNodeNativeMemoryLimit() {
        clusterSettings.applySettings(Settings.builder().put(NodeDuressSettings.SETTING_NATIVE_MEMORY_THRESHOLD.getKey(), 0.55d).build());
        expectThrows(
    }
    public void testNodeNativeMemoryLimitIsDynamic() {
        // Old key must be gone after upgrade.
        // New unified key must carry the original value, compared as bytes to avoid
import org.opensearch.common.settings.ClusterSettings;
    }
            () -> new NodeDuressSettings(raw, new ClusterSettings(raw, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
    }
        NodeDuressSettings settings = new NodeDuressSettings(
        assertEquals(0L, settings.getNodeNativeMemory());
/*
        assertNull(upgraded.get(NodeDuressSettings.SETTING_NATIVE_MEMORY_LIMIT_LEGACY.getKey()));
        assertEquals(0.85d, settings.getNativeMemoryThreshold(), 0.0d);
        Settings initial = Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "0b").build();
/**
        // so assert the contract directly to catch regressions in the consumer wiring here
        // Direct setter contract — the cluster-settings consumer routes through this setter,
 * Unit tests covering the native-memory threshold and node native-memory limit
        expectThrows(
