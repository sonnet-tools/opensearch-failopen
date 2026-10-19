                this.uploadBytesSucceeded = succeeded;  
     */
            long totalUploadsStarted,
    @Override
        public final long uploadBytesSucceeded;
     * Updates the last refresh time and refresh seq no which is seen by local store.
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        }  
                this.localRefreshClockTimeMs = in.readLong();
                this.localRefreshNumber = in.readLong();
    private volatile long localRefreshTimeMs;  
                } catch (IOException e) {  
        this.latestUploadedFiles.add(file);
                this.totalUploadTimeInMs = in.readLong();
            this.rejectionCount = rejectionCount;
        }  
    public void addToLatestUploadedFiles(String file) {  
        public Stats(  
                + ", consecutiveFailuresCount="  
            private long totalUploadsStarted = 0;
        return new Stats.Builder().shardId(shardId)
    public synchronized void updateRemoteRefreshTimeMs(long refreshTimeMs) {
    }
    public long getInflightUploadBytes() {
            }
                return this;
            .uploadBytesPerSecMovingAverage(uploadBytesPerSecMovingAverageReference.get().getAverage())
            private long totalUploadTimeInMs = 0;  
@PublicApi(since = "2.10.0")
            .remoteRefreshClockTimeMs(remoteRefreshClockTimeMs)  
            + this.localRefreshTimeMs;  
            .bytesLag(getBytesLag())
    public long getBytesLag() {
     */
            long localRefreshClockTimeMs,
                + ", uploadBytesStarted="
            this.uploadBytesPerSecMovingAverage = uploadBytesPerSecMovingAverage;  
            out.writeLong(uploadBytesSucceeded);
                + ", remoteRefreshClockTimeMs="
            private long localRefreshNumber = 0;
        updateLocalRefreshSeqNo(getLocalRefreshSeqNo() + 1);  
     */
                this.refreshTimeLagMs = in.readLong();  
        public final long rejectionCount;  
                && this.directoryFileTransferTrackerStats.equals(other.directoryFileTransferTrackerStats);
                && Double.compare(this.uploadBytesMovingAverage, other.uploadBytesMovingAverage) == 0
            public Builder totalUploadsFailed(long failed) {  
        public final double uploadBytesMovingAverage;  
            this.totalUploadsFailed = totalUploadsFailed;  
     * @param fileSizeFunction function is used to determine the file size in bytes  
                totalUploadsStarted,
        public static class Builder {  
                this.lastSuccessfulRemoteRefreshBytes = in.readLong();
                && this.totalUploadsSucceeded == other.totalUploadsSucceeded
        DirectoryFileTransferTracker directoryFileTransferTracker,
        rejectionCount.incrementAndGet();
            private double uploadTimeMovingAverage = 0;
                + ", totalUploadsFailed="  
        updateLocalRefreshClockTimeMs(System.currentTimeMillis());
            this.totalUploadsSucceeded = totalUploadsSucceeded;
            }
                return this;  
            .filter(f -> !latestUploadedFiles.contains(f))
import java.util.concurrent.atomic.AtomicLong;
            out.writeDouble(uploadTimeMovingAverage);
    private void computeRefreshSeqNoLag() {
                this.localRefreshClockTimeMs = time;
    }
                this.uploadBytesFailed = in.readLong();
        public final long totalUploadsFailed;
                this.remoteRefreshClockTimeMs = in.readLong();
    }  
    /**
                + '}';
    private final Map<String, AtomicLong> rejectionCountMap = ConcurrentCollections.newConcurrentMap();
                this.uploadTimeMovingAverage = average;
            out.writeLong(totalUploadsFailed);
                + rejectionCount
            private long lastSuccessfulRemoteRefreshBytes = 0;  
            Stats other = (Stats) obj;  
                + ", remoteRefreshNumber="
     */
    }  
    public long getLocalRefreshSeqNo() {
                uploadBytesMovingAverage,
 * The OpenSearch Contributors require contributions made to  
                this.uploadBytesPerSecMovingAverage = average;
    }  
                && this.uploadBytesFailed == other.uploadBytesFailed  
    public static class Stats implements Writeable {
            + localRefreshSeqNo
        public final long uploadBytesFailed;
    public void incrementRejectionCount() {  
                && this.lastSuccessfulRemoteRefreshBytes == other.lastSuccessfulRemoteRefreshBytes
        failures.record(true);
    void updateLocalRefreshSeqNo(long localRefreshSeqNo) {  
            this.totalUploadTimeInMs = totalUploadTimeInMs;  
    @PublicApi(since = "2.10.0")  
            out.writeLong(remoteRefreshNumber);
        }
    /**
            this.remoteRefreshClockTimeMs = builder.remoteRefreshClockTimeMs;
public class RemoteSegmentTransferTracker extends RemoteTransferTracker {  
     * {@link org.opensearch.index.store.Store.StoreDirectory} level file transfer tracker, used to show download stats
            long rejectionCount,
    private volatile long refreshSeqNoLag;
/**  
        return remoteRefreshTimeMs;  
            long totalUploadTimeInMs,
    }
        this.remoteRefreshStartTimeMs = refreshTimeMs == this.localRefreshTimeMs ? -1 : this.localRefreshTimeMs;  
    private final DirectoryFileTransferTracker directoryFileTransferTracker;  
            out.writeLong(uploadBytesFailed);
    }
                && this.totalUploadsFailed == other.totalUploadsFailed  
                + ", directoryFileTransferTrackerStats="
        public final long consecutiveFailuresCount;
        return remoteRefreshSeqNo;
                uploadBytesPerSecMovingAverage,
    public DirectoryFileTransferTracker getDirectoryFileTransferTracker() {
    /**
import org.opensearch.common.CheckedFunction;  
            long remoteRefreshNumber,  
        computeBytesLag();
    ) {  
            .filter(file -> EXCLUDE_FILES.contains(file) == false)  
     * Cumulative sum of rejection counts for this shard.  
                + bytesLag
                && this.totalUploadTimeInMs == other.totalUploadTimeInMs  
            }  
    }
                && this.uploadBytesSucceeded == other.uploadBytesSucceeded
    }  
        ) {
            out.writeLong(consecutiveFailuresCount);
     */  
            }  
    }  
            .lastSuccessfulRemoteRefreshBytes(lastSuccessfulRemoteRefreshBytes)  
                uploadBytesFailed,
    }
     *
import java.util.Map;  
                && this.remoteRefreshClockTimeMs == other.remoteRefreshClockTimeMs
    /**  
    /**
    public long getInflightUploads() {  
                uploadBytesSucceeded,  
import java.util.Collections;
        public final double uploadBytesPerSecMovingAverage;
        logger = Loggers.getLogger(getClass(), shardId);  
    }
 */
                && this.rejectionCount == other.rejectionCount
            private long consecutiveFailuresCount = 0;
        public final long totalUploadsStarted;  
        @Override
                && this.uploadBytesStarted == other.uploadBytesStarted
            long uploadBytesFailed,  
 * compatible open source license.
            }
    long getRemoteRefreshClockTimeMs() {  
            out.writeDouble(uploadBytesMovingAverage);  
    /**  
        long currentClockTimeMs = System.currentTimeMillis();
                refreshTimeLagMs,
        Collection<String> segmentFiles,
    }
                this.uploadBytesPerSecMovingAverage = in.readDouble();
import java.util.HashSet;
        updateLocalRefreshTimeMs(currentTimeMsUsingSystemNanos());
            + this.remoteRefreshSeqNo;  
            public Builder directoryFileTransferTrackerStats(DirectoryFileTransferTracker.Stats stats) {
            return "Stats{"  
            .totalUploadsStarted(totalUploadsStarted.get())
        /**
    }  
    }
        Set<String> fileSet = new HashSet<>(segmentFiles);
     */
            double uploadTimeMovingAverage,  
                + refreshTimeLagMs
     * This method is also provided the collection of segment files which are the latest refresh local segment files.
    }
                + ", bytesLag="  
