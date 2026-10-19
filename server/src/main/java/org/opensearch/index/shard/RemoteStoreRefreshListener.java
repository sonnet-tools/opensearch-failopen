 * RefreshListener implementation to upload newly created segment files to the remote store  
    private boolean isRefreshAfterCommitSafe() {
        if (dfasd != null) {
import org.opensearch.index.engine.EngineBackedIndexer;
        Map<String, Long> localSegmentsSizeMap,  
     *
            public void onFailure(String file) {  
        RemoteSegmentMetadata remoteSegmentMetadata = null;
        // all segments to remote before completing the recovery to ensure durability.  
                        remoteStoreSettings.getClusterRemoteSegmentTransferTimeout().millis(),  
        // read.
            // When primary shard is restored from remote store, the recovery happens first followed by changing
        if (shouldSync || skipPrimaryTermCheck) {  
     */  
                    Map<String, Long> localSegmentsSizeMap = updateLocalSizeMapAndTracker(localSegmentsPostRefresh).entrySet()
                sb.append(" primary=").append(indexShard.shardRouting.primary());
import org.apache.lucene.index.SegmentInfos;  
    /**  
     * @return true if sync is needed
        super(indexShard.getThreadPool());
     @return false if retry is needed
     * Creates an {@link UploadListener} containing the stats population logic which would be triggered before and after segment upload events  
        return new UploadListener() {
            return null;
                    }, latch);
        if (uploadStatus) {
            : remoteStoreSettings.getFlushOnUncommittedSegmentsThresholdSize().getBytes();
            remoteDirectory.uploadMetadata(
        // catalog's Lucene files — no race between catalog acquisition and IndexWriter re-capture.
    }
        // If there are failures in uploading segments, then we should retry as search idle can lead to  
        return localSegmentChecksumMap.get(file);
    protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
    /**
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            // we update the primary term and the same condition would not evaluate to true again in syncSegments.
     * This checks for readiness of the index shard and primary mode. This has separated from shouldSync since we use the  
        return successful.get();  
        }
import java.util.HashMap;
        // initializing primary term with the primary term of latest metadata in remote store.  
    }
        }
        logger = Loggers.getLogger(getClass(), indexShard.shardId());  
            long timeTakenInMS = TimeValue.nsecToMSec(System.nanoTime() - startTimeInNS);  
    }  
     * @param localSegmentsPostRefresh list of segment files present post refresh
            segmentTracker.updateUploadTimeMovingAverage(timeTakenInMS);
                // This is done to avoid delete post each refresh.
    boolean isLocalOrSnapshotRecoveryOrSeeding() {  
import org.opensearch.index.IndexSettings;  
    /**
        RemoteSegmentTransferTracker segmentTracker,
            || isRefreshAfterCommitSafe()
        ReplicationCheckpoint replicationCheckpoint
    );
     * {@link org.opensearch.index.IndexSettings} and the node's {@link RemoteStoreSettings}, whose values are kept  
    private static final int REMOTE_REFRESH_RETRY_MAX_INTERVAL_MILLIS = 10_000;
        return false;  
        // of this shard, and neither is on the acknowledgement path that the fence CAS gates. A superseded copy doing
    /**
            }
 * compatible open source license.
            // in the remote store.
        // harmless case); the stale-segment collection below has its own fail-CLOSED gate, as do the translog trims.
    /**
 */  
                            logger.warn("Exception while uploading new segments to the remote segment store", e);
        CatalogSnapshot catalogSnapshotCloned = catalogSnapshot.clone();
        return (indexShard.state() == IndexShardState.RECOVERING && indexShard.shardRouting.primary())
            cryptoMetadata  
        } catch (IOException e) {  
    }
        return isLocalOrSnapshotRecoveryOrSeeding();
            }
                        public void onResponse(Void unused) {
        updateRemoteRefreshTimeAndSeqNo(refreshTimeMs, refreshClockTimeMs, refreshSeqNo);
    private long flushOnUncommittedSegmentsThresholdBytes() {
    /**  
                sb.append(" primaryMode=").append(indexShard.getReplicationTracker().isPrimaryMode());
        }
            private long uploadStartTime = 0;  
    private final Logger logger;  
        return isReady;  
            logger.info("Shard is already closed. Not attempting sync to remote store");  
    private boolean isReadyForUpload() {
            return true;
    private static boolean isInternalEngineIndexer(org.opensearch.index.engine.exec.Indexer indexer) {
                                    lastRefreshedCheckpoint,  
     *
                segmentTracker.addUploadBytesSucceeded(fileSizeMap.get(file));  
     *
    private boolean skipUpload(String file) {
        remoteStoreUploader.uploadSegments(  
     */
                // We don't want to fail refresh if upload of new segments fails. The missed segments will be re-tried  
            try {  
            // When the shouldSync is called the first time, then 1st condition on primary term is true. But after that
        SegmentReplicationCheckpointPublisher checkpointPublisher,
                            } catch (Exception e) {
        return CryptoMetadata.fromIndexSettings(indexMetadata.getSettings());
    @Override
        }
                    if (latch.await(
        // ready state.
                    // (which fails open - an unreadable fence there costs at most an orphan). The two directions must  
                        public void onFailure(Exception e) {
                                clearStaleFilesFromLocalSegmentChecksumMap(localSegmentsPostRefresh);
        long refreshSeqNo,  
                remoteSegmentMetadata = this.remoteDirectory.init();
        userData.put(LOCAL_CHECKPOINT_KEY, String.valueOf(maxSeqNo));  
                        }
     */  
    }
        return successful;  
                    // call CatalogSnapshotManager.updateLastCommitInfo which mutates the live
        logger.debug("syncSegments runStatus={}", successful.get());
        return threshold != -1 && remoteDirectory.getSegmentsUploadedToRemoteStoreSize() > threshold;
        return this.primaryTerm != indexShard.getOperationPrimaryTerm();  
            localSegmentsSizeMap,
                    // sit on separate checks: FenceSegmentFlow.tla measures that relaxing the publication gate alone
    boolean isRemoteSegmentStoreInSync() {
        // refresh not occurring until write happens.
                    updateLocalSizeMapAndTracker(localSegmentsPostRefresh);
    }
            .catalogSnapshotToRemoteMetadataSerializer();  
            return catalogSnapshotRef.get().getFiles(true).stream().allMatch(this::skipUpload);  
                "Exception while reading checksum of local segment file: {}, ignoring the exception and re-uploading the file",
    private boolean uploadedSegmentsMapExceedsThreshold() {
    private final RemoteSegmentTransferTracker segmentTracker;  
    /**
                        }  
    }  
            localSegmentsSizeMap  
            && !remoteDirectory.containsFile(lastCommittedLocalSegmentFileName, getChecksumOfLocalFile(lastCommittedLocalSegmentFileName)));
        // the threshold to flush at, so that the engine can flush once they breach it.  
     * @return true if the method runs successfully.
            segmentUploadsCompletedListener,  
        );
     * current by cluster settings update consumers. Resolving on every publication rather than caching means an update
                logger.warn("Exception while uploading new segments to the remote segment store", e);  
                                    refreshTimeMs,  
                replicationCheckpoint,  
        return segmentTracker.updateLatestLocalFileNameLengthMap(segmentFiles, storeDirectory::fileLength);  
     */  
        return indexShard.state() == IndexShardState.CLOSED;
        // Extract crypto metadata once at start of sync
                                // along with marking minSeqNoToKeep, upload has succeeded completely.
        final IndexSettings indexSettings = indexShard.indexSettings();
    /**
    void uploadMetadata(
                translogFileGeneration,
        // fail-open check would turn a single unreadable-fence event into exactly that unsafe combination. Returning
            }  
    private void evictUploadedChecksums(Collection<String> currentSnapshotFiles) {  
            .stream()
    /**
    private void updateRemoteRefreshTimeAndSeqNo(long refreshTimeMs, long refreshClockTimeMs, long refreshSeqNo) {
    }
import java.util.concurrent.TimeUnit;
import org.opensearch.index.translog.Translog;
                segmentTracker.addUploadBytesStarted(fileSizeMap.get(file));
                localSegmentChecksumMap.put(file, checksum);
        if (indexShard.routingEntry().primary()) {
     * @param cryptoMetadata  CryptoMetadata for index-level encryption
                    // Create a map of file name to size and update the refresh segment tracker  
     * @param didRefresh true if the refresh opened a new reference
                        logger.info("Skipping stale segment cleanup: remote store fence ownership is superseded or unreadable");
     * In an exponential back off setup, the maximum retry interval after the retry interval increases exponentially.
    @Override
        // This also makes sure that retries are not scheduled for shards  
        Function<Map<String, Long>, UploadListener> uploadListenerFunction = (Map<String, Long> sizeMap) -> createUploadListener(
        userData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
        segmentTracker.setLatestUploadedFiles(localFileSizeMap.keySet());  
        // Publishing segment metadata and collecting stale segments both mutate state shared with any other live copy
                    }
    }
    protected boolean isRetryEnabled() {
    private void beforeSegmentsSync() {
        CryptoMetadata cryptoMetadata
package org.opensearch.index.shard;
        // This is required in case of remote migration seeding/snapshots/shrink/ split/clone where we need to durable persist
import org.opensearch.action.bulk.BackoffPolicy;  
        org.opensearch.common.CheckedFunction<CatalogSnapshot, byte[], IOException> serializer = indexShard
            }  
    }  
     *
                        .stream()
    }
                // discard whatever was published while the condition was on, otherwise it stays armed and can still
                    // Start the segments files upload with crypto  
        // CatalogSnapshotManager → LuceneCommitter.serializeToCommitFormat which uses the
        segmentTracker.incrementTotalUploadsStarted();  
                    // Clone to freeze lastCommitGeneration and other mutable state for the  
    }
import org.opensearch.action.LatchedActionListener;
        }  
                                uploadMetadata(localSegmentsPostRefresh, catalogSnapshot, checkpoint);
     * @param file that needs to be uploaded.
        resetBackOffDelayIterator();
        if (shardClosed()) {
            try (IndexInput indexInput = storeDirectory.openInput(file, IOContext.READONCE)) {
     * Updates the last refresh time and refresh seq no which is seen by remote store.
            } catch (IOException e) {
            return false;
            logger.info("Exception occurred in isRefreshAfterCommitSafe", e);  
        boolean successful;  
    }
        }
                                    localSegmentsSizeMap,
    }
                    CountDownLatch latch = new CountDownLatch(1);
            StringBuilder sb = new StringBuilder("Skipped syncing segments with");
                        throw new IllegalStateException(  
            logger.info("Skipping segment upload and cleanup: a higher primary term has taken the remote store fence");  
            if (indexShard.getReplicationTracker() != null) {  
                }  
public final class RemoteStoreRefreshListener extends ReleasableRetryableRefreshListener {
import java.util.Map;
            }
        // Publishing the new checkpoint which is used for remote store + segrep indexes
    private final RemoteStoreUploader remoteStoreUploader;  
                    // Capture replication checkpoint before uploading the segments as upload can take some time and checkpoint can  
        final long maxSeqNo = indexShard.getIndexer().currentOngoingRefreshCheckpoint();  
     * Checks if all files present in local store are uploaded to remote store or part of excluded files.
                    throw new IllegalStateException("DataFormatAwareStoreDirectory expected when pluggable data format is enabled");
                    Collection<String> localSegmentsPostRefresh = catalogSnapshot.getFiles(true);  
                    // asynchronously) to serialize segment metadata with a different generation
                // with remote trans-log integration.
import org.apache.lucene.store.Directory;
                logger.error("Exception while initialising RemoteSegmentStoreDirectory", e);  
                || indexShard.recoveryState().getRecoverySource().getType() == RecoverySource.Type.SNAPSHOT
        long refreshTimeMs,
     */
    /**  
                segmentTracker.addUploadTimeInMillis(Math.max(1, System.currentTimeMillis() - uploadStartTime));
                    // than the one used for the initial segment file upload.
                try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = indexShard.getCatalogSnapshot()) {
                                Locale.ROOT,
        this.remoteStoreSettings = remoteStoreSettings;  
        if (indexShard.getIndexer() instanceof EngineBackedIndexer engineBacked) {
                // Track upload success
import org.opensearch.threadpool.ThreadPool;  
            && indexShard.recoveryState() != null
    public static final Set<String> EXCLUDE_FILES = Set.of("write.lock");
            // reference, but it is important to upload the zero state segments so that the restore does not break.
        } else {  
                || indexShard.shouldSeedRemoteStore());
     *  it uses files uploaded cache in RemoteDirector and it doesn't make a remote store call.
import org.opensearch.common.logging.Loggers;
    boolean isLowPriorityUpload() {
     * returned value of this method for scheduling retries in syncSegments method.
     */
     *
                                successful.set(true);  
                segmentTracker.addToLatestUploadedFiles(file);
        localSegmentChecksumMap.keySet()
                                );  
            segmentTracker.updateUploadBytesMovingAverage(bytesUploaded);
            RemoteSegmentMetadata uploadedMetadata = this.remoteDirectory.init();
        return indexer instanceof EngineBackedIndexer engineBacked && engineBacked.getEngine() instanceof InternalEngine;
    private final RemoteStoreSettings remoteStoreSettings;
                    // unreadable-fence event, a perfectly correlated failure. A skipped cycle is retried on the next
     * @return true if this refresh has happened on account of a commit. If otherwise or exception, returns false.  
        };
     */
        // Pass the serializer from the indexer. For DFA primary it delegates to the
    }
                                indexShard.getOperationPrimaryTerm()
            // Accept DataFormatAwareEngine alongside InternalEngine (DFA primaries need the retry path).
        // Set the minimum sequence number for keeping translog
    private final SegmentReplicationCheckpointPublisher checkpointPublisher;
    @Override  
                segmentTracker.setLatestUploadedFiles(uploadedMetadata.getMetadata().keySet());  
            } catch (IOException e) {
            uploadListenerFunction,
        } else {
        // relaxing a collection gate alone is safe, but relaxing both violates HydrationIntegrity - so one shared  
        // Update the remote refresh time and refresh seq no
                                // We don't want to fail refresh if upload of new segments fails. The missed segments will be re-tried
    private final IndexShard indexShard;  
     * to either setting is picked up by the next successful segments sync.
        // so the owner's own collection then deletes files it is still hydrating. Both are therefore gated on this copy
            } else {
                        throw new SegmentUploadFailedException("Timeout while waiting for remote segment transfer to complete");  
                // if a new segments_N file is present in local that is not uploaded to remote store yet, it
            long bytesUploaded = segmentTracker.getUploadBytesSucceeded() - bytesBeforeUpload;
import java.util.Set;
                    // duration of this upload cycle. Without cloning, a concurrent flush can
    }
            }
    @Override
            }
        updateFinalStatusInSegmentTracker(successful.get(), bytesBeforeUpload, startTimeInNS);
    }
        if (shouldSync(didRefresh, false)) {
                        @Override  
            .getDelegate()).getDelegate();
                // Also trigger cleanup if the uploaded segments map exceeds the configured threshold,
        // The above trimming makes the translog-size based periodic flush condition ineffective on remote-store
                if (isRefreshAfterCommit() || uploadedSegmentsMapExceedsThreshold()) {
     */
            }
     * Resolves the uncommitted segment bytes to flush at: the per-index
                // as part of exponential back-off retry logic. This should not affect durability of the indexed data
                            )  
     * @return true if the upload has to be skipped for the file.  
        return false;
