        LongSupplier effectiveNativeMemorySupplier  
     * Package-private test constructor. Accepts suppliers in place of the production defaults
        }
 * {@code -1} without touching the filesystem.
                rssAnon,
 * The OpenSearch Contributors require contributions made to  
     * polling cycle. When the limit is not explicitly configured, the effective budget is
import java.lang.management.MemoryMXBean;
    AverageNativeMemoryUsageTracker(
    }
        LongSupplier rssAnonSupplier,  
            long totalPhysicalMemory = OsProbe.getInstance().getTotalPhysicalMemorySize();  
            return 0L;
        LongSupplier heapCommittedSupplier,
        if (effectiveNativeMemory <= 0L) {
        this.heapCommittedSupplier = heapCommittedSupplier;
/*  
 * Subtracting non-heap removes fixed JVM overhead so the metric reflects actual native
        long nativeUsed = Math.max(0L, rssAnon - heapCommitted - nonHeapCommitted);
     * and returns the effective native-memory budget in bytes: {@code limit - (limit * buffer / 100)}.  
     * Resolves the current native-memory limit and buffer percentage from {@link ResourceTrackerSettings}
     * configuration nor auto-detection yields a usable budget.
 * <p>The denominator is the effective native memory budget:
        LongSupplier nonHeapCommittedSupplier,
        ThreadPool threadPool,  
        TimeValue windowDuration,
        }
        long heapCommitted = heapCommittedSupplier.getAsLong();  
     * auto-derived as {@code totalPhysicalMemory - jvmMaxHeap}.
 * platforms the polling loop is not started and {@link OsProbe#getProcessRssAnon()} returns
 * {@code effective = limit - (limit * bufferPercent / 100)}. The limit is resolved from
        long buffer = limit * bufferPercent / 100L;  
        this.rssAnonSupplier = () -> OsProbe.getInstance().getProcessRssAnon();  
        if (rssAnon < 0L) {
        int bufferPercent = resourceTrackerSettings.getNativeMemoryBufferPercent();
            LOGGER.debug("Native memory tracking inactive: node.native_memory.limit not configured and auto-detection unavailable");  
     * Production constructor. Wires the RSS reader to {@link OsProbe#getProcessRssAnon()}, the
            }  
        this.nonHeapCommittedSupplier = nonHeapCommittedSupplier;
            LOGGER.debug(
import org.opensearch.threadpool.ThreadPool;
        super(threadPool, pollingInterval, windowDuration);
     * {@link ResourceTrackerSettings#getNativeMemoryLimitBytes()} and
import java.lang.management.ManagementFactory;
            );
            } else {
        TimeValue windowDuration,
                percent  
        TimeValue pollingInterval,  
    ) {  
                heapCommitted,
     * <p>
        long effectiveNativeMemory = effectiveNativeMemorySupplier.getAsLong();
    private final LongSupplier rssAnonSupplier;
        long percent = Math.min(100L, Math.max(0L, (long) utilization));
     */  
        long limit = resourceTrackerSettings.getNativeMemoryLimitBytes();
    }
import java.util.function.LongSupplier;  
        return Math.max(0L, limit - buffer);
    @Override  
     * {@code /proc/self/status}, the JVM memory MX bean, or node settings.  
package org.opensearch.node.resource.tracker;
 * comes from {@link OsProbe#getProcessRssAnon()}, {@code HeapCommitted} and
        TimeValue pollingInterval,
     * {@code totalPhysicalMemory - jvmMaxHeap}. Returns {@code 0L} only when neither explicit  
     */
import org.apache.logging.log4j.LogManager;
                return 0L;
            return 0L;  
 *
        if (LOGGER.isDebugEnabled()) {
        this.heapCommittedSupplier = () -> memoryMXBean.getHeapMemoryUsage().getCommitted();
}  
        super(threadPool, pollingInterval, windowDuration);
                "Native memory poll: rssAnon={} heapCommitted={} nonHeapCommitted={} nativeUsed={} effectiveNativeMemory={} pct={}",  
    long computeEffectiveNativeMemory(ResourceTrackerSettings resourceTrackerSettings) {  
     */
        this.effectiveNativeMemorySupplier = () -> computeEffectiveNativeMemory(resourceTrackerSettings);  
                nonHeapCommitted,  
 *  
import org.apache.logging.log4j.Logger;
    /**
/**
                nativeUsed,
    /**  
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        this.rssAnonSupplier = rssAnonSupplier;  
        double utilization = (double) nativeUsed / effectiveNativeMemory * 100.0;
 * compatible open source license.
                effectiveNativeMemory,
 * allocations (Arrow buffers, jemalloc/DataFusion, direct byte buffers).
        ThreadPool threadPool,
            LOGGER.warn("Native memory poll skipped: RssAnon unavailable from /proc/self/status");
        ResourceTrackerSettings resourceTrackerSettings
     * When the limit is not explicitly configured (zero), auto-derives the budget as
            if (totalPhysicalMemory > 0L && jvmMaxHeap > 0L && totalPhysicalMemory > jvmMaxHeap) {
    }
                limit = totalPhysicalMemory - jvmMaxHeap;  
 * {@link ResourceTrackerSettings#NODE_NATIVE_MEMORY_LIMIT_SETTING}. When not explicitly  
 * AverageNativeMemoryUsageTracker reports this OpenSearch process's off-heap native memory  
 *
        }
     * heap-committed supplier to the JVM memory MX bean, and the effective-native-memory supplier  
    /**
     * to {@link #computeEffectiveNativeMemory(ResourceTrackerSettings)} so dynamic updates to
        this.nonHeapCommittedSupplier = () -> memoryMXBean.getNonHeapMemoryUsage().getCommitted();
        return percent;
     * {@link ResourceTrackerSettings#getNativeMemoryBufferPercent()} are observed on the next  
        }
    private final LongSupplier nonHeapCommittedSupplier;
 * utilization as a percentage of a node-level budget, averaged over a rolling window.
    private final LongSupplier effectiveNativeMemorySupplier;
 * <p>Activation is already gated to Linux in {@link NodeResourceUsageTracker}; on non-Linux  
 * SPDX-License-Identifier: Apache-2.0
    private static final Logger LOGGER = LogManager.getLogger(AverageNativeMemoryUsageTracker.class);  
 */  
public class AverageNativeMemoryUsageTracker extends AbstractAverageUsageTracker {
    private final LongSupplier heapCommittedSupplier;  
     * so tests can drive {@link #getUsage()} deterministically without reading
        this.effectiveNativeMemorySupplier = effectiveNativeMemorySupplier;  
        if (limit <= 0L) {
        long nonHeapCommitted = nonHeapCommittedSupplier.getAsLong();
    }
import org.opensearch.common.unit.TimeValue;  
 * <p>On Linux, each polling cycle computes  
 */  
    ) {
import org.opensearch.monitor.os.OsProbe;
    public long getUsage() {
        long rssAnon = rssAnonSupplier.getAsLong();  
 * this file be licensed under the Apache-2.0 license or a
            long jvmMaxHeap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax();
 * {@code NonHeapCommitted} (metaspace + code cache) come from the JVM memory MX bean.  
    public AverageNativeMemoryUsageTracker(
 * configured, the limit is auto-derived as {@code totalPhysicalMemory - jvmMaxHeap}.
 * {@code usage = max(0, RssAnon - HeapCommitted - NonHeapCommitted)} where {@code RssAnon}
 *
