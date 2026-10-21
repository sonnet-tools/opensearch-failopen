                                uploadMetadata(localSegmentsPostRefresh, catalogSnapshot, checkpoint);
                // with remote trans-log integration.
        REMOTE_REFRESH_RETRY_MAX_INTERVAL_MILLIS
     */
        checkpointPublisher.publish(indexShard, checkpoint);
     * uploaded segment files onto remote store.
    ) {
     */
    private void resetBackOffDelayIterator() {
                || !(isInternalEngineIndexer(indexShard.getIndexer()) || indexShard.getIndexer() instanceof DataFormatAwareEngine);
                    CatalogSnapshot catalogSnapshot = catalogSnapshotRef.get().clone();
                segmentTracker.addUploadBytesSucceeded(fileSizeMap.get(file));
            }
            }
        // catalog's Lucene files — no race between catalog acquisition and IndexWriter re-capture.
    }
     * Returns if the current refresh has happened after a commit.
        return backoffDelayIterator.next();
            segmentTracker.incrementTotalUploadsSucceeded();
                sb.append(" primary=").append(indexShard.shardRouting.primary());
        // The above trimming makes the translog-size based periodic flush condition ineffective on remote-store
        RemoteSegmentMetadata remoteSegmentMetadata = null;
            .stream()
     *
    /**
        // Update the remote refresh time and refresh seq no
    }
        this.checkpointPublisher = checkpointPublisher;
    }
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
import org.opensearch.action.bulk.BackoffPolicy;
                    Collection<String> localSegmentsPostRefresh = catalogSnapshotRef.get().getFiles(true);
            localSegmentsSizeMap
import org.opensearch.common.concurrent.GatedCloseable;
        // Pass the serializer from the indexer. For DFA primary it delegates to the
                    // Clone to freeze lastCommitGeneration and other mutable state for the
    }
                segmentTracker.addUploadBytesFailed(fileSizeMap.get(file));
    private final RemoteSegmentTransferTracker segmentTracker;
    }
     * Checks if the underlying IndexShard instance is closed
            segmentTracker.updateUploadBytesPerSecMovingAverage((bytesUploaded * 1_000L) / Math.max(1, timeTakenInMS));
                    Map<String, Long> localSegmentsSizeMap = updateLocalSizeMapAndTracker(localSegmentsPostRefresh).entrySet()
            .collect(Collectors.toSet())
                // if a new segments_N file is present in local that is not uploaded to remote store yet, it
    private Map<String, Long> updateLocalSizeMapAndTracker(Collection<String> segmentFiles) {
        } catch (IOException e) {
                            String.format(
     * @param localSegmentsPostRefresh list of segment files present post refresh
import java.util.concurrent.TimeUnit;
            }
                || indexShard.shouldSeedRemoteStore());
            logger.error("Throwable thrown during isRemoteSegmentStoreInSync", throwable);
        // Start tracking total uploads started
        CatalogSnapshot catalogSnapshotCloned = catalogSnapshot.clone();
            segmentTracker.incrementTotalUploadsFailed();
     * Checks if all files present in local store are uploaded to remote store or part of excluded files.
     */
            return EXCLUDE_FILES.contains(file) || remoteDirectory.containsFile(file, getChecksumOfLocalFile(file));
        return localSegmentChecksumMap.get(file);
 * The OpenSearch Contributors require contributions made to
                        @Override
                // Track upload failure
     */
        // relaxing a collection gate alone is safe, but relaxing both violates HydrationIntegrity - so one shared
        beforeSegmentsSync();
     * Clears the stale files from the latest local segment checksum map.
        return ThreadPool.Names.REMOTE_REFRESH_RETRY;
 */
    private volatile long primaryTerm;
            StringBuilder sb = new StringBuilder("Skipped syncing segments with");
                initializeRemoteDirectoryOnTermUpdate();
            RemoteSegmentMetadata uploadedMetadata = this.remoteDirectory.init();
            // When the shouldSync is called the first time, then 1st condition on primary term is true. But after that
    private boolean skipUpload(String file) {
        }
    @Override
                String checksum = dfasd.calculateUploadChecksum(file);
                engineBacked.getEngine().clearUncommittedSegmentBytes();
    /**
            || isRemoteSegmentStoreInSync() == false;
                                logger.warn("Exception in post new segment upload actions", e);
        }
     *
    /**
                    evictUploadedChecksums(localSegmentsPostRefresh);
        // Publishing segment metadata and collecting stale segments both mutate state shared with any other live copy
                // Also trigger cleanup if the uploaded segments map exceeds the configured threshold,
     */
        boolean shouldSync = didRefresh // If the readers change, didRefresh is always true.
                                successful.set(true);
                                logger.debug("Metadata upload successful");
                    ) == false) {
            if (indexShard.getReplicationTracker() != null) {
     */
        logger.debug("onSuccessfulSegmentsSync lastRefreshedCheckpoint={} checkpoint={}", lastRefreshedCheckpoint, checkpoint);
            }
                // Track upload success
    /**
                    // call CatalogSnapshotManager.updateLastCommitInfo which mutates the live
        } else {
    /**
        RemoteSegmentTransferTracker segmentTracker,
        if (isReady == false) {
    private static final int REMOTE_REFRESH_RETRY_MAX_INTERVAL_MILLIS = 10_000;
                        public void onResponse(Void unused) {
        }
        // either can break a legitimate owner: an unfenced publish moves the reference set that collection prunes to,
        }
            // Following check is required to enable retry and make sure that we do not lose this refresh event
     *
    }
                logger.error("Exception while initialising RemoteSegmentStoreDirectory", e);
            logger.info(sb.toString());
     * Upload new segment files created as part of the last refresh to the remote segment store.
                // This is done to avoid delete post each refresh.
            filteredFiles,
                catalogSnapshotCloned,
    /**
     */
        // fail-open check would turn a single unreadable-fence event into exactly that unsafe combination. Returning
    private static final BackoffPolicy EXPONENTIAL_BACKOFF_POLICY = BackoffPolicy.exponentialEqualJitterBackoff(
        // of this shard, and neither is on the acknowledgement path that the fence CAS gates. A superseded copy doing
        try {
        this.storeDirectory = indexShard.store().directory();
        DataFormatAwareStoreDirectory dfasd = DataFormatAwareStoreDirectory.unwrap(storeDirectory);
    }
 * @opensearch.internal
        SegmentReplicationCheckpointPublisher checkpointPublisher,
     */
        return threshold != -1 && remoteDirectory.getSegmentsUploadedToRemoteStoreSize() > threshold;
    }
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
                        @Override
            .catalogSnapshotToRemoteMetadataSerializer();
            try {
        return (lastCommittedLocalSegmentFileName != null
    }
 * RefreshListener implementation to upload newly created segment files to the remote store
import java.util.stream.Collectors;
     *
            }
        Map<String, Long> localSegmentsSizeMap,
     * @param indexMetadata Index metadata containing crypto settings
            }
        if (indexShard.routingEntry().primary()) {
import org.apache.lucene.store.FilterDirectory;
    }
        }
        localSegmentChecksumMap = new HashMap<>();
        int threshold = indexShard.getRemoteStoreSettings().getUploadedSegmentsCleanupThreshold();
        // This also makes sure that retries are not scheduled for shards
        boolean isReady = indexShard.isStartedPrimary() || isLocalOrSnapshotRecoveryOrSeeding();
                remoteSegmentMetadata = this.remoteDirectory.init();
    @Override
