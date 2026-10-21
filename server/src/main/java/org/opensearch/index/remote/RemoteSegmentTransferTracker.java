    }
                + totalUploadsSucceeded
                return this;
            .lastSuccessfulRemoteRefreshBytes(lastSuccessfulRemoteRefreshBytes)
    }
                && this.uploadBytesStarted == other.uploadBytesStarted
     * The method is given a function as an argument which is used for determining the file size (length in bytes).
        }
 */
                + ", uploadBytesSucceeded="
                && Double.compare(this.uploadBytesPerSecMovingAverage, other.uploadBytesPerSecMovingAverage) == 0
    }
            this.uploadTimeMovingAverage = uploadTimeMovingAverage;
            .uploadBytesStarted(uploadBytesStarted.get())
         * Provides a fluent API for constructing a Stats object.
                lastSuccessfulRemoteRefreshBytes,
            this.remoteRefreshNumber = builder.remoteRefreshNumber;
        long currentTimeMs = currentTimeMsUsingSystemNanos();
        rejectionCountMap.computeIfAbsent(rejectionReason, k -> new AtomicLong()).incrementAndGet();
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                && this.totalUploadTimeInMs == other.totalUploadTimeInMs
        // Both the local refresh time and remote refresh time are set with current time to give consistent view of time lag when it arises.
            }
    }
 * The OpenSearch Contributors require contributions made to
                + ", uploadTimeMovingAverage="
            long uploadBytesSucceeded,
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.common.util.Streak;
        super.incrementTotalUploadsFailed();
    private final AtomicLong rejectionCount = new AtomicLong();
            .totalUploadTimeInMs(totalUploadTimeInMillis.get())
        Set<String> fileSet = new HashSet<>(segmentFiles);
            .stream()
            this.localRefreshNumber = localRefreshNumber;
                && this.rejectionCount == other.rejectionCount
     */
    public RemoteSegmentTransferTracker.Stats stats() {
        segmentFiles.stream()
                directoryFileTransferTrackerStats
        this.localRefreshTimeMs = localRefreshTimeMs;
            }
                this.totalUploadsSucceeded = in.readLong();
                this.uploadBytesStarted = started;
    }
                return this;
            private long totalUploadsSucceeded = 0;
        if (isRemoteInSyncBeforeLocalRefresh) {
            latestLocalFileNameLengthMap.keySet()
                uploadBytesStarted,
        Set<String> filesNotYetUploaded = latestLocalFileNameLengthMap.keySet()
import java.util.Objects;
    /**
     * Cumulative sum of rejection counts for this shard.
                return this;
    }
 * SPDX-License-Identifier: Apache-2.0
     *
            out.writeLong(uploadBytesFailed);
    }
                this.lastSuccessfulRemoteRefreshBytes = in.readLong();
    long getRemoteRefreshSeqNo() {
            .rejectionCount(rejectionCount.get())
            public Builder remoteRefreshClockTimeMs(long time) {
                && this.refreshTimeLagMs == other.refreshTimeLagMs
import org.opensearch.core.common.io.stream.StreamInput;
 * Keeps track of remote refresh which happens in {@link org.opensearch.index.shard.RemoteStoreRefreshListener}. This consist of multiple critical metrics.
            }
    public synchronized void updateRemoteRefreshTimeMs(long refreshTimeMs) {
            + "currentLocalRefreshTimeMs="
                uploadBytesSucceeded,
            } catch (IOException e) {
            long consecutiveFailuresCount,
    }
    public static class Stats implements Writeable {
            out.writeLong(uploadBytesStarted);
import java.util.Collection;
    private void computeRefreshSeqNoLag() {
                + totalUploadTimeInMs
     * @return updated map of local segment files and filesize
                + ", uploadBytesPerSecMovingAverage="
    private volatile long remoteRefreshStartTimeMs = -1;
            this.directoryFileTransferTrackerStats = builder.directoryFileTransferTrackerStats;
                && this.localRefreshNumber == other.localRefreshNumber
    public long getRejectionCount() {
                this.uploadBytesStarted = in.readLong();
        this.latestUploadedFiles.add(file);
            out.writeLong(rejectionCount);
     */
                return this;
            out.writeDouble(uploadTimeMovingAverage);
            ShardId shardId,
 *
    /**
                this.remoteRefreshNumber = number;
            + this.remoteRefreshTimeMs;
    private volatile long remoteRefreshTimeMs;
                + ", directoryFileTransferTrackerStats="
            this.uploadBytesFailed = uploadBytesFailed;
}
                return this;
            if (obj == null || getClass() != obj.getClass()) return false;
     * This method is also provided the collection of segment files which are the latest refresh local segment files.
                this.remoteRefreshClockTimeMs = time;
                this.shardId = new ShardId(in);
    synchronized void updateLocalRefreshTimeMs(long localRefreshTimeMs) {
            return Objects.hash(
        public final DirectoryFileTransferTracker.Stats directoryFileTransferTrackerStats;
            out.writeLong(totalUploadTimeInMs);
            private ShardId shardId = null;
    private volatile long remoteRefreshSeqNo;
        public final ShardId shardId;
    }
                return this;
    public void addToLatestUploadedFiles(String file) {
    public long getBytesLag() {
    }
                this.bytesLag = in.readLong();
            .totalUploadsSucceeded(totalUploadsSucceeded.get())
    @PublicApi(since = "2.10.0")
            }
            long uploadBytesStarted,
            this.totalUploadsFailed = totalUploadsFailed;
    /**
                this.refreshTimeLagMs = time;
            out.writeLong(remoteRefreshNumber);
            private long lastSuccessfulRemoteRefreshBytes = 0;
            + " < "
    @Override
             * Creates a {@link Stats} object from the builder's current state.
        public final long uploadBytesStarted;
            Stats other = (Stats) obj;
            this.totalUploadTimeInMs = builder.totalUploadTimeInMs;
    public void incrementTotalUploadsSucceeded() {
                + remoteRefreshClockTimeMs
                return this;
                return this;
        }
            }
    }
        public Stats(StreamInput in) throws IOException {
                + ", consecutiveFailuresCount="
     */
        return uploadBytesStarted.get() - uploadBytesFailed.get() - uploadBytesSucceeded.get();
        public void writeTo(StreamOutput out) throws IOException {
                this.totalUploadsStarted = started;
                throw e;
            out.writeLong(localRefreshNumber);
             */
    public RemoteSegmentTransferTracker(
                totalUploadsFailed,
                } catch (IOException e) {
        return totalUploadsStarted.get() - totalUploadsFailed.get() - totalUploadsSucceeded.get();
            + "currentRemoteRefreshSeqNo="
     * This is the time of first local refresh after the last successful remote refresh. When the remote store is in
            this.bytesLag = builder.bytesLag;
            private long localRefreshClockTimeMs = 0;
            + "currentRemoteRefreshTimeMs="
            public Builder uploadBytesSucceeded(long succeeded) {
            }
            }
     * Every refresh is assigned a sequence number. This is the sequence number of the most recent refresh.
            private long localRefreshNumber = 0;
        return Collections.unmodifiableMap(latestLocalFileNameLengthMap);
    private void updateLocalRefreshClockTimeMs(long localRefreshClockTimeMs) {
    /**
    }
            private long totalUploadsFailed = 0;
        boolean isRemoteInSyncBeforeLocalRefresh = this.localRefreshTimeMs == this.remoteRefreshTimeMs;
    private final Logger logger;
     */
            this.uploadBytesStarted = uploadBytesStarted;
    /**
package org.opensearch.index.remote;
            this.totalUploadsSucceeded = builder.totalUploadsSucceeded;
    /**
            public Builder uploadBytesPerSecMovingAverage(double average) {
            this.uploadBytesSucceeded = uploadBytesSucceeded;
            this.refreshTimeLagMs = builder.refreshTimeLagMs;
                this.uploadBytesSucceeded = succeeded;
import org.apache.logging.log4j.Logger;
    }
        return rejectionCount.get();
    /**
        }
                return this;
            out.writeLong(lastSuccessfulRemoteRefreshBytes);
        }
        public final long totalUploadsFailed;
     * @opensearch.api
            out.writeLong(bytesLag);
            out.writeLong(refreshTimeLagMs);
        return failures.length();
            long totalUploadsSucceeded,
    }
                latestLocalFileNameLengthMap.put(file, fileSize);
            .totalUploadsFailed(totalUploadsFailed.get())
     */
                return this;
        DirectoryFileTransferTracker directoryFileTransferTracker,
import java.util.concurrent.atomic.AtomicLong;
            return "Stats{"
    public long getTimeMsLag() {
        private Stats(Builder builder) {
                remoteRefreshNumber,
    public DirectoryFileTransferTracker getDirectoryFileTransferTracker() {
        }
    /**
            long refreshTimeLagMs,
            out.writeLong(totalUploadsFailed);
                return this;
        return new Stats.Builder().shardId(shardId)
        // method is triggered, which will update the local localRefreshTimeMs. Now, the lag would basically become the
     * Keeps track of rejection count with each rejection reason.
            }
        assert remoteRefreshSeqNo >= this.remoteRefreshSeqNo : "newRemoteRefreshSeqNo="
        return rejectionCountMap.get(rejectionReason).get();
    }
                + ", totalUploadsFailed="
         * This constructor will be deprecated starting in version 3.4.0.
                && Double.compare(this.uploadTimeMovingAverage, other.uploadTimeMovingAverage) == 0
                this.uploadTimeMovingAverage = average;
                this.uploadBytesSucceeded = in.readLong();
        if (remoteRefreshTimeMs == localRefreshTimeMs || bytesLag == 0) {
     */
    public Map<String, Long> updateLatestLocalFileNameLengthMap(
/**
        public static class Builder {
    }
                this.uploadBytesPerSecMovingAverage = average;
            }
            long totalUploadsFailed,
            );
        public final long remoteRefreshNumber;
                + bytesLag
        public int hashCode() {
        this.remoteRefreshClockTimeMs = remoteRefreshClockTimeMs;
        );
         */
            private long consecutiveFailuresCount = 0;
            out.writeLong(remoteRefreshClockTimeMs);
            this.totalUploadsStarted = totalUploadsStarted;
            }
    long getRemoteRefreshTimeMs() {
                this.totalUploadTimeInMs = time;
    }
     * Updates the last refresh time and refresh seq no which is seen by local store.
        this.remoteRefreshSeqNo = remoteRefreshSeqNo;
                this.uploadBytesPerSecMovingAverage = in.readDouble();
            double uploadTimeMovingAverage,
    }
            + "currentLocalRefreshSeqNo="
     */
                this.localRefreshNumber = number;
            public Builder totalUploadsSucceeded(long succeeded) {
        }
        localRefreshClockTimeMs = currentClockTimeMs;
                + ", uploadBytesStarted="
                && this.bytesLag == other.bytesLag
 * compatible open source license.
        rejectionCount.incrementAndGet();
    /**
            long rejectionCount,
            });
    }
            .filter(file -> EXCLUDE_FILES.contains(file) == false)
            }
        assert localRefreshSeqNo >= this.localRefreshSeqNo : "newLocalRefreshSeqNo="
     */
        public final double uploadBytesPerSecMovingAverage;
            this.totalUploadTimeInMs = totalUploadTimeInMs;
    /**
     * This method also removes the stale segment files from the map that are not part of the input segment files.
                + '}';
     */
                this.uploadBytesFailed = in.readLong();
import org.opensearch.index.store.DirectoryFileTransferTracker;
        assert localRefreshTimeMs >= this.localRefreshTimeMs : "newLocalRefreshTimeMs="
            public Builder bytesLag(long lag) {
                && this.localRefreshClockTimeMs == other.localRefreshClockTimeMs
        @Deprecated
            }
            public Builder shardId(ShardId shardId) {
        int movingAverageWindowSize
            }
 * @opensearch.api
            }
            + this.localRefreshSeqNo;
                this.uploadBytesMovingAverage = average;
            .localRefreshNumber(localRefreshSeqNo)
            /**
            public Builder directoryFileTransferTrackerStats(DirectoryFileTransferTracker.Stats stats) {
                this.uploadBytesMovingAverage = in.readDouble();
    }
            public Builder uploadTimeMovingAverage(double average) {
                && Double.compare(this.uploadBytesMovingAverage, other.uploadBytesMovingAverage) == 0
                + localRefreshClockTimeMs
    private final DirectoryFileTransferTracker directoryFileTransferTracker;
                long fileSize = 0;
     * The refresh time(clock) of the most recent remote refresh.
                + ", localRefreshClockTimeMs="
import org.opensearch.common.annotation.PublicApi;
            this.remoteRefreshClockTimeMs = remoteRefreshClockTimeMs;
            this.consecutiveFailuresCount = consecutiveFailuresCount;
        public final long uploadBytesFailed;
            this.lastSuccessfulRemoteRefreshBytes = lastSuccessfulRemoteRefreshBytes;
    }
                && this.directoryFileTransferTrackerStats.equals(other.directoryFileTransferTrackerStats);
     */
            public Builder refreshTimeLagMs(long time) {
                + totalUploadsFailed
            shardId.writeTo(out);
                + ", totalUploadTimeInMs="
import org.opensearch.core.index.shard.ShardId;
                + ", bytesLag="
    private final Map<String, Long> latestLocalFileNameLengthMap = ConcurrentCollections.newConcurrentMap();
            this.localRefreshNumber = builder.localRefreshNumber;
            .remoteRefreshNumber(remoteRefreshSeqNo)
@PublicApi(since = "2.10.0")
            .localRefreshClockTimeMs(localRefreshClockTimeMs)
            public Builder totalUploadsStarted(long started) {
                localRefreshClockTimeMs,
    public long getLocalRefreshClockTimeMs() {
                try {
        this.directoryFileTransferTracker = directoryFileTransferTracker;
            .uploadBytesPerSecMovingAverage(uploadBytesPerSecMovingAverageReference.get().getAverage())
        public boolean equals(Object obj) {
        /**
                return this;
     */
            long remoteRefreshNumber,
        logger.debug(
                this.totalUploadsFailed = failed;
        computeRefreshSeqNoLag();
        computeBytesLag();
            this.uploadBytesPerSecMovingAverage = uploadBytesPerSecMovingAverage;
     */
        /**
        // time since the last refresh happened locally.
                this.directoryFileTransferTrackerStats = stats;
    /**
                + "shardId="
        return directoryFileTransferTracker;
            private long uploadBytesStarted = 0;
                + shardId
            }
    /**
            }
import java.util.HashSet;
            .uploadBytesSucceeded(uploadBytesSucceeded.get())
                this.localRefreshClockTimeMs = time;
    }
                return this;
    /**
            long localRefreshNumber,
    }
            .uploadBytesFailed(uploadBytesFailed.get())
    public static long currentTimeMsUsingSystemNanos() {
        public final long totalUploadsStarted;
            this.remoteRefreshStartTimeMs = localRefreshTimeMs;
            public Builder remoteRefreshNumber(long number) {
            try {
                + ", lastSuccessfulRemoteRefreshBytes="
            private long totalUploadsStarted = 0;
         * Use {@link Builder} instead.
                && this.lastSuccessfulRemoteRefreshBytes == other.lastSuccessfulRemoteRefreshBytes
            private long refreshTimeLagMs = 0;
            .consecutiveFailuresCount(failures.length())
            + refreshTimeMs
            private DirectoryFileTransferTracker.Stats directoryFileTransferTrackerStats = null;
            public Builder uploadBytesFailed(long failed) {
                totalUploadsStarted,
        }
    }
                && this.uploadBytesFailed == other.uploadBytesFailed
        return remoteRefreshSeqNo;
                + totalUploadsStarted
            .filter(f -> !latestUploadedFiles.contains(f))
            long localRefreshClockTimeMs,
        }
            }
    /**
     */
    public long getRefreshSeqNoLag() {
        return remoteRefreshClockTimeMs;
            .refreshTimeLagMs(getTimeMsLag())
    /**
            .uploadTimeMovingAverage(uploadTimeMsMovingAverageReference.get().getAverage())
            private double uploadTimeMovingAverage = 0;
                uploadTimeMovingAverage,
import org.apache.logging.log4j.message.ParameterizedMessage;
            }
                + rejectionCount
                localRefreshNumber,
     * last successful remote refresh state on successful remote refresh.
            + " < "
                this.remoteRefreshClockTimeMs = in.readLong();
     * @param fileSizeFunction function is used to determine the file size in bytes
            segmentFiles,
        public final long uploadBytesSucceeded;
        @Override
            private long uploadBytesSucceeded = 0;
            this.uploadBytesPerSecMovingAverage = builder.uploadBytesPerSecMovingAverage;
            this.rejectionCount = rejectionCount;
            this.directoryFileTransferTrackerStats = directoryFileTransferTrackerStats;
 */
     * Keeps the seq no lag computed so that we do not compute it for every request.
        incrementRejectionCount();
        logger = Loggers.getLogger(getClass(), shardId);
        updateLocalRefreshTimeMs(currentTimeMsUsingSystemNanos());
    private volatile long localRefreshTimeMs;
        public String toString() {
        @Override
                return new Stats(this);
                + ", uploadBytesFailed="
    private volatile long bytesLag;
     * Keeps track of the total bytes of segment files which were uploaded to remote store during last successful remote refresh
            public Builder totalUploadTimeInMs(long time) {
    /**
    // Visible for testing
 * this file be licensed under the Apache-2.0 license or a
            }
                + uploadTimeMovingAverage
            out.writeLong(totalUploadsSucceeded);
            public Builder totalUploadsFailed(long failed) {
    public long getLocalRefreshSeqNo() {
                totalUploadsSucceeded,
    private volatile long lastSuccessfulRemoteRefreshBytes;
                + ", totalUploadsStarted="
            out.writeDouble(uploadBytesPerSecMovingAverage);
                return this;
            public Builder rejectionCount(long count) {
            this.refreshTimeLagMs = refreshTimeLagMs;
                uploadBytesFailed,
    int getConsecutiveFailureCount() {
                + ", rejectionCount="
        this.remoteRefreshStartTimeMs = refreshTimeMs == this.localRefreshTimeMs ? -1 : this.localRefreshTimeMs;
    private volatile long localRefreshSeqNo;
                + ", uploadBytesMovingAverage="
                + uploadBytesMovingAverage
         */
        public final long bytesLag;
            this.shardId = shardId;
    long getRemoteRefreshClockTimeMs() {
            this.lastSuccessfulRemoteRefreshBytes = builder.lastSuccessfulRemoteRefreshBytes;
            this.uploadBytesMovingAverage = uploadBytesMovingAverage;
                    logger.warn(new ParameterizedMessage("Exception while reading the fileLength of file={}", file), e);
    public void incrementRejectionCount() {
            out.writeLong(consecutiveFailuresCount);
        if (latestLocalFileNameLengthMap.isEmpty()) {
            .collect(Collectors.toSet());
    }
            DirectoryFileTransferTracker.Stats directoryFileTransferTrackerStats
    }
                + ", totalUploadsSucceeded="
                this.totalUploadsSucceeded = succeeded;
            this.bytesLag = bytesLag;
            private double uploadBytesPerSecMovingAverage = 0;
            public Builder localRefreshClockTimeMs(long time) {
        remoteRefreshClockTimeMs = currentClockTimeMs;
                this.rejectionCount = in.readLong();
    /**
        computeBytesLag();
        updateLocalRefreshClockTimeMs(System.currentTimeMillis());
                + remoteRefreshNumber
        public final long consecutiveFailuresCount;
        public final long remoteRefreshClockTimeMs;
                this.consecutiveFailuresCount = in.readLong();
    }
    public long getInflightUploads() {
            if (this == obj) return true;
                shardId,
        public final long totalUploadsSucceeded;
        public final long totalUploadTimeInMs;
    void updateLocalRefreshSeqNo(long localRefreshSeqNo) {
import java.io.IOException;
        this.latestUploadedFiles.clear();
            this.totalUploadsStarted = builder.totalUploadsStarted;
        @Override
            .directoryFileTransferTrackerStats(directoryFileTransferTracker.stats())
     * Holds count of consecutive failures until last success. Gets reset to zero if there is a success.
        computeBytesLag();
            "segmentFilesPostRefresh={} latestLocalFileNamesBeforeMapUpdate={}",
        return bytesLag;
            }
    public void updateRemoteRefreshClockTimeMs(long remoteRefreshClockTimeMs) {
        public final long localRefreshNumber;
        this.localRefreshSeqNo = localRefreshSeqNo;
            .filter(file -> latestLocalFileNameLengthMap.containsKey(file) == false || latestLocalFileNameLengthMap.get(file) == 0)
        refreshSeqNoLag = localRefreshSeqNo - remoteRefreshSeqNo;
import java.util.stream.Collectors;
            out.writeLong(uploadBytesSucceeded);
                return this;
     * @param segmentFiles     list of local refreshed segment files
        // Update the map
            this.uploadBytesMovingAverage = builder.uploadBytesMovingAverage;
        return currentTimeMsUsingSystemNanos() - remoteRefreshStartTimeMs;
                && this.totalUploadsStarted == other.totalUploadsStarted
                + lastSuccessfulRemoteRefreshBytes
import org.opensearch.common.CheckedFunction;
    private volatile long localRefreshClockTimeMs;
        @Override
        computeRefreshSeqNoLag();
            }
                consecutiveFailuresCount,
                this.uploadTimeMovingAverage = in.readDouble();
        }
            this.localRefreshClockTimeMs = builder.localRefreshClockTimeMs;
            return 0;
            return this.shardId.toString().equals(other.shardId.toString())
     * Keeps the bytes lag computed so that we do not compute it for every request.
            long lastSuccessfulRemoteRefreshBytes,
                remoteRefreshClockTimeMs,
            private long rejectionCount = 0;
            return;
            .build();
                return this;
     * The refresh time of the most recent refresh.
            + localRefreshSeqNo
            this.shardId = builder.shardId;
import org.opensearch.common.logging.Loggers;
            private long uploadBytesFailed = 0;
                + ", remoteRefreshClockTimeMs="
                this.remoteRefreshNumber = in.readLong();
            + this.localRefreshTimeMs;
                + ", localRefreshNumber="
            double uploadBytesMovingAverage,
            long totalUploadTimeInMs,
                this.rejectionCount = count;
        return refreshSeqNoLag;
                totalUploadTimeInMs,
        ) {
            this.uploadBytesFailed = builder.uploadBytesFailed;
            out.writeLong(totalUploadsStarted);
    }
                && this.remoteRefreshClockTimeMs == other.remoteRefreshClockTimeMs
     * The refresh time of the most recent remote refresh.
                return this;
    private final Map<String, AtomicLong> rejectionCountMap = ConcurrentCollections.newConcurrentMap();
            private long remoteRefreshNumber = 0;
                + uploadBytesFailed
                this.totalUploadsFailed = in.readLong();
                return this;
    }
    }
    private void computeBytesLag() {
            + this.remoteRefreshSeqNo;
            this.remoteRefreshNumber = remoteRefreshNumber;
            this.consecutiveFailuresCount = builder.consecutiveFailuresCount;
            out.writeOptionalWriteable(directoryFileTransferTrackerStats);
        this.latestUploadedFiles.addAll(files);
import java.util.Collections;
        CheckedFunction<String, Long, IOException> fileSizeFunction
                }
                this.directoryFileTransferTrackerStats = in.readOptionalWriteable(DirectoryFileTransferTracker.Stats::new);
        public final double uploadBytesMovingAverage;
            long uploadBytesFailed,
    }
    }
                && this.uploadBytesSucceeded == other.uploadBytesSucceeded
import java.util.Set;
     */
                this.uploadBytesFailed = failed;
                this.totalUploadsStarted = in.readLong();
    public long getInflightUploadBytes() {
import java.util.concurrent.TimeUnit;
            long remoteRefreshClockTimeMs,
                this.totalUploadTimeInMs = in.readLong();
import org.opensearch.core.common.io.stream.Writeable;
    @Override
            double uploadBytesPerSecMovingAverage,
                + uploadBytesSucceeded
            this.uploadBytesStarted = builder.uploadBytesStarted;
 *
        localRefreshTimeMs = currentTimeMs;
                refreshTimeLagMs,
            public Builder uploadBytesStarted(long started) {
        this.bytesLag = filesNotYetUploaded.stream().map(latestLocalFileNameLengthMap::get).mapToLong(Long::longValue).sum();
            private long remoteRefreshClockTimeMs = 0;
                return this;
                rejectionCount,
            .totalUploadsStarted(totalUploadsStarted.get())
        public final long rejectionCount;
        public final long lastSuccessfulRemoteRefreshBytes;
                && this.totalUploadsSucceeded == other.totalUploadsSucceeded
                this.localRefreshClockTimeMs = in.readLong();
     */
            .uploadBytesMovingAverage(uploadBytesMovingAverageReference.get().getAverage())
     * sync with local refresh, this will be reset to -1.
            public Builder uploadBytesMovingAverage(double average) {
    public long getLocalRefreshTimeMs() {
            + " < "
    public void updateLocalRefreshTimeAndSeqNo() {
        failures.record(true);
        return localRefreshTimeMs;
                + refreshTimeLagMs
import static org.opensearch.index.shard.RemoteStoreRefreshListener.EXCLUDE_FILES;
    /**
            this.totalUploadsSucceeded = totalUploadsSucceeded;
                return this;
     */
            this.remoteRefreshClockTimeMs = builder.remoteRefreshClockTimeMs;
            + localRefreshTimeMs
/*
     * This contains the files from the last successful remote refresh and ongoing uploads. This gets reset to just the
        super(shardId, movingAverageWindowSize);
                uploadBytesPerSecMovingAverage,
        return Collections.unmodifiableMap(latestLocalFileNameLengthMap);
     * Sequence number of the most recent remote refresh.
        // When multiple refreshes have failed, there is a possibility that retry is ongoing while another refresh gets
    }
                this.bytesLag = lag;
     * {@link org.opensearch.index.store.Store.StoreDirectory} level file transfer tracker, used to show download stats
        public Stats(
            this.uploadTimeMovingAverage = builder.uploadTimeMovingAverage;
                + ", refreshTimeLagMs="
    // Visible for testing
    /** public only for testing **/
                + localRefreshNumber
                this.shardId = shardId;
                this.refreshTimeLagMs = in.readLong();
    void incrementRejectionCount(String rejectionReason) {
                uploadBytesMovingAverage,
     * The refresh time(clock) of the most recent refresh.
                bytesLag,
            + " < "
    ) {
        remoteRefreshTimeMs = currentTimeMs;
                && this.consecutiveFailuresCount == other.consecutiveFailuresCount
            public Builder localRefreshNumber(long number) {
    /**
                + ", remoteRefreshNumber="
     */
    long getRejectionCount(String rejectionReason) {
        return localRefreshSeqNo;
            this.uploadBytesSucceeded = builder.uploadBytesSucceeded;
            .remoteRefreshClockTimeMs(remoteRefreshClockTimeMs)
    public void incrementTotalUploadsFailed() {
            long bytesLag,
        public final long refreshTimeLagMs;
                this.localRefreshNumber = in.readLong();
     * Updates the latestLocalFileNameLengthMap by adding file name and it's size to the map.
        // triggered. After the segments have been uploaded and before the below code runs, the updateLocalRefreshTimeAndSeqNo
import java.util.Map;
        Collection<String> segmentFiles,
        this.localRefreshClockTimeMs = localRefreshClockTimeMs;
    ) {
            + remoteRefreshSeqNo
            private double uploadBytesMovingAverage = 0;
            }
            }
        public final long localRefreshClockTimeMs;
                + uploadBytesStarted
            private long bytesLag = 0;
     *
        }
    }
                return this;
            public Builder() {}
            this.rejectionCount = builder.rejectionCount;
        }
            out.writeLong(localRefreshClockTimeMs);
            long totalUploadsStarted,
        public final double uploadTimeMovingAverage;
    public void updateRemoteRefreshSeqNo(long remoteRefreshSeqNo) {
    private final Set<String> latestUploadedFiles = ConcurrentCollections.newConcurrentSet();
         * Builder for the {@link Stats} class.
             * @return A new Stats instance.
        super.incrementTotalUploadsSucceeded();
    }
                + consecutiveFailuresCount
            this.localRefreshClockTimeMs = localRefreshClockTimeMs;
                && this.remoteRefreshNumber == other.remoteRefreshNumber
     */
    public void setLatestUploadedFiles(Set<String> files) {
        remoteRefreshStartTimeMs = currentTimeMs;
        failures.record(false);
            .bytesLag(getBytesLag())
        ShardId shardId,
            this.totalUploadsFailed = builder.totalUploadsFailed;
                + uploadBytesPerSecMovingAverage
                    fileSize = fileSizeFunction.apply(file);
            out.writeDouble(uploadBytesMovingAverage);
            public Stats build() {
     */
            .forEach(file -> {
        updateLocalRefreshSeqNo(getLocalRefreshSeqNo() + 1);
    private volatile long remoteRefreshClockTimeMs;
                && this.totalUploadsFailed == other.totalUploadsFailed
     *
public class RemoteSegmentTransferTracker extends RemoteTransferTracker {
     * Represents the tracker's state as seen in the stats API.
        long currentClockTimeMs = System.currentTimeMillis();
            public Builder consecutiveFailuresCount(long count) {
                + directoryFileTransferTrackerStats
        latestLocalFileNameLengthMap.entrySet().removeIf(entry -> fileSet.contains(entry.getKey()) == false);
        return remoteRefreshTimeMs;
        this.remoteRefreshTimeMs = refreshTimeMs;
        assert refreshTimeMs >= this.remoteRefreshTimeMs : "newRemoteRefreshTimeMs="
        // Remove keys from the fileSizeMap that do not exist in the latest segment files
        return localRefreshClockTimeMs;
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    public Map<String, Long> getLatestLocalFileNameLengthMap() {
    }
            private long totalUploadTimeInMs = 0;
    private final Streak failures = new Streak();
            public Builder lastSuccessfulRemoteRefreshBytes(long bytes) {
                this.lastSuccessfulRemoteRefreshBytes = bytes;
     * Keeps track of segment files and their size in bytes which are part of the most recent refresh.
                this.consecutiveFailuresCount = count;
    private volatile long refreshSeqNoLag;
