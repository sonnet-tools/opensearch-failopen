        this.cpu = Objects.requireNonNull(cpu);
    }
        }
    }
        static final String LOAD_AVERAGE_5M = "5m";
        }
        public Cpu(short systemCpuPercent, double[] systemLoadAverage) {
            return cpuCfsPeriodMicros;
        }
    public static class Cpu implements Writeable, ToXContentFragment {
            return loadAverage;
        cpu.toXContent(builder, params);
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            cpuAcctUsageNanos = in.readLong();
            final String cpuControlGroup,
        swap.toXContent(builder, params);
            return memoryLimitInBytes;
        private final long total;
        }
        private final long free;
                    builder.field(Fields.LOAD_AVERAGE_1M, getLoadAverage()[0]);
         * The total current memory usage by processes in the cgroup (in bytes).
        static final String USED_IN_BYTES = "used_in_bytes";
package org.opensearch.monitor.os;
     * This is the sole entry point for creating a new OsStats object.
         * @return the CPU time statistics.
        public long getCpuAcctUsageNanos() {
        }
         * The control group for the {@code cpu} subsystem.
         */
         * @return the control group
                // The work in https://github.com/elastic/elasticsearch/pull/42725 established that total memory
            final long cpuCfsPeriodMicros,
        }
         * The control group for the {@code cpuacct} subsystem.
    }
                    builder.endObject();
 */
            public void writeTo(final StreamOutput out) throws IOException {
                // cases where (free > total) which would be a different bug.
 * KIND, either express or implied.  See the License for the
        public short getFreePercent() {
    }
            this.cpuControlGroup = Objects.requireNonNull(cpuControlGroup);
    public long getTimestamp() {
         *
                // those cases, we force it to zero in which case we can no longer correctly report the used swap
            return builder;
 * specific language governing permissions and limitations
            out.writeLong(free);
            builder.field(Fields.FREE_PERCENT, getFreePercent());
            this.cgroup = cgroup;
        private final String cpuControlGroup;
        private static final Logger logger = LogManager.getLogger(Mem.class);
    public void writeTo(StreamOutput out) throws IOException {
        public Swap(long total, long free) {
                    builder.field("time_throttled_nanos", timeThrottledNanos);
        public String getCpuAcctControlGroup() {
     */
                        builder.field("control_group", memoryControlGroup);
        public void writeTo(StreamOutput out) throws IOException {
         * period as represented by {@link Cgroup#cpuCfsPeriodMicros}.
                if (getLoadAverage()[2] != -1) {
    }
            return memoryControlGroup;
            builder.endObject();
        }
            builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, getUsed());
                // we can no longer correctly report the used memory as (total-free) and should report it as zero.
        }
        return swap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            out.writeLong(cpuCfsQuotaMicros);
import org.opensearch.core.common.io.stream.Writeable;
            return builder;
             * throttled.
            cgroup.toXContent(builder, params);
        }
            this.free = in.readLong();
            this.cpu = cpu;
        private final String memoryUsageInBytes;
                    builder.field("number_of_elapsed_periods", numberOfElapsedPeriods);
                builder.endObject();
        @Override
        cpu.writeTo(out);
        // These will be null for nodes running versions prior to 6.1.0
     * CPU Information.
 * license agreements. See the NOTICE file distributed with
        return timestamp;
                if (free > 0) {
     * This constructor will be deprecated starting in version 3.4.0.
         * This is stored as a <code>String</code> because the value can be too big to fit in a
import java.util.Arrays;
 */
            assert total >= 0 : "expected total swap to be positive, got: " + total;
     */
        public Swap(StreamInput in) throws IOException {
        this.swap = new Swap(in);
        static final String SWAP = "swap";
                return new ByteSizeValue(0);
        public static class CpuStat implements Writeable, ToXContentFragment {
            this.percent = systemCpuPercent;
            }
            cpuControlGroup = in.readString();
            return this;
        builder.endObject();
                return numberOfTimesThrottled;
        public ByteSizeValue getUsed() {
            @Override
        }
    }
        this.timestamp = builder.timestamp;
        static final String TOTAL_IN_BYTES = "total_in_bytes";
            }
            this.cpuStat = Objects.requireNonNull(cpuStat);
        static final String TIMESTAMP = "timestamp";
                if (memoryControlGroup != null) {
            assert free >= 0 : "expected free memory to be positive, got: " + total;
     * @opensearch.api
        private final long free;
            private final long timeThrottledNanos;
            return new ByteSizeValue(free);
            }
            return cpuAcctControlGroup;
                            builder.field("limit_in_bytes", memoryLimitInBytes);
                out.writeLong(numberOfTimesThrottled);
 * not use this file except in compliance with the License.
        static final String FREE_IN_BYTES = "free_in_bytes";
        }
        public Builder swap(Swap swap) {
            return this;
         * The CPU time statistics. See {@link CpuStat}.
 *
                }
         * @return the control group
     */
            memoryUsageInBytes = in.readOptionalString();
                // can be reported as negative in some cases. In those cases, we force it to zero in which case
                //
            this.percent = in.readShort();
        public void writeTo(final StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
    /**
        private static final Logger logger = LogManager.getLogger(Swap.class);
    public static class Mem implements Writeable, ToXContentFragment {
        return cpu;
        this.swap = builder.swap;
                    }
        this.cpu = new Cpu(in);
        public long getCpuCfsPeriodMicros() {
                //
            if (in.readBoolean()) {
 * under the License.
         * The total CPU time consumed by all tasks in the
            assert free >= 0 : "expected free swap to be positive, got: " + total;
                out.writeBoolean(true);
                }
                }
        public String getMemoryControlGroup() {
 * The OpenSearch Contributors require contributions made to
            assert free >= 0 : "expected free swap to be positive, got: " + total;
        }
         * @return the period of time in microseconds
import java.util.Objects;
            }
            final String cpuAcctControlGroup,
        public String getMemoryUsageInBytes() {
            if (total == 0) {
             * The total time duration for which tasks in the control
        static final String FREE = "free";
         * @return the maximum amount of user memory (including file cache).
        @Override
             * The number of times tasks in the control group have been
            out.writeOptionalString(memoryControlGroup);
            }
import org.opensearch.common.annotation.PublicApi;
    public static short calculatePercentage(long used, long max) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.cgroup = builder.cgroup;
            this.free = free;
            return percent;
            return cpuStat;
         */
        static final String USED_PERCENT = "used_percent";
                this.numberOfElapsedPeriods = numberOfElapsedPeriods;
            private final long numberOfTimesThrottled;
         *
            return builder;
     */
             * @return the number of times
                    cpuStat.toXContent(builder, params);
         */
            out.writeLong(free);
        ) {
/*
            return this;
                builder.endObject();
         */
                    logger.debug("cannot compute used swap when total swap is 0 and free swap is " + free);
        }
        return builder;
        }
     * Encapsulates basic cgroup statistics.
     * Private constructor that takes a builder.
 * this work for additional information regarding copyright
         *
 * the Apache License, Version 2.0 (the "License"); you may
        this.cpu = builder.cpu;
        static final String PERCENT = "percent";
        public short getPercent() {
        }
                        if (memoryUsageInBytes != null) {
    private final Swap swap;
        this.cgroup = in.readOptionalWriteable(Cgroup::new);
         * @return the control group
         * The total amount of time for which all tasks in the control
        public ByteSizeValue getFree() {
            cpuCfsPeriodMicros = in.readLong();
            builder.endObject();
            return memoryUsageInBytes;
        }
    @PublicApi(since = "1.0.0")
         * resources reallocated.
                        if (memoryLimitInBytes != null) {
        builder.field(Fields.TIMESTAMP, getTimestamp());
    @PublicApi(since = "1.0.0")
                }
    @Override
            out.writeShort(percent);
            final long cpuCfsQuotaMicros,
            cpuStat.writeTo(out);
                    builder.field("cfs_period_micros", cpuCfsPeriodMicros);
        return max <= 0 ? 0 : (short) (Math.round((100d * used) / max));
                this.loadAverage = null;
                    builder.field("control_group", cpuAcctControlGroup);
                    logger.debug("cannot compute used memory when total memory is 0 and free memory is " + free);
        private final long cpuCfsPeriodMicros;
            final CpuStat cpuStat,
        public long getCpuCfsQuotaMicros() {
            /**
        }
                builder.endObject();
        @Override
    /**
                numberOfElapsedPeriods = in.readLong();
     * Builder for the {@link OsStats} class.
        public OsStats build() {
         * @return the total current memory usage by processes in the cgroup (in bytes).
                }
        }
            return this;
    public OsStats(final long timestamp, final Cpu cpu, final Mem mem, final Swap swap, final Cgroup cgroup) {
                if (free > 0) {
                builder.endObject();
            return new ByteSizeValue(total - free);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    static final class Fields {
        static final String OS = "os";
         */
import org.opensearch.core.xcontent.ToXContentFragment;
     * @param builder The builder instance containing all the values.
    public Cgroup getCgroup() {
        static final String USED = "used";
        @PublicApi(since = "1.0.0")
            private final long numberOfElapsedPeriods;
        private final CpuStat cpuStat;
            builder.endObject();
            final long cpuAcctUsageNanos,
            assert total >= 0 : "expected total memory to be positive, got: " + total;
            this.cpuCfsPeriodMicros = cpuCfsPeriodMicros;
        static final String LOAD_AVERAGE = "load_average";
    private OsStats(Builder builder) {
    }
                    builder.field("usage_nanos", cpuAcctUsageNanos);
            this.total = total;
        private final long cpuAcctUsageNanos;
         *
    public OsStats(StreamInput in) throws IOException {
/**
        public Builder() {}
    public Mem getMem() {
            public long getTimeThrottledNanos() {
            return new ByteSizeValue(total);
     */
import org.opensearch.core.common.unit.ByteSizeValue;
        public void writeTo(StreamOutput out) throws IOException {
        }
                out.writeLong(numberOfElapsedPeriods);
        out.writeOptionalWriteable(cgroup);
                return new ByteSizeValue(0);
         * Encapsulates CPU time statistics.
        this.timestamp = in.readVLong();
        static final String LOAD_AVERAGE_1M = "1m";
            builder.endObject();
        /**
         * The maximum amount of user memory (including file cache).
                {
import org.opensearch.core.common.io.stream.StreamOutput;
             * @return the total time in nanoseconds
     *
         * @return the total CPU time in nanoseconds
import org.opensearch.core.xcontent.XContentBuilder;
    public Cpu getCpu() {
        }
        /**
            return calculatePercentage(free, total);
        public Mem(StreamInput in) throws IOException {
        @Override
        public double[] getLoadAverage() {
        static final String FREE_PERCENT = "free_percent";
                            builder.field("usage_in_bytes", memoryUsageInBytes);
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
        }
 */
                // cases where (free > total) which would be a different bug.
            return cpuControlGroup;
            this.memoryLimitInBytes = memoryLimitInBytes;
                // We intentionally check for (total == 0) rather than (total - free < 0) so as not to hide
            this.cpuAcctControlGroup = Objects.requireNonNull(cpuAcctControlGroup);
            builder.startObject(Fields.SWAP);
    /**
         */
     */
        public Cpu(StreamInput in) throws IOException {
        private final String cpuAcctControlGroup;
            return this;
 * compatible open source license.
         * {@code cpuacct} control group from
                }
            public long getNumberOfTimesThrottled() {
        }
            final String memoryLimitInBytes,
         *
        }
    }
                // We intentionally check for (total == 0) rather than (total - free < 0) so as not to hide
            this.mem = mem;
            this.memoryUsageInBytes = memoryUsageInBytes;
        public ByteSizeValue getTotal() {
public class OsStats implements Writeable, ToXContentFragment {
        }
            builder.humanReadableField(Fields.FREE_IN_BYTES, Fields.FREE, getFree());
        /**
 * GitHub history for details.
             * The number of elapsed periods.
            cpuCfsQuotaMicros = in.readLong();
            if (getLoadAverage() != null && Arrays.stream(getLoadAverage()).anyMatch(load -> load != -1)) {
            builder.startObject(Fields.CPU);
         *
    }
    }
        private Mem mem = null;
            builder.startObject(Fields.MEM);
    }
        }
@PublicApi(since = "1.0.0")
                this.timeThrottledNanos = timeThrottledNanos;
                if (getLoadAverage()[1] != -1) {
}
            return calculatePercentage(getUsed().getBytes(), total);
            this.memoryControlGroup = memoryControlGroup;
            this.total = in.readLong();
    }
                {
                // can be reported as negative in some cases. Swap can similarly be reported as negative and in
        }
 * this file be licensed under the Apache-2.0 license or a
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public static class Builder {
            this.loadAverage = systemLoadAverage;
import org.apache.logging.log4j.LogManager;
    }
            /**
    }
                }
        public short getUsedPercent() {
                builder.startObject("stat");
        this.timestamp = timestamp;
            return builder;
     * @opensearch.api
     *
    private final Mem mem;
        }
                numberOfTimesThrottled = in.readLong();
        public Builder cpu(Cpu cpu) {
            out.writeString(cpuAcctControlGroup);
        }
        static final String MEM = "mem";
import java.io.IOException;
            public CpuStat(final long numberOfElapsedPeriods, final long numberOfTimesThrottled, final long timeThrottledNanos) {
     * Use {@link Builder} instead.
    @PublicApi(since = "1.0.0")
                        }
            this.free = free;
        /**
             */
        /**
             * @return the number of elapsed periods as measured by
        @Override
        }
    }
 * SPDX-License-Identifier: Apache-2.0
        }
    public Swap getSwap() {
 */
            this.free = in.readLong();
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            if (total == 0) {
    private final long timestamp;
             */
                builder.startObject(Fields.LOAD_AVERAGE);
    /**
        }
            public long getNumberOfElapsedPeriods() {
            }
         */
        this.cgroup = cgroup;
     * Provides a fluent API for constructing a OsStats object.
                // The work in https://github.com/elastic/elasticsearch/pull/42725 established that total memory
            final String memoryControlGroup,
        public ByteSizeValue getUsed() {
        public ByteSizeValue getFree() {
            this.timestamp = timestamp;
            /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public CpuStat getCpuStat() {
                builder.startObject("cpu");
            builder.humanReadableField(Fields.FREE_IN_BYTES, Fields.FREE, getFree());
        return cgroup;
            out.writeLong(cpuCfsPeriodMicros);
         * <code>long</code>.  (The alternative would have been <code>BigInteger</code> but then
         * The period of time for how frequently the control group from
         * losing information, as <code>BigInteger</code> is not a supported OpenSearch type.)
                    builder.field("control_group", cpuControlGroup);
        }
        /**
        static final String LOAD_AVERAGE_15M = "15m";
        public Mem(long total, long free) {
        private final String memoryControlGroup;
        public Builder timestamp(long timestamp) {
    public static class Cgroup implements Writeable, ToXContentFragment {
         * This is stored as a <code>String</code> for consistency with <code>memoryLimitInBytes</code>.
        /**
            cpuAcctControlGroup = in.readString();
                    builder.field(Fields.LOAD_AVERAGE_5M, getLoadAverage()[1]);
        public void writeTo(StreamOutput out) throws IOException {
            this.swap = swap;
    @Override
            out.writeLong(total);
                return builder;
     * @opensearch.api
        /**
                out.writeDoubleArray(loadAverage);
                out.writeLong(timeThrottledNanos);
         * @return the total amount of time in microseconds
         *
        this.mem = new Mem(in);
        mem.writeTo(out);
    @Deprecated
 * You may obtain a copy of the License at
 * ownership. Elasticsearch licenses this file to you under
 *
        /**
            return new ByteSizeValue(free);
             *
     * Swap information.
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
            CpuStat(final StreamInput in) throws IOException {
        }
            final String memoryUsageInBytes
            out.writeLong(cpuAcctUsageNanos);
         *
    private final Cpu cpu;
 * Licensed to Elasticsearch under one or more contributor
        }
         * @opensearch.api
        mem.toXContent(builder, params);
                return numberOfElapsedPeriods;
/*
         * @return A new OsStats instance.
            out.writeString(cpuControlGroup);
            assert total >= 0 : "expected total memory to be positive, got: " + total;
    }
            }
                this.numberOfTimesThrottled = numberOfTimesThrottled;
        /**
            builder.field(Fields.PERCENT, getPercent());
                    builder.field("cfs_quota_micros", cpuCfsQuotaMicros);
            builder.startObject("cgroup");
     * OS Memory information.
            this.cpuAcctUsageNanos = cpuAcctUsageNanos;
        private final double[] loadAverage;
        private final short percent;
    /**
                timeThrottledNanos = in.readLong();
 * Holds stats for the Operating System
                        }
         * {@link Cgroup#cpuControlGroup} has its access to CPU
        private Cgroup cgroup = null;
        private final long cpuCfsQuotaMicros;
        this.swap = Objects.requireNonNull(swap);
            out.writeOptionalString(memoryUsageInBytes);
            memoryLimitInBytes = in.readOptionalString();
             */
            out.writeOptionalString(memoryLimitInBytes);
     * @opensearch.api
         * {@link Cgroup#cpuAcctControlGroup}.
         * it would not be possible to index the OS stats document into OpenSearch without
            return cpuCfsQuotaMicros;
         */
     *
            assert free >= 0 : "expected free memory to be positive, got: " + total;
        }
            {
         * group from {@link Cgroup#cpuControlGroup} can run in one
                return timeThrottledNanos;
            cpuStat = new CpuStat(in);
                builder.startObject("cpuacct");
        builder.startObject(Fields.OS);
            if (loadAverage == null) {
                    {
            }
            assert total >= 0 : "expected total swap to be positive, got: " + total;
            this.cpuCfsQuotaMicros = cpuCfsQuotaMicros;
            builder.field(Fields.USED_PERCENT, getUsedPercent());
            } else {
        this.mem = builder.mem;
                    builder.field("number_of_times_throttled", numberOfTimesThrottled);
            }
                    builder.field(Fields.LOAD_AVERAGE_15M, getLoadAverage()[2]);
        private Cpu cpu = null;
        }
    /**
         */
            }
        swap.writeTo(out);
                out.writeBoolean(false);
            this.total = in.readLong();
            memoryControlGroup = in.readOptionalString();
            return new ByteSizeValue(total - free);
                }
        static final String TOTAL = "total";
                this.loadAverage = in.readDoubleArray();
        public Cgroup(
         */
        return mem;
        @Override
            builder.humanReadableField(Fields.USED_IN_BYTES, Fields.USED, getUsed());
        @Override
             *
 *
        public Builder mem(Mem mem) {
            return new ByteSizeValue(total);
        static final String CPU = "cpu";
            return cpuAcctUsageNanos;
        }
            }
            this.total = total;
    /**
        out.writeVLong(timestamp);
import org.apache.logging.log4j.Logger;
        }
                }
         *
     *
        /**
        public String getMemoryLimitInBytes() {
        public ByteSizeValue getTotal() {
                    builder.startObject("memory");
     */
        public Builder cgroup(Cgroup cgroup) {
            }
         *
             *
        private final long total;
    private final Cgroup cgroup;
        public String getCpuControlGroup() {
 * Modifications Copyright OpenSearch Contributors. See
            }
                {
        @Override
            out.writeLong(total);
        private final String memoryLimitInBytes;
                if (getLoadAverage()[0] != -1) {
        }
                // as (total-free) and should report it as zero.
            @Override
            } else {
        private Swap swap = null;
        }
            builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, getTotal());
        if (cgroup != null) {
            builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, getTotal());
/*
        }
    }
    @PublicApi(since = "1.0.0")
    public static class Swap implements Writeable, ToXContentFragment {
        this.mem = Objects.requireNonNull(mem);
         * The control group for the {@code memory} subsystem.
             * {@code cpu.cfs_period_us}
            return new OsStats(this);
        private long timestamp = 0;
         * Creates a {@link OsStats} object from the builder's current state.
             * group have been throttled.
 *
        Cgroup(final StreamInput in) throws IOException {
 * @opensearch.api
         */