import org.opensearch.common.unit.TimeValue;
                sb.append(" primaryMode=").append(indexShard.getReplicationTracker().isPrimaryMode());
import org.apache.lucene.store.IndexInput;
        // reader registered for this snapshot to produce bytes strictly consistent with the
import java.util.Set;
        return successful.get();
     * @param didRefresh true if the refresh opened a new reference
    private final SegmentReplicationCheckpointPublisher checkpointPublisher;
        return (indexShard.state() == IndexShardState.RECOVERING && indexShard.shardRouting.primary())
import java.util.HashMap;
import org.opensearch.threadpool.ThreadPool;
                    // unreadable-fence event, a perfectly correlated failure. A skipped cycle is retried on the next
                        public void onFailure(Exception e) {
     * @return true if the upload has to be skipped for the file.
        if (translogGeneration == null) {
        Map<String, Long> localFileSizeMap,
                try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = indexShard.getCatalogSnapshot()) {
    }
            // Exclude files that are already uploaded and the exclude files to come up with the list of files to be uploaded.
                    // Start the segments files upload with crypto
        ReplicationCheckpoint checkpoint
            return null;
            try (IndexInput indexInput = storeDirectory.openInput(file, IOContext.READONCE)) {
            // reference, but it is important to upload the zero state segments so that the restore does not break.
import org.opensearch.cluster.metadata.CryptoMetadata;
     */
        // Update latest uploaded segment files name in segment tracker
        // the threshold to flush at, so that the engine can flush once they breach it.
                    logger.warn("Exception while reading SegmentInfosSnapshot", e);
                DataFormatAwareStoreDirectory dfasd = DataFormatAwareStoreDirectory.unwrap(storeDirectory);
                "Exception while reading checksum of local segment file: {}, ignoring the exception and re-uploading the file",
            }
        Collection<String> localSegmentsPostRefresh,
                // to prevent unbounded memory growth when flushes do not happen.
        // ready state.
        }
    private final RemoteStoreUploader remoteStoreUploader;
        }
