    private void registerUptimeGauge(MetricsRegistry registry) {
    private void registerCpuGauges(MetricsRegistry registry, ProcessProbe processProbe, OsProbe osProbe) {
        );
            threadStateTimestamp = now;
            )
                heapTags
}
                heapTags
    static final String JVM_MEMORY_COMMITTED = "jvm.memory.committed";
    /**
    private long[] threadStateCounts = new long[Thread.State.values().length];
        gaugeHandles.add(
        OsProbe osProbe,
    // ---- Buffer pools ----
            try {
        );
        long[] counts = new long[Thread.State.values().length];
    public void close() throws IOException {
                "JVM thread count",
            registerUptimeGauge(registry);
import org.opensearch.monitor.jvm.JvmStats;
    // Units
        }
    static final String JVM_MEMORY_USED = "jvm.memory.used";
 * <p>Memory pool, GC collector, and buffer pool gauges are discovered dynamically
 * The OpenSearch Contributors require contributions made to
        return null;
                UNIT_1,
    // Classes
     * Constructs NodeRuntimeMetrics and registers all gauges with the given metrics registry.
                JvmStats.GarbageCollector c = getCollectorByName(collectorName);
    private final JvmService jvmService;
                JvmStats.BufferPool b = getBufferPoolByName(bpName);
    private final AtomicBoolean closed = new AtomicBoolean();
                UNIT_BYTES,
    static final String TAG_TYPE = "type";
 *
    // ---- Uptime ----
        for (JvmStats.GarbageCollector gc : jvmService.stats().getGc()) {
                JVM_SYSTEM_CPU_UTILIZATION,
import java.io.IOException;
        Tags nonHeapTags = Tags.of(TAG_TYPE, "non_heap");
        for (JvmStats.MemoryPool pool : jvmService.stats().getMem()) {
    // CPU
                    "JVM threads in this state",
                if (p == null) return 0.0;
            )
        gaugeHandles.add(
    }
        // Per-pool gauges
    /**
                "JVM heap memory max",
                "JVM uptime",
            }
     * @param jvmService   the JVM stats service
                return c == null ? 0.0 : (double) c.getCollectionCount();
                () -> (double) jvmService.stats().getMem().getNonHeapUsed().getBytes(),
            ThreadInfo[] infos = threadMXBean.getThreadInfo(threadIds);
 * SPDX-License-Identifier: Apache-2.0
    static final String JVM_GC_DURATION = "jvm.gc.duration";
                JVM_MEMORY_LIMIT,
 *
        }
import org.apache.logging.log4j.LogManager;
     * @param processProbe the process probe for CPU metrics
        gaugeHandles.add(
import java.util.concurrent.atomic.AtomicBoolean;
                UNIT_1,
            }
        this.jvmService = Objects.requireNonNull(jvmService, "jvmService");
        threadStateCounts = counts;
 * identically across G1, Parallel, CMS, ZGC, and other collector implementations.
    static final String JVM_UPTIME = "jvm.uptime";
        gaugeHandles.add(
            closeQuietly();
 * from the initial {@link JvmStats} snapshot and tagged by name, so they work
import java.util.Objects;
    static final String JVM_CLASS_COUNT = "jvm.class.count";
    }
        gaugeHandles.add(
            }, poolTags));
            )
            }
                "Currently loaded class count",
                () -> (double) jvmService.stats().getClasses().getUnloadedClassCount(),
            )
            String poolName = pool.getName();
                return b == null ? 0.0 : (double) b.getTotalCapacity().getBytes();
            String stateName = state.name().toLowerCase(Locale.ROOT);
                heapTags
 * @opensearch.internal
    // ---- GC (cumulative gauges) ----
        if (now - threadStateTimestamp > CACHE_TTL_MS) {
    static final String JVM_BUFFER_MEMORY_USED = "jvm.buffer.memory.used";
                    JVM_THREAD_COUNT,
                logger.debug("Failed to close gauge handle", e);
                UNIT_BYTES,
            }
import org.opensearch.telemetry.metrics.MetricsRegistry;
import java.lang.management.ThreadMXBean;
    static final String JVM_CLASS_LOADED = "jvm.class.loaded";
        ProcessProbe processProbe,
    static final String JVM_CLASS_UNLOADED = "jvm.class.unloaded";
    }
    static final String TAG_GC = "gc";
                UNIT_SECONDS,
    private void closeQuietly() {
                UNIT_1,
            throw e;
                JVM_MEMORY_COMMITTED,
    // Tag keys
            registry.createGauge(
        } catch (Exception e) {
                return pool;
        for (JvmStats.BufferPool bp : stats.getBufferPools()) {
    static final String JVM_GC_COUNT = "jvm.gc.count";
        }
        ThreadMXBean threadMXBean
                () -> clampCpuPercent(osProbe.getSystemCpuPercent()),
        MetricsRegistry registry,
import org.apache.logging.log4j.Logger;
                JVM_MEMORY_USED,
        gaugeHandles.add(
            if (bp.getName().equals(bpName)) {
    }
            )
    private final ThreadMXBean threadMXBean;
        return null;
     */
            }, gcTags));
     * @param registry     the metrics registry to register gauges with
        );
            )
        }
            if (pool.getName().equals(poolName)) {
public class NodeRuntimeMetrics implements Closeable {
            }, bpTags));
                () -> (double) jvmService.stats().getMem().getHeapUsed().getBytes(),
        }
     */
            gaugeHandles.add(registry.createGauge(JVM_MEMORY_USED, "JVM memory pool used", UNIT_BYTES, () -> {
            registerThreadGauges(registry);
                JVM_MEMORY_COMMITTED,
    private void registerThreadGauges(MetricsRegistry registry) {
    static final String JVM_BUFFER_COUNT = "jvm.buffer.count";
                return b == null ? 0.0 : (double) b.getUsed().getBytes();
        );
    private JvmStats.BufferPool getBufferPoolByName(String bpName) {
            registerClassGauges(registry);
                return bytes < 0 ? 0.0 : (double) bytes;
            registry.createGauge(
                return bp;
        );
    private void registerClassGauges(MetricsRegistry registry) {
    }
            gaugeHandles.add(registry.createGauge(JVM_MEMORY_USED_AFTER_LAST_GC, "JVM memory pool used after last GC", UNIT_BYTES, () -> {
            gaugeHandles.add(registry.createGauge(JVM_GC_DURATION, "GC cumulative collection time", UNIT_SECONDS, () -> {
            gaugeHandles.add(
                () -> (double) jvmService.stats().getMem().getHeapMax().getBytes(),
        gaugeHandles.add(
                JvmStats.MemoryPool p = getPoolByName(poolName);
                () -> (double) jvmService.stats().getClasses().getTotalLoadedClassCount(),
    }
                Tags.EMPTY
    }
    // GC
    }
            registry.createGauge(
 * compatible open source license.
                nonHeapTags
     *
    }
    static final String UNIT_SECONDS = "s";
        JvmService jvmService,
            gaugeHandles.add(registry.createGauge(JVM_GC_COUNT, "GC collection count", UNIT_1, () -> {
import java.lang.management.ThreadInfo;
 */
            )
                "JVM non-heap memory committed",
                Tags.EMPTY
            gaugeHandles.add(registry.createGauge(JVM_MEMORY_LIMIT, "JVM memory pool max", UNIT_BYTES, () -> {
                Tags.EMPTY
    // ---- CPU ----
        gaugeHandles.add(
    // notification listeners. Cumulative gauges give rate-of-GC-time; histograms would
                    counts[info.getThreadState().ordinal()]++;
        gaugeHandles.add(
        );
    private static double clampCpuPercent(short pct) {
            registry.createGauge(
                handle.close();
    }
    // Threads
        gaugeHandles.add(
                }
                Tags.EMPTY
            registerMemoryGauges(registry);
            }, gcTags));
            registerBufferPoolGauges(registry);
            registry.createGauge(
                UNIT_1,
        }
        }
                () -> jvmService.stats().getUptime().getMillis() / 1000.0,
        for (JvmStats.BufferPool bp : jvmService.stats().getBufferPools()) {
        );
            logger.debug("Failed to collect thread state counts", e);
 * (heap, non-heap, per-pool), GC collectors, buffer pools, threads (including
        return pct < 0 ? 0.0 : pct / 100.0;
    NodeRuntimeMetrics(
        }
     * @param osProbe      the OS probe for system CPU metrics
        this.threadMXBean = Objects.requireNonNull(threadMXBean, "threadMXBean");
 * the {@link JvmStats} snapshot with a 1-second TTL. A single collection sweep
            }, bpTags));
                if (info != null) {
    static final String TAG_POOL = "pool";
        Tags heapTags = Tags.of(TAG_TYPE, "heap");
        return threadStateCounts[state.ordinal()];
import java.util.List;
    private void registerMemoryGauges(MetricsRegistry registry) {
            registry.createGauge(
        );
                JvmStats.MemoryPool p = getPoolByName(poolName);
        gaugeHandles.add(
        } catch (Exception e) {
    // ---- Classes ----
            gaugeHandles.add(registry.createGauge(JVM_BUFFER_COUNT, "Buffer pool buffer count", UNIT_1, () -> {
    // ---- Threads ----
            return;
            Tags bpTags = Tags.of(TAG_POOL, bpName);
            Tags poolTags = Tags.of(TAG_POOL, poolName);
 */
        JvmStats stats = jvmService.stats();
    private long threadStateTimestamp;
                JvmStats.BufferPool b = getBufferPoolByName(bpName);
     * Returns the count of threads in the given state, using a cached snapshot
     * that is refreshed at most once per second. This ensures that during a
            String collectorName = gc.getName();
    static final String UNIT_1 = "1";
                () -> (double) jvmService.stats().getClasses().getLoadedClassCount(),
                Tags.EMPTY
                return p == null ? 0.0 : (double) p.getUsed().getBytes();
        Objects.requireNonNull(registry, "registry");
        return null;
    }
            registry.createGauge(
                nonHeapTags
            }
 *
                UNIT_BYTES,
            );
import org.opensearch.monitor.os.OsProbe;
        gaugeHandles.clear();
    // Uptime
                UNIT_BYTES,
            registry.createGauge(
package org.opensearch.monitor;
        Objects.requireNonNull(osProbe, "osProbe");
                "Recent JVM CPU utilization",
                    () -> (double) getThreadStateCount(state),
    private void registerBufferPoolGauges(MetricsRegistry registry) {
    static final String JVM_CPU_RECENT_UTILIZATION = "jvm.cpu.recent_utilization";
            )
                JVM_UPTIME,
                    UNIT_1,
        Objects.requireNonNull(processProbe, "processProbe");
        );
        if (closed.compareAndSet(false, true) == false) {
    }
        JvmStats stats = jvmService.stats();
            )
            gaugeHandles.add(registry.createGauge(JVM_BUFFER_MEMORY_LIMIT, "Buffer pool total capacity", UNIT_BYTES, () -> {
            }, poolTags));
 * this file be licensed under the Apache-2.0 license or a
 * <p>All JVM gauge suppliers read through {@link JvmService#stats()}, which caches
import java.io.Closeable;
                () -> (double) jvmService.stats().getThreads().getCount(),
    private final List<Closeable> gaugeHandles = new ArrayList<>();
            }, bpTags));
        }
            gaugeHandles.add(registry.createGauge(JVM_BUFFER_MEMORY_USED, "Buffer pool memory used", UNIT_BYTES, () -> {
                registry.createGauge(
                JVM_MEMORY_USED,
import java.util.Locale;
import java.lang.management.ManagementFactory;
                UNIT_BYTES,
                return c == null ? 0.0 : c.getCollectionTime().getMillis() / 1000.0;
        }
    }
                JVM_CLASS_LOADED,
 *
                UNIT_1,
            )
                "JVM heap memory committed",
                JVM_CLASS_UNLOADED,
    // Memory
    // TODO: Add event-driven GC pause duration histograms via GarbageCollectorMXBean
    private static final long CACHE_TTL_MS = 1000;
/**
        closeQuietly();
    static final String UNIT_BYTES = "bytes";
    static final String TAG_STATE = "state";
    // ---- Memory (heap aggregate, non-heap aggregate, per-pool) ----
     * single collection sweep all per-state gauges share one getThreadInfo() call.
import java.util.ArrayList;
    ) {
                JvmStats.BufferPool b = getBufferPoolByName(bpName);
        JvmStats stats = jvmService.stats();
            Tags gcTags = Tags.of(TAG_GC, collectorName);
        );
        }
        logger.debug("Registered {} node runtime metric gauges", gaugeHandles.size());
            registry.createGauge(
    // Thread state snapshot cache — shared across all per-state gauges
import org.opensearch.telemetry.metrics.tags.Tags;
        for (Thread.State state : Thread.State.values()) {
                "Total loaded class count since JVM start",
        this(registry, jvmService, processProbe, osProbe, ManagementFactory.getThreadMXBean());
                UNIT_1,
    static final String JVM_SYSTEM_CPU_UTILIZATION = "jvm.system.cpu.utilization";
    static final String JVM_MEMORY_USED_AFTER_LAST_GC = "jvm.memory.used_after_last_gc";
        );
        try {
    }
                return p == null ? 0.0 : (double) p.getLastGcStats().getUsed().getBytes();
            )
        );
            registerCpuGauges(registry, processProbe, osProbe);
    }
    static final String JVM_THREAD_COUNT = "jvm.thread.count";
        for (Closeable handle : gaugeHandles) {
            for (ThreadInfo info : infos) {
    static final String JVM_BUFFER_MEMORY_LIMIT = "jvm.buffer.memory.limit";
                JvmStats.GarbageCollector c = getCollectorByName(collectorName);
import org.opensearch.monitor.jvm.JvmService;
                Tags.EMPTY
            registerGcGauges(registry);
        }
            registry.createGauge(
    // enable percentile analysis of individual pause durations (p50, p99).
 * reuses one snapshot across all gauges with no redundant MXBean calls.
                long bytes = p.getMax().getBytes();
            if (gc.getName().equals(collectorName)) {
            Tags stateTags = Tags.of(TAG_STATE, stateName);
    private static final Logger logger = LogManager.getLogger(NodeRuntimeMetrics.class);
                "Total unloaded class count since JVM start",
/*
            String bpName = bp.getName();
    private JvmStats.GarbageCollector getCollectorByName(String collectorName) {
                return gc;
    static final String JVM_MEMORY_LIMIT = "jvm.memory.limit";
        gaugeHandles.add(
                "System CPU utilization",
    }
            long[] threadIds = threadMXBean.getAllThreadIds();
                JVM_THREAD_COUNT,
 * Registers pull-based gauges for node-level runtime metrics covering JVM memory
    // Buffer pools
                JVM_CLASS_COUNT,
                JvmStats.MemoryPool p = getPoolByName(poolName);
        for (JvmStats.MemoryPool pool : stats.getMem()) {
            registry.createGauge(
    private JvmStats.MemoryPool getPoolByName(String poolName) {
            }, poolTags));
                "JVM heap memory used",
            registry.createGauge(
    private void refreshThreadStateCounts() {
        try {
                )
            )
                Tags.EMPTY
import org.opensearch.monitor.process.ProcessProbe;
    private void registerGcGauges(MetricsRegistry registry) {
        for (JvmStats.GarbageCollector gc : stats.getGc()) {
    }
                () -> (double) jvmService.stats().getMem().getNonHeapCommitted().getBytes(),
                    stateTags
                "JVM non-heap memory used",
        long now = System.currentTimeMillis();
                JVM_CPU_RECENT_UTILIZATION,
            refreshThreadStateCounts();
            } catch (IOException e) {
    public NodeRuntimeMetrics(MetricsRegistry registry, JvmService jvmService, ProcessProbe processProbe, OsProbe osProbe) {
    @Override
 * per-state counts), class loading, uptime, and CPU usage.
                return b == null ? 0.0 : (double) b.getCount();
                () -> (double) jvmService.stats().getMem().getHeapCommitted().getBytes(),
                () -> clampCpuPercent(processProbe.getProcessCpuPercent()),
    private synchronized long getThreadStateCount(Thread.State state) {
