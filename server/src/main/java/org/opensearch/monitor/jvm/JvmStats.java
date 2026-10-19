        static final String POOLS = "pools";
    private final List<BufferPool> bufferPools;  
        this.gc = gc;
import java.lang.management.ThreadMXBean;  
            out.writeList(pools);
        );  
 * specific language governing permissions and limitations
            garbageCollectors,
                    continue;  
 * this work for additional information regarding copyright
        }  
        }  
        gc = new GarbageCollectors(in);
        GarbageCollectors garbageCollectors = new GarbageCollectors(collectors);  
                if (collectionUsage == null) {
        private final long used;  
            max = in.readVLong();  
            builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, new ByteSizeValue(pool.getLastGcStats().used));
            this.peakMax = peakMax;
            out.writeVLong(collectionTime);
        return bufferPools;  
            try {
            this.peakCount = peakCount;  
        Mem mem = new Mem(heapCommitted, heapUsed, heapMax, nonHeapCommitted, nonHeapUsed, Collections.unmodifiableList(pools));
            GarbageCollectorMXBean gcMxBean = gcMxBeans.get(i);
            out.writeVLong(heapUsed);
            this.collectors = collectors;
            return this.collectors;
        }
            if (max == 0) {  
import java.io.IOException;  
     * The garbage collector.  
package org.opensearch.monitor.jvm;
            this.count = count;
        }  
 * KIND, either express or implied.  See the License for the
        this.timestamp = timestamp;  
     *
        }  
    public static class Mem implements Writeable, Iterable<MemoryPool> {
        private final long loadedClassCount;  
            builder.endObject();  
        static final String COLLECTION_TIME = "collection_time";
            return (short) (heapUsed * 100 / heapMax);
    private final long uptime;
            return this.name;
        List<BufferPool> bufferPoolsList = Collections.emptyList();
    public static class GarbageCollector implements Writeable {
        private final long heapMax;
    @Override
            out.writeString(name);  
            out.writeVLong(used);  
        public Mem(long heapCommitted, long heapUsed, long heapMax, long nonHeapCommitted, long nonHeapUsed, List<MemoryPool> pools) {
     * @opensearch.internal
            return new ByteSizeValue(totalCapacity);  
                    new ByteSizeValue(bufferPool.totalCapacity)  
        @Override
/**
        }
            out.writeVLong(nonHeapUsed);  
import org.opensearch.core.xcontent.ToXContentFragment;  
            return new TimeValue(collectionTime, TimeUnit.MILLISECONDS);
        static final String PEAK_USED = "peak_used";  
            }
        }
 * Licensed to Elasticsearch under one or more contributor  
    static final class Fields {
    ) {
        public Iterator<GarbageCollector> iterator() {  
                builder.humanReadableField(  
        }  
    /**
        static final String MEM = "mem";
    public static JvmStats jvmStats() {  
 * license agreements. See the NOTICE file distributed with
        static final String HEAP_USED = "heap_used";  
        builder.field(Fields.CURRENT_LOADED_COUNT, classes.getLoadedClassCount());
        @Override
        long timestamp,
            return Arrays.stream(collectors).iterator();
            builder.startObject(collector.getName());  
        public ByteSizeValue getUsed() {  
 * Unless required by applicable law or agreed to in writing,
        this.mem = mem;
        static final String PEAK_MAX_IN_BYTES = "peak_max_in_bytes";  
            out.writeLong(loadedClassCount);  
        if (bufferPools != null) {  
                builder.startObject(bufferPool.getName());  
        gc.writeTo(out);
            bufferPoolsList = new ArrayList<>(bufferPools.size());
            unloadedClassCount = in.readLong();
        }
public class JvmStats implements Writeable, ToXContentFragment {
        public MemoryPool(String name, long used, long max, long peakUsed, long peakMax, MemoryPoolGcStats lastGcStats) {  
            }  
        static final String HEAP_COMMITTED_IN_BYTES = "heap_committed_in_bytes";  
        public long getLoadedClassCount() {
     */
            out.writeVLong(peakUsed);
     */
        }
        /**
 * compatible open source license.
        public void writeTo(StreamOutput out) throws IOException {
     * @opensearch.internal
                bufferPoolsList.add(  
        }
        static final String PEAK_MAX = "peak_max";
        builder.humanReadableField(Fields.NON_HEAP_COMMITTED_IN_BYTES, Fields.NON_HEAP_COMMITTED, new ByteSizeValue(mem.nonHeapCommitted));
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        static final String TOTAL_LOADED_COUNT = "total_loaded_count";
 *
    }
    private final long timestamp;
        }  
        builder.field(Fields.COUNT, threads.getCount());
        memUsage = memoryMXBean.getNonHeapMemoryUsage();
    }
            return new ByteSizeValue(heapMax);
        }  
    }
            return count;  
        long heapMax = memUsage.getMax() < 0 ? 0 : memUsage.getMax();
        }
            System.currentTimeMillis(),  
        builder.startObject(Fields.GC);
            } catch (final Exception ignored) {
        public long getCount() {
        return new JvmStats(
     */  
        static final String USED_IN_BYTES = "used_in_bytes";  
import java.lang.management.BufferPoolMXBean;
        static final String TOTAL_CAPACITY = "total_capacity";  
        static final String TOTAL_CAPACITY_IN_BYTES = "total_capacity_in_bytes";
        private final long totalLoadedClassCount;
            this.nonHeapCommitted = nonHeapCommitted;
        for (int i = 0; i < collectors.length; i++) {
            max = in.readVLong();  
        }  
            return this.name;  
        static final String NON_HEAP_USED = "non_heap_used";
        }  
        static final String UPTIME = "uptime";
            out.writeVLong(nonHeapCommitted);
import java.util.Collections;  
            this.unloadedClassCount = unloadedClassCount;
/*
        builder.startObject(Fields.COLLECTORS);
    /**
                return -1;  
        static final String HEAP_USED_IN_BYTES = "heap_used_in_bytes";
            used = in.readVLong();
        Threads threads = new Threads(threadMXBean.getThreadCount(), threadMXBean.getPeakThreadCount());  
        mem = new Mem(in);  
        builder.field(Fields.PEAK_COUNT, threads.getPeakCount());
        public ByteSizeValue getNonHeapUsed() {  
        static final String COLLECTORS = "collectors";  
            classLoadingMXBean.getUnloadedClassCount()
        }
            name = in.readString();
        private final long peakMax;  
            builder.field(Fields.COLLECTION_COUNT, collector.getCollectionCount());
            return this.count;
            this.heapUsed = heapUsed;  
        Classes classes = new Classes(
    }  
        static final String HEAP_MAX = "heap_max";  
        builder.endObject();
        }
        this.classes = classes;  
            out.writeVLong(heapMax);
            name = in.readString();
/*  
        return threads;
                builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, new ByteSizeValue(bufferPool.used));
                        new MemoryPoolGcStats(  
            return new ByteSizeValue(peakUsed);
        Mem mem,  
            builder.humanReadableField(Fields.PEAK_MAX_IN_BYTES, Fields.PEAK_MAX, new ByteSizeValue(pool.peakMax));
        for (MemoryPool pool : mem) {
        private final long count;
        private final long nonHeapUsed;
        for (GarbageCollector collector : gc) {
        public void writeTo(StreamOutput out) throws IOException {
            heapMax = in.readVLong();  
        List<BufferPool> bufferPools,  
        );
            peakUsed = in.readVLong();
    public static class MemoryPool implements Writeable {  
     *  
            return (short) (used * 100 / max);  
    }
            for (BufferPoolMXBean bufferPool : bufferPools) {
            out.writeString(name);
        return builder;
        if (mem.getHeapUsedPercent() >= 0) {
        for (MemoryPoolMXBean memoryPoolMXBean : memoryPoolMXBeans) {
        }
 * ownership. Elasticsearch licenses this file to you under  
        List<MemoryPool> pools = new ArrayList<>();  
    public void writeTo(StreamOutput out) throws IOException {
        long nonHeapCommitted = memUsage.getCommitted() < 0 ? 0 : memUsage.getCommitted();
        memoryMXBean = ManagementFactory.getMemoryMXBean();
                    Fields.TOTAL_CAPACITY_IN_BYTES,
        public void writeTo(StreamOutput out) throws IOException {
        public String getName() {
        @Override
        private final long nonHeapCommitted;  
 *  
            this.count = count;
import org.opensearch.common.unit.TimeValue;
        runtimeMXBean = ManagementFactory.getRuntimeMXBean();  
            this.used = used;  
                if (name == null) { // if we can't resolve it, its not interesting.... (Per Gen, Code Cache)
        static final String COLLECTION_TIME_IN_MILLIS = "collection_time_in_millis";  
    public List<BufferPool> getBufferPools() {
        static final String HEAP_USED_PERCENT = "heap_used_percent";
            out.writeLong(totalCapacity);
 * not use this file except in compliance with the License.
        public void writeTo(StreamOutput out) throws IOException {
            runtimeMXBean.getUptime(),
        out.writeList(bufferPools);
 * this file be licensed under the Apache-2.0 license or a
            collectors[i] = new GarbageCollector(  
        }
import org.opensearch.core.common.io.stream.StreamInput;
            builder.humanReadableField(Fields.COLLECTION_TIME_IN_MILLIS, Fields.COLLECTION_TIME, new TimeValue(collector.collectionTime));
        }  
        builder.endObject();
            return loadedClassCount;  
        @Override
    /**
        public GarbageCollector[] getCollectors() {
            this.used = used;
            builder.humanReadableField(Fields.MAX_IN_BYTES, Fields.MAX, new ByteSizeValue(pool.getLastGcStats().max));
        }  
import java.util.List;
        }
        public ByteSizeValue getHeapUsed() {
        /**  
 * You may obtain a copy of the License at  
 */  
        public int getPeakCount() {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Iterator;
        builder.startObject(Fields.JVM);  
        public MemoryPoolGcStats(StreamInput in) throws IOException {
        static final String UPTIME_IN_MILLIS = "uptime_in_millis";  
        static final String MAX_IN_BYTES = "max_in_bytes";
     * @opensearch.internal
 */
            builder.field(Fields.HEAP_USED_PERCENT, mem.getHeapUsedPercent());
     *
        timestamp = in.readVLong();
                }  
            this.lastGcStats = lastGcStats;  
    private final GarbageCollectors gc;
     * Garbage collector references.
    }
        public long getCollectionCount() {  
        static final String NON_HEAP_COMMITTED = "non_heap_committed";
    public Threads getThreads() {  
            count = in.readLong();
        }
                        peakUsage.getUsed() < 0 ? 0 : peakUsage.getUsed(),
        builder.humanReadableField(Fields.HEAP_USED_IN_BYTES, Fields.HEAP_USED, new ByteSizeValue(mem.heapUsed));  
            }  
            classLoadingMXBean.getTotalLoadedClassCount(),
                String name = GcNames.getByMemoryPoolName(memoryPoolMXBean.getName(), null);
 *
        this.uptime = uptime;
            used = in.readLong();
            this.max = max;  
        builder.endObject();
    }  
            out.writeVInt(count);
    private static final ThreadMXBean threadMXBean;
            collectors = in.readArray(GarbageCollector::new, GarbageCollector[]::new);
 * Modifications Copyright OpenSearch Contributors. See
        }
    public GarbageCollectors getGc() {
            this.nonHeapUsed = nonHeapUsed;  
                    collectionUsage = new MemoryUsage(0, 0, 0, 0);
            used = in.readVLong();
        threads = new Threads(in);
    public TimeValue getUptime() {
        static final String CLASSES = "classes";  
        classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();  
            out.writeVLong(collectionCount);
        private final long totalCapacity;
        public ByteSizeValue getTotalCapacity() {
        static final String PEAK_COUNT = "peak_count";  
        classes = new Classes(in);
     * most recently expended effort in recycling unused objects
        /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return new ByteSizeValue(max);
                // For some pools, the collection usage may not be supported and the method returns null.  
        public short getUsagePercent() {
        }  
import java.lang.management.RuntimeMXBean;
        GarbageCollector[] collectors = new GarbageCollector[gcMxBeans.size()];  
        private final long collectionCount;
    public Classes getClasses() {  
        }
        public long getUnloadedClassCount() {
        public Classes(long loadedClassCount, long totalLoadedClassCount, long unloadedClassCount) {
     * A buffer pool.  
        Classes classes
        builder.field(Fields.TOTAL_UNLOADED_COUNT, classes.getUnloadedClassCount());
            count = in.readVInt();
            classLoadingMXBean.getLoadedClassCount(),  
    /**
import java.util.concurrent.TimeUnit;  
        public void writeTo(StreamOutput out) throws IOException {
        List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();
     *
        }  
         * returns the maximum heap size. 0 bytes signals unknown.
                    new MemoryPool(  
        static final String COUNT = "count";
     * Memory data.  
        @Override
            return new ByteSizeValue(used);  
                MemoryUsage usage = memoryPoolMXBean.getUsage();  
            out.writeVInt(peakCount);
        private final String name;  
     *
        long heapCommitted = memUsage.getCommitted() < 0 ? 0 : memUsage.getCommitted();  
                        usage.getMax() < 0 ? 0 : usage.getMax(),  
        public ByteSizeValue getHeapMax() {  
    static {
        public MemoryPool(StreamInput in) throws IOException {  
            peakCount = in.readVInt();
        static final String HEAP_COMMITTED = "heap_committed";
            out.writeVLong(heapCommitted);  
        public Classes(StreamInput in) throws IOException {
        private final int peakCount;
    public static class GarbageCollectors implements Writeable, Iterable<GarbageCollector> {
 *    http://www.apache.org/licenses/LICENSE-2.0
        static final String NON_HEAP_COMMITTED_IN_BYTES = "non_heap_committed_in_bytes";
            builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, new ByteSizeValue(pool.used));  
    public static class BufferPool implements Writeable {
        threads.writeTo(out);  
                    new BufferPool(bufferPool.getName(), bufferPool.getCount(), bufferPool.getTotalCapacity(), bufferPool.getMemoryUsed())
                        name,
    private static final ClassLoadingMXBean classLoadingMXBean;  
        public int getCount() {
        }
        public long getTotalLoadedClassCount() {  
        }  
            List<BufferPoolMXBean> bufferPools = ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class);  
            return lastGcStats;
 * SPDX-License-Identifier: Apache-2.0
        @Override
    public JvmStats(  
        builder.startObject(Fields.THREADS);  
                GcNames.getByGcName(gcMxBean.getName(), gcMxBean.getName()),
import org.opensearch.core.common.io.stream.StreamOutput;  
        MemoryUsage memUsage = memoryMXBean.getHeapMemoryUsage();
    public JvmStats(StreamInput in) throws IOException {  
        public void writeTo(StreamOutput out) throws IOException {  
 * GitHub history for details.
        public GarbageCollector(String name, long collectionCount, long collectionTime) {
                    Fields.TOTAL_CAPACITY,
    }  
        public Mem(StreamInput in) throws IOException {
            this.pools = pools;
    private static final RuntimeMXBean runtimeMXBean;  
        this.threads = threads;  
        builder.endObject();
    }
        }
            this.heapCommitted = heapCommitted;
/*  
        }
        classes.writeTo(out);  
     * A memory pool.
     */  
                builder.field(Fields.COUNT, bufferPool.getCount());
        }
                );
            builder.endObject();
        static final String TOTAL_UNLOADED_COUNT = "total_unloaded_count";  
        static final String NON_HEAP_USED_IN_BYTES = "non_heap_used_in_bytes";  
        static final String HEAP_MAX_IN_BYTES = "heap_max_in_bytes";
     */  
        public void writeTo(StreamOutput out) throws IOException {
            pools = in.readList(MemoryPool::new);
        }  
        static final String TIMESTAMP = "timestamp";
        private final String name;
        }
    private final Threads threads;
import java.util.ArrayList;
        builder.startObject(Fields.POOLS);  
        static final String BUFFER_POOLS = "buffer_pools";
            nonHeapCommitted = in.readVLong();
    public long getTimestamp() {  
        }
    public static class Classes implements Writeable {
     * Class information.  
        public ByteSizeValue getHeapCommitted() {
        static final String LAST_GC_STATS = "last_gc_stats";
        }
            }  
        public ByteSizeValue getMax() {
        return this.mem;  
                );
    }  
         * Returns the heap usage after last garbage collection cycle
        static final String USAGE_PERCENT = "usage_percent";
            this.name = name;
        @Override  
        static final String MAX = "max";
        } catch (Exception e) {
            classes  
    }
                            collectionUsage.getUsed() < 0 ? 0 : collectionUsage.getUsed(),
    /**  
                MemoryUsage peakUsage = memoryPoolMXBean.getPeakUsage();
    @Override
        try {
        }
            this.heapMax = heapMax;
        }  
            return new ByteSizeValue(used);
            threads,  
     * Thread information.
        }
            lastGcStats = new MemoryPoolGcStats(in);  
         */  
        private final long used;
        builder.startObject(Fields.CLASSES);
        public BufferPool(String name, long count, long totalCapacity, long used) {
        }
            return peakCount;
        }
    }
        builder.humanReadableField(Fields.UPTIME_IN_MILLIS, Fields.UPTIME, new TimeValue(uptime));
 * The OpenSearch Contributors require contributions made to  
        private final GarbageCollector[] collectors;
            this.collectionTime = collectionTime;
            totalCapacity = in.readLong();  
            builder.endObject();
        }
            // buffer pools are not available
        public ByteSizeValue getUsed() {
        builder.endObject();
        bufferPools = in.readList(BufferPool::new);  
 * under the License.  
                builder.endObject();
        out.writeVLong(timestamp);  
        static final String THREADS = "threads";
     *  
        Threads threads,
    private static final MemoryMXBean memoryMXBean;
import org.opensearch.core.common.io.stream.Writeable;
                            collectionUsage.getMax() < 0 ? 0 : collectionUsage.getMax()
            builder.startObject(pool.getName());
            peakMax = in.readVLong();
        public String getName() {
import java.lang.management.GarbageCollectorMXBean;  
                );
            return new ByteSizeValue(heapCommitted);
 * software distributed under the License is distributed on an
     * @opensearch.internal
            totalLoadedClassCount = in.readLong();  
                pools.add(
        this.bufferPools = bufferPools;
 * @opensearch.internal
        builder.humanReadableField(Fields.NON_HEAP_USED_IN_BYTES, Fields.NON_HEAP_USED, new ByteSizeValue(mem.nonHeapUsed));  
        public MemoryPoolGcStats(long used, long max) {
            return new ByteSizeValue(nonHeapCommitted);  
 */  
            this.name = name;
        }
            this.used = used;  
        private final long max;  
    }  
            builder.startObject(Fields.LAST_GC_STATS);  
     * @opensearch.internal
        private final MemoryPoolGcStats lastGcStats;
            out.writeLong(unloadedClassCount);
import java.lang.management.MemoryMXBean;
                        usage.getUsed() < 0 ? 0 : usage.getUsed(),
        }
        private final String name;  
     * @opensearch.internal
        }
        out.writeVLong(uptime);
                gcMxBean.getCollectionCount(),
            out.writeVLong(max);  
        @Override
            out.writeArray(collectors);
        public BufferPool(StreamInput in) throws IOException {  
    public static class MemoryPoolGcStats implements Writeable {  
    }
            mem,
        private final long unloadedClassCount;
        public ByteSizeValue getUsed() {  
        GarbageCollectors gc,
            );
    }
            out.writeVLong(used);
            builder.field(Fields.USAGE_PERCENT, pool.getLastGcStats().getUsagePercent());  
        return new TimeValue(uptime);
         */
        static final String CURRENT_LOADED_COUNT = "current_loaded_count";
        }
