            + "downloadBytesMovingAverage="  
            this.totalDownloadsSucceeded = in.readVLong();
    }
         * Provides a fluent API for constructing a Stats object.
            out.writeVLong(downloadBytesSucceeded);
        ) {  
 * @opensearch.api
    /**
     */
                return this;
            return this.shardId.equals(other.shardId)  
    private final AtomicLong lastSuccessfulDownloadTimestamp;
        downloadBytesSucceeded.addAndGet(count);
     * @param prevDownloadTimeInMillis   Amount of downloadTimeInMillis in this tracker before the download was started  
                && Double.compare(this.uploadBytesPerSecMovingAverage, other.uploadBytesPerSecMovingAverage) == 0
import org.opensearch.common.annotation.PublicApi;
                return this;
            public Builder lastSuccessfulDownloadTimestamp(long timestamp) {  
            + "totalUploadTimeInMillis="  
            .totalDownloadTimeInMillis(totalDownloadTimeInMillis.get())
    }  
            long uploadBytesFailed,  
            this.uploadTimeMovingAverage = builder.uploadTimeMovingAverage;
            this.lastSuccessfulUploadTimestamp = in.readVLong();  
            + uploadBytesMovingAverageReference.get().getAverage()
        lastSuccessfulDownloadTimestamp = new AtomicLong(0);
        downloadTimeMsMutex = new Object();  
    }
                return this;
        /**  
         */
         * Speed of a Remote Translog Store download in bytes-per-second.
            + "totalDownloadsSucceeded="  
        public final long uploadBytesStarted;  
            this.uploadBytesPerSecMovingAverage = builder.uploadBytesPerSecMovingAverage;  
             */
        public final long totalUploadsStarted;  
            this.uploadBytesStarted = uploadBytesStarted;
            this.uploadBytesSucceeded = builder.uploadBytesSucceeded;
    }
                this.downloadBytesSucceeded = succeeded;
        downloadBytesMovingAverageReference = new AtomicReference<>(new MovingAverage(movingAverageWindowSize));  
            .totalDownloadsSucceeded(totalDownloadsSucceeded.get())  
            + "lastSuccessfulUploadTimestamp="  
            public Builder uploadBytesMovingAverage(double average) {  
        return downloadBytesMovingAverageReference.get().isReady();  
        this.lastSuccessfulDownloadTimestamp.set(lastSuccessfulDownloadTimestamp);
        lastSuccessfulUploadTimestamp = new AtomicLong(0);  
                this.totalDownloadTimeInMillis = time;
                return this;  
            private double uploadTimeMovingAverage = 0;
    public long getLastSuccessfulUploadTimestamp() {
            }  
            out.writeVLong(uploadBytesFailed);
            this.totalUploadsStarted = builder.totalUploadsStarted;
    /**
    double getDownloadBytesPerSecMovingAverage() {  
            out.writeVLong(totalUploadTimeInMillis);
        /**
    public void addDownloadBytesSucceeded(long count) {  
    @Override  
     */  
         */
        public final double uploadBytesMovingAverage;
                this.downloadTimeMovingAverage = average;
            }  
            if (obj == null || getClass() != obj.getClass()) return false;  
    public void setLastSuccessfulUploadTimestamp(long lastSuccessfulUploadTimestamp) {
                downloadTimeMovingAverage  
     */
                this.totalUploadsFailed = failed;  
            .uploadBytesSucceeded(uploadBytesSucceeded.get())
            }  
                this.totalUploadsSucceeded = succeeded;
             * @return A new Stats instance.
            + ","
     */
                && this.totalDownloadsSucceeded == other.totalDownloadsSucceeded
        updateDownloadBytesMovingAverage(bytesDownloaded);  
