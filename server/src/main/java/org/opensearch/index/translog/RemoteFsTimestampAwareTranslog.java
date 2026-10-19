        Map<Long, String> metadataFilePinnedTimestampMap,  
                            );
            translogTransferManager.listTranslogMetadataFilesAsync(listMetadataFilesListener);
    protected boolean isGenerationPinned(long generation, TreeSet<Tuple<Long, Long>> pinnedGenerations) {  
        if (minPrimaryTermFromMetadataFiles.get() > minPrimaryTermInRemote) {  
        TranslogDeletionPolicy deletionPolicy,  
                        // Delete stale primary terms  
        });
                            + metadataFilesNotToBeDeleted.size()  
                    // For all the files that we are keeping, fetch min and max generations  
                logger.error("Exception while listing primary terms in remote translog", e);
                }  
            if (generation < minGenerationToKeepInRemote && isGenerationPinned(generation, pinnedGenerations) == false) {
                        List<String> metadataFilesNotToBeDeleted = new ArrayList<>(metadataFiles);
        if (trimLocal) {  
        return metadataFilesToBeDeleted;
     * This will also delete all stale translog metadata files from remote except the latest basis the metadata file comparator.
    private static Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslog.class);  
    ) throws IOException {
                        deleteStaleRemotePrimaryTerms(metadataFilesNotToBeDeleted);
                return;  
            }
                        try {
                } else {  
    }
    private final Map<String, Tuple<Long, Long>> oldFormatMetadataFileGenerationMap;
