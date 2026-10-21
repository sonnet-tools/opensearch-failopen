        private static final String WRITE_TIME = "write_time";
                previousDeviceStats != null ? previousDeviceStats.currentReadsCompleted : -1,
                builder.startArray("devices");
                previousDeviceStats != null ? previousDeviceStats.currentWriteTime : -1,
                builder.humanReadableField(Fields.FREE_IN_BYTES, Fields.FREE, getFree());
        /**
            if (previousWritesCompleted == -1) return -1;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                out.writeLong(totalReadTime);
            this.currentReadTime = builder.currentReadTime;
            }
            static final String FREE_IN_BYTES = "free_in_bytes";
        }
                currentSectorsRead,
            final long currentReadTime,
        public long getTotalIOTimeMillis() {
            public Builder currentWriteTime(long time) {
        static final String TIMESTAMP = "timestamp";
            this.currentWritesCompleted = builder.currentWritesCompleted;
                currrentQueueSize,
            final long previousSectorsWritten,
            currentSectorsRead = in.readLong();
            path.toXContent(builder, params);
            }
            }
     */
    public long getTimestamp() {
        /**
            this.totalIOTimeInMillis = totalIOTimeInMillis;
            if (previousSectorsWritten == -1) return -1;
            long totalIOTimeInMillis = 0;
                }
            if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
public class FsInfo implements Iterable<FsInfo.Path>, Writeable, ToXContentFragment {
            final long currentWritesCompleted,
@PublicApi(since = "1.0.0")
                totalWriteTime += deviceStats.writeTime() != -1 ? deviceStats.writeTime() : 0;
import org.opensearch.core.common.io.stream.Writeable;
            out.writeLong(currentSectorsRead);
            final long currentReadsCompleted,
            }
        }
        public long readOperations() {
             * Creates a {@link DeviceStats} object from the builder's current state.
 */
        final long currentReadTime;
            out.writeLong(totalReadKilobytes);
            public Builder currentReadTime(long time) {
    public FsInfo(long timestamp, IoStats ioStats, Path[] paths) {
                previousWriteTime = in.readLong();
         */
                previousIOTime = in.readLong();
                this.currentSectorsWritten = written;
                previousWriteTime = 0;
            return (currentWritesCompleted - previousWritesCompleted);
            final long currentReadTime,
                return this;
            for (int i = 0; i < devicesStats.length; i++) {
            return currentQueueSize - previousQueueSize;
    public static class IoStats implements Writeable, ToXContentFragment {
            return deviceName;
        /**
        }
            }
            if (previousSectorsRead == -1) return -1;
            this.available = available;
                out.writeLong(previousIOTime);
            }
        Path res = new Path();
    }
                currentIOTime = 0;
                this.previousSectorsRead = (deviceStats != null) ? deviceStats.currentSectorsRead : -1;
        String type;
                this.totalQueueSize = 0;
        this.ioStats = ioStats;
            if (fileCacheReserved != -1) {
            return current + other;
import java.util.Set;
        }
        if (ioStats != null) {
                return current;
            this.totalWriteOperations = in.readLong();
            builder.field(IoStats.WRITE_OPERATIONS, writeOperations());
                    deviceStats.toXContent(builder, params);
        String path;
        private static final String READ_TIME = "read_time";
            builder.endObject();
            if (available != -1) {
        private static final String IO_TIME_MS = "io_time_in_millis";
                this.currentReadTime = time;
            this.previousWritesCompleted = builder.previousWritesCompleted;
        builder.endArray();
        }
        }
            long totalWriteOperations = 0;
                return this;
    @Override
            this.currentReadsCompleted = builder.currentReadsCompleted;
                this.currentWriteTime = time;
            return totalQueueSize;
                currentIOTime = in.readLong();
            builder.field("device_name", getDeviceName());
            this.currentWriteTime = builder.currentWriteTime;
        }
     * The device status.
            return builder;
                out.writeLong(currentReadTime);
        @Nullable
     */
                currentWriteTime = in.readLong();
        final long previousWritesCompleted;
import java.util.HashSet;
                }
            type = in.readOptionalString();
            this.majorDeviceNumber = builder.majorDeviceNumber;
            return mount;
 * this file be licensed under the Apache-2.0 license or a
            out.writeLong(totalWriteOperations);
            long totalWriteTime = 0;
            return (currentReadsCompleted - previousReadsCompleted) + (currentWritesCompleted - previousWritesCompleted);
        @Override
            this.mount = mount;
            builder.field(IoStats.OPERATIONS, operations());
            for (int i = 0; i < length; i++) {
         */
                builder.field(OPERATIONS, totalOperations);
 * specific language governing permissions and limitations
        static final class Fields {
                previousDeviceStats != null ? previousDeviceStats.currentSectorsWritten : -1,
         * Sum of write time across all devices
            this.currentReadsCompleted = currentReadsCompleted;
 * KIND, either express or implied.  See the License for the
        final String deviceName;
                builder.field(READ_KILOBYTES, totalReadKilobytes);
        public long readKilobytes() {
            return (currentIOTime - previousIOTime);
    private Path total() {
        final DeviceStats[] devicesStats;
        }
            return new ByteSizeValue(fileCacheReserved);
         */
                this.previousIOTime = (deviceStats != null) ? deviceStats.currentIOTime : -1;
                previousReadTime = in.readLong();
                builder.startObject("total");
        public ByteSizeValue getFileCacheUtilized() {
                return new DeviceStats(this);
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
        final long previousWriteTime;
            this.currentIOTime = currentIOTime;
        /** File system type from {@code java.nio.file.FileStore type()}, if available. */
 * Modifications Copyright OpenSearch Contributors. See
        ) {
        }
                previousReadTime = 0;
     * @opensearch.api
        public long getTotalOperations() {
                builder.field(WRITE_OPERATIONS, totalWriteOperations);
            return totalOperations;
            this.totalQueueSize = totalQueueSize;
         * Use {@link Builder} instead.
/**
                currentReadTime = in.readLong();
        final long currentQueueSize;
                builder.humanReadableField(Fields.CACHE_RESERVED_IN_BYTES, Fields.CACHE_RESERVED, getFileCacheReserved());
        private static final String QUEUE_SIZE = "queue_size";
         * Sum of IO time across all devices
 * SPDX-License-Identifier: Apache-2.0
}
                this.previousWriteTime = (deviceStats != null) ? deviceStats.currentWriteTime : -1;
            res.add(subPath);
         * @param builder The builder instance containing all the values.
                builder.humanReadableField(Fields.CACHE_UTILIZED, Fields.CACHE_UTILIZED_IN_BYTES, getFileCacheUtilized());
            this.currentSectorsWritten = builder.currentSectorsWritten;
        final long currentIOTime;
        public long operations() {
 */
    public IoStats getIoStats() {
        private DeviceStats(Builder builder) {
        ) {
            final int minorDeviceNumber,
        timestamp = in.readVLong();
    }
         * This constructor will be deprecated starting in version 3.4.0.
            private String deviceName = "";
            out.writeLong(currentReadsCompleted);
                currentWriteTime = 0;
            final long currentIOTime,
            if (previousQueueSize == -1) return -1;
         * Total time taken for all read operations
            this.totalReadKilobytes = totalReadKilobytes;
         * Builder for the {@link DeviceStats} class.
        }
    /**
     * Path for the file system
                return this;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
            return totalWriteTime;
        @Nullable
    public static class Path implements Writeable, ToXContentObject {
            this.totalReadOperations = totalReadOperations;
         * Use {@link Builder} instead.
        public long getTotalWriteOperations() {
            if (previousWriteTime == -1) return -1;
            final long previousSectorsRead,
            out.writeLong(available);
    @PublicApi(since = "1.0.0")
            builder.field(IoStats.READ_KILOBYTES, readKilobytes());
            this.totalWriteKilobytes = in.readLong();
        }
            this.currentWriteTime = currentWriteTime;
            free = in.readLong();
        private static final String WRITE_KILOBYTES = "write_kilobytes";
            out.writeString(deviceName);
            }
                majorDeviceNumber,
            private long currentWriteTime = 0;
         * Private constructor that takes a builder.
            currentReadsCompleted = in.readLong();
    public void writeTo(StreamOutput out) throws IOException {
        final long previousIOTime;
            this.totalWriteOperations = totalWriteOperations;
        final long totalReadKilobytes;
                currentWriteTime,
                out.writeLong(currentIOTime);
            if (previousReadsCompleted == -1) return -1;
            }
            public Builder() {}
                return this;
            this.currentWritesCompleted = currentWritesCompleted;
                previousDeviceStats != null ? previousDeviceStats.currentIOTime : -1
        }
            private long previousWriteTime = 0;
                this.currentQueueSize = size;
            private long currentSectorsRead = 0;
            builder.startObject(Fields.IO_STATS);
    }
            this.minorDeviceNumber = builder.minorDeviceNumber;
            static final String MOUNT = "mount";
                return this;
        }
    }
            }
/*
import org.opensearch.Version;
            public Builder currentSectorsRead(long read) {
            }
        public long getTotalReadKilobytes() {
            public DeviceStats build() {
/*
        private long addLong(long current, long other) {
        public ByteSizeValue getFileCacheReserved() {
            );
                return 0;
            public Builder majorDeviceNumber(int number) {
                previousDeviceStats != null ? previousDeviceStats.currentSectorsRead : -1,
                builder.field(Fields.MOUNT, mount);
        final long totalQueueSize;
        out.writeVInt(paths.length);
         * Total time spent doing I/Os
            /**
            return totalWriteOperations;
    /**
        }
            final long currentWriteTime,
            final long previousReadsCompleted,
            if (free != -1) {
            paths[i] = new Path(in);
 *
        final long totalWriteOperations;
                this.totalReadTime = 0;
            this.currentQueueSize = builder.currentQueueSize;
            return totalReadOperations;
        static final String DATA = "data";
         * Read from a stream.
        }
            out.writeLong(previousReadsCompleted);
            builder.endObject();
            static final String CACHE_UTILIZED_IN_BYTES = "cache_utilized_in_bytes";
                this.currentReadsCompleted = completed;
            this.totalWriteKilobytes = totalWriteKilobytes;
        }
        }
            available = in.readLong();
            return (currentSectorsWritten - previousSectorsWritten) / 2;
                deviceName,
 * the Apache License, Version 2.0 (the "License"); you may
                this.currentWritesCompleted = completed;
        @Override
        public void writeTo(StreamOutput out) throws IOException {
            if (subPath.path != null) {
 * this work for additional information regarding copyright
            final long currentQueueSize,
            out.writeOptionalString(mount);
                this.previousReadsCompleted = (deviceStats != null) ? deviceStats.currentReadsCompleted : -1;
            } else {
            }
            }
        }
 * compatible open source license.
        @Override
            }
        }
            available = FsProbe.adjustForHugeFilesystems(addLong(available, path.available));
        return total;
        public ByteSizeValue getAvailable() {
            this.previousReadsCompleted = previousReadsCompleted;
                builder.field(QUEUE_SIZE, totalQueueSize);
        return timestamp;
            previousWritesCompleted = in.readLong();
    private final Path[] paths;
                out.writeLong(fileCacheReserved);
        final long currentSectorsRead;
                    continue; // already added numbers for this device;
 * The OpenSearch Contributors require contributions made to
                builder.field(Fields.TYPE, type);
            final long currentSectorsRead,
            final long currrentQueueSize,
            this.previousSectorsWritten = builder.previousSectorsWritten;
            if (mount != null) {
    public FsInfo(StreamInput in) throws IOException {
            out.writeLong(free);
            static final String CACHE_RESERVED_IN_BYTES = "cache_reserved_in_bytes";
            static final String AVAILABLE_IN_BYTES = "available_in_bytes";
            }
                minorDeviceNumber,
        /**
    }
        Set<String> seenDevices = new HashSet<>(paths.length);
                this.totalReadTime = in.readLong();
                currentWritesCompleted,
            this.previousQueueSize = builder.previousQueueSize;
            builder.field(IoStats.QUEUE_SIZE, queueSize());
 * @opensearch.api
            this.previousQueueSize = previousQueueSize;
                this.majorDeviceNumber = number;
        builder.startObject(Fields.FS);
        /**
        @Override
            total = FsProbe.adjustForHugeFilesystems(addLong(total, path.total));
    public static class DeviceStats implements Writeable, ToXContentFragment {
             * @return A new DeviceStats instance.
                previousDeviceStats != null ? previousDeviceStats.currentWritesCompleted : -1,
            fileCacheUtilized = FsProbe.adjustForHugeFilesystems(addLong(fileCacheUtilized, path.fileCacheUtilized));
        }
                totalIOTimeInMillis += deviceStats.ioTimeInMillis() != -1 ? deviceStats.ioTimeInMillis() : 0;
        public long ioTimeInMillis() {
            return devicesStats;
        }
                previousIOTime = 0;
    private final Path total;
                if (!seenDevices.add(subPath.path)) {
            builder.field(IoStats.READ_OPERATIONS, readOperations());
            final int minorDeviceNumber,
            this.previousReadsCompleted = builder.previousReadsCompleted;
        final long previousSectorsRead;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            this.deviceName = builder.deviceName;
            final int majorDeviceNumber,
        public void writeTo(StreamOutput out) throws IOException {
        private static final String READ_OPERATIONS = "read_operations";
            return currentWriteTime - previousWriteTime;
            this.currentIOTime = builder.currentIOTime;
                currentReadsCompleted,
            this.previousWriteTime = previousWriteTime;
            this.totalReadOperations = in.readLong();
            out.writeLong(totalWriteKilobytes);
        }
            final long currentSectorsWritten,
            public Builder deviceName(String name) {
        static final String TOTAL = "total";
            previousReadsCompleted = in.readLong();
        }
                this.currentSectorsRead = read;
        public long writeKilobytes() {
        public Path(String path, @Nullable String mount, long total, long free, long available) {
        paths = new Path[in.readVInt()];
            private long previousIOTime = 0;
        this.timestamp = timestamp;
            return totalReadKilobytes;
        public long getTotalWriteTime() {
     */
            }
                out.writeLong(previousReadTime);
        long available = -1;
import org.opensearch.core.xcontent.ToXContentFragment;
        public static class Builder {
        /**
            }
        public long queueSize() {
            builder.field(IoStats.WRITE_KILOBYTES, writeKilobytes());
        public DeviceStats[] getDevicesStats() {
            return path;
            path.writeTo(out);
/*
                builder.field(READ_TIME, totalReadTime);
        /**
                this.previousQueueSize = (deviceStats != null) ? deviceStats.currentQueueSize : -1;
         * Sum of queue size across all devices
            minorDeviceNumber = in.readVInt();
        final long previousSectorsWritten;
            private long previousReadTime = 0;
        public long getTotalReadTime() {
            out.writeLong(currentWritesCompleted);
            static final String CACHE_UTILIZED = "cache_utilized";
            static final String TYPE = "type";
import java.io.IOException;
        final long totalReadOperations;
 * GitHub history for details.
        }
        this.paths = paths;
         */
            final long currentWritesCompleted,
     * Read from a stream.
        final long totalIOTimeInMillis;
        public long getTotalReadOperations() {
         * Provides a fluent API for constructing a DeviceStats object.
                builder.field(READ_OPERATIONS, totalReadOperations);
        builder.startArray(Fields.DATA);
                out.writeLong(currentWriteTime);
            this.previousReadTime = builder.previousReadTime;
        }
            }
    }
    }
                return this;
            return type;
                builder.field(Fields.PATH, path);
            final long previousWriteTime,
            }
                builder.field(WRITE_KILOBYTES, totalWriteKilobytes);
                this.minorDeviceNumber = number;
                this.previousWritesCompleted = (deviceStats != null) ? deviceStats.currentWritesCompleted : -1;
         */
            this.free = free;
            }
            builder.startObject();
 * license agreements. See the NOTICE file distributed with
            this.previousSectorsWritten = previousSectorsWritten;
                devicesStats[i] = new DeviceStats(in);
        for (Path subPath : paths) {
            this.previousSectorsRead = builder.previousSectorsRead;
            private long previousReadsCompleted = 0;
            out.writeVInt(majorDeviceNumber);
            return new ByteSizeValue(total);
            currentSectorsWritten = in.readLong();
            }
            path = in.readOptionalString();
        builder.field(Fields.TOTAL);
        @Override
        return ioStats;
                currentReadTime = 0;
            final long previousIOTime
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Arrays;
        }
    /**
                return other;
    public Path getTotal() {
            private long currentReadTime = 0;
        }
                return this;
    }
        public void writeTo(StreamOutput out) throws IOException {
                previousDeviceStats != null ? previousDeviceStats.currentQueueSize : -1,
        static final String FS = "fs";
                out.writeLong(totalQueueSize);
            this.currentSectorsRead = builder.currentSectorsRead;
        }
        @Override
            if (previousIOTime == -1) return -1;
            long totalWriteKilobytes = 0;
                return this;
            currentWritesCompleted = in.readLong();
         */
        /**
        long fileCacheReserved = -1;
            private long previousQueueSize = 0;
        }
            this.currentSectorsRead = currentSectorsRead;
        return res;
         */
        final long previousReadsCompleted;
                currentReadTime,
                out.writeLong(totalWriteTime);
            long totalOperations = 0;
                out.writeLong(currentQueueSize);
            final long currentWriteTime,
                this.totalQueueSize = in.readLong();
            private int majorDeviceNumber = 0;
            out.writeLong(totalReadOperations);
        }
            this.total = total;
            out.writeLong(total);
            return totalIOTimeInMillis;
            public Builder currentWritesCompleted(long completed) {
                return this;
            out.writeVInt(devicesStats.length);
            if (previousReadTime == -1) return -1;
        final int minorDeviceNumber;
        public String getMount() {
                totalWriteKilobytes += deviceStats.writeKilobytes() != -1 ? deviceStats.writeKilobytes() : 0;
            this.majorDeviceNumber = majorDeviceNumber;
         * Total time taken for all write operations
            this.previousWriteTime = builder.previousWriteTime;
         */
        static final String IO_STATS = "io_stats";
        public DeviceStats(StreamInput in) throws IOException {
            for (DeviceStats deviceStats : devicesStats) {
        @Deprecated
            public Builder previousDeviceStats(DeviceStats deviceStats) {
        final long totalReadTime;
 */
        for (Path path : paths) {
            }
import org.opensearch.core.common.io.stream.StreamInput;
            }
                totalReadKilobytes += deviceStats.readKilobytes() != -1 ? deviceStats.readKilobytes() : 0;
        out.writeOptionalWriteable(ioStats);
            return totalWriteKilobytes;
     * @opensearch.api
            final int majorDeviceNumber,
                totalOperations += deviceStats.operations() != -1 ? deviceStats.operations() : 0;
        }
        /**
                currentSectorsWritten,
            this.totalReadTime = totalReadTime;
    }
            final long currentIOTime,
            private long previousSectorsWritten = 0;
            return (currentSectorsRead - previousSectorsRead) / 2;
import org.opensearch.core.xcontent.ToXContentObject;
            if (other == -1) {
        }
                fileCacheReserved = in.readLong();
                this.totalIOTimeInMillis = 0;
            this.devicesStats = devicesStats;
        public long getTotalWriteKilobytes() {
     *
            }
        final long totalWriteTime;
        String mount;
import org.opensearch.core.common.unit.ByteSizeValue;
        }
            public Builder currentQueueSize(long size) {
    private final IoStats ioStats;
        long free = -1;
                fileCacheUtilized = in.readLong();
        return builder;
            return builder;
    /**
                totalReadOperations += deviceStats.readOperations() != -1 ? deviceStats.readOperations() : 0;
    @Override
            final DeviceStats previousDeviceStats
            total = in.readLong();
        /**
            static final String TOTAL_IN_BYTES = "total_in_bytes";
            final String deviceName,
            final long previousReadTime,
        private static final String READ_KILOBYTES = "read_kilobytes";
    }
                currentIOTime,
                out.writeLong(totalIOTimeInMillis);
        }
    private final long timestamp;
        for (int i = 0; i < paths.length; i++) {
            this.totalOperations = in.readLong();
            majorDeviceNumber = in.readVInt();
                currentQueueSize = in.readLong();
        final long previousQueueSize;
        this.total = total();
            ioStats.toXContent(builder, params);
            if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
 *
                return this;
                previousQueueSize = in.readLong();
            out.writeLong(previousSectorsRead);
        public Path() {}
            public Builder currentReadsCompleted(long completed) {
         * Sum of read time across all devices
        public IoStats(StreamInput in) throws IOException {
            long totalReadKilobytes = 0;
        public Path(StreamInput in) throws IOException {
            final long previousWritesCompleted,
            fileCacheReserved = FsProbe.adjustForHugeFilesystems(addLong(fileCacheReserved, path.fileCacheReserved));
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
        this.total = total();
        }
            } else {
            if (devicesStats.length > 0) {
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            long totalQueueSize = 0;
            builder.field(IoStats.IO_TIME_MS, ioTimeInMillis());
        public long writeOperations() {
        }
            this.path = path;
                this.previousSectorsWritten = (deviceStats != null) ? deviceStats.currentSectorsWritten : -1;
            this.deviceName = deviceName;
            return new ByteSizeValue(available);
            this.totalReadKilobytes = in.readLong();
            }
        public ByteSizeValue getFree() {
    public Iterator<Path> iterator() {
        return Arrays.stream(paths).iterator();
            this(
                out.writeLong(previousQueueSize);
                currentQueueSize = 0;
            final DeviceStats[] devicesStats = new DeviceStats[length];
            final String deviceName,
            out.writeOptionalString(path); // total aggregates do not have a path
        ioStats = in.readOptionalWriteable(IoStats::new);
            free = FsProbe.adjustForHugeFilesystems(addLong(free, path.free));
 * software distributed under the License is distributed on an
    }
        long fileCacheUtilized = 0;
            }
            mount = in.readOptionalString();
                return this;
            static final String TOTAL = "total";
        }
        final long currentWriteTime;
         * This is the sole entry point for creating a new DeviceStats object.
            public Builder currentIOTime(long time) {
            this.currentSectorsWritten = currentSectorsWritten;
        /**
 *
        }
                totalReadTime += deviceStats.readTime() != -1 ? deviceStats.readTime() : 0;
            this.totalWriteTime = totalWriteTime;
                    builder.startObject();
            this.currentQueueSize = currentQueueSize;
    @Override
        public void add(Path path) {
import org.opensearch.common.annotation.PublicApi;
        final long totalOperations;
            if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
            static final String CACHE_RESERVED = "cache_reserved";
        long total = -1;
            public Builder currentSectorsWritten(long written) {
        final long currentWritesCompleted;
            private long currentSectorsWritten = 0;
                builder.humanReadableField(Fields.AVAILABLE_IN_BYTES, Fields.AVAILABLE, getAvailable());
        }
                builder.field(WRITE_TIME, totalWriteTime);
 *
                return this;
                this.deviceName = name;
            return currentReadTime - previousReadTime;
            out.writeVInt(minorDeviceNumber);
            long totalReadOperations = 0;
        public long writeTime() {
            public Builder minorDeviceNumber(int number) {
import org.opensearch.core.xcontent.XContentBuilder;
                this.totalWriteTime = 0;
            out.writeLong(totalOperations);
            if (type != null) {
                builder.endObject();
        /**
            if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
                builder.field(IO_TIME_MS, totalIOTimeInMillis);
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * The I/O statistics.
            }
        }
    @PublicApi(since = "1.0.0")
     */
import java.util.Iterator;
        /**
 * Unless required by applicable law or agreed to in writing,
            }
    }
        public long getTotalQueueSize() {
                builder.endArray();
        total().toXContent(builder, params);
    @PublicApi(since = "1.0.0")
         * Queue size based on weighted time spent doing I/Os
        public ByteSizeValue getTotal() {
            if (previousReadsCompleted == -1 || previousWritesCompleted == -1) return -1;
            this.previousSectorsRead = previousSectorsRead;
            }
                builder.humanReadableField(Fields.TOTAL_IN_BYTES, Fields.TOTAL, getTotal());
                totalQueueSize += deviceStats.queueSize() != -1 ? deviceStats.queueSize() : 0;
        }
                for (DeviceStats deviceStats : devicesStats) {
            return (currentReadsCompleted - previousReadsCompleted);
            long totalReadTime = 0;
        public String getPath() {
        private static final String WRITE_OPERATIONS = "write_operations";
        final int majorDeviceNumber;
     *
         */
            previousSectorsWritten = in.readLong();
        private DeviceStats(
        }
                devicesStats[i].writeTo(out);
         */
     *
            previousSectorsRead = in.readLong();
package org.opensearch.monitor.fs;
            return builder;
    static final class Fields {
        }
            this.previousWritesCompleted = previousWritesCompleted;
                out.writeLong(previousWriteTime);
            static final String FREE = "free";
            private long currentWritesCompleted = 0;
            if (path != null) {
            return totalReadTime;
            final long currentReadsCompleted,
 * You may obtain a copy of the License at
         * This constructor will be deprecated starting in version 3.4.0.
            out.writeLong(previousSectorsWritten);
        final long currentReadsCompleted;
            return new ByteSizeValue(fileCacheUtilized);
        builder.field(Fields.TIMESTAMP, timestamp);
        public String getDeviceName() {
            this.totalOperations = totalOperations;
                    builder.endObject();
import org.opensearch.common.Nullable;
        public long readTime() {
        out.writeVLong(timestamp);
            return new ByteSizeValue(free);
            }
            this.devicesStats = devicesStats;
                this.totalWriteTime = in.readLong();
            final long previousQueueSize,
        @Deprecated
            static final String PATH = "path";
        final long currentSectorsWritten;
        }
            if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
            private long currentIOTime = 0;
            this.currentReadTime = currentReadTime;
            static final String AVAILABLE = "available";
        public DeviceStats(
         */
            }
             */
            if (total != -1) {
                out.writeLong(fileCacheUtilized);
            }
            final int length = in.readVInt();
            private long currentReadsCompleted = 0;
            out.writeLong(previousWritesCompleted);
            builder.field(IoStats.READ_TIME, readTime());
            private long previousSectorsRead = 0;
        final long totalWriteKilobytes;
                this.totalIOTimeInMillis = in.readLong();
            private long currentQueueSize = 0;
            if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
                previousDeviceStats != null ? previousDeviceStats.currentReadTime : -1,
            if (fileCacheReserved != 0) {
 * not use this file except in compliance with the License.
            }
            out.writeOptionalString(type);
        }
        public String getType() {
            final long currentSectorsWritten,
            builder.field(IoStats.WRITE_TIME, writeTime());
                previousQueueSize = 0;
         */
        }
     * @opensearch.api
        final long previousReadTime;
                this.currentIOTime = time;
        for (Path path : paths) {
            deviceName = in.readString();
         */
                totalWriteOperations += deviceStats.writeOperations() != -1 ? deviceStats.writeOperations() : 0;
            this.minorDeviceNumber = minorDeviceNumber;
    }
            this.previousIOTime = previousIOTime;
            }
        public IoStats(final DeviceStats[] devicesStats) {
        }
            if (current == -1 && other == -1) {
            out.writeLong(currentSectorsWritten);
            if (current == -1) {
        private static final String OPERATIONS = "operations";
            final long currentSectorsRead,
            private int minorDeviceNumber = 0;
            this.previousReadTime = previousReadTime;
 * FileSystem information
            this.previousIOTime = builder.previousIOTime;
            private long previousWritesCompleted = 0;
                this.previousReadTime = (deviceStats != null) ? deviceStats.currentReadTime : -1;
        builder.endObject();
        }
        }
            }
 * Licensed to Elasticsearch under one or more contributor