/*  
        return lastSuccessfulUploadTimestamp.get();
            .totalUploadsSucceeded(totalUploadsSucceeded.get())
            public Builder uploadBytesSucceeded(long succeeded) {  
        setLastSuccessfulDownloadTimestamp(System.currentTimeMillis());  
            long totalDownloadsSucceeded,  
    public long getTotalDownloadsSucceeded() {  
        updateMovingAverage(speed, downloadBytesPerSecMutex, downloadBytesPerSecMovingAverageReference);
            this.uploadBytesSucceeded = in.readVLong();  
    private final AtomicLong totalDownloadTimeInMillis;
            }
            out.writeVLong(totalDownloadTimeInMillis);  
                return this;
                && this.uploadBytesFailed == other.uploadBytesFailed  
 * compatible open source license.
                return this;  
     */
            return Objects.hash(
        public final double downloadBytesPerSecMovingAverage;  
            + "totalUploadsStarted="  
         * Total number of Remote Translog Store uploads that have failed.  
        totalDownloadsSucceeded = new AtomicLong(0);
            long totalUploadsFailed,  
    /**
            this.downloadTimeMovingAverage = in.readDouble();  
            }
            this.shardId = shardId;
        /**
    public long getDownloadBytesSucceeded() {
            .uploadTimeMovingAverage(uploadTimeMsMovingAverageReference.get().getAverage())
            private double downloadBytesMovingAverage = 0;  
         */
            + ","
        public final double downloadBytesMovingAverage;
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.core.index.shard.ShardId;  
        @Override
            this.totalUploadsFailed = totalUploadsFailed;
            + ","
    public long getTotalDownloadTimeInMillis() {
    public void addDownloadTimeInMillis(long duration) {
        downloadBytesPerSecMovingAverageReference = new AtomicReference<>(new MovingAverage(movingAverageWindowSize));
     * Total time spent on Remote Translog Store downloads.
            + downloadBytesPerSecMovingAverageReference.get().getAverage()
    /**  
            .lastSuccessfulDownloadTimestamp(lastSuccessfulDownloadTimestamp.get())
            this.uploadBytesStarted = in.readVLong();
            this.downloadBytesSucceeded = builder.downloadBytesSucceeded;
        /**  
            this.totalUploadsSucceeded = builder.totalUploadsSucceeded;
         * Time taken by a Remote Translog Store download.  
        return downloadBytesMovingAverageReference.get().getAverage();
    private final AtomicLong downloadBytesSucceeded;
            double uploadTimeMovingAverage,
         * This constructor will be deprecated starting in version 3.4.0.  
        /**
     */  
            }
            this.lastSuccessfulUploadTimestamp = lastSuccessfulUploadTimestamp;  
    boolean isDownloadBytesMovingAverageReady() {
        /**
            + totalUploadsFailed.get()
    /**
         * Builder for the {@link Stats} class.
                return this;
public class RemoteTranslogTransferTracker extends RemoteTransferTracker {
            long totalDownloadTimeInMillis,
    private final AtomicReference<MovingAverage> downloadBytesPerSecMovingAverageReference;  
        /**
            }
            + "lastSuccessfulDownloadTimestamp="  
                uploadBytesStarted,
        long durationInMillis = getTotalDownloadTimeInMillis() - prevDownloadTimeInMillis;
            public Builder uploadTimeMovingAverage(double average) {
         */
            + ","
            + lastSuccessfulDownloadTimestamp.get()
            + downloadTimeMsMovingAverageReference.get().getAverage()
    public long getLastSuccessfulDownloadTimestamp() {  
 *
        }
                this.uploadBytesFailed = failed;  
        downloadBytesSucceeded = new AtomicLong(0);  
        public final double uploadBytesPerSecMovingAverage;
    }
            this.totalUploadsSucceeded = in.readVLong();  
            + totalDownloadsSucceeded.get()
            .uploadBytesStarted(uploadBytesStarted.get())
         */
            double uploadBytesPerSecMovingAverage,  
         * Total number of byte uploads to Remote Translog Store that have been started.
        /**
        private Stats(Builder builder) {
            out.writeVLong(totalUploadsStarted);
            .downloadBytesMovingAverage(downloadBytesMovingAverageReference.get().getAverage())  
        downloadTimeMsMovingAverageReference = new AtomicReference<>(new MovingAverage(movingAverageWindowSize));
            }  
            .totalUploadsStarted(totalUploadsStarted.get())
            + totalUploadsStarted.get()
     * @opensearch.api  
         */  
         * Epoch timestamp of the last successful Remote Translog Store upload.
         * Size of a Remote Translog Store upload in bytes.  
    /**  
     */
            private long uploadBytesFailed = 0;  
         */
     * Validates if the stats in this tracker and the stats contained in the given stats object are same or not  
    void updateDownloadBytesPerSecMovingAverage(long speed) {
        /**  
         * Total number of Remote Translog Store that have been successful.
            this.shardId = new ShardId(in);
    }  
            + ","
        public final double downloadTimeMovingAverage;
                this.lastSuccessfulDownloadTimestamp = timestamp;
            this.downloadBytesPerSecMovingAverage = in.readDouble();
            + "downloadBytesSucceeded="  
            }
                && this.lastSuccessfulDownloadTimestamp == other.lastSuccessfulDownloadTimestamp  
         */  
        super(shardId, movingAverageWindowSize);
            private double downloadTimeMovingAverage = 0;
            + "uploadBytesFailed="  
                return this;  
            }
     */
         */
                return this;  
            out.writeVLong(uploadBytesStarted);
                return this;
            private long totalDownloadTimeInMillis = 0;
    private final Object downloadBytesMutex;  
            + uploadBytesPerSecMovingAverageReference.get().getAverage()
                return this;
     */
            public Builder lastSuccessfulUploadTimestamp(long timestamp) {
            + uploadTimeMsMovingAverageReference.get().getAverage()
        totalDownloadsSucceeded.addAndGet(1);
     * @return Stats object with the tracker's stats
            + totalUploadsSucceeded.get()
    }
         * Total number of byte uploads to Remote Translog Store that have failed.  
                downloadBytesPerSecMovingAverage,
                this.uploadBytesPerSecMovingAverage = average;  
            .totalUploadTimeInMillis(totalUploadTimeInMillis.get())
                totalDownloadsSucceeded,
            public Builder totalUploadsSucceeded(long succeeded) {  
        return downloadBytesPerSecMovingAverageReference.get().getAverage();
        totalDownloadTimeInMillis = new AtomicLong(0);
         */  
            this.totalUploadsFailed = builder.totalUploadsFailed;  
         * Speed of a Remote Translog Store upload in bytes-per-second.
            + ","
         * Total number of byte downloads from Remote Translog Store that have been successful.
    boolean isDownloadBytesPerSecMovingAverageReady() {
            }  
                totalUploadsStarted,
     *
        updateMovingAverage(count, downloadBytesMutex, downloadBytesMovingAverageReference);
            long totalUploadsStarted,
 * The OpenSearch Contributors require contributions made to  
            public Builder totalDownloadsSucceeded(long succeeded) {
            + downloadBytesMovingAverageReference.get().getAverage()
        public final long totalUploadsSucceeded;
        public final double uploadTimeMovingAverage;  
            private long totalUploadsFailed = 0;  
                downloadBytesSucceeded,
            double downloadTimeMovingAverage
        return new RemoteTranslogTransferTracker.Stats.Builder().shardId(shardId)
                this.totalUploadsStarted = started;
        }  
                uploadBytesPerSecMovingAverage,
 * this file be licensed under the Apache-2.0 license or a
            out.writeDouble(downloadTimeMovingAverage);  
    public RemoteTranslogTransferTracker.Stats stats() {
 * Stores Remote Translog Store-related stats for a given IndexShard.
                totalUploadTimeInMillis,
     */
}
            public Builder totalUploadTimeInMillis(long time) {
            this.downloadBytesMovingAverage = builder.downloadBytesMovingAverage;  
                return this;
            .uploadBytesPerSecMovingAverage(uploadBytesPerSecMovingAverageReference.get().getAverage())  
        }
    @PublicApi(since = "2.10.0")
            private double uploadBytesPerSecMovingAverage = 0;  
        public final long lastSuccessfulUploadTimestamp;
            out.writeVLong(totalDownloadsSucceeded);
            }
    }  
        updateMovingAverage(duration, downloadTimeMsMutex, downloadTimeMsMovingAverageReference);
                && this.totalDownloadTimeInMillis == other.totalDownloadTimeInMillis  
    /**
        super.updateMovingAverageWindowSize(updatedSize);  
                this.uploadBytesStarted = started;
    }  
            this.uploadBytesPerSecMovingAverage = uploadBytesPerSecMovingAverage;  
            this.downloadTimeMovingAverage = downloadTimeMovingAverage;  
                lastSuccessfulUploadTimestamp,
                && this.totalUploadTimeInMillis == other.totalUploadTimeInMillis
    boolean isDownloadTimeMovingAverageReady() {
     * Provides moving average over the last N total size in bytes of translog files downloaded as part of Remote Translog Store download.
                return new Stats(this);
        updateMovingAverageWindowSize(updatedSize, downloadTimeMsMutex, downloadTimeMsMovingAverageReference);  
    private final AtomicLong lastSuccessfulUploadTimestamp;
        this.lastSuccessfulUploadTimestamp.set(lastSuccessfulUploadTimestamp);  
        incrementDownloadsSucceeded();
            private long lastSuccessfulUploadTimestamp = 0;  
        if (durationInMillis > 0) {  
     * Epoch timestamp of the last successful Remote Translog Store download.
        /**
        return downloadBytesPerSecMovingAverageReference.get().isReady();  
     * @param prevDownloadBytesSucceeded Number of downloadBytesSucceeded in this tracker before the download was started
    /**
     * Total number of byte downloads to Remote Translog Store that have been successful.  
            public Builder shardId(ShardId shardId) {  
        updateMovingAverageWindowSize(updatedSize, downloadBytesPerSecMutex, downloadBytesPerSecMovingAverageReference);
            ShardId shardId,
            out.writeDouble(uploadBytesMovingAverage);
            public Builder downloadBytesSucceeded(long succeeded) {
import org.opensearch.core.common.io.stream.StreamOutput;
            + totalDownloadTimeInMillis.get()
        long bytesDownloaded = getDownloadBytesSucceeded() - prevDownloadBytesSucceeded;
            }
            double uploadBytesMovingAverage,
            private long uploadBytesStarted = 0;
        totalDownloadTimeInMillis.addAndGet(duration);  
            this.uploadBytesSucceeded = uploadBytesSucceeded;  
        @Deprecated  
            this.lastSuccessfulUploadTimestamp = builder.lastSuccessfulUploadTimestamp;  
         */  
        updateMovingAverageWindowSize(updatedSize, downloadBytesMutex, downloadBytesMovingAverageReference);
            public Builder uploadBytesFailed(long failed) {
             * Creates a {@link Stats} object from the builder's current state.  
     */
        @Override  
            out.writeDouble(uploadTimeMovingAverage);
                && Double.compare(this.uploadTimeMovingAverage, other.uploadTimeMovingAverage) == 0
            this.uploadBytesFailed = builder.uploadBytesFailed;  
            );
            .build();  
            public Builder totalDownloadTimeInMillis(long time) {  
                return this;
            + ","
                this.uploadTimeMovingAverage = average;
         */  
     * Total number of Remote Translog Store downloads that have been successful.
                totalUploadsFailed,  
            this.uploadTimeMovingAverage = uploadTimeMovingAverage;
            long downloadBytesSucceeded,
            private long totalUploadsStarted = 0;
     * @param other Stats object to compare this tracker against
            out.writeDouble(uploadBytesPerSecMovingAverage);  
            this.totalUploadsStarted = in.readVLong();
    double getDownloadTimeMovingAverage() {  
        /**
    void updateDownloadBytesMovingAverage(long count) {
    public RemoteTranslogTransferTracker(ShardId shardId, int movingAverageWindowSize) {  
    boolean hasSameStatsAs(RemoteTranslogTransferTracker.Stats other) {
            }  
        public final long totalUploadTimeInMillis;  
        public void writeTo(StreamOutput out) throws IOException {  
         * Total time spent on Remote Translog Store uploads.
            this.totalUploadTimeInMillis = builder.totalUploadTimeInMillis;
    private final AtomicReference<MovingAverage> downloadTimeMsMovingAverageReference;
        }  
import java.io.IOException;
            updateDownloadBytesPerSecMovingAverage(bytesDownloaded * 1_000L / durationInMillis);
            this.downloadTimeMovingAverage = builder.downloadTimeMovingAverage;
         * Total number of Remote Translog Store uploads that have been started.
                && Double.compare(this.downloadBytesMovingAverage, other.downloadBytesMovingAverage) == 0
            this.totalUploadsStarted = totalUploadsStarted;
        public boolean equals(Object obj) {
            + "totalDownloadTimeInMillis="  
        public final long lastSuccessfulDownloadTimestamp;
                totalUploadsSucceeded,
                this.totalDownloadsSucceeded = succeeded;  
        public final long downloadBytesSucceeded;  
            this.lastSuccessfulDownloadTimestamp = lastSuccessfulDownloadTimestamp;  
            this.totalUploadTimeInMillis = in.readVLong();
                return this;  
            private ShardId shardId = null;
    void updateDownloadTimeMovingAverage(long duration) {
                && this.downloadBytesSucceeded == other.downloadBytesSucceeded
    }
     * This lock object is used for making sure we do not miss any data.
    }
            }
            out.writeVLong(lastSuccessfulUploadTimestamp);  
                totalDownloadTimeInMillis,  
        public final long uploadBytesSucceeded;
        /**
            + ","
    /**  
            double downloadBytesMovingAverage,  
            public Builder() {}
    public String toString() {
            + totalUploadTimeInMillis.get()
         * Total time spent on Remote Translog Store downloads.  
            this.totalDownloadTimeInMillis = totalDownloadTimeInMillis;  
        /**
     * Represents the tracker's state as seen in the stats API.
        public final long totalUploadsFailed;
     */
            long lastSuccessfulDownloadTimestamp,
            + "}";  
     * N is window size. Wrapped with {@code AtomicReference} for dynamic changes in window size.
     */  
                && Double.compare(this.downloadTimeMovingAverage, other.downloadTimeMovingAverage) == 0;  
         */
            this.uploadBytesPerSecMovingAverage = in.readDouble();  
    }
            + "uploadBytesMovingAverage="  
            + "uploadBytesPerSecMovingAverage="  
    /**
        return this.stats().equals(other);  
    /**  
    /**
            .totalUploadsFailed(totalUploadsFailed.get())  
            double downloadBytesPerSecMovingAverage,
            public Builder downloadBytesPerSecMovingAverage(double average) {
                return this;
            long uploadBytesStarted,
                uploadBytesMovingAverage,  
            this.downloadBytesSucceeded = in.readVLong();
            + downloadBytesSucceeded.get()
                && this.lastSuccessfulUploadTimestamp == other.lastSuccessfulUploadTimestamp
        downloadBytesMutex = new Object();
    private final AtomicLong totalDownloadsSucceeded;  
                shardId.toString(),  
                this.uploadBytesMovingAverage = average;
                return this;
    }
    /**
            + ","
            this.totalDownloadsSucceeded = totalDownloadsSucceeded;
    }
         */
        /**  
            this.downloadBytesSucceeded = downloadBytesSucceeded;
    private final Object downloadBytesPerSecMutex;
     *
    double getDownloadBytesMovingAverage() {  
                && this.totalUploadsSucceeded == other.totalUploadsSucceeded
            public Builder uploadBytesStarted(long started) {
     */  
    }
        return downloadTimeMsMovingAverageReference.get().isReady();  
     * This lock object is used for making sure we do not miss any data.  
            long totalUploadTimeInMillis,
                this.totalUploadTimeInMillis = time;
                && this.totalUploadsStarted == other.totalUploadsStarted
            /**
/**
    /**
        updateDownloadTimeMovingAverage(durationInMillis);
         */  
     * Record stats related to a download from Remote Translog Store  
            long lastSuccessfulUploadTimestamp,  
            + "downloadTimeMovingAverage="  
         */
            }
            public Builder totalUploadsStarted(long started) {
         */
        public Stats(StreamInput in) throws IOException {  
            this.totalDownloadTimeInMillis = in.readVLong();  
    }
                && this.uploadBytesStarted == other.uploadBytesStarted
            this.downloadBytesPerSecMovingAverage = builder.downloadBytesPerSecMovingAverage;
    }  
 */
            + uploadBytesFailed.get()
            out.writeDouble(downloadBytesPerSecMovingAverage);
    private final Object downloadTimeMsMutex;
    void setLastSuccessfulDownloadTimestamp(long lastSuccessfulDownloadTimestamp) {
        public final long totalDownloadsSucceeded;
                lastSuccessfulDownloadTimestamp,  
                uploadBytesSucceeded,
        return totalDownloadTimeInMillis.get();
            + ","
                this.shardId = shardId;
    }
     * Provides moving average over the last N overall download time (in nanos) as part of Remote Translog Store download. N is window size.
        public final long uploadBytesFailed;
            }
        /**  
package org.opensearch.index.remote;
            this.uploadBytesMovingAverage = uploadBytesMovingAverage;
            + ","
            + "downloadBytesPerSecMovingAverage="  
            this.totalUploadTimeInMillis = totalUploadTimeInMillis;
            out.writeVLong(uploadBytesSucceeded);  
            if (this == obj) return true;
        }
     * Gets the tracker's state as seen in the stats API  
     * Provides moving average over the last N download speed (in bytes/s) of translog files downloaded as part of Remote Translog Store download.  
     *
        return downloadBytesSucceeded.get();  
import java.util.Objects;  
    /**
        downloadBytesPerSecMutex = new Object();
            long uploadBytesSucceeded,
         * Total number of byte uploads to Remote Translog Store that have been successful.
            shardId.writeTo(out);
import org.opensearch.common.util.MovingAverage;
            private long totalUploadsSucceeded = 0;
     * This lock object is used for making sure we do not miss any data.
@PublicApi(since = "2.10.0")  
            this.totalDownloadTimeInMillis = builder.totalDownloadTimeInMillis;
            out.writeDouble(downloadBytesMovingAverage);
            out.writeVLong(totalUploadsFailed);
                uploadTimeMovingAverage,
            .uploadBytesMovingAverage(uploadBytesMovingAverageReference.get().getAverage())
        /**
            public Stats build() {  
            + lastSuccessfulUploadTimestamp.get()
 *  
            public Builder downloadBytesMovingAverage(double average) {
         * Epoch timestamp of the last successful Remote Translog Store download.  
     * Wrapped with {@code AtomicReference} for dynamic changes in window size.  
        }
     * @param updatedSize the updated size  
            + "uploadTimeMovingAverage="  
 * SPDX-License-Identifier: Apache-2.0
        public int hashCode() {
     */  