import org.opensearch.common.annotation.PublicApi;
    private volatile long bytesLag;
            + "currentLocalRefreshSeqNo="
            .forEach(file -> {
    private void updateLocalRefreshClockTimeMs(long localRefreshClockTimeMs) {
            private long uploadBytesSucceeded = 0;  
    }
                this.directoryFileTransferTrackerStats = stats;  
    }  
                    fileSize = fileSizeFunction.apply(file);
            public Builder uploadBytesStarted(long started) {
            .uploadBytesStarted(uploadBytesStarted.get())
        @Deprecated
             */
                && this.localRefreshNumber == other.localRefreshNumber  
        return localRefreshTimeMs;
            }
        public Stats(StreamInput in) throws IOException {
            long bytesLag,
            this.localRefreshClockTimeMs = localRefreshClockTimeMs;  
        public final ShardId shardId;  
        return Collections.unmodifiableMap(latestLocalFileNameLengthMap);  
            /**
    /**
            public Builder uploadBytesFailed(long failed) {  
    /**
     * @opensearch.api
                this.uploadBytesStarted = in.readLong();  
                + uploadTimeMovingAverage
                return this;
        super.incrementTotalUploadsSucceeded();  
        @Override
            private long remoteRefreshClockTimeMs = 0;  
            }  
                this.shardId = new ShardId(in);  
     */
    private volatile long remoteRefreshTimeMs;  
                + ", totalUploadsSucceeded="
        boolean isRemoteInSyncBeforeLocalRefresh = this.localRefreshTimeMs == this.remoteRefreshTimeMs;
            + " < "  
        latestLocalFileNameLengthMap.entrySet().removeIf(entry -> fileSet.contains(entry.getKey()) == false);
            public Builder lastSuccessfulRemoteRefreshBytes(long bytes) {
import java.util.Objects;
        }
        return uploadBytesStarted.get() - uploadBytesFailed.get() - uploadBytesSucceeded.get();  
                this.consecutiveFailuresCount = in.readLong();
            out.writeLong(totalUploadTimeInMs);
     *  
            }  
                && this.bytesLag == other.bytesLag
                this.totalUploadsStarted = started;
        }  
        private Stats(Builder builder) {
                this.consecutiveFailuresCount = count;
        public final DirectoryFileTransferTracker.Stats directoryFileTransferTrackerStats;
                this.rejectionCount = in.readLong();  
                + totalUploadTimeInMs  
        this.remoteRefreshSeqNo = remoteRefreshSeqNo;
            public Builder totalUploadTimeInMs(long time) {
            .localRefreshClockTimeMs(localRefreshClockTimeMs)
            this.bytesLag = bytesLag;
            }  
        }
     * @param segmentFiles     list of local refreshed segment files
            out.writeLong(totalUploadsStarted);  
        return bytesLag;
    public void incrementTotalUploadsFailed() {
                this.totalUploadsFailed = failed;
                this.uploadBytesFailed = failed;
            + remoteRefreshSeqNo  
 * Keeps track of remote refresh which happens in {@link org.opensearch.index.shard.RemoteStoreRefreshListener}. This consist of multiple critical metrics.
                try {
            out.writeOptionalWriteable(directoryFileTransferTrackerStats);
            out.writeLong(remoteRefreshClockTimeMs);
            .uploadBytesSucceeded(uploadBytesSucceeded.get())
     */  
            .rejectionCount(rejectionCount.get())
        assert refreshTimeMs >= this.remoteRefreshTimeMs : "newRemoteRefreshTimeMs="
    /**  
            public Builder shardId(ShardId shardId) {
         */
        public String toString() {
        public void writeTo(StreamOutput out) throws IOException {
        return localRefreshClockTimeMs;  
            + localRefreshTimeMs  
            if (obj == null || getClass() != obj.getClass()) return false;
        this.localRefreshSeqNo = localRefreshSeqNo;  
                return this;  
            DirectoryFileTransferTracker.Stats directoryFileTransferTrackerStats  
            long lastSuccessfulRemoteRefreshBytes,  
                remoteRefreshClockTimeMs,  
    }  
            .filter(file -> latestLocalFileNameLengthMap.containsKey(file) == false || latestLocalFileNameLengthMap.get(file) == 0)
     */  
    void incrementRejectionCount(String rejectionReason) {
        int movingAverageWindowSize
        computeRefreshSeqNoLag();
                return this;  
                this.bytesLag = in.readLong();  
            );
            this.directoryFileTransferTrackerStats = builder.directoryFileTransferTrackerStats;
        }
        return rejectionCountMap.get(rejectionReason).get();
        localRefreshTimeMs = currentTimeMs;
    public long getRefreshSeqNoLag() {
                shardId,
    public void updateLocalRefreshTimeAndSeqNo() {  
        }
                this.bytesLag = lag;
        return totalUploadsStarted.get() - totalUploadsFailed.get() - totalUploadsSucceeded.get();
     * The refresh time of the most recent refresh.
    }
            + " < "
            long uploadBytesStarted,
                + ", uploadBytesFailed="  
            try {
            this.uploadBytesStarted = uploadBytesStarted;
     * The refresh time(clock) of the most recent remote refresh.  
    }
 * SPDX-License-Identifier: Apache-2.0
     * The method is given a function as an argument which is used for determining the file size (length in bytes).
        }
 * @opensearch.api  
                long fileSize = 0;  
        this.remoteRefreshTimeMs = refreshTimeMs;
    // Visible for testing
            .stream()
                return this;
            this.lastSuccessfulRemoteRefreshBytes = lastSuccessfulRemoteRefreshBytes;
     */  
                return this;  
            public Builder localRefreshNumber(long number) {  
                return this;
        @Override
    public long getTimeMsLag() {  
            }
            public Builder uploadBytesMovingAverage(double average) {
                + ", uploadBytesPerSecMovingAverage="  
            this.uploadBytesSucceeded = builder.uploadBytesSucceeded;
            this.totalUploadsSucceeded = builder.totalUploadsSucceeded;
import org.opensearch.core.common.io.stream.Writeable;
                + localRefreshClockTimeMs
            .uploadBytesFailed(uploadBytesFailed.get())  
            public Builder bytesLag(long lag) {  
            long uploadBytesSucceeded,
            private long uploadBytesStarted = 0;
        computeRefreshSeqNoLag();
            }
        return refreshSeqNoLag;  
                && Double.compare(this.uploadTimeMovingAverage, other.uploadTimeMovingAverage) == 0
    }
                + totalUploadsFailed
                + ", localRefreshClockTimeMs="  
                this.totalUploadsSucceeded = succeeded;  
     */
                + localRefreshNumber
            this.shardId = builder.shardId;
            private long totalUploadsSucceeded = 0;  
        return remoteRefreshClockTimeMs;
                return this;  
    /**
            this.totalUploadTimeInMs = builder.totalUploadTimeInMs;
    private final Streak failures = new Streak();
            private double uploadBytesPerSecMovingAverage = 0;
                localRefreshClockTimeMs,
    }  
                lastSuccessfulRemoteRefreshBytes,  
         */
                rejectionCount,
import org.apache.logging.log4j.message.ParameterizedMessage;
                this.remoteRefreshClockTimeMs = time;  
                && this.refreshTimeLagMs == other.refreshTimeLagMs
    /**
     * This method also removes the stale segment files from the map that are not part of the input segment files.  
    /**  
        public final long remoteRefreshNumber;
            .totalUploadsSucceeded(totalUploadsSucceeded.get())
        public final long totalUploadTimeInMs;
    private final Set<String> latestUploadedFiles = ConcurrentCollections.newConcurrentSet();  
import java.util.Collection;  
     * This is the time of first local refresh after the last successful remote refresh. When the remote store is in  
            this.remoteRefreshNumber = builder.remoteRefreshNumber;
        this.localRefreshTimeMs = localRefreshTimeMs;
            }
            public Builder localRefreshClockTimeMs(long time) {  
        // time since the last refresh happened locally.
            + this.remoteRefreshTimeMs;  
                this.remoteRefreshNumber = number;  
            return Objects.hash(  
        public final long remoteRefreshClockTimeMs;
    public long getLocalRefreshTimeMs() {
        remoteRefreshStartTimeMs = currentTimeMs;  
                && Double.compare(this.uploadBytesPerSecMovingAverage, other.uploadBytesPerSecMovingAverage) == 0  
    public void incrementTotalUploadsSucceeded() {
            + this.localRefreshSeqNo;
        public int hashCode() {
            public Stats build() {
            this.uploadBytesMovingAverage = builder.uploadBytesMovingAverage;
     * Keeps track of rejection count with each rejection reason.
        // Remove keys from the fileSizeMap that do not exist in the latest segment files  
        }
        CheckedFunction<String, Long, IOException> fileSizeFunction  
        super(shardId, movingAverageWindowSize);
    long getRemoteRefreshTimeMs() {
                return this;
     */
import static org.opensearch.index.shard.RemoteStoreRefreshListener.EXCLUDE_FILES;
                + ", uploadTimeMovingAverage="
        this.directoryFileTransferTracker = directoryFileTransferTracker;  
            this.rejectionCount = builder.rejectionCount;
                && this.consecutiveFailuresCount == other.consecutiveFailuresCount  
    long getRemoteRefreshSeqNo() {  
    }
                this.rejectionCount = count;
            }  
        // triggered. After the segments have been uploaded and before the below code runs, the updateLocalRefreshTimeAndSeqNo  
import org.apache.logging.log4j.Logger;
        );  
                uploadBytesStarted,
            private long remoteRefreshNumber = 0;  
     *
            + refreshTimeMs  
     */  
        assert remoteRefreshSeqNo >= this.remoteRefreshSeqNo : "newRemoteRefreshSeqNo="
            this.localRefreshNumber = builder.localRefreshNumber;  
        incrementRejectionCount();  
        public final double uploadTimeMovingAverage;  
            this.shardId = shardId;
            long consecutiveFailuresCount,