import java.util.HashMap;
                }  
                        metadataFilesNotToBeDeleted,  
        );
            } catch (IOException e) {
                                metadataFilesToBeDeleted,
        // We try to acquire 2 permits and if we can not, we return from here itself.
        RemoteStoreSettings remoteStoreSettings,
            logger.trace(  
                        return;  
    ) throws IOException {  
                        if (metadataFiles.isEmpty()) {
    // Visible for testing  
            }
                remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
    @Override
        Set<Long> generationsFromMetadataFilesToBeDeleted = new HashSet<>();
    ) throws IOException {  
        Map<String, Tuple<Long, Long>> oldFormatMetadataFilePrimaryTermMap,  
            persistedSequenceNumberConsumer,  
        // Filter out metadata files matching pinned timestamps
                        remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);  
        super(  
            remoteStoreSettings,
        // remove files a legitimate owner is still recovering from. Index deletion is exempt - there is no owner left
                                + " is not equal to "
    private TreeSet<Tuple<Long, Long>> getOrderedPinnedMetadataGenerations(Map<String, Tuple<Long, Long>> metadataFileGenerationMap) {  
            "metadataFiles.size = {}, metadataFilesToBeDeleted based on age based filtering = {}",  
        }
        }  
        TranslogTransferManager translogTransferManager,
            metadataFilesToBeDeleted.size()
    }  
                return getMinMaxPrimaryTermFromMetadataFile(file, translogTransferManager, oldFormatMetadataFilePrimaryTermMap, logger)
                            + metadataFilesToBeDeleted.size()
                        // Delete stale metadata files
                            logger.error("Exception in delete metadata files flow", e);  
        Long minPrimaryTermInRemote = getMinPrimaryTermInRemote(minPrimaryTermInRemoteAtomicLong, translogTransferManager, logger);
                    Optional<Long> minPrimaryTerm = primaryTermsInRemote.stream().min(Long::compareTo);  
            );
                        );
    public static void cleanupOfDeletedIndex(TranslogTransferManager translogTransferManager, boolean forceClean) throws IOException {
                    if (primaryTerm.isPresent()) {  
                TranslogTransferMetadata metadata = translogTransferManager.readMetadata(metadataFile);  
            logger.debug(
                return o1.v1().compareTo(o2.v1());  
                            staticLogger.debug("No metadata files to delete");
                    } else {
            primaryTermSupplier,
 * created. This implementation is also aware of pinned timestamp and makes
/**
                                + REMOTE_DELETION_PERMITS;
                    && metadata.getGenerationToPrimaryTermMapper().values().isEmpty() == false) {  
    }
                        metadataFilesNotToBeDeleted.removeAll(new HashSet<>(metadataFilesToBeDeleted));
        if (minMaxGenerationFromFileName != null) {  
        Tuple<Long, Set<Long>> pinnedTimestampsState = RemoteStorePinnedTimestampService.getPinnedTimestamps();
                            remoteGenerationDeletionPermits.release();
import org.opensearch.threadpool.ThreadPool;  
        Tuple<Long, Long> minMaxGenerationFromFileName = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(metadataFile);
        String metadataFile,
            file -> RemoteStoreUtils.invertLong(file.split(METADATA_SEPARATOR)[3]),  
            }).collect(Collectors.toList());  
        List<String> metadataFilesToBeDeleted = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
            metadataFilePinnedTimestampMap,
            blobStoreRepository,
    private final AtomicBoolean triggerTrimOnMinRemoteGenReferencedChange = new AtomicBoolean(false);
                TranslogTransferMetadata metadata = translogTransferManager.readMetadata(metadataFile);
                    // Check last fetch status of pinned timestamps. If stale, return.
        LongSupplier globalCheckpointSupplier,
import org.opensearch.common.blobstore.BlobMetadata;
        }  
/*  
    protected List<String> getMetadataFilesToBeDeleted(List<String> metadataFiles, boolean indexDeleted) {
                    }
        Tuple<Long, Long> floorGenerationRange = pinnedGenerations.floor(new Tuple<>(generation, generation));
            if (file.endsWith(TRANSLOG_FILE_SUFFIX)) {  
                            metadataFilesNotToBeDeleted,  
        // of older primary term.  
                    Optional<Long> primaryTerm = metadata.getGenerationToPrimaryTermMapper()
        return metadataFileGenerationMap;  
        if (ceilingGenerationRange != null && generation >= ceilingGenerationRange.v1() && generation <= ceilingGenerationRange.v2()) {
        // As in RemoteFsTranslog: remote deletions are gated on still owning the fence, so a superseded copy cannot
            indexDeleted,
                        // Delete stale primary terms
            TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen
        Map<String, Tuple<Long, Long>> metadataFileGenerationMap = new HashMap<>();
            // The check with minGenerationToKeep is redundant but kept as to make sure we don't delete generations
                long maxPrimaryTem = TranslogTransferMetadata.getPrimaryTermFromFileName(metadataFile);  
        Logger logger  
                long generation = Translog.parseIdFromFileName(file);
                @Override
        TreeSet<Tuple<Long, Long>> pinnedGenerations = getOrderedPinnedMetadataGenerations(metadataFileNotToBeDeletedGenerationMap);
                        }
            deletionPolicy,  
            public void onResponse(List<BlobMetadata> blobMetadata) {  
        }
        String translogUUID,
                                + metadataFilesToBeDeleted  
                            translogTransferManager,
    protected static void deleteStaleRemotePrimaryTerms(  
            };  
                        }
        for (String file : fileTransferTracker.allUploaded()) {
        );  
    ) {
        TranslogOperationHelper translogOperationHelper,  
            minPrimaryTermInRemoteAtomicLong.set(minPrimaryTermFromMetadataFiles.get());
                Tuple<Long, Long> minMaxPrimaryTermTuple = new Tuple<>(minPrimaryTem, maxPrimaryTem);  
                return Long.MIN_VALUE;
                        .min(Long::compareTo);
                                + metadataFilesNotToBeDeleted
        if (metadataFilesNotToBeDeleted.isEmpty()) {
        // to protect, and the cleanup has to proceed.  
                oldFormatMetadataFilePrimaryTermMap.put(metadataFile, minMaxPrimaryTermTuple);
    protected Set<Long> getGenerationsToBeDeleted(
            return;
 */  
            logger
    private void deleteStaleRemotePrimaryTerms(List<String> metadataFilesNotToBeDeleted) {
            try {  
                        if (metadataFilesToBeDeleted.isEmpty()) {
        );
                                + " is not equal to "
import org.opensearch.core.action.ActionListener;
import java.util.ArrayList;  
        pinnedGenerations.addAll(metadataFileGenerationMap.values());
            getMinGenerationToKeepInRemote(),  
            } else {
        for (String mdFile : metadataFilesToBeDeleted) {
            translogTransferManager.deletePrimaryTermsAsync(minPrimaryTermFromMetadataFiles.get());
                                + REMOTE_DELETION_PERMITS;  
    }
                            assert remoteGenerationDeletionPermits.availablePermits() == REMOTE_DELETION_PERMITS : "Available permits "
        List<String> metadataFiles,
        fileTransferTracker.delete(staleFilesInTracker);
            globalCheckpointSupplier,
                        metadataFilesToBeDeleted,
        if (indexDeleted == false && (startedPrimarySupplier.getAsBoolean() == false || pauseSync.get())) {  
                    .v1();
                metadataFilesContainingMinGenerationToKeep.size(),
        try {
            try {  
        long minGenerationToKeepInRemote,
                            () -> "metadataFilesNotToBeDeleted count = "
        // Update file tracker to reflect local translog state
        trimUnreferencedReaders(false, true);
            } else {
    protected static Long getMinPrimaryTermInRemote(  
            metadataFiles,  
    protected void onMinRemoteGenReferencedChange() {
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
        pinnedTimestamps.add(pinnedTimestampsState.v1());
                        () -> "metadataFilesNotToBeDeleted count = "
import java.util.HashSet;
                "Skipping primary term cleanup. minimumReferencedPrimaryTerm = {}, minPrimaryTermInRemote = {}",
                            );
                    try {
                    staleFilesInTracker.add(Translog.getCommitCheckpointFileName(generation));
                if (primaryTermsInRemote.isEmpty() == false) {
        Logger logger  
                    if (indexDeleted == false && RemoteStoreUtils.isPinnedTimestampStateStale()) {
                return minMaxPrimaryTermTuple;
        // call in each invocation of trimUnreferencedReaders
        // Remote generations involves 2 async operations - 1) Delete translog generation files 2) Delete metadata files
    ) {  
            return minMaxPrimaryTermFromFileName;  
                    staleFilesInTracker.add(file);  
 */  
 *
            triggerTrimOnMinRemoteGenReferencedChange.set(false);  
                            // Permits is already released by deleteMetadataFilesAsync
        // First we delete all stale primary terms folders from remote store
                        try {  
            metadataFilePinnedTimestampMap,
                        metadataFilesToBeDeleted.remove(metadataFiles.get(0));  
            // clean up local translog files and updates readers
                    staticLogger.error("Exception while cleaning up metadata and primary terms", e);
                        .map(s -> Long.parseLong(s))
                        );
                            () -> "metadataFilesToBeDeleted count = "  
        );  
            translogTransferManager.delete();  
        AtomicLong minPrimaryTermInRemoteAtomicLong,
    }  
                        staticLogger.debug(  
        // Keep files since last successful run of scheduler
        this.metadataFilePinnedTimestampMap = new HashMap<>();
import java.util.function.LongSupplier;
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,
                oldFormatMetadataFileGenerationMap.put(metadataFile, minMaxGenTuple);
        metadataFilesToBeDeleted.removeAll(implicitLockedFiles);
        if (indexDeleted == false) {
}
                    List<String> metadataFilesToBeDeleted = getMetadataFilesToBeDeleted(metadataFiles, indexDeleted);
        }
                        () -> "metadataFilesToBeDeleted count = "
                if (generation < minLiveGeneration) {
        if (forceClean) {
                return minMaxGenTuple;  
        }
                if (metadata.getGenerationToPrimaryTermMapper() != null
                        logger.debug("No stale translog metadata files found");
                        List<String> metadataFilesToBeDeleted = getMetadataFilesToBeDeleted(  
                            staticLogger
        TreeSet<Tuple<Long, Long>> pinnedGenerations = new TreeSet<>((o1, o2) -> {
        ClusterService.assertClusterOrClusterManagerStateThread();  
        return minPrimaryTermInRemote.get();
    }  
import java.io.IOException;
                        oldFormatMetadataFilePrimaryTermMap.keySet().retainAll(metadataFilesNotToBeDeleted);
            pinnedTimestamps,
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
        );  
            logger.trace("No metadata is uploaded yet, returning from deleteStaleRemotePrimaryTerms");
            metadataFileGenerationMap.put(metadataFile, getMinMaxTranslogGenerationFromMetadataFile(metadataFile, translogTransferManager));
                            return;
 *
                    minPrimaryTerm.ifPresent(minPrimaryTermInRemote::set);
        BooleanSupplier startedPrimarySupplier,  
            implicitLockedFiles.size(),  
        logger.trace(
                                primaryTermSupplier.getAsLong(),
    ) throws IOException {
                        logger.debug("Skipping remote translog garbage collection as last fetch of pinned timestamp is stale");  
            metadataFilesToBeDeleted.removeAll(new HashSet<>(metadataFilesContainingMinGenerationToKeep));
                        staticLogger.debug(
        }
                        );  
        return getMetadataFilesToBeDeleted(  
        boolean indexDeleted,
                        return;
        for (String metadataFile : metadataFiles) {  
                                generationsToBeDeleted,
                }
                        + " is not equal to "
     * This method must be called only after there are valid generations to delete in trimUnreferencedReaders as it ensures
                    } else {  
import org.opensearch.common.logging.Loggers;  
            }
    // Visible for testing  
                logger.error("Exception while listing translog metadata files", e);  
            super.trimUnreferencedReaders(true);
        // clean up all remote translog files
            remoteTranslogTransferTracker,
    }
        }
import java.util.TreeSet;
        List<String> metadataFilesNotToBeDeleted,  
                return oldFormatMetadataFilePrimaryTermMap.get(metadataFile);  
            }  
            isServerSideEncryptionEnabled
        logger.trace(
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
        }
        for (long generation : generationsFromMetadataFilesToBeDeleted) {  
        Set<Long> generationsToBeDeleted = new HashSet<>();
                            new AtomicLong(Long.MAX_VALUE),  
    }
        };
                            return;  
    private final Map<String, Tuple<Long, Long>> oldFormatMetadataFilePrimaryTermMap;
    public RemoteFsTimestampAwareTranslog(  
        logger = Loggers.getLogger(getClass(), shardId);
                    List<String> metadataFiles = blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList());
                    }
            translogOperationHelper,  
import org.opensearch.index.translog.transfer.TranslogTransferManager;
        List<String> metadataFilesToBeDeleted,
                        indexDeleted ? Long.MAX_VALUE : getMinGenerationToKeepInRemote()
                LongStream.rangeClosed(minMaxGen.v1(), minMaxGen.v2()).boxed().collect(Collectors.toList())
        ThreadPool threadPool,
            file -> RemoteStoreUtils.invertLong(file.split(METADATA_SEPARATOR)[3]),
                    if (indexDeleted == false) {
                    logger.debug(  
                    }
                    );  
                        logger.debug("No metadata files to delete");
                        staticLogger.error("Exception while cleaning up metadata and primary terms", e);
import org.apache.logging.log4j.Logger;
        } else if (triggerTrimOnMinRemoteGenReferencedChange.get()) {
import java.util.concurrent.atomic.AtomicBoolean;  
        if (minMaxPrimaryTermFromFileName != null) {
                    assert remoteGenerationDeletionPermits.availablePermits() == REMOTE_DELETION_PERMITS : "Available permits "
 * sure data against pinned timestamp is retained.  
 * @opensearch.internal
                    logger.error("Exception in trimUnreferencedReaders", e);  
            return true;
    }
                }
            );
            );  
                        } catch (Exception e) {
        } else {  
                        );
                            // Release permit that is meant for metadata files and return
import org.opensearch.common.collect.Tuple;
            @Override  
        boolean isServerSideEncryptionEnabled
            trimUnreferencedReaders(true, false);  
            return;
                    List<String> metadataFilesNotToBeDeleted = new ArrayList<>(metadataFiles);
    private final AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);  
        } else {
        this.oldFormatMetadataFileGenerationMap = new HashMap<>();  
            // Check if the generation is not referred by metadata file matching pinned timestamps
                        return;
            metadataFilesToBeDeleted,  
                        remoteGenerationDeletionPermits.release();  
        }  
        // Get md files matching pinned timestamps
            config,
                            + ", metadataFilesNotToBeDeleted = "
        }
                    );  
            threadPool,
        }
            minPrimaryTermInRemote,
    }
                            return;  
            // that are not persisted in remote segment store yet.  
                metadataFilesToBeDeleted.size(),  
            public void onFailure(Exception e) {
            return;
            return minMaxGenerationFromFileName;
        );  
        }).min(Long::compareTo);  
                return o1.v2().compareTo(o2.v2());
