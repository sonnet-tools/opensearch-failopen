                .build()  
    private volatile long minSeqNoToKeep;
                throw new IllegalStateException(errorMsg);
        this.remoteTranslogTransferTracker = remoteTranslogTransferTracker;  
            persistedSequenceNumberConsumer,  
                    + "], node id ["
            if (readers.isEmpty()) {
                    "remote translog metadata has min generation ["  
    }
    }
                    Translog.createEmptyTranslog(location, translogTransferManager.getShardId(), checkpoint);
            transferService,
    protected boolean upload(long primaryTerm, long generation, long maxSeqNo) throws IOException {
import org.opensearch.cluster.service.ClusterService;
            IOUtils.closeWhileHandlingException(readers);
            );
        // Deleting remote generations mutates state shared with any other live copy of this shard, and is not on the
            try {
        Path location,  
                    sync();
    private void deleteStaleRemotePrimaryTerms() {  
        RemoteStorePathStrategy pathStrategy,  
            isTranslogMetadataEnabled,  
                    final TranslogReader reader = current.closeIntoReader();
            null
            fileTransferTracker,
                    + fenceOwnerAllocationId
        throws IOException {  
        TranslogTransferManager translogTransferManager = buildTranslogTransferManager(
            + "] but the lowest gen available is ["
        } catch (TranslogFencedException ex) {  
    private boolean syncToDisk() throws IOException {
    @Override
        }  
        String fenceOwnerAllocationId,
     * @param generations generations to be deleted.
    protected final AtomicBoolean pauseSync = new AtomicBoolean(false);
                    // Here we are downgrading the write lock by acquiring the read lock and releasing the write lock  
        ShardId shardId,  
    }
            pathStrategy,  
                // Every translog instance requires RECORDED OWNERSHIP to arbitrate an existing equal-term path, not
                skipped  
    // Semaphore used to allow only single remote generation to happen at a time
                    + fenceOwnerNodeId  
                    closeFilesIfNoPendingRetentionLocks();
        String fenceOwnerAllocationId,  
        RemoteStoreSettings remoteStoreSettings,
            + currentFileGeneration()  
        boolean isServerSideEncryptionEnabled
                ? translogMetadata.getGenerationToChecksumMapper()
        assert repository instanceof BlobStoreRepository : String.format(  
    private void deleteRemoteGeneration(Set<Long> generations) {
            blobStoreRepository,
            isServerSideEncryptionEnabled,
    protected static final int REMOTE_DELETION_PERMITS = 2;
            long maxGeneration = translogMetadata.getGeneration();  
                throw new IllegalStateException(
            if (globalCheckpoint > globalCheckpointSynced) {
            logger.debug("skipped uploading translog for {} {} syncPermits={}", primaryTerm, generation, syncPermit.availablePermits());
            } else {
        if (fenceOwnerAllocationId == null || fenceOwnerNodeId == null) {
            int skipped = 0;
            channelFactory
        String shardIdStr = String.valueOf(shardId.id());
     * @return {@code true} if the shard should be flushed
                config.getNodeId()
    private final boolean isTranslogMetadataEnabled;
                    }
        /**  
                translogMetadata.getMinTranslogGeneration(),
    }
            globalCheckpointSupplier,
                : Map.of();
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = new RemoteTranslogTransferTracker(shardId, 1000);
        if (olderPrimaryCleaned.trySet(Boolean.TRUE)) {
                    // This ensures that other threads can still acquire the read locks while also protecting the
            );
            closeOnTragicEvent(ex);  
    protected void setMinSeqNoToKeep(long seqNo) {
        return checkpoint.generation == checkpoint.minTranslogGeneration  
        } catch (IOException e) {
            } else if (generation < current.getGeneration()) {  
            RemoteStorePathStrategy.ShardDataPathInput.builder()
            if (fileTransferTracker.uploaded(Translog.getFilename(generation)) == false) {  
        While translog files are getting downloaded by new primary, it might hence be deleted by the primary  
            minGenerationForSeqNo(minSeqNoToKeep, current, readers)
            .build();  
                Translog::getCommitCheckpointFileName,
        // clean up local translog files and updates readers  
                // recovery seal (sealFence below) claimed via a throwaway instance and recorded this copy's
        // Store-enforced conditional writes only. The fence exists to exclude a writer on ANOTHER node, so a container
     * implicitly that minimum primary term in latest translog metadata in remote store is the current primary term.
                fenceOwnerNodeId,
            remoteStoreSettings,
    @Override  
            } else {  
    @Override
        RemoteStorePathStrategy pathStrategy,  
    }  
         */
        }
                // The manager decides whether the local copy can be reused (footer checksum equals the advertised one)
        BlobStoreTransferService transferService = new BlobStoreTransferService(  
            throw new IllegalArgumentException(  
                "Downloaded translog and checkpoint files from={} to={}, generations already present locally={}",  
                    if (generation < minGeneration || generation > maxGeneration) {
import java.util.function.LongSupplier;  
        if (current.totalOperations() == 0 && primaryTermSupplier.getAsLong() == current.getPrimaryTerm()) {
            .indexUUID(indexUUID)
            pathStrategy,
    private static RemoteStoreFence buildFence(
            return null;
        // acknowledgement path the fence CAS gates, so it is gated on this copy still owning the fence. A superseded
import java.nio.file.NoSuchFileException;
    @Override  
            remoteStoreSettings,
    static void download(TranslogTransferManager translogTransferManager, Path location, Logger logger, boolean seedRemote, long timestamp)
     * This method must be called only after there are valid generations to delete in trimUnreferencedReaders as it ensures
        // We use a dummy stats tracker to ensure the flow doesn't break.  
    }  
        long minReferencedGen = Math.min(  
            blobStoreRepository.blobStore(isServerSideEncryptionEnabled),
        }
        );
                true  
        long primaryTerm
                // legitimately claimed it during that window and then serve from a restore point read before the
    }
            // resolve Index-level cryptoMetadata
            primaryTermSupplier.getAsLong(),  
        syncBeforeRollGeneration();  
            tracker,
            deletionPolicy,  
            tracker,  
        This doesn't happen in last download , where it is ensured that older primary has stopped modifying tlog data.  
    }
            if (syncPermit.tryAcquire(SYNC_PERMIT, 1, TimeUnit.MINUTES)) {
        translogTransferManager.delete();  
                    + " on another node. Use a repository whose store evaluates the precondition itself, such as s3."
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;  
                        current = createWriter(current.getGeneration() + 1);  
import java.util.concurrent.atomic.AtomicBoolean;  
        }
        // Fail fast at the single fence-construction funnel: the fence records the owning copy's identity, and a
                // as present without that check.  
                .dataCategory(TRANSLOG)  
            Files.copy(
            .dataType(DATA)
                } catch (final Exception e) {
import org.opensearch.common.logging.Loggers;
     * @opensearch.internal
                    assert writeLock.isHeldByCurrentThread() : "Write lock must be held before we acquire the read lock";
        ThreadPool threadPool,
    }
            }  
        // TODO: To be revisited as part of https://github.com/opensearch-project/OpenSearch/issues/7567  
    protected boolean shouldFlush() {
                // for instance if we have a lot of tlog and we can't create the writer we keep  
    public static void sealFence(  
        FileTransferTracker fileTransferTracker,
     * This must not be called for a copy receiving a handoff from a live peer (primary relocation): the source is still
            shardId,
        logger.debug("Downloading translog files from remote");
        }  
    @Override
                generation,
         */
            shardId  
        }
    public long getMinUnreferencedSeqNoInSegments(long minUnrefCheckpointInLastCommit) {
            try {  
        RemoteFsTranslogTransferListener(long generation, long primaryTerm, long maxSeqNo, long globalCheckpoint) {
                // we have to close all the recovered ones otherwise we leak file handles here
    public static void download(
 */
    @Override
            throw new IllegalArgumentException(  
            if (closed.compareAndSet(false, true)) {
                } else {  
    ) {  
        );
            throw ex;
            // and also verify for same during primary-primary relocation  
 * SPDX-License-Identifier: Apache-2.0
        );  
            null,
        // than running unfenced, because the shard would report itself protected. Fail closed instead.
    // clean up translog folder uploaded by previous primaries once
            Checkpoint checkpoint = readCheckpoint(location);
        boolean isServerSideEncryptionEnabled,
        /*
        ).validateAndAdvance(primaryTerm);  
        } catch (Exception e) {
        boolean seedRemote,
                });  
                        maxSeqNo = getMaxSeqNo();
        TranslogConfig config,  
    /**
            // the engine fails the shard instead of retrying the upload. The translog is closed by the caller, once
     * fence would leave a window in which a previous primary — alive but no longer in the cluster's view, e.g. behind a
        }
        return syncPermit.availablePermits();
            if (ex instanceof IOException ioException) {  
        }  
            mdPath,
        RemoteStorePathStrategy pathStrategy,  
    /**
        translogTransferManager.transferFenceOwnership(primaryTermSupplier.getAsLong(), targetAllocationId);  
    }  
        );
        RemoteStoreSettings remoteStoreSettings,
            } else {
            Map<String, String> generationToChecksumMapper = translogMetadata.getGenerationToChecksumMapper() != null  
import org.opensearch.common.blobstore.BlobContainer;  
                    skipped++;
import java.util.HashSet;
            isServerSideEncryptionEnabled  
    public boolean ensureSynced(Location location) throws IOException {
                String fileName = file.getFileName().toString();
        if (fenceContainer.isConditionalWriteSupported() == false) {
        CryptoMetadata cryptoMetadata = CryptoMetadata.fromIndexSettings(indexMetadata.getSettings());  
                download(translogTransferManager, location, logger, config.shouldSeedRemote(), 0);
            shardId
            remoteGenerationDeletionPermits::release
     * Sealing first is what makes the restore point trustworthy. A copy that read the restore point before claiming the
        LongConsumer persistedSequenceNumberConsumer,
                remoteGenerationDeletionPermits.release();
            .fixedPrefix(remoteStoreSettings.getTranslogPathFixedPrefix())
            long minGeneration = translogMetadata.getMinTranslogGeneration();
 */  
    ) throws IOException {  
 * A Translog implementation which syncs local FS with a remote store
        BlobStoreRepository blobStoreRepository = (BlobStoreRepository) repository;
    }  
    public static void cleanup(  
                    logger.debug("Empty translog on local, skipping clean-up");
import java.nio.file.Path;  
import java.util.Set;
        RemoteStoreSettings remoteStoreSettings,
            }
        RemoteStorePathStrategy pathStrategy,
    }  
        try (ReleasableLock lock = readLock.acquire()) {  
        this.minSeqNoToKeep = seqNo;
            (BlobStoreRepository) repository,
        assert readLock.isHeldByCurrentThread() == true;
 * created.
            logger.info("Downloaded data from remote translog till maxSeqNo = {}", checkpoint.maxSeqNo);
     */
        ClusterService.assertClusterOrClusterManagerStateThread();
                );
        }
            remoteStoreSettings,  
            blobStoreRepository,
        ) {
        assert location.generation <= current.getGeneration();
            return;
        ThreadPool threadPool,  
            // close the opened translog files if we fail to create a new translog...
        RemoteTranslogTransferTracker tracker,
        LongSupplier primaryTermSupplier,
                remoteStoreSettings,
                    generationToPrimaryTermMapper.get(generation),
    ) {
        assert Objects.nonNull(pathStrategy);
            pathStrategy,
    }
        // action which re-downloads the segments and translog on the new primary. We are ensuring 2 things here -
    }
        boolean isTranslogMetadataEnabled,  
    }
            return current.syncNeeded()
        try (
        }
            remoteTranslogTransferTracker,  
        private final long primaryTerm;
    protected volatile long minRemoteGenReferenced;
                pathStrategy,  
     *  
            "%s repository should be instance of BlobStoreRepository",
                    logger.debug("translog closed");  
        if (remoteGenerationDeletionPermits.tryAcquire(REMOTE_DELETION_PERMITS) == false) {
        return minReferencedGen;
                readers,  
        // The fence lives alongside the translog metadata files (its name does not match the metadata prefix, so
            );
        logger.info("Exhausted all download retries during translog/checkpoint file download");
            fence  
            Checkpoint checkpoint = current.getLastSyncedCheckpoint();
        RemoteTranslogTransferTracker statsTracker = translogTransferManager.getRemoteTranslogTransferTracker();
            generations,
}  
                // on to all the uncommitted tlog files if we don't close
    }
            + "]";
        }
public class RemoteFsTranslog extends Translog implements RemoteStoreFenceOwnership {
            // in-place snapshot restore) must be able to take over a dead incumbent's path, whose recorded owner it  
                        Files.delete(file);
        TranslogOperationHelper translogOperationHelper,
        BlobContainer fenceContainer = blobStoreRepository.blobStore(isServerSideEncryptionEnabled).blobContainer(mdPath);
            ensureOpen();
    protected void onMinRemoteGenReferencedChange() {
    @Override  
            // If we don't , we should swallow FileAlreadyExistsException while writing to remote store
                } catch (IllegalStateException | IllegalArgumentException e) {
        );
                if (success == false) {  
import org.opensearch.index.translog.transfer.RemoteStoreFence;
        RemoteStorePathStrategy pathStrategy,
            translogUUID,
        return remoteGenerationDeletionPermits.availablePermits() == REMOTE_DELETION_PERMITS;
        LongSupplier globalCheckpointSupplier,  
         */
            );
        // 2. Using syncPermits, we prevent syncs at the desired time during primary relocation.  
                cryptoMetadata  
            return current.sync();  
        } else {
            IOUtils.closeWhileHandlingException(current);  
                }
            dataPath,  
        long maxSeqNo = -1;  
            deleteStaleRemotePrimaryTerms();  
    public void trimUnreferencedReaders() throws IOException {
                // The reconciliation loop below would silently do nothing and the translog.ckp copy at the end would  
                .fixedPrefix(remoteStoreSettings.getTranslogPathFixedPrefix())
            // NO-OP  
        Repository repository,
                } else if (isEmptyTranslog(checkpoint) == false) {
        boolean isServerSideEncryptionEnabled,  
            isTranslogMetadataEnabled,
        return minSeqNoToKeep;
        RemoteStorePathStrategy pathStrategy,
            }
                success = true;
            maxRemoteTranslogGenerationUploaded = generation;
    ) throws IOException {
            threadPool,  
                }
        RemoteStoreSettings remoteStoreSettings,
            throw ex;
        IndexMetadata indexMetadata = indexSettings.getIndexMetadata();
            isTranslogMetadataEnabled,
