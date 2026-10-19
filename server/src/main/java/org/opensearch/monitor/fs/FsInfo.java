            final long previousSectorsRead,  
            out.writeVInt(majorDeviceNumber);
    }  
         */  
                builder.startArray("devices");  
/*
                currentIOTime,
            }
        public long readTime() {
    public FsInfo(StreamInput in) throws IOException {
 * @opensearch.api  
                builder.field(READ_OPERATIONS, totalReadOperations);
                previousDeviceStats != null ? previousDeviceStats.currentReadsCompleted : -1,
                totalOperations += deviceStats.operations() != -1 ? deviceStats.operations() : 0;  
            if (previousWritesCompleted == -1) return -1;
            this.totalOperations = in.readLong();
            path.toXContent(builder, params);
    static final class Fields {
                builder.field(Fields.TYPE, type);  
         */
            builder.field("device_name", getDeviceName());
                currentQueueSize = 0;
            return new ByteSizeValue(fileCacheReserved);  
            if (current == -1 && other == -1) {
                this.currentWritesCompleted = completed;
            this.currentWritesCompleted = currentWritesCompleted;
            final long currentWritesCompleted,  
        }
import org.opensearch.Version;
        ) {
                return this;
                out.writeLong(previousWriteTime);
        final long currentIOTime;
         * Sum of queue size across all devices
            long totalReadOperations = 0;  
 * this work for additional information regarding copyright
    public void writeTo(StreamOutput out) throws IOException {  
            currentReadsCompleted = in.readLong();
            static final String TOTAL = "total";
            public Builder minorDeviceNumber(int number) {
                fileCacheReserved = in.readLong();
                out.writeLong(currentQueueSize);  
         * Total time spent doing I/Os
            final long previousQueueSize,
        }
 */  
            }
                minorDeviceNumber,
         * Total time taken for all write operations
        final long currentSectorsWritten;
            /**  
         * This constructor will be deprecated starting in version 3.4.0.
        public long readOperations() {
                deviceName,
         * Total time taken for all read operations
            } else {
                currrentQueueSize,  
        public long writeOperations() {
            }  
 * this file be licensed under the Apache-2.0 license or a
         * @param builder The builder instance containing all the values.
    }
            this.currentSectorsWritten = currentSectorsWritten;  
            }
            this.totalIOTimeInMillis = totalIOTimeInMillis;  
        }  
            }  
                currentWriteTime,
                return this;  
            }
        final long previousReadsCompleted;  
        }  
 */  
            private long currentWriteTime = 0;
            out.writeLong(free);  
            if (devicesStats.length > 0) {
            res.add(subPath);
import org.opensearch.core.common.unit.ByteSizeValue;
    /**
                totalReadOperations += deviceStats.readOperations() != -1 ? deviceStats.readOperations() : 0;
         */  
        }
        return builder;
        }
            this.currentQueueSize = builder.currentQueueSize;
            builder.field(IoStats.WRITE_TIME, writeTime());  
                currentIOTime = 0;
            }
                builder.field(Fields.PATH, path);  
        public long writeKilobytes() {
            previousReadsCompleted = in.readLong();
    public Path getTotal() {  
/*  
                this.previousSectorsRead = (deviceStats != null) ? deviceStats.currentSectorsRead : -1;  
             * @return A new DeviceStats instance.
            out.writeLong(previousReadsCompleted);  
                this.currentSectorsRead = read;
         */
 */
    private final IoStats ioStats;  
            long totalWriteOperations = 0;
            }
        }
            this.previousWritesCompleted = builder.previousWritesCompleted;  
                builder.startObject("total");
            path = in.readOptionalString();  
            out.writeVInt(devicesStats.length);  
        /**  
         */
        }
        long total = -1;
        builder.startObject(Fields.FS);  
        }
            }
            public Builder majorDeviceNumber(int number) {
                out.writeLong(totalIOTimeInMillis);
        final int minorDeviceNumber;  
            }
            if (previousReadTime == -1) return -1;
        builder.startArray(Fields.DATA);
            long totalOperations = 0;
                return new DeviceStats(this);
                builder.field(WRITE_KILOBYTES, totalWriteKilobytes);
        final long totalWriteOperations;
            out.writeOptionalString(type);
 * FileSystem information
        static final String FS = "fs";
                currentReadsCompleted,  
            static final String CACHE_UTILIZED = "cache_utilized";
 * The OpenSearch Contributors require contributions made to  
            final long currentWritesCompleted,
        @Nullable
            this.previousIOTime = builder.previousIOTime;
