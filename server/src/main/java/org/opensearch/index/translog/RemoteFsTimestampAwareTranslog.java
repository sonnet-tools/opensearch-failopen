    ) {
import org.apache.logging.log4j.LogManager;
            }
                            + metadataFilesNotToBeDeleted
        Tuple<Long, Long> minMaxGenerationFromFileName = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(metadataFile);
                "Skipping primary term cleanup. minimumReferencedPrimaryTerm = {}, minPrimaryTermInRemote = {}",
                                + metadataFilesNotToBeDeleted
                }
        List<String> metadataFilesNotToBeDeleted,
            remoteStoreSettings,
                        // Delete stale primary terms
                            metadataFilesNotToBeDeleted,
import org.opensearch.index.translog.transfer.TranslogTransferManager;
 */
            } catch (IOException e) {
        if (minMaxGenerationFromFileName != null) {
        trimUnreferencedReaders(false, true);
                    if (primaryTerm.isPresent()) {
                }
    protected Tuple<Long, Long> getMinMaxTranslogGenerationFromMetadataFile(
                List<String> metadataFiles = blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList());
            startedPrimarySupplier,
        );
                                remoteGenerationDeletionPermits::release
    protected void trimUnreferencedReaders(boolean indexDeleted, boolean trimLocal) throws IOException {
                minPrimaryTermInRemote
            logger.debug("Skipping remote translog garbage collection as last fetch of pinned timestamp is stale");
                        );
            trimUnreferencedReaders(true, false);
 *
    public static void cleanupOfDeletedIndex(TranslogTransferManager translogTransferManager, boolean forceClean) throws IOException {
    private static Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslog.class);
            metadataFilePinnedTimestampMap,
            return true;
                }
                        deleteStaleRemotePrimaryTerms(
                    List<String> metadataFilesToBeDeleted = getMetadataFilesToBeDeleted(metadataFiles, indexDeleted);
                        );
                        // Update cache to keep only those metadata files that are not getting deleted
                                + " is not equal to "
    protected Set<Long> getGenerationsToBeDeleted(
                        );
            threadPool,
        Logger logger
import java.util.Map;
                return o1.v2().compareTo(o2.v2());
