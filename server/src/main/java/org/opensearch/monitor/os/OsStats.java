         * @return A new OsStats instance.
    public Mem getMem() {
        this.timestamp = timestamp;  
import org.opensearch.core.common.unit.ByteSizeValue;
    /**
    public static class Mem implements Writeable, ToXContentFragment {
                        builder.field("control_group", memoryControlGroup);
        static final String TIMESTAMP = "timestamp";
        this.swap = new Swap(in);
            final String memoryLimitInBytes,
                return numberOfTimesThrottled;  
                        if (memoryLimitInBytes != null) {
            out.writeLong(cpuAcctUsageNanos);  
    public Cgroup getCgroup() {
            builder.field(Fields.PERCENT, getPercent());
            builder.endObject();  
            final CpuStat cpuStat,
            }  
         */  
         * @return the CPU time statistics.  
         */
                builder.startObject("stat");
        private Cgroup cgroup = null;
     */  
         *
        @Override  
        private final long total;  
     */  
         */
    static final class Fields {
        }
    @Override  
                if (getLoadAverage()[2] != -1) {
        @Override  
            this.mem = mem;
            this.total = total;  
            builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, getTotal());  
                }  
        builder.endObject();
         *
/*
    /**
        }  
         * @opensearch.api
        }
                numberOfElapsedPeriods = in.readLong();
            return memoryUsageInBytes;
            public long getTimeThrottledNanos() {  
            this.cpuAcctControlGroup = Objects.requireNonNull(cpuAcctControlGroup);
            return cpuControlGroup;
             * The number of elapsed periods.
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api  
        }
        static final String FREE_PERCENT = "free_percent";  
            memoryControlGroup = in.readOptionalString();
                return numberOfElapsedPeriods;
                    {  
     */  
             *  
        private static final Logger logger = LogManager.getLogger(Swap.class);
        }
         *  
        /**  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return new ByteSizeValue(total - free);
            }  
         *
            return calculatePercentage(free, total);
    @PublicApi(since = "1.0.0")
     * OS Memory information.  
            out.writeLong(cpuCfsPeriodMicros);
}
    }
                this.numberOfElapsedPeriods = numberOfElapsedPeriods;
        public Builder swap(Swap swap) {
    }
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
            return cpuAcctUsageNanos;
             */  
    }  
                }
             */
        }
            this.cgroup = cgroup;
 * Unless required by applicable law or agreed to in writing,
                return new ByteSizeValue(0);  
        /**
        static final String TOTAL = "total";  
    @PublicApi(since = "1.0.0")
            cpuAcctUsageNanos = in.readLong();
        public ByteSizeValue getUsed() {  
        }
     * This constructor will be deprecated starting in version 3.4.0.
            builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, getTotal());
                this.loadAverage = in.readDoubleArray();  
        private final long cpuAcctUsageNanos;
            if (in.readBoolean()) {
                }  
            }
         */  
        }
        }
            this.cpuCfsPeriodMicros = cpuCfsPeriodMicros;
            /**
        public String getCpuAcctControlGroup() {
        this.cpu = new Cpu(in);  
         *
                    builder.field(Fields.LOAD_AVERAGE_15M, getLoadAverage()[2]);
                if (free > 0) {  
        /**  
        }
                // We intentionally check for (total == 0) rather than (total - free < 0) so as not to hide
        static final String PERCENT = "percent";  
    public Swap getSwap() {  
                    builder.field("cfs_quota_micros", cpuCfsQuotaMicros);  
                    builder.field(Fields.LOAD_AVERAGE_5M, getLoadAverage()[1]);
            return percent;  
    }
import org.apache.logging.log4j.Logger;
    }  
package org.opensearch.monitor.os;
                //  
 */  
