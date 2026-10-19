     *
    /**
        TimeValue.timeValueSeconds(Defaults.WINDOW_DURATION_IN_SECONDS),
    );
        /**
        return nativeMemoryWindowDuration;
    );
        return ioWindowDuration;
     * <p>Falls back to {@link ByteSizeValue#ZERO} (unconfigured) when either probe is unreliable
     * Absolute native-memory budget for this node, in bytes.
        "node.native_memory.buffer_percent",
        this.nativeMemoryBufferPercent = NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING.get(settings);
        this.ioPollingInterval = GLOBAL_IO_USAGE_AC_POLLING_INTERVAL_SETTING.get(settings);
    private volatile TimeValue ioPollingInterval;
    );
    public TimeValue getIoPollingInterval() {
     */
        // 80% of off-heap (RAM - heap) leaves ~20% headroom for unmanaged native consumers:
        Setting.Property.Dynamic,
        "node.resource.tracker.global_native_memory_usage.window_duration",
    public int getNativeMemoryBufferPercent() {
    public void setNativeMemoryWindowDuration(TimeValue nativeMemoryWindowDuration) {
        private static final long POLLING_INTERVAL_IN_MILLIS = 500;
        long heap = Runtime.getRuntime().maxMemory();
        return Long.toString(offHeap * 80 / 100) + "b";
import org.opensearch.common.settings.Settings;
        // to accommodate the DataFusion parquet cache budget (1% of off-heap carved from
    }
        this.nativeMemoryWindowDuration = nativeMemoryWindowDuration;
        TimeValue.timeValueSeconds(Defaults.WINDOW_DURATION_IN_SECONDS),
     * Computes the default for {@link #NODE_NATIVE_MEMORY_LIMIT_SETTING} as {@code RAM - JVM heap}.
    }
        0,
        this.cpuWindowDuration = GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.get(settings);
    }
    );
     * {@link OsProbe#getTotalPhysicalMemorySize()} returns the cgroup-limited RAM in
    private volatile long nativeMemoryLimitBytes;
import org.opensearch.common.settings.Setting;
        this.cpuWindowDuration = cpuWindowDuration;
     * not bounded by the framework. Operators with predominantly analytics workloads can
     * available, and 79% of that is allocated to AC's tracker. The remaining ~21% is left
     * larger than RAM. With ZERO, the tracker reports {@code 0%} and admission control treats the
 * compatible open source license.
        "node.resource.tracker.global_cpu_usage.window_duration",
    );
     * <ul>
     * containers and total physical RAM on bare metal; subtracting {@link Runtime#maxMemory()}
     * raise this toward 100% of off-heap; search-heavy workloads needing more page cache
        TimeValue.timeValueSeconds(Defaults.WINDOW_DURATION_IN_SECONDS),
        "node.resource.tracker.global_native_memory_usage.polling_interval",
         * This is the default polling interval for IO usage tracker
     * budget as unset; downstream framework defaults (root limit, pool maxes, DataFusion pool)
        TimeValue.timeValueSeconds(2),
     * branches deterministically without mocking {@link OsProbe} or {@link Runtime}.
    public static final Setting<TimeValue> GLOBAL_CPU_USAGE_AC_POLLING_INTERVAL_SETTING = Setting.positiveTimeSetting(
     *   <li>{@code -Xmx} (heap) is somehow {@code >=} reported physical RAM (degenerate config
 * The OpenSearch Contributors require contributions made to
         */
     * downstream framework caps stay unbounded.
     *       containers where {@code /proc/meminfo} cgroup files are not readable)</li>
    private volatile TimeValue cpuWindowDuration;
    }
        long ram = OsProbe.getInstance().getTotalPhysicalMemorySize();
     * native memory the tracker divides against is {@code limit - (limit * bufferPercent / 100)}.
        return cpuPollingInterval;
import org.opensearch.monitor.os.OsProbe;
        // toward 100%; search-heavy workloads needing more page cache should lower it.
     *
    /**
        return memoryPollingInterval;
        Setting.Property.NodeScope
    public void setCpuWindowDuration(TimeValue cpuWindowDuration) {
import org.opensearch.common.unit.TimeValue;
         * This is the default polling interval of usage trackers to get the resource utilization data
        "node.resource.tracker.global_cpu_usage.polling_interval",
    private volatile TimeValue nativeMemoryWindowDuration;
            return "0b";
    public TimeValue getCpuPollingInterval() {
    }
    /**
        this.nativeMemoryWindowDuration = GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.get(settings);
        Setting.Property.NodeScope
        this.memoryPollingInterval = GLOBAL_JVM_USAGE_AC_POLLING_INTERVAL_SETTING.get(settings);
        Setting.Property.NodeScope
    }
    );
        this.nativeMemoryLimitBytes = NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings).getBytes();
    public void setMemoryWindowDuration(TimeValue memoryWindowDuration) {
 */
     * — RAM probe returns 0 in some restricted containers, or {@code maxMemory()} is somehow
        "node.resource.tracker.global_io_usage.window_duration",
        "node.resource.tracker.global_jvmmp.polling_interval",
        Setting.Property.Dynamic,
        TimeValue.timeValueMillis(Defaults.POLLING_INTERVAL_IN_MILLIS),
     * Pure overload of {@link #deriveNativeMemoryLimitDefault()} with the OS- and
        Setting.Property.Dynamic,
        return nativeMemoryLimitBytes;
        "node.resource.tracker.global_jvmmp.window_duration",
    private volatile int nativeMemoryBufferPercent;
        this.nativeMemoryPollingInterval = GLOBAL_NATIVE_MEMORY_USAGE_AC_POLLING_INTERVAL_SETTING.get(settings);
         * This is the default window duration on which the average resource utilization values will be calculated
    private volatile TimeValue memoryPollingInterval;
     * unmanaged for Lucene mmap, Liquid cache, OS page cache, and other native consumers
    private volatile TimeValue nativeMemoryPollingInterval;
/*
    public static final Setting<Integer> NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING = Setting.intSetting(
    }
        /**
        Setting.Property.NodeScope
        // unmanaged headroom + 2% from the DataFusion operator pool). Matches the partitioning
    public static final Setting<TimeValue> GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING = Setting.positiveTimeSetting(
    }
        long offHeap = ram - heap;
    /**
        "node.native_memory.limit",
     * <p><strong>Default: 79% of {@code RAM - JVM heap}.</strong> The JVM-aware
    private volatile TimeValue ioWindowDuration;
        /**
    }
        s -> deriveNativeMemoryLimitDefault(),
        this.ioWindowDuration = ioWindowDuration;
         */
    public static final Setting<TimeValue> GLOBAL_NATIVE_MEMORY_USAGE_AC_POLLING_INTERVAL_SETTING = Setting.positiveTimeSetting(
        this.nativeMemoryBufferPercent = nativeMemoryBufferPercent;
    public TimeValue getIoWindowDuration() {
     */
        TimeValue.timeValueSeconds(Defaults.IO_WINDOW_DURATION_IN_SECONDS),
    }
        return nativeMemoryPollingInterval;
    }
    public ResourceTrackerSettings(Settings settings) {
    public static final Setting<TimeValue> GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING = Setting.positiveTimeSetting(
         */
     *       or container-aware probe disagreeing with the JVM heap)</li>
 * SPDX-License-Identifier: Apache-2.0
        Setting.Property.Dynamic,
        // model in PR #21732. Operators with predominantly analytics workloads can raise this
        this.memoryWindowDuration = GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.get(settings);
    static String deriveNativeMemoryLimitDefault() {
     * (the configured {@code -Xmx}) gives the off-heap budget the operator implicitly has
    public void setIoWindowDuration(TimeValue ioWindowDuration) {
 * this file be licensed under the Apache-2.0 license or a
        /**
        Setting.Property.NodeScope
 *
     * JVM-derived inputs lifted to parameters so unit tests can exercise the fallback
        Setting.Property.Dynamic,
        100,
        return memoryWindowDuration;
     *   <li>{@link OsProbe#getTotalPhysicalMemorySize()} returns {@code 0} (e.g. restricted
     *
        Setting.Property.NodeScope
        this.memoryWindowDuration = memoryWindowDuration;
     * Returns the bytes-as-string representation expected by the {@link Setting} parser.
        private static final long IO_POLLING_INTERVAL_IN_MILLIS = 5000;
     * </ul>
    public void setNativeMemoryLimitBytes(long nativeMemoryLimitBytes) {
/**
        Setting.Property.NodeScope
    public TimeValue getCpuWindowDuration() {
    }
    public TimeValue getNativeMemoryPollingInterval() {
        Setting.Property.NodeScope
     * Percentage of the native-memory limit that is reserved as buffer (not usable). The effective
    static String deriveNativeMemoryLimitDefault(long ram, long heap) {
        if (ram <= 0 || heap <= 0 || heap >= ram) {
     */
    );
    }
    public static final Setting<ByteSizeValue> NODE_NATIVE_MEMORY_LIMIT_SETTING = Setting.byteSizeSetting(
    public TimeValue getMemoryPollingInterval() {
        Setting.Property.Dynamic,
        return this.cpuWindowDuration;
    );
    }
        this.ioWindowDuration = GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.get(settings);
        return deriveNativeMemoryLimitDefault(ram, heap);
    public long getNativeMemoryLimitBytes() {
        0,
        private static final long IO_WINDOW_DURATION_IN_SECONDS = 120;
        TimeValue.timeValueMillis(Defaults.POLLING_INTERVAL_IN_MILLIS),
    public static final Setting<TimeValue> GLOBAL_JVM_USAGE_AC_POLLING_INTERVAL_SETTING = Setting.positiveTimeSetting(
import org.opensearch.core.common.unit.ByteSizeValue;
         * This is the default window duration for IO usage tracker on which the average resource utilization values will be calculated
    }
    public static final Setting<TimeValue> GLOBAL_IO_USAGE_AC_POLLING_INTERVAL_SETTING = Setting.positiveTimeSetting(
}
    }
     * should lower it explicitly.
    );
         */
 */
    private static class Defaults {
     * Both fall-back paths preserve the pre-default opt-in semantics: AC stays unconfigured,
 * Settings related to resource usage trackers such as polling interval, window duration etc
package org.opensearch.node.resource.tracker;
    public void setNativeMemoryBufferPercent(int nativeMemoryBufferPercent) {
    }
     */
        return nativeMemoryBufferPercent;
        return ioPollingInterval;
        TimeValue.timeValueMillis(Defaults.IO_POLLING_INTERVAL_IN_MILLIS),
    }
    public static final Setting<TimeValue> GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING = Setting.positiveTimeSetting(
     * fall back to {@link Long#MAX_VALUE} unbounded mode, preserving pre-AC behaviour.
    public TimeValue getNativeMemoryWindowDuration() {
     * <p>Returns {@code "0b"} (unset, AC unconfigured) when:
    );
    private volatile TimeValue cpuPollingInterval;
    private volatile TimeValue memoryWindowDuration;
        this.nativeMemoryLimitBytes = nativeMemoryLimitBytes;
    }
        this.cpuPollingInterval = GLOBAL_CPU_USAGE_AC_POLLING_INTERVAL_SETTING.get(settings);
    public TimeValue getMemoryWindowDuration() {
        "node.resource.tracker.global_io_usage.polling_interval",
public class ResourceTrackerSettings {
        Setting.Property.NodeScope
        // Lucene mmap, Liquid cache, OS page cache, sidecar processes. Raised from 79% to 80%
    public static final Setting<TimeValue> GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING = Setting.positiveTimeSetting(
        Setting.Property.NodeScope
        private static final long WINDOW_DURATION_IN_SECONDS = 30;
    }
        }