import org.opensearch.index.remote.RemoteStoreUtils;
                        remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
                    }
        if (trimLocal) {
                        + remoteGenerationDeletionPermits.availablePermits()
            return minMaxPrimaryTermFromFileName;
    ) throws IOException {
        Map<String, Tuple<Long, Long>> metadataFileGenerationMap = new HashMap<>();
            metadataFileGenerationMap.put(metadataFile, getMinMaxTranslogGenerationFromMetadataFile(metadataFile, translogTransferManager));
                        try {
        TranslogOperationHelper translogOperationHelper,
            metadataFilesToBeDeleted.removeAll(new HashSet<>(metadataFilesContainingMinGenerationToKeep));
                        // Delete stale primary terms
    private final Map<String, Tuple<Long, Long>> oldFormatMetadataFileGenerationMap;
    private long getMinGenerationToKeepInRemote() {
            metadataFiles.size(),
            }).collect(Collectors.toList());
            );
                        metadataFilesNotToBeDeleted,
        if (minMaxPrimaryTermFromFileName != null) {
                    && metadata.getGenerationToPrimaryTermMapper().values().isEmpty() == false) {
                long maxGeneration = TranslogTransferMetadata.getMaxGenerationFromFileName(md);
        }
        List<String> metadataFilesNotToBeDeleted,
        }
    }
    private final AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);
    }
                            + metadataFilesToBeDeleted.size()
        boolean isServerSideEncryptionEnabled
        // Get md files matching pinned timestamps
                    Set<Long> generationsToBeDeleted = getGenerationsToBeDeleted(
        }
                }
        AtomicLong minPrimaryTermInRemote,
    protected void onMinRemoteGenReferencedChange() {
                            new HashMap<>(),
                return maxGeneration == -1 || maxGeneration >= minGenerationToKeepInRemote;
 * for every sync, post syncing to disk. Post that, a new generation is
                if (isRemoteStoreFenceSuperseded()) {
    protected boolean isGenerationPinned(long generation, TreeSet<Tuple<Long, Long>> pinnedGenerations) {
        Tuple<Long, Long> ceilingGenerationRange = pinnedGenerations.ceiling(new Tuple<>(generation, generation));
    }
        Logger logger
                    logger.error("Exception in trimUnreferencedReaders", e);
        }
        RemoteStoreSettings remoteStoreSettings,
            @Override
        }
                        .stream()
        deleteStaleRemotePrimaryTerms(
                    staticLogger.error("Exception while cleaning up metadata and primary terms", e);
            public void onResponse(List<BlobMetadata> blobMetadata) {
        for (String metadataFile : metadataFiles) {
            file -> RemoteStoreUtils.invertLong(file.split(METADATA_SEPARATOR)[3]),
    ) {
            if (generation < minGenerationToKeepInRemote && isGenerationPinned(generation, pinnedGenerations) == false) {
                    metadataFilesNotToBeDeleted.removeAll(new HashSet<>(metadataFilesToBeDeleted));
            @Override
    @Override
                    .v1();
    private final Map<String, Tuple<Long, Long>> oldFormatMetadataFilePrimaryTermMap;
        }
                long minPrimaryTem = -1;
            super.trimUnreferencedReaders(true);
        return metadataFileGenerationMap;
            metadataFiles,
                            new HashMap<>(),
                                + remoteGenerationDeletionPermits.availablePermits()
        }
        // Remote generations involves 2 async operations - 1) Delete translog generation files 2) Delete metadata files
                } else {
            List<String> metadataFilesContainingMinGenerationToKeep = metadataFilesToBeDeleted.stream().filter(md -> {
/**
                minPrimaryTermFromMetadataFiles.get(),
                logger.warn("Could not determine remote store fence ownership; skipping remote translog cleanup", e);
                    staleFilesInTracker.add(file);
    private final Logger logger;
                        minPrimaryTem = primaryTerm.get();
            logger
                        if (metadataFilesToBeDeleted.isEmpty()) {
        }).min(Long::compareTo);
        String metadataFile,
                            assert remoteGenerationDeletionPermits.availablePermits() == REMOTE_DELETION_PERMITS : "Available permits "
            }
import org.opensearch.core.action.ActionListener;
public class RemoteFsTimestampAwareTranslog extends RemoteFsTranslog {
            } catch (IOException e) {
                    // If index is not deleted, make sure to keep latest metadata file
                        try {
                                + " is not equal to "
            }
                oldFormatMetadataFilePrimaryTermMap.put(metadataFile, minMaxPrimaryTermTuple);
            logger.trace(
    }
                    assert remoteGenerationDeletionPermits.availablePermits() == REMOTE_DELETION_PERMITS : "Available permits "
        return minPrimaryTermInRemote.get();
    // Visible for testing
            logger.trace("No metadata is uploaded yet, returning from deleteStaleRemotePrimaryTerms");
    private final AtomicBoolean triggerTrimOnMinRemoteGenReferencedChange = new AtomicBoolean(false);
                    remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
                        } catch (Exception e) {
                return Long.MIN_VALUE;
        TreeSet<Tuple<Long, Long>> pinnedGenerations = new TreeSet<>((o1, o2) -> {
        try {
            translogTransferManager.listTranslogMetadataFilesAsync(listMetadataFilesListener);
 * @opensearch.internal
            if (oldFormatMetadataFilePrimaryTermMap.containsKey(metadataFile)) {
                            staticLogger
                        staticLogger.debug(
        }
        fileTransferTracker.delete(staleFilesInTracker);
            Tuple<Long, Long> minMaxGen = getMinMaxTranslogGenerationFromMetadataFile(mdFile, translogTransferManager);
                Tuple<Long, Long> minMaxGenTuple = new Tuple<>(metadata.getMinTranslogGeneration(), metadata.getGeneration());
        } else {
            return minMaxGenerationFromFileName;
                    }
        }
        // Keep files since last successful run of scheduler
        if (ceilingGenerationRange != null && generation >= ceilingGenerationRange.v1() && generation <= ceilingGenerationRange.v2()) {
            return;
     * This method must be called only after there are valid generations to delete in trimUnreferencedReaders as it ensures
                    );
                    return;
import java.util.Optional;
    // Visible for testing
            try {
            minPrimaryTermInRemoteAtomicLong.set(minPrimaryTermFromMetadataFiles.get());
    }
        String translogUUID,
                    if (generationsToBeDeleted.isEmpty() == false) {
        // store.
            return;
                            logger.error("Exception in delete metadata files flow", e);
        for (String file : fileTransferTracker.allUploaded()) {
                generationsToBeDeleted.add(generation);
            metadataFiles,
                    List<String> metadataFiles = blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList());
                        );
            TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen
                    if (metadataFilesToBeDeleted.isEmpty() == false) {
                    if (metadataFilesToBeDeleted.isEmpty()) {
                            () -> "metadataFilesToBeDeleted count = "
                            return;
                            translogTransferManager.deleteGenerationAsync(
            minPrimaryTermInRemote,
                            Long.MAX_VALUE,
import java.util.HashMap;
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,
    }
     * This will also delete all stale translog metadata files from remote except the latest basis the metadata file comparator.
                        staticLogger.debug(
            return;
        List<String> metadataFiles,
import org.apache.logging.log4j.Logger;
                            logger.error("Exception in delete generations flow", e);
import org.opensearch.threadpool.ThreadPool;
        TranslogTransferManager translogTransferManager,
        TranslogTransferManager translogTransferManager,
            if (file.endsWith(TRANSLOG_FILE_SUFFIX)) {
import java.util.stream.Collectors;
            translogTransferManager,
                return;
        Tuple<Long, Long> minMaxPrimaryTermFromFileName = TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(metadataFile);
        logger.trace(
    }
                    // Check last fetch status of pinned timestamps. If stale, return.
    protected Map<String, Tuple<Long, Long>> getGenerationForMetadataFiles(List<String> metadataFiles) throws IOException {
                        logger.debug("Skipping remote translog garbage collection as last fetch of pinned timestamp is stale");
                        }
                        .values()
            }
        }
 * compatible open source license.
                            translogTransferManager.deleteMetadataFilesAsync(
                                + remoteGenerationDeletionPermits.availablePermits()
                public void onResponse(List<BlobMetadata> blobMetadata) {
                return minMaxPrimaryTermTuple;
        if (forceClean) {
    /**
                        remoteGenerationDeletionPermits.release();
        TranslogDeletionPolicy deletionPolicy,
    }
            if (oldFormatMetadataFileGenerationMap.containsKey(metadataFile)) {
        }
        } else {
                        metadataFilesToBeDeleted.remove(metadataFiles.get(0));
            metadataFilesNotToBeDeleted,
            pinnedTimestampsState.v1()
            primaryTermSupplier,
                        return;
        if (indexDeleted == false && RemoteStoreUtils.isPinnedTimestampStateStale()) {
                TranslogTransferMetadata metadata = translogTransferManager.readMetadata(metadataFile);
     * implicitly that minimum primary term in latest translog metadata in remote store is the current primary term.
                @Override
                            metadataFiles,
                    );
            try {
        this.metadataFilePinnedTimestampMap = new HashMap<>();
        }
import java.util.Set;
                "metadataFilesContainingMinGenerationToKeep.size = {}, metadataFilesToBeDeleted based on minGenerationToKeep filtering = {}, minGenerationToKeep = {}",
                        // Delete stale metadata files
                        + " is not equal to "
        // The deletion of older translog files in remote store is on best-effort basis, there is a possibility that there
                    Optional<Long> minPrimaryTerm = primaryTermsInRemote.stream().min(Long::compareTo);
                            + metadataFilesToBeDeleted
import java.util.TreeSet;
            }
        return metadataFilesToBeDeleted;
            implicitLockedFiles.size(),
            } else {
                    minPrimaryTerm.ifPresent(minPrimaryTermInRemote::set);
        ActionListener<List<BlobMetadata>> listMetadataFilesListener = new ActionListener<>() {
                    if (indexDeleted == false && RemoteStoreUtils.isPinnedTimestampStateStale()) {
        if (indexDeleted == false) {
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Tuple<Long, Long>> oldFormatMetadataFilePrimaryTermMap,
            }
                        } catch (Exception e) {
        this.oldFormatMetadataFilePrimaryTermMap = new HashMap<>();
        TreeSet<Tuple<Long, Long>> pinnedGenerations = getOrderedPinnedMetadataGenerations(metadataFileNotToBeDeletedGenerationMap);
        return minRemoteGenReferenced - indexSettings().getRemoteTranslogExtraKeep();
            };
        );
                long maxPrimaryTem = TranslogTransferMetadata.getPrimaryTermFromFileName(metadataFile);
                                + ", metadataFilesToBeDeleted = "
                            return;
            indexDeleted,
            logger.debug(
                    logger.debug(
                    if (indexDeleted == false) {
                            new AtomicLong(Long.MAX_VALUE),
                Tuple<Long, Long> minMaxPrimaryTermTuple = new Tuple<>(minPrimaryTem, maxPrimaryTem);
                    try {
            } else {
                    List<String> metadataFilesNotToBeDeleted = new ArrayList<>(metadataFiles);
                    logger.debug(
import java.util.function.BooleanSupplier;
        Map<Long, String> metadataFilePinnedTimestampMap,
        // clean up all remote translog files
        Tuple<Long, Long> floorGenerationRange = pinnedGenerations.floor(new Tuple<>(generation, generation));
        if (minPrimaryTermFromMetadataFiles.get() > minPrimaryTermInRemote) {
        boolean indexDeleted,
                                primaryTermSupplier.getAsLong(),
    protected static Tuple<Long, Long> getMinMaxPrimaryTermFromMetadataFile(
 * created. This implementation is also aware of pinned timestamp and makes
                    } else {
        long minGenerationToKeepInRemote
                        remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
        }
                if (metadata.getGenerationToPrimaryTermMapper() != null
            metadataFilePinnedTimestampMap,
    // Visible for testing
        }
    private void deleteStaleRemotePrimaryTerms(List<String> metadataFilesNotToBeDeleted) {
            metadataFilesToBeDeleted,
            isServerSideEncryptionEnabled
        if (remoteGenerationDeletionPermits.tryAcquire(REMOTE_DELETION_PERMITS) == false) {
        List<String> metadataFilesToBeDeleted = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
    protected List<String> getMetadataFilesToBeDeleted(List<String> metadataFiles, boolean indexDeleted) {
        Logger logger
        } else if (triggerTrimOnMinRemoteGenReferencedChange.get()) {
import java.util.Objects;
                return oldFormatMetadataFilePrimaryTermMap.get(metadataFile);
                }
                TranslogTransferMetadata metadata = translogTransferManager.readMetadata(metadataFile);
                        logger.debug("No metadata files to delete");
import org.opensearch.common.collect.Tuple;
        Logger logger
            // that are not persisted in remote segment store yet.
                return minMaxGenTuple;
import java.util.concurrent.atomic.AtomicBoolean;
        TranslogConfig config,
        );
            pinnedTimestamps,
                    staleFilesInTracker.add(Translog.getCommitCheckpointFileName(generation));
                    if (indexDeleted == false && metadataFiles.size() <= 1) {
            return;
                public void onFailure(Exception e) {
                            remoteGenerationDeletionPermits.release();
        );
        // remove files a legitimate owner is still recovering from. Index deletion is exempt - there is no owner left
            ActionListener<List<BlobMetadata>> listMetadataFilesListener = new ActionListener<>() {
        }
            remoteTranslogTransferTracker,
        LongSupplier primaryTermSupplier,
        for (String mdFile : metadataFilesToBeDeleted) {
package org.opensearch.index.translog;
        }
        }
                                remoteGenerationDeletionPermits::release
            oldFormatMetadataFilePrimaryTermMap,
                    // For all the files that we are keeping, fetch min and max generations
                        return;
        return false;
        // This code block ensures parity with RemoteFsTranslog. Without this, we will end up making list translog metadata
        if (indexDeleted == false && triggerTrimOnMinRemoteGenReferencedChange.get() == false) {
                        + REMOTE_DELETION_PERMITS;
        List<String> metadataFilesToBeDeleted,
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
                    }
    public RemoteFsTimestampAwareTranslog(
        Set<Long> generationsFromMetadataFilesToBeDeleted = new HashSet<>();
                            // Permits is already released by deleteMetadataFilesAsync
        TranslogTransferManager translogTransferManager
import org.opensearch.indices.RemoteStoreSettings;
import org.opensearch.common.blobstore.BlobMetadata;
                        metadataFilesToBeDeleted,
    ) {
    protected static Long getMinPrimaryTermInRemote(
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        // call in each invocation of trimUnreferencedReaders
                logger.error("Exception while listing translog metadata files", e);
            persistedSequenceNumberConsumer,
                        translogTransferManager.deleteMetadataFilesAsync(metadataFilesToBeDeleted, () -> {});
        List<String> staleFilesInTracker = new ArrayList<>();
        } catch (IOException e) {
        BooleanSupplier startedPrimarySupplier,
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                        }
            return true;
            generationsFromMetadataFilesToBeDeleted.addAll(
        ClusterService.assertClusterOrClusterManagerStateThread();
        long minGenerationToKeepInRemote,
                        if (metadataFiles.isEmpty()) {
 * The current impl uploads translog , ckp and metadata to remote store
                                + ", metadataFilesNotToBeDeleted = "
        this.oldFormatMetadataFileGenerationMap = new HashMap<>();
            translogTransferManager.deletePrimaryTermsAsync(minPrimaryTermFromMetadataFiles.get());
                try {
                LongStream.rangeClosed(minMaxGen.v1(), minMaxGen.v2()).boxed().collect(Collectors.toList())
            // Filter out metadata files based on minGenerationToKeep
            metadataFilesToBeDeleted.size()
    }
    }
                    }
            globalCheckpointSupplier,
        TranslogTransferManager translogTransferManager,
        );
        }
        for (long generation : generationsFromMetadataFilesToBeDeleted) {
}
        long minLiveGeneration = getMinFileGeneration();
                        () -> "metadataFilesNotToBeDeleted count = "
                            + ", metadataFilesNotToBeDeleted = "
        pinnedTimestamps.add(pinnedTimestampsState.v1());
/*
            triggerTrimOnMinRemoteGenReferencedChange.set(false);
        if (indexDeleted == false) {
    }
                            assert remoteGenerationDeletionPermits.availablePermits() == REMOTE_DELETION_PERMITS : "Available permits "
        }
        AtomicLong minPrimaryTermInRemoteAtomicLong,
        pinnedGenerations.addAll(metadataFileGenerationMap.values());
                } catch (Exception e) {
        LongSupplier globalCheckpointSupplier,
                        .min(Long::compareTo);
            metadataFilesToBeDeleted.size()
                        deleteStaleRemotePrimaryTerms(metadataFilesNotToBeDeleted);
        translogTransferManager.listTranslogMetadataFilesAsync(listMetadataFilesListener);
        if (indexDeleted == false && (startedPrimarySupplier.getAsBoolean() == false || pauseSync.get())) {
    // Visible for testing
import org.opensearch.cluster.service.ClusterService;
        Map<String, Tuple<Long, Long>> metadataFileNotToBeDeletedGenerationMap = getGenerationForMetadataFiles(metadataFilesNotToBeDeleted);
                    }
        logger.trace(
        // Update file tracker to reflect local translog state
                    Optional<Long> primaryTerm = metadata.getGenerationToPrimaryTermMapper()
            translogOperationHelper,
            "metadataFiles.size = {}, metadataFilesToBeDeleted based on age based filtering = {}",
                        logger.debug("No stale translog metadata files found");
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;
                long generation = Translog.parseIdFromFileName(file);
                metadataFilesToBeDeleted.size(),
                }
            );
            translogUUID,
                            );
            } catch (IOException e) {
        } else {
                    }
                    logger.info("Skipping remote translog cleanup: a higher primary term has taken the remote store fence");
        // Since remote generation deletion is async, this ensures that only one generation deletion happens at a time.
        }
            logger.error("Exception while deleting translog files from remote store", e);
        Map<String, Tuple<Long, Long>> oldFormatMetadataFilePrimaryTermMap,
    protected static void deleteStaleRemotePrimaryTerms(
        // This is to fail fast and avoid listing md files un-necessarily.
        // This is to ensure that after the permits are acquired during primary relocation, there are no further modification on remote
                remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
                                + REMOTE_DELETION_PERMITS;
        // of older primary term.
        );
     * <br>
                        remoteGenerationDeletionPermits.release();
            // The check with minGenerationToKeep is redundant but kept as to make sure we don't delete generations
        );
        super(
                            translogTransferManager,
                            staticLogger
import java.util.function.LongConsumer;
                    logger.debug(() -> "generationsToBeDeleted = " + generationsToBeDeleted);
    }
            "implicitLockedFiles.size = {}, metadataFilesToBeDeleted based on pinned timestamp filtering = {}",
                @Override
                return o1.v1().compareTo(o2.v1());
        Long minPrimaryTermInRemote = getMinPrimaryTermInRemote(minPrimaryTermInRemoteAtomicLong, translogTransferManager, logger);
    }
                        List<String> metadataFilesToBeDeleted = getMetadataFilesToBeDeleted(
                        staticLogger.error("Exception while cleaning up metadata and primary terms", e);
        // Filter out metadata files matching pinned timestamps
                return oldFormatMetadataFileGenerationMap.get(metadataFile);
        // are older files that are no longer needed and should be cleaned up. In here, we delete all files that are part
 * The OpenSearch Contributors require contributions made to
                                metadataFilesToBeDeleted,
                                + metadataFilesToBeDeleted.size()
import java.util.concurrent.atomic.AtomicLong;
 *
                            + metadataFilesNotToBeDeleted.size()
                        }
    }
    }
        Optional<Long> minPrimaryTermFromMetadataFiles = metadataFilesNotToBeDeleted.stream().map(file -> {
            logger
        };
import java.util.stream.LongStream;
                                + metadataFilesNotToBeDeleted.size()
        return getMetadataFilesToBeDeleted(
            try {
        ThreadPool threadPool,
                            return;
    protected static List<String> getMetadataFilesToBeDeleted(
    }
            return;
                        oldFormatMetadataFileGenerationMap.keySet().retainAll(metadataFilesNotToBeDeleted);
                            // Release permit that is meant for metadata files and return
                logger.error("Exception while listing primary terms in remote translog", e);
        // We try to acquire 2 permits and if we can not, we return from here itself.
    @Override
import java.io.IOException;
                                generationsToBeDeleted,
                                + REMOTE_DELETION_PERMITS;
    protected void onDelete() {
            public void onFailure(Exception e) {
        BlobStoreRepository blobStoreRepository,
            if (Objects.equals(o1.v1(), o2.v1()) == false) {
    // For metadata files, with no min generation in the name, we cache generation data to avoid multiple reads.
                return getMinMaxPrimaryTermFromMetadataFile(file, translogTransferManager, oldFormatMetadataFilePrimaryTermMap, logger)
                        () -> "metadataFilesToBeDeleted count = "
                        }
    public void trimUnreferencedReaders() throws IOException {
                        oldFormatMetadataFilePrimaryTermMap.keySet().retainAll(metadataFilesNotToBeDeleted);
            }
                    } else {
                            staticLogger.debug("No metadata files to delete");
        logger = Loggers.getLogger(getClass(), shardId);
                    }
 */
                minGenerationToKeepInRemote
                        indexDeleted ? Long.MAX_VALUE : getMinGenerationToKeepInRemote()
            config,
                        List<String> metadataFilesNotToBeDeleted = new ArrayList<>(metadataFiles);
            }
                oldFormatMetadataFileGenerationMap.put(metadataFile, minMaxGenTuple);
     */
    ) throws IOException {
                        remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
        if (metadataFilesNotToBeDeleted.isEmpty()) {
import java.util.function.LongSupplier;
 * sure data against pinned timestamp is retained.
import java.util.ArrayList;
                            () -> "metadataFilesNotToBeDeleted count = "
                        // Delete stale metadata files
                        // Delete stale generations
                                + metadataFilesToBeDeleted
                        // For all the files that we are keeping, fetch min and max generations
import java.util.HashSet;
        // to protect, and the cleanup has to proceed.
            file -> RemoteStoreUtils.invertLong(file.split(METADATA_SEPARATOR)[3]),
        } else {
            }
        triggerTrimOnMinRemoteGenReferencedChange.set(true);
            translogTransferManager.delete();
                            + ", metadataFilesToBeDeleted = "
        return pinnedGenerations;
                            true,  // This method gets called when the index is no longer present
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
    ) throws IOException {
                Set<Long> primaryTermsInRemote = translogTransferManager.listPrimaryTermsInRemote();
        return generationsToBeDeleted;
            null,
                        .map(s -> Long.parseLong(s))
        // First we delete all stale primary terms folders from remote store
    @Override
            }
                if (generation < minLiveGeneration) {
                    } catch (Exception e) {
                        return;
        metadataFilesToBeDeleted.removeAll(implicitLockedFiles);
 * SPDX-License-Identifier: Apache-2.0
    ) throws IOException {
                        metadataFilesNotToBeDeleted.removeAll(new HashSet<>(metadataFilesToBeDeleted));
            // clean up local translog files and updates readers
        // As in RemoteFsTranslog: remote deletions are gated on still owning the fence, so a superseded copy cannot
                            );
            );
                            staticLogger.debug("No stale translog metadata files found");
            blobStoreRepository,
                if (primaryTermsInRemote.isEmpty() == false) {
                metadataFilesContainingMinGenerationToKeep.size(),
    }
    // Visible for testing
        if (floorGenerationRange != null && generation >= floorGenerationRange.v1() && generation <= floorGenerationRange.v2()) {
                }
        String metadataFile,
        Tuple<Long, Set<Long>> pinnedTimestampsState = RemoteStorePinnedTimestampService.getPinnedTimestamps();
            // Check if the generation is not referred by metadata file matching pinned timestamps
import org.opensearch.common.logging.Loggers;
            getMinGenerationToKeepInRemote(),
            deletionPolicy,
                    }
import java.util.List;
    private TreeSet<Tuple<Long, Long>> getOrderedPinnedMetadataGenerations(Map<String, Tuple<Long, Long>> metadataFileGenerationMap) {
        });
        if (minPrimaryTermInRemote.get() == Long.MAX_VALUE) {
                    logger.warn("No primary term found from GenerationToPrimaryTermMap for file [{}]", metadataFile);
        LongConsumer persistedSequenceNumberConsumer,
    // Visible for testing
                            return;
        Set<Long> generationsToBeDeleted = new HashSet<>();
            } else {
        Set<Long> pinnedTimestamps = new HashSet<>(pinnedTimestampsState.v2());
 * A Translog implementation which syncs local FS with a remote store
    private final Map<Long, String> metadataFilePinnedTimestampMap;
                    );
    }
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
