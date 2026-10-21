            return this.count;
            this.nonHeapCommitted = nonHeapCommitted;
        private final long unloadedClassCount;
import org.opensearch.core.xcontent.XContentBuilder;
        private final long nonHeapUsed;
            garbageCollectors,
        static final String POOLS = "pools";
 * under the License.
        }
         */
        }
        Classes classes = new Classes(
            totalCapacity = in.readLong();
            builder.humanReadableField(Fields.COLLECTION_TIME_IN_MILLIS, Fields.COLLECTION_TIME, new TimeValue(collector.collectionTime));
            mem,
        public long getTotalLoadedClassCount() {
            out.writeVInt(peakCount);
        this.threads = threads;
            return new ByteSizeValue(used);
        this.uptime = uptime;
        private final long heapUsed;
        }
                MemoryUsage peakUsage = memoryPoolMXBean.getPeakUsage();
    private final Classes classes;
            out.writeVLong(nonHeapCommitted);
 * ownership. Elasticsearch licenses this file to you under
    public Threads getThreads() {
        static final String THREADS = "threads";
 * this work for additional information regarding copyright
/**
            name = in.readString();
import java.lang.management.MemoryPoolMXBean;
        @Override
            }
    }
     *
            peakCount = in.readVInt();
        List<BufferPool> bufferPools,
import org.opensearch.core.common.io.stream.StreamOutput;
import java.lang.management.ManagementFactory;
        }
        builder.field(Fields.TOTAL_LOADED_COUNT, classes.getTotalLoadedClassCount());
        return classes;
 * this file be licensed under the Apache-2.0 license or a
            }
    /**
            out.writeLong(loadedClassCount);
            builder.startObject(Fields.LAST_GC_STATS);
    /**
    private final Mem mem;
     * @opensearch.internal
            return (short) (used * 100 / max);
        @Override
            heapUsed = in.readVLong();
        public MemoryPoolGcStats getLastGcStats() {
            lastGcStats = new MemoryPoolGcStats(in);
        Threads threads = new Threads(threadMXBean.getThreadCount(), threadMXBean.getPeakThreadCount());
/*
        private final String name;
        static final String PEAK_MAX_IN_BYTES = "peak_max_in_bytes";
        static final String UPTIME = "uptime";
        /**
        private final long used;
            out.writeArray(collectors);
                        new MemoryPoolGcStats(
        long timestamp,
            }
    public JvmStats(
        long heapUsed = memUsage.getUsed() < 0 ? 0 : memUsage.getUsed();
        public ByteSizeValue getHeapCommitted() {
            pools = in.readList(MemoryPool::new);
        List<MemoryPool> pools = new ArrayList<>();
            classLoadingMXBean.getUnloadedClassCount()
        public Mem(long heapCommitted, long heapUsed, long heapMax, long nonHeapCommitted, long nonHeapUsed, List<MemoryPool> pools) {
    }
        List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();
        public ByteSizeValue getNonHeapUsed() {
            out.writeVLong(used);
     *
            out.writeVLong(max);
        builder.endObject();
        }
    public static class MemoryPoolGcStats implements Writeable {
    public static class MemoryPool implements Writeable {
            return this.collectors;
    public static class GarbageCollectors implements Writeable, Iterable<GarbageCollector> {
        static final String HEAP_USED_PERCENT = "heap_used_percent";
        }
        }
import java.util.Collections;
    }
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final List<BufferPool> bufferPools;
            out.writeVLong(heapCommitted);
        public GarbageCollectors(StreamInput in) throws IOException {
            this.name = name;
            this.pools = pools;
        @Override
            builder.humanReadableField(Fields.PEAK_MAX_IN_BYTES, Fields.PEAK_MAX, new ByteSizeValue(pool.peakMax));
        public long getLoadedClassCount() {
        );
 *
            this.heapUsed = heapUsed;
            return new ByteSizeValue(nonHeapCommitted);
    private static final RuntimeMXBean runtimeMXBean;
            collectionCount = in.readVLong();
        Classes classes
    public JvmStats(StreamInput in) throws IOException {
        }
            return this.collectionCount;
        threadMXBean = ManagementFactory.getThreadMXBean();
            System.currentTimeMillis(),
        }
        for (MemoryPoolMXBean memoryPoolMXBean : memoryPoolMXBeans) {
            unloadedClassCount = in.readLong();
        public int getCount() {
            return new ByteSizeValue(heapUsed);
        private final GarbageCollector[] collectors;
            loadedClassCount = in.readLong();
     */
        return bufferPools;
                return -1;
    public static class Mem implements Writeable, Iterable<MemoryPool> {
    @Override
import java.lang.management.RuntimeMXBean;
import org.opensearch.core.common.io.stream.Writeable;
        out.writeVLong(timestamp);
                        usage.getUsed() < 0 ? 0 : usage.getUsed(),
        }
            List<BufferPoolMXBean> bufferPools = ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);
 *
     * Thread information.
        static final String MAX_IN_BYTES = "max_in_bytes";
        public int getPeakCount() {
        static final String NON_HEAP_COMMITTED = "non_heap_committed";
        }
        builder.humanReadableField(Fields.HEAP_COMMITTED_IN_BYTES, Fields.HEAP_COMMITTED, new ByteSizeValue(mem.heapCommitted));
            this.used = used;
     * The garbage collector.
    private static final MemoryMXBean memoryMXBean;
                    new BufferPool(bufferPool.getName(), bufferPool.getCount(), bufferPool.getTotalCapacity(), bufferPool.getMemoryUsed())
                gcMxBean.getCollectionCount(),
        private final long nonHeapCommitted;
            // buffer pools are not available
        public MemoryPool(String name, long used, long max, long peakUsed, long peakMax, MemoryPoolGcStats lastGcStats) {
        }
            out.writeVLong(peakUsed);
    /**
        builder.startObject(Fields.JVM);
import java.util.ArrayList;
    }
        @Override
import java.lang.management.BufferPoolMXBean;
        public short getHeapUsedPercent() {
        }
            out.writeLong(unloadedClassCount);
        builder.startObject(Fields.POOLS);
 */
        private final long used;
        this.gc = gc;
        Mem mem = new Mem(heapCommitted, heapUsed, heapMax, nonHeapCommitted, nonHeapUsed, Collections.unmodifiableList(pools));
        if (mem.getHeapUsedPercent() >= 0) {
            collectors[i] = new GarbageCollector(
                GcNames.getByGcName(gcMxBean.getName(), gcMxBean.getName()),
        static final String HEAP_COMMITTED = "heap_committed";
        public Threads(int count, int peakCount) {
         * returns the maximum heap size. 0 bytes signals unknown.
        public ByteSizeValue getPeakMax() {
     */
            for (BufferPoolMXBean bufferPool : bufferPools) {
        for (MemoryPool pool : mem) {
     * @opensearch.internal
        static final String GC = "gc";
            return (short) (heapUsed * 100 / heapMax);
        }
                String name = GcNames.getByMemoryPoolName(memoryPoolMXBean.getName(), null);
        builder.humanReadableField(Fields.HEAP_USED_IN_BYTES, Fields.HEAP_USED, new ByteSizeValue(mem.heapUsed));
                            collectionUsage.getMax() < 0 ? 0 : collectionUsage.getMax()
            builder.field(Fields.COLLECTION_COUNT, collector.getCollectionCount());
        }
                    new MemoryPool(
        mem = new Mem(in);
            return this.name;
            builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, new ByteSizeValue(pool.getLastGcStats().used));
        static final String COLLECTION_COUNT = "collection_count";
            this.used = used;
                if (name == null) { // if we can't resolve it, its not interesting.... (Per Gen, Code Cache)
        }
            builder.field(Fields.USAGE_PERCENT, pool.getLastGcStats().getUsagePercent());
        }
    }
        if (bufferPools != null) {
            return Arrays.stream(collectors).iterator();
                    Fields.TOTAL_CAPACITY_IN_BYTES,
        }
            return new TimeValue(collectionTime, TimeUnit.MILLISECONDS);
    }
        builder.endObject();
            return pools.iterator();
 * Unless required by applicable law or agreed to in writing,
        builder.humanReadableField(Fields.UPTIME_IN_MILLIS, Fields.UPTIME, new TimeValue(uptime));
        static final String HEAP_USED = "heap_used";
        @Override
 * compatible open source license.
        @Override
    /**
            this.totalCapacity = totalCapacity;
        }
        }
            this.loadedClassCount = loadedClassCount;
        static final String LAST_GC_STATS = "last_gc_stats";
        public Iterator<MemoryPool> iterator() {
            return new ByteSizeValue(totalCapacity);
        }
    public static class Classes implements Writeable {
    public static class BufferPool implements Writeable {
        static final String USED_IN_BYTES = "used_in_bytes";
    }
     */
    /**
}
            builder.field(Fields.HEAP_USED_PERCENT, mem.getHeapUsedPercent());
        builder.field(Fields.TOTAL_UNLOADED_COUNT, classes.getUnloadedClassCount());
                );
 * the Apache License, Version 2.0 (the "License"); you may
        }
        @Override
        public MemoryPoolGcStats(StreamInput in) throws IOException {
        }
        uptime = in.readVLong();
public class JvmStats implements Writeable, ToXContentFragment {
        builder.field(Fields.COUNT, threads.getCount());
            GarbageCollectorMXBean gcMxBean = gcMxBeans.get(i);
        }
            out.writeString(name);
    @Override
                return -1;
        private final long peakUsed;
        static final String USAGE_PERCENT = "usage_percent";
            return new ByteSizeValue(nonHeapUsed);
            out.writeVLong(nonHeapUsed);
        builder.endObject();
        classes.writeTo(out);
        try {
            lastGcStats.writeTo(out);
        private final long totalCapacity;
 * license agreements. See the NOTICE file distributed with
    }
            this.name = name;
        gc.writeTo(out);
        }
            builder.endObject();
    private final GarbageCollectors gc;
    static final class Fields {
                        usage.getMax() < 0 ? 0 : usage.getMax(),
     * @opensearch.internal
        public ByteSizeValue getMax() {
        }
            return new ByteSizeValue(max);
            this.heapMax = heapMax;
        }
        classes = new Classes(in);
        builder.startObject(Fields.MEM);
            out.writeVLong(used);
 */
     * @opensearch.internal
        static final String HEAP_MAX = "heap_max";
        static final String TOTAL_CAPACITY_IN_BYTES = "total_capacity_in_bytes";
        public String getName() {
        builder.field(Fields.PEAK_COUNT, threads.getPeakCount());
        @Override
        }
        threads.writeTo(out);
        }
        }
        public BufferPool(StreamInput in) throws IOException {
        }
                gcMxBean.getCollectionTime()
                );
         * returns the heap usage in percent. -1 signals unknown.
