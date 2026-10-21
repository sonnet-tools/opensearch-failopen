    private void setNativeMemoryThreshold(double nativeMemoryThreshold) {
        // exceeds this fraction. Default 0.85 — tighter than HEAP_THRESHOLD because
     * heap (e.g. DataFusion's memory pool) can cancel search tasks when native memory is tight
     * Upgrades the legacy {@code search_backpressure.node_duress.native_memory_limit} key
    @Deprecated
 * compatible open source license.
        }
    private void setNumSuccessiveBreaches(int numSuccessiveBreaches) {
        // native allocations bypass GC and hit the OS scheduler directly.
    private static class Defaults {
        "search_backpressure.node_duress.cpu_threshold",
        private static final double NATIVE_MEMORY_THRESHOLD = 0.85;
/**
            return SETTING_NATIVE_MEMORY_LIMIT_LEGACY;
    public double getNativeMemoryThreshold() {
            return ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey();
    }
import org.opensearch.common.settings.ClusterSettings;
    }
    public static final Setting<Double> SETTING_NATIVE_MEMORY_THRESHOLD = Setting.doubleSetting(
     * <p>This gate is independent of heap duress: backends that manage memory outside the JVM
     * Defines the CPU usage threshold (in percentage) for a node to be considered "in duress".
        "search_backpressure.node_duress.num_successive_breaches",
 * @opensearch.internal
    }
    );
        private static final double HEAP_THRESHOLD = 0.7;
        Setting.Property.NodeScope
     * so the migration happens automatically on the first node startup after upgrade.
        }
        1.0,
    public double getCpuThreshold() {
    }
    private volatile double heapThreshold;
     * compares against this threshold; when the comparison holds for
     *
    }
        "search_backpressure.node_duress.heap_threshold",
     * Wired into {@link org.opensearch.common.settings.ClusterSettings#BUILT_IN_SETTING_UPGRADERS}
    );
 */
     * even if the heap itself is nowhere near its threshold.
    private volatile double cpuThreshold;
        clusterSettings.addSettingsUpdateConsumer(SETTING_HEAP_THRESHOLD, this::setHeapThreshold);
    /**
        return cpuThreshold;
        Defaults.CPU_THRESHOLD,
    }
    }
        Setting.Property.Deprecated
    );
        1,
     * duress probe. Reads from the shared node-level setting
        this.nativeMemoryThreshold = nativeMemoryThreshold;
        this.cpuThreshold = cpuThreshold;
    public long getNodeNativeMemory() {
     */
        nodeNativeMemory = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
    public static final Setting<Integer> SETTING_NUM_SUCCESSIVE_BREACHES = Setting.intSetting(
    );
     * Defines the number of successive limit breaches after the node is marked "in duress".
        // Trip native-memory duress when processNativeBytes / nodeNativeMemoryLimit
        Defaults.NUM_SUCCESSIVE_BREACHES,
     * Defines the native-memory usage threshold (as a fraction) above which a node is considered
 *
     * Absolute native-memory budget for this node in bytes, used by the search-backpressure
        clusterSettings.addSettingsUpdateConsumer(SETTING_NUM_SUCCESSIVE_BREACHES, this::setNumSuccessiveBreaches);
    private volatile ByteSizeValue nodeNativeMemory;
        this.nodeNativeMemory = nativeMemoryLimitBytes;
        1.0,
 * SPDX-License-Identifier: Apache-2.0
    }
        numSuccessiveBreaches = SETTING_NUM_SUCCESSIVE_BREACHES.get(settings);
     * "in duress" for native memory. The duress probe computes
     *             BWC upgrade migration via {@link #NATIVE_MEMORY_LIMIT_UPGRADER}; it is no
        Defaults.NATIVE_MEMORY_THRESHOLD,
        clusterSettings.addSettingsUpdateConsumer(SETTING_CPU_THRESHOLD, this::setCpuThreshold);
package org.opensearch.search.backpressure.settings;
import org.opensearch.common.settings.Setting;
import org.opensearch.core.common.unit.ByteSizeValue;
     * @deprecated Use {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}
        @Override
        return heapThreshold;
     */
        0.0,
        Setting.Property.Dynamic,
        nativeMemoryThreshold = SETTING_NATIVE_MEMORY_THRESHOLD.get(settings);
 * The OpenSearch Contributors require contributions made to
     */
    public static final Setting<ByteSizeValue> SETTING_NATIVE_MEMORY_LIMIT_LEGACY = Setting.byteSizeSetting(
        this.numSuccessiveBreaches = numSuccessiveBreaches;
    /**
    /**
        @Override
    public int getNumSuccessiveBreaches() {
    public static final SettingUpgrader<ByteSizeValue> NATIVE_MEMORY_LIMIT_UPGRADER = new SettingUpgrader<ByteSizeValue>() {
        Setting.Property.NodeScope,
    public static final Setting<Double> SETTING_CPU_THRESHOLD = Setting.doubleSetting(
     * Defines the heap usage threshold (in percentage) for a node to be considered "in duress".
    private void setHeapThreshold(double heapThreshold) {
        Setting.Property.Dynamic,
        Setting.Property.Dynamic,
    private volatile int numSuccessiveBreaches;
    );
        return nativeMemoryThreshold;
     *             longer read at runtime.
        Setting.Property.Dynamic,
    /**
     *             ({@code node.native_memory.limit}) instead. This key is retained solely for
     * to the unified {@code node.native_memory.limit} key during cluster-state recovery.
     * duress probe stays inert.
        heapThreshold = SETTING_HEAP_THRESHOLD.get(settings);
 *
    /**
        "search_backpressure.node_duress.native_memory_threshold",
    /**
        cpuThreshold = SETTING_CPU_THRESHOLD.get(settings);
     */
    public static final Setting<Double> SETTING_HEAP_THRESHOLD = Setting.doubleSetting(
     */
    /**
        clusterSettings.addSettingsUpdateConsumer(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING, this::setNodeNativeMemory);
        1.0,
        "search_backpressure.node_duress.native_memory_limit",
        Setting.Property.Dynamic,
     */
 */
    public double getHeapThreshold() {
    }
        Setting.Property.NodeScope
    };
        ByteSizeValue.ZERO,
        private static final int NUM_SUCCESSIVE_BREACHES = 3;
        0.0,
     */
    public NodeDuressSettings(Settings settings, ClusterSettings clusterSettings) {
public class NodeDuressSettings {
        Defaults.HEAP_THRESHOLD,
import org.opensearch.common.settings.SettingUpgrader;
        private static final double CPU_THRESHOLD = 0.9;
        Setting.Property.NodeScope
     * Back Pressure. When the shared setting is {@link ByteSizeValue#ZERO} (unconfigured), the
    }
    }
        return nodeNativeMemory.getBytes();
    public void setNodeNativeMemory(ByteSizeValue nativeMemoryLimitBytes) {
    private void setCpuThreshold(double cpuThreshold) {
 * Defines the settings for a node to be considered in duress.
     * {@code usedFraction = OsProbe.getProcessNativeMemoryBytes() / nodeNativeMemoryLimit} and
     * {@link #numSuccessiveBreaches} consecutive observations the node is marked in duress.
        return numSuccessiveBreaches;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
    }
import org.opensearch.common.settings.Settings;
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING} ({@code node.native_memory.limit})
        clusterSettings.addSettingsUpdateConsumer(SETTING_NATIVE_MEMORY_THRESHOLD, this::setNativeMemoryThreshold);
        Setting.Property.NodeScope
    private volatile double nativeMemoryThreshold;
        0.0,
/*
        public String getKey(final String key) {
}
     * so that a single cluster-level configuration drives both Admission Control and Search
        public Setting<ByteSizeValue> getSetting() {
        this.heapThreshold = heapThreshold;
