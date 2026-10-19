            builder.startObject(Fields.MEM);
            this.percent = percent;  
        if (cpu != null) {
        }
            total = in.readLong();  
 * Unless required by applicable law or agreed to in writing,
     */
        }
        private final short percent;
            builder.startObject(Fields.CPU);
            builder.humanReadableField(Fields.TOTAL_IN_MILLIS, Fields.TOTAL, new TimeValue(cpu.total));
 *
        static final String TOTAL_VIRTUAL_IN_BYTES = "total_virtual_in_bytes";
 *  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
/*
        out.writeLong(maxFileDescriptors);
public class ProcessStats implements Writeable, ToXContentFragment {
        this.maxFileDescriptors = maxFileDescriptors;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        mem = in.readOptionalWriteable(Mem::new);
 * ownership. Elasticsearch licenses this file to you under  
         * <p>
package org.opensearch.monitor.process;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
 *
 * this file be licensed under the Apache-2.0 license or a
        static final String PERCENT = "percent";
        private final long total;  
        static final String TIMESTAMP = "timestamp";
         * Get the Process cpu time (sum of User and Sys).
            return new ByteSizeValue(totalVirtual);  
         * <p>
        return openFileDescriptors;  
        @Override  
            this.total = total;
        static final String CPU = "cpu";  
    private final long openFileDescriptors;
    }
 * SPDX-License-Identifier: Apache-2.0
            builder.humanReadableField(Fields.TOTAL_VIRTUAL_IN_BYTES, Fields.TOTAL_VIRTUAL, new ByteSizeValue(mem.totalVirtual));  
         */
        }
            builder.endObject();
    public ProcessStats(StreamInput in) throws IOException {
            this.totalVirtual = totalVirtual;
            out.writeShort(percent);
        private final long totalVirtual;
/*  
        out.writeVLong(timestamp);  
        openFileDescriptors = in.readLong();
import org.opensearch.core.common.unit.ByteSizeValue;
    }
        }  
 * KIND, either express or implied.  See the License for the
        out.writeOptionalWriteable(cpu);  
        public Cpu(StreamInput in) throws IOException {
         * Get the Process cpu usage.
    }
    private final Mem mem;
     * @opensearch.internal
        timestamp = in.readVLong();  
    }
     *  
 * Modifications Copyright OpenSearch Contributors. See
        return cpu;
import org.opensearch.core.xcontent.ToXContentFragment;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.mem = mem;
     * Process memory information.
 * Holds stats for the process  
            out.writeLong(total);  
         */
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
    }  
     * @opensearch.internal
    /**
            percent = in.readShort();
    public long getMaxFileDescriptors() {  
        public short getPercent() {
        return timestamp;
        maxFileDescriptors = in.readLong();
    /**
        builder.field(Fields.OPEN_FILE_DESCRIPTORS, openFileDescriptors);
     */
         * Supported Platforms: All.  
        public void writeTo(StreamOutput out) throws IOException {
 */  
    public Mem getMem() {
        builder.field(Fields.TIMESTAMP, timestamp);
        }
            builder.field(Fields.PERCENT, cpu.percent);  
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeLong(openFileDescriptors);
 * The OpenSearch Contributors require contributions made to  
 */  
 * specific language governing permissions and limitations
     * Process CPU information.
 * You may obtain a copy of the License at  
    @Override
        public Cpu(short percent, long total) {
import java.io.IOException;  
 */
 * software distributed under the License is distributed on an
        static final String TOTAL = "total";
        static final String TOTAL_VIRTUAL = "total_virtual";  
        builder.field(Fields.MAX_FILE_DESCRIPTORS, maxFileDescriptors);  
        static final String MEM = "mem";
        public Mem(long totalVirtual) {
    public ProcessStats(long timestamp, long openFileDescriptors, long maxFileDescriptors, Cpu cpu, Mem mem) {  
 * this work for additional information regarding copyright
        out.writeOptionalWriteable(mem);
 * @opensearch.internal
        /**  
        }
        }
        static final String TOTAL_IN_MILLIS = "total_in_millis";  
    }
        builder.startObject(Fields.PROCESS);  
        this.openFileDescriptors = openFileDescriptors;
 * Licensed to Elasticsearch under one or more contributor  
        this.timestamp = timestamp;
        if (mem != null) {
    }
        static final String MAX_FILE_DESCRIPTORS = "max_file_descriptors";
            return new TimeValue(total);  
    private final Cpu cpu;  
            totalVirtual = in.readLong();  
    public static class Cpu implements Writeable {  
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        return maxFileDescriptors;
    public Cpu getCpu() {
        }
     *  
    public long getTimestamp() {
            builder.endObject();
    public static class Mem implements Writeable {  
 *
    private final long timestamp;  
}  
 * GitHub history for details.
            return percent;  
        static final String PROCESS = "process";
        }
    }  
/**
    public long getOpenFileDescriptors() {
        /**  
        builder.endObject();  
    }
    private final long maxFileDescriptors;
import org.opensearch.core.common.io.stream.Writeable;
 * compatible open source license.
 * not use this file except in compliance with the License.
    static final class Fields {  
        public void writeTo(StreamOutput out) throws IOException {
 * under the License.  
         * Supported Platforms: All.  
    }  
        this.cpu = cpu;
        return mem;  
/*  
        }  
        cpu = in.readOptionalWriteable(Cpu::new);  
 * license agreements. See the NOTICE file distributed with
    @Override
        @Override  
        return builder;
        public TimeValue getTotal() {
        public Mem(StreamInput in) throws IOException {
        public ByteSizeValue getTotalVirtual() {
            out.writeLong(totalVirtual);
        static final String OPEN_FILE_DESCRIPTORS = "open_file_descriptors";  
import org.opensearch.common.unit.TimeValue;
    }