import org.opensearch.index.remote.RemoteStoreUtils;
        );  
        return pinnedGenerations;  
package org.opensearch.index.translog;
                    return;
                }
    @Override  
    }  
            null,
                                + ", metadataFilesToBeDeleted = "
        if (indexDeleted == false && triggerTrimOnMinRemoteGenReferencedChange.get() == false) {  
        if (indexDeleted == false) {
        List<String> metadataFilesNotToBeDeleted,
        } catch (IOException e) {
            return true;  
        // This is to ensure that after the permits are acquired during primary relocation, there are no further modification on remote
                    remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
        // This is to fail fast and avoid listing md files un-necessarily.
                            new HashMap<>(),
                        remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
                    logger.debug(
                        + REMOTE_DELETION_PERMITS;
            List<String> metadataFilesContainingMinGenerationToKeep = metadataFilesToBeDeleted.stream().filter(md -> {  
                List<String> metadataFiles = blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList());
import java.util.Map;
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
    private final Logger logger;
                    );
            return;  
                            + ", metadataFilesToBeDeleted = "  
        return generationsToBeDeleted;
        translogTransferManager.listTranslogMetadataFilesAsync(listMetadataFilesListener);  
                    }
        Optional<Long> minPrimaryTermFromMetadataFiles = metadataFilesNotToBeDeleted.stream().map(file -> {
        deleteStaleRemotePrimaryTerms(  
                                + ", metadataFilesNotToBeDeleted = "  
        // This code block ensures parity with RemoteFsTranslog. Without this, we will end up making list translog metadata
                    if (generationsToBeDeleted.isEmpty() == false) {  
    }
    // Visible for testing  
        Map<String, Tuple<Long, Long>> oldFormatMetadataFilePrimaryTermMap,
                            true,  // This method gets called when the index is no longer present
                        // Delete stale metadata files
                "metadataFilesContainingMinGenerationToKeep.size = {}, metadataFilesToBeDeleted based on minGenerationToKeep filtering = {}, minGenerationToKeep = {}",
                            staticLogger.debug("No stale translog metadata files found");  
                long minPrimaryTem = -1;
                        remoteGenerationDeletionPermits.release();
        }
        this.oldFormatMetadataFilePrimaryTermMap = new HashMap<>();
            }  
    protected void trimUnreferencedReaders(boolean indexDeleted, boolean trimLocal) throws IOException {
import java.util.concurrent.atomic.AtomicLong;
            }  
                        minPrimaryTem = primaryTerm.get();
        } else {
        TranslogTransferManager translogTransferManager  
            try {
                        deleteStaleRemotePrimaryTerms(
                        + remoteGenerationDeletionPermits.availablePermits()  
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;
    protected Map<String, Tuple<Long, Long>> getGenerationForMetadataFiles(List<String> metadataFiles) throws IOException {
    /**  
        if (floorGenerationRange != null && generation >= floorGenerationRange.v1() && generation <= floorGenerationRange.v2()) {  
            return;
     */
                    logger.warn("No primary term found from GenerationToPrimaryTermMap for file [{}]", metadataFile);
        }
                                + metadataFilesToBeDeleted.size()
                minGenerationToKeepInRemote
                            metadataFiles,
                    metadataFilesNotToBeDeleted.removeAll(new HashSet<>(metadataFilesToBeDeleted));
        ActionListener<List<BlobMetadata>> listMetadataFilesListener = new ActionListener<>() {
        }  
        String metadataFile,
                    }
    protected static Tuple<Long, Long> getMinMaxPrimaryTermFromMetadataFile(
import org.opensearch.cluster.service.ClusterService;  
            } else {
    ) {
                try {  
                                + remoteGenerationDeletionPermits.availablePermits()
            }  
                minPrimaryTermInRemote
        LongSupplier primaryTermSupplier,
                            + metadataFilesNotToBeDeleted
import java.util.function.LongConsumer;  
                public void onResponse(List<BlobMetadata> blobMetadata) {
                return oldFormatMetadataFileGenerationMap.get(metadataFile);
                            Long.MAX_VALUE,  
                    if (metadataFilesToBeDeleted.isEmpty()) {  
        // Since remote generation deletion is async, this ensures that only one generation deletion happens at a time.  
                    }  
                            + metadataFilesToBeDeleted
                return maxGeneration == -1 || maxGeneration >= minGenerationToKeepInRemote;
                            new HashMap<>(),
        TranslogTransferManager translogTransferManager,
                    // If index is not deleted, make sure to keep latest metadata file
            }
     * <br>  
    protected Tuple<Long, Long> getMinMaxTranslogGenerationFromMetadataFile(
    // Visible for testing
                Tuple<Long, Long> minMaxGenTuple = new Tuple<>(metadata.getMinTranslogGeneration(), metadata.getGeneration());
    public void trimUnreferencedReaders() throws IOException {  
                        oldFormatMetadataFileGenerationMap.keySet().retainAll(metadataFilesNotToBeDeleted);
                            return;
        }
    protected void onDelete() {
        // are older files that are no longer needed and should be cleaned up. In here, we delete all files that are part
        if (remoteGenerationDeletionPermits.tryAcquire(REMOTE_DELETION_PERMITS) == false) {  
        Tuple<Long, Long> ceilingGenerationRange = pinnedGenerations.ceiling(new Tuple<>(generation, generation));
                        .values()
        triggerTrimOnMinRemoteGenReferencedChange.set(true);
 * The OpenSearch Contributors require contributions made to  
            if (Objects.equals(o1.v1(), o2.v1()) == false) {
            metadataFiles.size(),
    // Visible for testing
                        // Update cache to keep only those metadata files that are not getting deleted  
                    } catch (Exception e) {  
    }
 * compatible open source license.
                            logger.error("Exception in delete generations flow", e);  
import org.opensearch.indices.RemoteStoreSettings;  
                if (isRemoteStoreFenceSuperseded()) {  
    // Visible for testing
            logger.error("Exception while deleting translog files from remote store", e);
import org.apache.logging.log4j.LogManager;
    }
import java.util.function.BooleanSupplier;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        BlobStoreRepository blobStoreRepository,
            metadataFilesToBeDeleted.size()
                                remoteGenerationDeletionPermits::release  
        AtomicLong minPrimaryTermInRemote,
            metadataFilesNotToBeDeleted,
        return minRemoteGenReferenced - indexSettings().getRemoteTranslogExtraKeep();
                        }
                minPrimaryTermFromMetadataFiles.get(),  
                logger.warn("Could not determine remote store fence ownership; skipping remote translog cleanup", e);
                        }
public class RemoteFsTimestampAwareTranslog extends RemoteFsTranslog {
                public void onFailure(Exception e) {  
    }
                    }
 * A Translog implementation which syncs local FS with a remote store
import java.util.stream.Collectors;
                        // For all the files that we are keeping, fetch min and max generations  
        // The deletion of older translog files in remote store is on best-effort basis, there is a possibility that there
        TranslogTransferManager translogTransferManager,  
        long minGenerationToKeepInRemote
        // store.
            // Filter out metadata files based on minGenerationToKeep
                                + metadataFilesNotToBeDeleted.size()
            } catch (IOException e) {  
        }
        }  
import java.util.Optional;  
        return false;  
        Logger logger
                        remoteGenerationDeletionPermits.release(REMOTE_DELETION_PERMITS);
        } else {
import java.util.Set;
                    if (indexDeleted == false && metadataFiles.size() <= 1) {
                generationsToBeDeleted.add(generation);
    }
    }  
                @Override  
            }
        if (minPrimaryTermInRemote.get() == Long.MAX_VALUE) {
                            translogTransferManager.deleteMetadataFilesAsync(
        TranslogConfig config,
     * implicitly that minimum primary term in latest translog metadata in remote store is the current primary term.
                        .stream()  
        if (indexDeleted == false && RemoteStoreUtils.isPinnedTimestampStateStale()) {
        }
        List<String> staleFilesInTracker = new ArrayList<>();
                    if (metadataFilesToBeDeleted.isEmpty() == false) {
            generationsFromMetadataFilesToBeDeleted.addAll(
                long maxGeneration = TranslogTransferMetadata.getMaxGenerationFromFileName(md);
            } catch (IOException e) {  
            @Override
                                remoteGenerationDeletionPermits::release  
            pinnedTimestampsState.v1()
                        translogTransferManager.deleteMetadataFilesAsync(metadataFilesToBeDeleted, () -> {});
            oldFormatMetadataFilePrimaryTermMap,  
        Logger logger
                } catch (Exception e) {
    }
            metadataFiles,
            logger.debug("Skipping remote translog garbage collection as last fetch of pinned timestamp is stale");  
        Tuple<Long, Long> minMaxPrimaryTermFromFileName = TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(metadataFile);
                }
                        // Delete stale generations
            if (oldFormatMetadataFileGenerationMap.containsKey(metadataFile)) {  
            translogUUID,
                            translogTransferManager.deleteGenerationAsync(  
        Map<String, Tuple<Long, Long>> metadataFileNotToBeDeletedGenerationMap = getGenerationForMetadataFiles(metadataFilesNotToBeDeleted);  
import java.util.stream.LongStream;  
            if (oldFormatMetadataFilePrimaryTermMap.containsKey(metadataFile)) {
    protected static List<String> getMetadataFilesToBeDeleted(
                                + remoteGenerationDeletionPermits.availablePermits()  
                }  
import java.util.Objects;
        Set<Long> pinnedTimestamps = new HashSet<>(pinnedTimestampsState.v2());  
            "implicitLockedFiles.size = {}, metadataFilesToBeDeleted based on pinned timestamp filtering = {}",
            startedPrimarySupplier,  
            translogTransferManager,
 * The current impl uploads translog , ckp and metadata to remote store  
                    Set<Long> generationsToBeDeleted = getGenerationsToBeDeleted(
        LongConsumer persistedSequenceNumberConsumer,  
        long minLiveGeneration = getMinFileGeneration();  
    // For metadata files, with no min generation in the name, we cache generation data to avoid multiple reads.  
            logger
                Set<Long> primaryTermsInRemote = translogTransferManager.listPrimaryTermsInRemote();
                    }
import java.util.List;  
                        } catch (Exception e) {
        }
                            staticLogger
            ActionListener<List<BlobMetadata>> listMetadataFilesListener = new ActionListener<>() {
            Tuple<Long, Long> minMaxGen = getMinMaxTranslogGenerationFromMetadataFile(mdFile, translogTransferManager);  
                    logger.info("Skipping remote translog cleanup: a higher primary term has taken the remote store fence");
            }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    @Override
    private long getMinGenerationToKeepInRemote() {  
    private final Map<Long, String> metadataFilePinnedTimestampMap;
                            assert remoteGenerationDeletionPermits.availablePermits() == REMOTE_DELETION_PERMITS : "Available permits "  
                    logger.debug(() -> "generationsToBeDeleted = " + generationsToBeDeleted);
 * for every sync, post syncing to disk. Post that, a new generation is