import org.opensearch.core.common.io.stream.StreamOutput;  
            this.remoteRefreshStartTimeMs = localRefreshTimeMs;
            return 0;
            .totalUploadTimeInMs(totalUploadTimeInMillis.get())
    }
            out.writeLong(totalUploadsSucceeded);
            double uploadBytesMovingAverage,
     * The refresh time(clock) of the most recent refresh.  
            .refreshTimeLagMs(getTimeMsLag())
 *
                remoteRefreshNumber,  
                return this;
     */
                this.uploadBytesStarted = started;
}
    public void setLatestUploadedFiles(Set<String> files) {
    public Map<String, Long> updateLatestLocalFileNameLengthMap(
                latestLocalFileNameLengthMap.put(file, fileSize);  
    private volatile long localRefreshClockTimeMs;
            this.totalUploadsFailed = builder.totalUploadsFailed;  
            + "currentRemoteRefreshSeqNo="
            .uploadBytesMovingAverage(uploadBytesMovingAverageReference.get().getAverage())
        // Update the map
            this.uploadBytesStarted = builder.uploadBytesStarted;
        // When multiple refreshes have failed, there is a possibility that retry is ongoing while another refresh gets
        localRefreshClockTimeMs = currentClockTimeMs;
        failures.record(false);
                + ", rejectionCount="
            }
    public static long currentTimeMsUsingSystemNanos() {  
    long getRejectionCount(String rejectionReason) {  
                this.totalUploadsSucceeded = in.readLong();
            this.uploadBytesPerSecMovingAverage = builder.uploadBytesPerSecMovingAverage;  
                this.uploadBytesMovingAverage = in.readDouble();  
                + "shardId="
                this.remoteRefreshNumber = in.readLong();
            }
    private final Map<String, Long> latestLocalFileNameLengthMap = ConcurrentCollections.newConcurrentMap();  
            this.refreshTimeLagMs = builder.refreshTimeLagMs;
    /**
            this.localRefreshClockTimeMs = builder.localRefreshClockTimeMs;  
    private final AtomicLong rejectionCount = new AtomicLong();
                return this;
            .build();
        public final long totalUploadsSucceeded;
                this.uploadBytesMovingAverage = average;
            .totalUploadsFailed(totalUploadsFailed.get())  
            latestLocalFileNameLengthMap.keySet()
            this.uploadBytesFailed = uploadBytesFailed;  
                this.lastSuccessfulRemoteRefreshBytes = bytes;  
        public final long localRefreshClockTimeMs;
     * @return updated map of local segment files and filesize
     */
                + directoryFileTransferTrackerStats  
                + totalUploadsStarted
        remoteRefreshClockTimeMs = currentClockTimeMs;
            return;
                }
            out.writeLong(localRefreshClockTimeMs);
    private final Logger logger;
                + ", localRefreshNumber="  
    }  
                return this;
    }
        assert localRefreshTimeMs >= this.localRefreshTimeMs : "newLocalRefreshTimeMs="
        this.latestUploadedFiles.clear();  
        return rejectionCount.get();
            shardId.writeTo(out);  
