            Map<String, String> generationToChecksumMapper = translogMetadata.getGenerationToChecksumMapper() != null
            .basePath(blobStoreRepository.basePath())
        LongSupplier globalCheckpointSupplier,
     * Claims the fence for this shard copy at {@code primaryTerm}, before the caller reads its translog restore point.
        throws IOException {
            }
        RemoteStoreSettings remoteStoreSettings,
        RemoteStoreSettings remoteStoreSettings
        if (fencingEnabled) {
    protected boolean upload(long primaryTerm, long generation, long maxSeqNo) throws IOException {
                break;
        return readers.size() >= maxRemoteTlogReaders;
                true
                .dataCategory(TRANSLOG)
            shardId,
                    tragedy.setTragicException(e);
            return;
            tracker,
                String fileName = file.getFileName().toString();
    static void download(TranslogTransferManager translogTransferManager, Path location, Logger logger, boolean seedRemote, long timestamp)
                    boolean wasSyncPaused = pauseSync.getAndSet(false);
import java.util.function.LongSupplier;
 * A Translog implementation which syncs local FS with a remote store
            // If local filesystem contains non-empty translog, we clean up these files and create empty translog.
        // This enables us to restore translog from the metadata in case of failover or relocation.
     * Deletes remote translog and metadata files asynchronously corresponding to the generations.
            tragedy.setTragicException(ex);
                boolean result = pauseSync.compareAndSet(false, true);
    private static void downloadOnce(
    protected Releasable drainSync() {
                transferSnapshotProvider,
                        logger.trace("Creating new writer for gen: [{}]", current.getGeneration() + 1);
import org.opensearch.index.translog.transfer.TransferSnapshot;
         * Generation for the translog
import org.opensearch.index.translog.transfer.listener.TranslogTransferListener;
    }
            return prepareAndUpload(primaryTermSupplier.getAsLong(), location.generation);
                    logger.debug("Empty translog on local, skipping clean-up");
                .basePath(blobStoreRepository.basePath())
            fence
                }
        syncBeforeRollGeneration();
    private final RemoteTranslogTransferTracker remoteTranslogTransferTracker;
            logger.debug(
            remoteStoreSettings,
    // Visible for testing
            fileTransferTracker,
                );
                try {
 * The OpenSearch Contributors require contributions made to
        }
    protected void setMinSeqNoToKeep(long seqNo) {
                deleteRemoteGeneration(generationsToDelete);
        boolean isServerSideEncryptionEnabled,
        translogTransferManager.transferFenceOwnership(primaryTermSupplier.getAsLong(), targetAllocationId);
        assert readLock.isHeldByCurrentThread() || writeLock.isHeldByCurrentThread();
                generation,
import org.opensearch.cluster.service.ClusterService;
            mdPath,
            .fixedPrefix(remoteStoreSettings.getTranslogPathFixedPrefix())
            primaryTermSupplier.getAsLong(),
            tracker,
import java.io.IOException;
        private final long generation;
        // of older primary term.
                    generation,
            if (minGeneration > maxGeneration) {
                }
                }
            ensureOpen();
import org.apache.logging.log4j.Logger;
import org.opensearch.common.util.concurrent.ReleasableLock;
                return;
        if (current.totalOperations() == 0 && primaryTermSupplier.getAsLong() == current.getPrimaryTerm()) {
                return;
            long minGeneration = translogMetadata.getMinTranslogGeneration();
        // Since remote generation deletion is async, this ensures that only one generation deletion happens at a time.
                readers,
        if (fenceContainer.isConditionalWriteSupported() == false) {
        RemoteFsTranslogTransferListener(long generation, long primaryTerm, long maxSeqNo, long globalCheckpoint) {
        // The fence lives alongside the translog metadata files (its name does not match the metadata prefix, so
    /**
            // The tragic exception is set by upload(); close here, where the resources of the try-with-resources above
            long maxGeneration = translogMetadata.getGeneration();
            // NO-OP
    protected final FileTransferTracker fileTransferTracker;
                    IOUtils.closeWhileHandlingException(readers);
                return false;
                // The below condition on GCP exists to handle global checkpoint updates during close index.
            statsTracker.recordDownloadStats(prevDownloadBytesSucceeded, prevDownloadTimeInMillis);
        public void onUploadComplete(TransferSnapshot transferSnapshot) throws IOException {
                    copyCheckpointTo(location.resolve(getCommitCheckpointFileName(current.getGeneration())));
    }
            if (readers.isEmpty()) {
        );
            if (globalCheckpoint > globalCheckpointSynced) {
    public static TranslogTransferManager buildTranslogTransferManager(
    }
                try {
            channelFactory
        CryptoMetadata cryptoMetadata = CryptoMetadata.fromIndexSettings(indexMetadata.getSettings());
            remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
                    Translog.createEmptyTranslog(location, translogTransferManager.getShardId(), checkpoint);
                "Remote store fencing is enabled for "
        // This is to ensure that after the permits are acquired during primary relocation, there are no further modification on remote
            return;
        assert location.generation <= current.getGeneration();
import java.util.concurrent.Semaphore;
    }
        }
            isServerSideEncryptionEnabled
        } catch (final Exception ex) {
                );
            remoteGenerationDeletionPermits::release
    @Override
    ) throws IOException {
            Locale.ROOT,
        RemoteStorePathStrategy pathStrategy,
    protected void onDelete() {
        /**
                    sync();
            shardId,
import org.opensearch.common.lease.Releasables;
 *
            }
        } catch (Exception e) {
    @Override
                    }
            // in-place snapshot restore) must be able to take over a dead incumbent's path, whose recorded owner it
    @Override
     * @opensearch.internal
     * restore point was read. Those writes would be acknowledged and then lost. Claiming the chain first invalidates
            }
    @Override
import java.nio.file.Path;
        ) {
        BlobPath dataPath = pathStrategy.generatePath(dataPathInput);
    }
        BlobContainer fenceContainer = blobStoreRepository.blobStore(isServerSideEncryptionEnabled).blobContainer(mdPath);
                "Remote store fencing is enabled for "
import java.util.concurrent.TimeUnit;
        IOException ex = null;
            );
    // Visible for testing
                translogMetadata.getMinTranslogGeneration(),
                    + "]); fencing requires the copy identity that only a live shard supplies"
                    + "], node id ["
    }
                        Files.delete(file);
        trimUnreferencedReaders(false);
    /**
        }
    ) {
            int skipped = 0;
            // can never match. This is the first of the two claims; the translog instance's guarded re-adoption is the second.
                return upload(primaryTerm, generation, maxSeqNo);
                throw new IllegalStateException(errorMsg);
            logger.debug("skipped uploading translog for {} {} syncPermits={}", primaryTerm, generation, syncPermit.availablePermits());
            ).build()
            Checkpoint checkpoint = readCheckpoint(location);
    @Override
                success = true;
        TranslogOperationHelper translogOperationHelper,
                location.resolve(Translog.getCommitCheckpointFileName(translogMetadata.getGeneration())),
                return;
                    getMinFileGeneration(),
        // Deleting remote generations mutates state shared with any other live copy of this shard, and is not on the
                fenceOwnerAllocationId,
            shardId,
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = new RemoteTranslogTransferTracker(shardId, 1000);
    public static void sealFence(
     *
            isTranslogMetadataEnabled,
                Files.createDirectories(location);
                    logger.debug("Remote migration ongoing. Retaining the translog on local, skipping clean-up");
        long maxSeqNo = -1;
            // (notably the read lock) have already been released - closeOnTragicEvent acquires the write lock.
            .dataCategory(TRANSLOG)
                // as present without that check.
                // only a relocation target's. This is the second of the two claims a takeover makes: the
            threadPool,
     * legitimately serving at the same term, and sealing would fence it mid-handoff.
            IOUtils.closeWhileHandlingException(readers);
        }
        boolean seedRemote,
                    assert wasSyncPaused : "RemoteFsTranslog sync was not paused before re-enabling it";
            );
        }
                : Map.of();
            translogUUID,
    }
import java.util.function.LongConsumer;
                translogMetadata.getGeneration(),
    // clean up translog folder uploaded by previous primaries once
            remoteTranslogTransferTracker,
        }
        for (long generation = minRemoteGenReferenced - 1 - indexSettings().getRemoteTranslogExtraKeep(); generation >= 0; generation--) {
import org.opensearch.common.blobstore.BlobContainer;
    ) {
 * compatible open source license.
                    + fenceOwnerNodeId
        boolean isTranslogMetadataEnabled,
            } catch (Exception e) {
        boolean isServerSideEncryptionEnabled,
            for (long i = maxGeneration; i >= minGeneration; i--) {
            fileTransferTracker,
            // The seal arbitrates UNGUARDED: a brand-new legitimate incarnation (failover promotion, store recovery,
    protected boolean shouldFlush() {
                    + shardId
            isServerSideEncryptionEnabled,
        private final long maxSeqNo;
    }
        BlobStoreRepository blobStoreRepository,
                        + "] greater than max generation ["
    }
import org.opensearch.index.remote.RemoteStorePathStrategy;
            pathStrategy,
                // proves the guard restores NoAckedWriteLoss. For a relocation target the same check is what defers
    public static TranslogTransferManager buildTranslogTransferManager(
        LongConsumer persistedSequenceNumberConsumer,
                        + "]"
    @Override
        if (indexMetadata == null) {
import java.util.Set;
        );
            config.getAllocationId(),
            fileTransferTracker,
        fileTransferTracker = new FileTransferTracker(shardId, remoteTranslogTransferTracker);
        RemoteStoreSettings remoteStoreSettings,
     * Returns <code>true</code> if an fsync and/or remote transfer is required to ensure durability of the translogs operations or it's metadata.
        }
                    assert writeLock.isHeldByCurrentThread() : "Write lock must be held before we acquire the read lock";
                // we have to close all the recovered ones otherwise we leak file handles here
     * the old primary's token, so its very next upload fails and it can acknowledge nothing this copy will not see.
        assert readLock.isHeldByCurrentThread() == true;
            Checkpoint checkpoint = current.getLastSyncedCheckpoint();
        long prevDownloadTimeInMillis = statsTracker.getTotalDownloadTimeInMillis();
import java.util.function.BooleanSupplier;
        Logger logger,
            false
        }
                    // readers and writer to not be mutated any further.
     * @throws TranslogFencedException if another copy already owns the fence at a higher term
        // rejected here, at the source, rather than by a bare requireNonNull deep inside RemoteStoreFence.
                    if (closed.get() == false) {
        Path location,
     *
        While translog files are getting downloaded by new primary, it might hence be deleted by the primary
import org.opensearch.repositories.Repository;
                // on to all the uncommitted tlog files if we don't close
        BlobStoreRepository blobStoreRepository,
        BlobStoreRepository blobStoreRepository,
    @Override
            logger.warn("Could not determine remote store fence ownership; skipping remote translog cleanup", e);
        BlobStoreTransferService transferService = new BlobStoreTransferService(
                current = createWriter(
        }
import org.opensearch.common.SetOnce;
                    if (closed.get() == false) {
        public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) throws IOException {
        }
        } else {
    @Override
            pathStrategy,
        assert repository instanceof BlobStoreRepository : "repository should be instance of BlobStoreRepository";
        if (onlyTrimLocal) {
                onMinRemoteGenReferencedChange();
        this.startedPrimarySupplier = startedPrimarySupplier;
                } else if (isEmptyTranslog(checkpoint) == false) {
                ex = e;
            long previousMinRemoteGenReferenced = minRemoteGenReferenced;
 *
import org.opensearch.threadpool.ThreadPool;
        Hence we retry if tlog/ckp files are not found .
                // twin's acknowledgements - losing them. FenceTakeover.tla exhibits that trace unguarded and
            }
                throw (RuntimeException) ex;
    // These permits exist to allow any inflight background triggered upload.
        boolean isTranslogMetadataEnabled,
            if (closed.compareAndSet(false, true)) {
                } finally {
                // Release permit that is meant for metadata files and return
     */
            }
     * This method must be called only after there are valid generations to delete in trimUnreferencedReaders as it ensures
        if (olderPrimaryCleaned.trySet(Boolean.TRUE)) {
    /**
            shardId,
            + " deletion policy requires a minReferenceGen of ["
                boolean downloaded = translogTransferManager.downloadTranslogIfChanged(
    }
        FileTransferTracker fileTransferTracker = new FileTransferTracker(shardId, remoteTranslogTransferTracker);
    ) {
        }
                // recovery seal (sealFence below) claimed via a throwaway instance and recorded this copy's
        // cleans up remote translog files not referenced in latest uploaded metadata.
        try (
            }
            try {
    }
            + " deletion policy requires a minReferenceGen of ["
    protected final SetOnce<Boolean> olderPrimaryCleaned = new SetOnce<>();
                    generationToPrimaryTermMapper.get(generation),
            // the read lock held around this call has been released.
            "%s repository should be instance of BlobStoreRepository",
            shardId,
            + "Translog.close method is called from inside Translog, but not via closeOnTragicEvent method";
            }
        if (fenceOwnerAllocationId == null || fenceOwnerNodeId == null) {
        }
        );
                // its first upload. Unguarded, the re-adoption would take the chain back from an equal-term twin that
 * created.
    }
                config.getNodeId()
/*
    protected static final int REMOTE_DELETION_PERMITS = 2;
            + "]";
        ChannelFactory channelFactory,
        );
            } finally {
            this.generation = generation;
            this.globalCheckpoint = globalCheckpoint;
        BlobStoreRepository blobStoreRepository = (BlobStoreRepository) repository;
                logger.error(errorMsg);
                } catch (final Exception e) {
        if (translogMetadata != null) {
            remoteStoreSettings,
        } catch (TranslogFencedException ex) {
    ) throws IOException {
        try {
    private static final int DOWNLOAD_RETRIES = 2;
        }
        RemoteStorePathStrategy pathStrategy,
            dataPath,
            boolean success = false;
            }
    public static void cleanup(
            && checkpoint.numOps == 0;
            }
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
import org.opensearch.indices.RemoteStoreSettings;
        TranslogTransferMetadata translogMetadata = translogTransferManager.readMetadata(timestamp);
        } catch (TimeoutException | InterruptedException e) {
    }
        RemoteStorePathStrategy pathStrategy,
            );
        Path location,
            // When code flow reaches this block, it means we don't have any translog files uploaded to remote store.
        TranslogTransferManager translogTransferManager = buildTranslogTransferManager(
        This doesn't happen in last download , where it is ensured that older primary has stopped modifying tlog data.
                }
        // We try to acquire 2 permits and if we can not, we return from here itself.
import org.opensearch.index.translog.transfer.RemoteStoreFence;
    public boolean syncNeeded() {
                throw ioException;
    public boolean revertFenceOwnership() throws IOException {
        } else {
import org.opensearch.cluster.metadata.CryptoMetadata;
        assert Objects.nonNull(pathStrategy);
                cryptoMetadata
    private final boolean isServerSideEncryptionEnabled;
            closeOnTragicEvent(ex);
    }
        if (remoteGenerationDeletionPermits.tryAcquire(REMOTE_DELETION_PERMITS) == false) {
                throw new TimeoutException("Timeout while acquiring all permits");
        }
     * This checks if number of translog files breaches the threshold count determined by
            // the latest generation's checkpoint once every generation is in place; a download that fails before then
            throw e;
                    skipped++;
        long minReferencedGen = Math.min(
        TranslogTransferManager translogTransferManager = buildTranslogTransferManager(
    public void transferFenceOwnership(String targetAllocationId) throws IOException {
            syncPermit.release(SYNC_PERMIT);
        private final long primaryTerm;
        // store.
                    + " but the owning shard copy's identity is unknown (allocation id ["
        BlobStoreRepository blobStoreRepository,
            null,
                    long generation = parseIdFromFileName(fileName, STRICT_TLOG_OR_CKP_PATTERN);
            }
import org.opensearch.core.index.shard.ShardId;
        try {
                || (current.getLastSyncedCheckpoint().globalCheckpoint > globalCheckpointSynced);
        RemoteTranslogTransferTracker tracker,
        boolean isTranslogMetadataEnabled,
        ShardId shardId,
        }
        }
        return remoteTranslogTransferTracker;
        In Primary to Primary relocation , there can be concurrent upload and download of translog.
    protected boolean prepareAndUpload(Long primaryTerm, Long generation) throws IOException {
        try (ReleasableLock lock = writeLock.acquire()) {
            } finally {
        @Override
        assert Translog.calledFromOutsideOrViaTragedyClose() : shardId
        if (seqNo < this.minSeqNoToKeep) {
        }
        );
 * @opensearch.internal
        if (maxRemoteTlogReaders == -1) {
            maxRemoteTranslogGenerationUploaded = generation;
                // Every translog instance requires RECORDED OWNERSHIP to arbitrate an existing equal-term path, not
            // the engine fails the shard instead of retrying the upload. The translog is closed by the caller, once
            fenceOwnerAllocationId,
        );
            if (generation == null || generation == current.getGeneration()) {
     * TranslogTransferListener implementation for RemoteFsTranslog
                    return upload(primaryTerm, current.getGeneration(), maxSeqNo);
                    }
                logger.info("All inflight remote translog syncs finished and further syncs paused");
        // Fail fast at the single fence-construction funnel: the fence records the owning copy's identity, and a
                    + shardId
        for (int i = 0; i <= DOWNLOAD_RETRIES; i++) {
        ShardId shardId,
        assert repository instanceof BlobStoreRepository : String.format(
            if (isRemoteStoreFenceSuperseded()) {
        }
            translogTransferManager.deleteStaleTranslogMetadataFilesAsync(remoteGenerationDeletionPermits::release);
            closeOnTragicEvent(ex);
                }
        @Override
        return buildTranslogTransferManager(
                    return upload(primaryTerm, current.getGeneration() - 1, maxSeqNo);
            // When a new writer is created the
        String fenceOwnerAllocationId,
        // 2. Using syncPermits, we prevent syncs at the desired time during primary relocation.
                logger.error("Exception in delete generations flow", e);
        String fenceOwnerNodeId
                    throw e;
    private static final int SYNC_PERMIT = 1;
        }
                    // Creating empty translog will cleanup the older un-referenced tranlog files, we don't have to explicitly delete
                skipped
    }
        RemoteStoreSettings remoteStoreSettings,
        super(
     * <br>
                logger.trace("Translog reader list is empty, returning from deleteStaleRemotePrimaryTerms");
    }
            );
        FileTransferTracker fileTransferTracker,
    }
    public boolean isRemoteStoreFenceSuperseded() throws IOException {
import org.opensearch.common.blobstore.BlobPath;
            shardId,
                success = true;
/**
     */
            logger.info("Downloaded data from remote translog till maxSeqNo = {}", checkpoint.maxSeqNo);
            Map<String, String> generationToPrimaryTermMapper = translogMetadata.getGenerationToPrimaryTermMapper();
            return;
                shardId,
            .indexUUID(indexUUID)
        ThreadPool threadPool,
                    assert syncPermit.availablePermits() == SYNC_PERMIT : "Available permits is " + syncPermit.availablePermits();
        return new TranslogTransferManager(
                        + minGeneration
        RemoteStoreFence fence = null;
        boolean isServerSideEncryptionEnabled
            long minimumReferencedPrimaryTerm = readers.stream().map(BaseTranslogReader::getPrimaryTerm).min(Long::compare).get();
        Repository repository,
     * implicitly that minimum primary term in latest translog metadata in remote store is the current primary term.
    private CryptoMetadata resolveCryptoMetadata() {
    private volatile long minSeqNoToKeep;
        return cryptoMetadata;
        // TODO: To be revisited as part of https://github.com/opensearch-project/OpenSearch/issues/7567
                fenceOwnerNodeId,
                // arbitrates unguarded, so a new incarnation can still take over a dead incumbent's path.
 * for every sync, post syncing to disk. Post that, a new generation is
        return translogTransferManager.isFenceSuperseded(primaryTermSupplier.getAsLong());
package org.opensearch.index.translog;
        if (syncToDisk() || syncNeeded()) {
            + "] but the lowest gen available is ["
    }
                    checkpoint.generation + 1,
            if (fileTransferTracker.uploaded(Translog.getFilename(generation)) == false) {
                logger.trace("downloadOnce success={} timeElapsed={}", success, (System.currentTimeMillis() - startTimeMs));
import org.opensearch.common.logging.Loggers;
        );
 */
        // The deletion of older translog files in remote store is on best-effort basis, there is a possibility that there
            isTranslogMetadataEnabled,
    protected volatile long minRemoteGenReferenced;
                // Refer issue - https://github.com/opensearch-project/OpenSearch/issues/15989
     */
            // Another shard copy owns the fence: this copy must never acknowledge another write. Treat as tragic so
    }
    private static BlobPath translogMetadataPath(
            throw new RuntimeException("Failed to acquire all permits", e);
    ) {
    private boolean syncToDisk() throws IOException {
        prepareAndUpload(primaryTermSupplier.getAsLong(), null);
        try (ReleasableLock lock = readLock.acquire()) {
            this.maxSeqNo = maxSeqNo;
            }
import java.util.Locale;
            // Only generations inside the remote range can be reused; everything else is removed, as the unconditional
                final Checkpoint checkpoint = readCheckpoint(location);
    private static RemoteStoreFence buildFence(
                    logger.debug("deleting non-generation file [{}] from translog directory before download", fileName);
            if (previousMinRemoteGenReferenced != minRemoteGenReferenced) {
    /**
        }
        translogTransferManager.delete();
 */
        // We use a dummy stats tracker to ensure the flow doesn't break.
                    if (generation < minGeneration || generation > maxGeneration) {
        long timestamp,
        this.isServerSideEncryptionEnabled = isServerSideEncryptionEnabled;
            throw new IllegalArgumentException(
        assert minReferencedGen >= getMinFileGeneration() : shardId
    }
    public void close() throws IOException {
                    persistedSequenceNumberConsumer
            // Update the global checkpoint only if the supplied global checkpoint is greater than it
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        }
        } finally {
        boolean isServerSideEncryptionEnabled
            return current.sync();
            // Writing remote in sync fashion doesn't hurt as global ckp update
                if (downloaded == false) {
            }
            }
    }
        // metadata listings and GC never see it) and is updated only via conditional writes.
    }
            blobStoreRepository,
            threadPool,
            indexSettings().isRemoteStoreFencingEnabled(),
            // resolve Index-level cryptoMetadata
        RemoteStorePathStrategy pathStrategy,
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
    private class RemoteFsTranslogTransferListener implements TranslogTransferListener {
        return minSeqNoToKeep;
    public boolean ensureSynced(Location location) throws IOException {
        // TODO: To be revisited as part of https://github.com/opensearch-project/OpenSearch/issues/7567
            );
            isServerSideEncryptionEnabled,
            "%s repository should be instance of BlobStoreRepository",
    protected final Semaphore remoteGenerationDeletionPermits = new Semaphore(REMOTE_DELETION_PERMITS);
     * {@code cluster.remote_store.translog.max_readers} setting
        }
     * This must not be called for a copy receiving a handoff from a live peer (primary relocation): the source is still
        ThreadPool threadPool,
import java.util.Map;
        logger.debug("Downloading translog files from remote");
            + getMinFileGeneration()
    protected final BooleanSupplier startedPrimarySupplier;
        RemoteStorePathStrategy pathStrategy,
            if (config.downloadRemoteTranslogOnInit()) {
        String fenceOwnerNodeId,
    // visible for testing
            // If local filesystem contains empty translog or no translog, we don't do anything.
        BlobStoreRepository blobStoreRepository = (BlobStoreRepository) repository;
        BlobPath mdPath = translogMetadataPath(blobStoreRepository, shardId, pathStrategy, remoteStoreSettings);
    boolean isRemoteGenerationDeletionPermitsAvailable() {
        );
        long prevDownloadBytesSucceeded = statsTracker.getDownloadBytesSucceeded();
import org.opensearch.common.util.io.IOUtils;
            }
 * The current impl uploads translog , ckp and metadata to remote store
        } catch (IOException e) {
                    syncPermit.release(SYNC_PERMIT);
                    location,
            throw ex;
        RemoteStorePathStrategy.ShardDataPathInput dataPathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
        int maxRemoteTlogReaders = translogTransferManager.getMaxRemoteTranslogReadersSettings();
            persistedSequenceNumberConsumer,
                    + " on another node. Use a repository whose store evaluates the precondition itself, such as s3."
import org.opensearch.core.util.FileSystemUtils;
            Files.copy(
            }
    private static boolean isEmptyTranslog(Checkpoint checkpoint) {
        return remoteGenerationDeletionPermits.availablePermits() == REMOTE_DELETION_PERMITS;
import org.opensearch.index.translog.transfer.TranslogCheckpointTransferSnapshot;
        ShardId shardId,
        long primaryTerm
        RemoteStoreSettings remoteStoreSettings,
            deleteStaleRemotePrimaryTerms();
            }
import org.opensearch.index.translog.transfer.TranslogFencedException;
        // caller without one (e.g. an offline tool constructing a TranslogConfig without an allocation id) must be
            try {
                // for instance if we have a lot of tlog and we can't create the writer we keep
            config,
                // The reconciliation loop below would silently do nothing and the translog.ckp copy at the end would
     */
        String shardIdStr = String.valueOf(shardId.id());
        String translogUUID,
import java.nio.file.Files;
     * <p>
 * SPDX-License-Identifier: Apache-2.0
                // continue till download retries
                    checkpoint.globalCheckpoint,
            // If we don't , we should swallow FileAlreadyExistsException while writing to remote store
    }
            false,
import org.opensearch.cluster.metadata.IndexMetadata;
    private void deleteRemoteGeneration(Set<Long> generations) {
        );
        boolean isTranslogMetadataEnabled,
            if (FileSystemUtils.exists(location.resolve(CHECKPOINT_FILE_NAME))) {
            throw ex;
    }
            && checkpoint.maxSeqNo == SequenceNumbers.NO_OPS_PERFORMED
            if (generation == null) {
        RemoteStoreSettings remoteStoreSettings,
                minRemoteGenReferenced
                String generation = Long.toString(i);
                blobStoreRepository,
        }
            blobStoreRepository.blobStore(isServerSideEncryptionEnabled),
                    logger.debug("translog closed");
            );
            + minReferencedGen
        // ReplicationTracker.primaryMode() as true. However, before we perform the `internal:index/shard/replication/segments_sync`
import java.util.Objects;
                    generationToChecksumMapper.get(generation)
        logger = Loggers.getLogger(getClass(), shardId);
        return minReferencedGen;
    public long getMinUnreferencedSeqNoInSegments(long minUnrefCheckpointInLastCommit) {
        this.remoteTranslogTransferTracker = remoteTranslogTransferTracker;
        if (location.generation == current.getGeneration()) {
        // During primary relocation, both the old and new primary have engine created with RemoteFsTranslog and having
            if (readers.isEmpty()) {
        if (startedPrimarySupplier.getAsBoolean() == false || syncPermit.tryAcquire(SYNC_PERMIT) == false) {
                    closeFilesIfNoPendingRetentionLocks();
            this.readers.addAll(recoverFromFiles(checkpoint));
            remoteStoreSettings,
            translogOperationHelper,
    }
        try {
    }
        }
        } catch (TranslogFencedException ex) {
    /**
        if (startedPrimarySupplier.getAsBoolean() == false || pauseSync.get()) {
            generationsToDelete.add(generation);
                );
            blobStoreRepository,
            deletionPolicy.minTranslogGenRequired(readers, current),
        );
    private volatile long maxRemoteTranslogGenerationUploaded;
            blobStoreRepository,
        Repository repository,
        String fenceOwnerAllocationId,
            deletionPolicy,
            long startTimeMs = System.currentTimeMillis();
            return;
                isServerSideEncryptionEnabled,
                // and registers a reused copy with its transfer tracker itself; there is no way to mark a generation
     * This will also delete all stale translog metadata files from remote except the latest basis the metadata file comparator.
                primaryTerm,
            }
                assert result && syncPermit.availablePermits() == 0;
    }
            isServerSideEncryptionEnabled,
        IndexMetadata indexMetadata = indexSettings.getIndexMetadata();
            if (syncPermit.tryAcquire(SYNC_PERMIT, 1, TimeUnit.MINUTES)) {
    private final boolean isTranslogMetadataEnabled;
            }
     * @param generations generations to be deleted.
        return false;
    }
                        current = createWriter(current.getGeneration() + 1);
        translogTransferManager.deleteGenerationAsync(
            threadPool,
        buildFence(
     * Sealing first is what makes the restore point trustworthy. A copy that read the restore point before claiming the
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = new RemoteTranslogTransferTracker(shardId, 1000);
        // Fails CLOSED, unlike the segment publish gate: a wrongly permitted delete is not recoverable, so an
     * <p>
        String fenceOwnerAllocationId,
        logger.trace("uploading translog for primary term {} generation {}", primaryTerm, generation);
        private final long globalCheckpoint;
        // unreadable fence skips the cleanup rather than proceeding with it.
    // Semaphore used to allow only single remote generation to happen at a time
        ThreadPool threadPool,
        RemoteFsTranslog.download(translogTransferManager, location, logger, seedRemote, timestamp);
            this.primaryTerm = primaryTerm;
                location.resolve(Translog.CHECKPOINT_FILE_NAME)
import java.util.HashSet;
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
    int availablePermits() {
    RemoteTranslogTransferTracker getRemoteTranslogTracker() {
}
    }
                });
            fenceOwnerNodeId,
            remoteTranslogTransferTracker,
    @Override
                .dataType(METADATA)
            logger.debug("No translog files found on remote, checking local filesystem for cleanup");
                new RemoteFsTranslogTransferListener(generation, primaryTerm, maxSeqNo, checkpoint.globalCheckpoint),
         */
                    closeOnTragicEvent(e);
            + "] which is higher than the current generation ["
            minGenerationForSeqNo(minSeqNoToKeep, current, readers)
            return translogTransferManager.transferSnapshot(
            fileTransferTracker,
                throw new IllegalStateException(
            // existence of translog.ckp file work in the same way
        Set<Long> generationsToDelete = new HashSet<>();
            return false;
import org.opensearch.index.translog.transfer.FileTransferTracker;
            (BlobStoreRepository) repository,
            indexSettings().getRemoteStorePathStrategy(),
    public RemoteFsTranslog(
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,
            logger.info(
            throw new IllegalArgumentException(
            pathStrategy,
    // the max global checkpoint that has been synced
        assert repository instanceof BlobStoreRepository : String.format(
        ThreadPool threadPool,
            generations,
import java.util.concurrent.TimeoutException;
            isTranslogMetadataEnabled,
            } else if (generation < current.getGeneration()) {
        // clean up all remote translog files
        // clean up local translog files and updates readers
        BlobPath mdPath = translogMetadataPath(blobStoreRepository, shardId, pathStrategy, remoteStoreSettings);
        logger.debug("downloadOnce execution completed");
    }
import java.util.concurrent.atomic.AtomicBoolean;
                download(translogTransferManager, location, logger, config.shouldSeedRemote(), 0);
            fileTransferTracker,
        return fileTransferTracker.allUploaded();
        }
        RemoteStoreSettings remoteStoreSettings,
                .indexUUID(shardId.getIndex().getUUID())
        boolean fencingEnabled,
                // fail with an opaque NoSuchFileException after the download retries; name the actual problem.
    public Set<String> allUploaded() {
        RemoteTranslogTransferTracker statsTracker = translogTransferManager.getRemoteTranslogTransferTracker();
        }
            Locale.ROOT,
        throw ex;
     * Checks whether or not the shard should be flushed based on translog files.
        return pathStrategy.generatePath(
        // that merely emulates the precondition in process would let two nodes both believe they hold the fence - worse
            .shardId(shardIdStr)
        this.translogTransferManager = buildTranslogTransferManager(
import org.opensearch.common.lease.Releasable;
     * network partition — still holds a valid CAS token and can therefore keep acknowledging writes that land after the
            // Do we need remote writes in sync fashion ?
        // are older files that are no longer needed and should be cleaned up. In here, we delete all files that are part
                if (seedRemote) {
            return current.syncNeeded()
            primaryTermSupplier,
    ) throws IOException {
                    + " but the translog repository does not support store-enforced conditional writes, so it cannot fence a writer"
        BlobStoreRepository blobStoreRepository,
            + currentFileGeneration()
        long timestamp
            + "]";
            .dataType(DATA)
            try {
                        maxSeqNo = getMaxSeqNo();
    // Visible for testing
            fence = buildFence(
                remoteGenerationDeletionPermits.release();
            throw ex;
                    // Here we are downgrading the write lock by acquiring the read lock and releasing the write lock
    protected void trimUnreferencedReaders(boolean onlyTrimLocal) throws IOException {
                // on holding
            config.getNodeId()
            return;
    protected void onMinRemoteGenReferencedChange() {
                try {
        ShardId shardId,
        ShardId shardId,
                Translog::getCommitCheckpointFileName,
        translogTransferManager.deleteTranslogFiles();
        // copy collecting garbage can remove files a legitimate owner is still recovering from. See FenceSegmentFlow.tla.
            remoteStoreSettings,
            RemoteStorePathStrategy.ShardDataPathInput.builder()
            remoteTranslogTransferTracker,
            throw new IllegalArgumentException(
    }
                globalCheckpointSynced = globalCheckpoint;
        if (generationsToDelete.isEmpty() == false) {
            boolean success = false;
         */
        super.trimUnreferencedReaders();
                } else {
     * @return {@code true} if the shard should be flushed
                } else {
            threadPool
            return false;
                // allocation id, the restore point was read with no live token held, and this instance re-adopts on
    protected volatile long globalCheckpointSynced;
            } else {
    private final Semaphore syncPermit = new Semaphore(SYNC_PERMIT);
 * this file be licensed under the Apache-2.0 license or a
            } else {
        );
            pathStrategy,
            transferService,
                    // This ensures that other threads can still acquire the read locks while also protecting the
                "Successfully uploaded translog for primary term = {}, generation = {}, maxSeqNo = {}, minRemoteGenReferenced = {}",
    private final Logger logger;
            // wipe this replaces did for every file. That includes the top-level translog.ckp, which is recreated from
                translogTransferManager.populateFileTrackerWithLocalState(this.readers);
        }
                }
        String indexUUID = shardId.getIndex().getUUID();
            );
        // 1. Using startedPrimarySupplier, we prevent the new primary to do pre-emptive syncs
        return translogTransferManager.revertFenceOwnership(primaryTermSupplier.getAsLong());
            threadPool,
     */
            + minReferencedGen
                    }
        boolean requireRecordedOwnership
            for (Path file : FileSystemUtils.files(location)) {
                if (closed.get() == false) {
        logger.trace(remoteTranslogTransferTracker.toString());
        FileTransferTracker fileTransferTracker,
            // leaves the directory without one, and with it the engine open fails, exactly as before.
        FileTransferTracker fileTransferTracker = new FileTransferTracker(shardId, remoteTranslogTransferTracker);
import org.opensearch.index.seqno.SequenceNumbers;
        Logger logger,
        assert minReferencedGen <= currentFileGeneration() : shardId
    protected final TranslogTransferManager translogTransferManager;
        LongSupplier primaryTermSupplier,
    }
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
         * Primary Term for the translog
                return;
            }
    }
                }
                || (maxRemoteTranslogGenerationUploaded + 1 < this.currentFileGeneration() && current.totalOperations() == 0)
    }
                        + maxGeneration
public class RemoteFsTranslog extends Translog implements RemoteStoreFenceOwnership {
                    readers.add(reader);
        }
        /*
            remoteStoreSettings,
        try (Releasable ignored = writeLock.acquire()) {
                    final TranslogReader reader = current.closeIntoReader();
        ThreadPool threadPool,
        boolean seedRemote,
    protected long getMinReferencedGen() throws IOException {
        BooleanSupplier startedPrimarySupplier,
        );
            if (ex instanceof IOException ioException) {
        }
            // and also verify for same during primary-primary relocation
            null
        Repository repository,
                pathStrategy,
    public void trimUnreferencedReaders() throws IOException {
            if (config.downloadRemoteTranslogOnInit() == false) {
        TranslogTransferManager translogTransferManager,
            // is not updated in remote translog except in primary to primary recovery.
     */
                shardId + " min seq number required can't go backwards: " + "current [" + this.minSeqNoToKeep + "] new [" + seqNo + "]"
            IOUtils.closeWhileHandlingException(current);
        /**
                ? translogMetadata.getGenerationToChecksumMapper()
            shardId
                "Downloaded translog and checkpoint files from={} to={}, generations already present locally={}",
            // First we delete all stale primary terms folders from remote store
        RemoteStorePathStrategy pathStrategy,
            } catch (FileNotFoundException | NoSuchFileException e) {
            translogTransferManager.deletePrimaryTermsAsync(minimumReferencedPrimaryTerm);
        boolean isServerSideEncryptionEnabled,
            .build();
        RemoteStorePathStrategy pathStrategy,
        try (Releasable ignored = readLock; Releasable ignoredGenLock = deletionPolicy.acquireTranslogGen(getMinFileGeneration())) {
        logger.info("Exhausted all download retries during translog/checkpoint file download");
                String errorMsg = String.format(Locale.ROOT, "%s at least one reader must be recovered", shardId);
     * fence would leave a window in which a previous primary — alive but no longer in the cluster's view, e.g. behind a
        ClusterService.assertClusterOrClusterManagerStateThread();
                location,
            TranslogCheckpointTransferSnapshot transferSnapshotProvider = new TranslogCheckpointTransferSnapshot.Builder(
                downloadOnce(translogTransferManager, location, logger, seedRemote, timestamp);
        // action which re-downloads the segments and translog on the new primary. We are ensuring 2 things here -
            current = null;
    ) throws IOException {
    ) throws IOException {
    public void sync() throws IOException {
    }
        // We use a dummy stats tracker to ensure the flow doesn't break.
    }
         */
        TranslogDeletionPolicy deletionPolicy,
        // clean up all remote translog files
        ).validateAndAdvance(primaryTerm);
            // We copy the latest generation .ckp file to translog.ckp so that flows that depend on
            blobStoreRepository,
    @Override
    // Visible for testing
                    readLock.acquire();
        isTranslogMetadataEnabled = indexSettings().isTranslogMetadataEnabled();
        String fenceOwnerNodeId,
                .fixedPrefix(remoteStoreSettings.getTranslogPathFixedPrefix())
            }
                } catch (IllegalStateException | IllegalArgumentException e) {
        try (ReleasableLock lock = readLock.acquire()) {
        RemoteTranslogTransferTracker tracker,
                // legitimately claimed it during that window and then serve from a restore point read before the
            );
import java.io.FileNotFoundException;
            // close the opened translog files if we fail to create a new translog...
    protected final AtomicBoolean pauseSync = new AtomicBoolean(false);
    public static void download(
            }
        this.minSeqNoToKeep = seqNo;
                primaryTerm,
                generation,
                .shardId(String.valueOf(shardId.id()))
        }
            if (Files.notExists(location)) {
    public void rollGeneration() throws IOException {
    /**
            } else {
            globalCheckpointSupplier,
        // than running unfenced, because the shard would report itself protected. Fail closed instead.
                    Files.delete(file);
                return Releasables.releaseOnce(() -> {
    @Override
            isTranslogMetadataEnabled,
                // The manager decides whether the local copy can be reused (footer checksum equals the advertised one)
            minRemoteGenReferenced = getMinFileGeneration();
            isTranslogMetadataEnabled,
    }
                    logger.info("Resumed remote translog sync back on relocation failure");
                    "remote translog metadata has min generation ["
        return syncPermit.availablePermits();
                maxSeqNo,
        return checkpoint.generation == checkpoint.minTranslogGeneration
        ShardId shardId,
            isServerSideEncryptionEnabled
            && checkpoint.minSeqNo == SequenceNumbers.NO_OPS_PERFORMED
                    logger.debug("Translog files exist on local without any metadata in remote, cleaning up these files");
                .build()
    private void deleteStaleRemotePrimaryTerms() {
        ShardId shardId,
    }
        TranslogConfig config,
    // min generation referred by last uploaded translog
                remoteStoreSettings,
        boolean isServerSideEncryptionEnabled
import java.nio.file.NoSuchFileException;
            return null;
                if (success == false) {
            remoteStoreSettings,
        // Store-enforced conditional writes only. The fence exists to exclude a writer on ANOTHER node, so a container
                logger.info("Skipping remote translog cleanup: a higher primary term has taken the remote store fence");
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
        RemoteStoreSettings remoteStoreSettings,
        boolean isServerSideEncryptionEnabled
    }
import org.opensearch.index.translog.transfer.TranslogTransferManager;
                    + fenceOwnerAllocationId
            prepareAndUpload(primaryTermSupplier.getAsLong(), null);
                // adoption until the source's explicit ownership transfer. Only the seal path itself (sealFence)
            shardId
        // acknowledgement path the fence CAS gates, so it is gated on this copy still owning the fence. A superseded
            CryptoMetadata cryptoMetadata = resolveCryptoMetadata();
        // Remote generations involves 2 async operations - 1) Delete translog generation files 2) Delete metadata files
        return new RemoteStoreFence(fenceContainer, fenceOwnerAllocationId, fenceOwnerNodeId, shardId, requireRecordedOwnership);