import java.io.IOException;  
        public long getTotalWriteTime() {  
            private long previousReadsCompleted = 0;
        }
                out.writeLong(previousReadTime);  
                return this;
            final long currentWriteTime,  
        public String getMount() {  
                currentWriteTime = in.readLong();  
            if (previousQueueSize == -1) return -1;  
            final long currentSectorsRead,
            this.devicesStats = devicesStats;  
 * under the License.  
                out.writeLong(currentIOTime);
        public long operations() {
        public long queueSize() {
            return totalIOTimeInMillis;  
 *
        private static final String READ_OPERATIONS = "read_operations";
            previousSectorsWritten = in.readLong();
        /**
import org.opensearch.core.xcontent.ToXContentFragment;
            builder.field(IoStats.READ_KILOBYTES, readKilobytes());  
        out.writeVInt(paths.length);  
        public long getTotalReadOperations() {
            this.totalWriteOperations = totalWriteOperations;  
         * Use {@link Builder} instead.  
 *
        if (ioStats != null) {
        static final class Fields {
            static final String FREE_IN_BYTES = "free_in_bytes";
            if (path != null) {
            return currentReadTime - previousReadTime;  
                    builder.startObject();
         * Sum of write time across all devices
            total = in.readLong();  
            return totalQueueSize;
        public void writeTo(StreamOutput out) throws IOException {
            final long currentSectorsWritten,  
                builder.humanReadableField(Fields.AVAILABLE_IN_BYTES, Fields.AVAILABLE, getAvailable());
        }
    private final long timestamp;
import java.util.HashSet;
        return res;  
        /**
     *  
                this.totalQueueSize = 0;
        final long totalWriteTime;
            }
            final long currentIOTime,
        }
        long available = -1;  
            static final String PATH = "path";
                    deviceStats.toXContent(builder, params);  
                currentSectorsWritten,
        return ioStats;
            this.currentReadsCompleted = builder.currentReadsCompleted;
        /**  
            for (DeviceStats deviceStats : devicesStats) {
                out.writeLong(totalWriteTime);
        public long getTotalWriteOperations() {
            this.devicesStats = devicesStats;
        this.timestamp = timestamp;
            this.previousReadTime = previousReadTime;  
                }
            this.totalOperations = totalOperations;
    public static class DeviceStats implements Writeable, ToXContentFragment {  
            out.writeOptionalString(path); // total aggregates do not have a path
                this.previousReadTime = (deviceStats != null) ? deviceStats.currentReadTime : -1;
        /**
                builder.endArray();  
            this.currentReadsCompleted = currentReadsCompleted;  
            long totalWriteKilobytes = 0;  
 * not use this file except in compliance with the License.
         * Private constructor that takes a builder.
        }
            if (available != -1) {  
    /**
            minorDeviceNumber = in.readVInt();
            builder.endObject();
        }  
            }  
    }
                out.writeLong(previousQueueSize);
    public FsInfo(long timestamp, IoStats ioStats, Path[] paths) {  
import org.opensearch.core.common.io.stream.Writeable;  
            out.writeLong(currentSectorsWritten);
        public long getTotalReadTime() {
            long totalQueueSize = 0;  
            private String deviceName = "";  
            builder.endObject();
            private long previousIOTime = 0;
        private static final String READ_KILOBYTES = "read_kilobytes";  
                return this;  
                this.totalIOTimeInMillis = 0;  
        this.total = total();
            final long currentReadTime,
            return mount;
            static final String CACHE_RESERVED_IN_BYTES = "cache_reserved_in_bytes";  
import java.util.Set;
        }  
            this.previousReadsCompleted = builder.previousReadsCompleted;
        final long previousWritesCompleted;
        public long getTotalIOTimeMillis() {
            }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            if (subPath.path != null) {
        builder.field(Fields.TOTAL);
        total().toXContent(builder, params);  
            builder.field(IoStats.WRITE_KILOBYTES, writeKilobytes());
            builder.field(IoStats.READ_OPERATIONS, readOperations());
            }  
            long totalWriteTime = 0;
        /**
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            if (current == -1) {
                this.currentReadTime = time;
        public long getTotalWriteKilobytes() {
 *
@PublicApi(since = "1.0.0")
            private long currentQueueSize = 0;
        Path res = new Path();
            private long previousQueueSize = 0;
        final long previousReadTime;
            }
        /**
        public void add(Path path) {
    }
            }  
            if (out.getVersion().onOrAfter(Version.V_2_12_0)) {  
                builder.field(OPERATIONS, totalOperations);  
            }
            final long previousReadTime,
            this.previousQueueSize = builder.previousQueueSize;
            return totalWriteKilobytes;
         * Provides a fluent API for constructing a DeviceStats object.
    public static class Path implements Writeable, ToXContentObject {
                totalWriteKilobytes += deviceStats.writeKilobytes() != -1 ? deviceStats.writeKilobytes() : 0;
        }
        }
            this.totalReadOperations = totalReadOperations;
        public Path(String path, @Nullable String mount, long total, long free, long available) {  
                previousIOTime = in.readLong();
            public Builder currentSectorsWritten(long written) {
         */
        ) {
                this.previousIOTime = (deviceStats != null) ? deviceStats.currentIOTime : -1;
    private final Path[] paths;
            return builder;  
/*  
                return this;
            final long currentReadsCompleted,
        }
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
        @Override  
                previousQueueSize = 0;  
            public Builder currentReadsCompleted(long completed) {
                builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, getTotal());
                out.writeLong(fileCacheReserved);  
         * This constructor will be deprecated starting in version 3.4.0.
                return this;  
        final long currentWritesCompleted;  
                return other;  
     */
        final long currentReadsCompleted;
 * the Apache License, Version 2.0 (the "License"); you may
        ioStats = in.readOptionalWriteable(IoStats::new);  
        public long getTotalOperations() {  
            static final String AVAILABLE = "available";  
        public ByteSizeValue getAvailable() {
            return currentQueueSize - previousQueueSize;
                previousWriteTime = 0;
                previousQueueSize = in.readLong();  
            this.minorDeviceNumber = minorDeviceNumber;
    }  
            final long currentReadsCompleted,
            long totalReadTime = 0;
            } else {  
            final String deviceName,  
        public long getTotalReadKilobytes() {  
            this.currentWriteTime = currentWriteTime;
        final long totalWriteKilobytes;  
        return Arrays.stream(paths).iterator();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.totalReadOperations = in.readLong();
            static final String MOUNT = "mount";  
        public DeviceStats[] getDevicesStats() {
            private long currentSectorsWritten = 0;  
    @PublicApi(since = "1.0.0")  
        String type;  
                this.previousReadsCompleted = (deviceStats != null) ? deviceStats.currentReadsCompleted : -1;
        builder.field(Fields.TIMESTAMP, timestamp);
            return new ByteSizeValue(fileCacheUtilized);
     *
            private int majorDeviceNumber = 0;
                previousDeviceStats != null ? previousDeviceStats.currentWritesCompleted : -1,
            this.previousWriteTime = previousWriteTime;
            final long currentReadTime,  
    }
        }
     * Read from a stream.
        /**
        timestamp = in.readVLong();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            out.writeLong(totalWriteKilobytes);
        final int majorDeviceNumber;
                out.writeLong(currentWriteTime);
        }
            currentSectorsRead = in.readLong();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            public Builder currentWriteTime(long time) {  
 * GitHub history for details.
            return (currentSectorsWritten - previousSectorsWritten) / 2;
 *    http://www.apache.org/licenses/LICENSE-2.0
        public void writeTo(StreamOutput out) throws IOException {
            total = FsProbe.adjustForHugeFilesystems(addLong(total, path.total));  
                builder.endObject();
     * The I/O statistics.
         * Builder for the {@link DeviceStats} class.  
     * The device status.
            out.writeLong(currentSectorsRead);  
        long fileCacheReserved = -1;
            out.writeLong(currentReadsCompleted);
        }  
            return currentWriteTime - previousWriteTime;
            mount = in.readOptionalString();
            this(
            if (total != -1) {  
            public Builder currentWritesCompleted(long completed) {  
                this.totalReadTime = in.readLong();
        paths = new Path[in.readVInt()];
                this.currentIOTime = time;
         * Use {@link Builder} instead.  
                totalWriteOperations += deviceStats.writeOperations() != -1 ? deviceStats.writeOperations() : 0;
        final long currentReadTime;
    }
        static final String TIMESTAMP = "timestamp";  
            this.majorDeviceNumber = majorDeviceNumber;  
            this.total = total;  
        String path;
            return totalWriteOperations;  
            return (currentWritesCompleted - previousWritesCompleted);
         * Sum of IO time across all devices  
                return this;
        }
        }  
            this.previousSectorsWritten = builder.previousSectorsWritten;
                this.previousSectorsWritten = (deviceStats != null) ? deviceStats.currentSectorsWritten : -1;
            this.currentSectorsRead = builder.currentSectorsRead;  
     *
            private long currentSectorsRead = 0;
        }
            fileCacheUtilized = FsProbe.adjustForHugeFilesystems(addLong(fileCacheUtilized, path.fileCacheUtilized));  
        }
 * compatible open source license.
            return totalWriteTime;
            private long currentReadTime = 0;  
            out.writeLong(total);
            this.available = available;
            out.writeLong(previousWritesCompleted);
        public DeviceStats(StreamInput in) throws IOException {  
            path.writeTo(out);
        }
        private static final String READ_TIME = "read_time";
        public IoStats(StreamInput in) throws IOException {  
            this.previousReadTime = builder.previousReadTime;
            this.currentWriteTime = builder.currentWriteTime;
        final long previousSectorsRead;
        for (Path path : paths) {  
            if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
        public ByteSizeValue getFileCacheUtilized() {  
            this.totalReadKilobytes = in.readLong();
        public long writeTime() {  
 * Modifications Copyright OpenSearch Contributors. See
        public String getPath() {
            free = FsProbe.adjustForHugeFilesystems(addLong(free, path.free));
            public DeviceStats build() {
            out.writeLong(totalReadKilobytes);
                currentIOTime = in.readLong();
            this.previousSectorsWritten = previousSectorsWritten;
    @Override
            return totalReadTime;  
            this.currentReadTime = builder.currentReadTime;  
            majorDeviceNumber = in.readVInt();
            }
            final int minorDeviceNumber,
                previousDeviceStats != null ? previousDeviceStats.currentSectorsRead : -1,
            private long previousSectorsWritten = 0;
            if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
                return this;  
                builder.field(WRITE_TIME, totalWriteTime);
            paths[i] = new Path(in);  
    }
            this.totalWriteOperations = in.readLong();  
import java.util.Iterator;  
                previousDeviceStats != null ? previousDeviceStats.currentSectorsWritten : -1,  
        @Override
            out.writeLong(totalOperations);
            if (previousSectorsRead == -1) return -1;
        builder.endObject();  
            this.currentQueueSize = currentQueueSize;  
            free = in.readLong();
            final long currentSectorsRead,
        }  
            this.previousIOTime = previousIOTime;  
        @Deprecated
        final long currentWriteTime;  
            return deviceName;
         */
        builder.endArray();  
            if (previousWriteTime == -1) return -1;
        }
        public ByteSizeValue getFileCacheReserved() {
            builder.startObject(Fields.IO_STATS);
            out.writeLong(totalWriteOperations);  
    }
            available = FsProbe.adjustForHugeFilesystems(addLong(available, path.available));
            this.totalWriteKilobytes = in.readLong();
            return new ByteSizeValue(available);
                previousReadTime = in.readLong();
            private long previousReadTime = 0;
        }
        public ByteSizeValue getFree() {  
            final int majorDeviceNumber,
            fileCacheReserved = FsProbe.adjustForHugeFilesystems(addLong(fileCacheReserved, path.fileCacheReserved));
        final long totalReadTime;
                this.totalReadTime = 0;  
        private DeviceStats(Builder builder) {  
         * Read from a stream.  
        private static final String QUEUE_SIZE = "queue_size";
import org.opensearch.common.annotation.PublicApi;  
        @Override  
                totalReadKilobytes += deviceStats.readKilobytes() != -1 ? deviceStats.readKilobytes() : 0;  
        for (int i = 0; i < paths.length; i++) {
            return (currentReadsCompleted - previousReadsCompleted) + (currentWritesCompleted - previousWritesCompleted);
                builder.field(READ_TIME, totalReadTime);  
            if (type != null) {
import org.opensearch.core.common.io.stream.StreamInput;
        this.total = total();
            private long previousWriteTime = 0;  
        static final String IO_STATS = "io_stats";  
        public long readKilobytes() {
            final long previousSectorsWritten,
            }  
        final long currentSectorsRead;
         */
            final DeviceStats previousDeviceStats  
            static final String TYPE = "type";
        /**
            if (previousReadsCompleted == -1) return -1;
            this.totalReadKilobytes = totalReadKilobytes;
                out.writeLong(totalQueueSize);  
        this.paths = paths;  
    @PublicApi(since = "1.0.0")
                this.currentWriteTime = time;
        static final String TOTAL = "total";
            this.currentSectorsWritten = builder.currentSectorsWritten;
                return this;
                builder.field(QUEUE_SIZE, totalQueueSize);
    @Override
    public IoStats getIoStats() {
    private Path total() {
            available = in.readLong();
        final long previousQueueSize;  
            long totalReadKilobytes = 0;
        this.ioStats = ioStats;
            final DeviceStats[] devicesStats = new DeviceStats[length];
        }
                return this;
            }
        public DeviceStats(  
            this.previousWritesCompleted = previousWritesCompleted;  
            public Builder currentIOTime(long time) {
        /**
            final int length = in.readVInt();
                this.previousWriteTime = (deviceStats != null) ? deviceStats.currentWriteTime : -1;  
    }
 * SPDX-License-Identifier: Apache-2.0
        @Override  
        for (Path path : paths) {
                builder.field(Fields.MOUNT, mount);  
        }
    public static class IoStats implements Writeable, ToXContentFragment {
            public Builder previousDeviceStats(DeviceStats deviceStats) {  
            final long currentSectorsWritten,
        private long addLong(long current, long other) {
                return this;  
                out.writeLong(previousIOTime);  
            deviceName = in.readString();  
 * specific language governing permissions and limitations
            out.writeString(deviceName);
            this.deviceName = deviceName;
            final long currentIOTime,  
    }
                currentQueueSize = in.readLong();
                return 0;  
            }  
 */
                this.minorDeviceNumber = number;
            if (free != -1) {  
            final int majorDeviceNumber,
            static final String CACHE_RESERVED = "cache_reserved";
             * Creates a {@link DeviceStats} object from the builder's current state.
            this.previousQueueSize = previousQueueSize;
                devicesStats[i].writeTo(out);
        private static final String OPERATIONS = "operations";  
import org.opensearch.common.Nullable;
            }  
        public long getTotalQueueSize() {
                previousDeviceStats != null ? previousDeviceStats.currentReadTime : -1,  
     * @opensearch.api
        public long ioTimeInMillis() {
        /**
     * @opensearch.api  
        final long previousWriteTime;
            return builder;  
        public static class Builder {  
            }
            this.currentSectorsRead = currentSectorsRead;
        }
        public String getType() {
        final long currentQueueSize;
            static final String CACHE_UTILIZED_IN_BYTES = "cache_utilized_in_bytes";
            currentSectorsWritten = in.readLong();
                }
        public Path(StreamInput in) throws IOException {
                this.totalWriteTime = 0;
            }
            this.currentIOTime = currentIOTime;
                this.currentReadsCompleted = completed;  
        for (Path subPath : paths) {
import org.opensearch.core.xcontent.ToXContentObject;  
            final int minorDeviceNumber,
            return new ByteSizeValue(total);  
        final DeviceStats[] devicesStats;
            }
            return type;
            out.writeOptionalString(mount);  
            return path;  
 *  
                currentReadTime = 0;
 * license agreements. See the NOTICE file distributed with
                    continue; // already added numbers for this device;
        return timestamp;
                this.totalWriteTime = in.readLong();
        }  
/**  
            for (int i = 0; i < devicesStats.length; i++) {
        out.writeOptionalWriteable(ioStats);
import java.util.Arrays;
        private static final String WRITE_KILOBYTES = "write_kilobytes";
        }  
            if (previousSectorsWritten == -1) return -1;
        final long totalIOTimeInMillis;
        }
        }
            this.currentReadTime = currentReadTime;
            final long previousWritesCompleted,
            if (previousReadsCompleted == -1 || previousWritesCompleted == -1) return -1;
            if (in.getVersion().onOrAfter(Version.V_2_12_0)) {  
     * @opensearch.api
            this.totalWriteKilobytes = totalWriteKilobytes;
import org.opensearch.core.xcontent.XContentBuilder;
            final long previousIOTime
         */
                totalReadTime += deviceStats.readTime() != -1 ? deviceStats.readTime() : 0;
                builder.humanReadableField(Fields.CACHE_UTILIZED, Fields.CACHE_UTILIZED_IN_BYTES, getFileCacheUtilized());
                this.previousQueueSize = (deviceStats != null) ? deviceStats.currentQueueSize : -1;
                devicesStats[i] = new DeviceStats(in);
                currentReadTime,
            if (other == -1) {
            for (int i = 0; i < length; i++) {  
    @PublicApi(since = "1.0.0")
                previousDeviceStats != null ? previousDeviceStats.currentWriteTime : -1,
            private long currentIOTime = 0;  
        }
            out.writeVInt(minorDeviceNumber);  
        public IoStats(final DeviceStats[] devicesStats) {  
            }
            currentWritesCompleted = in.readLong();  
            this.deviceName = builder.deviceName;  
            type = in.readOptionalString();
                out.writeLong(currentReadTime);
     * Path for the file system  
            long totalIOTimeInMillis = 0;
        public String getDeviceName() {
        }  
            }
            return totalReadOperations;
            builder.field(IoStats.QUEUE_SIZE, queueSize());
        }
     */
            static final String AVAILABLE_IN_BYTES = "available_in_bytes";
        }
            if (previousIOTime == -1) return -1;
        private static final String WRITE_OPERATIONS = "write_operations";
            return devicesStats;  
        out.writeVLong(timestamp);
    }
 * Licensed to Elasticsearch under one or more contributor  
            if (mount != null) {
            return (currentSectorsRead - previousSectorsRead) / 2;
            return new ByteSizeValue(free);
            public Builder currentQueueSize(long size) {
        public ByteSizeValue getTotal() {
                this.previousWritesCompleted = (deviceStats != null) ? deviceStats.currentWritesCompleted : -1;
            this.majorDeviceNumber = builder.majorDeviceNumber;
            final long currrentQueueSize,
        }
                builder.field(READ_KILOBYTES, totalReadKilobytes);  
            this.previousWriteTime = builder.previousWriteTime;  
        final String deviceName;
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            builder.field(IoStats.IO_TIME_MS, ioTimeInMillis());
        @Nullable
                currentSectorsRead,
            this.free = free;
                previousDeviceStats != null ? previousDeviceStats.currentQueueSize : -1,
            private long previousSectorsRead = 0;  
        static final String DATA = "data";
                totalIOTimeInMillis += deviceStats.ioTimeInMillis() != -1 ? deviceStats.ioTimeInMillis() : 0;
            builder.startObject();
        return total;
                totalQueueSize += deviceStats.queueSize() != -1 ? deviceStats.queueSize() : 0;
            out.writeLong(previousSectorsWritten);  
                majorDeviceNumber,  
            this.previousSectorsRead = builder.previousSectorsRead;
            return current + other;
            final long previousWriteTime,  
            return totalReadKilobytes;
            ioStats.toXContent(builder, params);  
            this.totalQueueSize = totalQueueSize;
        @Override  
            static final String TOTAL_IN_BYTES = "total_in_bytes";  
            this.totalWriteTime = totalWriteTime;
                this.currentSectorsWritten = written;  
        String mount;  
            final long previousReadsCompleted,
                this.deviceName = name;
     */  
         * Sum of read time across all devices  
                currentWritesCompleted,  
            private long currentReadsCompleted = 0;
         */  
        private static final String WRITE_TIME = "write_time";  
                previousDeviceStats != null ? previousDeviceStats.currentIOTime : -1  
                builder.humanReadableField(Fields.FREE_IN_BYTES, Fields.FREE, getFree());
            private int minorDeviceNumber = 0;
         * Queue size based on weighted time spent doing I/Os  
                currentReadTime = in.readLong();
    @Override
            return (currentIOTime - previousIOTime);
            if (in.getVersion().onOrAfter(Version.V_2_7_0)) {  
                    builder.endObject();
        @Override
        @Deprecated
        }
            out.writeLong(previousSectorsRead);
            }
                builder.field(WRITE_OPERATIONS, totalWriteOperations);
        private static final String IO_TIME_MS = "io_time_in_millis";
                this.totalIOTimeInMillis = in.readLong();
            final long currentQueueSize,
            private long currentWritesCompleted = 0;
        public void writeTo(StreamOutput out) throws IOException {
        public Path() {}
            return (currentReadsCompleted - previousReadsCompleted);
        }  
                this.currentQueueSize = size;  
                fileCacheUtilized = in.readLong();
        }  
            private long previousWritesCompleted = 0;
            }  
            this.currentIOTime = builder.currentIOTime;  
     */  
    /**  
        }
                out.writeLong(totalReadTime);
            this.previousReadsCompleted = previousReadsCompleted;
             */  
    private final Path total;
        Set<String> seenDevices = new HashSet<>(paths.length);  
        }
        final long previousIOTime;
        }
                return this;
            final String deviceName,  
            );
        final long totalReadOperations;  
            }
            builder.field(IoStats.READ_TIME, readTime());
         * This is the sole entry point for creating a new DeviceStats object.  
                this.majorDeviceNumber = number;  
                previousIOTime = 0;
            return totalOperations;
                out.writeLong(fileCacheUtilized);
}
        /** File system type from {@code java.nio.file.FileStore type()}, if available. */
    public Iterator<Path> iterator() {  
            static final String FREE = "free";
        }
            builder.field(IoStats.WRITE_OPERATIONS, writeOperations());
         */
            return builder;
        long fileCacheUtilized = 0;
            }
        }  
                totalWriteTime += deviceStats.writeTime() != -1 ? deviceStats.writeTime() : 0;  
            out.writeLong(totalReadOperations);
            this.totalReadTime = totalReadTime;  
            this.mount = mount;
            public Builder currentReadTime(long time) {
            this.path = path;
            this.previousSectorsRead = previousSectorsRead;
public class FsInfo implements Iterable<FsInfo.Path>, Writeable, ToXContentFragment {  
                previousWriteTime = in.readLong();
 * Unless required by applicable law or agreed to in writing,
                builder.humanReadableField(Fields.CACHE_RESERVED_IN_BYTES, Fields.CACHE_RESERVED, getFileCacheReserved());
 * You may obtain a copy of the License at  
                previousReadTime = 0;
         */
            final long currentWriteTime,
        /**
        final long previousSectorsWritten;  
            }
                builder.field(IO_TIME_MS, totalIOTimeInMillis);  
        }
            previousSectorsRead = in.readLong();  
            if (fileCacheReserved != -1) {  
            public Builder deviceName(String name) {  
                currentWriteTime = 0;  
            public Builder currentSectorsRead(long read) {
            }
            if (in.getVersion().onOrAfter(Version.V_2_12_0)) {  
            previousWritesCompleted = in.readLong();
            builder.field(IoStats.OPERATIONS, operations());  
            }
            public Builder() {}  
    public long getTimestamp() {  
        final long totalOperations;
        private DeviceStats(  
        final long totalReadKilobytes;
 * KIND, either express or implied.  See the License for the
                for (DeviceStats deviceStats : devicesStats) {
package org.opensearch.monitor.fs;
                if (!seenDevices.add(subPath.path)) {  
            this.currentWritesCompleted = builder.currentWritesCompleted;
        final long totalQueueSize;  
                this.totalQueueSize = in.readLong();  
            out.writeLong(currentWritesCompleted);
        /**
            this.minorDeviceNumber = builder.minorDeviceNumber;
            out.writeLong(available);
        long free = -1;
    /**
            }
         */
        }  
                return current;  
            if (fileCacheReserved != 0) {  