import java.util.concurrent.atomic.AtomicLong;
            .downloadTimeMovingAverage(downloadTimeMsMovingAverageReference.get().getAverage())
            this.uploadBytesMovingAverage = builder.uploadBytesMovingAverage;
            public Builder downloadTimeMovingAverage(double average) {  
                this.downloadBytesMovingAverage = average;  
     *
     * Epoch timestamp of the last successful Remote Translog Store upload.  
            }
    }  
            private long downloadBytesSucceeded = 0;
    }
            + "totalUploadsSucceeded="  
            + ","
            this.uploadBytesStarted = builder.uploadBytesStarted;
            private long uploadBytesSucceeded = 0;
            this.totalUploadsSucceeded = totalUploadsSucceeded;  
            this.downloadBytesMovingAverage = in.readDouble();
            + ","
        }
            + "totalUploadsFailed="  
            this.totalUploadsFailed = in.readVLong();
                return this;
    }  
        return lastSuccessfulDownloadTimestamp.get();
        @Override  
                this.uploadBytesSucceeded = succeeded;
         * Size of a Remote Translog Store download in bytes.
     * Updates the window size for data collection. This also resets any data collected so far.
            this.uploadTimeMovingAverage = in.readDouble();
                return this;  
            .uploadBytesFailed(uploadBytesFailed.get())  
            this.lastSuccessfulDownloadTimestamp = in.readVLong();  
        /**  
            + ","
     *
            private long totalUploadTimeInMillis = 0;
            this.uploadBytesFailed = in.readVLong();
            this.shardId = builder.shardId;
            }  
            long totalUploadsSucceeded,
            .lastSuccessfulUploadTimestamp(lastSuccessfulUploadTimestamp.get())  
        /**
    }
            + ","
            this.totalDownloadsSucceeded = builder.totalDownloadsSucceeded;  
        return totalDownloadsSucceeded.get();
            }
            + uploadBytesStarted.get()
            this.downloadBytesPerSecMovingAverage = downloadBytesPerSecMovingAverage;
            this.uploadBytesFailed = uploadBytesFailed;
    }
    }
                && Double.compare(this.uploadBytesMovingAverage, other.uploadBytesMovingAverage) == 0  
                && Double.compare(this.downloadBytesPerSecMovingAverage, other.downloadBytesPerSecMovingAverage) == 0
            public Builder totalUploadsFailed(long failed) {
    private final AtomicReference<MovingAverage> downloadBytesMovingAverageReference;
            private double downloadBytesPerSecMovingAverage = 0;
        public final long totalDownloadTimeInMillis;
         */  
            private long totalDownloadsSucceeded = 0;  
            public Builder uploadBytesPerSecMovingAverage(double average) {
        public Stats(
                downloadBytesMovingAverage,
    public void recordDownloadStats(long prevDownloadBytesSucceeded, long prevDownloadTimeInMillis) {
        public static class Builder {
            out.writeVLong(lastSuccessfulDownloadTimestamp);  
         */
    /**  
        return "RemoteTranslogTransferStats{"
    public static class Stats implements Writeable {  
            + "uploadBytesStarted="  
    void updateMovingAverageWindowSize(int updatedSize) {
            this.downloadBytesMovingAverage = downloadBytesMovingAverage;
    }  
        }
         * Use {@link Builder} instead.
         * Total number of Remote Translog Store downloads that have been successful.
        /**  
            this.uploadBytesMovingAverage = in.readDouble();
import org.opensearch.core.common.io.stream.Writeable;
            + ","
            RemoteTranslogTransferTracker.Stats other = (RemoteTranslogTransferTracker.Stats) obj;
        return downloadTimeMsMovingAverageReference.get().getAverage();
    }  
         */
import java.util.concurrent.atomic.AtomicReference;
                this.lastSuccessfulUploadTimestamp = timestamp;  
            this.lastSuccessfulDownloadTimestamp = builder.lastSuccessfulDownloadTimestamp;
            out.writeVLong(totalUploadsSucceeded);  
                return this;
        final ShardId shardId;
                && this.uploadBytesSucceeded == other.uploadBytesSucceeded
            + ","
     */
                && this.totalUploadsFailed == other.totalUploadsFailed  
            private long lastSuccessfulDownloadTimestamp = 0;
            private double uploadBytesMovingAverage = 0;
    void incrementDownloadsSucceeded() {
     * @return true if stats are same and false otherwise  
                uploadBytesFailed,  
                this.downloadBytesPerSecMovingAverage = average;
         * Time taken by a Remote Translog Store upload.
     * N is window size. Wrapped with {@code AtomicReference} for dynamic changes in window size.
        /**
 */  
            .downloadBytesPerSecMovingAverage(downloadBytesPerSecMovingAverageReference.get().getAverage())
            .downloadBytesSucceeded(downloadBytesSucceeded.get())