import org.apache.lucene.index.SegmentInfos;
            public void onFailure(String file) {
    ) {
        long refreshSeqNo = segmentTracker.getLocalRefreshSeqNo();
                sb.append(" engineType=").append(indexShard.getIndexer().getClass().getSimpleName());
     *  it uses files uploaded cache in RemoteDirector and it doesn't make a remote store call.
    }
            } catch (IOException e) {
            }
 */
    }
        segmentTracker.updateRemoteRefreshSeqNo(refreshSeqNo);
     * @return true if sync is needed
        long lastRefreshedCheckpoint,
            dfasd.evictStaleChecksums(currentSnapshotFiles);
     */
            );
    private boolean shardClosed() {
            // Here we update the tracker with latest remote uploaded files.
     * @param segmentFiles list of segment files that are part of the most recent local refresh.
        IndexShard indexShard,
    protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
            segmentUploadsCompletedListener,
import java.util.Iterator;
            || remoteDirectory.getSegmentsUploadedToRemoteStore().isEmpty()
    }
            private long uploadStartTime = 0;
                serializer
        if (indexShard.getIndexer() instanceof EngineBackedIndexer engineBacked) {
import java.util.Map;
     *
            logger.error("Exception in RemoteStoreRefreshListener.afterRefresh()", t);
    }
    }
        long refreshSeqNo,
            @Override
            } else {
                || indexShard.recoveryState().getRecoverySource().getType() == RecoverySource.Type.SNAPSHOT
    private void onSuccessfulSegmentsSync(
            successful = true;
     * to either setting is picked up by the next successful segments sync.
        Translog.TranslogGeneration translogGeneration = indexShard.getIndexer().translogManager().getTranslogGeneration();
        if (shouldSync || skipPrimaryTermCheck) {
        indexShard.getIndexer().translogManager().setMinSeqNoToKeep(lastRefreshedCheckpoint + 1);
     */
            // Below check ensures that if there is commit, then that gets picked up by both 1st and 2nd shouldSync call.
    }
     @return false if retry is needed
        ReplicationCheckpoint replicationCheckpoint
     *
                        throw new IllegalStateException(
import org.apache.lucene.store.Directory;
    private boolean isRefreshAfterCommitSafe() {
        }
     */
     * The initial retry interval at which the retry job gets scheduled after a failure.
     * Different from IndexShard#isRemoteSegmentStoreInSync as
    boolean isRemoteSegmentStoreInSync() {
        segmentTracker.updateRemoteRefreshClockTimeMs(refreshClockTimeMs);
                        );
        }
            if (indexShard.state() != null) {
                translogFileGeneration,
     */
                    }, latch);
    );
                // trigger a flush after the operator turned the condition off
                                onSuccessfulSegmentsSync(
                segmentTracker.addUploadBytesStarted(fileSizeMap.get(file));
        long refreshTimeMs,
                                Locale.ROOT,
                            )
     * Whether to upload a file or not depending on whether file is in excluded list or has been already uploaded.
     * @param fileSizeMap updated map of current snapshot of local segments to their sizes
        // publication and fails OPEN (an unreadable fence proceeds - the worst case is an orphan, the pre-existing
                                // Start metadata file upload
import org.apache.lucene.store.IOContext;
                                // as part of exponential back-off retry logic. This should not affect durability of the indexed data
    }
    private final RemoteStoreSettings remoteStoreSettings;
            .filter(file -> !localSegmentsPostRefresh.contains(file))
import org.opensearch.index.seqno.SequenceNumbers;
        return isReady;
     * On primary term update, we (re)initialise the remote segment directory to reflect the latest metadata file that
                    // Collection fails CLOSED, on its own gate, unlike the publication gate at the top of this sync
            );
        catalogSnapshotCloned.setUserData(userData, false);