import org.opensearch.index.translog.transfer.TranslogFencedException;
                shardId + " min seq number required can't go backwards: " + "current [" + this.minSeqNoToKeep + "] new [" + seqNo + "]"
        assert minReferencedGen <= currentFileGeneration() : shardId
import java.util.concurrent.Semaphore;  
                "Remote store fencing is enabled for "
        FileTransferTracker fileTransferTracker = new FileTransferTracker(shardId, remoteTranslogTransferTracker);
                    + "]); fencing requires the copy identity that only a live shard supplies"
                    IOUtils.closeWhileHandlingException(readers);
    protected final SetOnce<Boolean> olderPrimaryCleaned = new SetOnce<>();
    /**  
import org.opensearch.index.remote.RemoteStorePathStrategy;  
import org.opensearch.repositories.Repository;
                .dataType(METADATA)
    // Visible for testing  
import org.opensearch.index.translog.transfer.BlobStoreTransferService;  
        }
        RemoteStoreSettings remoteStoreSettings
                "Remote store fencing is enabled for "
        boolean seedRemote,
                final Checkpoint checkpoint = readCheckpoint(location);
        if (maxRemoteTlogReaders == -1) {
    protected final BooleanSupplier startedPrimarySupplier;
        logger.trace("uploading translog for primary term {} generation {}", primaryTerm, generation);  
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
            throw new RuntimeException("Failed to acquire all permits", e);
    private volatile long maxRemoteTranslogGenerationUploaded;  
            // Only generations inside the remote range can be reused; everything else is removed, as the unconditional
                    persistedSequenceNumberConsumer
            config,
 * The current impl uploads translog , ckp and metadata to remote store
        // We use a dummy stats tracker to ensure the flow doesn't break.
            shardId,  
            false
            this.primaryTerm = primaryTerm;
                transferSnapshotProvider,
 *
        assert repository instanceof BlobStoreRepository : "repository should be instance of BlobStoreRepository";  
            this.generation = generation;  
        // Fails CLOSED, unlike the segment publish gate: a wrongly permitted delete is not recoverable, so an
                if (seedRemote) {  
            // Do we need remote writes in sync fashion ?
        for (int i = 0; i <= DOWNLOAD_RETRIES; i++) {  
        RemoteTranslogTransferTracker tracker,
    private final boolean isServerSideEncryptionEnabled;  
     * This checks if number of translog files breaches the threshold count determined by  
        // copy collecting garbage can remove files a legitimate owner is still recovering from. See FenceSegmentFlow.tla.  
            return false;
            boolean success = false;  
    @Override  
    private static BlobPath translogMetadataPath(
            // The seal arbitrates UNGUARDED: a brand-new legitimate incarnation (failover promotion, store recovery,
        String fenceOwnerAllocationId,
                    location,
    // Visible for testing
        RemoteStoreFence fence = null;
package org.opensearch.index.translog;
        ThreadPool threadPool,
     * @throws TranslogFencedException if another copy already owns the fence at a higher term
            return prepareAndUpload(primaryTermSupplier.getAsLong(), location.generation);
            }  
    private static boolean isEmptyTranslog(Checkpoint checkpoint) {
        throw ex;  
        assert minReferencedGen >= getMinFileGeneration() : shardId
                // The below condition on GCP exists to handle global checkpoint updates during close index.  
     * legitimately serving at the same term, and sealing would fence it mid-handoff.
import org.apache.logging.log4j.Logger;
            return;
    // visible for testing  
                    checkpoint.generation + 1,
    public static TranslogTransferManager buildTranslogTransferManager(  
import org.opensearch.common.blobstore.BlobPath;
                } else {  
            return false;
         * Primary Term for the translog  
        // unreadable fence skips the cleanup rather than proceeding with it.
import java.util.Locale;
            // When a new writer is created the  
            + "] which is higher than the current generation ["
            if (previousMinRemoteGenReferenced != minRemoteGenReferenced) {
                    tragedy.setTragicException(e);
                throw (RuntimeException) ex;  
                    generationToChecksumMapper.get(generation)
        }  
            );
    protected void trimUnreferencedReaders(boolean onlyTrimLocal) throws IOException {
        } finally {
        super.trimUnreferencedReaders();
        }
        public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) throws IOException {
    public boolean syncNeeded() {
            fenceOwnerAllocationId,  
            throw new IllegalArgumentException(
            // Update the global checkpoint only if the supplied global checkpoint is greater than it
            remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
    public RemoteFsTranslog(
            // If local filesystem contains non-empty translog, we clean up these files and create empty translog.
import org.opensearch.core.index.shard.ShardId;
        BlobStoreRepository blobStoreRepository,  
 * for every sync, post syncing to disk. Post that, a new generation is  
                        + "]"
            if (generation == null || generation == current.getGeneration()) {
        // clean up all remote translog files
            if (generation == null) {  
        }
            Locale.ROOT,
        boolean isServerSideEncryptionEnabled
    }  
        } catch (TimeoutException | InterruptedException e) {
                try {
        RemoteFsTranslog.download(translogTransferManager, location, logger, seedRemote, timestamp);  
                );
        logger.trace(remoteTranslogTransferTracker.toString());
                // continue till download retries
                // its first upload. Unguarded, the re-adoption would take the chain back from an equal-term twin that  
                return;  
import java.util.concurrent.TimeoutException;
                // Release permit that is meant for metadata files and return
        private final long globalCheckpoint;  
            // The tragic exception is set by upload(); close here, where the resources of the try-with-resources above
            }
                );  
            }  
            translogTransferManager.deleteStaleTranslogMetadataFilesAsync(remoteGenerationDeletionPermits::release);
                        + maxGeneration  
            // the latest generation's checkpoint once every generation is in place; a download that fails before then
                    syncPermit.release(SYNC_PERMIT);
     */
     * TranslogTransferListener implementation for RemoteFsTranslog  
            .basePath(blobStoreRepository.basePath())  
