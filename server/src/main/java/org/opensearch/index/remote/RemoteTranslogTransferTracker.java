    /**
    private final Object downloadBytesMutex;
        /**
            + ","
            public Builder totalDownloadsSucceeded(long succeeded) {
                totalUploadsFailed,
            + "downloadBytesPerSecMovingAverage="
            + "uploadBytesFailed="
    private final AtomicLong totalDownloadTimeInMillis;
            + "uploadBytesStarted="
                this.uploadBytesMovingAverage = average;
            out.writeVLong(downloadBytesSucceeded);
        /**
        this.lastSuccessfulUploadTimestamp.set(lastSuccessfulUploadTimestamp);
            this.totalDownloadTimeInMillis = in.readVLong();
            .totalUploadsFailed(totalUploadsFailed.get())
            .totalUploadsSucceeded(totalUploadsSucceeded.get())
                lastSuccessfulUploadTimestamp,
            }
        updateMovingAverageWindowSize(updatedSize, downloadTimeMsMutex, downloadTimeMsMovingAverageReference);
        return lastSuccessfulUploadTimestamp.get();
        downloadTimeMsMovingAverageReference = new AtomicReference<>(new MovingAverage(movingAverageWindowSize));
     * Total time spent on Remote Translog Store downloads.
            out.writeDouble(downloadTimeMovingAverage);
     */
                this.uploadBytesPerSecMovingAverage = average;
        /**
         * Builder for the {@link Stats} class.
            + ","
    }
        /**
     *
            double downloadBytesMovingAverage,
            out.writeVLong(totalDownloadsSucceeded);
            this.lastSuccessfulUploadTimestamp = builder.lastSuccessfulUploadTimestamp;
            out.writeVLong(totalUploadsFailed);
                this.uploadTimeMovingAverage = average;
    public long getTotalDownloadsSucceeded() {
            long uploadBytesFailed,
        updateMovingAverageWindowSize(updatedSize, downloadBytesPerSecMutex, downloadBytesPerSecMovingAverageReference);
            public Builder downloadBytesSucceeded(long succeeded) {
            + "}";
     * @param prevDownloadTimeInMillis   Amount of downloadTimeInMillis in this tracker before the download was started
            this.downloadTimeMovingAverage = in.readDouble();
     * Updates the window size for data collection. This also resets any data collected so far.
            .lastSuccessfulDownloadTimestamp(lastSuccessfulDownloadTimestamp.get())
    void updateDownloadTimeMovingAverage(long duration) {
                this.downloadBytesMovingAverage = average;
        public final double downloadBytesPerSecMovingAverage;
            this.uploadBytesMovingAverage = in.readDouble();
     */
            private long totalDownloadsSucceeded = 0;
        public final long lastSuccessfulDownloadTimestamp;
                && this.lastSuccessfulDownloadTimestamp == other.lastSuccessfulDownloadTimestamp
            public Builder uploadBytesPerSecMovingAverage(double average) {
        updateDownloadBytesMovingAverage(bytesDownloaded);
         */
            this.uploadBytesMovingAverage = uploadBytesMovingAverage;
    }
                && this.totalUploadTimeInMillis == other.totalUploadTimeInMillis
    public RemoteTranslogTransferTracker(ShardId shardId, int movingAverageWindowSize) {
    /**
            + ","
     */
            public Builder uploadBytesStarted(long started) {
         */
            }
                totalUploadTimeInMillis,
            public Builder() {}
            this.totalDownloadTimeInMillis = builder.totalDownloadTimeInMillis;
import org.opensearch.core.common.io.stream.StreamOutput;
     */
        final ShardId shardId;
         * Use {@link Builder} instead.
     */
                return this;
     */
            .downloadBytesSucceeded(downloadBytesSucceeded.get())
            updateDownloadBytesPerSecMovingAverage(bytesDownloaded * 1_000L / durationInMillis);
                uploadBytesMovingAverage,
            long totalUploadsSucceeded,
         * Total number of Remote Translog Store uploads that have been started.
         * Total number of Remote Translog Store downloads that have been successful.
    }
            private double downloadBytesMovingAverage = 0;
            }
         */
    private final AtomicReference<MovingAverage> downloadBytesMovingAverageReference;
         */
        /**
            this.uploadBytesSucceeded = in.readVLong();
                downloadBytesPerSecMovingAverage,
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(shardId)
                totalUploadsStarted,
     * This lock object is used for making sure we do not miss any data.
            this.uploadBytesFailed = in.readVLong();
            .downloadTimeMovingAverage(downloadTimeMsMovingAverageReference.get().getAverage())
    /**
    /**
         */
            + uploadBytesStarted.get()
        totalDownloadTimeInMillis.addAndGet(duration);
            this.downloadTimeMovingAverage = builder.downloadTimeMovingAverage;
                return this;
            + "downloadBytesMovingAverage="
        updateDownloadTimeMovingAverage(durationInMillis);
    private final Object downloadBytesPerSecMutex;
            + ","
            out.writeVLong(totalUploadsStarted);
    }
    public long getTotalDownloadTimeInMillis() {
            + "uploadBytesMovingAverage="
     * Epoch timestamp of the last successful Remote Translog Store download.
            private long totalDownloadTimeInMillis = 0;
         */
 * SPDX-License-Identifier: Apache-2.0
        /**
        public final long totalUploadsSucceeded;
        return lastSuccessfulDownloadTimestamp.get();
            shardId.writeTo(out);
    private final AtomicLong totalDownloadsSucceeded;
        @Override
                this.totalUploadsFailed = failed;
            long lastSuccessfulDownloadTimestamp,
            out.writeVLong(totalUploadTimeInMillis);
        public boolean equals(Object obj) {
     * This lock object is used for making sure we do not miss any data.
        setLastSuccessfulDownloadTimestamp(System.currentTimeMillis());
            .uploadBytesPerSecMovingAverage(uploadBytesPerSecMovingAverageReference.get().getAverage())
            long uploadBytesStarted,
     * @return Stats object with the tracker's stats
         * Speed of a Remote Translog Store upload in bytes-per-second.
            + totalUploadsFailed.get()
            this.uploadBytesStarted = in.readVLong();
package org.opensearch.index.remote;
            this.totalUploadsStarted = in.readVLong();
        downloadBytesMutex = new Object();
            }
            + uploadBytesFailed.get()
         * Total number of Remote Translog Store uploads that have failed.
    void updateDownloadBytesPerSecMovingAverage(long speed) {
        public Stats(StreamInput in) throws IOException {
            + ","
            }
            this.downloadBytesMovingAverage = downloadBytesMovingAverage;
    public void recordDownloadStats(long prevDownloadBytesSucceeded, long prevDownloadTimeInMillis) {
    /**
@PublicApi(since = "2.10.0")
            private long totalUploadTimeInMillis = 0;
        if (durationInMillis > 0) {
    private final AtomicLong downloadBytesSucceeded;
     *
            .totalDownloadsSucceeded(totalDownloadsSucceeded.get())
        return downloadBytesMovingAverageReference.get().getAverage();
                return this;
            + ","
        }
    }
         */
            }
            public Builder uploadBytesFailed(long failed) {
            out.writeDouble(uploadBytesPerSecMovingAverage);
     *
        /**
     */
             */
            private double uploadTimeMovingAverage = 0;
            out.writeDouble(downloadBytesPerSecMovingAverage);
         * Total time spent on Remote Translog Store uploads.
     */
            }
                && this.uploadBytesStarted == other.uploadBytesStarted
            + ","
    }
                totalDownloadTimeInMillis,
         * Total number of byte uploads to Remote Translog Store that have been successful.
            this.totalUploadsSucceeded = in.readVLong();
        public final double uploadBytesPerSecMovingAverage;
                return this;
            this.downloadBytesPerSecMovingAverage = downloadBytesPerSecMovingAverage;
            .build();
        @Deprecated
 * Stores Remote Translog Store-related stats for a given IndexShard.
        /**
        public final long downloadBytesSucceeded;
                return this;
     * Validates if the stats in this tracker and the stats contained in the given stats object are same or not
            }
         * Time taken by a Remote Translog Store download.
    private final AtomicLong lastSuccessfulDownloadTimestamp;
            .lastSuccessfulUploadTimestamp(lastSuccessfulUploadTimestamp.get())
    public String toString() {
                return this;
        /**
            private long uploadBytesFailed = 0;
            this.uploadBytesPerSecMovingAverage = uploadBytesPerSecMovingAverage;
            public Builder downloadTimeMovingAverage(double average) {
     */
                this.totalUploadsSucceeded = succeeded;
                && this.totalUploadsFailed == other.totalUploadsFailed
            this.downloadBytesSucceeded = builder.downloadBytesSucceeded;
 * @opensearch.api
            this.totalUploadsSucceeded = totalUploadsSucceeded;
     * Total number of Remote Translog Store downloads that have been successful.
         */
     */
                this.uploadBytesStarted = started;
        /**
            this.lastSuccessfulDownloadTimestamp = in.readVLong();
        public final double uploadBytesMovingAverage;
            this.totalUploadsFailed = in.readVLong();
         */
            this.lastSuccessfulUploadTimestamp = in.readVLong();
            private ShardId shardId = null;
            public Stats build() {
        return downloadTimeMsMovingAverageReference.get().getAverage();
            }
            }
            long totalDownloadTimeInMillis,
                this.totalDownloadTimeInMillis = time;
            out.writeDouble(downloadBytesMovingAverage);
            this.uploadBytesFailed = builder.uploadBytesFailed;
        long durationInMillis = getTotalDownloadTimeInMillis() - prevDownloadTimeInMillis;
            public Builder uploadBytesSucceeded(long succeeded) {
            .totalUploadsStarted(totalUploadsStarted.get())
            }
