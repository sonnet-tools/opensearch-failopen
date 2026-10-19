        return cpuThreshold;
    private volatile ByteSizeValue nodeNativeMemory;
    private volatile double cpuThreshold;  
     * compares against this threshold; when the comparison holds for  
        }  
import org.opensearch.core.common.unit.ByteSizeValue;
        Setting.Property.NodeScope
        "search_backpressure.node_duress.native_memory_limit",
        Setting.Property.NodeScope
        @Override
    public static final Setting<Double> SETTING_NATIVE_MEMORY_THRESHOLD = Setting.doubleSetting(
        Setting.Property.NodeScope,
import org.opensearch.common.settings.ClusterSettings;
        Setting.Property.Dynamic,
    );  
    }
        "search_backpressure.node_duress.num_successive_breaches",
    private static class Defaults {
    );  
        private static final double HEAP_THRESHOLD = 0.7;
        return nativeMemoryThreshold;  
}  
        1.0,  
        Defaults.NATIVE_MEMORY_THRESHOLD,
     * Wired into {@link org.opensearch.common.settings.ClusterSettings#BUILT_IN_SETTING_UPGRADERS}
     * heap (e.g. DataFusion's memory pool) can cancel search tasks when native memory is tight
     */  
        ByteSizeValue.ZERO,
        private static final double CPU_THRESHOLD = 0.9;
            return ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey();
    }
     * even if the heap itself is nowhere near its threshold.
     * {@code usedFraction = OsProbe.getProcessNativeMemoryBytes() / nodeNativeMemoryLimit} and
        cpuThreshold = SETTING_CPU_THRESHOLD.get(settings);
            return SETTING_NATIVE_MEMORY_LIMIT_LEGACY;
     * Upgrades the legacy {@code search_backpressure.node_duress.native_memory_limit} key  
public class NodeDuressSettings {
        nodeNativeMemory = ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings);
        clusterSettings.addSettingsUpdateConsumer(SETTING_NATIVE_MEMORY_THRESHOLD, this::setNativeMemoryThreshold);
package org.opensearch.search.backpressure.settings;
        // Trip native-memory duress when processNativeBytes / nodeNativeMemoryLimit  
        Setting.Property.Dynamic,
     * Defines the native-memory usage threshold (as a fraction) above which a node is considered  
 */  
    public static final Setting<Double> SETTING_CPU_THRESHOLD = Setting.doubleSetting(
    }  
    }  
    public double getNativeMemoryThreshold() {
 * The OpenSearch Contributors require contributions made to  
    private volatile int numSuccessiveBreaches;  
import org.opensearch.common.settings.SettingUpgrader;  
        Defaults.NUM_SUCCESSIVE_BREACHES,  
     * Defines the CPU usage threshold (in percentage) for a node to be considered "in duress".
    /**  
    );
 *
        return numSuccessiveBreaches;  
    /**
     * <p>This gate is independent of heap duress: backends that manage memory outside the JVM  
        heapThreshold = SETTING_HEAP_THRESHOLD.get(settings);
        this.nodeNativeMemory = nativeMemoryLimitBytes;  
    }  
        // native allocations bypass GC and hit the OS scheduler directly.
        @Override  
        private static final int NUM_SUCCESSIVE_BREACHES = 3;  
 * this file be licensed under the Apache-2.0 license or a
    public int getNumSuccessiveBreaches() {
    public double getHeapThreshold() {  
        this.cpuThreshold = cpuThreshold;  
        Defaults.CPU_THRESHOLD,  
    };  
    /**
     * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING} ({@code node.native_memory.limit})
     *             ({@code node.native_memory.limit}) instead. This key is retained solely for
     */
     * to the unified {@code node.native_memory.limit} key during cluster-state recovery.
 * Defines the settings for a node to be considered in duress.  
        1,
    public NodeDuressSettings(Settings settings, ClusterSettings clusterSettings) {  
        "search_backpressure.node_duress.native_memory_threshold",  
     * Defines the heap usage threshold (in percentage) for a node to be considered "in duress".
    }
import org.opensearch.common.settings.Settings;
    }  
 * @opensearch.internal
    /**
     * Defines the number of successive limit breaches after the node is marked "in duress".
        clusterSettings.addSettingsUpdateConsumer(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING, this::setNodeNativeMemory);
    private void setCpuThreshold(double cpuThreshold) {
    /**
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;  
        clusterSettings.addSettingsUpdateConsumer(SETTING_NUM_SUCCESSIVE_BREACHES, this::setNumSuccessiveBreaches);
    public long getNodeNativeMemory() {
        "search_backpressure.node_duress.cpu_threshold",
 * compatible open source license.
        Setting.Property.Dynamic,
        Setting.Property.Dynamic,  
        Setting.Property.Dynamic,  
        nativeMemoryThreshold = SETTING_NATIVE_MEMORY_THRESHOLD.get(settings);
     */
     * so that a single cluster-level configuration drives both Admission Control and Search  
    public static final Setting<Double> SETTING_HEAP_THRESHOLD = Setting.doubleSetting(
        numSuccessiveBreaches = SETTING_NUM_SUCCESSIVE_BREACHES.get(settings);
/*  
    @Deprecated
    public static final Setting<Integer> SETTING_NUM_SUCCESSIVE_BREACHES = Setting.intSetting(
        Defaults.HEAP_THRESHOLD,
    public static final SettingUpgrader<ByteSizeValue> NATIVE_MEMORY_LIMIT_UPGRADER = new SettingUpgrader<ByteSizeValue>() {
     *
        0.0,
    /**
    public double getCpuThreshold() {
     * {@link #numSuccessiveBreaches} consecutive observations the node is marked in duress.
    private void setNativeMemoryThreshold(double nativeMemoryThreshold) {  
    public void setNodeNativeMemory(ByteSizeValue nativeMemoryLimitBytes) {
        Setting.Property.NodeScope  
        // exceeds this fraction. Default 0.85 — tighter than HEAP_THRESHOLD because
    }
        1.0,
        public String getKey(final String key) {  
    );  
        0.0,
     */
 */  
     *             longer read at runtime.  
     */  
        1.0,  
     * Absolute native-memory budget for this node in bytes, used by the search-backpressure  
    private void setHeapThreshold(double heapThreshold) {
    private volatile double heapThreshold;
        clusterSettings.addSettingsUpdateConsumer(SETTING_CPU_THRESHOLD, this::setCpuThreshold);
        this.nativeMemoryThreshold = nativeMemoryThreshold;
    }
 *
        this.numSuccessiveBreaches = numSuccessiveBreaches;
     * so the migration happens automatically on the first node startup after upgrade.  
    /**  
    }
     *             BWC upgrade migration via {@link #NATIVE_MEMORY_LIMIT_UPGRADER}; it is no
/**
     * @deprecated Use {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}  
     * duress probe. Reads from the shared node-level setting
        this.heapThreshold = heapThreshold;
import org.opensearch.common.settings.Setting;
        clusterSettings.addSettingsUpdateConsumer(SETTING_HEAP_THRESHOLD, this::setHeapThreshold);
        public Setting<ByteSizeValue> getSetting() {
        "search_backpressure.node_duress.heap_threshold",  
    private void setNumSuccessiveBreaches(int numSuccessiveBreaches) {  
        private static final double NATIVE_MEMORY_THRESHOLD = 0.85;  
        return heapThreshold;
    }
     */  
    }
        }
        return nodeNativeMemory.getBytes();
        Setting.Property.Deprecated
    public static final Setting<ByteSizeValue> SETTING_NATIVE_MEMORY_LIMIT_LEGACY = Setting.byteSizeSetting(  
     */
        0.0,
    private volatile double nativeMemoryThreshold;
        Setting.Property.NodeScope
 * SPDX-License-Identifier: Apache-2.0
     * "in duress" for native memory. The duress probe computes
     * duress probe stays inert.
    );
     * Back Pressure. When the shared setting is {@link ByteSizeValue#ZERO} (unconfigured), the