/*
        return gc;
    }
        this.classes = classes;
            totalLoadedClassCount = in.readLong();
     * @opensearch.internal
            return this.name;
            out.writeString(name);
            this.collectors = collectors;
        static final String MAX = "max";
            this.name = name;
        long nonHeapCommitted = memUsage.getCommitted() < 0 ? 0 : memUsage.getCommitted();
import java.lang.management.MemoryMXBean;
    private static final ThreadMXBean threadMXBean;
            if (max == 0) {
            builder.humanReadableField(Fields.MAX_IN_BYTES, Fields.MAX, new ByteSizeValue(pool.getLastGcStats().max));
     * @opensearch.internal
        memUsage = memoryMXBean.getNonHeapMemoryUsage();
 */
 * Licensed to Elasticsearch under one or more contributor
        }
                MemoryUsage collectionUsage = memoryPoolMXBean.getCollectionUsage();
        public MemoryPool(StreamInput in) throws IOException {
        builder.startObject(Fields.THREADS);
        return this.mem;
    }
            name = in.readString();
            nonHeapUsed = in.readVLong();
        builder.humanReadableField(Fields.HEAP_MAX_IN_BYTES, Fields.HEAP_MAX, new ByteSizeValue(mem.heapMax));
import java.lang.management.GarbageCollectorMXBean;
     */
        static final String NON_HEAP_COMMITTED_IN_BYTES = "non_heap_committed_in_bytes";
            this.totalLoadedClassCount = totalLoadedClassCount;
 * @opensearch.internal
        public void writeTo(StreamOutput out) throws IOException {
            peakMax = in.readVLong();
        static final String PEAK_USED = "peak_used";
            bufferPoolsList,
        }
        }
 * Holds JVM statistics
            out.writeVLong(peakMax);
        }
    public TimeValue getUptime() {
        private final long peakMax;
            classLoadingMXBean.getLoadedClassCount(),
        }
            return new ByteSizeValue(used);
    }
        }
        gc = new GarbageCollectors(in);
    public Mem getMem() {
            return peakCount;
            return new ByteSizeValue(peakUsed);
        classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
    /**
            used = in.readVLong();
        List<BufferPool> bufferPoolsList = Collections.emptyList();
 * The OpenSearch Contributors require contributions made to
        static final String BUFFER_POOLS = "buffer_pools";
            for (BufferPool bufferPool : bufferPools) {
            max = in.readVLong();
     * Stores the memory usage after the Java virtual machine
        }
            builder.humanReadableField(Fields.PEAK_USED_IN_BYTES, Fields.PEAK_USED, new ByteSizeValue(pool.peakUsed));
        private final int count;
                builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, new ByteSizeValue(bufferPool.used));
        for (GarbageCollector collector : gc) {
        this.timestamp = timestamp;
     */
        @Override
     * @opensearch.internal
        }
                }
            out.writeVLong(collectionTime);
     * Garbage collector references.
    }
    public long getTimestamp() {
        }
        public long getUnloadedClassCount() {
        }
            out.writeVLong(collectionCount);
            return new ByteSizeValue(max);
 */
        builder.humanReadableField(Fields.NON_HEAP_COMMITTED_IN_BYTES, Fields.NON_HEAP_COMMITTED, new ByteSizeValue(mem.nonHeapCommitted));
        timestamp = in.readVLong();
        static final String PEAK_COUNT = "peak_count";
    public static class Threads implements Writeable {
         * Returns the heap usage after last garbage collection cycle
    static {
            used = in.readLong();
            builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, new ByteSizeValue(pool.used));
            out.writeLong(totalLoadedClassCount);
            this.peakMax = peakMax;
        builder.endObject();
        }
        public void writeTo(StreamOutput out) throws IOException {
import java.util.concurrent.TimeUnit;
        static final String USED = "used";
        }
            used = in.readVLong();
            this.collectionCount = collectionCount;
        public ByteSizeValue getUsed() {
     *
        }
        public void writeTo(StreamOutput out) throws IOException {
            count = in.readLong();
        static final String COLLECTION_TIME_IN_MILLIS = "collection_time_in_millis";
     * A buffer pool.
    }
    }
 *
    private static final ClassLoadingMXBean classLoadingMXBean;
        }
    public List<BufferPool> getBufferPools() {
     * Memory data.
        static final String NON_HEAP_USED_IN_BYTES = "non_heap_used_in_bytes";
            name = in.readString();
            out.writeVLong(heapUsed);
        }
        builder.startObject(Fields.GC);
                );
        public short getUsagePercent() {
    /**
    }
        static final String HEAP_COMMITTED_IN_BYTES = "heap_committed_in_bytes";
        static final String PEAK_USED_IN_BYTES = "peak_used_in_bytes";
 * You may obtain a copy of the License at
            this.count = count;
        mem.writeTo(out);
    }
        }
import org.opensearch.common.unit.TimeValue;
        public void writeTo(StreamOutput out) throws IOException {
            this.max = max;
        public GarbageCollector[] getCollectors() {
        private final long max;
        private final long count;
        public BufferPool(String name, long count, long totalCapacity, long used) {
     * Class information.
            count = in.readVInt();
        builder.startObject(Fields.CLASSES);
        }
        static final String COLLECTION_TIME = "collection_time";
     *
        }
            this.max = max;
            nonHeapCommitted = in.readVLong();
        } catch (Exception e) {
 * KIND, either express or implied.  See the License for the
                bufferPoolsList.add(
            peakUsed = in.readVLong();
        out.writeVLong(uptime);
        public Iterator<GarbageCollector> iterator() {
            this.peakCount = peakCount;
        out.writeList(bufferPools);
            out.writeVInt(count);
 * GitHub history for details.
     * in particular memory pool.
                        peakUsage.getUsed() < 0 ? 0 : peakUsage.getUsed(),
                MemoryUsage usage = memoryPoolMXBean.getUsage();
                builder.field(Fields.COUNT, bufferPool.getCount());
    private final long timestamp;
        }
        }
    }
     *
        static final String TIMESTAMP = "timestamp";
        static final String HEAP_USED_IN_BYTES = "heap_used_in_bytes";
            heapMax = in.readVLong();
            }
                        peakUsage.getMax() < 0 ? 0 : peakUsage.getMax(),
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        private final long loadedClassCount;
import java.io.IOException;
        public void writeTo(StreamOutput out) throws IOException {
            this.used = used;
        public ByteSizeValue getMax() {
        return builder;
import java.lang.management.ThreadMXBean;
        public Threads(StreamInput in) throws IOException {
        public Classes(long loadedClassCount, long totalLoadedClassCount, long unloadedClassCount) {
            this.nonHeapUsed = nonHeapUsed;
     * A memory pool.
import org.opensearch.core.common.io.stream.StreamInput;
        static final String JVM = "jvm";
            this.peakUsed = peakUsed;
            this.collectionTime = collectionTime;
        private final int peakCount;
        for (int i = 0; i < collectors.length; i++) {
            builder.startObject(Fields.BUFFER_POOLS);
        }
        this.mem = mem;
            builder.endObject();
            return this.name;
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
         */
        );
        public ByteSizeValue getUsed() {
        return timestamp;
        builder.startObject(Fields.COLLECTORS);
     *
                    )
            threads,
    ) {
        runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        public void writeTo(StreamOutput out) throws IOException {
        public ByteSizeValue getPeakUsed() {
        long nonHeapUsed = memUsage.getUsed() < 0 ? 0 : memUsage.getUsed();
        private final String name;
        static final String PEAK_MAX = "peak_max";
                builder.startObject(bufferPool.getName());
        public ByteSizeValue getHeapMax() {
        long heapMax = memUsage.getMax() < 0 ? 0 : memUsage.getMax();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return new JvmStats(
        public String getName() {
            builder.startObject(collector.getName());
            builder.startObject(pool.getName());
                    Fields.TOTAL_CAPACITY,
    /**
        public ByteSizeValue getNonHeapCommitted() {
import java.lang.management.MemoryUsage;
import org.opensearch.core.xcontent.ToXContentFragment;
/*
        public ByteSizeValue getTotalCapacity() {
            out.writeVLong(heapMax);
                // For some pools, the collection usage may not be supported and the method returns null.
        threads = new Threads(in);
    public static class GarbageCollector implements Writeable {
        private final long used;
import java.util.Iterator;
        static final String COLLECTORS = "collectors";
        }
        public GarbageCollector(String name, long collectionCount, long collectionTime) {
            out.writeList(pools);
        }
        bufferPools = in.readList(BufferPool::new);
        this.bufferPools = bufferPools;
import java.util.Arrays;
                }
        static final String TOTAL_CAPACITY = "total_capacity";
            collectors = in.readArray(GarbageCollector::new, GarbageCollector[]::new);
        long heapCommitted = memUsage.getCommitted() < 0 ? 0 : memUsage.getCommitted();
            max = in.readVLong();
            if (heapMax == 0) {
        private final long collectionCount;
    }
        }
        builder.field(Fields.TIMESTAMP, timestamp);
        static final String HEAP_MAX_IN_BYTES = "heap_max_in_bytes";
        private final long max;
    public Classes getClasses() {
        public Mem(StreamInput in) throws IOException {
        long uptime,
        public String getName() {
        private final MemoryPoolGcStats lastGcStats;
            try {
        public ByteSizeValue getHeapUsed() {
         */
            return new ByteSizeValue(peakMax);
            builder.endObject();
            return loadedClassCount;
        public GarbageCollectors(GarbageCollector[] collectors) {
            );
            return new ByteSizeValue(heapCommitted);
            out.writeLong(totalCapacity);
            out.writeString(name);
        private final long heapMax;
 *
 * specific language governing permissions and limitations
        public void writeTo(StreamOutput out) throws IOException {
        @Override
            bufferPoolsList = new ArrayList<>(bufferPools.size());
            out.writeLong(count);
        }
import org.opensearch.core.common.unit.ByteSizeValue;
                        name,
        builder.endObject();
            heapCommitted = in.readVLong();
        MemoryUsage memUsage = memoryMXBean.getHeapMemoryUsage();
 * not use this file except in compliance with the License.
        static final String CURRENT_LOADED_COUNT = "current_loaded_count";
                pools.add(
     * most recently expended effort in recycling unused objects
     */
    private final long uptime;
import java.lang.management.ClassLoadingMXBean;
        }
        builder.endObject();
            return new ByteSizeValue(used);
        builder.field(Fields.CURRENT_LOADED_COUNT, classes.getLoadedClassCount());
        static final String CLASSES = "classes";
            runtimeMXBean.getUptime(),
     *
     */
        public Classes(StreamInput in) throws IOException {
        memoryMXBean = ManagementFactory.getMemoryMXBean();
            builder.humanReadableField(Fields.MAX_IN_BYTES, Fields.MAX, new ByteSizeValue(pool.max));
    public GarbageCollectors getGc() {
        private final long collectionTime;
                builder.humanReadableField(
        private final List<MemoryPool> pools;
            }
        private final String name;
            classLoadingMXBean.getTotalLoadedClassCount(),
 * software distributed under the License is distributed on an
        private final long heapCommitted;
                    new ByteSizeValue(bufferPool.totalCapacity)
        Threads threads,
            classes
            this.heapCommitted = heapCommitted;
        public ByteSizeValue getUsed() {
                            collectionUsage.getUsed() < 0 ? 0 : collectionUsage.getUsed(),
    }
            return totalLoadedClassCount;
            return count;
        public TimeValue getCollectionTime() {
        builder.humanReadableField(Fields.NON_HEAP_USED_IN_BYTES, Fields.NON_HEAP_USED, new ByteSizeValue(mem.nonHeapUsed));
        return new TimeValue(uptime);
    }
        }
            return lastGcStats;
        GarbageCollector[] collectors = new GarbageCollector[gcMxBeans.size()];
        }
            out.writeVLong(max);
        public long getCollectionCount() {
        static final String COUNT = "count";
        }
    }
    private final Threads threads;
        public void writeTo(StreamOutput out) throws IOException {
        static final String TOTAL_UNLOADED_COUNT = "total_unloaded_count";
            this.unloadedClassCount = unloadedClassCount;
        private final long totalLoadedClassCount;
        static final String MEM = "mem";
    public static JvmStats jvmStats() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public GarbageCollector(StreamInput in) throws IOException {
            out.writeLong(used);
        Mem mem,
        /**
     */
        static final String UPTIME_IN_MILLIS = "uptime_in_millis";
                    continue;
        static final String TOTAL_LOADED_COUNT = "total_loaded_count";
                        )
    public void writeTo(StreamOutput out) throws IOException {
            } catch (final Exception ignored) {
        return threads;
        public MemoryPoolGcStats(long used, long max) {
package org.opensearch.monitor.jvm;
    }
                builder.endObject();
                    collectionUsage = new MemoryUsage(0, 0, 0, 0);
            this.count = count;
        GarbageCollectors gc,
        GarbageCollectors garbageCollectors = new GarbageCollectors(collectors);
     *
                if (collectionUsage == null) {
            builder.endObject();
            return new ByteSizeValue(heapMax);
        builder.endObject();
     * @opensearch.internal
        /**
        public long getCount() {
        }
            this.lastGcStats = lastGcStats;
        static final String NON_HEAP_USED = "non_heap_used";
            collectionTime = in.readVLong();
            return unloadedClassCount;