import java.util.Objects;
            isTranslogMetadataEnabled,
        boolean isServerSideEncryptionEnabled,  
        boolean isTranslogMetadataEnabled,
            } finally {
                    logger.info("Resumed remote translog sync back on relocation failure");
        return translogTransferManager.isFenceSuperseded(primaryTermSupplier.getAsLong());
        );
        Repository repository,  
        if (syncToDisk() || syncNeeded()) {  
        try (ReleasableLock lock = readLock.acquire()) {
        long timestamp,  
    private CryptoMetadata resolveCryptoMetadata() {
        BlobPath dataPath = pathStrategy.generatePath(dataPathInput);
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
                    assert wasSyncPaused : "RemoteFsTranslog sync was not paused before re-enabling it";
        String fenceOwnerNodeId,
                }
            + getMinFileGeneration()  
        boolean isTranslogMetadataEnabled,
        RemoteStorePathStrategy pathStrategy,
        String translogUUID,
            );  
        for (long generation = minRemoteGenReferenced - 1 - indexSettings().getRemoteTranslogExtraKeep(); generation >= 0; generation--) {
                logger.info("Skipping remote translog cleanup: a higher primary term has taken the remote store fence");
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = new RemoteTranslogTransferTracker(shardId, 1000);
                location,
    ) throws IOException {  
    }
            // is not updated in remote translog except in primary to primary recovery.
        );  
            }  