import org.opensearch.common.util.UploadListener;
        // In this case when the primary mode is false, we need to upload segments to Remote Store
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
                String checksum = dfasd.calculateUploadChecksum(file);
            }
     *  
    }
    private void initializeRemoteDirectoryOnTermUpdate() throws IOException {  
            logger.trace("primaryTerm update from={} to={}", primaryTerm, indexShard.getOperationPrimaryTerm());
        boolean shouldSync = didRefresh // If the readers change, didRefresh is always true.  
        return ThreadPool.Names.REMOTE_REFRESH_RETRY;
        );
        // from isReadyForUpload to schedule refresh retries as the index shard or the primary mode are not in complete  
                // Start tracking the upload bytes started
 * SPDX-License-Identifier: Apache-2.0
     */
        long lastRefreshedCheckpoint,
            successful = true;
        // shards, hence publish the size of segment bytes not yet referenced by the last commit point, together with
        }  
                localSegmentChecksumMap.put(file, checksum);
     * has been uploaded to remote store successfully. This method also updates the segment tracker about the latest  
}
import java.util.function.Function;  
import java.util.stream.Collectors;
                        TimeUnit.MILLISECONDS
     * Whether to upload a file or not depending on whether file is in excluded list or has been already uploaded.  
                }
     */
    @Override  
        Map<String, Long> localFileSizeMap,
                    }
            .collect(Collectors.toSet())
    private static final BackoffPolicy EXPONENTIAL_BACKOFF_POLICY = BackoffPolicy.exponentialEqualJitterBackoff(
        return indexSettings.isFlushOnUncommittedSegmentsThresholdSizeExplicit()  
                }
            || isRemoteSegmentStoreInSync() == false;
        REMOTE_REFRESH_RETRY_BASE_INTERVAL_MILLIS,  
    private boolean shardClosed() {
    }
                DataFormatAwareStoreDirectory dfasd = DataFormatAwareStoreDirectory.unwrap(storeDirectory);  
        this.indexShard = indexShard;
    }  
     * The initial retry interval at which the retry job gets scheduled after a failure.  
 * this file be licensed under the Apache-2.0 license or a
     * Once uploaded, the checksum is stored in remote metadata and no longer needed in the local cache.
    protected Logger getLogger() {  
        return logger;
        // publication and fails OPEN (an unreadable fence proceeds - the worst case is an orphan, the pre-existing  
     */  
     * @return true iff the shard is a started with primary mode true or it is local or snapshot recovery.
/*  
        this.storeDirectory = indexShard.store().directory();
                    } else {  
import org.opensearch.cluster.metadata.IndexMetadata;
    private final Directory storeDirectory;
                uploadStartTime = System.currentTimeMillis();  
            // During failover, the uploaded metadata would have names of files that have been uploaded to remote store.  
                    // HydrationIntegrity - and a single shared fail-open check would relax both on one  
    /**  
                localSegmentsPostRefresh,
                    // snapshot's lastCommitGeneration — causing the retry path (which runs  
     *
            throw new UnsupportedOperationException("Encountered null TranslogGeneration while uploading metadata to remote segment store");
            successful = syncSegments();
    private void clearStaleFilesFromLocalSegmentChecksumMap(Collection<String> localSegmentsPostRefresh) {  
                // Track upload failure
    ) throws IOException {
import org.opensearch.indices.RemoteStoreSettings;  
    public RemoteStoreRefreshListener(
    /**
        // Update latest uploaded segment files name in segment tracker
     * @param fileSizeMap updated map of current snapshot of local segments to their sizes
        Map<String, String> userData = new HashMap<>(catalogSnapshotCloned.getUserData());
        String lastCommittedLocalSegmentFileName = SegmentInfos.getLastCommitSegmentsFileName(storeDirectory);
    }
        return (lastCommittedLocalSegmentFileName != null  
                                // At this point since we have uploaded new segments, segment infos and segment metadata file,
import static org.opensearch.index.seqno.SequenceNumbers.LOCAL_CHECKPOINT_KEY;  
        }
                    CatalogSnapshot catalogSnapshot = catalogSnapshotRef.get().clone();  
        } else {
            dfasd.evictStaleChecksums(currentSnapshotFiles);  
     * {@code index.remote_store.flush_on_uncommitted_segments.threshold_size} if the index sets it explicitly,
    private void onSuccessfulSegmentsSync(  
    protected void runAfterRefreshExactlyOnce(boolean didRefresh) {
            // Below check ensures that if there is commit, then that gets picked up by both 1st and 2nd shouldSync call.  
    private void resetBackOffDelayIterator() {
    private boolean shouldSync(boolean didRefresh, boolean skipPrimaryTermCheck) {
                    ) == false) {
            if (indexShard.indexSettings().isPluggableDataFormatEnabled()) {
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));  
        } catch (Throwable t) {
        segmentTracker.updateRemoteRefreshClockTimeMs(refreshClockTimeMs);
                                // with remote trans-log integration.
        long refreshClockTimeMs,
        segmentTracker.updateRemoteRefreshTimeMs(refreshTimeMs);  
                sb.append(" indexShardState=").append(indexShard.state());
    /**
            public void onSuccess(String file) {
     * This checks if there is a sync required to remote.
                initializeRemoteDirectoryOnTermUpdate();
        ActionListener<Void> segmentUploadsCompletedListener,
        }
            ? indexSettings.getFlushOnUncommittedSegmentsThresholdSize().getBytes()
        localSegmentChecksumMap = new HashMap<>();  
     * uploaded segment files onto remote store.
            logger.error(
        // either can break a legitimate owner: an unfenced publish moves the reference set that collection prunes to,  
        if (indexShard.indexSettings().isRemoteStoreFencingEnabled() && indexShard.isRemoteStoreFenceSuperseded()) {
        try {  
        indexShard.getIndexer().translogManager().setMinSeqNoToKeep(lastRefreshedCheckpoint + 1);  
            segmentTracker.incrementTotalUploadsFailed();  
import org.opensearch.core.action.ActionListener;
     * @return true iff all the local files are uploaded to remote store.
        // FenceSegmentFlow.tla measures why the separation matters: relaxing the publication gate alone is safe and
     * @param localSegmentsPostRefresh collection of segment files present after refresh
                        );
        this.checkpointPublisher = checkpointPublisher;
     * @param indexMetadata Index metadata containing crypto settings  
        }
     * @return updated map of local segment files and filesize  
     * Resets the backoff delay iterator so that the next set of failures starts with the base delay and goes upto max delay.  
        catalogSnapshotCloned.setUserData(userData, false);
                } catch (EngineException e) {
import org.opensearch.index.engine.DataFormatAwareEngine;
                            }  
        }
        Translog.TranslogGeneration translogGeneration = indexShard.getIndexer().translogManager().getTranslogGeneration();
        CatalogSnapshot catalogSnapshot,  
    private CryptoMetadata resolveCryptoMetadata(IndexMetadata indexMetadata) {  
    }  
        } catch (Throwable throwable) {
import java.util.Collection;  
                                    refreshClockTimeMs,
     * @return CryptoMetadata if encryption is configured, null otherwise
        }
                segmentTracker.updateLocalRefreshTimeAndSeqNo();
import org.apache.lucene.store.IOContext;  
     * Extracts CryptoMetadata if configured.
        this.segmentTracker = segmentTracker;  
            @Override
            } catch (Throwable t) {  
                    long lastRefreshedCheckpoint = indexShard.getIndexer().lastRefreshedCheckpoint();
                            try {
     * Different from IndexShard#isRemoteSegmentStoreInSync as  
            .forEach(localSegmentChecksumMap::remove);
        // with failed syncSegments invocation after they are closed
            .filter(file -> !localSegmentsPostRefresh.contains(file))  
                    final ReplicationCheckpoint checkpoint = indexShard.computeReplicationCheckpoint(catalogSnapshot);
        // retrying would spin. The setting is checked first so that an unfenced index never pays for the ownership  
                catalogSnapshotCloned,  
            try {  
     */
            segmentTracker.updateUploadBytesPerSecMovingAverage((bytesUploaded * 1_000L) / Math.max(1, timeTakenInMS));  
        return true;  
    /*
    /**
import org.apache.lucene.store.FilterDirectory;
                                // as part of exponential back-off retry logic. This should not affect durability of the indexed data  
            long translogFileGeneration = translogGeneration.translogFileGeneration;  
            );  
import org.opensearch.index.engine.EngineException;  
    private static final int REMOTE_REFRESH_RETRY_BASE_INTERVAL_MILLIS = 1_000;
        try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = indexShard.getCatalogSnapshot()) {
            return indexShard.state() != IndexShardState.STARTED  
import org.opensearch.index.remote.RemoteSegmentTransferTracker;  
            && (indexShard.recoveryState().getRecoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS  
        Collection<String> localSegmentsPostRefresh,
                segmentTracker.addUploadBytesFailed(fileSizeMap.get(file));
     */  
        IndexMetadata indexMetadata = indexShard.indexSettings().getIndexMetadata();
import java.util.concurrent.atomic.AtomicBoolean;
                    if (checkpoint.getPrimaryTerm() != indexShard.getOperationPrimaryTerm()) {
                serializer
import org.opensearch.common.unit.TimeValue;  
 * @opensearch.internal
     * This lives here, at the publication site, because it is the only place holding both scopes: the shard's
     * Updates map of file name to size of the input segment files in the segment tracker. Uses {@code storeDirectory.fileLength(file)} to get the size.
                                logger.warn("Exception in post new segment upload actions", e);
            try {  
        backoffDelayIterator = EXPONENTIAL_BACKOFF_POLICY.iterator();  
            }
     */  
        resetBackOffDelayIterator();
        // We have 2 separate methods to check if sync needs to be done or not. This is required since we use the return boolean
    protected String getRetryThreadPoolName() {  
    }
import java.util.Locale;  
    private void updateFinalStatusInSegmentTracker(boolean uploadStatus, long bytesBeforeUpload, long startTimeInNS) {  
     */  
     *
    /**
            logger.info(sb.toString());
        // true rather than requesting a retry is deliberate: a superseded copy will never regain ownership, so
        segmentTracker.updateRemoteRefreshSeqNo(refreshSeqNo);
    }  
            }
            return EXCLUDE_FILES.contains(file) || remoteDirectory.containsFile(file, getChecksumOfLocalFile(file));
     * Upload new segment files created as part of the last refresh to the remote segment store.
import org.opensearch.index.engine.InternalEngine;
                    Collection<String> localSegmentsPostRefresh = catalogSnapshotRef.get().getFiles(true);  
     *  
        checkpointPublisher.publish(indexShard, checkpoint);
        if (isReady == false) {
            logger.error("Exception in RemoteStoreRefreshListener.afterRefresh()", t);  
    /**
import java.util.Iterator;
                    // Collection fails CLOSED, on its own gate, unlike the publication gate at the top of this sync
     *
                engineBacked.getEngine().updateUncommittedSegmentBytes(localFileSizeMap, flushOnUncommittedSegmentsThresholdBytes());  
        RemoteStoreSettings remoteStoreSettings  
        Collection<String> filteredFiles = localSegmentsPostRefresh.stream().filter(file -> !skipUpload(file)).collect(Collectors.toList());
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
        this.primaryTerm = remoteSegmentMetadata != null ? remoteSegmentMetadata.getPrimaryTerm() : INVALID_PRIMARY_TERM;
                String checksum = Long.toString(CodecUtil.retrieveChecksum(indexInput));  
                        remoteDirectory.deleteStaleSegmentsAsync(indexShard.getRemoteStoreSettings().getMinRemoteSegmentMetadataFiles());
        }  
        beforeSegmentsSync();
    /**  
    /**
            return isRefreshAfterCommit();
            segmentTracker.incrementTotalUploadsSucceeded();
            );
     *  Doesn't throw an exception on store getting closed as store will be open
                // is considered as a first refresh post commit. A cleanup of stale commit files is triggered.  
     * otherwise the cluster default {@code cluster.remote_store.flush_on_uncommitted_segments.threshold_size}.  
    }
                    // move.
    public void beforeRefresh() throws IOException {}
    ) {  
     * On primary term update, we (re)initialise the remote segment directory to reflect the latest metadata file that
                            String.format(
    private final Map<String, String> localSegmentChecksumMap;
    @Override
                || !(isInternalEngineIndexer(indexShard.getIndexer()) || indexShard.getIndexer() instanceof DataFormatAwareEngine);
     * @param segmentUploadsCompletedListener listener to be notified when upload completes
    /**
                                    checkpoint
    }  
import org.apache.lucene.codecs.CodecUtil;
        remoteStoreUploader = new RemoteStoreUploaderService(indexShard, storeDirectory, remoteDirectory);
                    evictUploadedChecksums(localSegmentsPostRefresh);
                                logger.debug("Metadata upload successful");  
    private static final int INVALID_PRIMARY_TERM = -1;  
    protected TimeValue getNextRetryInterval() {
            // if following condition does not exist. The segments created as part of translog replay will not be present  
    private void uploadNewSegments(
     * @param didRefresh             if the readers changed.  
                    logger.warn("Exception while reading SegmentInfosSnapshot", e);  
    }
                                onSuccessfulSegmentsSync(
        }
            if (indexShard.recoveryState() != null) {  
    }
     *
            return shouldSync;
            if (indexShard.state() != null) {  
        this.remoteDirectory = (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory())  
        return backoffDelayIterator.next();
    }
        // still owning the fence - but on SEPARATE checks with OPPOSITE failure directions. This one gates the
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
                        @Override  
    private boolean syncSegments() {
        if (isReadyForUpload() == false) {
        if (shouldSync(didRefresh, true) && isReadyForUpload()) {
import java.util.concurrent.CountDownLatch;  
        // Ignore syncing segments if the underlying shard is closed
     * @return true if it is closed, false otherwise
                try (GatedCloseable<CatalogSnapshot> catalogSnapshotRef = indexShard.getCatalogSnapshot()) {
                return checksum;  
                    if (indexShard.indexSettings().isRemoteStoreFencingEnabled()  
        // Reset the backoffDelayIterator for the future failures  
        DataFormatAwareStoreDirectory dfasd = DataFormatAwareStoreDirectory.unwrap(storeDirectory);
            isLowPriorityUpload(),
                logger.error("Exception in runAfterRefreshExactlyOnce() method", t);
     * Evicts pre-computed checksums for files no longer in the current catalog snapshot.  
                    uploadNewSegments(localSegmentsPostRefresh, localSegmentsSizeMap, segmentUploadsCompletedListener, cryptoMetadata);
            // The third condition exists for uploading the zero state segments where the refresh has not changed the reader
        } catch (Exception e) {
        logger.debug("onSuccessfulSegmentsSync lastRefreshedCheckpoint={} checkpoint={}", lastRefreshedCheckpoint, checkpoint);  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                                // Start metadata file upload
    @Override  
            // primaryMode to true. Due to this, the refresh that is triggered post replay of translog will not go through
        }  
    /**
    private final RemoteSegmentStoreDirectory remoteDirectory;
        long refreshTimeMs = segmentTracker.getLocalRefreshTimeMs(), refreshClockTimeMs = segmentTracker.getLocalRefreshClockTimeMs();  
                storeDirectory,
            if (indexShard.getIndexerOrNull() != null) {  
import org.opensearch.cluster.metadata.CryptoMetadata;
        final AtomicBoolean successful = new AtomicBoolean(false);  
            if (remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled()) {
                // trigger a flush after the operator turned the condition off  
                sb.append(" engineType=").append(indexShard.getIndexer().getClass().getSimpleName());
                indexShard.getNodeId(),
            if (uploadedMetadata != null) {
                // to prevent unbounded memory growth when flushes do not happen.  
    }
     */
            @Override  
            }
        CryptoMetadata cryptoMetadata = resolveCryptoMetadata(indexMetadata);  
        long refreshSeqNo = segmentTracker.getLocalRefreshSeqNo();
            public void beforeUpload(String file) {  
        REMOTE_REFRESH_RETRY_MAX_INTERVAL_MILLIS
        int threshold = indexShard.getRemoteStoreSettings().getUploadedSegmentsCleanupThreshold();  
     * @param localSegmentsSizeMap map of segment file names to their sizes  
            || remoteDirectory.getSegmentsUploadedToRemoteStore().isEmpty()  
    private Map<String, Long> updateLocalSizeMapAndTracker(Collection<String> segmentFiles) {
    private volatile long primaryTerm;
                if (dfasd == null) {
import java.io.IOException;
        try {
        return false;
            }
                    }
                file  
        IndexShard indexShard,  
                                logger.debug("New segments upload successful");  
    }  
     * <p>
     * Checks if the underlying IndexShard instance is closed  
     * This method also uploads remote_segments_metadata file which contains metadata of each segment file uploaded.
            this.primaryTerm = indexShard.getOperationPrimaryTerm();  
        }
            }
                                    refreshSeqNo,
/**
    }  
            @Override
            // Here we update the tracker with latest remote uploaded files.
                    // is safe and relaxing a collection gate alone is safe, but relaxing BOTH violates
                engineBacked.getEngine().clearUncommittedSegmentBytes();
     *  
                                "primaryTerm mismatch during segments upload to remote store [%s] != [%s]",  
        if (indexMetadata == null) {
            filteredFiles,
        // Start tracking total uploads started
 *
        ReplicationCheckpoint checkpoint  
 * The OpenSearch Contributors require contributions made to  
                                checkpoint.getPrimaryTerm(),
     */  
            // Exclude files that are already uploaded and the exclude files to come up with the list of files to be uploaded.
        boolean isReady = indexShard.isStartedPrimary() || isLocalOrSnapshotRecoveryOrSeeding();
     * @param skipPrimaryTermCheck consider change in primary term or not for should sync
        long bytesBeforeUpload = segmentTracker.getUploadBytesSucceeded(), startTimeInNS = System.nanoTime();
        if (this.primaryTerm != indexShard.getOperationPrimaryTerm()) {
import org.opensearch.common.concurrent.GatedCloseable;
        }  
            // Following check is required to enable retry and make sure that we do not lose this refresh event  
        try {  
     * Clears the stale files from the latest local segment checksum map.
     */  
     * Returns if the current refresh has happened after a commit.
     *  
    private UploadListener createUploadListener(Map<String, Long> fileSizeMap) {
        if (!localSegmentChecksumMap.containsKey(file)) {
                sb.append(" recoverySourceType=").append(indexShard.recoveryState().getRecoverySource().getType());
        }
    private String getChecksumOfLocalFile(String file) throws IOException {  
                }  
     * Uploads new segment files to the remote store.  
                    ActionListener<Void> segmentUploadsCompletedListener = new LatchedActionListener<>(new ActionListener<>() {
     */
    ) {
                        && indexShard.isRemoteStoreFenceSupersededFailingClosed()) {
    }
     */  
            logger.error("Throwable thrown during isRemoteSegmentStoreInSync", throwable);
    ) {
import org.apache.logging.log4j.Logger;
        }
    }  
                    // commit-refresh; a wrongly permitted delete is not recoverable.
        // reader registered for this snapshot to produce bytes strictly consistent with the  
import org.apache.lucene.store.IndexInput;
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
        // if no metadata is present, this value will be initialized with -1.
     */  
                segmentTracker.addUploadTimeInMillis(Math.max(1, System.currentTimeMillis() - uploadStartTime));  
import org.opensearch.index.seqno.SequenceNumbers;
        if (translogGeneration == null) {  
        Collection<String> localSegmentsPostRefresh,
     * Exponential back off policy with max retry interval.  
     * @param segmentFiles list of segment files that are part of the most recent local refresh.
import org.opensearch.cluster.routing.RecoverySource;  
    private volatile Iterator<TimeValue> backoffDelayIterator;  
 */  
 *
    private boolean isRefreshAfterCommit() throws IOException {