package org.opensearch.index.remote;
            + " < "
import java.util.concurrent.TimeUnit;  
            + "currentLocalRefreshTimeMs="
            long totalUploadsSucceeded,
            out.writeLong(uploadBytesStarted);  
    /**  
            out.writeDouble(uploadBytesPerSecMovingAverage);
            public Builder totalUploadsStarted(long started) {
    /**
            out.writeLong(rejectionCount);  
            this.totalUploadsStarted = totalUploadsStarted;
            public Builder rejectionCount(long count) {
                + ", totalUploadsStarted="
        long currentTimeMs = currentTimeMsUsingSystemNanos();  
     * Holds count of consecutive failures until last success. Gets reset to zero if there is a success.
         * Use {@link Builder} instead.  
                this.totalUploadsFailed = in.readLong();
     * Keeps track of segment files and their size in bytes which are part of the most recent refresh.
     * Keeps the seq no lag computed so that we do not compute it for every request.
        public final long uploadBytesStarted;  
    public void updateRemoteRefreshSeqNo(long remoteRefreshSeqNo) {
            public Builder uploadBytesPerSecMovingAverage(double average) {  
    }
import org.opensearch.common.logging.Loggers;
    /**
            public Builder uploadTimeMovingAverage(double average) {
        return directoryFileTransferTracker;  
                directoryFileTransferTrackerStats  
                && this.remoteRefreshNumber == other.remoteRefreshNumber
            this.remoteRefreshNumber = remoteRefreshNumber;
     * last successful remote refresh state on successful remote refresh.
        rejectionCountMap.computeIfAbsent(rejectionReason, k -> new AtomicLong()).incrementAndGet();
    // Visible for testing  
     * The refresh time of the most recent remote refresh.
    private volatile long remoteRefreshSeqNo;
            out.writeLong(refreshTimeLagMs);  
        public boolean equals(Object obj) {  
         * Builder for the {@link Stats} class.  
            public Builder remoteRefreshClockTimeMs(long time) {
            }  
            .consecutiveFailuresCount(failures.length())
            private ShardId shardId = null;
         * Provides a fluent API for constructing a Stats object.
        logger.debug(
        if (isRemoteInSyncBeforeLocalRefresh) {  
    public long getRejectionCount() {
        refreshSeqNoLag = localRefreshSeqNo - remoteRefreshSeqNo;
     * Updates the latestLocalFileNameLengthMap by adding file name and it's size to the map.  
     * Every refresh is assigned a sequence number. This is the sequence number of the most recent refresh.
                totalUploadsFailed,
            this.localRefreshNumber = localRefreshNumber;  
    @Override
            this.consecutiveFailuresCount = builder.consecutiveFailuresCount;  
 */  
            "segmentFilesPostRefresh={} latestLocalFileNamesBeforeMapUpdate={}",  
    synchronized void updateLocalRefreshTimeMs(long localRefreshTimeMs) {
            this.directoryFileTransferTrackerStats = directoryFileTransferTrackerStats;
            private long localRefreshClockTimeMs = 0;
            .uploadTimeMovingAverage(uploadTimeMsMovingAverageReference.get().getAverage())  
 * this file be licensed under the Apache-2.0 license or a
    ) {
                this.shardId = shardId;
                + uploadBytesFailed
                bytesLag,
        this.remoteRefreshClockTimeMs = remoteRefreshClockTimeMs;
                return this;
    private volatile long lastSuccessfulRemoteRefreshBytes;  
                totalUploadTimeInMs,
                return this;
                + consecutiveFailuresCount
                + uploadBytesPerSecMovingAverage
    private volatile long remoteRefreshClockTimeMs;
        return failures.length();
            out.writeLong(lastSuccessfulRemoteRefreshBytes);
import org.opensearch.index.store.DirectoryFileTransferTracker;  
                return new Stats(this);  
        computeBytesLag();
            this.uploadBytesSucceeded = uploadBytesSucceeded;
            out.writeLong(localRefreshNumber);
    /** public only for testing **/
     * Sequence number of the most recent remote refresh.
    /**  
    private void computeBytesLag() {
                return this;
                localRefreshNumber,
            this.refreshTimeLagMs = refreshTimeLagMs;
import org.opensearch.core.common.io.stream.StreamInput;
        public final long lastSuccessfulRemoteRefreshBytes;
            private long totalUploadsFailed = 0;
         * This constructor will be deprecated starting in version 3.4.0.
                this.totalUploadTimeInMs = time;  
            .directoryFileTransferTrackerStats(directoryFileTransferTracker.stats())  
        super.incrementTotalUploadsFailed();  
        segmentFiles.stream()
                uploadTimeMovingAverage,  
                + lastSuccessfulRemoteRefreshBytes  
                    logger.warn(new ParameterizedMessage("Exception while reading the fileLength of file={}", file), e);
        return localRefreshSeqNo;
            }
     */
             * Creates a {@link Stats} object from the builder's current state.
            private long rejectionCount = 0;
     */
            this.uploadTimeMovingAverage = builder.uploadTimeMovingAverage;
    }
    int getConsecutiveFailureCount() {
                + ", totalUploadTimeInMs="
                + remoteRefreshNumber  
            private long bytesLag = 0;
    public long getLocalRefreshClockTimeMs() {
    }  
            } catch (IOException e) {  
                return this;  
        @Override
            this.totalUploadsStarted = builder.totalUploadsStarted;
            public Builder refreshTimeLagMs(long time) {
        // method is triggered, which will update the local localRefreshTimeMs. Now, the lag would basically become the
            .collect(Collectors.toSet());  
    /**
            this.uploadBytesFailed = builder.uploadBytesFailed;  
        public final long refreshTimeLagMs;  
     * Keeps track of the total bytes of segment files which were uploaded to remote store during last successful remote refresh
                + uploadBytesSucceeded  
            ShardId shardId,
                + ", uploadBytesMovingAverage="
        this.localRefreshClockTimeMs = localRefreshClockTimeMs;  
import java.util.stream.Collectors;
            }
                + ", refreshTimeLagMs="
                + remoteRefreshClockTimeMs  
            out.writeLong(bytesLag);  
            this.consecutiveFailuresCount = consecutiveFailuresCount;  
                this.localRefreshNumber = number;
                this.refreshTimeLagMs = time;
            }
        }
        Set<String> filesNotYetUploaded = latestLocalFileNameLengthMap.keySet()  
        this.latestUploadedFiles.addAll(files);
            this.lastSuccessfulRemoteRefreshBytes = builder.lastSuccessfulRemoteRefreshBytes;
                this.directoryFileTransferTrackerStats = in.readOptionalWriteable(DirectoryFileTransferTracker.Stats::new);
    }
                this.uploadBytesSucceeded = in.readLong();
        if (remoteRefreshTimeMs == localRefreshTimeMs || bytesLag == 0) {
        remoteRefreshTimeMs = currentTimeMs;
        assert localRefreshSeqNo >= this.localRefreshSeqNo : "newLocalRefreshSeqNo="
                + totalUploadsSucceeded  
/*  
    }  
                throw e;
            this.remoteRefreshClockTimeMs = remoteRefreshClockTimeMs;
            return this.shardId.toString().equals(other.shardId.toString())
                + ", uploadBytesSucceeded="
    public void updateRemoteRefreshClockTimeMs(long remoteRefreshClockTimeMs) {  
            public Builder uploadBytesSucceeded(long succeeded) {
    private volatile long localRefreshSeqNo;
                + uploadBytesMovingAverage
            .remoteRefreshNumber(remoteRefreshSeqNo)  
            long refreshTimeLagMs,
                return this;
        public final long bytesLag;
     */
            }
        return currentTimeMsUsingSystemNanos() - remoteRefreshStartTimeMs;
            }
            private DirectoryFileTransferTracker.Stats directoryFileTransferTrackerStats = null;  
            private double uploadBytesMovingAverage = 0;
    /**
    }
     * This contains the files from the last successful remote refresh and ongoing uploads. This gets reset to just the  
     */  
                this.uploadTimeMovingAverage = in.readDouble();
    }
            public Builder totalUploadsSucceeded(long succeeded) {
    }
             * @return A new Stats instance.  