import org.opensearch.index.translog.transfer.FileTransferTracker;
        try (ReleasableLock lock = writeLock.acquire()) {
        if (onlyTrimLocal) {  
        String indexUUID = shardId.getIndex().getUUID();  
    protected final Semaphore remoteGenerationDeletionPermits = new Semaphore(REMOTE_DELETION_PERMITS);
            );
        private final long generation;  
                // and registers a reused copy with its transfer tracker itself; there is no way to mark a generation
                        logger.trace("Creating new writer for gen: [{}]", current.getGeneration() + 1);
         * Generation for the translog
        translogTransferManager.deleteTranslogFiles();  
                    Files.delete(file);  
            minRemoteGenReferenced = getMinFileGeneration();
                minRemoteGenReferenced  
            }
                current = createWriter(  
                }  
            shardId,
            remoteStoreSettings,
     * Returns <code>true</code> if an fsync and/or remote transfer is required to ensure durability of the translogs operations or it's metadata.  
        Logger logger,  
                return;  
                    return upload(primaryTerm, current.getGeneration(), maxSeqNo);
            "%s repository should be instance of BlobStoreRepository",  
                || (current.getLastSyncedCheckpoint().globalCheckpoint > globalCheckpointSynced);
    // Visible for testing
    protected long getMinReferencedGen() throws IOException {
    }  
    private static void downloadOnce(  
import java.io.FileNotFoundException;
        boolean isTranslogMetadataEnabled,
    private static final int SYNC_PERMIT = 1;
                maxSeqNo,
        // metadata listings and GC never see it) and is updated only via conditional writes.
                } finally {
                logger.trace("downloadOnce success={} timeElapsed={}", success, (System.currentTimeMillis() - startTimeMs));
            fileTransferTracker,
        }  
     * Checks whether or not the shard should be flushed based on translog files.
        RemoteStorePathStrategy.ShardDataPathInput dataPathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
        BlobStoreRepository blobStoreRepository = (BlobStoreRepository) repository;
        // TODO: To be revisited as part of https://github.com/opensearch-project/OpenSearch/issues/7567
            }  