/*
    public static class Stats implements Writeable {
        /**
            this.totalUploadsStarted = builder.totalUploadsStarted;
            this.downloadBytesPerSecMovingAverage = in.readDouble();
     * @param updatedSize the updated size
    }
            + totalDownloadsSucceeded.get()
     * Epoch timestamp of the last successful Remote Translog Store upload.
            + downloadBytesMovingAverageReference.get().getAverage()
            }
            }
 */
    void updateMovingAverageWindowSize(int updatedSize) {
        public final long totalUploadsFailed;
                uploadBytesPerSecMovingAverage,
     */
            + totalUploadsStarted.get()
        return downloadTimeMsMovingAverageReference.get().isReady();
            this.totalDownloadsSucceeded = in.readVLong();
        return downloadBytesMovingAverageReference.get().isReady();
                && this.uploadBytesSucceeded == other.uploadBytesSucceeded
    /**
        return totalDownloadTimeInMillis.get();
            this.uploadBytesFailed = uploadBytesFailed;
            public Builder lastSuccessfulUploadTimestamp(long timestamp) {
     * N is window size. Wrapped with {@code AtomicReference} for dynamic changes in window size.
    }
    /**
 * The OpenSearch Contributors require contributions made to
        /**
            }
            }
            + "totalDownloadsSucceeded="
     * Provides moving average over the last N overall download time (in nanos) as part of Remote Translog Store download. N is window size.
            this.uploadBytesSucceeded = builder.uploadBytesSucceeded;
        }
                this.lastSuccessfulDownloadTimestamp = timestamp;
            + downloadBytesPerSecMovingAverageReference.get().getAverage()
    /**
     * Provides moving average over the last N download speed (in bytes/s) of translog files downloaded as part of Remote Translog Store download.
            + totalDownloadTimeInMillis.get()
            + "totalUploadTimeInMillis="
                downloadTimeMovingAverage
         */
        public final long totalDownloadsSucceeded;
        updateMovingAverage(count, downloadBytesMutex, downloadBytesMovingAverageReference);
    }
            this.shardId = builder.shardId;
    boolean isDownloadTimeMovingAverageReady() {
            double downloadBytesPerSecMovingAverage,
            + "totalUploadsSucceeded="
    void updateDownloadBytesMovingAverage(long count) {
            public Builder totalUploadsSucceeded(long succeeded) {
     *
            private long lastSuccessfulUploadTimestamp = 0;
                && Double.compare(this.downloadBytesMovingAverage, other.downloadBytesMovingAverage) == 0
        }
    }
    }
     * @param other Stats object to compare this tracker against
            this.totalDownloadsSucceeded = builder.totalDownloadsSucceeded;
                downloadBytesMovingAverage,
        public final long uploadBytesFailed;
                return new Stats(this);
     * @param prevDownloadBytesSucceeded Number of downloadBytesSucceeded in this tracker before the download was started
            public Builder totalDownloadTimeInMillis(long time) {
            + ","
        /**
            this.totalDownloadsSucceeded = totalDownloadsSucceeded;
    public long getLastSuccessfulUploadTimestamp() {
            this.totalUploadTimeInMillis = totalUploadTimeInMillis;
            private long totalUploadsStarted = 0;
    /**
            + "totalUploadsFailed="
        /**
    /**
            long totalUploadsStarted,
            long uploadBytesSucceeded,
        this.lastSuccessfulDownloadTimestamp.set(lastSuccessfulDownloadTimestamp);
            .uploadBytesStarted(uploadBytesStarted.get())
    @Override
    public void setLastSuccessfulUploadTimestamp(long lastSuccessfulUploadTimestamp) {
            /**
    }
                return this;
         * Total number of byte downloads from Remote Translog Store that have been successful.
 * this file be licensed under the Apache-2.0 license or a
            + downloadTimeMsMovingAverageReference.get().getAverage()
        totalDownloadTimeInMillis = new AtomicLong(0);
        private Stats(Builder builder) {
            + "lastSuccessfulUploadTimestamp="
            + uploadBytesPerSecMovingAverageReference.get().getAverage()
    /**
        return downloadBytesPerSecMovingAverageReference.get().isReady();
    private final AtomicReference<MovingAverage> downloadBytesPerSecMovingAverageReference;
    /**
            + "lastSuccessfulDownloadTimestamp="
            + ","
            }
    }
                && this.lastSuccessfulUploadTimestamp == other.lastSuccessfulUploadTimestamp
                uploadBytesSucceeded,
            + "totalUploadsStarted="
            long downloadBytesSucceeded,
        return "RemoteTranslogTransferStats{"
            RemoteTranslogTransferTracker.Stats other = (RemoteTranslogTransferTracker.Stats) obj;
 *
        super(shardId, movingAverageWindowSize);
import java.util.concurrent.atomic.AtomicLong;
                lastSuccessfulDownloadTimestamp,
            .totalDownloadTimeInMillis(totalDownloadTimeInMillis.get())
            + ","
        updateMovingAverage(duration, downloadTimeMsMutex, downloadTimeMsMovingAverageReference);
                uploadBytesFailed,
                return this;
            private double uploadBytesMovingAverage = 0;
    /**
    }
            private long downloadBytesSucceeded = 0;
    /**
            this.uploadTimeMovingAverage = builder.uploadTimeMovingAverage;
            this.uploadBytesPerSecMovingAverage = builder.uploadBytesPerSecMovingAverage;
    }
        }
            .totalUploadTimeInMillis(totalUploadTimeInMillis.get())
    boolean isDownloadBytesMovingAverageReady() {
            + lastSuccessfulUploadTimestamp.get()
                && Double.compare(this.uploadBytesPerSecMovingAverage, other.uploadBytesPerSecMovingAverage) == 0
            this.lastSuccessfulUploadTimestamp = lastSuccessfulUploadTimestamp;
     */
    /**
            this.totalUploadsFailed = builder.totalUploadsFailed;
            + "downloadTimeMovingAverage="
                && Double.compare(this.uploadBytesMovingAverage, other.uploadBytesMovingAverage) == 0
        public void writeTo(StreamOutput out) throws IOException {
        public final double downloadTimeMovingAverage;
        public static class Builder {
            this.totalUploadsFailed = totalUploadsFailed;
         */
         */
            this.uploadBytesPerSecMovingAverage = in.readDouble();
    public RemoteTranslogTransferTracker.Stats stats() {
            return Objects.hash(
            private long totalUploadsFailed = 0;
    void setLastSuccessfulDownloadTimestamp(long lastSuccessfulDownloadTimestamp) {
            double uploadBytesMovingAverage,
            + ","
         */
import org.opensearch.common.annotation.PublicApi;
    }
                && this.downloadBytesSucceeded == other.downloadBytesSucceeded
/**
                totalUploadsSucceeded,
import java.util.concurrent.atomic.AtomicReference;
                this.uploadBytesFailed = failed;
            this.totalUploadsStarted = totalUploadsStarted;
            out.writeVLong(uploadBytesSucceeded);
         * Epoch timestamp of the last successful Remote Translog Store upload.
        public final long lastSuccessfulUploadTimestamp;
                return this;
            if (this == obj) return true;
import java.io.IOException;
            this.uploadBytesMovingAverage = builder.uploadBytesMovingAverage;
            out.writeVLong(totalUploadsSucceeded);
            this.uploadTimeMovingAverage = in.readDouble();
         * Speed of a Remote Translog Store download in bytes-per-second.
    }
            return this.shardId.equals(other.shardId)
                && this.totalUploadsSucceeded == other.totalUploadsSucceeded
            + uploadBytesMovingAverageReference.get().getAverage()
    }
    double getDownloadBytesMovingAverage() {
            private long totalUploadsSucceeded = 0;
            double downloadTimeMovingAverage
            this.lastSuccessfulDownloadTimestamp = builder.lastSuccessfulDownloadTimestamp;
         */
                && this.totalDownloadsSucceeded == other.totalDownloadsSucceeded
         * Total number of byte uploads to Remote Translog Store that have failed.
            private double downloadTimeMovingAverage = 0;
        downloadBytesMovingAverageReference = new AtomicReference<>(new MovingAverage(movingAverageWindowSize));
    }
                return this;
        @Override
         * This constructor will be deprecated starting in version 3.4.0.
        public final long totalUploadTimeInMillis;
            out.writeVLong(uploadBytesFailed);
            + ","
            + downloadBytesSucceeded.get()
                return this;
                this.totalUploadsStarted = started;
        /**
         * Total number of byte uploads to Remote Translog Store that have been started.
        updateMovingAverage(speed, downloadBytesPerSecMutex, downloadBytesPerSecMovingAverageReference);
        }
                downloadBytesSucceeded,
    }
     */
         */
         */
            public Builder totalUploadsStarted(long started) {
        long bytesDownloaded = getDownloadBytesSucceeded() - prevDownloadBytesSucceeded;
 *
            + ","
            this.downloadBytesMovingAverage = builder.downloadBytesMovingAverage;
    }
            this.downloadBytesMovingAverage = in.readDouble();
    boolean hasSameStatsAs(RemoteTranslogTransferTracker.Stats other) {
            .downloadBytesPerSecMovingAverage(downloadBytesPerSecMovingAverageReference.get().getAverage())
        lastSuccessfulUploadTimestamp = new AtomicLong(0);
    public long getLastSuccessfulDownloadTimestamp() {
            public Builder downloadBytesPerSecMovingAverage(double average) {
            .uploadBytesSucceeded(uploadBytesSucceeded.get())
            out.writeDouble(uploadTimeMovingAverage);
        incrementDownloadsSucceeded();
    }
            this.shardId = shardId;
 * compatible open source license.
            this.uploadBytesStarted = uploadBytesStarted;
                return this;
     * @opensearch.api
        super.updateMovingAverageWindowSize(updatedSize);
     */
        }
            + lastSuccessfulDownloadTimestamp.get()
    void incrementDownloadsSucceeded() {
                && Double.compare(this.downloadBytesPerSecMovingAverage, other.downloadBytesPerSecMovingAverage) == 0
     * @return true if stats are same and false otherwise
            + ","
            + "downloadBytesSucceeded="
            }
            out.writeVLong(lastSuccessfulUploadTimestamp);
                shardId.toString(),
    double getDownloadTimeMovingAverage() {
    }
                return this;
        public int hashCode() {
            this.downloadBytesSucceeded = downloadBytesSucceeded;
    /**
                return this;
        public final long totalDownloadTimeInMillis;
}
         */
        lastSuccessfulDownloadTimestamp = new AtomicLong(0);
     * Record stats related to a download from Remote Translog Store
             * Creates a {@link Stats} object from the builder's current state.
            public Builder shardId(ShardId shardId) {
        /**
            out.writeVLong(lastSuccessfulDownloadTimestamp);
    private final AtomicLong lastSuccessfulUploadTimestamp;
            public Builder uploadBytesMovingAverage(double average) {
                return this;
        /**
                this.totalUploadTimeInMillis = time;
         * Total number of Remote Translog Store that have been successful.
        return downloadBytesSucceeded.get();
                return this;
        updateMovingAverageWindowSize(updatedSize, downloadBytesMutex, downloadBytesMovingAverageReference);
            + "uploadBytesPerSecMovingAverage="
            + "totalDownloadTimeInMillis="
     * Wrapped with {@code AtomicReference} for dynamic changes in window size.
 */
            .uploadBytesMovingAverage(uploadBytesMovingAverageReference.get().getAverage())
    private final Object downloadTimeMsMutex;
     * Total number of byte downloads to Remote Translog Store that have been successful.
            public Builder lastSuccessfulDownloadTimestamp(long timestamp) {
                return this;
            private long uploadBytesStarted = 0;
public class RemoteTranslogTransferTracker extends RemoteTransferTracker {
         */
            + "uploadTimeMovingAverage="
                && this.totalDownloadTimeInMillis == other.totalDownloadTimeInMillis
     */
            this.downloadTimeMovingAverage = downloadTimeMovingAverage;
            this.uploadBytesSucceeded = uploadBytesSucceeded;
import org.opensearch.core.index.shard.ShardId;
        }
        downloadBytesPerSecMutex = new Object();
            this.totalDownloadTimeInMillis = totalDownloadTimeInMillis;
        public final long totalUploadsStarted;
        return this.stats().equals(other);
        downloadBytesPerSecMovingAverageReference = new AtomicReference<>(new MovingAverage(movingAverageWindowSize));
     *
            + uploadTimeMsMovingAverageReference.get().getAverage()
        downloadTimeMsMutex = new Object();
            }
    private final AtomicReference<MovingAverage> downloadTimeMsMovingAverageReference;
                this.lastSuccessfulUploadTimestamp = timestamp;
        /**
            this.totalUploadsSucceeded = builder.totalUploadsSucceeded;
         */
    @PublicApi(since = "2.10.0")
            out.writeVLong(totalDownloadTimeInMillis);
        }
    public void addDownloadTimeInMillis(long duration) {
        public final double uploadTimeMovingAverage;
     * N is window size. Wrapped with {@code AtomicReference} for dynamic changes in window size.
         */
            }
import org.opensearch.core.common.io.stream.StreamInput;
        downloadBytesSucceeded = new AtomicLong(0);
            + totalUploadTimeInMillis.get()
        downloadBytesSucceeded.addAndGet(count);
     * Gets the tracker's state as seen in the stats API
            }
import org.opensearch.common.util.MovingAverage;
            long totalDownloadsSucceeded,
    public void addDownloadBytesSucceeded(long count) {
         * Total time spent on Remote Translog Store downloads.
            this.totalUploadTimeInMillis = in.readVLong();
            this.shardId = new ShardId(in);
            if (obj == null || getClass() != obj.getClass()) return false;
            private long uploadBytesSucceeded = 0;
            public Builder uploadTimeMovingAverage(double average) {
     * Provides moving average over the last N total size in bytes of translog files downloaded as part of Remote Translog Store download.
            long totalUploadTimeInMillis,
                && Double.compare(this.uploadTimeMovingAverage, other.uploadTimeMovingAverage) == 0
        @Override
import java.util.Objects;
    }
                this.shardId = shardId;
                uploadTimeMovingAverage,
            this.uploadTimeMovingAverage = uploadTimeMovingAverage;
            ShardId shardId,
                return this;
        /**
    double getDownloadBytesPerSecMovingAverage() {
            + ","
            this.lastSuccessfulDownloadTimestamp = lastSuccessfulDownloadTimestamp;
         * Provides a fluent API for constructing a Stats object.
            + ","
        public Stats(
        return totalDownloadsSucceeded.get();
    public long getDownloadBytesSucceeded() {
            out.writeDouble(uploadBytesMovingAverage);
        /**
            .uploadTimeMovingAverage(uploadTimeMsMovingAverageReference.get().getAverage())
            public Builder totalUploadTimeInMillis(long time) {
            out.writeVLong(uploadBytesStarted);
        public final double downloadBytesMovingAverage;
import org.opensearch.core.common.io.stream.Writeable;
        totalDownloadsSucceeded = new AtomicLong(0);
                this.uploadBytesSucceeded = succeeded;
     * Represents the tracker's state as seen in the stats API.
                this.downloadTimeMovingAverage = average;
            this.downloadBytesSucceeded = in.readVLong();
                && Double.compare(this.downloadTimeMovingAverage, other.downloadTimeMovingAverage) == 0;
            long totalUploadsFailed,
             * @return A new Stats instance.
            this.totalUploadTimeInMillis = builder.totalUploadTimeInMillis;
    boolean isDownloadBytesPerSecMovingAverageReady() {
                return this;
    }
        public final long uploadBytesSucceeded;
            + ","
                && this.uploadBytesFailed == other.uploadBytesFailed
            this.downloadBytesPerSecMovingAverage = builder.downloadBytesPerSecMovingAverage;
                && this.totalUploadsStarted == other.totalUploadsStarted
                this.totalDownloadsSucceeded = succeeded;
     * This lock object is used for making sure we do not miss any data.
                this.downloadBytesPerSecMovingAverage = average;
            this.uploadBytesStarted = builder.uploadBytesStarted;
            private double uploadBytesPerSecMovingAverage = 0;
        ) {
            + totalUploadsSucceeded.get()
            .downloadBytesMovingAverage(downloadBytesMovingAverageReference.get().getAverage())
            .uploadBytesFailed(uploadBytesFailed.get())
         * Size of a Remote Translog Store download in bytes.
                this.downloadBytesSucceeded = succeeded;
                uploadBytesStarted,
                totalDownloadsSucceeded,
        return downloadBytesPerSecMovingAverageReference.get().getAverage();
         * Time taken by a Remote Translog Store upload.
            double uploadBytesPerSecMovingAverage,
        public final long uploadBytesStarted;
            private double downloadBytesPerSecMovingAverage = 0;
            );
            public Builder totalUploadsFailed(long failed) {
        totalDownloadsSucceeded.addAndGet(1);
            private long lastSuccessfulDownloadTimestamp = 0;
         * Size of a Remote Translog Store upload in bytes.
         * Epoch timestamp of the last successful Remote Translog Store download.
     */
            double uploadTimeMovingAverage,
    }
            long lastSuccessfulUploadTimestamp,
            public Builder downloadBytesMovingAverage(double average) {