import java.io.IOException;
            long localRefreshNumber,
                + shardId
            private long refreshTimeLagMs = 0;
        // Both the local refresh time and remote refresh time are set with current time to give consistent view of time lag when it arises.
                && this.totalUploadsStarted == other.totalUploadsStarted
                return this;
            double uploadBytesPerSecMovingAverage,
                return this;
     * Represents the tracker's state as seen in the stats API.
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            public Builder() {}
            }
    private volatile long remoteRefreshStartTimeMs = -1;  
            .localRefreshNumber(localRefreshSeqNo)
        if (latestLocalFileNameLengthMap.isEmpty()) {  
    public RemoteSegmentTransferTracker.Stats stats() {  
            }
        computeBytesLag();
    public RemoteSegmentTransferTracker(
                this.totalUploadsStarted = in.readLong();  
            this.uploadTimeMovingAverage = uploadTimeMovingAverage;
                + uploadBytesStarted
import org.opensearch.common.util.Streak;  
                consecutiveFailuresCount,
import org.opensearch.core.index.shard.ShardId;
            public Builder consecutiveFailuresCount(long count) {  
    public Map<String, Long> getLatestLocalFileNameLengthMap() {
            long totalUploadsFailed,  
     * sync with local refresh, this will be reset to -1.
                && this.localRefreshClockTimeMs == other.localRefreshClockTimeMs  
            + "currentRemoteRefreshTimeMs="
            this.bytesLag = builder.bytesLag;  
                return this;  
            private long uploadBytesFailed = 0;
import java.util.Set;
            if (this == obj) return true;
        return Collections.unmodifiableMap(latestLocalFileNameLengthMap);
        public final long localRefreshNumber;
                totalUploadsSucceeded,  
                + ", lastSuccessfulRemoteRefreshBytes="
        ShardId shardId,  
            segmentFiles,
            });
     * Keeps the bytes lag computed so that we do not compute it for every request.  
    }
            this.uploadBytesMovingAverage = uploadBytesMovingAverage;
            long remoteRefreshClockTimeMs,  
        this.bytesLag = filesNotYetUploaded.stream().map(latestLocalFileNameLengthMap::get).mapToLong(Long::longValue).sum();
        /**
            + " < "
 *
            public Builder remoteRefreshNumber(long number) {
