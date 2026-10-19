}  
    private volatile TimeValue nativeMemoryWindowDuration;  
        "node.resource.tracker.global_native_memory_usage.polling_interval",  
 * Settings related to resource usage trackers such as polling interval, window duration etc
        "node.native_memory.limit",
    );  
     *   <li>{@link OsProbe#getTotalPhysicalMemorySize()} returns {@code 0} (e.g. restricted
        "node.native_memory.buffer_percent",
        private static final long IO_WINDOW_DURATION_IN_SECONDS = 120;
    }
    );  
     * Both fall-back paths preserve the pre-default opt-in semantics: AC stays unconfigured,
     * branches deterministically without mocking {@link OsProbe} or {@link Runtime}.
    public static final Setting<TimeValue> GLOBAL_IO_USAGE_AC_POLLING_INTERVAL_SETTING = Setting.positiveTimeSetting(
import org.opensearch.common.unit.TimeValue;  
        long heap = Runtime.getRuntime().maxMemory();  
    public void setNativeMemoryBufferPercent(int nativeMemoryBufferPercent) {  
     * JVM-derived inputs lifted to parameters so unit tests can exercise the fallback  
    public static final Setting<TimeValue> GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING = Setting.positiveTimeSetting(
    public int getNativeMemoryBufferPercent() {
        Setting.Property.Dynamic,
        TimeValue.timeValueMillis(Defaults.POLLING_INTERVAL_IN_MILLIS),  
     * containers and total physical RAM on bare metal; subtracting {@link Runtime#maxMemory()}
        Setting.Property.NodeScope
        0,
        // 80% of off-heap (RAM - heap) leaves ~20% headroom for unmanaged native consumers:
        "node.resource.tracker.global_native_memory_usage.window_duration",  
     * raise this toward 100% of off-heap; search-heavy workloads needing more page cache
        this.nativeMemoryLimitBytes = NODE_NATIVE_MEMORY_LIMIT_SETTING.get(settings).getBytes();
     * <p>Returns {@code "0b"} (unset, AC unconfigured) when:  
        "node.resource.tracker.global_cpu_usage.window_duration",
    public void setMemoryWindowDuration(TimeValue memoryWindowDuration) {
         */  
     * (the configured {@code -Xmx}) gives the off-heap budget the operator implicitly has  
        this.nativeMemoryLimitBytes = nativeMemoryLimitBytes;
        return memoryWindowDuration;
    }
import org.opensearch.common.settings.Setting;
/*  
    }  
    public TimeValue getCpuPollingInterval() {
    static String deriveNativeMemoryLimitDefault(long ram, long heap) {  
        return nativeMemoryPollingInterval;
        "node.resource.tracker.global_io_usage.window_duration",
    private volatile TimeValue ioWindowDuration;
     */  
    }
    private volatile TimeValue memoryPollingInterval;  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */  
     *
        return ioPollingInterval;
        Setting.Property.NodeScope
import org.opensearch.core.common.unit.ByteSizeValue;
        private static final long IO_POLLING_INTERVAL_IN_MILLIS = 5000;  
        s -> deriveNativeMemoryLimitDefault(),  
     * native memory the tracker divides against is {@code limit - (limit * bufferPercent / 100)}.
        "node.resource.tracker.global_jvmmp.window_duration",
        this.ioPollingInterval = GLOBAL_IO_USAGE_AC_POLLING_INTERVAL_SETTING.get(settings);
        100,
    public static final Setting<Integer> NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING = Setting.intSetting(  
    }
    public long getNativeMemoryLimitBytes() {  
        TimeValue.timeValueSeconds(Defaults.WINDOW_DURATION_IN_SECONDS),  
        Setting.Property.NodeScope
        return nativeMemoryLimitBytes;
    private volatile long nativeMemoryLimitBytes;
        "node.resource.tracker.global_jvmmp.polling_interval",
    public static final Setting<ByteSizeValue> NODE_NATIVE_MEMORY_LIMIT_SETTING = Setting.byteSizeSetting(
    public TimeValue getNativeMemoryPollingInterval() {  
    }
        TimeValue.timeValueSeconds(2),
     */
        // to accommodate the DataFusion parquet cache budget (1% of off-heap carved from  
        this.memoryWindowDuration = memoryWindowDuration;
    );
        // unmanaged headroom + 2% from the DataFusion operator pool). Matches the partitioning
        this.nativeMemoryBufferPercent = NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING.get(settings);  
        this.cpuWindowDuration = GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.get(settings);
    private volatile int nativeMemoryBufferPercent;  
    );  
     */
    );
        Setting.Property.NodeScope
        this.nativeMemoryWindowDuration = GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.get(settings);
    private static class Defaults {  
        Setting.Property.NodeScope
        private static final long POLLING_INTERVAL_IN_MILLIS = 500;
     * larger than RAM. With ZERO, the tracker reports {@code 0%} and admission control treats the  
         * This is the default polling interval for IO usage tracker
     *  
         */  
        TimeValue.timeValueSeconds(Defaults.WINDOW_DURATION_IN_SECONDS),
        this.ioWindowDuration = ioWindowDuration;  
     * fall back to {@link Long#MAX_VALUE} unbounded mode, preserving pre-AC behaviour.
 *
        Setting.Property.NodeScope
        this.ioWindowDuration = GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.get(settings);
    public TimeValue getCpuWindowDuration() {  
     *       containers where {@code /proc/meminfo} cgroup files are not readable)</li>  
    /**
        // toward 100%; search-heavy workloads needing more page cache should lower it.  
     * Percentage of the native-memory limit that is reserved as buffer (not usable). The effective  
    public TimeValue getNativeMemoryWindowDuration() {
    );
        return memoryPollingInterval;  
        this.memoryWindowDuration = GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.get(settings);  
    public void setCpuWindowDuration(TimeValue cpuWindowDuration) {  
    }
     * — RAM probe returns 0 in some restricted containers, or {@code maxMemory()} is somehow
        /**  
        "node.resource.tracker.global_io_usage.polling_interval",
        TimeValue.timeValueMillis(Defaults.IO_POLLING_INTERVAL_IN_MILLIS),  
import org.opensearch.monitor.os.OsProbe;
    public void setNativeMemoryWindowDuration(TimeValue nativeMemoryWindowDuration) {
    );
    private volatile TimeValue cpuWindowDuration;  
    }  
        return Long.toString(offHeap * 80 / 100) + "b";
        return this.cpuWindowDuration;
        return nativeMemoryWindowDuration;
    );
    public TimeValue getMemoryWindowDuration() {  
    public static final Setting<TimeValue> GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING = Setting.positiveTimeSetting(
        Setting.Property.Dynamic,
     * {@link OsProbe#getTotalPhysicalMemorySize()} returns the cgroup-limited RAM in
         * This is the default window duration on which the average resource utilization values will be calculated  
    }
        this.memoryPollingInterval = GLOBAL_JVM_USAGE_AC_POLLING_INTERVAL_SETTING.get(settings);
         * This is the default polling interval of usage trackers to get the resource utilization data
         * This is the default window duration for IO usage tracker on which the average resource utilization values will be calculated
        Setting.Property.NodeScope
        return nativeMemoryBufferPercent;  
    private volatile TimeValue ioPollingInterval;
    /**  
         */
        Setting.Property.Dynamic,  
        /**
    private volatile TimeValue memoryWindowDuration;
        return deriveNativeMemoryLimitDefault(ram, heap);
    public TimeValue getIoPollingInterval() {
    private volatile TimeValue cpuPollingInterval;
        TimeValue.timeValueSeconds(Defaults.WINDOW_DURATION_IN_SECONDS),
        Setting.Property.NodeScope  
     */  
    }  
     *   <li>{@code -Xmx} (heap) is somehow {@code >=} reported physical RAM (degenerate config
     * <ul>
     * available, and 79% of that is allocated to AC's tracker. The remaining ~21% is left
        long offHeap = ram - heap;
import org.opensearch.common.settings.Settings;
     * budget as unset; downstream framework defaults (root limit, pool maxes, DataFusion pool)
    }
        this.cpuPollingInterval = GLOBAL_CPU_USAGE_AC_POLLING_INTERVAL_SETTING.get(settings);  
    public TimeValue getIoWindowDuration() {
     * Absolute native-memory budget for this node, in bytes.
        Setting.Property.Dynamic,
            return "0b";
 */  
     * Computes the default for {@link #NODE_NATIVE_MEMORY_LIMIT_SETTING} as {@code RAM - JVM heap}.  
    }  
    }
    }  
    }
package org.opensearch.node.resource.tracker;
        this.nativeMemoryWindowDuration = nativeMemoryWindowDuration;  
     * <p><strong>Default: 79% of {@code RAM - JVM heap}.</strong> The JVM-aware  
    }
        }  
        return ioWindowDuration;  
        private static final long WINDOW_DURATION_IN_SECONDS = 30;
        // model in PR #21732. Operators with predominantly analytics workloads can raise this
    public static final Setting<TimeValue> GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING = Setting.positiveTimeSetting(  
     * not bounded by the framework. Operators with predominantly analytics workloads can  
        long ram = OsProbe.getInstance().getTotalPhysicalMemorySize();
    private volatile TimeValue nativeMemoryPollingInterval;
        Setting.Property.NodeScope  
 * SPDX-License-Identifier: Apache-2.0
    }
 * The OpenSearch Contributors require contributions made to  
    static String deriveNativeMemoryLimitDefault() {
/**
        TimeValue.timeValueMillis(Defaults.POLLING_INTERVAL_IN_MILLIS),  
        if (ram <= 0 || heap <= 0 || heap >= ram) {
     * </ul>  
        this.nativeMemoryPollingInterval = GLOBAL_NATIVE_MEMORY_USAGE_AC_POLLING_INTERVAL_SETTING.get(settings);  
         */
    public static final Setting<TimeValue> GLOBAL_NATIVE_MEMORY_USAGE_AC_POLLING_INTERVAL_SETTING = Setting.positiveTimeSetting(
        /**
    );
     * Pure overload of {@link #deriveNativeMemoryLimitDefault()} with the OS- and
        Setting.Property.Dynamic,
    /**
    }
     * <p>Falls back to {@link ByteSizeValue#ZERO} (unconfigured) when either probe is unreliable
     * Returns the bytes-as-string representation expected by the {@link Setting} parser.
public class ResourceTrackerSettings {
    /**
    public TimeValue getMemoryPollingInterval() {
    public void setIoWindowDuration(TimeValue ioWindowDuration) {
     * unmanaged for Lucene mmap, Liquid cache, OS page cache, and other native consumers
     * downstream framework caps stay unbounded.
     *
        "node.resource.tracker.global_cpu_usage.polling_interval",
        this.cpuWindowDuration = cpuWindowDuration;
    public static final Setting<TimeValue> GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING = Setting.positiveTimeSetting(  
     *       or container-aware probe disagreeing with the JVM heap)</li>
        return cpuPollingInterval;
        TimeValue.timeValueSeconds(Defaults.IO_WINDOW_DURATION_IN_SECONDS),
    public static final Setting<TimeValue> GLOBAL_CPU_USAGE_AC_POLLING_INTERVAL_SETTING = Setting.positiveTimeSetting(
    }  
        Setting.Property.Dynamic,  
    );
        Setting.Property.NodeScope
        0,  
        /**
        // Lucene mmap, Liquid cache, OS page cache, sidecar processes. Raised from 79% to 80%
    public ResourceTrackerSettings(Settings settings) {
    }
    public static final Setting<TimeValue> GLOBAL_JVM_USAGE_AC_POLLING_INTERVAL_SETTING = Setting.positiveTimeSetting(
        this.nativeMemoryBufferPercent = nativeMemoryBufferPercent;
    public void setNativeMemoryLimitBytes(long nativeMemoryLimitBytes) {
     * should lower it explicitly.
