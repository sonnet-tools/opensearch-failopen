                    JVM_THREAD_COUNT,  
    static final String JVM_MEMORY_COMMITTED = "jvm.memory.committed";
            )
                Tags.EMPTY
    /**
            )
                () -> clampCpuPercent(processProbe.getProcessCpuPercent()),
                JVM_SYSTEM_CPU_UTILIZATION,
                UNIT_1,
        );  
    static final String JVM_THREAD_COUNT = "jvm.thread.count";
 * Registers pull-based gauges for node-level runtime metrics covering JVM memory
                "Total loaded class count since JVM start",
    }
            }, bpTags));
                registry.createGauge(
                JvmStats.GarbageCollector c = getCollectorByName(collectorName);
            registry.createGauge(
                return c == null ? 0.0 : (double) c.getCollectionCount();  
        }
            String collectorName = gc.getName();
                return p == null ? 0.0 : (double) p.getLastGcStats().getUsed().getBytes();  
import java.lang.management.ThreadMXBean;
    // Uptime  
    }
            }, gcTags));  
        logger.debug("Registered {} node runtime metric gauges", gaugeHandles.size());  
            }, poolTags));  
    private static double clampCpuPercent(short pct) {
        MetricsRegistry registry,
                "System CPU utilization",
import java.util.List;
    // Threads  
     * @param registry     the metrics registry to register gauges with
        for (JvmStats.MemoryPool pool : jvmService.stats().getMem()) {  
     * @param osProbe      the OS probe for system CPU metrics
            registerUptimeGauge(registry);
                "Recent JVM CPU utilization",
    // ---- Buffer pools ----
                () -> (double) jvmService.stats().getThreads().getCount(),
            if (pool.getName().equals(poolName)) {
        return pct < 0 ? 0.0 : pct / 100.0;
        JvmStats stats = jvmService.stats();
                JvmStats.MemoryPool p = getPoolByName(poolName);
            }, bpTags));  
            )
                heapTags  
    static final String UNIT_BYTES = "bytes";
        // Per-pool gauges
            refreshThreadStateCounts();  
    }  
    private JvmStats.BufferPool getBufferPoolByName(String bpName) {  
            registerCpuGauges(registry, processProbe, osProbe);  
                return c == null ? 0.0 : c.getCollectionTime().getMillis() / 1000.0;
    static final String JVM_GC_DURATION = "jvm.gc.duration";
        );
    // Units
    }
                JVM_UPTIME,
                JvmStats.MemoryPool p = getPoolByName(poolName);
    // ---- Uptime ----  
package org.opensearch.monitor;
        for (Closeable handle : gaugeHandles) {
 * from the initial {@link JvmStats} snapshot and tagged by name, so they work
public class NodeRuntimeMetrics implements Closeable {  
    private final AtomicBoolean closed = new AtomicBoolean();
        try {
    // Thread state snapshot cache — shared across all per-state gauges
    private void registerClassGauges(MetricsRegistry registry) {  
                return gc;
    private final List<Closeable> gaugeHandles = new ArrayList<>();
     * @param processProbe the process probe for CPU metrics  
    static final String JVM_CPU_RECENT_UTILIZATION = "jvm.cpu.recent_utilization";  
                heapTags  
        for (JvmStats.GarbageCollector gc : jvmService.stats().getGc()) {  
            registry.createGauge(  
                () -> (double) jvmService.stats().getMem().getHeapMax().getBytes(),
                "JVM heap memory committed",  
                }
 * this file be licensed under the Apache-2.0 license or a
            closeQuietly();
    static final String TAG_TYPE = "type";
     * that is refreshed at most once per second. This ensures that during a  
        );
        } catch (Exception e) {
                Tags.EMPTY
                "JVM heap memory max",  
        }  
                JVM_MEMORY_COMMITTED,
        }
        gaugeHandles.add(  
    }  
                "JVM thread count",  
    // TODO: Add event-driven GC pause duration histograms via GarbageCollectorMXBean  
            logger.debug("Failed to collect thread state counts", e);
    static final String JVM_CLASS_UNLOADED = "jvm.class.unloaded";  
            )
                UNIT_BYTES,
            gaugeHandles.add(registry.createGauge(JVM_MEMORY_USED, "JVM memory pool used", UNIT_BYTES, () -> {  
 * identically across G1, Parallel, CMS, ZGC, and other collector implementations.
            Tags stateTags = Tags.of(TAG_STATE, stateName);  
                return bytes < 0 ? 0.0 : (double) bytes;
                    UNIT_1,
                UNIT_BYTES,
            registry.createGauge(
        gaugeHandles.add(  
    // ---- GC (cumulative gauges) ----
                Tags.EMPTY
            }, gcTags));
            gaugeHandles.add(registry.createGauge(JVM_BUFFER_MEMORY_USED, "Buffer pool memory used", UNIT_BYTES, () -> {  
                UNIT_BYTES,
    }
import org.opensearch.monitor.process.ProcessProbe;  
     * Returns the count of threads in the given state, using a cached snapshot
        gaugeHandles.add(  
        for (JvmStats.BufferPool bp : stats.getBufferPools()) {  
    }
import org.opensearch.telemetry.metrics.MetricsRegistry;
            Tags poolTags = Tags.of(TAG_POOL, poolName);
    static final String JVM_BUFFER_MEMORY_USED = "jvm.buffer.memory.used";
                    () -> (double) getThreadStateCount(state),  
 * <p>All JVM gauge suppliers read through {@link JvmService#stats()}, which caches
                if (p == null) return 0.0;  
    // CPU
    private void registerThreadGauges(MetricsRegistry registry) {
        }
                heapTags  
        return threadStateCounts[state.ordinal()];  
                "Total unloaded class count since JVM start",
        }
     *  
            registry.createGauge(
    static final String JVM_SYSTEM_CPU_UTILIZATION = "jvm.system.cpu.utilization";
    static final String JVM_GC_COUNT = "jvm.gc.count";
        Objects.requireNonNull(processProbe, "processProbe");
            )
        return null;
import org.opensearch.monitor.os.OsProbe;
 * compatible open source license.
            )  
    @Override
            )  
 * SPDX-License-Identifier: Apache-2.0
        }  
        for (Thread.State state : Thread.State.values()) {
                return b == null ? 0.0 : (double) b.getTotalCapacity().getBytes();  
            gaugeHandles.add(registry.createGauge(JVM_MEMORY_LIMIT, "JVM memory pool max", UNIT_BYTES, () -> {
            throw e;  
        ThreadMXBean threadMXBean  
     */
 *
 */  
    // enable percentile analysis of individual pause durations (p50, p99).
                JVM_MEMORY_USED,
    private void closeQuietly() {
    static final String UNIT_SECONDS = "s";  
                JVM_MEMORY_LIMIT,
            )
            gaugeHandles.add(registry.createGauge(JVM_BUFFER_COUNT, "Buffer pool buffer count", UNIT_1, () -> {
import java.lang.management.ManagementFactory;  
import java.util.concurrent.atomic.AtomicBoolean;
 *
        Objects.requireNonNull(registry, "registry");
                "JVM non-heap memory committed",  
        if (closed.compareAndSet(false, true) == false) {
        }
        return null;
    // ---- Threads ----  
    static final String JVM_BUFFER_MEMORY_LIMIT = "jvm.buffer.memory.limit";  
    ) {
        gaugeHandles.add(
                if (info != null) {  
    // GC  
                () -> clampCpuPercent(osProbe.getSystemCpuPercent()),
}
        if (now - threadStateTimestamp > CACHE_TTL_MS) {
        );
        );
                () -> (double) jvmService.stats().getMem().getNonHeapCommitted().getBytes(),
    }
                Tags.EMPTY  
        );  
        );  
    private void registerGcGauges(MetricsRegistry registry) {
 * per-state counts), class loading, uptime, and CPU usage.  
            }, poolTags));
            if (gc.getName().equals(collectorName)) {
import java.util.ArrayList;  
/*  
                JVM_CLASS_UNLOADED,  
    private void registerCpuGauges(MetricsRegistry registry, ProcessProbe processProbe, OsProbe osProbe) {
                () -> (double) jvmService.stats().getMem().getHeapCommitted().getBytes(),
                JvmStats.BufferPool b = getBufferPoolByName(bpName);  
    private void registerMemoryGauges(MetricsRegistry registry) {
import org.opensearch.telemetry.metrics.tags.Tags;
            )
    }  
    // ---- CPU ----
                UNIT_1,
        );
                Tags.EMPTY
        }
    public NodeRuntimeMetrics(MetricsRegistry registry, JvmService jvmService, ProcessProbe processProbe, OsProbe osProbe) {  
import java.util.Locale;
                () -> (double) jvmService.stats().getMem().getHeapUsed().getBytes(),
        ProcessProbe processProbe,
        try {
                UNIT_1,
            }  
            }
        for (JvmStats.GarbageCollector gc : stats.getGc()) {  
        long[] counts = new long[Thread.State.values().length];
    }  
            return;
 * <p>Memory pool, GC collector, and buffer pool gauges are discovered dynamically  
                return p == null ? 0.0 : (double) p.getUsed().getBytes();
                nonHeapTags  
        gaugeHandles.add(
    static final String TAG_POOL = "pool";
        gaugeHandles.add(  
            threadStateTimestamp = now;
            );  
                return bp;  
        } catch (Exception e) {
import org.apache.logging.log4j.Logger;
            registerMemoryGauges(registry);  
            String poolName = pool.getName();
        return null;  
        long now = System.currentTimeMillis();
        );
            long[] threadIds = threadMXBean.getAllThreadIds();  
    private final ThreadMXBean threadMXBean;
                    "JVM threads in this state",
        gaugeHandles.add(
            for (ThreadInfo info : infos) {
            Tags bpTags = Tags.of(TAG_POOL, bpName);
                Tags.EMPTY  
                UNIT_1,
    static final String JVM_BUFFER_COUNT = "jvm.buffer.count";
        gaugeHandles.clear();  
        Objects.requireNonNull(osProbe, "osProbe");  
                () -> (double) jvmService.stats().getClasses().getLoadedClassCount(),  
            }
                () -> (double) jvmService.stats().getMem().getNonHeapUsed().getBytes(),
                UNIT_SECONDS,
            gaugeHandles.add(registry.createGauge(JVM_GC_DURATION, "GC cumulative collection time", UNIT_SECONDS, () -> {  
import java.io.Closeable;
            registry.createGauge(
            gaugeHandles.add(registry.createGauge(JVM_MEMORY_USED_AFTER_LAST_GC, "JVM memory pool used after last GC", UNIT_BYTES, () -> {
import java.lang.management.ThreadInfo;
                () -> jvmService.stats().getUptime().getMillis() / 1000.0,
            if (bp.getName().equals(bpName)) {
                handle.close();
        gaugeHandles.add(
import java.util.Objects;  
import java.io.IOException;
        this(registry, jvmService, processProbe, osProbe, ManagementFactory.getThreadMXBean());
    }
    }  
        gaugeHandles.add(  
        );
 * (heap, non-heap, per-pool), GC collectors, buffer pools, threads (including
 * The OpenSearch Contributors require contributions made to  
    private final JvmService jvmService;  
    private synchronized long getThreadStateCount(Thread.State state) {  
                Tags.EMPTY
                JVM_CPU_RECENT_UTILIZATION,
        threadStateCounts = counts;
    // notification listeners. Cumulative gauges give rate-of-GC-time; histograms would
        this.jvmService = Objects.requireNonNull(jvmService, "jvmService");
    // Memory  
     * Constructs NodeRuntimeMetrics and registers all gauges with the given metrics registry.
    static final String UNIT_1 = "1";
    }
            registry.createGauge(
        }
            ThreadInfo[] infos = threadMXBean.getThreadInfo(threadIds);
            )
                JvmStats.BufferPool b = getBufferPoolByName(bpName);
 * reuses one snapshot across all gauges with no redundant MXBean calls.
        OsProbe osProbe,
            registerBufferPoolGauges(registry);
                () -> (double) jvmService.stats().getClasses().getTotalLoadedClassCount(),  
            registry.createGauge(
    static final String JVM_CLASS_LOADED = "jvm.class.loaded";
    static final String JVM_MEMORY_USED_AFTER_LAST_GC = "jvm.memory.used_after_last_gc";
            registry.createGauge(
            registerThreadGauges(registry);  
    static final String TAG_GC = "gc";  
            registry.createGauge(
                return b == null ? 0.0 : (double) b.getCount();
            String bpName = bp.getName();
            registry.createGauge(  
        for (JvmStats.BufferPool bp : jvmService.stats().getBufferPools()) {
    // ---- Memory (heap aggregate, non-heap aggregate, per-pool) ----  
    public void close() throws IOException {  
     * single collection sweep all per-state gauges share one getThreadInfo() call.
    // ---- Classes ----
            try {  
 *
            )
    private void registerUptimeGauge(MetricsRegistry registry) {
    // Buffer pools
        }  
/**  
                () -> (double) jvmService.stats().getClasses().getUnloadedClassCount(),  
    private void refreshThreadStateCounts() {  
    static final String JVM_MEMORY_USED = "jvm.memory.used";
                long bytes = p.getMax().getBytes();
                JVM_MEMORY_USED,
                JVM_CLASS_COUNT,  
    static final String JVM_MEMORY_LIMIT = "jvm.memory.limit";  
        );
            gaugeHandles.add(registry.createGauge(JVM_BUFFER_MEMORY_LIMIT, "Buffer pool total capacity", UNIT_BYTES, () -> {
                JvmStats.GarbageCollector c = getCollectorByName(collectorName);
    static final String JVM_UPTIME = "jvm.uptime";
import org.opensearch.monitor.jvm.JvmStats;
import org.apache.logging.log4j.LogManager;
    private long threadStateTimestamp;
                "JVM heap memory used",  
import org.opensearch.monitor.jvm.JvmService;  
    private static final Logger logger = LogManager.getLogger(NodeRuntimeMetrics.class);
        );
        Tags nonHeapTags = Tags.of(TAG_TYPE, "non_heap");
                "JVM non-heap memory used",  
                return pool;
                UNIT_1,  
 */
    // Tag keys  
 *  
    /**
                JVM_CLASS_LOADED,  
            registry.createGauge(
    }  
        Tags heapTags = Tags.of(TAG_TYPE, "heap");  
    NodeRuntimeMetrics(
    private JvmStats.GarbageCollector getCollectorByName(String collectorName) {
            gaugeHandles.add(registry.createGauge(JVM_GC_COUNT, "GC collection count", UNIT_1, () -> {
                JvmStats.BufferPool b = getBufferPoolByName(bpName);
        closeQuietly();
                nonHeapTags  
    }
    private long[] threadStateCounts = new long[Thread.State.values().length];  
                return b == null ? 0.0 : (double) b.getUsed().getBytes();
    // Classes  
                JVM_MEMORY_COMMITTED,
                logger.debug("Failed to close gauge handle", e);  
                    stateTags
            }, poolTags));  
            } catch (IOException e) {
        JvmService jvmService,  
        gaugeHandles.add(  
            registerClassGauges(registry);
            registerGcGauges(registry);
    private void registerBufferPoolGauges(MetricsRegistry registry) {
                UNIT_BYTES,
                "JVM uptime",  
        gaugeHandles.add(
            String stateName = state.name().toLowerCase(Locale.ROOT);
        }
                    counts[info.getThreadState().ordinal()]++;
                UNIT_1,  
    private static final long CACHE_TTL_MS = 1000;
        JvmStats stats = jvmService.stats();
                "Currently loaded class count",
        gaugeHandles.add(  
        for (JvmStats.MemoryPool pool : stats.getMem()) {  
    }
 * the {@link JvmStats} snapshot with a 1-second TTL. A single collection sweep  
                JvmStats.MemoryPool p = getPoolByName(poolName);
     */
        JvmStats stats = jvmService.stats();
    private JvmStats.MemoryPool getPoolByName(String poolName) {
                UNIT_BYTES,
    static final String TAG_STATE = "state";
        }
            registry.createGauge(
    }
                )
        this.threadMXBean = Objects.requireNonNull(threadMXBean, "threadMXBean");  
            }  
            }, bpTags));
    static final String JVM_CLASS_COUNT = "jvm.class.count";
            }  
     * @param jvmService   the JVM stats service
 * @opensearch.internal
            gaugeHandles.add(
                JVM_THREAD_COUNT,
            Tags gcTags = Tags.of(TAG_GC, collectorName);
            )