import java.util.function.Function;
     *
        };
            }
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
    protected Logger getLogger() {
        boolean successful;
     * Exponential back off policy with max retry interval.
                    // sit on separate checks: FenceSegmentFlow.tla measures that relaxing the publication gate alone
        logger.debug("syncSegments runStatus={}", successful.get());
                file
/**
    boolean isLowPriorityUpload() {
            return isRefreshAfterCommit();
                    Collection<String> localSegmentsPostRefresh = catalogSnapshot.getFiles(true);
        long refreshTimeMs = segmentTracker.getLocalRefreshTimeMs(), refreshClockTimeMs = segmentTracker.getLocalRefreshClockTimeMs();
     * Evicts pre-computed checksums for files no longer in the current catalog snapshot.
            this.primaryTerm = indexShard.getOperationPrimaryTerm();
    private void initializeRemoteDirectoryOnTermUpdate() throws IOException {
     */
        long refreshClockTimeMs,
        // refresh not occurring until write happens.
     * Uploads new segment files to the remote store.
        // with failed syncSegments invocation after they are closed
    /**
        }
                                // with remote trans-log integration.
        return false;
                    // Capture replication checkpoint before uploading the segments as upload can take some time and checkpoint can
            // The third condition exists for uploading the zero state segments where the refresh has not changed the reader
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
     * Creates an {@link UploadListener} containing the stats population logic which would be triggered before and after segment upload events
    }
     * current by cluster settings update consumers. Resolving on every publication rather than caching means an update
            return indexShard.state() != IndexShardState.STARTED
                sb.append(" recoverySourceType=").append(indexShard.recoveryState().getRecoverySource().getType());
     * @return updated map of local segment files and filesize
    @Override
            .forEach(localSegmentChecksumMap::remove);
        );
                                );
        } else {
import org.opensearch.index.engine.EngineException;
    /**
     * Resets the backoff delay iterator so that the next set of failures starts with the base delay and goes upto max delay.
        } catch (Exception e) {
                    throw new IllegalStateException("DataFormatAwareStoreDirectory expected when pluggable data format is enabled");
    private void evictUploadedChecksums(Collection<String> currentSnapshotFiles) {
    private boolean isReadyForUpload() {
     * @param localSegmentsSizeMap map of segment file names to their sizes
import org.opensearch.index.translog.Translog;
    public static final Set<String> EXCLUDE_FILES = Set.of("write.lock");
                localSegmentChecksumMap.put(file, checksum);
import org.opensearch.index.engine.EngineBackedIndexer;
     * @param localSegmentsPostRefresh collection of segment files present after refresh
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    /**
        RemoteStoreSettings remoteStoreSettings
        CryptoMetadata cryptoMetadata
     *
import static org.opensearch.index.seqno.SequenceNumbers.LOCAL_CHECKPOINT_KEY;
                                checkpoint.getPrimaryTerm(),
     * @return true if this refresh has happened on account of a commit. If otherwise or exception, returns false.
            segmentTracker.updateUploadBytesMovingAverage(bytesUploaded);
                    // snapshot's lastCommitGeneration — causing the retry path (which runs
            // in the remote store.
            logger.info("Shard is already closed. Not attempting sync to remote store");
                        }
    }
                segmentTracker.addUploadTimeInMillis(Math.max(1, System.currentTimeMillis() - uploadStartTime));
    }
            || isRefreshAfterCommitSafe()
        String lastCommittedLocalSegmentFileName = SegmentInfos.getLastCommitSegmentsFileName(storeDirectory);
import org.opensearch.index.IndexSettings;
    protected TimeValue getNextRetryInterval() {
                sb.append(" indexShardState=").append(indexShard.state());
            public void beforeUpload(String file) {
            }
            }
    private final Directory storeDirectory;
        org.opensearch.common.CheckedFunction<CatalogSnapshot, byte[], IOException> serializer = indexShard
                // discard whatever was published while the condition was on, otherwise it stays armed and can still
     */
            : remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize().getBytes();
                    } else {
                                indexShard.getOperationPrimaryTerm()
                    // move.
                logger.warn("Exception while uploading new segments to the remote segment store", e);
        // If there are failures in uploading segments, then we should retry as search idle can lead to
                        TimeUnit.MILLISECONDS
                        remoteDirectory.deleteStaleSegmentsAsync(indexShard.getRemoteStoreSettings().getMinRemoteSegmentMetadataFiles());
package org.opensearch.index.shard;
                    uploadNewSegments(localSegmentsPostRefresh, localSegmentsSizeMap, segmentUploadsCompletedListener, cryptoMetadata);
            long timeTakenInMS = TimeValue.nsecToMSec(System.nanoTime() - startTimeInNS);
                String checksum = Long.toString(CodecUtil.retrieveChecksum(indexInput));
        // This is required in case of remote migration seeding/snapshots/shrink/ split/clone where we need to durable persist
        // so the owner's own collection then deletes files it is still hydrating. Both are therefore gated on this copy
                        }
                }
    @Override
        }
    private void clearStaleFilesFromLocalSegmentChecksumMap(Collection<String> localSegmentsPostRefresh) {
    @Override
     * @param skipPrimaryTermCheck consider change in primary term or not for should sync
     *  Doesn't throw an exception on store getting closed as store will be open
        segmentTracker.updateRemoteRefreshTimeMs(refreshTimeMs);
            }
    }
            logger.trace("primaryTerm update from={} to={}", primaryTerm, indexShard.getOperationPrimaryTerm());
     * This lives here, at the publication site, because it is the only place holding both scopes: the shard's
                                    lastRefreshedCheckpoint,
            } catch (IOException e) {
        CatalogSnapshot catalogSnapshot,
        try {
        return successful;
     * {@link org.opensearch.index.IndexSettings} and the node's {@link RemoteStoreSettings}, whose values are kept
import java.util.concurrent.atomic.AtomicBoolean;
            if (indexShard.indexSettings().isPluggableDataFormatEnabled()) {
     * In an exponential back off setup, the maximum retry interval after the retry interval increases exponentially.
        return true;
                if (isRefreshAfterCommit() || uploadedSegmentsMapExceedsThreshold()) {
            try {
                                    refreshSeqNo,
    ) {
     * Once uploaded, the checksum is stored in remote metadata and no longer needed in the local cache.
    }
            if (remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled()) {
import org.apache.lucene.codecs.CodecUtil;
    protected boolean isRetryEnabled() {
        return logger;
        }
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = indexShard.getCatalogSnapshot()) {
        this.remoteDirectory = (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory())
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
                    CountDownLatch latch = new CountDownLatch(1);
     * Resolves the uncommitted segment bytes to flush at: the per-index
                            logger.warn("Exception while uploading new segments to the remote segment store", e);
    }
        } else {
                }
        }
            return catalogSnapshotRef.get().getFiles(true).stream().allMatch(this::skipUpload);
 * compatible open source license.
        updateFinalStatusInSegmentTracker(successful.get(), bytesBeforeUpload, startTimeInNS);
    private final IndexShard indexShard;
public final class RemoteStoreRefreshListener extends ReleasableRetryableRefreshListener {
        backoffDelayIterator = EXPONENTIAL_BACKOFF_POLICY.iterator();
        return CryptoMetadata.fromIndexSettings(indexMetadata.getSettings());
            @Override
            throw new UnsupportedOperationException("Encountered null TranslogGeneration while uploading metadata to remote segment store");
            return true;
                                "primaryTerm mismatch during segments upload to remote store [%s] != [%s]",
                    // commit-refresh; a wrongly permitted delete is not recoverable.
                    updateLocalSizeMapAndTracker(localSegmentsPostRefresh);
            long bytesUploaded = segmentTracker.getUploadBytesSucceeded() - bytesBeforeUpload;
    private void beforeSegmentsSync() {
     * This checks for readiness of the index shard and primary mode. This has separated from shouldSync since we use the
        Function<Map<String, Long>, UploadListener> uploadListenerFunction = (Map<String, Long> sizeMap) -> createUploadListener(
    /**
     * @return true iff the shard is a started with primary mode true or it is local or snapshot recovery.
                    final ReplicationCheckpoint checkpoint = indexShard.computeReplicationCheckpoint(catalogSnapshot);
        // shards, hence publish the size of segment bytes not yet referenced by the last commit point, together with
                                    localSegmentsSizeMap,
            segmentTracker.updateUploadTimeMovingAverage(timeTakenInMS);
/*
     */
                logger.error("Exception in runAfterRefreshExactlyOnce() method", t);
                    }
        Map<String, String> userData = new HashMap<>(catalogSnapshotCloned.getUserData());
        // initializing primary term with the primary term of latest metadata in remote store.
        // Publishing the new checkpoint which is used for remote store + segrep indexes
                return checksum;
     * This checks if there is a sync required to remote.
            ? indexSettings.getFlushOnUncommittedSegmentsThresholdSize().getBytes()
            // During failover, the uploaded metadata would have names of files that have been uploaded to remote store.
                    // Create a map of file name to size and update the refresh segment tracker
                    }
    private long flushOnUncommittedSegmentsThresholdBytes() {
        if (shouldSync(didRefresh, false)) {
        this.remoteStoreSettings = remoteStoreSettings;
                        remoteStoreSettings.getClusterRemoteSegmentTransferTimeout().millis(),
        localSegmentChecksumMap.keySet()
        if (uploadStatus) {
     */
            // we update the primary term and the same condition would not evaluate to true again in syncSegments.
        } catch (Throwable t) {
     * Updates map of file name to size of the input segment files in the segment tracker. Uses {@code storeDirectory.fileLength(file)} to get the size.
        return segmentTracker.updateLatestLocalFileNameLengthMap(segmentFiles, storeDirectory::fileLength);
    /**
                // as part of exponential back-off retry logic. This should not affect durability of the indexed data
                segmentTracker.updateLocalRefreshTimeAndSeqNo();
import org.opensearch.action.LatchedActionListener;
    protected String getRetryThreadPoolName() {
            }
    void uploadMetadata(
            // if following condition does not exist. The segments created as part of translog replay will not be present
        // FenceSegmentFlow.tla measures why the separation matters: relaxing the publication gate alone is safe and
                                logger.debug("New segments upload successful");
        return new UploadListener() {
                                // At this point since we have uploaded new segments, segment infos and segment metadata file,
                    ActionListener<Void> segmentUploadsCompletedListener = new LatchedActionListener<>(new ActionListener<>() {
                localSegmentsPostRefresh,
        segmentTracker.incrementTotalUploadsStarted();
        }
                segmentTracker.addToLatestUploadedFiles(file);
    /**
                // is considered as a first refresh post commit. A cleanup of stale commit files is triggered.
        // read.
            successful = syncSegments();
import org.opensearch.common.logging.Loggers;
     * @return true if the method runs successfully.
    ) throws IOException {
                    if (latch.await(
                    if (indexShard.indexSettings().isRemoteStoreFencingEnabled()
            public void onSuccess(String file) {
        } catch (Throwable throwable) {
     * returned value of this method for scheduling retries in syncSegments method.
        IndexMetadata indexMetadata = indexShard.indexSettings().getIndexMetadata();
            uploadListenerFunction,
        segmentTracker.setLatestUploadedFiles(localFileSizeMap.keySet());
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            } catch (Throwable t) {
                                // We don't want to fail refresh if upload of new segments fails. The missed segments will be re-tried
        remoteStoreUploader.uploadSegments(
                        logger.info("Skipping stale segment cleanup: remote store fence ownership is superseded or unreadable");
        if (dfasd != null) {
    /**
    }
     * Extracts CryptoMetadata if configured.
    private void updateFinalStatusInSegmentTracker(boolean uploadStatus, long bytesBeforeUpload, long startTimeInNS) {
        }
     *
                            try {
        ActionListener<Void> segmentUploadsCompletedListener,
        }
        CryptoMetadata cryptoMetadata = resolveCryptoMetadata(indexMetadata);
     * @param didRefresh             if the readers changed.
        updateRemoteRefreshTimeAndSeqNo(refreshTimeMs, refreshClockTimeMs, refreshSeqNo);
        Collection<String> localSegmentsPostRefresh,
import java.io.IOException;
            try {
    private volatile Iterator<TimeValue> backoffDelayIterator;
        Collection<String> filteredFiles = localSegmentsPostRefresh.stream().filter(file -> !skipUpload(file)).collect(Collectors.toList());
    @Override
    private final RemoteSegmentStoreDirectory remoteDirectory;
    /**
            && (indexShard.recoveryState().getRecoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS
        return false;
     * @param cryptoMetadata  CryptoMetadata for index-level encryption
                    long lastRefreshedCheckpoint = indexShard.getIndexer().lastRefreshedCheckpoint();
        return isLocalOrSnapshotRecoveryOrSeeding();
import org.opensearch.cluster.routing.RecoverySource;
    }
        logger = Loggers.getLogger(getClass(), indexShard.shardId());
                        throw new SegmentUploadFailedException("Timeout while waiting for remote segment transfer to complete");
     * {@code index.remote_store.flush_on_uncommitted_segments.threshold_size} if the index sets it explicitly,
            && indexShard.recoveryState() != null
                                    refreshClockTimeMs,
     * @return true if it is closed, false otherwise
    /*
        if (!localSegmentChecksumMap.containsKey(file)) {
        userData.put(LOCAL_CHECKPOINT_KEY, String.valueOf(maxSeqNo));
        // still owning the fence - but on SEPARATE checks with OPPOSITE failure directions. This one gates the
                if (dfasd == null) {
    private boolean shouldSync(boolean didRefresh, boolean skipPrimaryTermCheck) {
import java.util.Locale;
            logger.info("Exception occurred in isRefreshAfterCommitSafe", e);
     *
    private UploadListener createUploadListener(Map<String, Long> fileSizeMap) {
    @Override
                try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = indexShard.getCatalogSnapshot()) {
import org.apache.logging.log4j.Logger;
    /**
        long bytesBeforeUpload = segmentTracker.getUploadBytesSucceeded(), startTimeInNS = System.nanoTime();
        return false;
     * has been uploaded to remote store successfully. This method also updates the segment tracker about the latest
        }
}
        final long maxSeqNo = indexShard.getIndexer().currentOngoingRefreshCheckpoint();
            return shouldSync;
        remoteStoreUploader = new RemoteStoreUploaderService(indexShard, storeDirectory, remoteDirectory);
            return false;
    }
                    // than the one used for the initial segment file upload.
     *
    protected void runAfterRefreshExactlyOnce(boolean didRefresh) {
            @Override
    /**
        this.segmentTracker = segmentTracker;
        // In this case when the primary mode is false, we need to upload segments to Remote Store
    private boolean syncSegments() {
    private boolean isRefreshAfterCommit() throws IOException {
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (isReadyForUpload() == false) {
        return indexSettings.isFlushOnUncommittedSegmentsThresholdSizeExplicit()
                indexShard.getNodeId(),
                    // HydrationIntegrity - and a single shared fail-open check would relax both on one
                replicationCheckpoint,
     * @return true iff all the local files are uploaded to remote store.
    private void uploadNewSegments(
        final IndexSettings indexSettings = indexShard.indexSettings();
    }
        // true rather than requesting a retry is deliberate: a superseded copy will never regain ownership, so
                    }
    private static final int REMOTE_REFRESH_RETRY_BASE_INTERVAL_MILLIS = 1_000;
            if (indexShard.getIndexerOrNull() != null) {
                            }
                                    checkpoint
                            } catch (Exception e) {
import java.util.concurrent.CountDownLatch;
            // Accept DataFormatAwareEngine alongside InternalEngine (DFA primaries need the retry path).
        this.primaryTerm = remoteSegmentMetadata != null ? remoteSegmentMetadata.getPrimaryTerm() : INVALID_PRIMARY_TERM;
        if (indexShard.indexSettings().isRemoteStoreFencingEnabled() && indexShard.isRemoteStoreFenceSuperseded()) {
    public void beforeRefresh() throws IOException {}
     * <p>
import org.opensearch.common.util.UploadListener;
                }
 * this file be licensed under the Apache-2.0 license or a
                uploadStartTime = System.currentTimeMillis();
                    // duration of this upload cycle. Without cloning, a concurrent flush can
        resetBackOffDelayIterator();
        // retrying would spin. The setting is checked first so that an unfenced index never pays for the ownership
        }
                                    refreshTimeMs,
                segmentTracker.addUploadTimeInMillis(Math.max(1, System.currentTimeMillis() - uploadStartTime));
     * Updates the last refresh time and refresh seq no which is seen by remote store.
    private void updateRemoteRefreshTimeAndSeqNo(long refreshTimeMs, long refreshClockTimeMs, long refreshSeqNo) {
import org.opensearch.indices.RemoteStoreSettings;
    /**
    boolean isLocalOrSnapshotRecoveryOrSeeding() {
        if (shouldSync(didRefresh, true) && isReadyForUpload()) {
                }
        if (this.primaryTerm != indexShard.getOperationPrimaryTerm()) {
    private String getChecksumOfLocalFile(String file) throws IOException {
 *
    }
            isLowPriorityUpload(),
        resetBackOffDelayIterator();
     */
                                // along with marking minSeqNoToKeep, upload has succeeded completely.
    }
     */
            long translogFileGeneration = translogGeneration.translogFileGeneration;
     *
     * This method also uploads remote_segments_metadata file which contains metadata of each segment file uploaded.
        this.indexShard = indexShard;
        if (indexMetadata == null) {
                // Start tracking the upload bytes started
                localSegmentChecksumMap.put(file, checksum);
    /**
                    // is safe and relaxing a collection gate alone is safe, but relaxing BOTH violates
import org.opensearch.index.engine.DataFormatAwareEngine;
    private final Map<String, String> localSegmentChecksumMap;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.action.ActionListener;
        // Ignore syncing segments if the underlying shard is closed
        try {
        // Set the minimum sequence number for keeping translog
            remoteDirectory.uploadMetadata(
import org.opensearch.cluster.metadata.IndexMetadata;
import java.util.Collection;
    private final Logger logger;
            if (uploadedMetadata != null) {
    /**
        // from isReadyForUpload to schedule refresh retries as the index shard or the primary mode are not in complete
        // We have 2 separate methods to check if sync needs to be done or not. This is required since we use the return boolean
                storeDirectory,
import org.opensearch.index.engine.InternalEngine;
                } catch (EngineException e) {
        final AtomicBoolean successful = new AtomicBoolean(false);
        // harmless case); the stale-segment collection below has its own fail-CLOSED gate, as do the translog trims.
            .getDelegate()).getDelegate();
        return indexer instanceof EngineBackedIndexer engineBacked && engineBacked.getEngine() instanceof InternalEngine;
                engineBacked.getEngine().updateUncommittedSegmentBytes(localFileSizeMap, flushOnUncommittedSegmentsThresholdBytes());
                    // asynchronously) to serialize segment metadata with a different generation
        REMOTE_REFRESH_RETRY_BASE_INTERVAL_MILLIS,
    /**
                        && indexShard.isRemoteStoreFenceSupersededFailingClosed()) {
        );
                        .stream()
    }
    private CryptoMetadata resolveCryptoMetadata(IndexMetadata indexMetadata) {
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            logger.info("Skipping segment upload and cleanup: a higher primary term has taken the remote store fence");
     * @return CryptoMetadata if encryption is configured, null otherwise
    private static final int INVALID_PRIMARY_TERM = -1;
                    // (which fails open - an unreadable fence there costs at most an orphan). The two directions must
     *
        }
            logger.error(
        super(indexShard.getThreadPool());
        // if no metadata is present, this value will be initialized with -1.
                                clearStaleFilesFromLocalSegmentChecksumMap(localSegmentsPostRefresh);
                segmentTracker.setLatestUploadedFiles(uploadedMetadata.getMetadata().keySet());
            if (indexShard.recoveryState() != null) {
     * otherwise the cluster default {@code cluster.remote_store.flush_on_uncommitted_segments.threshold_size}.
 *
    }
            // When primary shard is restored from remote store, the recovery happens first followed by changing
            && !remoteDirectory.containsFile(lastCommittedLocalSegmentFileName, getChecksumOfLocalFile(lastCommittedLocalSegmentFileName)));
        if (shardClosed()) {
            cryptoMetadata
    private static boolean isInternalEngineIndexer(org.opensearch.index.engine.exec.Indexer indexer) {
    public RemoteStoreRefreshListener(
     * @param segmentUploadsCompletedListener listener to be notified when upload completes
        // CatalogSnapshotManager → LuceneCommitter.serializeToCommitFormat which uses the
    }
                    if (checkpoint.getPrimaryTerm() != indexShard.getOperationPrimaryTerm()) {
    private boolean uploadedSegmentsMapExceedsThreshold() {
    }
        return this.primaryTerm != indexShard.getOperationPrimaryTerm();
                // We don't want to fail refresh if upload of new segments fails. The missed segments will be re-tried
            // primaryMode to true. Due to this, the refresh that is triggered post replay of translog will not go through
     */
        // all segments to remote before completing the recovery to ensure durability.
     * @param file that needs to be uploaded.
     */
        // Reset the backoffDelayIterator for the future failures
            }
        return indexShard.state() == IndexShardState.CLOSED;
            localSegmentsSizeMap,
        // Extract crypto metadata once at start of sync