import java.util.function.LongConsumer;
            blobStoreRepository,  
        }  
                shardId,
    }
    boolean isRemoteGenerationDeletionPermitsAvailable() {
            }  
                try {  
                    + shardId
                String generation = Long.toString(i);  
        // This enables us to restore translog from the metadata in case of failover or relocation.  
            && checkpoint.maxSeqNo == SequenceNumbers.NO_OPS_PERFORMED
            TranslogCheckpointTransferSnapshot transferSnapshotProvider = new TranslogCheckpointTransferSnapshot.Builder(
                primaryTerm,  
            indexSettings().getRemoteStorePathStrategy(),
    private class RemoteFsTranslogTransferListener implements TranslogTransferListener {
                if (downloaded == false) {
            config.getNodeId()
    protected Releasable drainSync() {  
    private final Semaphore syncPermit = new Semaphore(SYNC_PERMIT);  
                String errorMsg = String.format(Locale.ROOT, "%s at least one reader must be recovered", shardId);
            return;
                if (closed.get() == false) {
        /**
        );
        String fenceOwnerNodeId  
        FileTransferTracker fileTransferTracker = new FileTransferTracker(shardId, remoteTranslogTransferTracker);  
                        + minGeneration
    private final RemoteTranslogTransferTracker remoteTranslogTransferTracker;
                }
    }
        }
        prepareAndUpload(primaryTermSupplier.getAsLong(), null);
                    if (closed.get() == false) {
            threadPool,
        BlobStoreRepository blobStoreRepository,
    ) throws IOException {
            long startTimeMs = System.currentTimeMillis();
            remoteStoreSettings,
            isServerSideEncryptionEnabled,
                return;  
        Path location,
        BlobPath mdPath = translogMetadataPath(blobStoreRepository, shardId, pathStrategy, remoteStoreSettings);  
            fence = buildFence(  
        );  
        logger = Loggers.getLogger(getClass(), shardId);
            }
            threadPool,
                isServerSideEncryptionEnabled,
            if (isRemoteStoreFenceSuperseded()) {
     */
                try {  
                    boolean wasSyncPaused = pauseSync.getAndSet(false);
                    + " but the translog repository does not support store-enforced conditional writes, so it cannot fence a writer"  
        Set<Long> generationsToDelete = new HashSet<>();
                logger.trace("Translog reader list is empty, returning from deleteStaleRemotePrimaryTerms");  
        if (translogMetadata != null) {  
    // min generation referred by last uploaded translog
        if (location.generation == current.getGeneration()) {  
            throw ex;  
            + " deletion policy requires a minReferenceGen of ["  
import org.opensearch.index.translog.transfer.TranslogCheckpointTransferSnapshot;
            translogOperationHelper,
            } catch (FileNotFoundException | NoSuchFileException e) {
        Repository repository,
    }  
    public boolean revertFenceOwnership() throws IOException {
    int availablePermits() {  
        }  
            isServerSideEncryptionEnabled
            } finally {
                .indexUUID(shardId.getIndex().getUUID())
        boolean fencingEnabled,
        // clean up all remote translog files
    }
        }
    public boolean isRemoteStoreFenceSuperseded() throws IOException {  
        // During primary relocation, both the old and new primary have engine created with RemoteFsTranslog and having
            throw e;
            }
            // Another shard copy owns the fence: this copy must never acknowledge another write. Treat as tragic so  
        @Override
    @Override
                logger.info("All inflight remote translog syncs finished and further syncs paused");
        int maxRemoteTlogReaders = translogTransferManager.getMaxRemoteTranslogReadersSettings();  
        ShardId shardId,
    protected volatile long globalCheckpointSynced;
     * <p>  
import org.opensearch.common.lease.Releasables;  
                blobStoreRepository,
    }
     * <br>  
        try (Releasable ignored = readLock; Releasable ignoredGenLock = deletionPolicy.acquireTranslogGen(getMinFileGeneration())) {  
                    logger.debug("Translog files exist on local without any metadata in remote, cleaning up these files");  
        // store.
            this.readers.addAll(recoverFromFiles(checkpoint));  
    ) {
            isServerSideEncryptionEnabled,
 *
        }  
            + " deletion policy requires a minReferenceGen of ["  
import org.opensearch.common.util.concurrent.ReleasableLock;
        return new TranslogTransferManager(  
                boolean downloaded = translogTransferManager.downloadTranslogIfChanged(
            shardId,
        return new RemoteStoreFence(fenceContainer, fenceOwnerAllocationId, fenceOwnerNodeId, shardId, requireRecordedOwnership);
     * <p>  
        } else {
                // adoption until the source's explicit ownership transfer. Only the seal path itself (sealFence)
                    return upload(primaryTerm, current.getGeneration() - 1, maxSeqNo);
                throw ioException;
        super(  
        Logger logger,  
        }  
        }  
import org.opensearch.common.SetOnce;
        boolean requireRecordedOwnership  
            // (notably the read lock) have already been released - closeOnTragicEvent acquires the write lock.
        if (seqNo < this.minSeqNoToKeep) {  
            shardId,
            // existence of translog.ckp file work in the same way  
                onMinRemoteGenReferencedChange();
                // fail with an opaque NoSuchFileException after the download retries; name the actual problem.
        ChannelFactory channelFactory,  
                break;
        boolean isServerSideEncryptionEnabled
                translogTransferManager.populateFileTrackerWithLocalState(this.readers);
                "Successfully uploaded translog for primary term = {}, generation = {}, maxSeqNo = {}, minRemoteGenReferenced = {}",
    private final Logger logger;
                downloadOnce(translogTransferManager, location, logger, seedRemote, timestamp);
            ).build()  
            if (config.downloadRemoteTranslogOnInit()) {
    }  
    /**
     */  
            logger.warn("Could not determine remote store fence ownership; skipping remote translog cleanup", e);  
        private final long maxSeqNo;
        ShardId shardId,
        }  
        // This is to ensure that after the permits are acquired during primary relocation, there are no further modification on remote
    }
        IOException ex = null;
                    // Creating empty translog will cleanup the older un-referenced tranlog files, we don't have to explicitly delete
                // proves the guard restores NoAckedWriteLoss. For a relocation target the same check is what defers  
            deletionPolicy.minTranslogGenRequired(readers, current),
        }  
        // rejected here, at the source, rather than by a bare requireNonNull deep inside RemoteStoreFence.
                    generation,  
            logger.debug(
        RemoteStoreSettings remoteStoreSettings,
                success = true;  
    }  
                fenceOwnerAllocationId,  
            && checkpoint.numOps == 0;  
            + "]";
    }
            long minimumReferencedPrimaryTerm = readers.stream().map(BaseTranslogReader::getPrimaryTerm).min(Long::compare).get();
     * Claims the fence for this shard copy at {@code primaryTerm}, before the caller reads its translog restore point.
            generationsToDelete.add(generation);  
        BlobStoreRepository blobStoreRepository,
        TranslogDeletionPolicy deletionPolicy,
        return fileTransferTracker.allUploaded();
            syncPermit.release(SYNC_PERMIT);  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
                    if (closed.get() == false) {
            // can never match. This is the first of the two claims; the translog instance's guarded re-adoption is the second.
            if (minGeneration > maxGeneration) {
                location.resolve(Translog.getCommitCheckpointFileName(translogMetadata.getGeneration())),
        ThreadPool threadPool,
        return pathStrategy.generatePath(
import org.opensearch.threadpool.ThreadPool;  
 * @opensearch.internal  
        try {  
    private static final int DOWNLOAD_RETRIES = 2;
                    throw e;
            false,  
            remoteTranslogTransferTracker,  
    public void rollGeneration() throws IOException {
    }
                    }  
            }  
    @Override
        }
            // If local filesystem contains empty translog or no translog, we don't do anything.
                // Refer issue - https://github.com/opensearch-project/OpenSearch/issues/15989
    @Override  
    }
        try {
            + minReferencedGen
        long timestamp
            logger.debug("No translog files found on remote, checking local filesystem for cleanup");  
/*  
            closeOnTragicEvent(ex);
    }  
        ShardId shardId,  
                    + shardId
        try {  
        RemoteStoreSettings remoteStoreSettings,
                location.resolve(Translog.CHECKPOINT_FILE_NAME)  
        ShardId shardId,  
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
        FileTransferTracker fileTransferTracker,
    }
                throw new TimeoutException("Timeout while acquiring all permits");
     * Deletes remote translog and metadata files asynchronously corresponding to the generations.
                    long generation = parseIdFromFileName(fileName, STRICT_TLOG_OR_CKP_PATTERN);  
import org.opensearch.cluster.metadata.CryptoMetadata;
        } catch (TranslogFencedException ex) {
        if (indexMetadata == null) {  
        long prevDownloadTimeInMillis = statsTracker.getTotalDownloadTimeInMillis();
        }
                    readers.add(reader);
        return cryptoMetadata;
     * network partition — still holds a valid CAS token and can therefore keep acknowledging writes that land after the  
            }
/**  
                globalCheckpointSynced = globalCheckpoint;
            + "Translog.close method is called from inside Translog, but not via closeOnTragicEvent method";  
     * {@code cluster.remote_store.translog.max_readers} setting
        In Primary to Primary relocation , there can be concurrent upload and download of translog.
            // Writing remote in sync fashion doesn't hurt as global ckp update
            if (readers.isEmpty()) {
        TranslogTransferManager translogTransferManager = buildTranslogTransferManager(  
        assert repository instanceof BlobStoreRepository : String.format(
import org.opensearch.index.translog.transfer.TranslogTransferManager;  
        BlobStoreRepository blobStoreRepository,
        BooleanSupplier startedPrimarySupplier,
    public static TranslogTransferManager buildTranslogTransferManager(  
            }
        ShardId shardId,  
        if (startedPrimarySupplier.getAsBoolean() == false || syncPermit.tryAcquire(SYNC_PERMIT) == false) {
                }
            return translogTransferManager.transferSnapshot(  
        return remoteTranslogTransferTracker;
            logger.info(
        public void onUploadComplete(TransferSnapshot transferSnapshot) throws IOException {
import org.opensearch.indices.RemoteStoreSettings;  
            && checkpoint.minSeqNo == SequenceNumbers.NO_OPS_PERFORMED
        // cleans up remote translog files not referenced in latest uploaded metadata.
            return;
    // These permits exist to allow any inflight background triggered upload.
                }
        translogTransferManager.deleteGenerationAsync(
        this.translogTransferManager = buildTranslogTransferManager(
        try (Releasable ignored = writeLock.acquire()) {
    protected final FileTransferTracker fileTransferTracker;  
    public void close() throws IOException {
        this.startedPrimarySupplier = startedPrimarySupplier;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.index.seqno.SequenceNumbers;
                    // readers and writer to not be mutated any further.
    }
     *
            .shardId(shardIdStr)
            }  
            // First we delete all stale primary terms folders from remote store  
        TranslogTransferManager translogTransferManager,
                    }  
 * this file be licensed under the Apache-2.0 license or a
            }  
                return;
    // the max global checkpoint that has been synced
                    copyCheckpointTo(location.resolve(getCommitCheckpointFileName(current.getGeneration())));  
            Map<String, String> generationToPrimaryTermMapper = translogMetadata.getGenerationToPrimaryTermMapper();
            for (long i = maxGeneration; i >= minGeneration; i--) {
            pathStrategy,  
    ) throws IOException {
    public Set<String> allUploaded() {  
        } catch (final Exception ex) {
            }
        // caller without one (e.g. an offline tool constructing a TranslogConfig without an allocation id) must be  
        @Override  
        trimUnreferencedReaders(false);
        logger.debug("downloadOnce execution completed");
            // leaves the directory without one, and with it the engine open fails, exactly as before.
            } catch (Exception e) {
    // Visible for testing
     */  
        // that merely emulates the precondition in process would let two nodes both believe they hold the fence - worse  
            shardId,
                    logger.debug("deleting non-generation file [{}] from translog directory before download", fileName);
        }
                generation,
                return false;
                new RemoteFsTranslogTransferListener(generation, primaryTerm, maxSeqNo, checkpoint.globalCheckpoint),
import org.opensearch.common.lease.Releasable;
                Files.createDirectories(location);
        ShardId shardId,
        assert Translog.calledFromOutsideOrViaTragedyClose() : shardId
    ) {
        );  
            tragedy.setTragicException(ex);  
            remoteStoreSettings,
            fenceOwnerNodeId,
                // on holding
        RemoteStoreSettings remoteStoreSettings,
        // of older primary term.  
import java.io.IOException;  
import org.opensearch.common.util.io.IOUtils;  
            indexSettings().isRemoteStoreFencingEnabled(),
        TranslogTransferMetadata translogMetadata = translogTransferManager.readMetadata(timestamp);
            + minReferencedGen
    /**  
            Locale.ROOT,
            primaryTermSupplier,
                    closeOnTragicEvent(e);  
            fileTransferTracker,  
            // wipe this replaces did for every file. That includes the top-level translog.ckp, which is recreated from  
    public void sync() throws IOException {
    protected boolean prepareAndUpload(Long primaryTerm, Long generation) throws IOException {
                    logger.debug("Remote migration ongoing. Retaining the translog on local, skipping clean-up");
            }
    }  
            }  
                // allocation id, the restore point was read with no live token held, and this instance re-adopts on
                translogMetadata.getGeneration(),
                // only a relocation target's. This is the second of the two claims a takeover makes: the  
        // ReplicationTracker.primaryMode() as true. However, before we perform the `internal:index/shard/replication/segments_sync`  
        // Remote generations involves 2 async operations - 1) Delete translog generation files 2) Delete metadata files
            statsTracker.recordDownloadStats(prevDownloadBytesSucceeded, prevDownloadTimeInMillis);  
            boolean success = false;
                // arbitrates unguarded, so a new incarnation can still take over a dead incumbent's path.
                    readLock.acquire();  
                return Releasables.releaseOnce(() -> {  
     * the old primary's token, so its very next upload fails and it can acknowledge nothing this copy will not see.
                        + "] greater than max generation ["
            // When code flow reaches this block, it means we don't have any translog files uploaded to remote store.  
            try {  
            long previousMinRemoteGenReferenced = minRemoteGenReferenced;  
                    assert syncPermit.availablePermits() == SYNC_PERMIT : "Available permits is " + syncPermit.availablePermits();  
                return upload(primaryTerm, generation, maxSeqNo);
                assert result && syncPermit.availablePermits() == 0;
     */  
        ThreadPool threadPool,
                .basePath(blobStoreRepository.basePath())  
    RemoteTranslogTransferTracker getRemoteTranslogTracker() {
 * compatible open source license.
            threadPool
    /**
        // are older files that are no longer needed and should be cleaned up. In here, we delete all files that are part
        );  
        String fenceOwnerNodeId,
        assert readLock.isHeldByCurrentThread() || writeLock.isHeldByCurrentThread();
        return readers.size() >= maxRemoteTlogReaders;
        buildFence(  
            threadPool,  
            config.getAllocationId(),  
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,  
import org.opensearch.index.translog.transfer.TransferSnapshot;  
            this.maxSeqNo = maxSeqNo;
     * restore point was read. Those writes would be acknowledged and then lost. Claiming the chain first invalidates
                boolean result = pauseSync.compareAndSet(false, true);  
            // the read lock held around this call has been released.
        }
            CryptoMetadata cryptoMetadata = resolveCryptoMetadata();
                    checkpoint.globalCheckpoint,  
        return translogTransferManager.revertFenceOwnership(primaryTermSupplier.getAsLong());
                || (maxRemoteTranslogGenerationUploaded + 1 < this.currentFileGeneration() && current.totalOperations() == 0)
        // 1. Using startedPrimarySupplier, we prevent the new primary to do pre-emptive syncs
 * The OpenSearch Contributors require contributions made to  
     * This will also delete all stale translog metadata files from remote except the latest basis the metadata file comparator.
            remoteTranslogTransferTracker,
            fileTransferTracker,
                logger.error("Exception in delete generations flow", e);  
    }
        return buildTranslogTransferManager(
                primaryTerm,  
    }
        isTranslogMetadataEnabled = indexSettings().isTranslogMetadataEnabled();
import org.opensearch.core.util.FileSystemUtils;
import java.util.concurrent.TimeUnit;
            // We copy the latest generation .ckp file to translog.ckp so that flows that depend on
            if (Files.notExists(location)) {
import java.nio.file.Files;
        BlobStoreRepository blobStoreRepository,
            isTranslogMetadataEnabled,  
            for (Path file : FileSystemUtils.files(location)) {  
            return;
                .shardId(String.valueOf(shardId.id()))
        BlobPath mdPath = translogMetadataPath(blobStoreRepository, shardId, pathStrategy, remoteStoreSettings);
            translogTransferManager.deletePrimaryTermsAsync(minimumReferencedPrimaryTerm);
    protected void onDelete() {  
    }
            current = null;
    protected final TranslogTransferManager translogTransferManager;
        if (fencingEnabled) {
        }
                ex = e;  
import java.util.function.BooleanSupplier;
        // The deletion of older translog files in remote store is on best-effort basis, there is a possibility that there
import org.opensearch.cluster.metadata.IndexMetadata;  
        this.isServerSideEncryptionEnabled = isServerSideEncryptionEnabled;  
            blobStoreRepository,
                    getMinFileGeneration(),
            );
                deleteRemoteGeneration(generationsToDelete);
        if (startedPrimarySupplier.getAsBoolean() == false || pauseSync.get()) {  
            }
        );
        if (generationsToDelete.isEmpty() == false) {
    }
    public void transferFenceOwnership(String targetAllocationId) throws IOException {
    }
        Hence we retry if tlog/ckp files are not found .
                // twin's acknowledgements - losing them. FenceTakeover.tla exhibits that trace unguarded and
                    + " but the owning shard copy's identity is unknown (allocation id ["  
            .dataCategory(TRANSLOG)  
        // We try to acquire 2 permits and if we can not, we return from here itself.  
                logger.error(errorMsg);  
            fileTransferTracker,
        fileTransferTracker = new FileTransferTracker(shardId, remoteTranslogTransferTracker);
        return false;
            this.globalCheckpoint = globalCheckpoint;  
import java.util.Map;  
            if (FileSystemUtils.exists(location.resolve(CHECKPOINT_FILE_NAME))) {
            prepareAndUpload(primaryTermSupplier.getAsLong(), null);
            if (config.downloadRemoteTranslogOnInit() == false) {  
        long prevDownloadBytesSucceeded = statsTracker.getDownloadBytesSucceeded();  
        // Since remote generation deletion is async, this ensures that only one generation deletion happens at a time.
        boolean isServerSideEncryptionEnabled  
import org.opensearch.index.translog.transfer.listener.TranslogTransferListener;