import org.opensearch.core.xcontent.ToXContentFragment;
        public String getCpuControlGroup() {
        public static class CpuStat implements Writeable, ToXContentFragment {
        /**  
            if (total == 0) {
        this.cgroup = cgroup;
    public static class Cgroup implements Writeable, ToXContentFragment {
            final String cpuAcctControlGroup,  
            assert free >= 0 : "expected free memory to be positive, got: " + total;
            }
                out.writeLong(numberOfElapsedPeriods);  
            this.cpuControlGroup = Objects.requireNonNull(cpuControlGroup);  
        }
                // We intentionally check for (total == 0) rather than (total - free < 0) so as not to hide  
        }
        }  
            assert total >= 0 : "expected total memory to be positive, got: " + total;
         * The total CPU time consumed by all tasks in the
             *  
            out.writeOptionalString(memoryLimitInBytes);  
            assert free >= 0 : "expected free memory to be positive, got: " + total;
         * Creates a {@link OsStats} object from the builder's current state.
 *
        @PublicApi(since = "1.0.0")  
        cpu.writeTo(out);  
                timeThrottledNanos = in.readLong();
        public ByteSizeValue getTotal() {
            out.writeShort(percent);
            if (loadAverage == null) {  
            cgroup.toXContent(builder, params);
        public Builder cpu(Cpu cpu) {
            @Override
 * ownership. Elasticsearch licenses this file to you under  
     * Swap information.  
         */
        }  
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
        public short getPercent() {
        }
    }
                if (memoryControlGroup != null) {
        return max <= 0 ? 0 : (short) (Math.round((100d * used) / max));
        }
        }
        return timestamp;
        }
            memoryUsageInBytes = in.readOptionalString();  
         *
                // cases where (free > total) which would be a different bug.
                    builder.endObject();  
    }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                        }
            memoryLimitInBytes = in.readOptionalString();
                out.writeBoolean(true);  
            public long getNumberOfTimesThrottled() {
        private final double[] loadAverage;
            final long cpuAcctUsageNanos,
        /**
                this.loadAverage = null;
            this.timestamp = timestamp;  
        /**  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *
 * under the License.  
            builder.humanReadableField(Fields.FREE_IN_BYTES, Fields.FREE, getFree());
        private final long total;  
     * Private constructor that takes a builder.  
                builder.startObject("cpu");
            return new ByteSizeValue(free);  
            }
        }
            builder.humanReadableField(Fields.FREE_IN_BYTES, Fields.FREE, getFree());
                    builder.startObject("memory");
            out.writeLong(total);
                this.timeThrottledNanos = timeThrottledNanos;
    }
 * Holds stats for the Operating System
        private Mem mem = null;
            } else {
        swap.writeTo(out);
        this.timestamp = in.readVLong();
 * SPDX-License-Identifier: Apache-2.0
            }
        private Swap swap = null;  
 * specific language governing permissions and limitations
        public long getCpuCfsQuotaMicros() {
        Cgroup(final StreamInput in) throws IOException {  
            return memoryControlGroup;  
                builder.startObject(Fields.LOAD_AVERAGE);  
        public CpuStat getCpuStat() {
import org.apache.logging.log4j.LogManager;
                out.writeLong(timeThrottledNanos);
         * The control group for the {@code memory} subsystem.
        static final String OS = "os";  
    public static class Swap implements Writeable, ToXContentFragment {
        }
            public void writeTo(final StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
                        }
                builder.endObject();  
        private static final Logger logger = LogManager.getLogger(Mem.class);
            return this;
                {  
        /**  
            this.percent = systemCpuPercent;
        public void writeTo(StreamOutput out) throws IOException {  
            final String memoryControlGroup,  
     *
        }
        public ByteSizeValue getTotal() {
        }
         */
            this.free = in.readLong();
        private final long cpuCfsPeriodMicros;
                    logger.debug("cannot compute used swap when total swap is 0 and free swap is " + free);
    @PublicApi(since = "1.0.0")
        builder.field(Fields.TIMESTAMP, getTimestamp());  
            }
                }
            builder.endObject();  
        }  
                // those cases, we force it to zero in which case we can no longer correctly report the used swap
        /**
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }
        static final String MEM = "mem";  
     */  
            this.total = total;  
            final long cpuCfsPeriodMicros,  
            return new ByteSizeValue(total);  
        }
        this.cpu = builder.cpu;  
         * Encapsulates CPU time statistics.
             * {@code cpu.cfs_period_us}
            assert total >= 0 : "expected total memory to be positive, got: " + total;  
            assert free >= 0 : "expected free swap to be positive, got: " + total;
        private final CpuStat cpuStat;  
     * @opensearch.api
        private final long free;
                {
/*  
            }  
         * @return the total current memory usage by processes in the cgroup (in bytes).
        static final String LOAD_AVERAGE_5M = "5m";  
                builder.startObject("cpuacct");
        @Override
            this.total = in.readLong();
        static final String FREE_IN_BYTES = "free_in_bytes";  
 *  
            cpuStat.writeTo(out);
         * The CPU time statistics. See {@link CpuStat}.
        @Override
            return cpuStat;  
        cpu.toXContent(builder, params);
    /**  
            return memoryLimitInBytes;
             *
         * This is stored as a <code>String</code> for consistency with <code>memoryLimitInBytes</code>.  
            builder.endObject();  
                return new ByteSizeValue(0);
         * The total current memory usage by processes in the cgroup (in bytes).
        this.cpu = Objects.requireNonNull(cpu);
import org.opensearch.common.annotation.PublicApi;  
        }
         */  
         * The control group for the {@code cpu} subsystem.  
 */
        private final long free;
            public long getNumberOfElapsedPeriods() {
import org.opensearch.core.xcontent.XContentBuilder;  
                        if (memoryUsageInBytes != null) {
    @PublicApi(since = "1.0.0")
            this.total = in.readLong();
    @Deprecated
                // The work in https://github.com/elastic/elasticsearch/pull/42725 established that total memory
            out.writeString(cpuAcctControlGroup);
            out.writeString(cpuControlGroup);
         * The control group for the {@code cpuacct} subsystem.
                    }
     * Provides a fluent API for constructing a OsStats object.  
        public Builder cgroup(Cgroup cgroup) {
        }  
         * The maximum amount of user memory (including file cache).
        static final String SWAP = "swap";
            builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, getUsed());  
                    builder.field("time_throttled_nanos", timeThrottledNanos);
     *
                }
        this.mem = Objects.requireNonNull(mem);
         *  
         * This is stored as a <code>String</code> because the value can be too big to fit in a
            builder.endObject();  
    }
        private Cpu cpu = null;
            return this;  
            final String memoryUsageInBytes
        this.swap = builder.swap;
        public Mem(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
            } else {
        return builder;
    }  
    /**
        }
    @Override  
        }
    }
                    builder.field("control_group", cpuControlGroup);
        static final String CPU = "cpu";
        @Override
            cpuControlGroup = in.readString();  
        public ByteSizeValue getFree() {
        private final String cpuAcctControlGroup;
 * compatible open source license.
    }
            public CpuStat(final long numberOfElapsedPeriods, final long numberOfTimesThrottled, final long timeThrottledNanos) {
                // as (total-free) and should report it as zero.
    private final Mem mem;
            assert total >= 0 : "expected total swap to be positive, got: " + total;  
        }
            final String cpuControlGroup,
        mem.toXContent(builder, params);
import org.opensearch.core.common.io.stream.Writeable;  
                    builder.field("number_of_times_throttled", numberOfTimesThrottled);
public class OsStats implements Writeable, ToXContentFragment {  
                // can be reported as negative in some cases. Swap can similarly be reported as negative and in  
        public long getCpuAcctUsageNanos() {
        /**  
    }  
            {
    public OsStats(final long timestamp, final Cpu cpu, final Mem mem, final Swap swap, final Cgroup cgroup) {
            cpuCfsPeriodMicros = in.readLong();
 * You may obtain a copy of the License at  
        this.swap = Objects.requireNonNull(swap);  
                {  
    private final Swap swap;
        private final short percent;
            cpuAcctControlGroup = in.readString();
         */
        /**
            builder.startObject(Fields.SWAP);
                    logger.debug("cannot compute used memory when total memory is 0 and free memory is " + free);  
        public OsStats build() {
            }
                            builder.field("usage_in_bytes", memoryUsageInBytes);  
                builder.endObject();
 * KIND, either express or implied.  See the License for the
            }  
    public static class Builder {
        public short getFreePercent() {  
            return new ByteSizeValue(total);  
            this.free = free;
        }
         *
    }
                    builder.field(Fields.LOAD_AVERAGE_1M, getLoadAverage()[0]);
 */
        public void writeTo(final StreamOutput out) throws IOException {
         * The period of time for how frequently the control group from  
                out.writeDoubleArray(loadAverage);
            assert free >= 0 : "expected free swap to be positive, got: " + total;
         * it would not be possible to index the OS stats document into OpenSearch without
     */  
                }
            this.cpuAcctUsageNanos = cpuAcctUsageNanos;
                if (free > 0) {
             */
        }
        }
            return loadAverage;
         * group from {@link Cgroup#cpuControlGroup} can run in one  
            assert total >= 0 : "expected total swap to be positive, got: " + total;
            return cpuCfsPeriodMicros;
 * software distributed under the License is distributed on an
        static final String USED = "used";
                builder.endObject();
        this.timestamp = builder.timestamp;
            final long cpuCfsQuotaMicros,
        }  
            private final long numberOfTimesThrottled;
        out.writeOptionalWriteable(cgroup);  
     * Use {@link Builder} instead.
                // can be reported as negative in some cases. In those cases, we force it to zero in which case  
            /**  
 * not use this file except in compliance with the License.
    public long getTimestamp() {  
                if (getLoadAverage()[1] != -1) {
            /**
            out.writeLong(free);
            this.free = in.readLong();
            this.loadAverage = systemLoadAverage;  
        public Swap(StreamInput in) throws IOException {
        public double[] getLoadAverage() {  
            }  
        public Cpu(short systemCpuPercent, double[] systemLoadAverage) {
            out.writeLong(total);
    private final Cpu cpu;  
            this.memoryControlGroup = memoryControlGroup;
     * Encapsulates basic cgroup statistics.  
         * {@code cpuacct} control group from
                }  
            return cpuCfsQuotaMicros;  
            return builder;
         * @return the period of time in microseconds
 * Modifications Copyright OpenSearch Contributors. See
        static final String TOTAL_IN_BYTES = "total_in_bytes";
        this.cgroup = builder.cgroup;  
            builder.startObject(Fields.CPU);  
     *
        public Swap(long total, long free) {  
            out.writeOptionalString(memoryControlGroup);
    private OsStats(Builder builder) {
        public Builder() {}  
        }  
            this.free = free;
                // cases where (free > total) which would be a different bug.
             * @return the total time in nanoseconds
            return builder;
    }
                    cpuStat.toXContent(builder, params);
            this.swap = swap;  
            return new OsStats(this);
            out.writeLong(cpuCfsQuotaMicros);  
        }  
        }  
                builder.endObject();
    public static short calculatePercentage(long used, long max) {  
         * {@link Cgroup#cpuAcctControlGroup}.  
     * @opensearch.api
    /**
            cpuStat = new CpuStat(in);  
        public ByteSizeValue getFree() {
        @Override
        return swap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        static final String LOAD_AVERAGE_15M = "15m";
         * period as represented by {@link Cgroup#cpuCfsPeriodMicros}.
         * {@link Cgroup#cpuControlGroup} has its access to CPU
        private final String memoryControlGroup;
        public Cgroup(
             * throttled.
            return calculatePercentage(getUsed().getBytes(), total);
     * This is the sole entry point for creating a new OsStats object.
         * The total amount of time for which all tasks in the control
                    builder.field("control_group", cpuAcctControlGroup);
        static final String FREE = "free";
            if (total == 0) {
        @Override  
    public OsStats(StreamInput in) throws IOException {
import java.io.IOException;
        ) {  
        this.mem = new Mem(in);
         *  
    /**
        private final String memoryLimitInBytes;  
import java.util.Arrays;  
        }  
                    builder.field("number_of_elapsed_periods", numberOfElapsedPeriods);  
 */  
        /**
        }  
            builder.field(Fields.USED_PERCENT, getUsedPercent());
        if (cgroup != null) {
        // These will be null for nodes running versions prior to 6.1.0
             * @return the number of times  
        public String getMemoryLimitInBytes() {  
            this.percent = in.readShort();
                // we can no longer correctly report the used memory as (total-free) and should report it as zero.
        private final String memoryUsageInBytes;
        public long getCpuCfsPeriodMicros() {  
     * @opensearch.api
            out.writeOptionalString(memoryUsageInBytes);
                out.writeBoolean(false);
        static final String USED_PERCENT = "used_percent";
                            builder.field("limit_in_bytes", memoryLimitInBytes);  
/*  
     */  
        return mem;  
        public String getMemoryControlGroup() {
            this.cpuStat = Objects.requireNonNull(cpuStat);  
                return timeThrottledNanos;
            return builder;
        public ByteSizeValue getUsed() {  
     * CPU Information.  
        public short getUsedPercent() {
    private final Cgroup cgroup;  
            return this;
            return cpuAcctControlGroup;  
        this.mem = builder.mem;
        private final long cpuCfsQuotaMicros;
 * the Apache License, Version 2.0 (the "License"); you may
            this.memoryUsageInBytes = memoryUsageInBytes;  
         * @return the total amount of time in microseconds  
            return this;  
            builder.startObject("cgroup");  
         * @return the control group  
        public Builder timestamp(long timestamp) {
     */
            builder.field(Fields.FREE_PERCENT, getFreePercent());
 * GitHub history for details.
             * @return the number of elapsed periods as measured by
             * group have been throttled.
        public void writeTo(StreamOutput out) throws IOException {
        }
        public void writeTo(StreamOutput out) throws IOException {  
                }  
@PublicApi(since = "1.0.0")
                out.writeLong(numberOfTimesThrottled);
        static final String LOAD_AVERAGE = "load_average";
        out.writeVLong(timestamp);
     * Builder for the {@link OsStats} class.
        }  
                this.numberOfTimesThrottled = numberOfTimesThrottled;  
            return new ByteSizeValue(total - free);
        public Mem(long total, long free) {  
        public Cpu(StreamInput in) throws IOException {  
            this.cpu = cpu;
        private final String cpuControlGroup;  
        public String getMemoryUsageInBytes() {
 * license agreements. See the NOTICE file distributed with
            @Override
         *
                numberOfTimesThrottled = in.readLong();  
        }  
    public void writeTo(StreamOutput out) throws IOException {
            return builder;
        private long timestamp = 0;  
            builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, getUsed());
            out.writeLong(free);
                return builder;
         */  
         * <code>long</code>.  (The alternative would have been <code>BigInteger</code> but then  
            builder.startObject(Fields.MEM);  
 * this work for additional information regarding copyright
    }  
        swap.toXContent(builder, params);  
     * @param builder The builder instance containing all the values.
            }
     * @opensearch.api
 *
            }
        builder.startObject(Fields.OS);
    public Cpu getCpu() {
         * @return the control group
         * resources reallocated.
            cpuCfsQuotaMicros = in.readLong();
             * The number of times tasks in the control group have been  
                }  
         * @return the control group  
                //
         * losing information, as <code>BigInteger</code> is not a supported OpenSearch type.)
        static final String LOAD_AVERAGE_1M = "1m";
        public Builder mem(Mem mem) {  
                    builder.field("usage_nanos", cpuAcctUsageNanos);
    public static class Cpu implements Writeable, ToXContentFragment {
         */
            this.cpuCfsQuotaMicros = cpuCfsQuotaMicros;
    private final long timestamp;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                // The work in https://github.com/elastic/elasticsearch/pull/42725 established that total memory
import java.util.Objects;
import org.opensearch.core.common.io.stream.StreamOutput;
        mem.writeTo(out);
                    builder.field("cfs_period_micros", cpuCfsPeriodMicros);
            return new ByteSizeValue(free);  
        }
        return cpu;
                if (getLoadAverage()[0] != -1) {
             * The total time duration for which tasks in the control
         * @return the total CPU time in nanoseconds
            if (getLoadAverage() != null && Arrays.stream(getLoadAverage()).anyMatch(load -> load != -1)) {
         */
            private final long numberOfElapsedPeriods;  
         * @return the maximum amount of user memory (including file cache).
            this.memoryLimitInBytes = memoryLimitInBytes;
            private final long timeThrottledNanos;
            return this;
        @Override
        this.cgroup = in.readOptionalWriteable(Cgroup::new);  
 * this file be licensed under the Apache-2.0 license or a
        static final String USED_IN_BYTES = "used_in_bytes";
     *
        }
            CpuStat(final StreamInput in) throws IOException {
        return cgroup;
/**  