import java.lang.management.MemoryUsage;
            builder.humanReadableField(Fields.MAX_IN_BYTES, Fields.MAX, new ByteSizeValue(pool.max));
        mem.writeTo(out);
            this.name = name;  
        }
        public GarbageCollectors(GarbageCollector[] collectors) {  
    }
            loadedClassCount = in.readLong();
            bufferPoolsList,
        }  
import java.lang.management.ClassLoadingMXBean;
        long heapUsed = memUsage.getUsed() < 0 ? 0 : memUsage.getUsed();
     * @opensearch.internal  
            return new ByteSizeValue(nonHeapUsed);
        public void writeTo(StreamOutput out) throws IOException {  
            lastGcStats.writeTo(out);
     */
            return new ByteSizeValue(max);
        }
        @Override  
    public Mem getMem() {
        builder.humanReadableField(Fields.HEAP_COMMITTED_IN_BYTES, Fields.HEAP_COMMITTED, new ByteSizeValue(mem.heapCommitted));
            builder.endObject();  
    private final Mem mem;  
            out.writeVLong(max);
 *
        private final long peakUsed;
                        )  
        public ByteSizeValue getPeakMax() {
            out.writeVLong(peakMax);  
                return -1;
     */  
        static final String COLLECTION_COUNT = "collection_count";
            return new ByteSizeValue(peakMax);  
            this.max = max;
            this.totalCapacity = totalCapacity;
 */  
        builder.field(Fields.TIMESTAMP, timestamp);
        static final String GC = "gc";
            return this.name;
                    )
            for (BufferPool bufferPool : bufferPools) {
        threadMXBean = ManagementFactory.getThreadMXBean();
            builder.startObject(Fields.BUFFER_POOLS);
        public Iterator<MemoryPool> iterator() {  
        public ByteSizeValue getPeakUsed() {
     * Stores the memory usage after the Java virtual machine  
import org.opensearch.core.common.unit.ByteSizeValue;
            heapUsed = in.readVLong();  
        static final String JVM = "jvm";  
     *
        builder.endObject();
                }
        static final String USED = "used";
        uptime = in.readVLong();
        builder.humanReadableField(Fields.HEAP_MAX_IN_BYTES, Fields.HEAP_MAX, new ByteSizeValue(mem.heapMax));
        builder.field(Fields.TOTAL_LOADED_COUNT, classes.getTotalLoadedClassCount());  
        private final int count;
        return gc;
            nonHeapUsed = in.readVLong();
            return new ByteSizeValue(heapUsed);  
    /**
        private final long collectionTime;
    /**  
            name = in.readString();
        }
        return classes;
            this.peakUsed = peakUsed;
}
            collectionTime = in.readVLong();
        }
        public short getHeapUsedPercent() {
import java.lang.management.ManagementFactory;
            out.writeLong(count);
        public ByteSizeValue getMax() {  
            return pools.iterator();
        return timestamp;
     * @opensearch.internal  
     *
        private final List<MemoryPool> pools;
        long uptime,
            builder.humanReadableField(Fields.PEAK_USED_IN_BYTES, Fields.PEAK_USED, new ByteSizeValue(pool.peakUsed));  
        private final long heapCommitted;  
        }
        public GarbageCollector(StreamInput in) throws IOException {
            return new ByteSizeValue(used);
        public TimeValue getCollectionTime() {
            out.writeLong(used);  
import org.opensearch.core.xcontent.XContentBuilder;
import java.lang.management.MemoryPoolMXBean;  
    }
        public GarbageCollectors(StreamInput in) throws IOException {
        builder.startObject(Fields.MEM);
            return totalLoadedClassCount;
        public MemoryPoolGcStats getLastGcStats() {  
            return this.collectionCount;
    }  
         */
        }
        }
         * returns the heap usage in percent. -1 signals unknown.
        }
        }
        }
    }
            out.writeLong(totalLoadedClassCount);
        static final String PEAK_USED_IN_BYTES = "peak_used_in_bytes";
            collectionCount = in.readVLong();  
        public Threads(StreamInput in) throws IOException {  
import java.util.Arrays;
    }  
        public ByteSizeValue getNonHeapCommitted() {
                gcMxBean.getCollectionTime()  
        builder.endObject();  
        }
            this.collectionCount = collectionCount;  
        }
    }
     */
            this.totalLoadedClassCount = totalLoadedClassCount;  
 * Holds JVM statistics  
                MemoryUsage collectionUsage = memoryPoolMXBean.getCollectionUsage();
        }
    /**
    private final Classes classes;
        private final long heapUsed;
     * in particular memory pool.
        public String getName() {  
            out.writeString(name);  
        public Threads(int count, int peakCount) {
            return unloadedClassCount;
        private final long max;
    }  
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        private final long used;  
        long nonHeapUsed = memUsage.getUsed() < 0 ? 0 : memUsage.getUsed();  
            heapCommitted = in.readVLong();
            this.loadedClassCount = loadedClassCount;
    public static class Threads implements Writeable {
                        peakUsage.getMax() < 0 ? 0 : peakUsage.getMax(),
            if (heapMax == 0) {
            }
        @Override
